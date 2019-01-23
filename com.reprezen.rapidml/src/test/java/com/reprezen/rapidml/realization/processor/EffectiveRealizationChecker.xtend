/*******************************************************************************
 * Copyright © 2013, 2018 Modelsolv, Inc.
 * All Rights Reserved.
 * 
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.realization.processor

import com.reprezen.rapidml.RealizationContainer
import com.reprezen.rapidml.ServiceDataResource
import com.reprezen.rapidml.TypedMessage
import com.reprezen.rapidml.realization.processor.EffectiveRealization
import com.reprezen.rapidml.realization.processor.EffectiveRealizationRegistry
import org.junit.rules.ErrorCollector

class EffectiveRealizationChecker extends ModelChecker<EffectiveRealization> {

	val registry = new EffectiveRealizationRegistry

	new(ErrorCollector errors) {
		super(errors)
	}

	override EffectiveRealization getRealization(RealizationContainer rznContainer) {
		return switch(rznContainer) {
			ServiceDataResource: registry.getRealization(rznContainer)?.get
			TypedMessage: registry.getRealization(rznContainer)?.get
		}
	}

	override _done() {
		val collisions = registry.nameCollisions
		if (collisions.present) {
			for (name : collisions.get.keySet) {
				try {
					throw new NameCollisionException(name, collisions.get.get(name))
				} catch (Throwable t) {
					errors.addError(t)
				}
			}
		}
	}

	override createRootChecker(EffectiveRealization rzn, ModelChecker<EffectiveRealization> base,
		(RootChecker<EffectiveRealization>)=>void code) {
		return new EffectiveRealizationRootChecker(rzn, base, code)
	}

	override String getRealizationName(EffectiveRealization rzn) {		
		return rzn.getName
	}

	static class EffectiveRealizationRootChecker extends RootChecker<EffectiveRealization> {

		new(EffectiveRealization rzn, ModelChecker<EffectiveRealization> base,
			(RootChecker<EffectiveRealization>)=>void code) {
			super(rzn, base, code)
		}

		override createPropertiesChecker(ModelChecker<EffectiveRealization> base, EffectiveRealization rzn,
			(PropertiesChecker<EffectiveRealization>)=>void code) {
			return new EffectiveRealizationPropertiesChecker(base, rzn, code)
		}

		override getAllLinks() {
			// tests are coded to expect links to appear in the referrer, since that's how RAPID model 
			// works, and it's much easier to code the tests that way and deal adapt this checker than
			// to code them more naturally and adapt the RAPID model checker (since that would require
			// being able to look back at the referrer to find its links). So here we need to collect
			// link objects from our included reference property realizations, not our own
			// (this means that links in roots are never checked!)
			// We should do undo these contortions and recode the tests to expect links in the
			// referrents once we get rid of ReferenceTreatments in the RAPID model
			return rzn.referenceRealizations.values.map[it.links.entrySet.map['''«key» > «value.name»''']].flatten.
				toList
		}

		override getMatchingRule() {
			return rzn.rule
		}

	}

	static class EffectiveRealizationPropertiesChecker extends PropertiesChecker<EffectiveRealization> {

		new(ModelChecker<EffectiveRealization> base, EffectiveRealization rzn,
			(PropertiesChecker<EffectiveRealization>)=>void code) {
			super(base, rzn, code)
		}

		override propertyExists(String propName) {
			rzn.properties.containsKey(propName)
		}

		override getPropRealization(String propName) {
			rzn.referenceRealizations.get(propName)
		}

		override getAllPropertyNames() {
			rzn.properties.keySet
		}

		override getPropertiesSize() {
			rzn.properties.size
		}
	}

}
