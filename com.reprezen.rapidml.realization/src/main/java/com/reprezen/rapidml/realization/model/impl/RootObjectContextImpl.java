package com.reprezen.rapidml.realization.model.impl;

import javax.annotation.Generated;
import com.fasterxml.jackson.core.JsonPointer;
import com.reprezen.jsonoverlay.JsonOverlay;
import com.reprezen.jsonoverlay.ReferenceManager;
import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.rapidml.realization.model.*;
import java.util.stream.Collectors;
import com.reprezen.jsonoverlay.OverlayFactory;

public class RootObjectContextImpl extends ReferenceLevelContextImpl implements RootObjectContext {

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public RootObjectContextImpl(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
        super(json, parent, refMgr);
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public RootObjectContextImpl(RootObjectContext rootObjectContext, JsonOverlay<?> parent, ReferenceManager refMgr) {
        super(rootObjectContext, parent, refMgr);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    protected void _elaborateJson() {
        super._elaborateJson();
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public static OverlayFactory<RootObjectContext> factory = new OverlayFactory<RootObjectContext>() {

        @Override
        protected Class<? extends JsonOverlay<? super RootObjectContext>> getOverlayClass() {
            return RootObjectContextImpl.class;
        }

        @Override
        public JsonOverlay<RootObjectContext> _create(RootObjectContext rootObjectContext, JsonOverlay<?> parent, ReferenceManager refMgr) {
            JsonOverlay<?> overlay;
            overlay = new RootObjectContextImpl(rootObjectContext, parent, refMgr);
            @SuppressWarnings("unchecked") JsonOverlay<RootObjectContext> castOverlay = (JsonOverlay<RootObjectContext>) overlay;
            return castOverlay;
        }

        @Override
        public JsonOverlay<RootObjectContext> _create(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
            JsonOverlay<?> overlay;
            overlay = new RootObjectContextImpl(json, parent, refMgr);
            @SuppressWarnings("unchecked") JsonOverlay<RootObjectContext> castOverlay = (JsonOverlay<RootObjectContext>) overlay;
            return castOverlay;
        }

        @Override
        protected boolean isExtendedType() {
            return false;
        }
    };

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    private static Class<? extends RootObjectContext> getSubtypeOf(RootObjectContext rootObjectContext) {
        return RootObjectContext.class;
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    private static Class<? extends RootObjectContext> getSubtypeOf(JsonNode json) {
        return RootObjectContext.class;
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    protected OverlayFactory<?> _getFactory() {
        return factory;
    }
}
