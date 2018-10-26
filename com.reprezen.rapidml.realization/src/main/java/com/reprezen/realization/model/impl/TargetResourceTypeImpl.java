package com.reprezen.realization.model.impl;

import javax.annotation.Generated;
import com.reprezen.jsonoverlay.JsonOverlay;
import com.reprezen.jsonoverlay.ReferenceManager;
import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.realization.model.*;
import com.reprezen.jsonoverlay.EnumOverlay;
import com.reprezen.jsonoverlay.OverlayFactory;

public class TargetResourceTypeImpl extends EnumOverlay<TargetResourceType> {

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public TargetResourceTypeImpl(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
        super(json, parent, factory, refMgr);
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public TargetResourceTypeImpl(TargetResourceType targetResourceType, JsonOverlay<?> parent, ReferenceManager refMgr) {
        super(targetResourceType, parent, factory, refMgr);
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    protected Class<TargetResourceType> getEnumClass() {
        return TargetResourceType.class;
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public static OverlayFactory<TargetResourceType> factory = new OverlayFactory<TargetResourceType>() {

        @Override
        protected Class<? extends JsonOverlay<? super TargetResourceType>> getOverlayClass() {
            return TargetResourceTypeImpl.class;
        }

        @Override
        public JsonOverlay<TargetResourceType> _create(TargetResourceType targetResourceType, JsonOverlay<?> parent, ReferenceManager refMgr) {
            return new TargetResourceTypeImpl(targetResourceType, parent, refMgr);
        }

        @Override
        public JsonOverlay<TargetResourceType> _create(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
            return new TargetResourceTypeImpl(json, parent, refMgr);
        }
    };

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    protected OverlayFactory<?> _getFactory() {
        return factory;
    }
}
