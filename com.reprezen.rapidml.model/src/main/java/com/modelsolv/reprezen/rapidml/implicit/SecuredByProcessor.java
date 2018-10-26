/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.modelsolv.reprezen.rapidml.implicit;

import com.modelsolv.reprezen.rapidml.Method;
import com.modelsolv.reprezen.rapidml.ResourceAPI;
import com.modelsolv.reprezen.rapidml.ResourceDefinition;

public class SecuredByProcessor {
    
    public void process(ResourceDefinition resource) {
        // add resourceAPI level authentication schemes if resource authentication schemes are absent
        if (resource.getSecuredBy().isEmpty()) {
            ResourceAPI resourceAPI = (ResourceAPI) resource.eContainer();
            if (resourceAPI != null) {
                resource.getSecuredBy().addAll(resourceAPI.getSecuredBy());
            }
        }
        
        for (Method method : resource.getMethods()) {
            // add resource level authentication schemes if method authentication schemes are absent
            if (method.getSecuredBy().isEmpty()) {
                if (resource != null) {
                    method.getSecuredBy().addAll(resource.getSecuredBy());
                }
            }
        }
    }
}
