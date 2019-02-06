package com.reprezen.rapidml.realization.model.impl;

import javax.annotation.Generated;

import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.jsonoverlay.JsonOverlay;
import com.reprezen.jsonoverlay.OverlayFactory;
import com.reprezen.jsonoverlay.ReferenceManager;
import com.reprezen.rapidml.realization.model.ResourceDefinitionContext;

public class ResourceDefinitionContextImpl extends DefinitionContextImpl implements ResourceDefinitionContext {

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public ResourceDefinitionContextImpl(JsonNode json, JsonOverlay<?> parent, ReferenceManager refMgr) {
		super(json, parent, refMgr);
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public ResourceDefinitionContextImpl(ResourceDefinitionContext resourceDefinitionContext, JsonOverlay<?> parent,
			ReferenceManager refMgr) {
		super(resourceDefinitionContext, parent, refMgr);
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	protected void _elaborateJson() {
		super._elaborateJson();
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	public static OverlayFactory<ResourceDefinitionContext> factory = new OverlayFactory<ResourceDefinitionContext>() {

		@Override
		protected Class<? extends JsonOverlay<? super ResourceDefinitionContext>> getOverlayClass() {
			return ResourceDefinitionContextImpl.class;
		}

		@Override
		public JsonOverlay<ResourceDefinitionContext> _create(ResourceDefinitionContext resourceDefinitionContext,
				JsonOverlay<?> parent, ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new ResourceDefinitionContextImpl(resourceDefinitionContext, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<ResourceDefinitionContext> castOverlay = (JsonOverlay<ResourceDefinitionContext>) overlay;
			return castOverlay;
		}

		@Override
		public JsonOverlay<ResourceDefinitionContext> _create(JsonNode json, JsonOverlay<?> parent,
				ReferenceManager refMgr) {
			JsonOverlay<?> overlay;
			overlay = new ResourceDefinitionContextImpl(json, parent, refMgr);
			@SuppressWarnings("unchecked")
			JsonOverlay<ResourceDefinitionContext> castOverlay = (JsonOverlay<ResourceDefinitionContext>) overlay;
			return castOverlay;
		}

		@Override
		protected boolean isExtendedType() {
			return false;
		}
	};

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private static Class<? extends ResourceDefinitionContext> getSubtypeOf(
			ResourceDefinitionContext resourceDefinitionContext) {
		return ResourceDefinitionContext.class;
	}

	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	private static Class<? extends ResourceDefinitionContext> getSubtypeOf(JsonNode json) {
		return ResourceDefinitionContext.class;
	}

	@Override
	@Generated("com.reprezen.jsonoverlay.gen.CodeGenerator")
	protected OverlayFactory<?> _getFactory() {
		return factory;
	}
}
