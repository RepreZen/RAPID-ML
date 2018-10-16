package com.modelsolv.reprezen.realization.model;

import javax.annotation.Generated;
import com.modelsolv.reprezen.realization.model.MultiplicitySelector;
import com.modelsolv.reprezen.realization.model.ContainmentSelector;
import com.modelsolv.reprezen.realization.model.ReadWriteSelector;
import com.modelsolv.reprezen.realization.model.ReferenceLevelContext;

public interface ReferencePropertyContext extends ReferenceLevelContext {

    // Multiplicity
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    MultiplicitySelector getMultiplicity();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    MultiplicitySelector getMultiplicity(boolean elaborate);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setMultiplicity(MultiplicitySelector multiplicity);

    // ReadWritability
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    ReadWriteSelector getReadWritability();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    ReadWriteSelector getReadWritability(boolean elaborate);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setReadWritability(ReadWriteSelector readWritability);

    // Required
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Boolean getRequired();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    boolean isRequired();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setRequired(Boolean required);

    // Containment
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    ContainmentSelector getContainment();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    ContainmentSelector getContainment(boolean elaborate);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setContainment(ContainmentSelector containment);
}
