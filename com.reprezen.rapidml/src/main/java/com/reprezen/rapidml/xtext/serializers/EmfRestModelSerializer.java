/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.xtext.serializers;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import com.reprezen.rapidml.ZenModel;

/**
 * Serializes an {@link com.modelsolv.reprezen.restapi.ZenModel} at a given location under the EMF 'xmi' serialization
 * format.
 * 
 * REVIEW: We should be working with streams, always, not with files.
 * 
 * @author jimleroyer
 * @since 2013/04/26
 */
public class EmfRestModelSerializer implements RestModelSerializer {

    /**
     * Serializes an {@link com.modelsolv.reprezen.restapi.ZenModel} at the given path.
     * 
     * @param path
     *            Location of the RESTApi metamodel.
     * @param model
     *            {@link com.modelsolv.reprezen.restapi.ZenModel} to serialize.
     */
    @Override
    public void serialize(String path, ZenModel model) throws RuntimeException {
        ResourceSet resourceSet = new ResourceSetImpl();
        org.eclipse.emf.ecore.resource.Resource resource = resourceSet.createResource(URI.createFileURI(path));
        resource.getContents().add(model);
        try {
            resource.save(null);
        } catch (IOException e) {
            throw new RuntimeException(String.format("Could not save the ZenModel at location '%s'", path), e);
        }
    }

}