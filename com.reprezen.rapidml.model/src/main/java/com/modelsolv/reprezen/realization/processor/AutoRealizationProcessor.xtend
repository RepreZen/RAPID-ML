package com.modelsolv.reprezen.realization.processor

import com.modelsolv.reprezen.realization.processor.RealizationProcessor.IRealizationProcessor
import com.modelsolv.reprezen.rapidml.TypedMessage
import com.modelsolv.reprezen.rapidml.ReferenceProperty
import com.modelsolv.reprezen.rapidml.ServiceDataResource
import java.util.Optional
import com.modelsolv.reprezen.rapidml.CollectionResource
import com.modelsolv.reprezen.rapidml.ObjectResource

class AutoRealizationProcessor implements IRealizationProcessor {

	val private EffectiveRealizationRegistry effectiveRealizationRegistry = new EffectiveRealizationRegistry
	val private RealizationContainerBuilder emfRealizationBuilder = new RealizationContainerBuilder

	def getRegistry() { effectiveRealizationRegistry }

	override processMessage(TypedMessage message) {
		val Optional<EffectiveRealization> realization = effectiveRealizationRegistry.getRealization(message)
		if (realization.isPresent) {
			message.effectiveRealization = realization.get
			return realization.get().getRule()
		}
		return null
	}

	override processObjectResource(ObjectResource resource) {
		val Optional<EffectiveRealization> realization = effectiveRealizationRegistry.getRealization(resource)
		if (realization.isPresent) {
			resource.effectiveRealization = realization.get
			return realization.get().getRule()
		}
		return null
	}

	override processCollectionResource(CollectionResource resource) {
		val Optional<EffectiveRealization> realization = effectiveRealizationRegistry.getRealization(resource)
		if (realization.isPresent) {
			resource.effectiveRealization = realization.get
			return realization.get().getRule()
		}
		return null
	}

	override processReferenceProperty(ReferenceProperty reference, TypedMessage message) {
		val Optional<EffectiveRealization> realization = effectiveRealizationRegistry.getRealization(reference, message)
		if (realization.isPresent) {
			val referenceRealization = realization.get().asReferenceRealization()
			val referenceTreatment = emfRealizationBuilder.buildReferenceTreatment(referenceRealization)
			referenceTreatment.referenceElement = reference
			return referenceTreatment
		}
		return null
	}

	override processReferenceProperty(ReferenceProperty reference, ServiceDataResource contextResource) {
		val Optional<EffectiveRealization> realization = effectiveRealizationRegistry.getRealization(reference, contextResource)
		if (realization.isPresent) {
			val referenceRealization = realization.get().asReferenceRealization()
			val referenceTreatment = emfRealizationBuilder.buildReferenceTreatment(referenceRealization)
			referenceTreatment.referenceElement = reference
			return referenceTreatment
		}
		return null
	}

}
