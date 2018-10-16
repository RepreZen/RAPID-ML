package com.modelsolv.reprezen.realization.model.impl;

import javax.annotation.Generated;
import com.fasterxml.jackson.core.JsonPointer;
import com.reprezen.jsonoverlay.JsonOverlay;
import com.reprezen.jsonoverlay.ReferenceManager;
import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.jsonoverlay.BooleanOverlay;
import com.modelsolv.reprezen.realization.model.*;
import java.util.stream.Collectors;
import com.reprezen.jsonoverlay.OverlayFactory;

public class PrimitivePropertySelectorImpl extends PropertyTypeSelectorImpl implements PrimitivePropertySelector {

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public PrimitivePropertySelectorImpl(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
        super(json, parent, refMgr);
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public PrimitivePropertySelectorImpl(PrimitivePropertySelector primitivePropertySelector, JsonOverlay<?> parent, ReferenceManager refMgr) {
        super(primitivePropertySelector, parent, refMgr);
    }

    // IsKey
    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public Boolean getIsKey() {
        return _get("isKey", Boolean.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public boolean isKey() {
        Boolean bool = _get("isKey", Boolean.class);
        return bool != null ? bool : false;
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public void setIsKey(Boolean isKey) {
        _setScalar("isKey", isKey, Boolean.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    protected void _elaborateJson() {
        super._elaborateJson();
        _createScalar("isKey", "isKey", BooleanOverlay.factory);
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public static OverlayFactory<PrimitivePropertySelector> factory = new OverlayFactory<PrimitivePropertySelector>() {

        @Override
        protected Class<? extends JsonOverlay<? super PrimitivePropertySelector>> getOverlayClass() {
            return PrimitivePropertySelectorImpl.class;
        }

        @Override
        public JsonOverlay<PrimitivePropertySelector> _create(PrimitivePropertySelector primitivePropertySelector, JsonOverlay<?> parent, ReferenceManager refMgr) {
            JsonOverlay<?> overlay;
            overlay = new PrimitivePropertySelectorImpl(primitivePropertySelector, parent, refMgr);
            @SuppressWarnings("unchecked") JsonOverlay<PrimitivePropertySelector> castOverlay = (JsonOverlay<PrimitivePropertySelector>) overlay;
            return castOverlay;
        }

        @Override
        public JsonOverlay<PrimitivePropertySelector> _create(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
            JsonOverlay<?> overlay;
            overlay = new PrimitivePropertySelectorImpl(json, parent, refMgr);
            @SuppressWarnings("unchecked") JsonOverlay<PrimitivePropertySelector> castOverlay = (JsonOverlay<PrimitivePropertySelector>) overlay;
            return castOverlay;
        }

        @Override
        protected boolean isExtendedType() {
            return false;
        }
    };

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    private static Class<? extends PrimitivePropertySelector> getSubtypeOf(PrimitivePropertySelector primitivePropertySelector) {
        return PrimitivePropertySelector.class;
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    private static Class<? extends PrimitivePropertySelector> getSubtypeOf(JsonNode json) {
        return PrimitivePropertySelector.class;
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    protected OverlayFactory<?> _getFactory() {
        return factory;
    }
}
