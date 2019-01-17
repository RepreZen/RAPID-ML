/*******************************************************************************
 * Copyright © 2013, 2018 Modelsolv, Inc.
 * All Rights Reserved.
 * 
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.realization.processor.m2

import com.reprezen.rapidml.ZenModel
import com.reprezen.rapidml.realization.processor.ModelChecker
import com.reprezen.rapidml.realization.processor.RapidHelper
import com.reprezen.rapidml.realization.processor.RealizationTestSuite

class ReuseTests<T> extends RealizationTestSuite<T> {
	extension RapidHelper = new RapidHelper

	new(ModelChecker<T> checker) {
		super(checker)
	}

	def testCollectionRoots(ZenModel model) {
		model.tbPersonCollection.check [
			bookmark("pc")
			named("Person_Root").selects("RootObjects")
			checkedAllLinks
			withOnlyProps("taxpayerID", "lastName", "firstName", "otherNames")
		].thenCheck(model.tbApi.resource("AccountantClients")) [
			shares("pc", "ac")
		]
	}

	def testObjectAndMessageRoots(ZenModel model) {
		model.tbPersonObject.check [
			bookmark("po")
			named("Person_Root").selects("RootObjects")
			withNoLinks
			withOnlyProps("taxpayerID", "lastName", "firstName", "otherNames")
		].thenCheck(model.tbPersonObject.get_Method.normalResponse) [
			shares("po", "po-get-200")
		].thenCheck(model.tbPersonCollection.method("POST").request) [
			shares("po", "pc-post-req")
		].thenCheck(model.tbPersonCollection.method("POST").normalResponse) [
			shares("po", "pc-post-200")
		]
	}

	def testSingleValuedRootsAndRefs(ZenModel model) {
		model.tbPersonObject.check [
			bookmark("po")
			named("Person_Object").selects("SingleValued")
			withNoLinks.withOnlyProps("taxpayerID", "lastName", "firstName", "otherNames")
		].thenCheck(model.tbPersonObject.get_Method.normalResponse) [
			shares("po", "po-get-200")
		].thenCheck(model.tbTaxFilingObject) [
			named("TaxFiling_Object").selects("SingleValued")
			withProps [
				including("filingID", "jurisdiction", "year", "period", "currency", "grossIncome", "taxLiability")
				includingRef("taxpayer") [
					shares("po", "tfo-taxpayer")
				]
				checkedAll
			]
		].thenCheck(model.tbPersonCollection.method("POST").request) [
			shares("po", "pc-post-req")
		].thenCheck(model.tbPersonCollection.method("POST").normalResponse) [
			shares("po", "pc-post-200")
		]
	}

	def testMultiValuedRootsAndRefs(ZenModel model) {
		model.tbPersonCollection.check [
			bookmark("pc")
			named("Person_List").selects("MultiValued")
			withNoLinks
			withNoProps
		].thenCheck(model.tbPersonCollection.get_Method.normalResponse) [
			shares("pc", "pc-get-200")
		].thenCheck(model.tbAccountantObject) [
			named("Accountant_Object").selects("SingleValued")
			withNoLinks
			withProps[
				including("employeeID", "lastName", "firstName")
				includingRef("officeAddress") [
					named("Address_Object").selects("SingleValued")
					withNoLinks
					withOnlyProps("addressLine1", "addressLine2", "city", "stateOrProvince", "postalCode", "country",
						"attentionLine")
				]
				includingRef("clients")[shares("pc", "ao-clients")]
				checkedAll
			]
		].thenCheck(model.tbAccountantObject) [
			bookmark("ao").named("Accountant_Object").selects("SingleValued").checkedAllLinks.withProps [
				including("employeeID", "lastName", "firstName").includingRef("officeAddress")[].includingRef("clients") [
					shares("pc", "ao-clients")
				]
			]
		].thenCheck(model.tbAccountantObject.method("PUT").normalResponse) [
			withProps[
				includingRef("clients") [
					shares("pc", "ao-put-200-clients")
				]
			]
		]
	}

	def testSingleAndMultiValuedRoots(ZenModel model) {
		model.tbPersonObject.check [
			bookmark("po")
			named("Person_Root").selects("RootObjects")
			withNoLinks
			withOnlyProps("taxpayerID", "lastName", "firstName", "otherNames")
		].thenCheck(model.tbPersonObject.get_Method.normalResponse) [
			shares("po", "po-get-200")
		].thenCheck(model.tbPersonCollection) [
			shares("po", "pc")
		].thenCheck(model.tbPersonCollection.method("POST").request) [
			shares("po", "pc-post-req")
		].thenCheck(model.tbPersonCollection.method("POST").normalResponse) [
			shares("po", "pc-post-200")
		].thenCheck(model.tbApi.resource("AccountantClients")) [
			shares("po", "ac")
		].thenCheck(model.tbApi.resource("AccountantClients").method("POST").request) [
			shares("po", "ac")
		].thenCheck(model.tbApi.resource("AccountantClients").method("POST").normalResponse) [
			shares("po", "ac")
		]
	}
}
