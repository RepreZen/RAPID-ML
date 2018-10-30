/*******************************************************************************
 * Copyright � 2013, 2018 Modelsolv, Inc.
 * All Rights Reserved.
 * 
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.realization.processor

import com.google.common.collect.Lists
import com.google.common.collect.Maps
import com.reprezen.rapidml.realization.model.RealizationRule
import com.reprezen.rapidml.ResourceAPI
import com.reprezen.rapidml.ServiceDataResource
import com.reprezen.rapidml.TypedMessage
import com.reprezen.rapidml.ReferenceProperty
import com.reprezen.rapidml.Structure
import com.reprezen.jsonoverlay.Overlay
import java.util.List
import java.util.Map
import java.util.Optional
import java.util.concurrent.CompletableFuture

/**
 * Registry for realizations used for a given RAPID model.
 * 
 * The same realization object must be used for every realization applying to a given Structure and based on a given
 * RealizationRule, regardless of the context.
 * 
 * Correct use of this class, which will meet the above requirement, requires the following:
 * 
 * <ul>
 * <li>Instantiate a single registry when processing a RAPID model, and use that registry for all processing of that
 * model</li>
 * <li>For every realization root (resource or message) appearing in the model, obtain a realization from this registry.
 * That realization will automatically include realizations for all reference properties appearing (directly or
 * indirectly) in the root realization.</li>
 * </ul>
 * 
 * Temporarily, realizations are wrapped in {@link Optional}, since factory default realizations are not yet 
 * expressed as realization models. If a requested realization is ever missing, the factory default realization logic 
 * should be applied. This should happen either always nor never for a given {@link ResourceAPI}, depending on whether 
 * that particular API has an associated realization model. 
 * 
 * @author Andy Lowry
 * 
 */
class EffectiveRealizationRegistry {

	val private Map<EffectiveRealizationKey, CompletableFuture<EffectiveRealization>> registry = Maps.newHashMap

	def EffectiveRealization get(Structure type, RealizationRule rule) {
		val future = get(type, rule, false)
		return future.get
	}


	def CompletableFuture<EffectiveRealization> get(Structure type, RealizationRule rule, boolean pendingOk) {
		val future = registry.get(EffectiveRealizationKey.of(type, rule))
		if (future === null || future.done || pendingOk) {
			return future
		} else {
			throw new IllegalStateException("Attempted to retrieve an EffectiveRealization before it was complete")
		}
	}

	def void register(Structure type, RealizationRule rule, EffectiveRealization realization) {
		val future = new CompletableFuture<EffectiveRealization>
		future.complete(realization)
		registry.put(EffectiveRealizationKey.of(type, rule), future)
	}

	def void register(Structure type, RealizationRule rule,
		CompletableFuture<EffectiveRealization> pendingRealization) {
		registry.put(EffectiveRealizationKey.of(type, rule), pendingRealization)
	}

	def Optional<EffectiveRealization> getRealization(ServiceDataResource resource) throws NoRealizationException {
		return new EffectiveRealizationProvider(resource, this).getRootRealization.resolveOptionalFuture
	}

	def Optional<EffectiveRealization> getRealization(TypedMessage message) throws NoRealizationException {
		return new EffectiveRealizationProvider(message, this).rootRealization.resolveOptionalFuture
	}

	def Optional<EffectiveRealization> getRealization(ReferenceProperty reference, TypedMessage message) {
		return new EffectiveRealizationProvider(message, this).getPropertyRealization(reference).resolveOptionalFuture
	}

	def Optional<EffectiveRealization> getRealization(ReferenceProperty reference, ServiceDataResource resource) {
		return new EffectiveRealizationProvider(resource, this).getPropertyRealization(reference).resolveOptionalFuture
	}

	def private Optional<EffectiveRealization> resolveOptionalFuture(
		Optional<CompletableFuture<EffectiveRealization>> future) {
		if (future.present) {
			if (future.get.done) {
				return Optional.of(future.get.get)
			} else {
				throw new IllegalStateException("Attempted to retrieve an EffectiveRealization before it was complete")
			}
		} else {
			return Optional.empty
		}
	}

	def boolean isRegistered(Structure type, RealizationRule rule) {
		return registry.containsKey(EffectiveRealizationKey.of(type, rule))
	}

	def Optional<Map<String, List<EffectiveRealizationKey>>> getNameCollisions() {
		val Map<String, List<EffectiveRealizationKey>> namesToKeys = Maps.newHashMap
		registry.entrySet.forEach [
			if (!value.done) {
				throw new IllegalStateException("Cannot check for name conflicts until all futures have completed")
			} else {
				val rzn = value.get
				val name = rzn.getName
				if (!namesToKeys.containsKey(name)) {
					namesToKeys.put(name, Lists.newArrayList)
				}
				namesToKeys.get(name).add(key)
			}
		]
		namesToKeys.entrySet.filter[value.size == 1].toList.forEach[namesToKeys.remove(key)]
		return if(namesToKeys.empty) Optional.empty else Optional.of(namesToKeys)
	}

	public static class EffectiveRealizationKey {

		val private Structure type
		val private RealizationRule rule

		new(Structure type, RealizationRule rule) {
			this.type = type
			this.rule = rule
		}

		def static of(Structure type, RealizationRule rule) {
			return new EffectiveRealizationKey(type, rule)
		}

		def getType() {
			return type
		}

		def getRule() {
			return rule
		}

		override equals(Object o) {
			switch o {
				EffectiveRealizationKey:
					return type === o.type && rule === o.rule
				default:
					return false
			}
		}

		override hashCode() {
			return 51 * System.identityHashCode(type) + System.identityHashCode(rule)
		}

		override String toString() {
			'''«type?.name?:"unknown type"»/«Overlay.of(rule)?.pathInParent?: "unknown rule"»'''
		}
	}

}
