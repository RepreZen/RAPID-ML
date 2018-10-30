package com.reprezen.rapidml.realization.model.impl;

import javax.annotation.Generated;
import com.reprezen.jsonoverlay.JsonOverlay;
import com.reprezen.jsonoverlay.ReferenceManager;
import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.rapidml.realization.model.*;
import com.reprezen.jsonoverlay.EnumOverlay;
import com.reprezen.jsonoverlay.OverlayFactory;

public class MessageTypeSelectorImpl extends EnumOverlay<MessageTypeSelector> {

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public MessageTypeSelectorImpl(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
        super(json, parent, factory, refMgr);
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public MessageTypeSelectorImpl(MessageTypeSelector messageTypeSelector, JsonOverlay<?> parent, ReferenceManager refMgr) {
        super(messageTypeSelector, parent, factory, refMgr);
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    protected Class<MessageTypeSelector> getEnumClass() {
        return MessageTypeSelector.class;
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public static OverlayFactory<MessageTypeSelector> factory = new OverlayFactory<MessageTypeSelector>() {

        @Override
        protected Class<? extends JsonOverlay<? super MessageTypeSelector>> getOverlayClass() {
            return MessageTypeSelectorImpl.class;
        }

        @Override
        public JsonOverlay<MessageTypeSelector> _create(MessageTypeSelector messageTypeSelector, JsonOverlay<?> parent, ReferenceManager refMgr) {
            return new MessageTypeSelectorImpl(messageTypeSelector, parent, refMgr);
        }

        @Override
        public JsonOverlay<MessageTypeSelector> _create(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
            return new MessageTypeSelectorImpl(json, parent, refMgr);
        }
    };

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    protected OverlayFactory<?> _getFactory() {
        return factory;
    }
}
