package com.reprezen.rapidml.realization.model.impl;

import com.reprezen.rapidml.realization.model.impl.PropertyRealizationImpl;
import javax.annotation.Generated;
import java.util.List;
import com.fasterxml.jackson.core.JsonPointer;
import com.reprezen.jsonoverlay.JsonOverlay;
import com.reprezen.jsonoverlay.ReferenceManager;
import com.reprezen.jsonoverlay.ListOverlay;
import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.rapidml.realization.model.*;
import com.reprezen.rapidml.realization.model.impl.PropertySelectorImpl;
import java.util.stream.Collectors;
import com.reprezen.jsonoverlay.OverlayFactory;

public class InclusivePropertySetImpl extends PropertySetImpl implements InclusivePropertySet {

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public InclusivePropertySetImpl(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
        super(json, parent, refMgr);
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public InclusivePropertySetImpl(InclusivePropertySet inclusivePropertySet, JsonOverlay<?> parent, ReferenceManager refMgr) {
        super(inclusivePropertySet, parent, refMgr);
    }

    // IncludedProperty
    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public List<PropertyRealization> getIncludedProperties() {
        return _getList("includedProperties", PropertyRealization.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public List<PropertyRealization> getIncludedProperties(boolean elaborate) {
        return _getList("includedProperties", elaborate, PropertyRealization.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public boolean hasIncludedProperties() {
        return _isPresent("includedProperties");
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public PropertyRealization getIncludedProperty(int index) {
        return _get("includedProperties", index, PropertyRealization.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public void setIncludedProperties(List<PropertyRealization> includedProperties) {
        _setList("includedProperties", includedProperties, PropertyRealization.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public void setIncludedProperty(int index, PropertyRealization includedProperty) {
        _set("includedProperties", index, includedProperty, PropertyRealization.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public void addIncludedProperty(PropertyRealization includedProperty) {
        _add("includedProperties", includedProperty, PropertyRealization.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public void insertIncludedProperty(int index, PropertyRealization includedProperty) {
        _insert("includedProperties", index, includedProperty, PropertyRealization.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public void removeIncludedProperty(int index) {
        _remove("includedProperties", index, PropertyRealization.class);
    }

    // ExcludedProperty
    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public List<PropertySelector> getExcludedProperties() {
        return _getList("excludedProperties", PropertySelector.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public List<PropertySelector> getExcludedProperties(boolean elaborate) {
        return _getList("excludedProperties", elaborate, PropertySelector.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public boolean hasExcludedProperties() {
        return _isPresent("excludedProperties");
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public PropertySelector getExcludedProperty(int index) {
        return _get("excludedProperties", index, PropertySelector.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public void setExcludedProperties(List<PropertySelector> excludedProperties) {
        _setList("excludedProperties", excludedProperties, PropertySelector.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public void setExcludedProperty(int index, PropertySelector excludedProperty) {
        _set("excludedProperties", index, excludedProperty, PropertySelector.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public void addExcludedProperty(PropertySelector excludedProperty) {
        _add("excludedProperties", excludedProperty, PropertySelector.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public void insertExcludedProperty(int index, PropertySelector excludedProperty) {
        _insert("excludedProperties", index, excludedProperty, PropertySelector.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public void removeExcludedProperty(int index) {
        _remove("excludedProperties", index, PropertySelector.class);
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    protected void _elaborateJson() {
        super._elaborateJson();
        _createList("includedProperties", "includedProperties", PropertyRealizationImpl.factory);
        _createList("excludedProperties", "excludedProperties", PropertySelectorImpl.factory);
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public static OverlayFactory<InclusivePropertySet> factory = new OverlayFactory<InclusivePropertySet>() {

        @Override
        protected Class<? extends JsonOverlay<? super InclusivePropertySet>> getOverlayClass() {
            return InclusivePropertySetImpl.class;
        }

        @Override
        public JsonOverlay<InclusivePropertySet> _create(InclusivePropertySet inclusivePropertySet, JsonOverlay<?> parent, ReferenceManager refMgr) {
            JsonOverlay<?> overlay;
            overlay = new InclusivePropertySetImpl(inclusivePropertySet, parent, refMgr);
            @SuppressWarnings("unchecked") JsonOverlay<InclusivePropertySet> castOverlay = (JsonOverlay<InclusivePropertySet>) overlay;
            return castOverlay;
        }

        @Override
        public JsonOverlay<InclusivePropertySet> _create(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
            JsonOverlay<?> overlay;
            overlay = new InclusivePropertySetImpl(json, parent, refMgr);
            @SuppressWarnings("unchecked") JsonOverlay<InclusivePropertySet> castOverlay = (JsonOverlay<InclusivePropertySet>) overlay;
            return castOverlay;
        }

        @Override
        protected boolean isExtendedType() {
            return false;
        }
    };

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    private static Class<? extends InclusivePropertySet> getSubtypeOf(InclusivePropertySet inclusivePropertySet) {
        return InclusivePropertySet.class;
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    private static Class<? extends InclusivePropertySet> getSubtypeOf(JsonNode json) {
        return InclusivePropertySet.class;
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    protected OverlayFactory<?> _getFactory() {
        return factory;
    }
}
