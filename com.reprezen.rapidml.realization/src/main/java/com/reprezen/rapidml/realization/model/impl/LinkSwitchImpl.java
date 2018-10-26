package com.reprezen.rapidml.realization.model.impl;

import java.util.Collection;
import java.util.stream.Collectors;
import com.reprezen.jsonoverlay.OverlayFactory;
import javax.annotation.Generated;
import java.util.List;
import com.fasterxml.jackson.core.JsonPointer;
import com.reprezen.rapidml.realization.model.Switchable;
import com.reprezen.jsonoverlay.JsonOverlay;
import com.reprezen.rapidml.realization.model.impl.ConditionalLinkImpl;
import com.reprezen.jsonoverlay.ReferenceManager;
import com.reprezen.jsonoverlay.ListOverlay;
import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.rapidml.realization.model.*;

public class LinkSwitchImpl extends LinkStrategyImpl implements LinkSwitch {

    @Override
    public Collection<ConditionalLink> getCandidates() {
        return getLinkCases();
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public LinkSwitchImpl(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
        super(json, parent, refMgr);
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public LinkSwitchImpl(LinkSwitch linkSwitch, JsonOverlay<?> parent, ReferenceManager refMgr) {
        super(linkSwitch, parent, refMgr);
    }

    // LinkCase
    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public List<ConditionalLink> getLinkCases() {
        return _getList("linkCases", ConditionalLink.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public List<ConditionalLink> getLinkCases(boolean elaborate) {
        return _getList("linkCases", elaborate, ConditionalLink.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public boolean hasLinkCases() {
        return _isPresent("linkCases");
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public ConditionalLink getLinkCase(int index) {
        return _get("linkCases", index, ConditionalLink.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public void setLinkCases(List<ConditionalLink> linkCases) {
        _setList("linkCases", linkCases, ConditionalLink.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public void setLinkCase(int index, ConditionalLink linkCase) {
        _set("linkCases", index, linkCase, ConditionalLink.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public void addLinkCase(ConditionalLink linkCase) {
        _add("linkCases", linkCase, ConditionalLink.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public void insertLinkCase(int index, ConditionalLink linkCase) {
        _insert("linkCases", index, linkCase, ConditionalLink.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public void removeLinkCase(int index) {
        _remove("linkCases", index, ConditionalLink.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    protected void _elaborateJson() {
        super._elaborateJson();
        _createList("linkCases", "cases", ConditionalLinkImpl.factory);
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public static OverlayFactory<LinkSwitch> factory = new OverlayFactory<LinkSwitch>() {

        @Override
        protected Class<? extends JsonOverlay<? super LinkSwitch>> getOverlayClass() {
            return LinkSwitchImpl.class;
        }

        @Override
        public JsonOverlay<LinkSwitch> _create(LinkSwitch linkSwitch, JsonOverlay<?> parent, ReferenceManager refMgr) {
            JsonOverlay<?> overlay;
            overlay = new LinkSwitchImpl(linkSwitch, parent, refMgr);
            @SuppressWarnings("unchecked") JsonOverlay<LinkSwitch> castOverlay = (JsonOverlay<LinkSwitch>) overlay;
            return castOverlay;
        }

        @Override
        public JsonOverlay<LinkSwitch> _create(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
            JsonOverlay<?> overlay;
            overlay = new LinkSwitchImpl(json, parent, refMgr);
            @SuppressWarnings("unchecked") JsonOverlay<LinkSwitch> castOverlay = (JsonOverlay<LinkSwitch>) overlay;
            return castOverlay;
        }

        @Override
        protected boolean isExtendedType() {
            return false;
        }
    };

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    private static Class<? extends LinkSwitch> getSubtypeOf(LinkSwitch linkSwitch) {
        return LinkSwitch.class;
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    private static Class<? extends LinkSwitch> getSubtypeOf(JsonNode json) {
        return LinkSwitch.class;
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    protected OverlayFactory<?> _getFactory() {
        return factory;
    }
}
