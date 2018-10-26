package com.reprezen.realization.model.impl;

import javax.annotation.Generated;
import com.reprezen.jsonoverlay.JsonOverlay;
import com.reprezen.jsonoverlay.ReferenceManager;
import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.realization.model.*;
import com.reprezen.jsonoverlay.EnumOverlay;
import com.reprezen.jsonoverlay.OverlayFactory;

public class ContainmentSelectorImpl extends EnumOverlay<ContainmentSelector> {

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public ContainmentSelectorImpl(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
        super(json, parent, factory, refMgr);
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public ContainmentSelectorImpl(ContainmentSelector containmentSelector, JsonOverlay<?> parent, ReferenceManager refMgr) {
        super(containmentSelector, parent, factory, refMgr);
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    protected Class<ContainmentSelector> getEnumClass() {
        return ContainmentSelector.class;
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public static OverlayFactory<ContainmentSelector> factory = new OverlayFactory<ContainmentSelector>() {

        @Override
        protected Class<? extends JsonOverlay<? super ContainmentSelector>> getOverlayClass() {
            return ContainmentSelectorImpl.class;
        }

        @Override
        public JsonOverlay<ContainmentSelector> _create(ContainmentSelector containmentSelector, JsonOverlay<?> parent, ReferenceManager refMgr) {
            return new ContainmentSelectorImpl(containmentSelector, parent, refMgr);
        }

        @Override
        public JsonOverlay<ContainmentSelector> _create(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
            return new ContainmentSelectorImpl(json, parent, refMgr);
        }
    };

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    protected OverlayFactory<?> _getFactory() {
        return factory;
    }
}
