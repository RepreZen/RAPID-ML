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

class ResourceTypeTests<T> extends RealizationTestSuite<T> {
	extension RapidHelper = new RapidHelper

	new(ModelChecker<T> checker) {
		super(checker)
	}

	def testObjectResourceRefsOnly(ZenModel model) {
		model.tbBalanceSheetObject.check [
			named("BalanceSheet_RootObj").selects("RootObjects")
			withProps[
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
				checkedAll
			]
		].thenCheck(model.tbBalanceSheetCollection) [
			named("BalanceSheet_RootColl").selects("RootCollections")
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
				includingRef("comments") [
					named("Comment_Ref").selects("RefObjects")
					withOnlyProps("commentID")
				]
				checkedAll
			]
		]
	}

	def testCollectionResourceRefsOnly(ZenModel model) {
		model.tbBalanceSheetObject.check [
			named("BalanceSheet_RootObj").selects("RootObjects")
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
				includingRef("comments") [
					named("Comment_Ref").selects("RefObjects")
					withOnlyProps("commentID")
				]
				checkedAll
			]
		].thenCheck(model.tbBalanceSheetCollection) [
			named("BalanceSheet_RootColl").selects("RootCollections")
			withProps [
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
				checkedAll
			]
		]
	}
}
