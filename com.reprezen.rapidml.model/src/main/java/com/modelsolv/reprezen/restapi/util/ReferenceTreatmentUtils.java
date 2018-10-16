/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.modelsolv.reprezen.restapi.util;

import org.eclipse.emf.ecore.EObject;

import com.modelsolv.reprezen.restapi.ReferenceTreatment;
import com.modelsolv.reprezen.restapi.ServiceDataResource;
import com.modelsolv.reprezen.restapi.TypedMessage;
import com.modelsolv.reprezen.restapi.Feature;
import com.modelsolv.reprezen.restapi.ReferenceElement;
import com.modelsolv.reprezen.restapi.Structure;

public class ReferenceTreatmentUtils {

    public static Structure getContextDataType(EObject context) {
        if (context instanceof ServiceDataResource) {
            return ((ServiceDataResource) context).getDataType();
        }
        if (context instanceof TypedMessage) {
            return ((TypedMessage) context).getActualType();
        }
        if (context instanceof ReferenceTreatment) {
            return ((ReferenceTreatment) context).getReferenceElement().getDataType();
        }
        // not supported case
        return null;
    }

    public static boolean isFeatureIncluded(EObject context, Feature feature) {
        if (context instanceof ServiceDataResource) {
            return ((ServiceDataResource) context).isIncluded(feature);
        }
        if (context instanceof TypedMessage) {
            return ((TypedMessage) context).isIncluded(feature);
        }
        return false;
    }

    public static String getLabel(ReferenceElement referenceElement) {
        return ">" + referenceElement.getName();
    }

}
