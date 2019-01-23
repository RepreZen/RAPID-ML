/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.xtext.loaders;

import static java.lang.String.format;

import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;

import com.google.inject.Injector;
import com.reprezen.core.RapidFileExtensions;
import com.reprezen.core.XmiFileExtensions;
import com.reprezen.rapidml.ZenModel;

/**
 * The Class ModelLoaderUtils.
 */
public class ModelLoaderUtils {

	/**
	 * Load model.
	 * 
	 * @param file
	 *            the source file
	 * @return the Zen model
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static ZenModel loadModel(Injector injector, IFile file) throws IOException {
		URI modelUri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
		return loadModel(injector, modelUri);
	}

	/**
	 * Load model.
	 * 
	 * @param modelURI
	 *            the URI of the source model
	 * @return the Zen model
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static ZenModel loadModel(Injector injector, URI modelURI) throws IOException {
		if (RapidFileExtensions.isZenExtension(modelURI.fileExtension())) {
			return injector.getInstance(DslRestModelLoader.class).load(modelURI);
		} else if (XmiFileExtensions.XMI.getExtension().equalsIgnoreCase(modelURI.fileExtension())) {
			return new EmfRestModelLoader().load(modelURI);
		} else {
			String extension = modelURI.fileExtension();
			throw new IOException(format("The '%s' extension is not supported for WADL generation.", extension));
		}
	}
}