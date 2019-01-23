package com.reprezen.rapidml.realization.model.impl;

import java.util.Collection;
import java.util.List;

import javax.annotation.Generated;

import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.jsonoverlay.JsonOverlay;
import com.reprezen.jsonoverlay.OverlayFactory;
import com.reprezen.jsonoverlay.ReferenceManager;
import com.reprezen.rapidml.realization.model.ConditionalPropertySet;
import com.reprezen.rapidml.realization.model.PropertySetSwitch;

public class PropertySetSwitchImpl extends PropertySetImpl implements PropertySetSwitch {

	@Override
	public Collection<ConditionalPropertySet> getCandidates() {
		return getPropertySetCases();
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public PropertySetSwitchImpl(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(json, parent, refMgr);
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public PropertySetSwitchImpl(PropertySetSwitch propertySetSwitch, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(propertySetSwitch, parent, refMgr);
	}

	// PropertySetCase
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public List<ConditionalPropertySet> getPropertySetCases() {
		return _getList("propertySetCases", ConditionalPropertySet.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public List<ConditionalPropertySet> getPropertySetCases(boolean elaborate) {
		return _getList("propertySetCases", elaborate, ConditionalPropertySet.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasPropertySetCases() {
		return _isPresent("propertySetCases");
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public ConditionalPropertySet getPropertySetCase(int index) {
		return _get("propertySetCases", index, ConditionalPropertySet.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setPropertySetCases(List<ConditionalPropertySet> propertySetCases) {
		_setList("propertySetCases", propertySetCases, ConditionalPropertySet.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setPropertySetCase(int index, ConditionalPropertySet propertySetCase) {
		_set("propertySetCases", index, propertySetCase, ConditionalPropertySet.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void addPropertySetCase(ConditionalPropertySet propertySetCase) {
		_add("propertySetCases", propertySetCase, ConditionalPropertySet.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void insertPropertySetCase(int index, ConditionalPropertySet propertySetCase) {
		_insert("propertySetCases", index, propertySetCase, ConditionalPropertySet.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void removePropertySetCase(int index) {
		_remove("propertySetCases", index, ConditionalPropertySet.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	protected void _elaborateJson() {
		super._elaborateJson();
		_createList("propertySetCases", "cases", ConditionalPropertySetImpl.factory);
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static OverlayFactory<PropertySetSwitch> factory = new OverlayFactory<PropertySetSwitch>() {

		@Override
		protected Class<? extends JsonOverlay<? super PropertySetSwitch>> getOverlayClass() {
			return PropertySetSwitchImpl.class;
		}

		@Override
		public JsonOverlay<PropertySetSwitch> _create(PropertySetSwitch propertySetSwitch, JsonOverlay<?> parent,
				ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new PropertySetSwitchImpl(propertySetSwitch, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<PropertySetSwitch> castOverlay = (JsonOverlay<PropertySetSwitch>) overlay;
			return castOverlay;
		}

		@Override
		public JsonOverlay<PropertySetSwitch> _create(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new PropertySetSwitchImpl(json, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<PropertySetSwitch> castOverlay = (JsonOverlay<PropertySetSwitch>) overlay;
			return castOverlay;
		}

		@Override
		protected boolean isExtendedType() {
			return false;
		}
	};

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private static Class<? extends PropertySetSwitch> getSubtypeOf(PropertySetSwitch propertySetSwitch) {
		return PropertySetSwitch.class;
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private static Class<? extends PropertySetSwitch> getSubtypeOf(JsonNode json) {
		return PropertySetSwitch.class;
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	protected OverlayFactory<?> _getFactory() {
		return factory;
	}
}
