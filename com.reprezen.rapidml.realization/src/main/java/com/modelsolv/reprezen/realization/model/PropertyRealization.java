package com.modelsolv.reprezen.realization.model;

import javax.annotation.Generated;
import com.modelsolv.reprezen.realization.model.AbstractPropertySelector;
import com.modelsolv.reprezen.realization.model.PropertyTypeRealization;

public interface PropertyRealization extends AbstractPropertySelector {

    // PropertyType
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    PropertyTypeRealization getPropertyType();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    PropertyTypeRealization getPropertyType(boolean elaborate);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setPropertyType(PropertyTypeRealization propertyType);
}
