/*******************************************************************************
 * Copyright © 2013, 2018 Modelsolv, Inc.
 * All Rights Reserved.
 * 
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.realization.processor.zen4007

import com.reprezen.rapidml.ZenModel
import com.reprezen.rapidml.realization.processor.ModelChecker
import com.reprezen.rapidml.realization.processor.RapidHelper
import com.reprezen.rapidml.realization.processor.RealizationTestSuite

import static com.reprezen.rapidml.HTTPMethods.POST

class Zen4007Tests<T> extends RealizationTestSuite<T> {
	extension RapidHelper = new RapidHelper

	new(ModelChecker<T> checker) {
		super(checker)
	}

	def testZen4007(ZenModel model) {
		val cfscResource = model.tbApi.resource("CashFlowStatementComments")
		model.tbFinancialStatementObject.check [
			named("FinancialStatement_Root").selects("ObjectResourceRoot")
			withNoLinks
			withNoProps
		].thenCheck(model.tbCommentCollection) [
			bookmark("commColl")
			named("Comment_Root").selects("CollectionResourceRoot")
			withNoLinks
			withOnlyProps("commentID")
		].thenCheck(model.tbApi.resource("BalanceSheetComments")) [
			shares("commColl")
		].thenCheck(model.tbApi.resource("IncomeStatementComments")) [
			shares("commColl")
		].thenCheck(cfscResource) [
			shares("commColl")
		].thenCheck(cfscResource.get_Method.normalResponse) [
			shares("commColl")
		].thenCheck(cfscResource.get_Method.response(400)) [
			bookmark("err")
			named("ErrorResponse_Root").selects("CollectionResourceRoot")
			withNoLinks.withOnlyProps("errorCode")
		].thenCheck(cfscResource.method(POST).response(201)) [
			shares("commColl")
		].thenCheck(cfscResource.method(POST).response(400)) [
			shares("err")
		]
	}
}
