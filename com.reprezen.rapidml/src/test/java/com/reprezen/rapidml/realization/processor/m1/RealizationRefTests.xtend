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

class RealizationRefTests<T> extends RealizationTestSuite<T> {
	extension RapidHelper = new RapidHelper

	new(ModelChecker<T> checker) {
		super(checker)
	}

	def testKeysInLevelTwoRefs(ZenModel model) {
		model.tbBalanceSheetObject.check [
			named("BalanceSheet_Root").selects("RootObjects")
			withProps [
				includingRef("statement") [
					named("BalanceSheet_Root_statement")
					withProps [
						including("statementID", "statementDate", "beginDate", "endDate", "fiscalYear")
						includingRef("company") [
							named("Company_NonRootRef").selects("NonRootRefObjects")
							withOnlyProps("companyID")
						]
						includingRef("balanceSheet") [
							named("BalanceSheet_NonRootRef").selects("NonRootRefObjects")
							withOnlyProps("balanceSheetID")
						]
						includingRef("incomeStatement") [
							named("IncomeStatement_NonRootRef").selects("NonRootRefObjects")
							withOnlyProps("incomeStatementID")
						]
						includingRef("cashFlowStatement") [
							named("CashFlowStatement_NonRootRef").selects("NonRootRefObjects")
							withOnlyProps("cashFlowStatementID")
						]
						checkedAll
					]
				]
				includingRef("accountingMethod") [
					named("BalanceSheet_Root_accountingMethod")
					withOnlyProps("accountingStandardID", "name", "revision", "revisionDate")
				]
				includingRef("comments") [
					named("BalanceSheet_Root_comments")
					withOnlyProps("commentID", "timestamp", "comment")
				]
				checkedAll
			]
		]
	}

}
