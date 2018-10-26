package com.reprezen.realization.model.impl;

import java.util.Collection;
import com.reprezen.realization.model.impl.LinkStrategyImpl;
import com.reprezen.realization.model.impl.ConditionsImpl;
import java.util.stream.Collectors;
import com.reprezen.jsonoverlay.OverlayFactory;
import javax.annotation.Generated;
import com.fasterxml.jackson.core.JsonPointer;
import com.reprezen.realization.model.ConditionedItem;
import com.reprezen.jsonoverlay.JsonOverlay;
import com.reprezen.jsonoverlay.ReferenceManager;
import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.realization.model.*;
import java.util.Collections;

public class ConditionalLinkImpl extends LinkStrategyImpl implements ConditionalLink {

    @Override
    public Collection<Conditions> getConditions() {
        return Collections.singletonList(getWhere());
    }

    @Override
    public boolean noConditionsResult() {
        return true;
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public ConditionalLinkImpl(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
        super(json, parent, refMgr);
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public ConditionalLinkImpl(ConditionalLink conditionalLink, JsonOverlay<?> parent, ReferenceManager refMgr) {
        super(conditionalLink, parent, refMgr);
    }

    // Where
    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public Conditions getWhere() {
        return _get("where", Conditions.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public Conditions getWhere(boolean elaborate) {
        return _get("where", elaborate, Conditions.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public void setWhere(Conditions where) {
        _setScalar("where", where, Conditions.class);
    }

    // Link
    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public LinkStrategy getLink() {
        return _get("link", LinkStrategy.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public LinkStrategy getLink(boolean elaborate) {
        return _get("link", elaborate, LinkStrategy.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public void setLink(LinkStrategy link) {
        _setScalar("link", link, LinkStrategy.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    protected void _elaborateJson() {
        super._elaborateJson();
        _createScalar("where", "where", ConditionsImpl.factory);
        _createScalar("link", "link", LinkStrategyImpl.factory);
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public static OverlayFactory<ConditionalLink> factory = new OverlayFactory<ConditionalLink>() {

        @Override
        protected Class<? extends JsonOverlay<? super ConditionalLink>> getOverlayClass() {
            return ConditionalLinkImpl.class;
        }

        @Override
        public JsonOverlay<ConditionalLink> _create(ConditionalLink conditionalLink, JsonOverlay<?> parent, ReferenceManager refMgr) {
            JsonOverlay<?> overlay;
            overlay = new ConditionalLinkImpl(conditionalLink, parent, refMgr);
            @SuppressWarnings("unchecked") JsonOverlay<ConditionalLink> castOverlay = (JsonOverlay<ConditionalLink>) overlay;
            return castOverlay;
        }

        @Override
        public JsonOverlay<ConditionalLink> _create(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
            JsonOverlay<?> overlay;
            overlay = new ConditionalLinkImpl(json, parent, refMgr);
            @SuppressWarnings("unchecked") JsonOverlay<ConditionalLink> castOverlay = (JsonOverlay<ConditionalLink>) overlay;
            return castOverlay;
        }

        @Override
        protected boolean isExtendedType() {
            return false;
        }
    };

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    private static Class<? extends ConditionalLink> getSubtypeOf(ConditionalLink conditionalLink) {
        return ConditionalLink.class;
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    private static Class<? extends ConditionalLink> getSubtypeOf(JsonNode json) {
        return ConditionalLink.class;
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    protected OverlayFactory<?> _getFactory() {
        return factory;
    }
}
