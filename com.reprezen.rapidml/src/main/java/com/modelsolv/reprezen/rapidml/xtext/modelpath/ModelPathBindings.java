/*******************************************************************************
 * Copyright © 2013, 2018 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.modelsolv.reprezen.rapidml.xtext.modelpath;

import static com.modelsolv.reprezen.rapidml.xtext.modelpath.DebugModelPath.debug;
import static com.modelsolv.reprezen.rapidml.xtext.modelpath.DebugModelPath.Option.INTERPOLATION;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.modelsolv.reprezen.rapidml.xtext.modelpath.ModelPathPattern.Delimiter;

public class ModelPathBindings {

    public static Pattern POS_VAR_REF_PATTERN = Pattern
            .compile("\\$((?<pos>\\d+)|\\{(?<bpos>\\d+)(:(?<posOpts>[./]*))?\\})");
    private static String NAMED_VAR_PATTERN_STRING = "\\p{L}[\\p{L}\\d_]*";
    public static Pattern WILDCARD_PATTERN = Pattern
            .compile("((?<name>(" + NAMED_VAR_PATTERN_STRING + ")):)?(?<wild>\\*\\*?)(:(?<opts>[gns]*))?");
    public static Pattern NAMED_VAR_REF_PATTERN = Pattern.compile("(\\$((?<name>" + NAMED_VAR_PATTERN_STRING
            + ")|\\{(?<bname>" + NAMED_VAR_PATTERN_STRING + ")(:(?<nameOpts>[./rn]*))?\\}))");

    private List<Value> values = Lists.newArrayList();
    private Map<String, Integer> namedValuePositions = Maps.newHashMap();

    public ModelPathBindings() {
    }

    public ModelPathBindings(ModelPathBindings... bindingses) {
        for (ModelPathBindings bindings : bindingses) {
            this.merge(bindings);
        }
    }

    public void add(List<String> value, Delimiter delimiter, MatchType matchType) {
        add(value, null, delimiter, matchType, null);
    }

    public void add(List<String> value, String name, Delimiter delimiter, MatchType matchType) {
        add(value, name, delimiter, matchType, null);
    }

    public void add(List<String> value, String name, Delimiter delimiter, MatchType matchType, String options) {
        if (options == null) {
            options = "";
        }
        if (options.contains(".")) {
            delimiter = Delimiter.DOT;
        } else if (options.contains("/")) {
            delimiter = Delimiter.SLASH;
        }
        add(new Value(value, name, delimiter, matchType, options));
    }

    public void add(Value value) {
        String name = value.getName();
        if (name != null) {
            checkNameCollision(name);
            namedValuePositions.put(name, values.size());
        }
        values.add(value);
    }

    public void remove(int i) {
        values.remove(i);
    }

    public void remove(List<String> value) {
        int lastPos = values.size() - 1;
        assert values.get(lastPos).getSegments().equals(value);
        values.remove(lastPos);
    }

    public void remove(List<String> value, String name) {
        remove(value);
        if (name != null) {
            assert namedValuePositions.containsKey(name);
            assert namedValuePositions.get(name) == values.size();
            namedValuePositions.remove(name);
        }
    }

    public void erase(int i) {
        values.set(i, null);
    }

    public void erase(String name) {
        values.get(namedValuePositions.get(name)).name = null;
        namedValuePositions.remove(name);
    }

    public int size() {
        return values.size();
    }

    public void merge(ModelPathBindings other) {
        int offset = values.size();
        for (int i = 0; i < other.size(); i++) {
            Value value = new Value(other.values.get(i));
            if (value.getName() != null) {
                checkNameCollision(value.getName());
                namedValuePositions.put(value.getName(), offset + i);
            }
            values.add(value);
        }
    }

    private void checkNameCollision(String name) {
        if (namedValuePositions.containsKey(name)) {
            throw new IllegalArgumentException("Name for wildcard already used in model model path item");
        }
    }

    private static Pattern interpPat = Pattern
            .compile(POS_VAR_REF_PATTERN + "|" + NAMED_VAR_REF_PATTERN + "|" + "\\$\\$");

    public String interpolate(String s) {
        // note that in the following we can't use Matcher#appendReplacement because we need to do delimiter fixups
        // after empty replacements.
        Matcher m = interpPat.matcher(s);
        StringBuffer sb = new StringBuffer();
        int appendPoint = 0;
        while (m.find()) {
            sb.append(s.substring(appendPoint, m.start()));
            appendPoint = m.end();
            Delimiter delim = null;
            String options = null;

            String var = m.group("pos");
            var = var != null ? var : m.group("bpos");
            if (var != null) {
                options = m.group("posOpts");
                delim = getDelimiter(var, options);
            } else {
                var = var != null ? var : m.group("name");
                var = var != null ? var : m.group("bname");
                if (var != null) {
                    options = m.group("nameOpts");
                    delim = getDelimiter(var, options);
                }
            }
            String replacement = var != null ? getValueString(var, options) : "$";
            if (appendReplacement(sb, replacement, s.substring(appendPoint), delim, options)) {
                appendPoint += 1;
            }
        }
        sb.append(s.substring(appendPoint));
        String result = sb.toString();
        debug(INTERPOLATION, ":Interpolation result: " + result, "Template=", s, "Bindings:", this);
        return result;
    }

    private boolean appendReplacement(StringBuffer sb, String replacement, String tail, Delimiter delimiter,
            String options) {
        if (replacement.isEmpty() && delimiter != null && (options == null || !options.contains("n"))) {
            String separator = delimiter.getSeparator();
            boolean followsSep = sb.length() > 0 && sb.substring(sb.length() - 1).equals(separator);
            boolean precedesSep = tail.startsWith(separator);
            return followsSep && precedesSep;
        } else {
            sb.append(replacement);
            return false;
        }
    }

    public String getValueString(String var, String options) {
        Integer pos = var.matches("\\d+") //
                ? (Integer) (Integer.parseInt(var) - 1) // bizarre cast forces overall expr to be Integer not int
                : namedValuePositions.get(var);
        if (pos != null && pos < values.size()) {
            Delimiter delim = getDelimiter(pos, options);
            List<String> segments = values.get(pos).getSegments();
            if (options != null && options.contains("r")) {
                segments = Lists.reverse(segments);
            }
            return String.join(delim.getSeparator(), segments);
        } else {
            return "";
        }
    }

    public List<String> getValue(int pos) {
        return pos < values.size() ? values.get(pos).getSegments() : Collections.emptyList();
    }

    public List<String> getValue(String name) {
        Integer pos = namedValuePositions.get(name);
        return pos != null ? getValue(pos) : Collections.emptyList();
    }

    public Delimiter getDelimiter(int i) {
        return i < values.size() ? values.get(i).getDelimiter() : null;
    }

    private Delimiter getDelimiter(int i, String options) {
        Delimiter delim = optionDelimiter(options);
        return delim != null ? delim : getDelimiter(i);
    }

    public Delimiter getDelimiter(String name) {
        Integer pos = parseIntOrNull(name);
        if (pos != null) {
            pos = pos - 1;
        } else {
            pos = namedValuePositions.get(name);
        }
        return pos != null ? getDelimiter(pos) : null;
    }

    private Delimiter getDelimiter(String name, String options) {
        Delimiter delim = optionDelimiter(options);
        return delim != null ? delim : getDelimiter(name);
    }

    private Integer parseIntOrNull(String i) {
        try {
            return Integer.valueOf(i);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private Delimiter optionDelimiter(String options) {
        if (options != null) {
            if (options.contains(".")) {
                return Delimiter.DOT;
            } else if (options.contains("/")) {
                return Delimiter.SLASH;
            }
        }
        return null;
    }

    public boolean hasName(String name) {
        return namedValuePositions.containsKey(name);
    }

    public List<Value> getValues() {
        return values;
    }

    public Map<String, Integer> getNamedValuePositions() {
        return namedValuePositions;
    }

    public static class Value {
        private List<String> segments;
        private String name;
        private Delimiter delimiter;
        private MatchType matchType;
        private String options;

        public Value(List<String> segments, String name, Delimiter delimiter, MatchType matchType, String options) {
            this.segments = segments;
            this.name = name;
            this.delimiter = delimiter;
            this.matchType = matchType;
            this.options = options;
        }

        public Value(Value other) {
            this(Lists.newArrayList(other.segments), other.name, other.delimiter, other.matchType, other.options);
        }

        public List<String> getSegments() {
            return segments;
        }

        public String getName() {
            return name;
        }

        public Delimiter getDelimiter() {
            return delimiter;
        }

        public MatchType getMatchType() {
            return matchType;
        }

        public String getOptions() {
            return options;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((delimiter == null) ? 0 : delimiter.hashCode());
            result = prime * result + ((matchType == null) ? 0 : matchType.hashCode());
            result = prime * result + ((name == null) ? 0 : name.hashCode());
            result = prime * result + ((options == null) ? 0 : options.hashCode());
            result = prime * result + ((segments == null) ? 0 : segments.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Value other = (Value) obj;
            if (delimiter != other.delimiter)
                return false;
            if (matchType != other.matchType)
                return false;
            if (name == null) {
                if (other.name != null)
                    return false;
            } else if (!name.equals(other.name))
                return false;
            if (options == null) {
                if (other.options != null)
                    return false;
            } else if (!options.equals(other.options))
                return false;
            if (segments == null) {
                if (other.segments != null)
                    return false;
            } else if (!segments.equals(other.segments))
                return false;
            return true;
        }

        @Override
        public String toString() {
            String namePart = name != null ? name + "=" : "";
            String separator = delimiter != null ? delimiter.getSeparator() : "|";
            String segsPart = String.join(separator, segments);
            String tagPart = matchType.getTag();
            String optPart = options.isEmpty() ? "" : ":" + options;
            String tagOptPart = !(tagPart.isEmpty() && optPart.isEmpty()) ? "[" + tagPart + optPart + "]" : "";
            return namePart + segsPart + tagOptPart;
        }

        public static Value fromBindingSpec(String bindingSpec) {
            String name = null;
            int nameEnd = bindingSpec.indexOf("=");
            if (nameEnd >= 0) {
                name = bindingSpec.substring(0, nameEnd);
                bindingSpec = bindingSpec.substring(nameEnd + 1);
            }
            int segsEnd = bindingSpec.indexOf("[");
            if (segsEnd < 0) {
                segsEnd = bindingSpec.length();
            }
            String valsPart = bindingSpec.substring(0, segsEnd);
            Delimiter delim = valsPart.contains(".") ? Delimiter.DOT
                    : valsPart.contains("/") ? Delimiter.SLASH : Delimiter.SLASH;
            bindingSpec = bindingSpec.substring(segsEnd);
            MatchType matchType = valsPart.equals("~") || valsPart.contains(".") || valsPart.contains("/")
                    ? MatchType.MULTI_WILD
                    : MatchType.WILD;
            String options = "";
            if (!bindingSpec.isEmpty()) {
                bindingSpec = bindingSpec.substring(1, bindingSpec.lastIndexOf("]"));
                int colonPos = bindingSpec.indexOf(":");
                if (colonPos <= 0) {
                    colonPos = bindingSpec.length();
                }
                switch (bindingSpec.substring(0, colonPos)) {
                case "*":
                    matchType = MatchType.WILD;
                    break;
                case "**":
                    matchType = MatchType.MULTI_WILD;
                    break;
                default:
                }
                options = colonPos < bindingSpec.length() ? bindingSpec.substring(colonPos + 1) : "";
            }
            List<String> segs = valsPart.equals("~") ? Arrays.asList()
                    : Arrays.asList(valsPart.split(delim != null ? delim.getRegex() : "\\|"));
            return new Value(segs, name, delim, matchType, options);
        }
    }

    public enum MatchType {
        SEGMENT(""), WILD("*"), MULTI_WILD("**");

        private String tag;

        MatchType(String tag) {
            this.tag = tag;
        }

        public String getTag() {
            return tag;
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((namedValuePositions == null) ? 0 : namedValuePositions.hashCode());
        result = prime * result + ((values == null) ? 0 : values.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ModelPathBindings other = (ModelPathBindings) obj;
        if (namedValuePositions == null) {
            if (other.namedValuePositions != null)
                return false;
        } else if (!namedValuePositions.equals(other.namedValuePositions))
            return false;
        if (values == null) {
            if (other.values != null)
                return false;
        } else if (!values.equals(other.values))
            return false;
        return true;
    }

    public String toString() {
        String specs = IntStream.range(0, values.size()) //
                .mapToObj(i -> getBindingSpec(i)) //
                .collect(Collectors.joining(", "));
        return "[" + specs + "]";
    }

    private String getBindingSpec(int i) {
        return String.valueOf(values.get(i));
    }
}
