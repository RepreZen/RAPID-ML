package com.reprezen.rapidml.realization.model.impl;

import javax.annotation.Generated;

import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.jsonoverlay.BooleanOverlay;
import com.reprezen.jsonoverlay.JsonOverlay;
import com.reprezen.jsonoverlay.OverlayFactory;
import com.reprezen.jsonoverlay.ReferenceManager;
import com.reprezen.rapidml.realization.model.Conditions;
import com.reprezen.rapidml.realization.model.ContextPattern;

public class ConditionsImpl extends BaseImpl implements Conditions {

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public ConditionsImpl(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(json, parent, refMgr);
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public ConditionsImpl(Conditions conditions, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(conditions, parent, refMgr);
	}

	// AutoLinkableToObjectResource
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Boolean getAutoLinkableToObjectResource() {
		return _get("autoLinkableToObjectResource", Boolean.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean isAutoLinkableToObjectResource() {
		Boolean bool = _get("autoLinkableToObjectResource", Boolean.class);
		return bool != null ? bool : false;
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setAutoLinkableToObjectResource(Boolean autoLinkableToObjectResource) {
		_setScalar("autoLinkableToObjectResource", autoLinkableToObjectResource, Boolean.class);
	}

	// AutoLinkableToCollectionResource
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Boolean getAutoLinkableToCollectionResource() {
		return _get("autoLinkableToCollectionResource", Boolean.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean isAutoLinkableToCollectionResource() {
		Boolean bool = _get("autoLinkableToCollectionResource", Boolean.class);
		return bool != null ? bool : false;
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setAutoLinkableToCollectionResource(Boolean autoLinkableToCollectionResource) {
		_setScalar("autoLinkableToCollectionResource", autoLinkableToCollectionResource, Boolean.class);
	}

	// HasKeys
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Boolean getHasKeys() {
		return _get("hasKeys", Boolean.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean hasKeys() {
		Boolean bool = _get("hasKeys", Boolean.class);
		return bool != null ? bool : false;
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setHasKeys(Boolean hasKeys) {
		_setScalar("hasKeys", hasKeys, Boolean.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	protected void _elaborateJson() {
		super._elaborateJson();
		_createScalar("autoLinkableToObjectResource", "autoLinkableToObjectResource", BooleanOverlay.factory);
		_createScalar("autoLinkableToCollectionResource", "autoLinkableToCollectionResource", BooleanOverlay.factory);
		_createScalar("hasKeys", "hasKeys", BooleanOverlay.factory);
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static OverlayFactory<Conditions> factory = new OverlayFactory<Conditions>() {

		@Override
		protected Class<? extends JsonOverlay<? super Conditions>> getOverlayClass() {
			return ConditionsImpl.class;
		}

		@Override
		public JsonOverlay<Conditions> _create(Conditions conditions, JsonOverlay<?> parent, ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			Class<? extends Conditions> subtype = getSubtypeOf(conditions);
			switch (subtype != null ? subtype.getSimpleName() : "") {
			case "ContextPattern":
				overlay = ContextPatternImpl.factory.create((ContextPattern) conditions, parent, refMgr);
				break;
			default:
				overlay = new ConditionsImpl((Conditions) conditions, parent, refMgr);
			}
			@SuppressWarnings("unchecked")
			JsonOverlay<Conditions> castOverlay = (JsonOverlay<Conditions>) overlay;
			return castOverlay;
		}

		@Override
		public JsonOverlay<Conditions> _create(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			Class<? extends Conditions> subtype = getSubtypeOf(json);
			switch (subtype != null ? subtype.getSimpleName() : "") {
			case "ContextPattern":
				overlay = ContextPatternImpl.factory.create(json, parent, refMgr);
				break;
			default:
				overlay = new ConditionsImpl(json, parent, refMgr);
			}
			@SuppressWarnings("unchecked")
			JsonOverlay<Conditions> castOverlay = (JsonOverlay<Conditions>) overlay;
			return castOverlay;
		}

		@Override
		protected boolean isExtendedType() {
			return true;
		}
	};

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private static Class<? extends Conditions> getSubtypeOf(Conditions conditions) {
		switch (conditions.getClass().getSimpleName()) {
		case "ContextPattern":
			return ContextPattern.class;
		case "Conditions":
			return Conditions.class;
		default:
			return null;
		}
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private static Class<? extends Conditions> getSubtypeOf(JsonNode json) {
		switch (json.at(JsonPointer.compile("/_type")).asText()) {
		case "ContextPattern":
			return ContextPattern.class;
		case "Conditions":
			return Conditions.class;
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
