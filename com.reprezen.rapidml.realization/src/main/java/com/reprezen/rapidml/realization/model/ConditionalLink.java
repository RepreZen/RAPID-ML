package com.reprezen.rapidml.realization.model;

import com.reprezen.rapidml.realization.model.LinkStrategy;
import javax.annotation.Generated;
import com.reprezen.rapidml.realization.model.ConditionedItem;
import com.reprezen.rapidml.realization.model.Conditions;

public interface ConditionalLink extends LinkStrategy, ConditionedItem {

    // Where
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Conditions getWhere();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Conditions getWhere(boolean elaborate);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setWhere(Conditions where);

    // Link
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    LinkStrategy getLink();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    LinkStrategy getLink(boolean elaborate);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setLink(LinkStrategy link);
}
