package com.reprezen.rapidml.realization.model.impl;

import javax.annotation.Generated;
import com.fasterxml.jackson.core.JsonPointer;
import com.reprezen.jsonoverlay.JsonOverlay;
import com.reprezen.jsonoverlay.ReferenceManager;
import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.rapidml.realization.model.*;
import java.util.stream.Collectors;
import com.reprezen.jsonoverlay.OverlayFactory;

public class ObjectRealizationStrategyImpl extends BaseImpl implements ObjectRealizationStrategy {

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public ObjectRealizationStrategyImpl(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
        super(json, parent, refMgr);
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public ObjectRealizationStrategyImpl(ObjectRealizationStrategy objectRealizationStrategy, JsonOverlay<?> parent, ReferenceManager refMgr) {
        super(objectRealizationStrategy, parent, refMgr);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    protected void _elaborateJson() {
        super._elaborateJson();
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public static OverlayFactory<ObjectRealizationStrategy> factory = new OverlayFactory<ObjectRealizationStrategy>() {

        @Override
        protected Class<? extends JsonOverlay<? super ObjectRealizationStrategy>> getOverlayClass() {
            return ObjectRealizationStrategyImpl.class;
        }

        @Override
        public JsonOverlay<ObjectRealizationStrategy> _create(ObjectRealizationStrategy objectRealizationStrategy, JsonOverlay<?> parent, ReferenceManager refMgr) {
            JsonOverlay<?> overlay;
            Class<? extends ObjectRealizationStrategy> subtype = getSubtypeOf(objectRealizationStrategy);
            switch(subtype != null ? subtype.getSimpleName() : "") {
                case "ObjectRealizationSpec":
                    overlay = ObjectRealizationSpecImpl.factory.create((ObjectRealizationSpec) objectRealizationStrategy, parent, refMgr);
                    break;
                default:
                    overlay = new ObjectRealizationStrategyImpl((ObjectRealizationStrategy) objectRealizationStrategy, parent, refMgr);
            }
            @SuppressWarnings("unchecked") JsonOverlay<ObjectRealizationStrategy> castOverlay = (JsonOverlay<ObjectRealizationStrategy>) overlay;
            return castOverlay;
        }

        @Override
        public JsonOverlay<ObjectRealizationStrategy> _create(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
            JsonOverlay<?> overlay;
            Class<? extends ObjectRealizationStrategy> subtype = getSubtypeOf(json);
            switch(subtype != null ? subtype.getSimpleName() : "") {
                case "ObjectRealizationSpec":
                    overlay = ObjectRealizationSpecImpl.factory.create(json, parent, refMgr);
                    break;
                default:
                    overlay = new ObjectRealizationStrategyImpl(json, parent, refMgr);
            }
            @SuppressWarnings("unchecked") JsonOverlay<ObjectRealizationStrategy> castOverlay = (JsonOverlay<ObjectRealizationStrategy>) overlay;
            return castOverlay;
        }

        @Override
        protected boolean isExtendedType() {
            return true;
        }
    };

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    private static Class<? extends ObjectRealizationStrategy> getSubtypeOf(ObjectRealizationStrategy objectRealizationStrategy) {
        switch(objectRealizationStrategy.getClass().getSimpleName()) {
            case "ObjectRealizationStrategy":
                return ObjectRealizationStrategy.class;
            case "ObjectRealizationSpec":
                return ObjectRealizationSpec.class;
            default:
                return null;
        }
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    private static Class<? extends ObjectRealizationStrategy> getSubtypeOf(JsonNode json) {
        switch(json.at(JsonPointer.compile("/_type")).asText()) {
            case "ObjectRealizationStrategy":
                return ObjectRealizationStrategy.class;
            case "ObjectRealizationSpec":
                return ObjectRealizationSpec.class;
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
