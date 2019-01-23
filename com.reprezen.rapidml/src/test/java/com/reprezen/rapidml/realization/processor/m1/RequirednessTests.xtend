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

class RequirednessTests<T> extends RealizationTestSuite<T> {

	extension RapidHelper = new RapidHelper

	new(ModelChecker<T> checker) {
		super(checker)
	}

	def testIncludeRequired(ZenModel model) {
		model.tbBalanceSheetObject.check [
			named("BalanceSheet_Root").selects("RootObjects")
			withProps [
				including("assets", "liabilities", "equity")
				includingRef("statement") [
					named("FinancialStatement_Ref").selects("RefObjects")
					withOnlyProps("statementID")
				]
				includingRef("accountingMethod") [
					named("AccountingStandard_Ref").selects("RefObjects")
					withOnlyProps("accountingStandardID")
				]
				includingRef("comments") [
					named("Comment_Ref").selects("RefObjects")
					withOnlyProps("commentID")
				]
			]
		]
	}

	def testExcludeRequired(ZenModel model) {
		// This test case behaves exactly like IncludeRequiredness, but uses `excludeProperties` instead of `includeProperties`
		testIncludeRequired(model)
	}
}
