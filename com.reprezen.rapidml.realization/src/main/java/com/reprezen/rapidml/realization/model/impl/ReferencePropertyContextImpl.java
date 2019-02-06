package com.reprezen.rapidml.realization.model.impl;

import javax.annotation.Generated;

import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.jsonoverlay.BooleanOverlay;
import com.reprezen.jsonoverlay.JsonOverlay;
import com.reprezen.jsonoverlay.OverlayFactory;
import com.reprezen.jsonoverlay.ReferenceManager;
import com.reprezen.rapidml.realization.model.ContainmentSelector;
import com.reprezen.rapidml.realization.model.MultiplicitySelector;
import com.reprezen.rapidml.realization.model.ReadWriteSelector;
import com.reprezen.rapidml.realization.model.ReferencePropertyContext;

public class ReferencePropertyContextImpl extends ReferenceLevelContextImpl implements ReferencePropertyContext {

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public ReferencePropertyContextImpl(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(json, parent, refMgr);
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public ReferencePropertyContextImpl(ReferencePropertyContext referencePropertyContext, JsonOverlay<?> parent,
			ReferenceManager refMgr) {
		super(referencePropertyContext, parent, refMgr);
	}

	// Multiplicity
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public MultiplicitySelector getMultiplicity() {
		return _get("multiplicity", MultiplicitySelector.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public MultiplicitySelector getMultiplicity(boolean elaborate) {
		return _get("multiplicity", elaborate, MultiplicitySelector.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setMultiplicity(MultiplicitySelector multiplicity) {
		_setScalar("multiplicity", multiplicity, MultiplicitySelector.class);
	}

	// ReadWritability
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public ReadWriteSelector getReadWritability() {
		return _get("readWritability", ReadWriteSelector.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public ReadWriteSelector getReadWritability(boolean elaborate) {
		return _get("readWritability", elaborate, ReadWriteSelector.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setReadWritability(ReadWriteSelector readWritability) {
		_setScalar("readWritability", readWritability, ReadWriteSelector.class);
	}

	// Required
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public Boolean getRequired() {
		return _get("required", Boolean.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public boolean isRequired() {
		Boolean bool = _get("required", Boolean.class);
		return bool != null ? bool : false;
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setRequired(Boolean required) {
		_setScalar("required", required, Boolean.class);
	}

	// Containment
	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public ContainmentSelector getContainment() {
		return _get("containment", ContainmentSelector.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public ContainmentSelector getContainment(boolean elaborate) {
		return _get("containment", elaborate, ContainmentSelector.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public void setContainment(ContainmentSelector containment) {
		_setScalar("containment", containment, ContainmentSelector.class);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	protected void _elaborateJson() {
		super._elaborateJson();
		_createScalar("multiplicity", "multiplicity", MultiplicitySelectorImpl.factory);
		_createScalar("readWritability", "readWritability", ReadWriteSelectorImpl.factory);
		_createScalar("required", "isRequired", BooleanOverlay.factory);
		_createScalar("containment", "containment", ContainmentSelectorImpl.factory);
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static OverlayFactory<ReferencePropertyContext> factory = new OverlayFactory<ReferencePropertyContext>() {

		@Override
		protected Class<? extends JsonOverlay<? super ReferencePropertyContext>> getOverlayClass() {
			return ReferencePropertyContextImpl.class;
		}

		@Override
		public JsonOverlay<ReferencePropertyContext> _create(ReferencePropertyContext referencePropertyContext,
				JsonOverlay<?> parent, ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new ReferencePropertyContextImpl(referencePropertyContext, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<ReferencePropertyContext> castOverlay = (JsonOverlay<ReferencePropertyContext>) overlay;
			return castOverlay;
		}

		@Override
		public JsonOverlay<ReferencePropertyContext> _create(JsonNode json, JsonOverlay<?> parent,
				ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new ReferencePropertyContextImpl(json, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<ReferencePropertyContext> castOverlay = (JsonOverlay<ReferencePropertyContext>) overlay;
			return castOverlay;
		}

		@Override
		protected boolean isExtendedType() {
			return false;
		}
	};

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private static Class<? extends ReferencePropertyContext> getSubtypeOf(
			ReferencePropertyContext referencePropertyContext) {
		return ReferencePropertyContext.class;
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private static Class<? extends ReferencePropertyContext> getSubtypeOf(JsonNode json) {
		return ReferencePropertyContext.class;
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	protected OverlayFactory<?> _getFactory() {
		return factory;
	}
}
