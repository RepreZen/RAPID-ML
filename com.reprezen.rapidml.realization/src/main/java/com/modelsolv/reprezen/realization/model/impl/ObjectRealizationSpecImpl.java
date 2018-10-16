package com.modelsolv.reprezen.realization.model.impl;

import javax.annotation.Generated;
import java.util.List;
import com.fasterxml.jackson.core.JsonPointer;
import com.reprezen.jsonoverlay.JsonOverlay;
import com.reprezen.jsonoverlay.ReferenceManager;
import com.reprezen.jsonoverlay.ListOverlay;
import com.modelsolv.reprezen.realization.model.impl.LinkStrategyImpl;
import com.fasterxml.jackson.databind.JsonNode;
import com.modelsolv.reprezen.realization.model.*;
import com.modelsolv.reprezen.realization.model.impl.PropertySetImpl;
import java.util.stream.Collectors;
import com.reprezen.jsonoverlay.OverlayFactory;

public class ObjectRealizationSpecImpl extends ObjectRealizationStrategyImpl implements ObjectRealizationSpec {

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public ObjectRealizationSpecImpl(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
        super(json, parent, refMgr);
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public ObjectRealizationSpecImpl(ObjectRealizationSpec objectRealizationSpec, JsonOverlay<?> parent, ReferenceManager refMgr) {
        super(objectRealizationSpec, parent, refMgr);
    }

    // PropertySet
    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public PropertySet getPropertySet() {
        return _get("propertySet", PropertySet.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public PropertySet getPropertySet(boolean elaborate) {
        return _get("propertySet", elaborate, PropertySet.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public void setPropertySet(PropertySet propertySet) {
        _setScalar("propertySet", propertySet, PropertySet.class);
    }

    // Link
    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public List<LinkStrategy> getLinks() {
        return _getList("links", LinkStrategy.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public List<LinkStrategy> getLinks(boolean elaborate) {
        return _getList("links", elaborate, LinkStrategy.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public boolean hasLinks() {
        return _isPresent("links");
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public LinkStrategy getLink(int index) {
        return _get("links", index, LinkStrategy.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public void setLinks(List<LinkStrategy> links) {
        _setList("links", links, LinkStrategy.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public void setLink(int index, LinkStrategy link) {
        _set("links", index, link, LinkStrategy.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public void addLink(LinkStrategy link) {
        _add("links", link, LinkStrategy.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public void insertLink(int index, LinkStrategy link) {
        _insert("links", index, link, LinkStrategy.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public void removeLink(int index) {
        _remove("links", index, LinkStrategy.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    protected void _elaborateJson() {
        super._elaborateJson();
        _createScalar("propertySet", "propertySet", PropertySetImpl.factory);
        _createList("links", "links", LinkStrategyImpl.factory);
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public static OverlayFactory<ObjectRealizationSpec> factory = new OverlayFactory<ObjectRealizationSpec>() {

        @Override
        protected Class<? extends JsonOverlay<? super ObjectRealizationSpec>> getOverlayClass() {
            return ObjectRealizationSpecImpl.class;
        }

        @Override
        public JsonOverlay<ObjectRealizationSpec> _create(ObjectRealizationSpec objectRealizationSpec, JsonOverlay<?> parent, ReferenceManager refMgr) {
            JsonOverlay<?> overlay;
            overlay = new ObjectRealizationSpecImpl(objectRealizationSpec, parent, refMgr);
            @SuppressWarnings("unchecked") JsonOverlay<ObjectRealizationSpec> castOverlay = (JsonOverlay<ObjectRealizationSpec>) overlay;
            return castOverlay;
        }

        @Override
        public JsonOverlay<ObjectRealizationSpec> _create(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
            JsonOverlay<?> overlay;
            overlay = new ObjectRealizationSpecImpl(json, parent, refMgr);
            @SuppressWarnings("unchecked") JsonOverlay<ObjectRealizationSpec> castOverlay = (JsonOverlay<ObjectRealizationSpec>) overlay;
            return castOverlay;
        }

        @Override
        protected boolean isExtendedType() {
            return false;
        }
    };

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    private static Class<? extends ObjectRealizationSpec> getSubtypeOf(ObjectRealizationSpec objectRealizationSpec) {
        return ObjectRealizationSpec.class;
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    private static Class<? extends ObjectRealizationSpec> getSubtypeOf(JsonNode json) {
        return ObjectRealizationSpec.class;
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    protected OverlayFactory<?> _getFactory() {
        return factory;
    }
}
