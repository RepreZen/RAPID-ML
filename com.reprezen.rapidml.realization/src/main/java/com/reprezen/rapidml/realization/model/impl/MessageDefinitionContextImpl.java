package com.reprezen.rapidml.realization.model.impl;

import javax.annotation.Generated;

import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.jsonoverlay.JsonOverlay;
import com.reprezen.jsonoverlay.OverlayFactory;
import com.reprezen.jsonoverlay.ReferenceManager;
import com.reprezen.rapidml.realization.model.MessageDefinitionContext;
import com.reprezen.rapidml.realization.model.MessageTypeSelector;
import com.reprezen.rapidml.realization.model.MethodTypeSelector;

public class MessageDefinitionContextImpl extends DefinitionContextImpl implements MessageDefinitionContext {

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public MessageDefinitionContextImpl(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(json, parent, refMgr);
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public MessageDefinitionContextImpl(MessageDefinitionContext messageDefinitionContext, JsonOverlay<?> parent,
			ReferenceManager refMgr) {
		super(messageDefinitionContext, parent, refMgr);
	}

	// MethodType
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public MethodTypeSelector getMethodType() {
		return _get("methodType", MethodTypeSelector.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public MethodTypeSelector getMethodType(boolean elaborate) {
		return _get("methodType", elaborate, MethodTypeSelector.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setMethodType(MethodTypeSelector methodType) {
		_setScalar("methodType", methodType, MethodTypeSelector.class);
	}

	// MessageType
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public MessageTypeSelector getMessageType() {
		return _get("messageType", MessageTypeSelector.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public MessageTypeSelector getMessageType(boolean elaborate) {
		return _get("messageType", elaborate, MessageTypeSelector.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setMessageType(MessageTypeSelector messageType) {
		_setScalar("messageType", messageType, MessageTypeSelector.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	protected void _elaborateJson() {
		super._elaborateJson();
		_createScalar("methodType", "methodType", MethodTypeSelectorImpl.factory);
		_createScalar("messageType", "messageType", MessageTypeSelectorImpl.factory);
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static OverlayFactory<MessageDefinitionContext> factory = new OverlayFactory<MessageDefinitionContext>() {

		@Override
		protected Class<? extends JsonOverlay<? super MessageDefinitionContext>> getOverlayClass() {
			return MessageDefinitionContextImpl.class;
		}

		@Override
		public JsonOverlay<MessageDefinitionContext> _create(MessageDefinitionContext messageDefinitionContext,
				JsonOverlay<?> parent, ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new MessageDefinitionContextImpl(messageDefinitionContext, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<MessageDefinitionContext> castOverlay = (JsonOverlay<MessageDefinitionContext>) overlay;
			return castOverlay;
		}

		@Override
		public JsonOverlay<MessageDefinitionContext> _create(JsonNode json, JsonOverlay<?> parent,
				ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new MessageDefinitionContextImpl(json, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<MessageDefinitionContext> castOverlay = (JsonOverlay<MessageDefinitionContext>) overlay;
			return castOverlay;
		}

		@Override
		protected boolean isExtendedType() {
			return false;
		}
	};

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private static Class<? extends MessageDefinitionContext> getSubtypeOf(
			MessageDefinitionContext messageDefinitionContext) {
		return MessageDefinitionContext.class;
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private static Class<? extends MessageDefinitionContext> getSubtypeOf(JsonNode json) {
		return MessageDefinitionContext.class;
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	protected OverlayFactory<?> _getFactory() {
		return factory;
	}
}
