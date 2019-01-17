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

class MultiplicityTests<T> extends RealizationTestSuite<T> {

	extension RapidHelper = new RapidHelper

	new(ModelChecker<T> checker) {
		super(checker)
	}

	def testExcludeMultiValued(ZenModel model) {
		model.tbBalanceSheetObject.check [
			named("BalanceSheet_Root").selects("RootObjects")
			withProps [
				including("balanceSheetID", "assets", "liabilities", "equity")
				includingRef("statement") [
					named("FinancialStatement_Ref").selects("RefObjects")
					withOnlyProps("statementID")
				]
				includingRef("accountingMethod") [
					named("AccountingStandard_Ref").selects("RefObjects")
					withOnlyProps("accountingStandardID")
				]
				checkedAll
			]
		]
	}

	def testExcludeSingleValued(ZenModel model) {
		model.tbBalanceSheetObject.check [
			named("BalanceSheet_Root").selects("RootObjects")
			withProps [
				includingRef("comments") [
					named("Comment_Ref").selects("RefObjects")
					withOnlyProps("commentID")
				]
				checkedAll
			]
		]
	}

	def testIncludeMultiValued(ZenModel model) {
		model.tbBalanceSheetObject.check [
			named("BalanceSheet_Root").selects("RootObject")
			withProps [
				includingRef("comments") [
					named("Comment_Ref").selects("RefObjets")
					withOnlyProps("commentID")
				]
				checkedAll
			]
		]
	}

	def testIncludeSingleValued(ZenModel model) {
		model.tbBalanceSheetObject.check [
			named("BalanceSheet_Root").selects("RootObjects")
			withProps [
				including("balanceSheetId", "assets", "liabilities", "equity")
				includingRef("statement") [
					named("FinancialStatement_Ref").selects("RefObjects")
					withOnlyProps("statementID")
				]
				includingRef("accountingMethod") [
					named("AccountingStandard_Ref").selects("RefObjects")
					withOnlyProps("accountingStandardID")
				]
				checkedAll
			]
		]
	}

	def testMatch(ZenModel model) {
		model.tbBalanceSheetObject.check [
			named("BalanceSheet_Root").selects("RootObjects")
			withProps [
				including("balanceSheetID", "assets", "liabilities", "equity")
				includingRef("statement") [
					named("FinancialStatement_SingleValuedRef").selects("SingleValuedRefObjects")
					withOnlyProps("statementID", "statementDate", "beginDate", "endDate", "fiscalYear")
				]
				includingRef("accountingMethod") [
					named("AccountingStandard_SingleValuedRef").selects("SingleValuedRefObjects")
					withOnlyProps("accountingStandardID", "name", "revision", "revisionDate")
				]
				includingRef("comments") [
					named("Comment_MultiValuedRef").selects("MultiValuedRefObjects")
					withOnlyProps("commentID")
				]
				checkedAll
			]
		]
	}
}
