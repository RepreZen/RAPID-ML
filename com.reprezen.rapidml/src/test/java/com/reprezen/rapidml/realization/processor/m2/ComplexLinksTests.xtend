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

class ComplexLinksTests<T> extends RealizationTestSuite<T> {
	extension RapidHelper = new RapidHelper

	new(ModelChecker<T> checker) {
		super(checker)
	}

	def testConditionalLink(ZenModel model) {
		model.tbFinancialStatementObject.check [
			named("FinancialStatement_Root").selects("RootObjects")
			withLinks("detail > BalanceSheetObject").checkedAllLinks.withProps [
				including("statementID")
				includingRef("company") [
					bookmark("comp")
					named("Company_Ref").selects("KeyedObjectRefWithLinks")
					withNoLinks
					withOnlyProps("companyID")
				]
				includingRef("balanceSheet") [
					bookmark("bs")
					named("BalanceSheet_Ref").selects("KeyedObjectRefWithLinks")
					withLink("detail > FinancialStatementObject")
					withLink("detail > CommentCollection")
					checkedAllLinks
					withProps [
						including("balanceSheetID")
						includingRef("statement") [
							bookmark("fs")
							named("FinancialStatement_Ref").selects("KeyedObjectRefWithLinks")
							withOnlyLinks("detail > BalanceSheetObject")
							withProps [
								including("statementID")
								includingRef("company") [
									shares("comp", "fs-ref")
								]
								includingRef("balanceSheet") [
									shares("bs", "fs-ref")
								]
								includingRef("incomeStatement") [
									bookmark("is")
									named("IncomeStatement_Ref").selects("KeyedObjectRefWithLinks")
									withLinks("detail > FinancialStatementObject")
									withLinks("detail > CommentCollection")
									checkedAllLinks
									withProps [
										including("incomeStatementID")
										includingRef("statement") [
											shares("fs", "is-ref")
										]
										includingRef("accountingMethod") [
											bookmark("acct")
											named("AccountingStandard_Ref").selects("KeyedObjectRefWithLinks")
											withNoLinks
											withOnlyProps("accountingStandardID")
										]
										includingRef("comments") [
											bookmark("comm")
											named("Comment_Ref").selects("KeyedCollectionRefWithLinks")
											withNoLinks
											withOnlyProps("commentID")
										]
										checkedAll
									]
								]
								includingRef("cashFlowStatement") [
									bookmark("cf")
									named("CashFlowStatement_Ref").selects("KeyedObjectRefWithLinks")
									withLinks("detail > FinancialStatementObject")
									withLinks("detail > CommentCollection")
									checkedAllLinks
									withProps [
										including("cashFlowStatementID")
										includingRef("statement") [
											shares("fs", "cf-ref")
										]
										includingRef("accountingMethod") [
											shares("acct", "cf-ref")
										]
										includingRef("comments") [
											shares("comm", "cf-ref")
										]
										checkedAll
									]
								]
								checkedAll
							]
						]
						includingRef("accountingMethod") [
							shares("acct", "bs-ref")
						]
						includingRef("comments") [
							shares("comm", "bs-ref")
						]
						checkedAll
					]
				]
				includingRef("incomeStatement") [
					shares("is", "fs-obj")
				]
				includingRef("cashFlowStatement") [
					shares("cf", "fs-obj")
				]
				checkedAll
			]
		].thenCheck(model.tbBalanceSheetObject) [
			named("BalanceSheet_Root").selects("RootObjects")
			withLinks("detail > FinancialStatementObject")
			withLinks("detail > CommentCollection")
			checkedAllLinks
			withProps [
				including("balanceSheetID")
				includingRef("statement") [
					shares("fs", "bs-obj")
				]
				includingRef("accountingMethod") [
					shares("acct", "bs-obj")
				]
				includingRef("comments") [
					shares("comm", "bs-obj")
				]
			]
		].thenCheck(model.tbCommentCollection) [
			named("Comment_Root").selects("RootObjects")
			withNoLinks
			withOnlyProps("commentID")
		]
	}

	def testLinkSwitch(ZenModel model) {
		model.tbFinancialStatementObject.check [
			named("FinancialStatement_Root").selects("RootObjects")
			withLinks("objectDetail > BalanceSheetObject")
			checkedAllLinks
			withProps[
				including("statementID")
				includingRef("company") [
					named("Company_Ref").selects("RefObjects")
					withNoLinks
					withOnlyProps("companyID")
				]
				includingRef("balanceSheet") [
					named("BalanceSheet_Ref").selects("RefObjects")
					withNoLinks
					withOnlyProps("balanceSheetID")
				]
				includingRef("incomeStatement") [
					named("IncomeStatement_Ref").selects("RefObjects")
					withNoLinks
					withOnlyProps("incomeStatementID")
				]
				includingRef("cashFlowStatement") [
					named("CashFlowStatement_Ref").selects("RefObjects")
					withNoLinks
					withOnlyProps("cashFlowStatementID")
				]
			]
		].thenCheck(model.tbBalanceSheetObject) [
			named("BalanceSheet_Root").selects("RootObjects")
			withLinks("objectDetail > FinancialStatementObject")
			withLinks("collectionDetail > CommentCollection")
			checkedAllLinks
			withProps[
				including("balanceSheetID")
				includingRef("statement") [
					named("FinancialStatement_Ref").selects("RefObjects")
					withNoLinks
					withOnlyProps("statementID")
				]
				includingRef("accountingMethod") [
					named("AccountingStandard_Ref").selects("RefObjects")
					withNoLinks
					withOnlyProps("accountingStandardID")
				]
				includingRef("comments") [
					named("Comment_Ref").selects("RefObjects")
					withNoLinks
					withOnlyProps("commentID")
				]
				checkedAll
			]

		].thenCheck(model.tbCommentCollection) [
			named("Comment_Root").selects("RootObjects")
			withNoLinks
			withOnlyProps("commentID")
		]
	}
}
