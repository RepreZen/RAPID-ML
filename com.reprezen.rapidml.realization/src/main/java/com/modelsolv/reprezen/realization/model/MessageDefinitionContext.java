package com.modelsolv.reprezen.realization.model;

import javax.annotation.Generated;
import com.modelsolv.reprezen.realization.model.MethodTypeSelector;
import com.modelsolv.reprezen.realization.model.MessageTypeSelector;
import com.modelsolv.reprezen.realization.model.DefinitionContext;

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
