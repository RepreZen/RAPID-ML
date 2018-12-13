/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.xtext.loaders;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.google.inject.Inject;
import com.reprezen.rapidml.ZenModel;

/**
 * Loads the RESTApi model that are in Xtext DSL format.
 * 
 * REVIEW: We should be working with streams, always, not with files.
 * 
 * @author jimleroyer
 * @since 2013/04/26
 */
public class DslRestModelLoader extends RestModelLoader {

	private final ResourceSet resourceSet;

	@Inject
	public DslRestModelLoader(ResourceSet resourceSet) {
		this.resourceSet = resourceSet;
	}

	/**
	 * Loads the model at the given location and returns it.
	 * 
	 * @param modelPath Location of the RESTApi metamodel.
	 * @return {@link com.reprezen.rapidml.ZenModel}
	 */
	@Override
	public ZenModel load(URI modelPath) {
		Resource resource = resourceSet.getResource(modelPath, true);
		if (resource != null && resource.getContents().size() == 1) {
			EObject root = resource.getContents().get(0);
			if (root instanceof ZenModel) {
				return (ZenModel) root;
			}
		}
		return null;
	}

	/**
	 * Loads the model at the given location and returns it.
	 * 
	 * @param modelLocation Location of the RESTApi metamodel.
	 * @return {@link com.reprezen.rapidml.ZenModel}
	 */
	@Override
	public ZenModel load(String modelLocation) {
		return load(URI.createFileURI(modelLocation));
	}

}
