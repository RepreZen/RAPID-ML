/*******************************************************************************
 * Copyright © 2013, 2018 Modelsolv, Inc.
 * All Rights Reserved.
 * 
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.realization.processor.m1

import com.reprezen.rapidml.ZenModel
import com.reprezen.rapidml.realization.processor.ModelChecker
import com.reprezen.rapidml.realization.processor.RapidHelper
import com.reprezen.rapidml.realization.processor.RealizationTestSuite

class ExclusivePropertySetTests<T> extends RealizationTestSuite<T> {
	extension RapidHelper = new RapidHelper

	new(ModelChecker<T> checker) {
		super(checker)
	}

	def testOnlyReference(ZenModel model) {
		model.tbTaxFilingObject.check [
			named("TaxFiling_OnlyReference").selects("AllObjects")
			withProps [
				includingRef("taxpayer") [
					named("Person_OnlyReference").selects("AllObjects")
					withNoProps
				]
				checkedAll
			]
		]
	}

	def testOnlyPrimitive(ZenModel model) {
		model.tbTaxFilingObject.check [
			named("TaxFiling_OnlyPrimitive").selects("AllObjects")
			withOnlyProps("filingID", "jurisdiction", "year", "period", "currency", "grossIncome", "taxLiability")
		]
	}
}
