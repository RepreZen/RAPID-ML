/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.realization.processor;

import com.reprezen.rapidml.realization.model.RealizationRule;
import com.reprezen.rapidml.realization.processor.RealizationProcessor.IRealizationProcessor;
import com.reprezen.rapidml.CollectionResource;
import com.reprezen.rapidml.ObjectResource;
import com.reprezen.rapidml.ReferenceTreatment;
import com.reprezen.rapidml.ResourceAPI;
import com.reprezen.rapidml.ServiceDataResource;
import com.reprezen.rapidml.TypedMessage;
import com.reprezen.rapidml.ReferenceProperty;

public class DefaultRealizationProcessor implements IRealizationProcessor {
    private final DefaultReferenceRealizationRegistry defaultReferenceRealizationRegistry;
  
    public DefaultRealizationProcessor(ResourceAPI resourceAPI) {
        LinksProcessor linksProcessor = new LinksProcessor(resourceAPI);
        defaultReferenceRealizationRegistry = new DefaultReferenceRealizationRegistry(linksProcessor);
    }

    public RealizationRule processMessage(TypedMessage message) {
        return null;
    }

    @Override
    public RealizationRule processObjectResource(ObjectResource objectResource) {
        return null;
    }

    @Override
    public RealizationRule processCollectionResource(CollectionResource collectionResource) {
        return null;
    }

    @Override
    public ReferenceTreatment processReferenceProperty(ReferenceProperty reference, TypedMessage contextMessage) {
        ReferenceTreatment referenceTreatment = defaultReferenceRealizationRegistry
                .createOrRetrieveDefaultReferenceTreatment(reference);
        return referenceTreatment;
    }

    @Override
    public ReferenceTreatment processReferenceProperty(ReferenceProperty reference,
            ServiceDataResource contextResource) {
        ReferenceTreatment referenceTreatment = defaultReferenceRealizationRegistry
                .createOrRetrieveDefaultReferenceTreatment(reference);
        return referenceTreatment;
    }

}
