package com.reprezen.realization.model;

import com.reprezen.realization.model.LinkStrategy;
import javax.annotation.Generated;
import com.reprezen.realization.model.Switchable;
import com.reprezen.realization.model.Base;
import java.util.Map;
import com.reprezen.realization.model.ObjectRealizationStrategy;
import com.reprezen.realization.model.PropertySet;
import com.reprezen.realization.model.RealizationRule;

public interface RealizationModel extends Base, Switchable<RealizationRule> {

    // Name
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    String getName();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setName(String name);

    // RealizationRule
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Map<String, RealizationRule> getRealizationRules();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Map<String, RealizationRule> getRealizationRules(boolean elaborate);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    boolean hasRealizationRules();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    boolean hasRealizationRule(String name);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    RealizationRule getRealizationRule(String name);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setRealizationRules(Map<String, RealizationRule> realizationRules);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setRealizationRule(String name, RealizationRule realizationRule);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void removeRealizationRule(String name);

    // Realization
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Map<String, ObjectRealizationStrategy> getRealizations();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Map<String, ObjectRealizationStrategy> getRealizations(boolean elaborate);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    boolean hasRealizations();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    boolean hasRealization(String name);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    ObjectRealizationStrategy getRealization(String name);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setRealizations(Map<String, ObjectRealizationStrategy> realizations);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setRealization(String name, ObjectRealizationStrategy realization);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void removeRealization(String name);

    // PropertySet
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Map<String, PropertySet> getPropertySets();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Map<String, PropertySet> getPropertySets(boolean elaborate);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    boolean hasPropertySets();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    boolean hasPropertySet(String name);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    PropertySet getPropertySet(String name);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setPropertySets(Map<String, PropertySet> propertySets);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setPropertySet(String name, PropertySet propertySet);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void removePropertySet(String name);

    // Link
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Map<String, LinkStrategy> getLinks();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    Map<String, LinkStrategy> getLinks(boolean elaborate);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    boolean hasLinks();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    boolean hasLink(String name);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    LinkStrategy getLink(String name);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setLinks(Map<String, LinkStrategy> links);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setLink(String name, LinkStrategy link);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void removeLink(String name);
}
