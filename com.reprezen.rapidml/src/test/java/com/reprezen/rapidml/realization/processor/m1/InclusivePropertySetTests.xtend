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

class InclusivePropertySetTests<T> extends RealizationTestSuite<T> {
	extension RapidHelper = new RapidHelper

	new(ModelChecker<T> checker) {
		super(checker)
	}

	def testSimple(ZenModel model) {
		model.tbTaxFilingObject.check [
			named("TaxFiling_AllProperties").selects("AllObjectRefsAsInlineObjects")
			withProps [
				including("filingID", "jurisdiction", "year", "period", "currency", "grossIncome", "taxLiability")
				includingRef("taxpayer") [
					named("Person_AllProperties").selects("AllObjectRefsAsInlineObjects")
					withOnlyProps("taxpayerID", "lastName", "firstName", "otherNames")
				]
				checkedAll
			]
		]
	}

	def testExcludePrimitive(ZenModel model) {
		model.tbTaxFilingObject.check [
			named("TaxFiling_AllExceptPrimitive").selects("AllObjects")
			withProps [
				includingRef("taxpayer") [
					named("Person_AllExceptPrimitive").selects("AllObjects")
					withNoProps
				]
				checkedAll
			]
		]
	}

	def testExcludeReference(ZenModel model) {
		model.tbTaxFilingObject.check [
			named("TaxFiling_AllExceptReference").selects("AllObjectRefsAsInlineObjects")
			withOnlyProps("filingID", "jurisdiction", "year", "period", "currency", "grossIncome", "taxLiability")
		]
	}
}
