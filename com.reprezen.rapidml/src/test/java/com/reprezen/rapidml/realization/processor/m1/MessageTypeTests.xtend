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

class MessageTypeTests<T> extends RealizationTestSuite<T> {
	extension RapidHelper = new RapidHelper

	new(ModelChecker<T> checker) {
		super(checker)
	}

	def testKeysInNoKeysOut(ZenModel model) {
		model.tbBalanceSheetObject.check [
			named("BalanceSheet_Root").selects("RootObjects")
			withProps [
				including("balanceSheetID", "assets", "liabilities", "equity")
				includingRef("statement") [
					bookmark("fsRef")
					named("FinancialStatement_Ref").selects("RefObjects")
					withOnlyProps("statementID")
				]
				includingRef("accountingMethod") [
					bookmark("amRef")
					named("AccountingStandard_Ref").selects("RefObjects")
					withOnlyProps("accountingStandardID")
				]
				includingRef("comments") [
					bookmark("cmRef")
					named("Comment_Ref").selects("RefObjects")
					withOnlyProps("commentID")
				]
				checkedAll
			]
		].thenCheck(model.tbBalanceSheetObject.method("POST").request) [
			named("BalanceSheet_PostReq").selects("POSTRequests")
			withProps [
				including("assets", "liabilities", "equity")
				includingRef("statement") [
					shares("fsRef")
				]
				includingRef("accountingMethod") [
					shares("amRef")
				]
				includingRef("comments") [
					shares("cmRef")
				]
				checkedAll
			]
		].thenCheck(model.tbBalanceSheetObject.method("POST").normalResponse) [
			named("BalanceSheet_PostResp").selects("POST200Response")
			withOnlyProps("balanceSheetID")
		]
	}
}
