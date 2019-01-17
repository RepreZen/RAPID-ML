/*******************************************************************************
 * Copyright © 2013, 2018 Modelsolv, Inc.
 * All Rights Reserved.
 * 
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.realization.processor

import com.google.common.collect.Sets
import com.reprezen.rapidml.ObjectRealization
import com.reprezen.rapidml.RealizationContainer
import com.reprezen.rapidml.ReferenceLink
import com.reprezen.rapidml.ReferenceProperty
import com.reprezen.rapidml.ReferenceRealization
import com.reprezen.rapidml.ReferenceTreatment
import java.util.Set
import org.junit.rules.ErrorCollector

class RapidModelChecker extends ModelChecker<RealizationContainer> {

	new(ErrorCollector errors) {
		super(errors)
	}

	override createRootChecker(RealizationContainer rzn, ModelChecker<RealizationContainer> base,
		(RootChecker<RealizationContainer>)=>void code) {
		return new RapidRootChecker(rzn, base, code)
	}

	override RealizationContainer getRealization(RealizationContainer rznContainer) {
		return rznContainer
	}

	override getRealizationName(RealizationContainer rzn) {
		return rzn.realizationName
	}

	def ReferenceProperty findReference(ReferenceRealization ref) {
		root.findReference(ref, Sets.<ReferenceTreatment>newHashSet)
	}

	def private ReferenceProperty findReference(RealizationContainer container, ReferenceRealization ref,
		Set<ReferenceTreatment> seen) {
		val treatments = container.referenceTreatments.filter[!seen.contains(it)]
		for (treatment : treatments) {
			if (treatment.referenceRealization == ref) {
				return treatment.referenceElement as ReferenceProperty
			} else {
				seen.add(treatment);
				val found = treatment.referenceRealization.findReference(ref, seen)
				if (found != null) {
					return found
				}
			}
		}
	}

	static class RapidRootChecker extends RootChecker<RealizationContainer> {

		val private RapidModelChecker rapidBase

		new(RealizationContainer rzn, ModelChecker<RealizationContainer> base,
			(RootChecker<RealizationContainer>)=>void code) {
			super(rzn, base, code)
			this.rapidBase = base as RapidModelChecker
		}

		override createPropertiesChecker(ModelChecker<RealizationContainer> base, RealizationContainer rzn,
			(PropertiesChecker<RealizationContainer>)=>void code) {
			return new RapidPropertiesChecker(base, rzn, code)
		}

		override getAllLinks() {
			val refLinks = rzn.referenceTreatments.filter[it instanceof ReferenceLink].map[it as ReferenceLink]
			refLinks.map['''«linkRelation?.name» > «targetResource.name»'''].toList
		}

		override isExempt(String link) {
			return rzn === root
		}

		override announceExempt(String link) {
			println('''
				«rzn.realizationName»: Root link test for «link» suppressed until supported by links processor
			''')
		}

		override getMatchingRule() {
			return rzn.effectiveRealization?.rule
		}

		override boolean sharesRealization(RealizationContainer current, RealizationContainer bookmarked) {
			super.sharesRealization(current, bookmarked) ||
				current.effectiveRealization == bookmarked.effectiveRealization;
		}
	}

	static class RapidPropertiesChecker extends PropertiesChecker<RealizationContainer> {

		val ObjectRealization rapidProperties

		new(ModelChecker<RealizationContainer> base, RealizationContainer rzn,
			(PropertiesChecker<RealizationContainer>)=>void code) {
			super(base, rzn, code)
			rapidProperties = rzn.properties
		}

		override propertyExists(String propName) {
			propName.property != null
		}

		def private getProperty(String propName) {
			rapidProperties.allIncludedProperties.findFirst[baseProperty.name == propName]
		}

		override getAllPropertyNames() {
			rapidProperties.allIncludedProperties.map[baseProperty.name]
		}

		override getPropertiesSize() {
			rapidProperties.allIncludedProperties.size
		}

		override getPropRealization(String propName) {
			val propTreatment = rapidProperties.realizationContainer.referenceTreatments.filter [
				it.referenceElement.name == propName
			]?.head
			propTreatment?.referenceRealization
		}
	}
}
