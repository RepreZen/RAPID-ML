package com.reprezen.rapidml.realization.model;

import javax.annotation.Generated;
import java.util.List;
import com.reprezen.rapidml.realization.model.Switchable;
import com.reprezen.rapidml.realization.model.PropertySet;
import com.reprezen.rapidml.realization.model.ConditionalPropertySet;

public interface PropertySetSwitch extends PropertySet, Switchable<ConditionalPropertySet> {

    // PropertySetCase
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    List<ConditionalPropertySet> getPropertySetCases();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    List<ConditionalPropertySet> getPropertySetCases(boolean elaborate);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    boolean hasPropertySetCases();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    ConditionalPropertySet getPropertySetCase(int index);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setPropertySetCases(List<ConditionalPropertySet> propertySetCases);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setPropertySetCase(int index, ConditionalPropertySet propertySetCase);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void addPropertySetCase(ConditionalPropertySet propertySetCase);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void insertPropertySetCase(int index, ConditionalPropertySet propertySetCase);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void removePropertySetCase(int index);
}
