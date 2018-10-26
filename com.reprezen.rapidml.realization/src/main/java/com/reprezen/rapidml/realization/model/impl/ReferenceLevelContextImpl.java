package com.reprezen.rapidml.realization.model.impl;

import javax.annotation.Generated;
import com.fasterxml.jackson.core.JsonPointer;
import com.reprezen.jsonoverlay.JsonOverlay;
import com.reprezen.jsonoverlay.ReferenceManager;
import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.rapidml.realization.model.*;
import java.util.stream.Collectors;
import com.reprezen.jsonoverlay.OverlayFactory;

public class ReferenceLevelContextImpl extends BaseImpl implements ReferenceLevelContext {

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public ReferenceLevelContextImpl(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
        super(json, parent, refMgr);
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public ReferenceLevelContextImpl(ReferenceLevelContext referenceLevelContext, JsonOverlay<?> parent, ReferenceManager refMgr) {
        super(referenceLevelContext, parent, refMgr);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    protected void _elaborateJson() {
        super._elaborateJson();
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public static OverlayFactory<ReferenceLevelContext> factory = new OverlayFactory<ReferenceLevelContext>() {

        @Override
        protected Class<? extends JsonOverlay<? super ReferenceLevelContext>> getOverlayClass() {
            return ReferenceLevelContextImpl.class;
        }

        @Override
        public JsonOverlay<ReferenceLevelContext> _create(ReferenceLevelContext referenceLevelContext, JsonOverlay<?> parent, ReferenceManager refMgr) {
            JsonOverlay<?> overlay;
            Class<? extends ReferenceLevelContext> subtype = getSubtypeOf(referenceLevelContext);
            switch(subtype != null ? subtype.getSimpleName() : "") {
                case "RootObjectContext":
                    overlay = RootObjectContextImpl.factory.create((RootObjectContext) referenceLevelContext, parent, refMgr);
                    break;
                case "ReferencePropertyContext":
                    overlay = ReferencePropertyContextImpl.factory.create((ReferencePropertyContext) referenceLevelContext, parent, refMgr);
                    break;
                default:
                    overlay = new ReferenceLevelContextImpl((ReferenceLevelContext) referenceLevelContext, parent, refMgr);
            }
            @SuppressWarnings("unchecked") JsonOverlay<ReferenceLevelContext> castOverlay = (JsonOverlay<ReferenceLevelContext>) overlay;
            return castOverlay;
        }

        @Override
        public JsonOverlay<ReferenceLevelContext> _create(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
            JsonOverlay<?> overlay;
            Class<? extends ReferenceLevelContext> subtype = getSubtypeOf(json);
            switch(subtype != null ? subtype.getSimpleName() : "") {
                case "RootObjectContext":
                    overlay = RootObjectContextImpl.factory.create(json, parent, refMgr);
                    break;
                case "ReferencePropertyContext":
                    overlay = ReferencePropertyContextImpl.factory.create(json, parent, refMgr);
                    break;
                default:
                    overlay = new ReferenceLevelContextImpl(json, parent, refMgr);
            }
            @SuppressWarnings("unchecked") JsonOverlay<ReferenceLevelContext> castOverlay = (JsonOverlay<ReferenceLevelContext>) overlay;
            return castOverlay;
        }

        @Override
        protected boolean isExtendedType() {
            return true;
        }
    };

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    private static Class<? extends ReferenceLevelContext> getSubtypeOf(ReferenceLevelContext referenceLevelContext) {
        switch(referenceLevelContext.getClass().getSimpleName()) {
            case "RootObjectContext":
                return RootObjectContext.class;
            case "ReferencePropertyContext":
                return ReferencePropertyContext.class;
            case "ReferenceLevelContext":
                return ReferenceLevelContext.class;
            default:
                return null;
        }
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    private static Class<? extends ReferenceLevelContext> getSubtypeOf(JsonNode json) {
        switch(json.at(JsonPointer.compile("/_type")).asText()) {
            case "RootObjectContext":
                return RootObjectContext.class;
            case "ReferencePropertyContext":
                return ReferencePropertyContext.class;
            case "ReferenceLevelContext":
                return ReferenceLevelContext.class;
            default:
                return null;
        }
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    protected OverlayFactory<?> _getFactory() {
        return factory;
    }
}
