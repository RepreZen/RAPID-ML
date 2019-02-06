package com.reprezen.rapidml.realization.model.impl;

import javax.annotation.Generated;

import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.jsonoverlay.JsonOverlay;
import com.reprezen.jsonoverlay.OverlayFactory;
import com.reprezen.jsonoverlay.ReferenceManager;
import com.reprezen.rapidml.realization.model.PrimitivePropertySelector;
import com.reprezen.rapidml.realization.model.PropertyTypeSelector;
import com.reprezen.rapidml.realization.model.ReferencePropertySelector;

public class PropertyTypeSelectorImpl extends BaseImpl implements PropertyTypeSelector {

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public PropertyTypeSelectorImpl(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(json, parent, refMgr);
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public PropertyTypeSelectorImpl(PropertyTypeSelector propertyTypeSelector, JsonOverlay<?> parent,
			ReferenceManager refMgr) {
		super(propertyTypeSelector, parent, refMgr);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	protected void _elaborateJson() {
		super._elaborateJson();
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static OverlayFactory<PropertyTypeSelector> factory = new OverlayFactory<PropertyTypeSelector>() {

		@Override
		protected Class<? extends JsonOverlay<? super PropertyTypeSelector>> getOverlayClass() {
			return PropertyTypeSelectorImpl.class;
		}

		@Override
		public JsonOverlay<PropertyTypeSelector> _create(PropertyTypeSelector propertyTypeSelector,
				JsonOverlay<?> parent, ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			Class<? extends PropertyTypeSelector> subtype = getSubtypeOf(propertyTypeSelector);
			switch (subtype != null ? subtype.getSimpleName() : "") {
			case "ReferencePropertySelector":
				overlay = ReferencePropertySelectorImpl.factory.create((ReferencePropertySelector) propertyTypeSelector,
						parent, refMgr);
				break;
			case "PrimitivePropertySelector":
				overlay = PrimitivePropertySelectorImpl.factory.create((PrimitivePropertySelector) propertyTypeSelector,
						parent, refMgr);
				break;
			default:
				overlay = new PropertyTypeSelectorImpl((PropertyTypeSelector) propertyTypeSelector, parent, refMgr);
			}
			@SuppressWarnings("unchecked")
			JsonOverlay<PropertyTypeSelector> castOverlay = (JsonOverlay<PropertyTypeSelector>) overlay;
			return castOverlay;
		}

		@Override
		public JsonOverlay<PropertyTypeSelector> _create(JsonNode json, JsonOverlay<?> parent,
				ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			Class<? extends PropertyTypeSelector> subtype = getSubtypeOf(json);
			switch (subtype != null ? subtype.getSimpleName() : "") {
			case "ReferencePropertySelector":
				overlay = ReferencePropertySelectorImpl.factory.create(json, parent, refMgr);
				break;
			case "PrimitivePropertySelector":
				overlay = PrimitivePropertySelectorImpl.factory.create(json, parent, refMgr);
				break;
			default:
				overlay = new PropertyTypeSelectorImpl(json, parent, refMgr);
			}
			@SuppressWarnings("unchecked")
			JsonOverlay<PropertyTypeSelector> castOverlay = (JsonOverlay<PropertyTypeSelector>) overlay;
			return castOverlay;
		}

		@Override
		protected boolean isExtendedType() {
			return true;
		}
	};

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private static Class<? extends PropertyTypeSelector> getSubtypeOf(PropertyTypeSelector propertyTypeSelector) {
		switch (propertyTypeSelector.getClass().getSimpleName()) {
		case "ReferencePropertySelector":
			return ReferencePropertySelector.class;
		case "PrimitivePropertySelector":
			return PrimitivePropertySelector.class;
		case "PropertyTypeSelector":
			return PropertyTypeSelector.class;
		default:
			return null;
		}
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private static Class<? extends PropertyTypeSelector> getSubtypeOf(JsonNode json) {
		switch (json.at(JsonPointer.compile("/_type")).asText()) {
		case "ReferencePropertySelector":
			return ReferencePropertySelector.class;
		case "PrimitivePropertySelector":
			return PrimitivePropertySelector.class;
		case "PropertyTypeSelector":
			return PropertyTypeSelector.class;
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
