/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.xtext.tests.xmi;

import org.junit.Test;

@SuppressWarnings("nls")
public class XmiSerializerTest {

    private final String modelPath = "../com.modelsolv.reprezen.resources/models/xmi/TaxBlasterModel.xmi";

    @Test
    public void testModelLoaded() {
        // ZenModel zenModel = XmiModelLoaderUtils.loadModelWithoutWorkspace(new File(modelPath));
        // assertThat(zenModel, notNullValue());
        // assertThat(zenModel.getName(), equalTo("TaxBlasterModel"));
    }

    @Test
    public void testReferencesToMediaTypesLibrary() {
        // ZenModel zenModel = XmiModelLoaderUtils.loadModelWithoutWorkspace(new File(modelPath));
        // assertThat(zenModel, notNullValue());
        //
        // EList<MediaType> mediaTypes = zenModel.getResourceAPIs().get(0).getOwnedResourceDefinitions().get(0)
        // .getMediaTypes();
        // assertFalse(mediaTypes.isEmpty());
        // MediaType mediaType = mediaTypes.get(0);
        // assertFalse(mediaType.eIsProxy());
        // assertThat(mediaType.getName(), equalTo("application/xml"));
    }

    @Test
    public void testReferencesToXsdTypesLibrary() {
        // ZenModel zenModel = XmiModelLoaderUtils.loadModelWithoutWorkspace(new File(modelPath));
        // assertThat(zenModel, notNullValue());
        //
        // DataModel interfaceDatamodel = zenModel.getDataModels().get(0);
        // Structure firstDataType = (Structure) interfaceDatamodel.getOwnedDataTypes().get(0);
        // PrimitiveProperty primitiveProperty = (PrimitiveProperty) firstDataType.getOwnedFeatures().get(0);
        // SingleValueType primType = primitiveProperty.getType();
        // assertNotNull(primType);
        // assertThat(((PrimitiveType) primType).getName(), equalTo("string"));
    }
}
