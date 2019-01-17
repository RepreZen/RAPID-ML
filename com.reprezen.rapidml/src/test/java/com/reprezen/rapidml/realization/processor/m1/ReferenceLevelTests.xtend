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

class ReferenceLevelTests<T> extends RealizationTestSuite<T> {
	extension RapidHelper = new RapidHelper

	new(ModelChecker<T> checker) {
		super(checker)
	}

	def testRootOnly(ZenModel model) {
		model.tbTaxFilingObject.check [
			named("TaxFiling_Root").selects("RootObjects")
			withProps [
				including("filingID", "jurisdiction", "year", "period", "currency", "grossIncome", "taxLiability")
				includingRef("taxpayer") [
					named("Person_Ref").selects("ReferencedObjects")
					withNoProps
				]
				checkedAll
			]
		].thenCheck(model.tbTaxFilingObject.get_Method.response(404)) [
			named("ErrorResponse_Root").selects("RootObjects")
			withOnlyProps("errorCode", "httpResponseCode", "message")
		]
	}

	def testRootsAndRefs(ZenModel model) {
		model.tbTaxFilingObject.check [
			named("TaxFiling_Root").selects("RootObjects")
			withProps [
				includingRef("taxpayer") [
					named("Person_Ref").selects("ReferencedObjects")
					withOnlyProps("taxpayerID", "lastName", "firstName", "otherNames")
				]
				checkedAll
			]
		].thenCheck(model.tbTaxFilingObject.get_Method.response(404)) [
			named("ErrorResponse_Root").selects("RootObjects")
			withNoProps
		]
	}
}
