package com.reprezen.realization.model.impl;

import java.util.Collection;
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
import com.reprezen.realization.model.impl.PropertySetImpl;
import java.util.Collections;

public class ConditionalPropertySetImpl extends PropertySetImpl implements ConditionalPropertySet {

    @Override
    public Collection<? extends Conditions> getConditions() {
        return Collections.singletonList(getWhere());
    }

    @Override
    public boolean noConditionsResult() {
        return true;
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public ConditionalPropertySetImpl(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
        super(json, parent, refMgr);
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public ConditionalPropertySetImpl(ConditionalPropertySet conditionalPropertySet, JsonOverlay<?> parent, ReferenceManager refMgr) {
        super(conditionalPropertySet, parent, refMgr);
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

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    protected void _elaborateJson() {
        super._elaborateJson();
        _createScalar("where", "where", ConditionsImpl.factory);
        _createScalar("propertySet", "propertySet", PropertySetImpl.factory);
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    public static OverlayFactory<ConditionalPropertySet> factory = new OverlayFactory<ConditionalPropertySet>() {

        @Override
        protected Class<? extends JsonOverlay<? super ConditionalPropertySet>> getOverlayClass() {
            return ConditionalPropertySetImpl.class;
        }

        @Override
        public JsonOverlay<ConditionalPropertySet> _create(ConditionalPropertySet conditionalPropertySet, JsonOverlay<?> parent, ReferenceManager refMgr) {
            JsonOverlay<?> overlay;
            overlay = new ConditionalPropertySetImpl(conditionalPropertySet, parent, refMgr);
            @SuppressWarnings("unchecked") JsonOverlay<ConditionalPropertySet> castOverlay = (JsonOverlay<ConditionalPropertySet>) overlay;
            return castOverlay;
        }

        @Override
        public JsonOverlay<ConditionalPropertySet> _create(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
            JsonOverlay<?> overlay;
            overlay = new ConditionalPropertySetImpl(json, parent, refMgr);
            @SuppressWarnings("unchecked") JsonOverlay<ConditionalPropertySet> castOverlay = (JsonOverlay<ConditionalPropertySet>) overlay;
            return castOverlay;
        }

        @Override
        protected boolean isExtendedType() {
            return false;
        }
    };

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    private static Class<? extends ConditionalPropertySet> getSubtypeOf(ConditionalPropertySet conditionalPropertySet) {
        return ConditionalPropertySet.class;
    }

    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    private static Class<? extends ConditionalPropertySet> getSubtypeOf(JsonNode json) {
        return ConditionalPropertySet.class;
    }

    @Override
    @Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
    protected OverlayFactory<?> _getFactory() {
        return factory;
    }
}
