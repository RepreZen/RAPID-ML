package com.modelsolv.reprezen.rapidml.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.modelsolv.reprezen.rapidml.ObjectRealization;
import com.modelsolv.reprezen.rapidml.PropertyReference;
import com.modelsolv.reprezen.rapidml.RealizationContainer;
import com.modelsolv.reprezen.rapidml.ResourceDefinition;
import com.modelsolv.reprezen.rapidml.URIParameter;
import com.modelsolv.reprezen.rapidml.PrimitiveProperty;

public class ObjectRealizationUtils {

    public static List<PrimitiveProperty> getMandatoryProperties(ObjectRealization includedProperties) {
        List<PrimitiveProperty> result = new ArrayList<>();
        RealizationContainer realizationContainer = includedProperties.getRealizationContainer();
        if (realizationContainer instanceof ResourceDefinition) {
            ResourceDefinition resource = (ResourceDefinition) realizationContainer;
            if (resource.getURI() != null) {
                for (URIParameter param : resource.getURI().getUriParameters()) {
                    if (param.getSourceReference() instanceof PropertyReference) {
                        PropertyReference property = (PropertyReference) param.getSourceReference();
                        result.add(property.getConceptualFeature());
                    }
                }
            }
        }
        // TODO : for TypedMessage
        return Collections.unmodifiableList(result);
    }

}
