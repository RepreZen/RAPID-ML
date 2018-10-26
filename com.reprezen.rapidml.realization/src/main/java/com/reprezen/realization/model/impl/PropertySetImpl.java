package com.reprezen.realization.model.impl;

import com.reprezen.realization.model.ExclusivePropertySet;
import javax.annotation.Generated;
import com.fasterxml.jackson.core.JsonPointer;
import com.reprezen.realization.model.InclusivePropertySet;
import com.reprezen.jsonoverlay.JsonOverlay;
import com.reprezen.jsonoverlay.ReferenceManager;
import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.realization.model.*;
import java.util.stream.Collectors;
import com.reprezen.realization.model.PropertySetSwitch;
import com.reprezen.jsonoverlay.OverlayFactory;
import com.reprezen.realization.model.ConditionalPropertySet;

public class PropertySetImpl extends BaseImpl implements PropertySet {

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public PropertySetImpl(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
        super(json, parent, refMgr);
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public PropertySetImpl(PropertySet propertySet, JsonOverlay<?> parent, ReferenceManager refMgr) {
        super(propertySet, parent, refMgr);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    protected void _elaborateJson() {
        super._elaborateJson();
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public static OverlayFactory<PropertySet> factory = new OverlayFactory<PropertySet>() {

        @Override
        protected Class<? extends JsonOverlay<? super PropertySet>> getOverlayClass() {
            return PropertySetImpl.class;
        }

        @Override
        public JsonOverlay<PropertySet> _create(PropertySet propertySet, JsonOverlay<?> parent, ReferenceManager refMgr) {
            JsonOverlay<?> overlay;
            Class<? extends PropertySet> subtype = getSubtypeOf(propertySet);
            switch(subtype != null ? subtype.getSimpleName() : "") {
                case "ExclusivePropertySet":
                    overlay = ExclusivePropertySetImpl.factory.create((ExclusivePropertySet) propertySet, parent, refMgr);
                    break;
                case "ConditionalPropertySet":
                    overlay = ConditionalPropertySetImpl.factory.create((ConditionalPropertySet) propertySet, parent, refMgr);
                    break;
                case "InclusivePropertySet":
                    overlay = InclusivePropertySetImpl.factory.create((InclusivePropertySet) propertySet, parent, refMgr);
                    break;
                case "PropertySetSwitch":
                    overlay = PropertySetSwitchImpl.factory.create((PropertySetSwitch) propertySet, parent, refMgr);
                    break;
                default:
                    overlay = new PropertySetImpl((PropertySet) propertySet, parent, refMgr);
            }
            @SuppressWarnings("unchecked") JsonOverlay<PropertySet> castOverlay = (JsonOverlay<PropertySet>) overlay;
            return castOverlay;
        }

        @Override
        public JsonOverlay<PropertySet> _create(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
            JsonOverlay<?> overlay;
            Class<? extends PropertySet> subtype = getSubtypeOf(json);
            switch(subtype != null ? subtype.getSimpleName() : "") {
                case "ExclusivePropertySet":
                    overlay = ExclusivePropertySetImpl.factory.create(json, parent, refMgr);
                    break;
                case "ConditionalPropertySet":
                    overlay = ConditionalPropertySetImpl.factory.create(json, parent, refMgr);
                    break;
                case "InclusivePropertySet":
                    overlay = InclusivePropertySetImpl.factory.create(json, parent, refMgr);
                    break;
                case "PropertySetSwitch":
                    overlay = PropertySetSwitchImpl.factory.create(json, parent, refMgr);
                    break;
                default:
                    overlay = new PropertySetImpl(json, parent, refMgr);
            }
            @SuppressWarnings("unchecked") JsonOverlay<PropertySet> castOverlay = (JsonOverlay<PropertySet>) overlay;
            return castOverlay;
        }

        @Override
        protected boolean isExtendedType() {
            return true;
        }
    };

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    private static Class<? extends PropertySet> getSubtypeOf(PropertySet propertySet) {
        switch(propertySet.getClass().getSimpleName()) {
            case "ExclusivePropertySet":
                return ExclusivePropertySet.class;
            case "ConditionalPropertySet":
                return ConditionalPropertySet.class;
            case "InclusivePropertySet":
                return InclusivePropertySet.class;
            case "PropertySetSwitch":
                return PropertySetSwitch.class;
            default:
                return null;
        }
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    private static Class<? extends PropertySet> getSubtypeOf(JsonNode json) {
        switch(json.at(JsonPointer.compile("/_type")).asText()) {
            case "ExclusivePropertySet":
                return ExclusivePropertySet.class;
            case "ConditionalPropertySet":
                return ConditionalPropertySet.class;
            case "InclusivePropertySet":
                return InclusivePropertySet.class;
            case "PropertySetSwitch":
                return PropertySetSwitch.class;
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
