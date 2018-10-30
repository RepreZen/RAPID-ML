/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.realization.processor;

import java.util.HashMap;
import java.util.Map;

import com.reprezen.rapidml.ReferenceRealization;
import com.reprezen.rapidml.ReferenceTreatment;
import com.reprezen.rapidml.ResourceAPI;
import com.reprezen.rapidml.Element;
import com.reprezen.rapidml.ReferenceProperty;
import com.reprezen.rapidml.Structure;

public class DefaultReferenceRealizationRegistry {
    private final static boolean TEMP_FEATURE_TOGGLE_USE_GRAPH = true;

    // We have a single instance of DefaultReferenceEmbedRegistry per normalization
    private final Map<ResourceAPI, Map<ReferenceTreatmentDescriptor, ReferenceRealization>> defaultReferenceRealizations = new HashMap<>();
    
    private final LinksProcessor linkProcessor;
    private final ResourceAPI context;

    public DefaultReferenceRealizationRegistry(LinksProcessor realizationProtocol) {
        this.linkProcessor = realizationProtocol;
        context = realizationProtocol.getResourceAPI();
    }

    public ReferenceTreatment createOrRetrieveDefaultReferenceTreatment(ReferenceProperty reference) {
        ReferenceRealization referenceRealization = createOrRetrieveDefaultReferenceRealization(
                newReferenceTreatmentDescriptor(reference));
        if (referenceRealization == null) {
            // null is return in case of cycles, won't be application with the new design
            return null;
        }
        ReferenceTreatment referenceTreatment = ReferenceTreatmentFactory.createReferenceTreatment(referenceRealization,
                reference);
        return referenceTreatment;
    }

    private ReferenceRealization createOrRetrieveDefaultReferenceRealization(ReferenceTreatmentDescriptor reference) {
        ReferenceRealization referenceRealization = getDefaultReferenceRealization(reference);
        if (referenceRealization != null) {
            return referenceRealization;
        }
        referenceRealization = linkProcessor.createDefaultReferenceRealization(context, reference);
        if (referenceRealization == null) {
            return null;
        }
        context.getDefaultReferenceRealizations().add(referenceRealization);
        getDefaultReferenceRealizations(context).put(reference, referenceRealization);
        // postprocess here. Otherwise, propertySet will run on the same element twice
        return referenceRealization;
    }

    private ReferenceRealization getDefaultReferenceRealization(ReferenceTreatmentDescriptor reference) {
        Map<ReferenceTreatmentDescriptor, ReferenceRealization> defaultReferenceEmbedsForAPI = getDefaultReferenceRealizations(
                context);
        if (TEMP_FEATURE_TOGGLE_USE_GRAPH) {
            return defaultReferenceEmbedsForAPI.get(reference);
        }
        return null;
    }

    private Map<ReferenceTreatmentDescriptor, ReferenceRealization> getDefaultReferenceRealizations(
            ResourceAPI context) {
        Map<ReferenceTreatmentDescriptor, ReferenceRealization> defaultReferenceEmbedsForAPI = defaultReferenceRealizations
                .get(context);
        if (defaultReferenceEmbedsForAPI == null) {
            defaultReferenceEmbedsForAPI = new HashMap<>();
            defaultReferenceRealizations.put(context, defaultReferenceEmbedsForAPI);
        }
        return defaultReferenceEmbedsForAPI;
    }

    private static ReferenceTreatmentDescriptor newReferenceTreatmentDescriptor(Element reference) {
        boolean objectNotCollection = !reference.isMultiValued();
        return new ReferenceTreatmentDescriptor(reference.getDataType(), objectNotCollection);
    }

    /**
     * Used as a key in the default realizations registry. Also defines all necessary information for default
     * realization creation. This information is used by ReferenceTreatmentFactory.
     *
     */
    public static class ReferenceTreatmentDescriptor {
        private final Structure targetDataType;

        /**
         * ReferenceTreatmentDescriptor is used as a key in a hashmap, linkSpec is one of its defining properties
         */
        private final boolean isObjectNotCollection;

        private ReferenceTreatmentDescriptor(Structure targetDataType, boolean isObjectNotCollection) {
            this.targetDataType = targetDataType;
            this.isObjectNotCollection = isObjectNotCollection;
        }

        public Structure getTargetDataType() {
            return targetDataType;
        }

        public boolean isObjectNotCollection() {
            return isObjectNotCollection;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + (isObjectNotCollection ? 1231 : 1237);
            result = prime * result + ((targetDataType == null) ? 0 : targetDataType.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            ReferenceTreatmentDescriptor other = (ReferenceTreatmentDescriptor) obj;
            if (isObjectNotCollection != other.isObjectNotCollection)
                return false;
            if (targetDataType == null) {
                if (other.targetDataType != null)
                    return false;
            } else if (!targetDataType.equals(other.targetDataType))
                return false;
            return true;
        }

    }
}
