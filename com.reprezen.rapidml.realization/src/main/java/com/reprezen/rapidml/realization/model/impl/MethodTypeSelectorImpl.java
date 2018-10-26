package com.reprezen.rapidml.realization.model.impl;

import javax.annotation.Generated;
import com.reprezen.jsonoverlay.JsonOverlay;
import com.reprezen.jsonoverlay.ReferenceManager;
import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.rapidml.realization.model.*;
import com.reprezen.jsonoverlay.EnumOverlay;
import com.reprezen.jsonoverlay.OverlayFactory;

public class MethodTypeSelectorImpl extends EnumOverlay<MethodTypeSelector> {

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public MethodTypeSelectorImpl(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
        super(json, parent, factory, refMgr);
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public MethodTypeSelectorImpl(MethodTypeSelector methodTypeSelector, JsonOverlay<?> parent, ReferenceManager refMgr) {
        super(methodTypeSelector, parent, factory, refMgr);
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    protected Class<MethodTypeSelector> getEnumClass() {
        return MethodTypeSelector.class;
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public static OverlayFactory<MethodTypeSelector> factory = new OverlayFactory<MethodTypeSelector>() {

        @Override
        protected Class<? extends JsonOverlay<? super MethodTypeSelector>> getOverlayClass() {
            return MethodTypeSelectorImpl.class;
        }

        @Override
        public JsonOverlay<MethodTypeSelector> _create(MethodTypeSelector methodTypeSelector, JsonOverlay<?> parent, ReferenceManager refMgr) {
            return new MethodTypeSelectorImpl(methodTypeSelector, parent, refMgr);
        }

        @Override
        public JsonOverlay<MethodTypeSelector> _create(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
            return new MethodTypeSelectorImpl(json, parent, refMgr);
        }
    };

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    protected OverlayFactory<?> _getFactory() {
        return factory;
    }
}
