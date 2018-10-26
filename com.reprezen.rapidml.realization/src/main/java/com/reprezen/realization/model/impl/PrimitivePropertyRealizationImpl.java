package com.reprezen.realization.model.impl;

import javax.annotation.Generated;
import com.fasterxml.jackson.core.JsonPointer;
import com.reprezen.jsonoverlay.JsonOverlay;
import com.reprezen.jsonoverlay.ReferenceManager;
import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.jsonoverlay.BooleanOverlay;
import com.reprezen.realization.model.*;
import java.util.stream.Collectors;
import com.reprezen.jsonoverlay.OverlayFactory;

public class PrimitivePropertyRealizationImpl extends PropertyTypeRealizationImpl implements PrimitivePropertyRealization {

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public PrimitivePropertyRealizationImpl(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
        super(json, parent, refMgr);
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public PrimitivePropertyRealizationImpl(PrimitivePropertyRealization primitivePropertyRealization, JsonOverlay<?> parent, ReferenceManager refMgr) {
        super(primitivePropertyRealization, parent, refMgr);
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
    public static OverlayFactory<PrimitivePropertyRealization> factory = new OverlayFactory<PrimitivePropertyRealization>() {

        @Override
        protected Class<? extends JsonOverlay<? super PrimitivePropertyRealization>> getOverlayClass() {
            return PrimitivePropertyRealizationImpl.class;
        }

        @Override
        public JsonOverlay<PrimitivePropertyRealization> _create(PrimitivePropertyRealization primitivePropertyRealization, JsonOverlay<?> parent, ReferenceManager refMgr) {
            JsonOverlay<?> overlay;
            overlay = new PrimitivePropertyRealizationImpl(primitivePropertyRealization, parent, refMgr);
            @SuppressWarnings("unchecked") JsonOverlay<PrimitivePropertyRealization> castOverlay = (JsonOverlay<PrimitivePropertyRealization>) overlay;
            return castOverlay;
        }

        @Override
        public JsonOverlay<PrimitivePropertyRealization> _create(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
            JsonOverlay<?> overlay;
            overlay = new PrimitivePropertyRealizationImpl(json, parent, refMgr);
            @SuppressWarnings("unchecked") JsonOverlay<PrimitivePropertyRealization> castOverlay = (JsonOverlay<PrimitivePropertyRealization>) overlay;
            return castOverlay;
        }

        @Override
        protected boolean isExtendedType() {
            return false;
        }
    };

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    private static Class<? extends PrimitivePropertyRealization> getSubtypeOf(PrimitivePropertyRealization primitivePropertyRealization) {
        return PrimitivePropertyRealization.class;
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    private static Class<? extends PrimitivePropertyRealization> getSubtypeOf(JsonNode json) {
        return PrimitivePropertyRealization.class;
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    protected OverlayFactory<?> _getFactory() {
        return factory;
    }
}
