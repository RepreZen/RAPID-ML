package com.reprezen.rapidml.realization.model.impl;

import java.util.List;

import javax.annotation.Generated;

import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.jsonoverlay.JsonOverlay;
import com.reprezen.jsonoverlay.OverlayFactory;
import com.reprezen.jsonoverlay.ReferenceManager;
import com.reprezen.rapidml.realization.model.ExclusivePropertySet;
import com.reprezen.rapidml.realization.model.PropertyRealization;

public class ExclusivePropertySetImpl extends PropertySetImpl implements ExclusivePropertySet {

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public ExclusivePropertySetImpl(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(json, parent, refMgr);
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public ExclusivePropertySetImpl(ExclusivePropertySet exclusivePropertySet, JsonOverlay<?> parent,
			ReferenceManager refMgr) {
		super(exclusivePropertySet, parent, refMgr);
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

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	protected void _elaborateJson() {
		super._elaborateJson();
		_createList("includedProperties", "includedProperties", PropertyRealizationImpl.factory);
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static OverlayFactory<ExclusivePropertySet> factory = new OverlayFactory<ExclusivePropertySet>() {

		@Override
		protected Class<? extends JsonOverlay<? super ExclusivePropertySet>> getOverlayClass() {
			return ExclusivePropertySetImpl.class;
		}

		@Override
		public JsonOverlay<ExclusivePropertySet> _create(ExclusivePropertySet exclusivePropertySet,
				JsonOverlay<?> parent, ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new ExclusivePropertySetImpl(exclusivePropertySet, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<ExclusivePropertySet> castOverlay = (JsonOverlay<ExclusivePropertySet>) overlay;
			return castOverlay;
		}

		@Override
		public JsonOverlay<ExclusivePropertySet> _create(JsonNode json, JsonOverlay<?> parent,
				ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new ExclusivePropertySetImpl(json, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<ExclusivePropertySet> castOverlay = (JsonOverlay<ExclusivePropertySet>) overlay;
			return castOverlay;
		}

		@Override
		protected boolean isExtendedType() {
			return false;
		}
	};

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private static Class<? extends ExclusivePropertySet> getSubtypeOf(ExclusivePropertySet exclusivePropertySet) {
		return ExclusivePropertySet.class;
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private static Class<? extends ExclusivePropertySet> getSubtypeOf(JsonNode json) {
		return ExclusivePropertySet.class;
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	protected OverlayFactory<?> _getFactory() {
		return factory;
	}
}
