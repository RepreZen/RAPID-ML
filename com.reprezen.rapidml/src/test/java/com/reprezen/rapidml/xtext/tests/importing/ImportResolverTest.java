package com.reprezen.rapidml.xtext.tests.importing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.reprezen.rapidml.xtext.modelpath.ImportResolver;
import com.reprezen.rapidml.xtext.modelpath.ModelPath;

public class ImportResolverTest {

    @Test
    public void nullModelPathTests() throws URISyntaxException {
        URI containerUri = URI.createURI("file:/x/y/Z.rapid");
        testNullModelPath(containerUri, "Sibling.rapid", "file:/x/y/Sibling.rapid");
        testNullModelPath(containerUri, "z/Child.rapid", "file:/x/y/z/Child.rapid");
        testNullModelPath(containerUri, "../Aunt.rapid", "file:/x/Aunt.rapid");
        testNullModelPath(containerUri, "/Root.rapid", "file:/Root.rapid");
        testNullModelPath(containerUri, "http://x.y.z/a/b/c/Absolute.rapid", "http://x.y.z/a/b/c/Absolute.rapid");
    }

    @Test
    public void simpleModelPathTests() throws URISyntaxException {
        ModelPath modelPath = new ModelPath("file:/x/y/z/; http://x.y.z/a/b/c/");
        testModelPath(modelPath, null, null, "Sibling.rapid", "file:/x/y/z/Sibling.rapid",
                "http://x.y.z/a/b/c/Sibling.rapid");
        testModelPath(modelPath, null, null, "z/Child.rapid", "file:/x/y/z/z/Child.rapid",
                "http://x.y.z/a/b/c/z/Child.rapid");
        testModelPath(modelPath, null, null, "../Aunt.rapid", "file:/x/y/Aunt.rapid", "http://x.y.z/a/b/Aunt.rapid");
        testModelPath(modelPath, null, null, "/Root.rapid", "file:/Root.rapid", "http://x.y.z/Root.rapid");
        testModelPath(modelPath, null, null, "http://a.b.c/Absolute.rapid", "http://a.b.c/Absolute.rapid");
    }

    @Test
    public void simpleModelPathWithDotTests() throws URISyntaxException {
        ModelPath modelPath = new ModelPath("file:/x/y/z/; .; http://x.y.z/a/b/c/");
        URI containerUri = URI.createURI("http://container/uri/model.rapid");
        testModelPath(modelPath, null, containerUri, "Sibling.rapid", "file:/x/y/z/Sibling.rapid",
                "http://container/uri/Sibling.rapid", "http://x.y.z/a/b/c/Sibling.rapid");
        testModelPath(modelPath, null, containerUri, "z/Child.rapid", "file:/x/y/z/z/Child.rapid",
                "http://container/uri/z/Child.rapid", "http://x.y.z/a/b/c/z/Child.rapid");
        testModelPath(modelPath, null, containerUri, "../Aunt.rapid", "file:/x/y/Aunt.rapid",
                "http://container/Aunt.rapid", "http://x.y.z/a/b/Aunt.rapid");
        testModelPath(modelPath, null, containerUri, "/Root.rapid", "file:/Root.rapid", "http://container/Root.rapid",
                "http://x.y.z/Root.rapid");
        testModelPath(modelPath, null, containerUri, "http://a.b.c/Absolute.rapid", "http://a.b.c/Absolute.rapid");
    }

    @Test
    public void wildcardModelPathTests() throws URISyntaxException, MalformedURLException {
        ModelPath modelPath = new ModelPath(
                "[a.*.c] http://a.$1.c/; [a.b:**, x/*/tail:**] http://a.$b.c/$2/${tail}/foo/");
        testModelPath(modelPath, "a.b.c.x", null, "Model.rapid", "http://a.b.c/Model.rapid");
        testModelPath(modelPath, "a.b.c", null, "x/y/z/Model.rapid", //
                "http://a.b.c/x/y/z/Model.rapid", //
                "http://a.c/y/foo/x/y/z/Model.rapid", //
                "http://a.c/y/z/foo/x/y/z/Model.rapid", //
                "http://a.b.c/y/foo/x/y/z/Model.rapid", //
                "http://a.b.c/y/z/foo/x/y/z/Model.rapid", //
                null);
        // repeat above tests but without referencing named wildcards. Tests bug in ModelPathItem$BindingsPruner that
        // was throwing concurrent mod exception. Fixed in 164b0ede937b64a4b566e9f6821833e4b8347d80 and in this change
        modelPath = new ModelPath("[a.*.c] http://a.$1.c/; [a.b:**, x/*/tail:**] http://a.$1.c/$2/${3}/foo/");
        testModelPath(modelPath, "a.b.c.x", null, "Model.rapid", "http://a.b.c/Model.rapid");
        testModelPath(modelPath, "a.b.c", null, "x/y/z/Model.rapid", //
                "http://a.b.c/x/y/z/Model.rapid", //
                "http://a.c/y/foo/x/y/z/Model.rapid", //
                "http://a.c/y/z/foo/x/y/z/Model.rapid", //
                "http://a.b.c/y/foo/x/y/z/Model.rapid", //
                "http://a.b.c/y/z/foo/x/y/z/Model.rapid", //
                null);

    }

    @Test
    public void simplePatternPathTests() throws URISyntaxException, MalformedURLException {
        ModelPath modelPath = new ModelPath("[ a.b ] http://a.b/; [ , x/y] file:/; [ a.b, x/y] http://a.b/");
        URI containerUri = URI.createURI("http://container/uri/model.rapid");
        testModelPath(modelPath, "a.b.c", containerUri, "model.rapid", "http://a.b/model.rapid");
        testModelPath(modelPath, "a.b.c", containerUri, "model.rapid", "http://a.b/model.rapid");
        testModelPath(modelPath, "x.a.b.c", containerUri, "model.rapid");
        testModelPath(modelPath, "x.a.b.c", containerUri, "x/y/model.rapid", "file:/x/y/model.rapid");
        testModelPath(modelPath, "a.b.c", containerUri, "x/y/model.rapid", "http://a.b/x/y/model.rapid",
                "file:/x/y/model.rapid", "http://a.b/x/y/model.rapid");
        testModelPath(modelPath, "x.a.b.c", containerUri, "model.rapid");
    }

    @Test
    public void platformUrlTemplateTests() throws URISyntaxException {
        ModelPath modelPath = new ModelPath(
                "[ a.b ] platform:/resource/projB/; [a.c] platform:/resource/projC/dir/; .");
        URI containerUri = URI.createURI("platform:/resource/mainProject/models/Model.rapid");
        testModelPath(modelPath, "a.b.c.Model.DM", containerUri, "foo/xxx.rapid", //
                "platform:/resource/projB/foo/xxx.rapid", //
                "platform:/resource/mainProject/models/foo/xxx.rapid");
        testModelPath(modelPath, "a.c.b.Model.DM", containerUri, "foo/xxx.rapid", //
                "platform:/resource/projC/dir/foo/xxx.rapid", //
                "platform:/resource/mainProject/models/foo/xxx.rapid");
        testModelPath(modelPath, "b.c.Model.DM", containerUri, "foo/xxx.rapid", //
                "platform:/resource/mainProject/models/foo/xxx.rapid");
    }

    @Test
    public void noImportUriTests() throws URISyntaxException {
        ModelPath modelPath = new ModelPath("[ a.b ] http://example.com/; [ , foo/bar ] http://bogus.com/; .");
        URI containerUri = URI.createURI("http://container.com/");
        testModelPath(modelPath, "a.b.c", containerUri, null, //
                "http://example.com/");
        testModelPath(modelPath, "a.b.c", containerUri, "foo/bar/model.rapid", //
                "http://example.com/foo/bar/model.rapid", //
                "http://bogus.com/foo/bar/model.rapid", //
                "http://container.com/foo/bar/model.rapid");
    }

    private void testNullModelPath(URI containerUri, String importUri, String expected) throws URISyntaxException {
        testModelPath(null, null, containerUri, importUri, expected);
    }

    private void testModelPath(ModelPath modelPath, String fqModelName, URI containerUri, String importUri,
            String... expected) throws URISyntaxException {
        ImportResolver resolver = new ImportResolver(modelPath, containerUri, fqModelName, importUri);
        List<URI> results = Lists.newArrayList(resolver.resolve());
        for (int i = 0; i < Math.min(expected.length, results.size()); i++) {
            assertEquals(expected[i], results.get(i).toString());
        }
        for (int i = expected.length; i < results.size(); i++) {
            fail("Unexpected proposed URL: " + results.get(i));
        }
        for (int i = results.size(); i < expected.length; i++) {
            if (expected[i] != null) {
                fail("Missing proposed URL: " + expected[i]);
            }
        }

    }
}
