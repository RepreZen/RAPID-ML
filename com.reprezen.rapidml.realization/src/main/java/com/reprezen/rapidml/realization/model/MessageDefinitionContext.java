package com.reprezen.rapidml.realization.model;

import javax.annotation.Generated;

public interface MessageDefinitionContext extends DefinitionContext {

	// MethodType
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	MethodTypeSelector getMethodType();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	MethodTypeSelector getMethodType(boolean elaborate);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setMethodType(MethodTypeSelector methodType);

	// MessageType
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	MessageTypeSelector getMessageType();

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	MessageTypeSelector getMessageType(boolean elaborate);

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	void setMessageType(MessageTypeSelector messageType);
}
