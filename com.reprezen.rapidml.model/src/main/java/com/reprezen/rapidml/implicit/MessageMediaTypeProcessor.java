/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.implicit;

import java.util.Optional;

import com.reprezen.rapidml.Method;
import com.reprezen.rapidml.ServiceDataResource;
import com.reprezen.rapidml.TypedMessage;

public class MessageMediaTypeProcessor {

    public void process(TypedMessage message) {
        // add resource level media types if message mediaTypes are absent
        if (message.getMediaTypes().isEmpty()) {
            Optional<ServiceDataResource> resource = getContainingResourceDefinition(message);
            if (resource.isPresent()) {
                message.getMediaTypes().addAll(resource.get().getMediaTypes());
            }
        }
    }

    public static Optional<ServiceDataResource> getContainingResourceDefinition(TypedMessage message) {
        Method method = (Method) message.eContainer();
        if (method != null && method.getContainingResourceDefinition() instanceof ServiceDataResource) {
            return Optional.of((ServiceDataResource)method.getContainingResourceDefinition());
        }
        return Optional.empty();
    }

}
