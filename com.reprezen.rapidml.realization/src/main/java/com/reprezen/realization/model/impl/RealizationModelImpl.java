package com.reprezen.realization.model.impl;

import com.reprezen.jsonoverlay.StringOverlay;
import com.reprezen.realization.model.impl.ObjectRealizationStrategyImpl;
import java.util.Collection;
import com.reprezen.realization.model.impl.LinkStrategyImpl;
import com.reprezen.jsonoverlay.MapOverlay;
import java.util.stream.Collectors;
import com.reprezen.jsonoverlay.OverlayFactory;
import javax.annotation.Generated;
import com.fasterxml.jackson.core.JsonPointer;
import com.reprezen.realization.model.Switchable;
import com.reprezen.jsonoverlay.JsonOverlay;
import java.util.Map;
import com.reprezen.jsonoverlay.ReferenceManager;
import java.util.Optional;
import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.realization.model.*;
import com.reprezen.realization.model.impl.PropertySetImpl;
import com.reprezen.realization.model.impl.RealizationRuleImpl;

public class RealizationModelImpl extends BaseImpl implements RealizationModel {

    @Override
    public Collection<RealizationRule> getCandidates() {
        return getRealizationRules().values();
    }

    @Override
    public Optional<RealizationRule> getNoCandidatesResult() {
        return Optional.of(FactoryDefaultRealizationRule.instance);
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public RealizationModelImpl(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
        super(json, parent, refMgr);
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public RealizationModelImpl(RealizationModel realizationModel, JsonOverlay<?> parent, ReferenceManager refMgr) {
        super(realizationModel, parent, refMgr);
    }

    // Name
    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public String getName() {
        return _get("name", String.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public void setName(String name) {
        _setScalar("name", name, String.class);
    }

    // RealizationRule
    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public Map<String, RealizationRule> getRealizationRules() {
        return _getMap("realizationRules", RealizationRule.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public Map<String, RealizationRule> getRealizationRules(boolean elaborate) {
        return _getMap("realizationRules", elaborate, RealizationRule.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public boolean hasRealizationRules() {
        return _isPresent("realizationRules");
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public boolean hasRealizationRule(String name) {
        return _getMap("realizationRules", RealizationRule.class).containsKey(name);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public RealizationRule getRealizationRule(String name) {
        return _get("realizationRules", name, RealizationRule.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public void setRealizationRules(Map<String, RealizationRule> realizationRules) {
        _setMap("realizationRules", realizationRules, RealizationRule.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public void setRealizationRule(String name, RealizationRule realizationRule) {
        _set("realizationRules", name, realizationRule, RealizationRule.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public void removeRealizationRule(String name) {
        _remove("realizationRules", name, RealizationRule.class);
    }

    // Realization
    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public Map<String, ObjectRealizationStrategy> getRealizations() {
        return _getMap("realizations", ObjectRealizationStrategy.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public Map<String, ObjectRealizationStrategy> getRealizations(boolean elaborate) {
        return _getMap("realizations", elaborate, ObjectRealizationStrategy.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public boolean hasRealizations() {
        return _isPresent("realizations");
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public boolean hasRealization(String name) {
        return _getMap("realizations", ObjectRealizationStrategy.class).containsKey(name);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public ObjectRealizationStrategy getRealization(String name) {
        return _get("realizations", name, ObjectRealizationStrategy.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public void setRealizations(Map<String, ObjectRealizationStrategy> realizations) {
        _setMap("realizations", realizations, ObjectRealizationStrategy.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public void setRealization(String name, ObjectRealizationStrategy realization) {
        _set("realizations", name, realization, ObjectRealizationStrategy.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public void removeRealization(String name) {
        _remove("realizations", name, ObjectRealizationStrategy.class);
    }

    // PropertySet
    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public Map<String, PropertySet> getPropertySets() {
        return _getMap("propertySets", PropertySet.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public Map<String, PropertySet> getPropertySets(boolean elaborate) {
        return _getMap("propertySets", elaborate, PropertySet.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public boolean hasPropertySets() {
        return _isPresent("propertySets");
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public boolean hasPropertySet(String name) {
        return _getMap("propertySets", PropertySet.class).containsKey(name);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public PropertySet getPropertySet(String name) {
        return _get("propertySets", name, PropertySet.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public void setPropertySets(Map<String, PropertySet> propertySets) {
        _setMap("propertySets", propertySets, PropertySet.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public void setPropertySet(String name, PropertySet propertySet) {
        _set("propertySets", name, propertySet, PropertySet.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public void removePropertySet(String name) {
        _remove("propertySets", name, PropertySet.class);
    }

    // Link
    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public Map<String, LinkStrategy> getLinks() {
        return _getMap("links", LinkStrategy.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public Map<String, LinkStrategy> getLinks(boolean elaborate) {
        return _getMap("links", elaborate, LinkStrategy.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public boolean hasLinks() {
        return _isPresent("links");
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public boolean hasLink(String name) {
        return _getMap("links", LinkStrategy.class).containsKey(name);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public LinkStrategy getLink(String name) {
        return _get("links", name, LinkStrategy.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public void setLinks(Map<String, LinkStrategy> links) {
        _setMap("links", links, LinkStrategy.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public void setLink(String name, LinkStrategy link) {
        _set("links", name, link, LinkStrategy.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public void removeLink(String name) {
        _remove("links", name, LinkStrategy.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    protected void _elaborateJson() {
        super._elaborateJson();
        _createScalar("name", "name", StringOverlay.factory);
        _createMap("realizationRules", "realizationRules", RealizationRuleImpl.factory, null);
        _createMap("realizations", "components/realizations", ObjectRealizationStrategyImpl.factory, null);
        _createMap("propertySets", "components/propertySets", PropertySetImpl.factory, null);
        _createMap("links", "components/links", LinkStrategyImpl.factory, null);
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public static OverlayFactory<RealizationModel> factory = new OverlayFactory<RealizationModel>() {

        @Override
        protected Class<? extends JsonOverlay<? super RealizationModel>> getOverlayClass() {
            return RealizationModelImpl.class;
        }

        @Override
        public JsonOverlay<RealizationModel> _create(RealizationModel realizationModel, JsonOverlay<?> parent, ReferenceManager refMgr) {
            JsonOverlay<?> overlay;
            overlay = new RealizationModelImpl(realizationModel, parent, refMgr);
            @SuppressWarnings("unchecked") JsonOverlay<RealizationModel> castOverlay = (JsonOverlay<RealizationModel>) overlay;
            return castOverlay;
        }

        @Override
        public JsonOverlay<RealizationModel> _create(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
            JsonOverlay<?> overlay;
            overlay = new RealizationModelImpl(json, parent, refMgr);
            @SuppressWarnings("unchecked") JsonOverlay<RealizationModel> castOverlay = (JsonOverlay<RealizationModel>) overlay;
            return castOverlay;
        }

        @Override
        protected boolean isExtendedType() {
            return false;
        }
    };

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    private static Class<? extends RealizationModel> getSubtypeOf(RealizationModel realizationModel) {
        return RealizationModel.class;
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    private static Class<? extends RealizationModel> getSubtypeOf(JsonNode json) {
        return RealizationModel.class;
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    protected OverlayFactory<?> _getFactory() {
        return factory;
    }
}
