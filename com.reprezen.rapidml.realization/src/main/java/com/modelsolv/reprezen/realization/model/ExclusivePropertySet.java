package com.modelsolv.reprezen.realization.model;

import javax.annotation.Generated;
import java.util.List;
import com.modelsolv.reprezen.realization.model.PropertyRealization;
import com.modelsolv.reprezen.realization.model.PropertySet;

public interface ExclusivePropertySet extends PropertySet {

    // IncludedProperty
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    List<PropertyRealization> getIncludedProperties();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    List<PropertyRealization> getIncludedProperties(boolean elaborate);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    boolean hasIncludedProperties();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    PropertyRealization getIncludedProperty(int index);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setIncludedProperties(List<PropertyRealization> includedProperties);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setIncludedProperty(int index, PropertyRealization includedProperty);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void addIncludedProperty(PropertyRealization includedProperty);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void insertIncludedProperty(int index, PropertyRealization includedProperty);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void removeIncludedProperty(int index);
}
