package com.modelsolv.reprezen.realization.model;

import javax.annotation.Generated;
import com.modelsolv.reprezen.realization.model.ContainmentSelector;
import com.modelsolv.reprezen.realization.model.PropertyTypeSelector;

public interface ReferencePropertySelector extends PropertyTypeSelector {

    // Containment
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    ContainmentSelector getContainment();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    ContainmentSelector getContainment(boolean elaborate);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setContainment(ContainmentSelector containment);

    // AutoLinkableToObjectResource
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Boolean getAutoLinkableToObjectResource();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    boolean isAutoLinkableToObjectResource();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setAutoLinkableToObjectResource(Boolean autoLinkableToObjectResource);

    // AutoLinkableToCollectionResource
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Boolean getAutoLinkableToCollectionResource();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    boolean isAutoLinkableToCollectionResource();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setAutoLinkableToCollectionResource(Boolean autoLinkableToCollectionResource);

    // HasKeys
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Boolean getHasKeys();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    boolean hasKeys();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setHasKeys(Boolean hasKeys);
}
