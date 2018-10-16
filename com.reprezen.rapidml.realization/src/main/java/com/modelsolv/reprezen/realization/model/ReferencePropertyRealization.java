package com.modelsolv.reprezen.realization.model;

import javax.annotation.Generated;
import com.modelsolv.reprezen.realization.model.ContainmentSelector;
import com.modelsolv.reprezen.realization.model.ObjectRealizationStrategy;
import com.modelsolv.reprezen.realization.model.PropertyTypeRealization;

public interface ReferencePropertyRealization extends PropertyTypeRealization {

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
    boolean isHasKeys();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setHasKeys(Boolean hasKeys);

    // Realization
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    ObjectRealizationStrategy getRealization();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    ObjectRealizationStrategy getRealization(boolean elaborate);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setRealization(ObjectRealizationStrategy realization);
}
