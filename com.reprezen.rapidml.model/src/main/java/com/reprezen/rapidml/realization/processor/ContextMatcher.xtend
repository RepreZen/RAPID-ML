/*******************************************************************************
 * Copyright � 2013, 2018 Modelsolv, Inc.
 * All Rights Reserved.
 * 
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.realization.processor

import com.google.common.collect.Maps
import com.google.common.collect.Sets
import com.reprezen.rapidml.realization.model.ConditionedItem
import com.reprezen.rapidml.realization.model.Conditions
import com.reprezen.rapidml.realization.model.ContextPattern
import com.reprezen.rapidml.realization.model.DefinitionContext
import com.reprezen.rapidml.realization.model.MessageDefinitionContext
import com.reprezen.rapidml.realization.model.MessageTypeSelector
import com.reprezen.rapidml.realization.model.MethodTypeSelector
import com.reprezen.rapidml.realization.model.ReferenceLevelContext
import com.reprezen.rapidml.realization.model.ReferencePropertyContext
import com.reprezen.rapidml.realization.model.ResourceDefinitionContext
import com.reprezen.rapidml.realization.model.ResourceTypeSelector
import com.reprezen.rapidml.realization.model.RootObjectContext
import com.reprezen.rapidml.realization.model.Switchable
import com.reprezen.rapidml.realization.processor.RealizationContext.MessageRealizationContext
import com.reprezen.rapidml.realization.processor.RealizationContext.ReferencePropertyRealizationContext
import com.reprezen.rapidml.realization.processor.RealizationContext.ResourceRealizationContext
import com.reprezen.rapidml.CollectionResource
import com.reprezen.rapidml.HTTPMethods
import com.reprezen.rapidml.ObjectResource
import com.reprezen.rapidml.ResourceAPI
import com.reprezen.rapidml.ServiceDataResource
import com.reprezen.rapidml.TypedMessage
import com.reprezen.rapidml.TypedRequest
import com.reprezen.rapidml.TypedResponse
import com.reprezen.rapidml.ReferenceProperty
import com.reprezen.rapidml.Structure
import com.reprezen.rapidml.util.ResourceFinder
import com.reprezen.jsonoverlay.Overlay
import java.util.Collection
import java.util.Map
import java.util.Optional

import static com.reprezen.rapidml.HTTPMethods.*

class ContextMatcher {

	static extension PropertySelectorMatcher propertySelectorMatcher = new PropertySelectorMatcher

	def static boolean matches(RealizationContext context, Collection<? extends Conditions> patterns) {
		return matchesAny(context, patterns, false)
	}

	def static boolean matchesAny(RealizationContext context, Collection<? extends Conditions> conds,
		boolean noPatternsResult) {
		if (conds.empty) {
			return noPatternsResult
		}
		for (cond : conds) {
			if (context.matches(cond)) {
				return true
			}
		}
		return false
	}

	def static boolean matches(RealizationContext context, ConditionedItem item) {
		return matchesAny(context, item.conditions, item.noConditionsResult);
	}

	def static <T extends ConditionedItem> Optional<T> evalSwitch(RealizationContext context,
		Switchable<T> switchable) {
		val candidates = switchable.candidates
		if (candidates.empty) {
			return switchable.noCandidatesResult
		}
		for (candidate : switchable.candidates) {
			if (context.matches(candidate.conditions)) {
				return Optional.of(candidate);
			}
		}
		return switchable.noMatchingCandidateResult
	}

	val private RealizationContext context

	new(ServiceDataResource resource) {
		this.context = RealizationContext.of(resource)
	}

	new(TypedMessage message) {
		this.context = RealizationContext.of(message)
	}

	def getRootContext() {
		return context
	}

	def getRootResource() {
		return context.resource
	}

	def getReferenceContext(ReferenceProperty refProp) {
		return RealizationContext.of(refProp, rootResource)
	}

	def <T extends ConditionedItem> Optional<T> evalSwitch(Switchable<T> switchable) {
		return context.evalSwitch(switchable)
	}

	def <T extends ConditionedItem> Optional<T> evalSwitch(ReferenceProperty refProp, Switchable<T> switchable) {
		val refPropContext = RealizationContext.of(refProp, context.resource)
		return refPropContext.evalSwitch(switchable)
	}

	def static private boolean matches(RealizationContext context, Conditions cond) {
		if (!cond.checkHasKeys(context)) {
			return false
		}
		if (!cond.checkAutoLinkableToObjectResource(context)) {
			return false
		}
		if (!cond.checkAutoLinkableToCollectionResource(context)) {
			return false
		}
		switch (cond) {
			ContextPattern: {
				if (!context.checkResourceTypeSelector(cond.resourceType)) {
					return false
				}
				if (!context.checkDefinedIn(cond.definedIn)) {
					return false
				}
				if (!context.checkLevelSelector(cond.level)) {
					return false
				}
			}
		}
		return true
	}

	def static private checkHasKeys(Conditions cond, RealizationContext context) {
		return cond.getHasKeys == null || cond.hasKeys() == context.structure.hasKeys
	}

	def static private checkAutoLinkableToObjectResource(Conditions cond, RealizationContext context) {
		return cond.getAutoLinkableToObjectResource == null ||
			cond.isAutoLinkableToObjectResource == context.structure.isAutoLinkableToObjectResource(context.api)
	}

	def static private checkAutoLinkableToCollectionResource(Conditions cond, RealizationContext context) {
		return cond.getAutoLinkableToCollectionResource == null || cond.isAutoLinkableToCollectionResource ==
			context.structure.isAutoLinkableToCollectionResource(context.api)
	}

	def static private boolean hasKeys(Structure struct) {
		for (prop : struct.allPrimitiveProperties) {
			if (prop.key) {
				return true;
			}
		}
	}

	def static public ObjectResource getAutoLinkableObjectResource(Structure struct, ResourceAPI api) {
		api.resourceFinder.findResource(struct, true) as ObjectResource
	}

	def static public boolean isAutoLinkableToObjectResource(Structure struct, ResourceAPI api) {
		getAutoLinkableObjectResource(struct, api) !== null
	}

	def static public CollectionResource getAutoLinkableCollectionResource(Structure struct, ResourceAPI api) {
		api.resourceFinder.findResource(struct, false) as CollectionResource
	}

	def static public boolean isAutoLinkableToCollectionResource(Structure struct, ResourceAPI api) {
		getAutoLinkableCollectionResource(struct, api) !== null
	}

	def static private boolean checkResourceTypeSelector(RealizationContext context,
		ResourceTypeSelector resourceType) {
		if (resourceType == null) {
			return true;
		} else {
			return switch (context.resource) {
				ObjectResource:
					resourceType == ResourceTypeSelector.OBJECT_RESOURCE
				CollectionResource:
					resourceType == ResourceTypeSelector.COLLECTION_RESOURCE
				default:
					throw new IllegalStateException("Root context is neither a ResourceContext nor a MessageContext")
			}
		}
	}

	def static private boolean checkDefinedIn(RealizationContext context, DefinitionContext defContext) {
		return !Overlay.of(defContext).present || switch (defContext) {
			MessageDefinitionContext:
				context instanceof MessageRealizationContext //
				&& checkMethodType(context.subject as TypedMessage, defContext.methodType) //
				&& checkMessageType(context.subject as TypedMessage, defContext.messageType)
			ResourceDefinitionContext:
				context instanceof ResourceRealizationContext
			default:
				false
		}
	}

	val static readOps = Sets.<HTTPMethods>newHashSet(GET, OPTIONS, HEAD)
	val static writeOps = Sets.<HTTPMethods>newHashSet(POST, PUT, PATCH, DELETE)

	def static private checkMethodType(TypedMessage message, MethodTypeSelector methodType) {
		val op = message.method.httpMethod
		return methodType == null || switch (methodType) {
			case READ_METHOD: readOps.contains(op)
			case WRITE_METHOD: writeOps.contains(op)
			case GET_METHOD: op == GET
			case POST_METHOD: op == POST
			case PUT_METHOD: op == PUT
			case PATCH_METHOD: op == PATCH
			case DELETE_METHOD: op == DELETE
			case OPTIONS_METHOD: op == OPTIONS
			case HEAD_METHOD: op == HEAD
			case TRACE_METHOD: op == TRACE
			case CONNECT_METHOD: op == CONNECT
		}
	}

	def static private checkMessageType(TypedMessage message, MessageTypeSelector messageType) {
		val isResponse = message instanceof TypedResponse
		val code = if(isResponse) (message as TypedResponse).statusCode
		return messageType == null || switch (messageType) {
			case REQUEST: !isResponse
			case RESPONSE: isResponse
			case INFORMATIONAL_1xx_RESPONSE: isResponse && code >= 100 && code < 200
			case SUCCESSFUL_2xx_RESPONSE: isResponse && code >= 200 && code < 300
			case REDIRECTION_3xx_RESPONSE: isResponse && code >= 300 && code < 400
			case CLIENT_ERROR_4xx_RESPONSE: isResponse && code >= 400 && code < 500
			case SERVER_ERROR_5xx_RESPONSE: isResponse && code >= 500 && code < 600
		}
	}

	def static private boolean checkLevelSelector(RealizationContext context, ReferenceLevelContext refLevel) {
		return !Overlay.of(refLevel).present || switch (refLevel) {
			RootObjectContext:
				context instanceof ResourceRealizationContext || context instanceof MessageRealizationContext
			ReferencePropertyContext:
				switch (context) {
					ReferencePropertyRealizationContext: {
						val refProp = context.subject as ReferenceProperty
						checkMultiplicity(refProp, refLevel.multiplicity) //
						&& checkReadWrite(refProp, refLevel.readWritability) //
						&& checkRequired(refProp, refLevel.getRequired) //
						&& checkContainment(refProp, refLevel.containment)
					}
					default:
						false
				}
			default:
				false
		}
	}

	val private static Map<ResourceAPI, ResourceFinder> resourceFinders = Maps.newIdentityHashMap

	def static private getResourceFinder(ResourceAPI api) {
		if (!resourceFinders.containsKey(api)) {
			resourceFinders.put(api, new ResourceFinder(api))
		}
		return resourceFinders.get(api)
	}

	def static getMethod(TypedMessage message) {
		switch (message) {
			TypedRequest: message.containingMethod
			TypedResponse: message.containingMethod
		}
	}

	def static getResource(RealizationContext context) {
		val subject = context.subject
		switch subject {
			TypedMessage:
				subject.method.containingResourceDefinition as ServiceDataResource
			ServiceDataResource:
				subject
			ReferenceProperty:
				(context as ReferencePropertyRealizationContext).rootResource
		}
	}

}
