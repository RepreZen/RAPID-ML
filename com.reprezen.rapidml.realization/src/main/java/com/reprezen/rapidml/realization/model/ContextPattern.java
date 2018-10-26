package com.reprezen.rapidml.realization.model;

import javax.annotation.Generated;
import com.reprezen.rapidml.realization.model.ResourceTypeSelector;
import com.reprezen.rapidml.realization.model.Conditions;
import com.reprezen.rapidml.realization.model.DefinitionContext;
import com.reprezen.rapidml.realization.model.ReferenceLevelContext;

public interface ContextPattern extends Conditions {

    // ResourceType
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    ResourceTypeSelector getResourceType();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    ResourceTypeSelector getResourceType(boolean elaborate);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setResourceType(ResourceTypeSelector resourceType);

    // DefinedIn
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    DefinitionContext getDefinedIn();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    DefinitionContext getDefinedIn(boolean elaborate);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setDefinedIn(DefinitionContext definedIn);

    // Level
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    ReferenceLevelContext getLevel();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    ReferenceLevelContext getLevel(boolean elaborate);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setLevel(ReferenceLevelContext level);
}
