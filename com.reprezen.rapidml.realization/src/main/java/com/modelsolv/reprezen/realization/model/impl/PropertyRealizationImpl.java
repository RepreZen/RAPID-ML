package com.modelsolv.reprezen.realization.model.impl;

import javax.annotation.Generated;
import com.fasterxml.jackson.core.JsonPointer;
import com.modelsolv.reprezen.realization.model.impl.PropertyTypeRealizationImpl;
import com.reprezen.jsonoverlay.JsonOverlay;
import com.reprezen.jsonoverlay.ReferenceManager;
import com.fasterxml.jackson.databind.JsonNode;
import com.modelsolv.reprezen.realization.model.*;
import java.util.stream.Collectors;
import com.reprezen.jsonoverlay.OverlayFactory;

public class PropertyRealizationImpl extends AbstractPropertySelectorImpl implements PropertyRealization {

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public PropertyRealizationImpl(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
        super(json, parent, refMgr);
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public PropertyRealizationImpl(PropertyRealization propertyRealization, JsonOverlay<?> parent, ReferenceManager refMgr) {
        super(propertyRealization, parent, refMgr);
    }

    // PropertyType
    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public PropertyTypeRealization getPropertyType() {
        return _get("propertyType", PropertyTypeRealization.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public PropertyTypeRealization getPropertyType(boolean elaborate) {
        return _get("propertyType", elaborate, PropertyTypeRealization.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public void setPropertyType(PropertyTypeRealization propertyType) {
        _setScalar("propertyType", propertyType, PropertyTypeRealization.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    protected void _elaborateJson() {
        super._elaborateJson();
        _createScalar("propertyType", "propertyType", PropertyTypeRealizationImpl.factory);
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public static OverlayFactory<PropertyRealization> factory = new OverlayFactory<PropertyRealization>() {

        @Override
        protected Class<? extends JsonOverlay<? super PropertyRealization>> getOverlayClass() {
            return PropertyRealizationImpl.class;
        }

        @Override
        public JsonOverlay<PropertyRealization> _create(PropertyRealization propertyRealization, JsonOverlay<?> parent, ReferenceManager refMgr) {
            JsonOverlay<?> overlay;
            overlay = new PropertyRealizationImpl(propertyRealization, parent, refMgr);
            @SuppressWarnings("unchecked") JsonOverlay<PropertyRealization> castOverlay = (JsonOverlay<PropertyRealization>) overlay;
            return castOverlay;
        }

        @Override
        public JsonOverlay<PropertyRealization> _create(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
            JsonOverlay<?> overlay;
            overlay = new PropertyRealizationImpl(json, parent, refMgr);
            @SuppressWarnings("unchecked") JsonOverlay<PropertyRealization> castOverlay = (JsonOverlay<PropertyRealization>) overlay;
            return castOverlay;
        }

        @Override
        protected boolean isExtendedType() {
            return false;
        }
    };

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    private static Class<? extends PropertyRealization> getSubtypeOf(PropertyRealization propertyRealization) {
        return PropertyRealization.class;
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    private static Class<? extends PropertyRealization> getSubtypeOf(JsonNode json) {
        return PropertyRealization.class;
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    protected OverlayFactory<?> _getFactory() {
        return factory;
    }
}
