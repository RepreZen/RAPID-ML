package com.modelsolv.reprezen.realization.model.impl;

import javax.annotation.Generated;
import com.fasterxml.jackson.core.JsonPointer;
import com.reprezen.jsonoverlay.JsonOverlay;
import com.reprezen.jsonoverlay.ReferenceManager;
import com.fasterxml.jackson.databind.JsonNode;
import com.modelsolv.reprezen.realization.model.*;
import com.modelsolv.reprezen.realization.model.impl.PropertyTypeSelectorImpl;
import java.util.stream.Collectors;
import com.reprezen.jsonoverlay.OverlayFactory;

public class PropertySelectorImpl extends AbstractPropertySelectorImpl implements PropertySelector {

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public PropertySelectorImpl(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
        super(json, parent, refMgr);
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public PropertySelectorImpl(PropertySelector propertySelector, JsonOverlay<?> parent, ReferenceManager refMgr) {
        super(propertySelector, parent, refMgr);
    }

    // PropertyType
    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public PropertyTypeSelector getPropertyType() {
        return _get("propertyType", PropertyTypeSelector.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public PropertyTypeSelector getPropertyType(boolean elaborate) {
        return _get("propertyType", elaborate, PropertyTypeSelector.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public void setPropertyType(PropertyTypeSelector propertyType) {
        _setScalar("propertyType", propertyType, PropertyTypeSelector.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    protected void _elaborateJson() {
        super._elaborateJson();
        _createScalar("propertyType", "propertyType", PropertyTypeSelectorImpl.factory);
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public static OverlayFactory<PropertySelector> factory = new OverlayFactory<PropertySelector>() {

        @Override
        protected Class<? extends JsonOverlay<? super PropertySelector>> getOverlayClass() {
            return PropertySelectorImpl.class;
        }

        @Override
        public JsonOverlay<PropertySelector> _create(PropertySelector propertySelector, JsonOverlay<?> parent, ReferenceManager refMgr) {
            JsonOverlay<?> overlay;
            overlay = new PropertySelectorImpl(propertySelector, parent, refMgr);
            @SuppressWarnings("unchecked") JsonOverlay<PropertySelector> castOverlay = (JsonOverlay<PropertySelector>) overlay;
            return castOverlay;
        }

        @Override
        public JsonOverlay<PropertySelector> _create(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
            JsonOverlay<?> overlay;
            overlay = new PropertySelectorImpl(json, parent, refMgr);
            @SuppressWarnings("unchecked") JsonOverlay<PropertySelector> castOverlay = (JsonOverlay<PropertySelector>) overlay;
            return castOverlay;
        }

        @Override
        protected boolean isExtendedType() {
            return false;
        }
    };

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    private static Class<? extends PropertySelector> getSubtypeOf(PropertySelector propertySelector) {
        return PropertySelector.class;
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    private static Class<? extends PropertySelector> getSubtypeOf(JsonNode json) {
        return PropertySelector.class;
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    protected OverlayFactory<?> _getFactory() {
        return factory;
    }
}
