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

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Stream;

import org.eclipse.emf.common.util.URI;
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
		this.importUri = importUri != null ? URI.createURI(importUri) : null;
		this.isAbsoluteImportUri = importUri != null ? !this.importUri.isRelative() : false;
	}

	public ImportResolver(String modelPathString, URI containerUri, String fqModelName, String importUri) {
		this(new ModelPath(modelPathString), containerUri, fqModelName, importUri);
	}

	public ImportResolver(List<ModelPathItem> modelPathItems, URI containerUri, String fqModelName, String importUri) {
		this(new ModelPath(modelPathItems), containerUri, fqModelName, importUri);
	}

	public Iterable<URI> resolve() {
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
						.flatMap(wrapBadUri(this::getUrisForItem)) //
				::iterator;
			} catch (RuntimeException e) {
				throw (IllegalArgumentException) e.getCause();
			}
		}
	}

	private Stream<URI> getUrisForItem(ModelPathItem item) {
		try {
			return item.getMatches(fqModelName, importUri) //
					.map(binding -> interpolate(binding, item)) //
					.filter(Objects::nonNull) //
					.map(wrapBadUri(URI::createURI)) //
					.map(context -> importUri != null ? importUri.resolve(context) : context);
		} catch (RuntimeException e) {
			throw (IllegalArgumentException) e.getCause();
		}
	}

	private String interpolate(ModelPathBindings binding, ModelPathItem item) {
		if (item.getUriTemplate() != null) {
			return binding.interpolate(item.getUriTemplate());
		}
		if (containerUri != null) {
			return binding.interpolate(containerUri.toString());
		}
		return null;
	}

	@FunctionalInterface
	private interface ThrowingFunction<T, R, E extends Exception> {
		R accept(T t) throws E;
	}

	static <T, R> Function<T, R> wrapBadUri(ThrowingFunction<T, R, IllegalArgumentException> f) {
		return t -> {
			try {
				return f.accept(t);
			} catch (IllegalArgumentException e) {
				throw new RuntimeException(e);
			}
		};
	}
}
