package com.reprezen.realization.model.impl;

import com.reprezen.jsonoverlay.StringOverlay;
import com.reprezen.realization.model.impl.TargetResourceTypeImpl;
import javax.annotation.Generated;
import com.fasterxml.jackson.core.JsonPointer;
import com.reprezen.jsonoverlay.JsonOverlay;
import com.reprezen.jsonoverlay.ReferenceManager;
import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.realization.model.*;
import java.util.stream.Collectors;
import com.reprezen.jsonoverlay.OverlayFactory;

public class LinkSpecImpl extends LinkStrategyImpl implements LinkSpec {

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public LinkSpecImpl(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
        super(json, parent, refMgr);
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public LinkSpecImpl(LinkSpec linkSpec, JsonOverlay<?> parent, ReferenceManager refMgr) {
        super(linkSpec, parent, refMgr);
    }

    // TargetResourceType
    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public TargetResourceType getTargetResourceType() {
        return _get("targetResourceType", TargetResourceType.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public TargetResourceType getTargetResourceType(boolean elaborate) {
        return _get("targetResourceType", elaborate, TargetResourceType.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public void setTargetResourceType(TargetResourceType targetResourceType) {
        _setScalar("targetResourceType", targetResourceType, TargetResourceType.class);
    }

    // LinkRelation
    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public String getLinkRelation() {
        return _get("linkRelation", String.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public void setLinkRelation(String linkRelation) {
        _setScalar("linkRelation", linkRelation, String.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    protected void _elaborateJson() {
        super._elaborateJson();
        _createScalar("targetResourceType", "targetResourceType", TargetResourceTypeImpl.factory);
        _createScalar("linkRelation", "linkRelation", StringOverlay.factory);
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public static OverlayFactory<LinkSpec> factory = new OverlayFactory<LinkSpec>() {

        @Override
        protected Class<? extends JsonOverlay<? super LinkSpec>> getOverlayClass() {
            return LinkSpecImpl.class;
        }

        @Override
        public JsonOverlay<LinkSpec> _create(LinkSpec linkSpec, JsonOverlay<?> parent, ReferenceManager refMgr) {
            JsonOverlay<?> overlay;
            overlay = new LinkSpecImpl(linkSpec, parent, refMgr);
            @SuppressWarnings("unchecked") JsonOverlay<LinkSpec> castOverlay = (JsonOverlay<LinkSpec>) overlay;
            return castOverlay;
        }

        @Override
        public JsonOverlay<LinkSpec> _create(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
            JsonOverlay<?> overlay;
            overlay = new LinkSpecImpl(json, parent, refMgr);
            @SuppressWarnings("unchecked") JsonOverlay<LinkSpec> castOverlay = (JsonOverlay<LinkSpec>) overlay;
            return castOverlay;
        }

        @Override
        protected boolean isExtendedType() {
            return false;
        }
    };

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    private static Class<? extends LinkSpec> getSubtypeOf(LinkSpec linkSpec) {
        return LinkSpec.class;
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    private static Class<? extends LinkSpec> getSubtypeOf(JsonNode json) {
        return LinkSpec.class;
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    protected OverlayFactory<?> _getFactory() {
        return factory;
    }
}
