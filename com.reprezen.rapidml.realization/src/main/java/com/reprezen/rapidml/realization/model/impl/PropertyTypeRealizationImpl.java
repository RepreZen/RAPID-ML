package com.reprezen.rapidml.realization.model.impl;

import javax.annotation.Generated;

import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.jsonoverlay.JsonOverlay;
import com.reprezen.jsonoverlay.OverlayFactory;
import com.reprezen.jsonoverlay.ReferenceManager;
import com.reprezen.rapidml.realization.model.PrimitivePropertyRealization;
import com.reprezen.rapidml.realization.model.PropertyTypeRealization;
import com.reprezen.rapidml.realization.model.ReferencePropertyRealization;

public class PropertyTypeRealizationImpl extends BaseImpl implements PropertyTypeRealization {

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public PropertyTypeRealizationImpl(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(json, parent, refMgr);
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public PropertyTypeRealizationImpl(PropertyTypeRealization propertyTypeRealization, JsonOverlay<?> parent,
			ReferenceManager refMgr) {
		super(propertyTypeRealization, parent, refMgr);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	protected void _elaborateJson() {
		super._elaborateJson();
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static OverlayFactory<PropertyTypeRealization> factory = new OverlayFactory<PropertyTypeRealization>() {

		@Override
		protected Class<? extends JsonOverlay<? super PropertyTypeRealization>> getOverlayClass() {
			return PropertyTypeRealizationImpl.class;
		}

		@Override
		public JsonOverlay<PropertyTypeRealization> _create(PropertyTypeRealization propertyTypeRealization,
				JsonOverlay<?> parent, ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			Class<? extends PropertyTypeRealization> subtype = getSubtypeOf(propertyTypeRealization);
			switch (subtype != null ? subtype.getSimpleName() : "") {
			case "ReferencePropertyRealization":
				overlay = ReferencePropertyRealizationImpl.factory
						.create((ReferencePropertyRealization) propertyTypeRealization, parent, refMgr);
				break;
			case "PrimitivePropertyRealization":
				overlay = PrimitivePropertyRealizationImpl.factory
						.create((PrimitivePropertyRealization) propertyTypeRealization, parent, refMgr);
				break;
			default:
				overlay = new PropertyTypeRealizationImpl((PropertyTypeRealization) propertyTypeRealization, parent,
						refMgr);
			}
			@SuppressWarnings("unchecked")
			JsonOverlay<PropertyTypeRealization> castOverlay = (JsonOverlay<PropertyTypeRealization>) overlay;
			return castOverlay;
		}

		@Override
		public JsonOverlay<PropertyTypeRealization> _create(JsonNode json, JsonOverlay<?> parent,
				ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			Class<? extends PropertyTypeRealization> subtype = getSubtypeOf(json);
			switch (subtype != null ? subtype.getSimpleName() : "") {
			case "ReferencePropertyRealization":
				overlay = ReferencePropertyRealizationImpl.factory.create(json, parent, refMgr);
				break;
			case "PrimitivePropertyRealization":
				overlay = PrimitivePropertyRealizationImpl.factory.create(json, parent, refMgr);
				break;
			default:
				overlay = new PropertyTypeRealizationImpl(json, parent, refMgr);
			}
			@SuppressWarnings("unchecked")
			JsonOverlay<PropertyTypeRealization> castOverlay = (JsonOverlay<PropertyTypeRealization>) overlay;
			return castOverlay;
		}

		@Override
		protected boolean isExtendedType() {
			return true;
		}
	};

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private static Class<? extends PropertyTypeRealization> getSubtypeOf(
			PropertyTypeRealization propertyTypeRealization) {
		switch (propertyTypeRealization.getClass().getSimpleName()) {
		case "ReferencePropertyRealization":
			return ReferencePropertyRealization.class;
		case "PrimitivePropertyRealization":
			return PrimitivePropertyRealization.class;
		case "PropertyTypeRealization":
			return PropertyTypeRealization.class;
		default:
			return null;
		}
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private static Class<? extends PropertyTypeRealization> getSubtypeOf(JsonNode json) {
		switch (json.at(JsonPointer.compile("/_type")).asText()) {
		case "ReferencePropertyRealization":
			return ReferencePropertyRealization.class;
		case "PrimitivePropertyRealization":
			return PrimitivePropertyRealization.class;
		case "PropertyTypeRealization":
			return PropertyTypeRealization.class;
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
