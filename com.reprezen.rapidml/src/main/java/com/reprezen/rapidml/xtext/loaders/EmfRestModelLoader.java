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
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import com.google.common.base.Preconditions;
import com.reprezen.rapidml.ZenModel;

/**
 * Loads the RESTApi model that are in EMF format.
 * 
 * REVIEW: We should be working with streams, always, not with files.
 * 
 * @author jimleroyer
 * @since 2013/04/26
 */
public class EmfRestModelLoader extends RestModelLoader {

    /**
     * Loads the model at the given location and returns it.
     * 
     * @param modelLocation
     *            Location of the RESTApi metamodel.
     * @return {@link com.reprezen.rapidml.ZenModel}
     * @throws {@link
     *             com.reprezen.rapidml.xtext.RestApiException}
     */
    @Override
    public ZenModel load(URI modelLocation) {
        Preconditions.checkArgument(modelLocation != null, "The model location should not be null");
        validateFile(modelLocation.toFileString());
        return doLoad(modelLocation);
    }

    /**
     * Loads the model at the given location and returns it.
     * 
     * @param modelLocation
     *            Location of the RESTApi metamodel.
     * @return {@link com.reprezen.rapidml.ZenModel}
     * @throws {@link
     *             com.reprezen.rapidml.xtext.RestApiException}
     */
    @Override
    public ZenModel load(String modelLocation) {
        Preconditions.checkArgument(modelLocation != null, "The model location should not be null");
        validateFile(modelLocation);
        return doLoad(URI.createFileURI(modelLocation));
    }

    protected ZenModel doLoad(URI modelLocation) {
        ResourceSet resourceSet = new ResourceSetImpl();
        org.eclipse.emf.ecore.resource.Resource resource = resourceSet.getResource(modelLocation, true);
        ZenModel model = (ZenModel) resource.getContents().get(0);
        return model;
    }

}