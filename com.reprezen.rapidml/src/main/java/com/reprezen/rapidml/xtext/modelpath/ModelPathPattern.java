/*******************************************************************************
 * Copyright © 2013, 2018 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.xtext.modelpath;

import static com.reprezen.rapidml.xtext.modelpath.DebugModelPath.debug;
import static com.reprezen.rapidml.xtext.modelpath.DebugModelPath.Option.MATCHING;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;
import com.reprezen.rapidml.xtext.modelpath.ModelPathBindings.MatchType;

public class ModelPathPattern {
	private String pattern;
	private List<String> patternSegments;
	private Delimiter delimiter;

	public ModelPathPattern(String pattern, Delimiter delimiter) {
		this.pattern = pattern;
		this.patternSegments = getSegments(pattern, delimiter);
		this.delimiter = delimiter;
	}

	public List<ModelPathBindings> getMatches(String s, Delimiter delim) {
		if (patternSegments == null) {
			debug(MATCHING, ":Empty pattern does not match '" + s + "'");
			return null;
		}
		List<String> segments = getSegments(s, delim);
		List<ModelPathBindings> matches = new PatternMatcher(patternSegments, segments).matches();
		debug(MATCHING, ":Matching results for pattern '" + pattern + "' with '" + s + "'", matches);
		return matches;
	}

	private List<String> getSegments(String s, Delimiter delim) {
		if (s != null) {
			return Arrays.asList(s.split(delim.regex)).stream() //
					.filter((String part) -> !part.isEmpty()) //
					.collect(Collectors.toList());
		} else {
			return null;
		}
	}

	public String toString() {
		return String.join(delimiter.separator, patternSegments);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((delimiter == null) ? 0 : delimiter.hashCode());
		result = prime * result + ((patternSegments == null) ? 0 : patternSegments.hashCode());
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
		ModelPathPattern other = (ModelPathPattern) obj;
		if (delimiter != other.delimiter)
			return false;
		if (patternSegments == null) {
			if (other.patternSegments != null)
				return false;
		} else if (!patternSegments.equals(other.patternSegments))
			return false;
		return true;
	}

	private class PatternMatcher {
		private List<String> pattern;
		private List<String> specimen;
		private List<ModelPathBindings> matches = null;
		private ModelPathBindings working = new ModelPathBindings();

		public PatternMatcher(List<String> pattern, List<String> specimen) {
			this.pattern = pattern;
			this.specimen = specimen;
		}

		public List<ModelPathBindings> matches() {
			matches = Lists.newArrayList();
			collectMatches(pattern, specimen);
			return matches;
		}

		private boolean collectMatches(List<String> pat, List<String> spec) {
			if (pat.isEmpty()) {
				matches.add(new ModelPathBindings(working));
				return true;
			} else if (spec.isEmpty()) {
				return false;
			} else {
				String patHead = pat.get(0);
				String specHead = spec.get(0);
				if (patHead.equals(specHead)) {
					return collectHeadMatch(pat, spec);
				} else {
					Matcher m = ModelPathBindings.WILDCARD_PATTERN.matcher(patHead);
					if (m.matches()) {
						if (m.group("wild").equals("*")) {
							return collectWild(pat, spec, m.group("name"), specHead, m.group("opts"));
						} else {
							return collectDoubleWild(pat, spec, m.group("name"), m.group("opts"));
						}
					} else {
						return false;
					}
				}
			}
		}

		private boolean collectHeadMatch(List<String> pat, List<String> spec) {
			return descend(pat, spec, 1);
		}

		private boolean collectWild(List<String> pat, List<String> spec, String name, String specHead, String options) {
			working.add(Arrays.asList(specHead), name, delimiter, MatchType.WILD);
			boolean matched = descend(pat, spec, 1);
			working.remove(Arrays.asList(specHead), name);
			return matched;
		}

		private boolean collectDoubleWild(List<String> pat, List<String> spec, String name, String options) {
			if (options == null) {
				options = "";
			}
			int first = options.contains("g") ? spec.size() - 1 : options.contains("n") ? 1 : 0;
			int last = options.contains("g") ? (options.contains("n") ? 0 : -1) : spec.size();
			int incr = options.contains("g") ? -1 : 1;
			boolean matched = false;
			for (int span = first; span != last; span += incr) {
				List<String> sublist = spec.subList(0, span);
				working.add(sublist, name, delimiter, MatchType.MULTI_WILD);
				if (descend(pat, spec, span)) {
					matched = true;
				}
				working.remove(sublist, name);
				if (matched && options.contains("s")) {
					return true;
				}
			}
			return matched;
		}

		private boolean descend(List<String> pat, List<String> spec, int specSkip) {
			return collectMatches(pat.subList(1, pat.size()), spec.subList(specSkip, spec.size()));
		}
	}

	public enum Delimiter {
		DOT("\\.", "."), SLASH("/", "/");

		private String regex;
		private String separator;

		Delimiter(String regex, String separator) {
			this.regex = regex;
			this.separator = separator;
		}

		public static Delimiter of(String delim) {
			for (Delimiter delimiter : Delimiter.values()) {
				if (delim.equals(delimiter.separator)) {
					return delimiter;
				}
			}
			return null;
		}

		public String getRegex() {
			return regex;
		}

		public String getSeparator() {
			return separator;
		}
	}
}
