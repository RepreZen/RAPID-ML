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
import static com.reprezen.rapidml.xtext.modelpath.DebugModelPath.Option.RESOLUTION;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Stream;

import org.eclipse.xtext.util.Strings;

public class ImportResolver {
    public static final String SYS_VARIABLE_MODEL_PATH = "com.modelsolv.reprezen.rapid-ml.modelpath";

    private ModelPath modelPath;
    private URI containerUri;
    private String fqModelName;
    private URI importUri;
    private boolean isAbsoluteImportUri;

    public static ModelPath getActiveModelPath() {
        String modelPathString = System.getProperty(ImportResolver.SYS_VARIABLE_MODEL_PATH);
        if (Strings.isEmpty(modelPathString)) {
            return null;
        }
        return new ModelPath(modelPathString);
    }

    public ImportResolver(ModelPath modelPath, URI containerUri, String fqModelName, String importUri) {
        this.modelPath = modelPath;
        this.containerUri = containerUri;
        this.fqModelName = fqModelName;
        try {
            this.importUri = importUri != null ? new URI(importUri) : null;
            this.isAbsoluteImportUri = importUri != null ? this.importUri.isAbsolute() : false;
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException("Invalid import URI", e);
        }
    }

    public ImportResolver(String modelPathString, URI containerUri, String fqModelName, String importUri) {
        this(new ModelPath(modelPathString), containerUri, fqModelName, importUri);
    }

    public ImportResolver(List<ModelPathItem> modelPathItems, URI containerUri, String fqModelName, String importUri) {
        this(new ModelPath(modelPathItems), containerUri, fqModelName, importUri);
    }

    public Iterable<URI> resolve() throws URISyntaxException {
        debug(RESOLUTION, ":Resolving model path " + String.valueOf(modelPath), "Container=", containerUri,
                "FQ Model Name=", fqModelName, "Import URI=", importUri);
        if (isAbsoluteImportUri) {
            debug(RESOLUTION, ":Absolute import URI used as is: " + importUri.toString());
            return Arrays.asList(importUri);
        } else if (modelPath == null) {
            debug(RESOLUTION, ":Using default importer-relative model path ('.')");
            return getUrisForItem(new ModelPathItem(null, null, "."))::iterator;
        } else {
            try {
                return modelPath.getItems().stream() //
                        .flatMap(wrapBadUri(item -> getUrisForItem(item))) //
                ::iterator;
            } catch (RuntimeException e) {
                throw (URISyntaxException) e.getCause();
            }
        }
    }

    private Stream<URI> getUrisForItem(ModelPathItem item) throws URISyntaxException {
        String template = item.getUriTemplate();
        try {
            return item.getMatches(fqModelName, importUri) //
                    .map((ModelPathBindings b) -> b.interpolate(template != null ? template : containerUri.toString())) //
                    .filter(Objects::nonNull) //
                    .map(wrapBadUri(uriString -> new URI(uriString))) //
                    .map(context -> importUri != null ? context.resolve(importUri) : context);
        } catch (RuntimeException e) {
            throw (URISyntaxException) e.getCause();
        }
    }

    @FunctionalInterface
    private interface ThrowingFunction<T, R, E extends Exception> {
        R accept(T t) throws E;
    }

    static <T, R> Function<T, R> wrapBadUri(ThrowingFunction<T, R, URISyntaxException> f) {
        return t -> {
            try {
                return f.accept(t);
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
        };
    }
}
