package com.reprezen.rapidml.realization.model.impl;

import javax.annotation.Generated;
import com.fasterxml.jackson.core.JsonPointer;
import java.util.Collection;
import com.reprezen.jsonoverlay.JsonOverlay;
import com.reprezen.jsonoverlay.ReferenceManager;
import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.rapidml.realization.model.*;
import java.util.stream.Collectors;
import java.util.Collections;
import com.reprezen.jsonoverlay.OverlayFactory;

public class LinkStrategyImpl extends BaseImpl implements LinkStrategy {

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public LinkStrategyImpl(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
        super(json, parent, refMgr);
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public LinkStrategyImpl(LinkStrategy linkStrategy, JsonOverlay<?> parent, ReferenceManager refMgr) {
        super(linkStrategy, parent, refMgr);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    protected void _elaborateJson() {
        super._elaborateJson();
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public static OverlayFactory<LinkStrategy> factory = new OverlayFactory<LinkStrategy>() {

        @Override
        protected Class<? extends JsonOverlay<? super LinkStrategy>> getOverlayClass() {
            return LinkStrategyImpl.class;
        }

        @Override
        public JsonOverlay<LinkStrategy> _create(LinkStrategy linkStrategy, JsonOverlay<?> parent, ReferenceManager refMgr) {
            JsonOverlay<?> overlay;
            Class<? extends LinkStrategy> subtype = getSubtypeOf(linkStrategy);
            switch(subtype != null ? subtype.getSimpleName() : "") {
                case "ConditionalLink":
                    overlay = ConditionalLinkImpl.factory.create((ConditionalLink) linkStrategy, parent, refMgr);
                    break;
                case "LinkSwitch":
                    overlay = LinkSwitchImpl.factory.create((LinkSwitch) linkStrategy, parent, refMgr);
                    break;
                case "LinkSpec":
                    overlay = LinkSpecImpl.factory.create((LinkSpec) linkStrategy, parent, refMgr);
                    break;
                default:
                    overlay = new LinkStrategyImpl((LinkStrategy) linkStrategy, parent, refMgr);
            }
            @SuppressWarnings("unchecked") JsonOverlay<LinkStrategy> castOverlay = (JsonOverlay<LinkStrategy>) overlay;
            return castOverlay;
        }

        @Override
        public JsonOverlay<LinkStrategy> _create(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
            JsonOverlay<?> overlay;
            Class<? extends LinkStrategy> subtype = getSubtypeOf(json);
            switch(subtype != null ? subtype.getSimpleName() : "") {
                case "ConditionalLink":
                    overlay = ConditionalLinkImpl.factory.create(json, parent, refMgr);
                    break;
                case "LinkSwitch":
                    overlay = LinkSwitchImpl.factory.create(json, parent, refMgr);
                    break;
                case "LinkSpec":
                    overlay = LinkSpecImpl.factory.create(json, parent, refMgr);
                    break;
                default:
                    overlay = new LinkStrategyImpl(json, parent, refMgr);
            }
            @SuppressWarnings("unchecked") JsonOverlay<LinkStrategy> castOverlay = (JsonOverlay<LinkStrategy>) overlay;
            return castOverlay;
        }

        @Override
        protected boolean isExtendedType() {
            return true;
        }
    };

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    private static Class<? extends LinkStrategy> getSubtypeOf(LinkStrategy linkStrategy) {
        switch(linkStrategy.getClass().getSimpleName()) {
            case "ConditionalLink":
                return ConditionalLink.class;
            case "LinkSwitch":
                return LinkSwitch.class;
            case "LinkSpec":
                return LinkSpec.class;
            default:
                return null;
        }
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    private static Class<? extends LinkStrategy> getSubtypeOf(JsonNode json) {
        switch(json.at(JsonPointer.compile("/strategy")).asText()) {
            case "conditional":
                return ConditionalLink.class;
            case "switch":
                return LinkSwitch.class;
            case "specification":
                return LinkSpec.class;
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
