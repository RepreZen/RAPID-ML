/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.implicit;

import com.reprezen.rapidml.Method;
import com.reprezen.rapidml.ResourceDefinition;
import com.reprezen.rapidml.RapidmlFactory;
import com.reprezen.rapidml.TypedResponse;

public class DefaultResponseProcessor {
    public void process(Method method) {
        if (method.getResponses().isEmpty() && needsDefaultResponse(method)) {
            createDefaultResponse(method);
        }
    }
           
    protected void createDefaultResponse(Method method) {
        TypedResponse result = RapidmlFactory.eINSTANCE.createTypedResponse();
        result.setStatusCode(200);
        switch (method.getHttpMethod()) {
        case GET:
        case POST:
        case PATCH:
        case DELETE:
            ResourceDefinition containingResource = (ResourceDefinition) method.eContainer();
            result.setResourceType(containingResource);
            break;
        default: // do nothing;
        }
        method.getResponses().add(result);
    }
    
    protected boolean needsDefaultResponse(Method method) {
        return true;
    }
}
