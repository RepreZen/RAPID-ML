package com.reprezen.realization.model.impl;

import javax.annotation.Generated;
import com.fasterxml.jackson.core.JsonPointer;
import com.reprezen.jsonoverlay.JsonOverlay;
import com.reprezen.jsonoverlay.ReferenceManager;
import com.reprezen.realization.model.impl.ContainmentSelectorImpl;
import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.jsonoverlay.BooleanOverlay;
import com.reprezen.realization.model.*;
import java.util.stream.Collectors;
import com.reprezen.jsonoverlay.OverlayFactory;

public class ReferencePropertySelectorImpl extends PropertyTypeSelectorImpl implements ReferencePropertySelector {

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public ReferencePropertySelectorImpl(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
        super(json, parent, refMgr);
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public ReferencePropertySelectorImpl(ReferencePropertySelector referencePropertySelector, JsonOverlay<?> parent, ReferenceManager refMgr) {
        super(referencePropertySelector, parent, refMgr);
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
    public boolean hasKeys() {
        Boolean bool = _get("hasKeys", Boolean.class);
        return bool != null ? bool : false;
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public void setHasKeys(Boolean hasKeys) {
        _setScalar("hasKeys", hasKeys, Boolean.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    protected void _elaborateJson() {
        super._elaborateJson();
        _createScalar("containment", "containment", ContainmentSelectorImpl.factory);
        _createScalar("autoLinkableToObjectResource", "autoLinkableToObjectResource", BooleanOverlay.factory);
        _createScalar("autoLinkableToCollectionResource", "autoLinkableToCollectionResource", BooleanOverlay.factory);
        _createScalar("hasKeys", "hasKeys", BooleanOverlay.factory);
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public static OverlayFactory<ReferencePropertySelector> factory = new OverlayFactory<ReferencePropertySelector>() {

        @Override
        protected Class<? extends JsonOverlay<? super ReferencePropertySelector>> getOverlayClass() {
            return ReferencePropertySelectorImpl.class;
        }

        @Override
        public JsonOverlay<ReferencePropertySelector> _create(ReferencePropertySelector referencePropertySelector, JsonOverlay<?> parent, ReferenceManager refMgr) {
            JsonOverlay<?> overlay;
            overlay = new ReferencePropertySelectorImpl(referencePropertySelector, parent, refMgr);
            @SuppressWarnings("unchecked") JsonOverlay<ReferencePropertySelector> castOverlay = (JsonOverlay<ReferencePropertySelector>) overlay;
            return castOverlay;
        }

        @Override
        public JsonOverlay<ReferencePropertySelector> _create(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
            JsonOverlay<?> overlay;
            overlay = new ReferencePropertySelectorImpl(json, parent, refMgr);
            @SuppressWarnings("unchecked") JsonOverlay<ReferencePropertySelector> castOverlay = (JsonOverlay<ReferencePropertySelector>) overlay;
            return castOverlay;
        }

        @Override
        protected boolean isExtendedType() {
            return false;
        }
    };

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    private static Class<? extends ReferencePropertySelector> getSubtypeOf(ReferencePropertySelector referencePropertySelector) {
        return ReferencePropertySelector.class;
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    private static Class<? extends ReferencePropertySelector> getSubtypeOf(JsonNode json) {
        return ReferencePropertySelector.class;
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    protected OverlayFactory<?> _getFactory() {
        return factory;
    }
}
