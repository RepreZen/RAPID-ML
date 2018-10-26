package com.reprezen.rapidml.realization.model.impl;

import com.reprezen.rapidml.realization.model.impl.ObjectRealizationStrategyImpl;
import javax.annotation.Generated;
import com.fasterxml.jackson.core.JsonPointer;
import com.reprezen.jsonoverlay.JsonOverlay;
import com.reprezen.jsonoverlay.ReferenceManager;
import com.reprezen.rapidml.realization.model.impl.ContainmentSelectorImpl;
import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.jsonoverlay.BooleanOverlay;
import com.reprezen.rapidml.realization.model.*;
import java.util.stream.Collectors;
import com.reprezen.jsonoverlay.OverlayFactory;

public class ReferencePropertyRealizationImpl extends PropertyTypeRealizationImpl implements ReferencePropertyRealization {

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public ReferencePropertyRealizationImpl(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
        super(json, parent, refMgr);
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public ReferencePropertyRealizationImpl(ReferencePropertyRealization referencePropertyRealization, JsonOverlay<?> parent, ReferenceManager refMgr) {
        super(referencePropertyRealization, parent, refMgr);
    }

    // Containment
    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public ContainmentSelector getContainment() {
        return _get("containment", ContainmentSelector.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public ContainmentSelector getContainment(boolean elaborate) {
        return _get("containment", elaborate, ContainmentSelector.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public void setContainment(ContainmentSelector containment) {
        _setScalar("containment", containment, ContainmentSelector.class);
    }

    // AutoLinkableToObjectResource
    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public Boolean getAutoLinkableToObjectResource() {
        return _get("autoLinkableToObjectResource", Boolean.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public boolean isAutoLinkableToObjectResource() {
        Boolean bool = _get("autoLinkableToObjectResource", Boolean.class);
        return bool != null ? bool : false;
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public void setAutoLinkableToObjectResource(Boolean autoLinkableToObjectResource) {
        _setScalar("autoLinkableToObjectResource", autoLinkableToObjectResource, Boolean.class);
    }

    // AutoLinkableToCollectionResource
    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public Boolean getAutoLinkableToCollectionResource() {
        return _get("autoLinkableToCollectionResource", Boolean.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public boolean isAutoLinkableToCollectionResource() {
        Boolean bool = _get("autoLinkableToCollectionResource", Boolean.class);
        return bool != null ? bool : false;
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public void setAutoLinkableToCollectionResource(Boolean autoLinkableToCollectionResource) {
        _setScalar("autoLinkableToCollectionResource", autoLinkableToCollectionResource, Boolean.class);
    }

    // HasKeys
    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public Boolean getHasKeys() {
        return _get("hasKeys", Boolean.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public boolean isHasKeys() {
        Boolean bool = _get("hasKeys", Boolean.class);
        return bool != null ? bool : false;
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public void setHasKeys(Boolean hasKeys) {
        _setScalar("hasKeys", hasKeys, Boolean.class);
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
        _createScalar("containment", "containment", ContainmentSelectorImpl.factory);
        _createScalar("autoLinkableToObjectResource", "autoLinkableToObjectResource", BooleanOverlay.factory);
        _createScalar("autoLinkableToCollectionResource", "autoLinkableToCollectionResource", BooleanOverlay.factory);
        _createScalar("hasKeys", "hasKeys", BooleanOverlay.factory);
        _createScalar("realization", "realization", ObjectRealizationStrategyImpl.factory);
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public static OverlayFactory<ReferencePropertyRealization> factory = new OverlayFactory<ReferencePropertyRealization>() {

        @Override
        protected Class<? extends JsonOverlay<? super ReferencePropertyRealization>> getOverlayClass() {
            return ReferencePropertyRealizationImpl.class;
        }

        @Override
        public JsonOverlay<ReferencePropertyRealization> _create(ReferencePropertyRealization referencePropertyRealization, JsonOverlay<?> parent, ReferenceManager refMgr) {
            JsonOverlay<?> overlay;
            overlay = new ReferencePropertyRealizationImpl(referencePropertyRealization, parent, refMgr);
            @SuppressWarnings("unchecked") JsonOverlay<ReferencePropertyRealization> castOverlay = (JsonOverlay<ReferencePropertyRealization>) overlay;
            return castOverlay;
        }

        @Override
        public JsonOverlay<ReferencePropertyRealization> _create(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
            JsonOverlay<?> overlay;
            overlay = new ReferencePropertyRealizationImpl(json, parent, refMgr);
            @SuppressWarnings("unchecked") JsonOverlay<ReferencePropertyRealization> castOverlay = (JsonOverlay<ReferencePropertyRealization>) overlay;
            return castOverlay;
        }

        @Override
        protected boolean isExtendedType() {
            return false;
        }
    };

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    private static Class<? extends ReferencePropertyRealization> getSubtypeOf(ReferencePropertyRealization referencePropertyRealization) {
        return ReferencePropertyRealization.class;
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    private static Class<? extends ReferencePropertyRealization> getSubtypeOf(JsonNode json) {
        return ReferencePropertyRealization.class;
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    protected OverlayFactory<?> _getFactory() {
        return factory;
    }
}
