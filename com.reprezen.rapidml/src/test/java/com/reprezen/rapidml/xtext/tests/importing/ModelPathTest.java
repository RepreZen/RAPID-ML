package com.reprezen.rapidml.xtext.tests.importing;

import static com.reprezen.rapidml.xtext.modelpath.ModelPathBindings.MatchType.WILD;
import static com.reprezen.rapidml.xtext.modelpath.ModelPathPattern.Delimiter.DOT;
import static com.reprezen.rapidml.xtext.modelpath.ModelPathPattern.Delimiter.SLASH;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Test;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.reprezen.rapidml.xtext.modelpath.ModelPath;
import com.reprezen.rapidml.xtext.modelpath.ModelPathBindings;
import com.reprezen.rapidml.xtext.modelpath.ModelPathBindings.Value;
import com.reprezen.rapidml.xtext.modelpath.ModelPathItem;
import com.reprezen.rapidml.xtext.modelpath.ModelPathPattern;
import com.reprezen.rapidml.xtext.modelpath.ModelPathPattern.Delimiter;

public class ModelPathTest {

	@Test
	public void modelPathParserTest() {
		testModelPathParser(".");
		testModelPathParser("[ a.b.c, x/y/z ] http://x/y/z", ".", "[ , ] http://x/y/z/");
	}

	@Test
	public void modelPathItemParserTest() {
		testModelPathItemParser(".", null, null, null);
		testModelPathItemParser("[].", null, null, null);
		testModelPathItemParser("[ , ] .", null, null, null);
		testModelPathItemParser("http://x/y/z", null, null, "http://x/y/z");
		testModelPathItemParser("http://x/y/z/", null, null, "http://x/y/z/");
		testModelPathItemParser("[a.b.c] .", "a.b.c", null, null);
		testModelPathItemParser("[, x/y/z] .", null, "x/y/z", null);
		testModelPathItemParser("[ a.b.c , x/y/z].", "a.b.c", "x/y/z", null);
	}

	@Test
	public void namedModelPathItemParserTest() {
		testModelPathItemParser("name=.", null, null, null, "name");
		testModelPathItemParser("name = [].", null, null, null, "name");
		testModelPathItemParser("foo=[ , ] .", null, null, null, "foo");
		testModelPathItemParser("name=http://x/y/z", null, null, "http://x/y/z", "name");
		testModelPathItemParser("name = http://x/y/z/", null, null, "http://x/y/z/", "name");
		testModelPathItemParser("name= [a.b.c] .", "a.b.c", null, null, "name");
		testModelPathItemParser("name =[, x/y/z] .", null, "x/y/z", null, "name");
		testModelPathItemParser("name=[ a.b.c , x/y/z].", "a.b.c", "x/y/z", null, "name");
	}

	@Test
	public void modelPathPatternTest() {
		testModelPatternMatcher("a/b", SLASH, "a/b/c", true);
		testModelPatternMatcher("a/b", SLASH, "a/b", true);
		testModelPatternMatcher("a/b", SLASH, "a", false);
		testModelPatternMatcher("a.b", DOT, "a.b.c", true);
		testModelPatternMatcher("a.b", DOT, "a.b", true);
		testModelPatternMatcher("a.b", DOT, "a", false);

		testModelPatternMatcher("/a/b", SLASH, "a/b/c", true);
		testModelPatternMatcher("a/b/", SLASH, "a/b", true);
		testModelPatternMatcher("/a/b/", SLASH, "a", false);
		testModelPatternMatcher(".a.b", DOT, "a.b.c", true);
		testModelPatternMatcher("a.b.", DOT, "a.b", true);
		testModelPatternMatcher(".a.b.", DOT, "a", false);

		testModelPatternMatcher("a/b", SLASH, "/a/b/c", true);
		testModelPatternMatcher("a/b", SLASH, "a/b/c/", true);
		testModelPatternMatcher("a/b", SLASH, "/a/b/c/", true);
		testModelPatternMatcher("a.b", DOT, ".a.b.c", true);
		testModelPatternMatcher("a.b", DOT, ".a.b.c.", true);
		testModelPatternMatcher("a.b", DOT, ".a.b.c.", true);
	}

	@Test
	public void modelPathWildTest() {
		testModelPatternMatcher("a/*/c", SLASH, "a/b/c", "b");
		testModelPatternMatcher("*/*/*", SLASH, "/a/b/c", "a", "b", "c");
		testModelPatternMatcher("**/*", SLASH, "a/b/c", //
				"~", "a", null, //
				"a", "b", null, //
				"a/b", "c");
		testModelPatternMatcher("**/**/d", SLASH, "a/b/c/d", //
				"~", "a/b/c", null, //
				"a", "b/c", null, //
				"a/b", "c", null, //
				"a/b/c", "~");
		testModelPatternMatcher("**/*/d", SLASH, "a/b/c/d/e/f/d/g", //
				"a/b", "c", null, //
				"a/b/c/d/e", "f");
		testModelPatternMatcher("a/**/*/d", SLASH, "a/b/c/d/e/f/d/g", //
				"b[**]", "c", null, //
				"b/c/d/e", "f");
		testModelPatternMatcher("a/*/c", SLASH, "a/b/c", "b");
		testModelPatternMatcher("*/*/*", SLASH, "/a/b/c", "a", "b", "c");
		testModelPatternMatcher("**/*", SLASH, "a/b/c", //
				"~", "a", null, //
				"a", "b", null, //
				"a|b", "c");
		testModelPatternMatcher("**/**/d", SLASH, "a/b/c/d", //
				"~", "a/b/c", null, //
				"a[**]", "b/c", null, //
				"a/b", "c[**]", null, //
				"a/b/c", "~");
		testModelPatternMatcher("**/*/d", SLASH, "a/b/c/d/e/f/d/g", //
				"a/b", "c", null, //
				"a/b/c/d/e", "f");
		testModelPatternMatcher("a/**/*/d", SLASH, "a/b/c/d/e/f/d/g", //
				"b[**]", "c", null, //
				"b/c/d/e", "f");
		testModelPatternMatcher("a/**:g/*/d", SLASH, "a/b/c/d/e/f/d/g", //
				"b/c/d/e", "f", null, //
				"b[**]", "c");
		testModelPatternMatcher("a/**:s/*/d", SLASH, "a/b/c/d/e/f/d/g", //
				"b[**]", "c");
		testModelPatternMatcher("a/**:gs/*/d", SLASH, "a/b/c/d/e/f/d/g", //
				"b/c/d/e", "f");
		testModelPatternMatcher("a/**/*/d", SLASH, "a/x/d/b/c/d/e/f/d/g", //
				"~", "x", null, //
				"x/d/b", "c", null, //
				"x/d/b/d/e", "f");
		testModelPatternMatcher("a/**:n/*/d", SLASH, "a/x/d/b/c/d/e/f/d/g", //
				"x/d/b", "c", null, //
				"x/d/b/d/e", "f");
		testModelPatternMatcher("a/**:gn/*/d", SLASH, "a/x/d/b/c/d/e/f/d/g", //
				"x/d/b/c/d/e", "f", null, //
				"x/d/b", "c");
	}

	@Test
	public void modelPathBindingsTest() {
		ModelPathBindings b1 = new ModelPathBindings();
		b1.add(Arrays.asList("value1.1"), SLASH, WILD);
		b1.add(Arrays.asList("value1.2"), "name1.2", SLASH, WILD);
		b1.add(Arrays.asList("value1.3"), "name1.3", SLASH, WILD);
		testModelPathBindings(b1, "value1.1", "name1.2=value1.2", "name1.3=value1.3");
		try {
			b1.add(Arrays.asList("bogus"), "name1.3", SLASH, WILD);
			fail("Duplicate binding name not detected");
		} catch (IllegalArgumentException e) {
		} catch (Exception e) {
			fail("Wrong exception for duplicate binding name");
		}
		ModelPathBindings b2 = new ModelPathBindings();
		b2.add(Arrays.asList("value2.1"), "name2.1", SLASH, WILD);
		b2.add(Arrays.asList("value2.2"), SLASH, WILD);
		testModelPathBindings(b2, "name2.1=value2.1", "value2.2");
		b1.merge(b2);
		testModelPathBindings(b1, "value1.1", "name1.2=value1.2", "name1.3=value1.3", "name2.1=value2.1", "value2.2");
		try {
			b1.merge(b2);
			fail("Duplicate bindings from bindings merge not detected");
		} catch (IllegalArgumentException e) {
		} catch (Exception e) {
			fail("Wrong exception for duplicate binding from bindings merge");
		}
	}

	@Test
	public void modelPathBindingsInterpolationTests() {
		testModelPathBindingsInterpolation("$1", "hello", "hello");
		testModelPathBindingsInterpolation("$11", "", "hello");
		testModelPathBindingsInterpolation("${1}1", "hello1", "hello");
		testModelPathBindingsInterpolation("$1", "hello/there", "hello/there");
		testModelPathBindingsInterpolation("${1:.}", "hello.there", "hello/there");
		testModelPathBindingsInterpolation("${1:/}", "hello/there", "hello/there");

		testModelPathBindingsInterpolation("$a", "hello", "a=hello");
		testModelPathBindingsInterpolation("$ax", "", "a=hello");
		testModelPathBindingsInterpolation("${a}x", "hellox", "a=hello");
		testModelPathBindingsInterpolation("$a", "hello/there", "a=hello/there");
		testModelPathBindingsInterpolation("${a:.}", "hello.there", "a=hello.there");
		testModelPathBindingsInterpolation("${a:/}", "hello/there", "a=hello/there");

		testModelPathBindingsInterpolation("${a:r}", "there/hello", "a=hello/there");
		testModelPathBindingsInterpolation("x/${a}/y", "x/y", "a=~");
		testModelPathBindingsInterpolation("x${a}/y", "x/y", "a=~");
		testModelPathBindingsInterpolation("x/${a}y", "x/y", "a=~");
		testModelPathBindingsInterpolation("x${a}y", "xy", "a=~");
		testModelPathBindingsInterpolation("x/${a:n}/y", "x//y", "a=~");
		testModelPathBindingsInterpolation("x${a:n}/y", "x/y", "a=~");
		testModelPathBindingsInterpolation("x/${a:n}y", "x/y", "a=~");
		testModelPathBindingsInterpolation("x${a:n}y", "xy", "a=~");
		testModelPathBindingsInterpolation("x/${a}/y", "x/y", "a=");
		testModelPathBindingsInterpolation("x${a}/y", "x/y", "a=");
		testModelPathBindingsInterpolation("x/${a}y", "x/y", "a=");
		testModelPathBindingsInterpolation("x${a}y", "xy", "a=");
	}

	@Test
	public void doubleDollarTests() {
		testModelPathBindingsInterpolation("${1}$", "$");
		testModelPathBindingsInterpolation("$1$", "$");
		testModelPathBindingsInterpolation("${1}$$", "$");
		testModelPathBindingsInterpolation("$1$$", "$");
		testModelPathBindingsInterpolation("$$1$$", "$1$");
		testModelPathBindingsInterpolation("$${1}$$", "${1}$");
		testModelPathBindingsInterpolation("$1x$$x$", "hellox$x$", "hello");
		testModelPathBindingsInterpolation("$1x$$$x$", "hellox$foo$", "hello", "x=foo");
		testModelPathBindingsInterpolation("$1x$$${x}$$$$", "hellox$foo$$", "hello", "x=foo");
		testModelPathBindingsInterpolation("$1x$$${x}$$$$$", "hellox$foo$$$", "hello", "x=foo");
	}

	private void testModelPathParser(String... itemStrings) {
		List<ModelPathItem> items = Arrays.asList(itemStrings).stream()
				.map((String itemString) -> new ModelPathItem(itemString)).collect(Collectors.toList());
		ModelPath path = new ModelPath(String.join("; ", itemStrings));
		assertEquals(items, path.getItems());
		path = new ModelPath(String.join("\n", itemStrings));
		assertEquals(items, path.getItems());
	}

	private void testModelPathItemParser(String itemString, String modelPat, String pathPat, String uri) {
		testModelPathItemParser(itemString, modelPat, pathPat, uri, null);
	}

	private void testModelPathItemParser(String itemString, String modelPat, String pathPat, String uri, String name) {
		ModelPathItem item = new ModelPathItem(itemString);
		assertEquals("Wrong model pattern", modelPat, item.getModelPattern());
		assertEquals("Wrong path pattern", pathPat, item.getPathPattern());
		assertEquals("Wrong URL template", uri, item.getUriTemplate());
		assertEquals("Wrong name", name, item.getName());
	}

	private void testModelPatternMatcher(String patternString, Delimiter delimiter, String s, boolean shouldMatch) {
		ModelPathPattern pattern = new ModelPathPattern(patternString, delimiter);
		boolean matched = pattern.getMatches(s, delimiter).iterator().hasNext();
		assertTrue(shouldMatch ? "Pattern did not match" : "Pattern should not have matched", shouldMatch == matched);
	}

	private void testModelPatternMatcher(String patternString, Delimiter delimiter, String s, String... flatBindings) {
		ModelPathPattern pattern = new ModelPathPattern(patternString, delimiter);
		List<ModelPathBindings> expected = unflattenBindings(flatBindings);
		List<ModelPathBindings> matches = Lists.newArrayList(pattern.getMatches(s, delimiter));
		for (int i = 0; i < Math.min(expected.size(), matches.size()); i++) {
			assertEquals("Wrong bindings", expected.get(0), matches.get(0));
		}
		for (int i = matches.size(); i < expected.size(); i++) {
			fail("Missing bindings: " + expected.get(i));
		}
		for (int i = expected.size(); i < matches.size(); i++) {
			fail("Unexpected bindings: " + matches.get(i));
		}
	}

	private List<ModelPathBindings> unflattenBindings(String... boundValues) {
		List<ModelPathBindings> bindingsList = Lists.newArrayList();
		int start = 0;
		for (int i = 0; i < boundValues.length; i++) {
			if (boundValues[i] == null) {
				bindingsList.add(createModelPathBindings(Arrays.copyOfRange(boundValues, start, i)));
				start = i + 1;
			}
		}
		if (start < boundValues.length || (boundValues.length > 0 && boundValues[boundValues.length - 1] == null)) {
			bindingsList.add(createModelPathBindings(Arrays.copyOfRange(boundValues, start, boundValues.length)));
		}
		return bindingsList;
	}

	private void testModelPathBindings(ModelPathBindings bindings, String... expectedValues) {
		List<Value> values = bindings.getValues();
		Set<String> names = bindings.getNamedValuePositions().keySet();
		Set<String> expectedNames = Sets.newHashSet();
		for (int i = 0; i < Math.min(expectedValues.length, values.size()); i++) {
			String[] parts = expectedValues[i].split("=");
			String name = parts.length > 1 ? parts[0] : null;
			List<String> value = Lists.newArrayList(parts[parts.length > 1 ? 1 : 0]);
			if (name != null) {
				expectedNames.add(name);
			}
			assertEquals("Wrong value in bindings at position " + i, value, bindings.getValue(i));
			if (name != null) {
				assertTrue("Missing named binding for " + name, names.contains(name));
				if (names.contains(name)) {
					assertEquals("Wrong bound value for name" + name, value, bindings.getValue(name));
				}
			}
		}
		for (int i = values.size(); i < expectedValues.length; i++) {
			fail("Missing value in binding at position " + i + ": " + expectedValues[i]);
		}
		for (int i = expectedValues.length; i < values.size(); i++) {
			fail("Unexpected value in bindings at position " + i + ": " + bindings.getValue(i));
		}
		for (String name : expectedNames) {
			assertTrue("Missing name in bindings: " + name, bindings.hasName(name));
		}
		for (String name : bindings.getNamedValuePositions().keySet()) {
			assertTrue("Unexpected name in bindings: " + name, expectedNames.contains(name));
		}
	}

	private void testModelPathBindingsInterpolation(String template, String expected, String... bindingsSpec) {
		ModelPathBindings bindings = createModelPathBindings(bindingsSpec);
		assertEquals(expected, bindings.interpolate(template));
	}

	private ModelPathBindings createModelPathBindings(String... bindingSpecs) {
		ModelPathBindings bindings = new ModelPathBindings();
		for (String spec : bindingSpecs) {
			bindings.add(Value.fromBindingSpec(spec));
		}
		return bindings;
	}
}
