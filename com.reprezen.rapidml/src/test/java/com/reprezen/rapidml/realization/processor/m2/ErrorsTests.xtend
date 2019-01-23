/*******************************************************************************
i * Copyright © 2013, 2018 Modelsolv, Inc.
 * All Rights Reserved.
 * 
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.realization.processor.m2

import com.reprezen.rapidml.ZenModel
import com.reprezen.rapidml.realization.processor.ModelChecker
import com.reprezen.rapidml.realization.processor.NameCollisionException
import com.reprezen.rapidml.realization.processor.RapidHelper
import com.reprezen.rapidml.realization.processor.RapidModelChecker
import com.reprezen.rapidml.realization.processor.RealizationTestSuite
import java.util.List
import junit.framework.AssertionFailedError
import org.junit.rules.ErrorCollector

class ErrorsTests<T> extends RealizationTestSuite<T> {
	extension RapidHelper = new RapidHelper

	new(ModelChecker<T> checker) {
		super(checker)
	}

	def void testNameCollision(ZenModel model) {
		if (checker instanceof RapidModelChecker) {
			// no need to test this with realization containers, since
			// there are no actual assersions about the realizations;
			// just a check that the registry detects name collisions
			return
		}
		pushChecker
		model.tbPersonObject.check[]
		model.tbTaxFilingObject.check[]
		model.tbPersonCollection.check[]
		model.tbTaxFilingCollection.check[]
		checker.done
		val errors = popChecker
		checkErrors(errors, checker.errors)
	}

	val expectedCollisions = #{"RootRealization" -> #["Person/RootObjects", "TaxFiling/RootObjects"]}

	def private checkErrors(List<Throwable> errors, ErrorCollector collector) {
		for (err : errors.filter[!(it instanceof NameCollisionException)]) {
			collector.addError(err)
		}
		val collisions = errors.filter[it instanceof NameCollisionException].map[it as NameCollisionException]
		for (expected : expectedCollisions.entrySet) {
			if (!collisions.exists[it.matches(expected.key, expected.value)]) {
				collector.addError(
					new AssertionFailedError('''Did not detect name collision for name "«expected.key» [«expected.value»]'''))
			}
		}
		for (actual : collisions) {
			if (!expectedCollisions.entrySet.exists[actual.matches(key, value)]) {
				collector.addError(
					new AssertionFailedError('''Unexpected name collision for «actual.name» [«actual.keys»]'''))
			}
		}
	}

}
