package com.reprezen.rapidml.realization.model;

import com.reprezen.rapidml.realization.model.LinkStrategy;
import javax.annotation.Generated;
import java.util.List;
import com.reprezen.rapidml.realization.model.Switchable;
import com.reprezen.rapidml.realization.model.ConditionalLink;

public interface LinkSwitch extends LinkStrategy, Switchable<ConditionalLink> {

    // LinkCase
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    List<ConditionalLink> getLinkCases();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    List<ConditionalLink> getLinkCases(boolean elaborate);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    boolean hasLinkCases();

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    ConditionalLink getLinkCase(int index);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setLinkCases(List<ConditionalLink> linkCases);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void setLinkCase(int index, ConditionalLink linkCase);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void addLinkCase(ConditionalLink linkCase);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void insertLinkCase(int index, ConditionalLink linkCase);

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    void removeLinkCase(int index);
}
