package com.reprezen.realization.model;

import javax.annotation.Generated;
import com.reprezen.realization.model.MultiplicitySelector;
import com.reprezen.realization.model.Base;
import com.reprezen.realization.model.ReadWriteSelector;

public interface AbstractPropertySelector extends Base {

    // ReadWritability
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    ReadWriteSelector getReadWritability();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    ReadWriteSelector getReadWritability(boolean elaborate);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setReadWritability(ReadWriteSelector readWritability);

    // Multiplicity
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    MultiplicitySelector getMultiplicity();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    MultiplicitySelector getMultiplicity(boolean elaborate);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setMultiplicity(MultiplicitySelector multiplicity);

    // Required
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Boolean getRequired();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    boolean isRequired();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setRequired(Boolean required);
}
