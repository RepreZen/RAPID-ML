package com.reprezen.realization.model.impl;

import javax.annotation.Generated;
import com.reprezen.jsonoverlay.JsonOverlay;
import com.reprezen.jsonoverlay.ReferenceManager;
import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.realization.model.*;
import com.reprezen.jsonoverlay.EnumOverlay;
import com.reprezen.jsonoverlay.OverlayFactory;

public class MultiplicitySelectorImpl extends EnumOverlay<MultiplicitySelector> {

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public MultiplicitySelectorImpl(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
        super(json, parent, factory, refMgr);
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public MultiplicitySelectorImpl(MultiplicitySelector multiplicitySelector, JsonOverlay<?> parent, ReferenceManager refMgr) {
        super(multiplicitySelector, parent, factory, refMgr);
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    protected Class<MultiplicitySelector> getEnumClass() {
        return MultiplicitySelector.class;
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public static OverlayFactory<MultiplicitySelector> factory = new OverlayFactory<MultiplicitySelector>() {

        @Override
        protected Class<? extends JsonOverlay<? super MultiplicitySelector>> getOverlayClass() {
            return MultiplicitySelectorImpl.class;
        }

        @Override
        public JsonOverlay<MultiplicitySelector> _create(MultiplicitySelector multiplicitySelector, JsonOverlay<?> parent, ReferenceManager refMgr) {
            return new MultiplicitySelectorImpl(multiplicitySelector, parent, refMgr);
        }

        @Override
        public JsonOverlay<MultiplicitySelector> _create(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
            return new MultiplicitySelectorImpl(json, parent, refMgr);
        }
    };

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    protected OverlayFactory<?> _getFactory() {
        return factory;
    }
}
