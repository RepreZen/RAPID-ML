package com.reprezen.rapidml.realization.model;

import javax.annotation.Generated;
import com.reprezen.rapidml.realization.model.PropertyTypeSelector;
import com.reprezen.rapidml.realization.model.AbstractPropertySelector;

public interface PropertySelector extends AbstractPropertySelector {

    // PropertyType
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    PropertyTypeSelector getPropertyType();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    PropertyTypeSelector getPropertyType(boolean elaborate);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setPropertyType(PropertyTypeSelector propertyType);
}
