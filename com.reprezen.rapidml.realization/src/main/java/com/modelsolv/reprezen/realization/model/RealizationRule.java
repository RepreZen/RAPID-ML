package com.modelsolv.reprezen.realization.model;

import javax.annotation.Generated;
import java.util.List;
import com.modelsolv.reprezen.realization.model.ConditionedItem;
import com.modelsolv.reprezen.realization.model.Base;
import com.modelsolv.reprezen.realization.model.ObjectRealizationStrategy;
import com.modelsolv.reprezen.realization.model.ContextPattern;

public interface RealizationRule extends Base, ConditionedItem {

    // NamingPattern
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    String getNamingPattern();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setNamingPattern(String namingPattern);

    // Context
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    List<ContextPattern> getContexts();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    List<ContextPattern> getContexts(boolean elaborate);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    boolean hasContexts();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    ContextPattern getContext(int index);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setContexts(List<ContextPattern> contexts);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setContext(int index, ContextPattern context);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void addContext(ContextPattern context);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void insertContext(int index, ContextPattern context);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void removeContext(int index);

    // Realization
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    ObjectRealizationStrategy getRealization();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    ObjectRealizationStrategy getRealization(boolean elaborate);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setRealization(ObjectRealizationStrategy realization);
}
