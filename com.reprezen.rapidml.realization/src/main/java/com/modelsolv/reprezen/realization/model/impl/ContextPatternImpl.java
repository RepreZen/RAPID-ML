package com.modelsolv.reprezen.realization.model.impl;

import javax.annotation.Generated;
import com.fasterxml.jackson.core.JsonPointer;
import com.reprezen.jsonoverlay.JsonOverlay;
import com.modelsolv.reprezen.realization.model.impl.ReferenceLevelContextImpl;
import com.modelsolv.reprezen.realization.model.impl.ResourceTypeSelectorImpl;
import com.reprezen.jsonoverlay.ReferenceManager;
import com.fasterxml.jackson.databind.JsonNode;
import com.modelsolv.reprezen.realization.model.*;
import java.util.stream.Collectors;
import com.modelsolv.reprezen.realization.model.impl.DefinitionContextImpl;
import com.reprezen.jsonoverlay.OverlayFactory;

public class ContextPatternImpl extends ConditionsImpl implements ContextPattern {

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public ContextPatternImpl(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
        super(json, parent, refMgr);
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public ContextPatternImpl(ContextPattern contextPattern, JsonOverlay<?> parent, ReferenceManager refMgr) {
        super(contextPattern, parent, refMgr);
    }

    // ResourceType
    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public ResourceTypeSelector getResourceType() {
        return _get("resourceType", ResourceTypeSelector.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public ResourceTypeSelector getResourceType(boolean elaborate) {
        return _get("resourceType", elaborate, ResourceTypeSelector.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public void setResourceType(ResourceTypeSelector resourceType) {
        _setScalar("resourceType", resourceType, ResourceTypeSelector.class);
    }

    // DefinedIn
    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public DefinitionContext getDefinedIn() {
        return _get("definedIn", DefinitionContext.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public DefinitionContext getDefinedIn(boolean elaborate) {
        return _get("definedIn", elaborate, DefinitionContext.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public void setDefinedIn(DefinitionContext definedIn) {
        _setScalar("definedIn", definedIn, DefinitionContext.class);
    }

    // Level
    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public ReferenceLevelContext getLevel() {
        return _get("level", ReferenceLevelContext.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public ReferenceLevelContext getLevel(boolean elaborate) {
        return _get("level", elaborate, ReferenceLevelContext.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public void setLevel(ReferenceLevelContext level) {
        _setScalar("level", level, ReferenceLevelContext.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    protected void _elaborateJson() {
        super._elaborateJson();
        _createScalar("resourceType", "resourceType", ResourceTypeSelectorImpl.factory);
        _createScalar("definedIn", "definedIn", DefinitionContextImpl.factory);
        _createScalar("level", "level", ReferenceLevelContextImpl.factory);
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public static OverlayFactory<ContextPattern> factory = new OverlayFactory<ContextPattern>() {

        @Override
        protected Class<? extends JsonOverlay<? super ContextPattern>> getOverlayClass() {
            return ContextPatternImpl.class;
        }

        @Override
        public JsonOverlay<ContextPattern> _create(ContextPattern contextPattern, JsonOverlay<?> parent, ReferenceManager refMgr) {
            JsonOverlay<?> overlay;
            overlay = new ContextPatternImpl(contextPattern, parent, refMgr);
            @SuppressWarnings("unchecked") JsonOverlay<ContextPattern> castOverlay = (JsonOverlay<ContextPattern>) overlay;
            return castOverlay;
        }

        @Override
        public JsonOverlay<ContextPattern> _create(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
            JsonOverlay<?> overlay;
            overlay = new ContextPatternImpl(json, parent, refMgr);
            @SuppressWarnings("unchecked") JsonOverlay<ContextPattern> castOverlay = (JsonOverlay<ContextPattern>) overlay;
            return castOverlay;
        }

        @Override
        protected boolean isExtendedType() {
            return false;
        }
    };

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    private static Class<? extends ContextPattern> getSubtypeOf(ContextPattern contextPattern) {
        return ContextPattern.class;
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    private static Class<? extends ContextPattern> getSubtypeOf(JsonNode json) {
        return ContextPattern.class;
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    protected OverlayFactory<?> _getFactory() {
        return factory;
    }
}
