package com.reprezen.realization.model.impl;

import javax.annotation.Generated;
import com.fasterxml.jackson.core.JsonPointer;
import com.reprezen.jsonoverlay.JsonOverlay;
import com.reprezen.jsonoverlay.ReferenceManager;
import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.realization.model.*;
import java.util.stream.Collectors;
import com.reprezen.jsonoverlay.OverlayFactory;

public class DefinitionContextImpl extends BaseImpl implements DefinitionContext {

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public DefinitionContextImpl(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
        super(json, parent, refMgr);
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public DefinitionContextImpl(DefinitionContext definitionContext, JsonOverlay<?> parent, ReferenceManager refMgr) {
        super(definitionContext, parent, refMgr);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    protected void _elaborateJson() {
        super._elaborateJson();
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public static OverlayFactory<DefinitionContext> factory = new OverlayFactory<DefinitionContext>() {

        @Override
        protected Class<? extends JsonOverlay<? super DefinitionContext>> getOverlayClass() {
            return DefinitionContextImpl.class;
        }

        @Override
        public JsonOverlay<DefinitionContext> _create(DefinitionContext definitionContext, JsonOverlay<?> parent, ReferenceManager refMgr) {
            JsonOverlay<?> overlay;
            Class<? extends DefinitionContext> subtype = getSubtypeOf(definitionContext);
            switch(subtype != null ? subtype.getSimpleName() : "") {
                case "ResourceDefinitionContext":
                    overlay = ResourceDefinitionContextImpl.factory.create((ResourceDefinitionContext) definitionContext, parent, refMgr);
                    break;
                case "MessageDefinitionContext":
                    overlay = MessageDefinitionContextImpl.factory.create((MessageDefinitionContext) definitionContext, parent, refMgr);
                    break;
                default:
                    overlay = new DefinitionContextImpl((DefinitionContext) definitionContext, parent, refMgr);
            }
            @SuppressWarnings("unchecked") JsonOverlay<DefinitionContext> castOverlay = (JsonOverlay<DefinitionContext>) overlay;
            return castOverlay;
        }

        @Override
        public JsonOverlay<DefinitionContext> _create(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
            JsonOverlay<?> overlay;
            Class<? extends DefinitionContext> subtype = getSubtypeOf(json);
            switch(subtype != null ? subtype.getSimpleName() : "") {
                case "ResourceDefinitionContext":
                    overlay = ResourceDefinitionContextImpl.factory.create(json, parent, refMgr);
                    break;
                case "MessageDefinitionContext":
                    overlay = MessageDefinitionContextImpl.factory.create(json, parent, refMgr);
                    break;
                default:
                    overlay = new DefinitionContextImpl(json, parent, refMgr);
            }
            @SuppressWarnings("unchecked") JsonOverlay<DefinitionContext> castOverlay = (JsonOverlay<DefinitionContext>) overlay;
            return castOverlay;
        }

        @Override
        protected boolean isExtendedType() {
            return true;
        }
    };

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    private static Class<? extends DefinitionContext> getSubtypeOf(DefinitionContext definitionContext) {
        switch(definitionContext.getClass().getSimpleName()) {
            case "ResourceDefinitionContext":
                return ResourceDefinitionContext.class;
            case "MessageDefinitionContext":
                return MessageDefinitionContext.class;
            case "DefinitionContext":
                return DefinitionContext.class;
            default:
                return null;
        }
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    private static Class<? extends DefinitionContext> getSubtypeOf(JsonNode json) {
        switch(json.at(JsonPointer.compile("/_type")).asText()) {
            case "ResourceDefinitionContext":
                return ResourceDefinitionContext.class;
            case "MessageDefinitionContext":
                return MessageDefinitionContext.class;
            case "DefinitionContext":
                return DefinitionContext.class;
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
