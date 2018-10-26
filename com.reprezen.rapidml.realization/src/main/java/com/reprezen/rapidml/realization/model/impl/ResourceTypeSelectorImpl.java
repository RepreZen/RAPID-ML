package com.reprezen.rapidml.realization.model.impl;

import javax.annotation.Generated;
import com.reprezen.jsonoverlay.JsonOverlay;
import com.reprezen.jsonoverlay.ReferenceManager;
import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.rapidml.realization.model.*;
import com.reprezen.jsonoverlay.EnumOverlay;
import com.reprezen.jsonoverlay.OverlayFactory;

public class ResourceTypeSelectorImpl extends EnumOverlay<ResourceTypeSelector> {

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public ResourceTypeSelectorImpl(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
        super(json, parent, factory, refMgr);
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public ResourceTypeSelectorImpl(ResourceTypeSelector resourceTypeSelector, JsonOverlay<?> parent, ReferenceManager refMgr) {
        super(resourceTypeSelector, parent, factory, refMgr);
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    protected Class<ResourceTypeSelector> getEnumClass() {
        return ResourceTypeSelector.class;
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public static OverlayFactory<ResourceTypeSelector> factory = new OverlayFactory<ResourceTypeSelector>() {

        @Override
        protected Class<? extends JsonOverlay<? super ResourceTypeSelector>> getOverlayClass() {
            return ResourceTypeSelectorImpl.class;
        }

        @Override
        public JsonOverlay<ResourceTypeSelector> _create(ResourceTypeSelector resourceTypeSelector, JsonOverlay<?> parent, ReferenceManager refMgr) {
            return new ResourceTypeSelectorImpl(resourceTypeSelector, parent, refMgr);
        }

        @Override
        public JsonOverlay<ResourceTypeSelector> _create(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
            return new ResourceTypeSelectorImpl(json, parent, refMgr);
        }
    };

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    protected OverlayFactory<?> _getFactory() {
        return factory;
    }
}
