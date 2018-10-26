package com.reprezen.rapidml.realization.model;

import javax.annotation.Generated;
import com.reprezen.rapidml.realization.model.AbstractPropertySelector;
import com.reprezen.rapidml.realization.model.PropertyTypeRealization;

public interface PropertyRealization extends AbstractPropertySelector {

    // PropertyType
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    PropertyTypeRealization getPropertyType();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    PropertyTypeRealization getPropertyType(boolean elaborate);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setPropertyType(PropertyTypeRealization propertyType);
}
