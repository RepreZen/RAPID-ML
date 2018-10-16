package com.modelsolv.reprezen.realization.model.impl;

import com.reprezen.jsonoverlay.StringOverlay;
import com.modelsolv.reprezen.realization.model.impl.ObjectRealizationStrategyImpl;
import java.util.Collection;
import com.modelsolv.reprezen.realization.model.impl.ContextPatternImpl;
import java.util.stream.Collectors;
import com.reprezen.jsonoverlay.OverlayFactory;
import javax.annotation.Generated;
import com.fasterxml.jackson.core.JsonPointer;
import java.util.List;
import com.modelsolv.reprezen.realization.model.ConditionedItem;
import com.reprezen.jsonoverlay.JsonOverlay;
import com.reprezen.jsonoverlay.ReferenceManager;
import com.reprezen.jsonoverlay.ListOverlay;
import com.fasterxml.jackson.databind.JsonNode;
import com.modelsolv.reprezen.realization.model.*;

public class RealizationRuleImpl extends BaseImpl implements RealizationRule {

    @Override
    public Collection<? extends Conditions> getConditions() {
        return getContexts();
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public RealizationRuleImpl(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
        super(json, parent, refMgr);
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public RealizationRuleImpl(RealizationRule realizationRule, JsonOverlay<?> parent, ReferenceManager refMgr) {
        super(realizationRule, parent, refMgr);
    }

    // NamingPattern
    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public String getNamingPattern() {
        return _get("namingPattern", String.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public void setNamingPattern(String namingPattern) {
        _setScalar("namingPattern", namingPattern, String.class);
    }

    // Context
    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public List<ContextPattern> getContexts() {
        return _getList("contexts", ContextPattern.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public List<ContextPattern> getContexts(boolean elaborate) {
        return _getList("contexts", elaborate, ContextPattern.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public boolean hasContexts() {
        return _isPresent("contexts");
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public ContextPattern getContext(int index) {
        return _get("contexts", index, ContextPattern.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public void setContexts(List<ContextPattern> contexts) {
        _setList("contexts", contexts, ContextPattern.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public void setContext(int index, ContextPattern context) {
        _set("contexts", index, context, ContextPattern.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public void addContext(ContextPattern context) {
        _add("contexts", context, ContextPattern.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public void insertContext(int index, ContextPattern context) {
        _insert("contexts", index, context, ContextPattern.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public void removeContext(int index) {
        _remove("contexts", index, ContextPattern.class);
    }

    // Realization
    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public ObjectRealizationStrategy getRealization() {
        return _get("realization", ObjectRealizationStrategy.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public ObjectRealizationStrategy getRealization(boolean elaborate) {
        return _get("realization", elaborate, ObjectRealizationStrategy.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public void setRealization(ObjectRealizationStrategy realization) {
        _setScalar("realization", realization, ObjectRealizationStrategy.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    protected void _elaborateJson() {
        super._elaborateJson();
        _createScalar("namingPattern", "namingPattern", StringOverlay.factory);
        _createList("contexts", "appliesTo", ContextPatternImpl.factory);
        _createScalar("realization", "realization", ObjectRealizationStrategyImpl.factory);
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public static OverlayFactory<RealizationRule> factory = new OverlayFactory<RealizationRule>() {

        @Override
        protected Class<? extends JsonOverlay<? super RealizationRule>> getOverlayClass() {
            return RealizationRuleImpl.class;
        }

        @Override
        public JsonOverlay<RealizationRule> _create(RealizationRule realizationRule, JsonOverlay<?> parent, ReferenceManager refMgr) {
            JsonOverlay<?> overlay;
            overlay = new RealizationRuleImpl(realizationRule, parent, refMgr);
            @SuppressWarnings("unchecked") JsonOverlay<RealizationRule> castOverlay = (JsonOverlay<RealizationRule>) overlay;
            return castOverlay;
        }

        @Override
        public JsonOverlay<RealizationRule> _create(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
            JsonOverlay<?> overlay;
            overlay = new RealizationRuleImpl(json, parent, refMgr);
            @SuppressWarnings("unchecked") JsonOverlay<RealizationRule> castOverlay = (JsonOverlay<RealizationRule>) overlay;
            return castOverlay;
        }

        @Override
        protected boolean isExtendedType() {
            return false;
        }
    };

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    private static Class<? extends RealizationRule> getSubtypeOf(RealizationRule realizationRule) {
        return RealizationRule.class;
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    private static Class<? extends RealizationRule> getSubtypeOf(JsonNode json) {
        return RealizationRule.class;
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    protected OverlayFactory<?> _getFactory() {
        return factory;
    }
}
