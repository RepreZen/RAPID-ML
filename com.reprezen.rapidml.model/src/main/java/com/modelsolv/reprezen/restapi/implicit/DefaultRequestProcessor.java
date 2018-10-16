/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.modelsolv.reprezen.restapi.implicit;

import com.modelsolv.reprezen.restapi.Method;
import com.modelsolv.reprezen.restapi.ResourceDefinition;
import com.modelsolv.reprezen.restapi.RestapiFactory;
import com.modelsolv.reprezen.restapi.TypedRequest;

public class DefaultRequestProcessor {

    public void process(Method method) {
        if (null == method.getRequest() && needsDefaultRequest(method)) {
            createDefaultRequest(method);
        }
    }

    protected void createDefaultRequest(Method method) {
        TypedRequest result = RestapiFactory.eINSTANCE.createTypedRequest();
        switch (method.getHttpMethod()) {
        case PUT:
        case POST:
        case PATCH:
        case DELETE:
            ResourceDefinition containingResource = (ResourceDefinition) method.eContainer();
            result.setResourceType(containingResource);
            break;
        default: // do nothing;
        }
        method.setRequest(result);
    }

    protected boolean needsDefaultRequest(Method method) {
        return true;
    }
}
