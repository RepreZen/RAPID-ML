package com.reprezen.rapidml.realization.model;

import com.reprezen.rapidml.realization.model.LinkStrategy;
import javax.annotation.Generated;
import com.reprezen.rapidml.realization.model.TargetResourceType;

public interface LinkSpec extends LinkStrategy {

    // TargetResourceType
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    TargetResourceType getTargetResourceType();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    TargetResourceType getTargetResourceType(boolean elaborate);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setTargetResourceType(TargetResourceType targetResourceType);

    // LinkRelation
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    String getLinkRelation();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setLinkRelation(String linkRelation);
}