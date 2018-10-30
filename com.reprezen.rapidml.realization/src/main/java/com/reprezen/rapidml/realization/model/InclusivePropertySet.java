package com.reprezen.rapidml.realization.model;

import javax.annotation.Generated;
import java.util.List;
import com.reprezen.rapidml.realization.model.PropertyRealization;
import com.reprezen.rapidml.realization.model.PropertySelector;
import com.reprezen.rapidml.realization.model.PropertySet;

public interface InclusivePropertySet extends PropertySet {

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

    // ExcludedProperty
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    List<PropertySelector> getExcludedProperties();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    List<PropertySelector> getExcludedProperties(boolean elaborate);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    boolean hasExcludedProperties();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    PropertySelector getExcludedProperty(int index);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setExcludedProperties(List<PropertySelector> excludedProperties);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setExcludedProperty(int index, PropertySelector excludedProperty);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void addExcludedProperty(PropertySelector excludedProperty);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void insertExcludedProperty(int index, PropertySelector excludedProperty);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void removeExcludedProperty(int index);
}
