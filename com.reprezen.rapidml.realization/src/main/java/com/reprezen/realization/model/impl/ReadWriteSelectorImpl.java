package com.reprezen.realization.model.impl;

import javax.annotation.Generated;
import com.reprezen.jsonoverlay.JsonOverlay;
import com.reprezen.jsonoverlay.ReferenceManager;
import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.realization.model.*;
import com.reprezen.jsonoverlay.EnumOverlay;
import com.reprezen.jsonoverlay.OverlayFactory;

public class ReadWriteSelectorImpl extends EnumOverlay<ReadWriteSelector> {

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public ReadWriteSelectorImpl(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
        super(json, parent, factory, refMgr);
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public ReadWriteSelectorImpl(ReadWriteSelector readWriteSelector, JsonOverlay<?> parent, ReferenceManager refMgr) {
        super(readWriteSelector, parent, factory, refMgr);
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    protected Class<ReadWriteSelector> getEnumClass() {
        return ReadWriteSelector.class;
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public static OverlayFactory<ReadWriteSelector> factory = new OverlayFactory<ReadWriteSelector>() {

        @Override
        protected Class<? extends JsonOverlay<? super ReadWriteSelector>> getOverlayClass() {
            return ReadWriteSelectorImpl.class;
        }

        @Override
        public JsonOverlay<ReadWriteSelector> _create(ReadWriteSelector readWriteSelector, JsonOverlay<?> parent, ReferenceManager refMgr) {
            return new ReadWriteSelectorImpl(readWriteSelector, parent, refMgr);
        }

        @Override
        public JsonOverlay<ReadWriteSelector> _create(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
            return new ReadWriteSelectorImpl(json, parent, refMgr);
        }
    };

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    protected OverlayFactory<?> _getFactory() {
        return factory;
    }
}
