/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.implicit;

import java.util.List;

import com.google.common.collect.Lists;
import com.reprezen.rapidml.realization.processor.RealizationProcessor;
import com.reprezen.rapidml.Documentation;
import com.reprezen.rapidml.Method;
import com.reprezen.rapidml.ResourceAPI;
import com.reprezen.rapidml.ResourceDefinition;
import com.reprezen.rapidml.TypedMessage;
import com.reprezen.rapidml.ZenModel;
import com.reprezen.rapidml.util.TagUtils;

import reprezen.org.eclipse.xtext.EcoreUtil2;

public class ZenModelNormalizer {

    public void normalize(ZenModel model) {
        if (TagUtils.getTagWithName(model, TagUtils.NORMALIZED).isPresent()) {
            return;
        }
        new InheritedPropertiesProcessor().addInheritedProperties(model);
        for (ResourceAPI resourceAPI : model.getResourceAPIs()) {
            for (ResourceDefinition resource : resourceAPI.getOwnedResourceDefinitions()) {
                new SecuredByProcessor().process(resource);
                for (Method method : resource.getMethods()) {
                    processMethod(method);
                }
            }
        }

        DocumentationSpaceProcessor documentationSpaceProcessor = new DocumentationSpaceProcessor();
        for (Documentation doc : EcoreUtil2.getAllContentsOfType(model, Documentation.class)) {
            documentationSpaceProcessor.process(doc);
        }
        try {
            generateAutoRealizations(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
        TagUtils.addTag(model, TagUtils.NORMALIZED);
    }

    public void generateAutoRealizations(ZenModel model) {
        for (ResourceAPI resourceAPI : model.getResourceAPIs()) {
            new RealizationProcessor(resourceAPI).generateAutoRealizations();
        }
    }

    protected void processMethod(Method method) {
        new DefaultRequestProcessor().process(method);
        new DefaultResponseProcessor().process(method);

        List<TypedMessage> typedMessages = Lists.newArrayList();
        typedMessages.addAll(method.getResponses());
        typedMessages.add(method.getRequest());

        for (TypedMessage typedMessage : typedMessages) {
            processTypedMessage(typedMessage);
        }
    }

    protected void processTypedMessage(TypedMessage message) {
        new MessageMediaTypeProcessor().process(message);
    }

}
