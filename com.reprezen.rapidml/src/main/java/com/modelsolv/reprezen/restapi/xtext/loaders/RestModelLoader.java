/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.modelsolv.reprezen.restapi.xtext.loaders;

import org.eclipse.emf.common.util.URI;

import com.modelsolv.reprezen.restapi.ZenModel;

/**
 * Loader for the ModelSolv RESTApi metamodel.
 * 
 * @author jimleroyer
 * @since 2013/04/25
 */
public interface RestModelLoader {

    /**
     * Loads the model at the given location and returns it.
     * 
     * @param modelPath
     *            {@link org.eclipse.emf.common.util.URI} of the RESTApi metamodel.
     * @return {@link com.modelsolv.reprezen.restapi.ZenModel}
     */
    public ZenModel load(URI modelPath);

    /**
     * Loads the model at the given location and returns it.
     * 
     * @param modelLocation
     *            Location of the model, as a {@link String}.
     * @return {@link com.modelsolv.reprezen.restapi.ZenModel}
     */
    public ZenModel load(String modelLocation);

}
