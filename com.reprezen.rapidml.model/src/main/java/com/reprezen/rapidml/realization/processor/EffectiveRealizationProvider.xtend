/*******************************************************************************
 * Copyright © 2013, 2018 Modelsolv, Inc.
 * All Rights Reserved.
 * 
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.realization.processor

import com.google.common.collect.Lists
import com.google.common.collect.Maps
import com.reprezen.rapidml.realization.model.AbstractPropertySelector
import com.reprezen.rapidml.realization.model.ConditionalLink
import com.reprezen.rapidml.realization.model.ConditionalPropertySet
import com.reprezen.rapidml.realization.model.ExclusivePropertySet
import com.reprezen.rapidml.realization.model.InclusivePropertySet
import com.reprezen.rapidml.realization.model.LinkSpec
import com.reprezen.rapidml.realization.model.LinkStrategy
import com.reprezen.rapidml.realization.model.LinkSwitch
import com.reprezen.rapidml.realization.model.ObjectRealizationSpec
import com.reprezen.rapidml.realization.model.ObjectRealizationStrategy
import com.reprezen.rapidml.realization.model.PropertyRealization
import com.reprezen.rapidml.realization.model.PropertySelector
import com.reprezen.rapidml.realization.model.PropertySetSwitch
import com.reprezen.rapidml.realization.model.RealizationModel
import com.reprezen.rapidml.realization.model.RealizationRule
import com.reprezen.rapidml.realization.model.ReferencePropertyRealization
import com.reprezen.rapidml.realization.model.TargetResourceType
import com.reprezen.rapidml.realization.model.impl.FactoryDefaultRealizationRule
import com.reprezen.rapidml.realization.processor.EffectiveRealization.NestedEffectiveRealization
import com.reprezen.rapidml.ResourceAPI
import com.reprezen.rapidml.ServiceDataResource
import com.reprezen.rapidml.TypedMessage
import com.reprezen.rapidml.TypedRequest
import com.reprezen.rapidml.TypedResponse
import com.reprezen.rapidml.Feature
import com.reprezen.rapidml.ReferenceProperty
import com.reprezen.jsonoverlay.Overlay
import java.util.Collection
import java.util.List
import java.util.Map
import java.util.Optional
import java.util.concurrent.CompletableFuture

class EffectiveRealizationProvider {
	val ContextMatcher rootMatcher
	val EffectiveRealizationRegistry registry
	val RealizationModel governingModel

	new(TypedMessage message, EffectiveRealizationRegistry registry) {
		this.rootMatcher = new ContextMatcher(message)
		this.registry = registry
		this.governingModel = message.governingModel
	}

	new(ServiceDataResource resource, EffectiveRealizationRegistry registry) {
		this.rootMatcher = new ContextMatcher(resource)
		this.registry = registry
		this.governingModel = resource.governingModel
	}

	def Optional<CompletableFuture<EffectiveRealization>> getRootRealization() {
		return matchRoot
	}

	def Optional<CompletableFuture<EffectiveRealization>> getPropertyRealization(ReferenceProperty refProp) {
		return matchProperty(refProp, false)
	}

	def private matchRoot() {
		val match = if(governingModel !== null) rootMatcher.evalSwitch(governingModel) else Optional.of(factoryDefault)
		return match.resolve(rootMatcher.rootContext, false)
	}

	def private matchProperty(ReferenceProperty refProp, boolean nested) {
		val match = if (governingModel !== null)
				rootMatcher.evalSwitch(refProp, governingModel)
			else
				Optional.of(factoryDefault)
		return match.resolve(rootMatcher.getReferenceContext(refProp), nested)
	}

	def private resolve(Optional<RealizationRule> rule, RealizationContext context, boolean nested) {
		if (!rule.isPresent) {
			throw new NoRealizationException
		} else if (rule.get == factoryDefault) {
			return Optional.empty
		} else {
			if (!registry.isRegistered(context.structure, rule.get)) {
				val rzn = rule.get.realization as ObjectRealizationSpec
				val future = new CompletableFuture<EffectiveRealization>
				registry.register(context.structure, rule.get, future)
				future.complete(rzn.elaborateRealization(rule.get, context, nested))
			}
			return Optional.of(registry.get(context.structure, rule.get, true))
		}
	}

	def private EffectiveRealization elaborateRealization(ObjectRealizationSpec spec, RealizationRule rule,
		RealizationContext context, boolean nested) {
		val builder = new EffectiveRealization.Builder(context, rule, this)
		spec.propertySet.resolveProperties(context).entrySet.forEach [
			val feature = it.key
			val propRzn = it.value
			builder.includeProperty(feature.name, propRzn)
			if (propRzn != null && Overlay.of(propRzn.propertyType).present &&
				propRzn.propertyType instanceof ReferencePropertyRealization) {
				val refRzn = propRzn.propertyType as ReferencePropertyRealization
				if (Overlay.of(refRzn.realization).isPresent) {
					val refContext = RealizationContext.of(feature as ReferenceProperty, context.resource)
					val realization = refRzn.realization.resolveRealization(refContext)
					builder.addNestedRealization(feature.name,
						realization.elaborateRealization(null, refContext, true) as NestedEffectiveRealization)
				}
			}
		]
		spec.links.resolveLinks(context).forEach [
			builder.addLink(linkRelation, targetResourceType.resolveTarget(context))
		]
		return builder.build(nested)
	}

	def private ObjectRealizationSpec resolveRealization(ObjectRealizationStrategy strategy,
		RealizationContext context) {
		switch (strategy) {
			ObjectRealizationSpec:
				return strategy
		// No other strategies at this point, other than ObjectRealizationRef, which we'll always 
		// see as the referenced strategy, i.e. as an ObjectRealizationSpec
		}
	}

	def private dispatch Map<Feature, PropertyRealization> resolveProperties(InclusivePropertySet propertySet,
		RealizationContext context) {
		val Map<Feature, PropertyRealization> result = Maps.newHashMap
		val (Feature)=>boolean excluded = if (propertySet.excludedProperties !== null)
				[
					propertySet.excludedProperties.matches(it, context)
				]
			else
				[false]
		for (feature : context.structure.ownedFeatures.filter(excluded.negate)) {
			val realization = propertySet.includedProperties.findFirst[it.matches(feature, context)]
			result.put(feature, realization)
		}
		return result
	}

	def private dispatch Map<Feature, PropertyRealization> resolveProperties(ExclusivePropertySet propertySet,
		RealizationContext context) {
		val Map<Feature, PropertyRealization> result = Maps.newHashMap
		for (feature : context.structure.ownedFeatures) {
			val rzn = propertySet.includedProperties.findFirst[it.matches(feature, context)]
			if (rzn != null) {
				result.put(feature, rzn)
			}
		}
		result
	}

	def private dispatch Map<Feature, PropertyRealization> resolveProperties(ConditionalPropertySet propertySet,
		RealizationContext context) {
		if (ContextMatcher::matches(context, propertySet)) {
			return propertySet.propertySet.resolveProperties(context)
		} else {
			// no match means no included properties
			return Maps.newHashMap
		}
	}

	def private dispatch Map<Feature, PropertyRealization> resolveProperties(PropertySetSwitch propertySet,
		RealizationContext context) {
		val result = ContextMatcher::evalSwitch(context, propertySet)
		if (result.present) {
			return result.get.resolveProperties(context)
		} else {
			// no matching case means no included properties
			return Maps.newHashMap
		}
	}

	def private <T> negate((T)=>boolean predicate) {
		return predicate.andThen[!it]
	}

	def private boolean matches(Collection<PropertySelector> selectors, Feature feature, RealizationContext context) {
		return selectors.exists[it.matches(feature, context)]
	}

	def private boolean matches(AbstractPropertySelector selector, Feature feature, RealizationContext context) {
		return new PropertySelectorMatcher(context).matches(feature, selector)
	}

	def private List<LinkSpec> resolveLinks(Collection<LinkStrategy> linkStrategies, RealizationContext context) {
		val List<LinkSpec> result = Lists.newArrayList
		for (linkStrategy : linkStrategies) {
			result.addAll(linkStrategy.resolveLinkStrategy(context))
		}
		return result
	}

	def private dispatch List<LinkSpec> resolveLinkStrategy(LinkSpec strategy, RealizationContext context) {
		return #[strategy]
	}

	def private dispatch List<LinkSpec> resolveLinkStrategy(ConditionalLink strategy, RealizationContext context) {
		if (ContextMatcher::matches(context, strategy)) {
			return strategy.link.resolveLinkStrategy(context)
		} else {
			return #[]
		}
	}

	def private dispatch List<LinkSpec> resolveLinkStrategy(LinkSwitch strategy, RealizationContext context) {
		val link = ContextMatcher::evalSwitch(context, strategy)
		if (link.present) {
			return link.get.resolveLinkStrategy(context)
		} else {
			return #[]
		}
	}

	def private ServiceDataResource resolveTarget(TargetResourceType target, RealizationContext context) {
		return switch (target) {
			case AUTO_LINK_COLLECTION_RESOURCE:
				ContextMatcher::getAutoLinkableCollectionResource(context.structure, context.api)
			case AUTO_LINK_OBJECT_RESOURCE:
				ContextMatcher::getAutoLinkableObjectResource(context.structure, context.api)
			case THIS_RESOURCE:
				null
		}
	}

	def private governingModel(ServiceDataResource resource) {
		(resource.eContainer as ResourceAPI).autoRealizations.head?.realizationModel
	}

	def private governingModel(TypedMessage message) {
		message.resource.governingModel
	}

	def private getResource(TypedMessage message) {
		if (message.resourceType !== null) {
			return message.resourceType as ServiceDataResource
		} else {
			return switch (message) {
				TypedRequest: message.containingMethod.containingResourceDefinition as ServiceDataResource
				TypedResponse: message.containingMethod.containingResourceDefinition as ServiceDataResource
			}
		}
	}

	def private getFactoryDefault() {
		return FactoryDefaultRealizationRule.instance as RealizationRule
	}
}
public class NoRealizationException extends Exception {
}
