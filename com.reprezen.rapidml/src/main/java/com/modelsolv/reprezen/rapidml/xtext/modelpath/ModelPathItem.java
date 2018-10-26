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
import static com.modelsolv.reprezen.rapidml.xtext.modelpath.DebugModelPath.Option.MATCHING;

import java.net.URI;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.modelsolv.reprezen.rapidml.xtext.modelpath.ModelPathBindings.Value;
import com.modelsolv.reprezen.rapidml.xtext.modelpath.ModelPathPattern.Delimiter;

public class ModelPathItem {
    private ModelPathPattern modelPattern;
    private ModelPathPattern pathPattern;
    private String urlTemplate;
    private String name;

    public ModelPathItem(String modelPatString, String pathPatdString, String urlTemplate) {
        this.modelPattern = getPattern(modelPatString, Delimiter.DOT);
        this.pathPattern = getPattern(pathPatdString, Delimiter.SLASH);
        this.urlTemplate = adjustUrlTemplate(urlTemplate);
    }

    public ModelPathItem(String itemString) {
        String[] parts = parseItem(itemString.trim());
        this.modelPattern = getPattern(parts[0], Delimiter.DOT);
        this.pathPattern = getPattern(parts[1], Delimiter.SLASH);
        this.urlTemplate = adjustUrlTemplate(parts[2]);
        this.name = parts[3];
    }

    public ModelPathItem() {
    }

    private ModelPathPattern getPattern(String pattern, Delimiter delimiter) {
        return pattern != null ? new ModelPathPattern(pattern, delimiter) : null;
    }

    private String adjustUrlTemplate(String urlTemplate) {
        return urlTemplate.equals(".") ? null : urlTemplate;
    }

    private static String optPat(String p) {
        return "(" + p + ")?";
    }

    private static String namedPat(String p, String name) {
        return "(?<" + name + ">" + p + ")";
    }

    private static String modelPatPat = namedPat("[^,\\s\\]]+", "modelPat");
    private static String pathPatPat = namedPat("[^\\s\\]]+", "pathPat");
    private static String urlPat = namedPat("\\S+", "url");
    private static String namePat = namedPat("\\w+", "name");
    private static String ws = "\\s*";

    private static Pattern itemPat = Pattern.compile("^" + ws + optPat(namePat + ws + "=") + ws
            + optPat("\\[" + ws + optPat(modelPatPat) + ws + optPat("," + ws + optPat(pathPatPat)) + ws + "\\]") + ws
            + urlPat + ws + "$");

    private static String[] parseItem(String itemString) {
        Matcher m = itemPat.matcher(itemString);
        if (m.matches()) {
            return new String[] { m.group("modelPat"), m.group("pathPat"), m.group("url"), m.group("name") };
        } else {
            throw new IllegalArgumentException("Invalid model path item: " + itemString);
        }
    }

    public String getModelPattern() {
        return Objects.toString(modelPattern, null);
    }

    public void setModelPattern(ModelPathPattern modelPattern) {
        this.modelPattern = modelPattern;
    }

    public String getPathPattern() {
        return Objects.toString(pathPattern, null);
    }

    public void setPathPattern(ModelPathPattern pathPattern) {
        this.pathPattern = pathPattern;
    }

    public String getUriTemplate() {
        return urlTemplate;
    }

    public void setUrlTemplate(String urlTemplate) {
        this.urlTemplate = urlTemplate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isContainerUrlItem() {
        return urlTemplate == null;
    }

    public Stream<ModelPathBindings> getMatches(String fqModelName, URI importUri) {
        if (importUri == null && (pathPattern != null || isContainerUrlItem())) {
            return Stream.empty();
        }
        List<ModelPathBindings> modelMatches = getMatches(modelPattern, fqModelName, Delimiter.DOT);
        List<ModelPathBindings> pathMatches = getMatches(pathPattern, importUri != null ? importUri.getPath() : null,
                Delimiter.SLASH);
        if (modelMatches == null && pathMatches == null) {
            return Stream.of(new ModelPathBindings());
        }
        if (modelMatches != null && modelMatches.isEmpty()) {
            return Stream.empty();
        }
        if (pathMatches != null && pathMatches.isEmpty()) {
            return Stream.empty();
        }
        BindingsPruner pruner = new BindingsPruner(urlTemplate);
        UniqueFilter<ModelPathBindings> uniqueFilter = new UniqueFilter<>();
        return combineMatches(modelMatches, pathMatches) //
                .map(b -> pruner.prune(b)) //
                .filter(b -> uniqueFilter.accept(b));
    }

    private Stream<ModelPathBindings> combineMatches(List<ModelPathBindings> b1List, List<ModelPathBindings> b2List) {
        if (b1List == null && b2List == null) {
            return Stream.empty();
        } else if (b1List == null) {
            return b2List.stream();
        } else if (b2List == null) {
            return b1List.stream();
        } else {
            Stream.Builder<ModelPathBindings> builder = Stream.builder();
            for (ModelPathBindings b1 : b1List) {
                for (ModelPathBindings b2 : b2List) {
                    ModelPathBindings combined = new ModelPathBindings(b1, b2);
                    debug(MATCHING, ":Combined Bindings: " + combined, "Model Pattern Bindings:", b1,
                            "Path Pattern Bindings:", b2);
                    builder.accept(combined);
                }
            }
            return builder.build();
        }
    }

    private List<ModelPathBindings> getMatches(ModelPathPattern pattern, String s, Delimiter delim) {
        return pattern != null ? pattern.getMatches(s, delim) : null;
    }

    private static class BindingsPruner {
        private String template;
        private Set<Integer> usedPositions;
        private Set<String> usedNames;

        public BindingsPruner(String template) {
            this.template = template;
            usedPositions = getUsedPositions(template);
            usedNames = getUsedNames(template);
        }

        public ModelPathBindings prune(ModelPathBindings bindings) {
            ModelPathBindings result = new ModelPathBindings(bindings);
            List<Value> values = result.getValues();
            List<String> erasedNames = Lists.newArrayList();
            for (String name : result.getNamedValuePositions().keySet()) {
                if (!usedNames.contains(name)) {
                    erasedNames.add(name);
                }
            }
            for (String erasedName : erasedNames) {
                result.erase(erasedName);
            }
            Set<Integer> usedPositionsViaNames = Sets.newHashSet(bindings.getNamedValuePositions().values());
            boolean removing = true; // remove from values list until we've left something, then replace with null
            for (int i = values.size() - 1; i >= 0; i--) {
                if (usedPositions.contains(i) || usedPositionsViaNames.contains(i)) {
                    removing = false;
                } else if (removing) {
                    result.remove(i);
                } else {
                    result.erase(i);
                }
            }
            if (!bindings.equals(result)) {
                debug(MATCHING, ":Bindings pruned of unused variables: " + result.toString(), "Original bindings=",
                        bindings, "Template=", template);
            }
            return result;
        }

        private Set<Integer> getUsedPositions(String template) {
            Set<Integer> result = Sets.newHashSet();
            if (template != null) {
                Matcher m = ModelPathBindings.POS_VAR_REF_PATTERN.matcher(template);
                while (m.find()) {
                    String pos = m.group("pos");
                    pos = pos != null ? pos : m.group("bpos");
                    result.add(Integer.parseInt(pos) - 1);
                }
            }
            return result;
        }

        private Set<String> getUsedNames(String template) {
            Set<String> result = Sets.newHashSet();
            if (template != null) {
                Matcher m = ModelPathBindings.NAMED_VAR_REF_PATTERN.matcher(template);
                while (m.find()) {
                    String name = m.group("name");
                    name = name != null ? name : m.group("bname");
                    result.add(name);
                }
            }
            return result;
        }
    }

    private static class UniqueFilter<T> {
        Set<T> seenItems = Sets.newHashSet();

        public boolean accept(T item) {
            boolean alreadySeen = seenItems.contains(item);
            if (!alreadySeen) {
                seenItems.add(item);
            } else {
                debug(MATCHING, ":Suppressing duplicate bindings: " + item);
            }
            return !alreadySeen;
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((modelPattern == null) ? 0 : modelPattern.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((pathPattern == null) ? 0 : pathPattern.hashCode());
        result = prime * result + ((urlTemplate == null) ? 0 : urlTemplate.hashCode());
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
        ModelPathItem other = (ModelPathItem) obj;
        if (modelPattern == null) {
            if (other.modelPattern != null)
                return false;
        } else if (!modelPattern.equals(other.modelPattern))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (pathPattern == null) {
            if (other.pathPattern != null)
                return false;
        } else if (!pathPattern.equals(other.pathPattern))
            return false;
        if (urlTemplate == null) {
            if (other.urlTemplate != null)
                return false;
        } else if (!urlTemplate.equals(other.urlTemplate))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return String.format("%s=[%s, %s] %s", name, modelPattern, pathPattern,
                urlTemplate != null ? urlTemplate : ".");
    }

}