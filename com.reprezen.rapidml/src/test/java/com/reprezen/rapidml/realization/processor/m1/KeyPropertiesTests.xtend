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

class KeyPropertiesTests<T> extends RealizationTestSuite<T> {
	extension RapidHelper = new RapidHelper

	new(ModelChecker<T> checker) {
		super(checker)
	}

	def testIncludeKeys(ZenModel model) {
		model.tbTaxFilingObject.check [
			named("TaxFiling_Root").selects("RootObjects")
			withProps [
				including("filingID", "jurisdiction", "year", "period", "currency", "grossIncome", "taxLiability")
				includingRef("taxpayer") [
					named("Person_Ref").selects("ReferencedObjects")
					withOnlyProps("taxpayerID")
				]
				checkedAll
			]
		].thenCheck(model.tbTaxFilingObject.get_Method.response(404)) [
			named("ErrorResponse_Root").selects("RootObjects")
			withOnlyProps("errorCode", "httpResponseCode", "message")
		]
	}

	def testIncludeNonKeys(ZenModel model) {
		model.tbTaxFilingObject.check [
			named("TaxFiling_Root").selects("RootObjects")
			withProps [
				including("filingID", "jurisdiction", "year", "period", "currency", "grossIncome", "taxLiability")
				includingRef("taxpayer") [
					named("Person_Ref").selects("ReferencedObjects")
					withOnlyProps("lastName", "firstName", "otherNames")
				]
				checkedAll
			]
		].thenCheck(model.tbTaxFilingObject.get_Method.response(404)) [
			named("ErrorResponse_Root").selects("RootObjects")
			withOnlyProps("errorCode", "httpResponseCode", "message")
		]
	}

	def testExcludeNonKeys(ZenModel model) {
		model.tbTaxFilingObject.check [
			named("TaxFiling_Root").selects("RootObjects")
			withProps [
				including("filingID", "jurisdiction", "year", "period", "currency", "grossIncome", "taxLiability")
				includingRef("taxpayer") [
					named("Person_Ref").selects("ReferencedObjects")
					withOnlyProps("taxpayerID")
				]
				checkedAll
			]
		].thenCheck(model.tbTaxFilingObject.get_Method.response(404)) [
			named("ErrorResponse_Root").selects("RootObjects")
			withOnlyProps("errorCode", "httpResponseCode", "message")
		]
	}

	def testExcludeKeys(ZenModel model) {
		model.tbTaxFilingObject.check [
			named("TaxFiling_Root").selects("RootObjects")
			withProps [
				including("filingID", "jurisdiction", "year", "period", "currency", "grossIncome", "taxLiability")
				includingRef("taxpayer") [
					named("Person_Ref").selects("ReferencedObjects")
					withOnlyProps("lastName", "firstName", "otherNames")
				]
				checkedAll
			]
		].thenCheck(model.tbTaxFilingObject.get_Method.response(404)) [
			named("ErrorResponse_Root").selects("RootObjects")
			withOnlyProps("errorCode", "httpResponseCode", "message")
		]
	}

	def testKeysOrAll(ZenModel model) {
		model.tbAccountantObject.check [
			named("Accountant_Root").selects("RootObjects")
			withProps [
				including("employeeID", "lastName", "firstName")
				includingRef("officeAddress") [
					named("Address_Ref").selects("RefsWithoutKeys")
					withOnlyProps("addressLine1", "addressLine2", "city", "stateOrProvince", "postalCode", "country",
						"attentionLine")
				]
				includingRef("clients") [
					named("Person_Ref").selects("RefsWithKeys")
					withOnlyProps("taxpayerID")
				]
				checkedAll
			]
		]
	}
}
