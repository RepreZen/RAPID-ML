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

class LinkSpecTests<T> extends RealizationTestSuite<T> {
	extension RapidHelper = new RapidHelper

	new(ModelChecker<T> checker) {
		super(checker)
	}

	def testCollectionResource(ZenModel model) {
		model.tbIndexObject.check [
			named("Index_Root").selects("ObjectResourceRoot")
			withNoLinks
			withProps [
				includingRef("people") [
					bookmark("pplRzn")
					named("Person_Ref").selects("MultiRefNotLinkableToCR")
					withNoLinks
					withNoProps
				]
				includingRef("accountants") [
					named("Accountant_Ref").selects("MultiRefNotLinkableToCR")
					withNoLinks
					withNoProps
				]
				includingRef("balanceSheets") [
					named("BalanceSheet_Ref").selects("MultiRefNotLinkableToCR")
					withOnlyLink("detail > CommentCollection")
					withProps [
						includingRef("comments") [
							named("Comment_Ref").selects("MultiRefLinkableToCR")
							withNoLinks
							withOnlyProps("commentID")
						].checkedAll
					]
				].checkedAll
			]
		].thenCheck(model.tbCommentCollection) [
			named("Comment_Root").selects("CollectionResourceRoot")
			withNoLinks
			withOnlyProps("commentID")
		].thenCheck(model.tbTaxFilingCollection) [
			named("TaxFiling_Root").selects("CollectionResourceRoot")
			withNoLinks
			withOnlyProps("filingID", "year", "period")
		]
	}

	def testObjectResource(ZenModel model) {
		model.tbFinancialStatementObject.check [
			named("FinancialStatement_Root").selects("RootObjects")
			withOnlyLink("detail > BalanceSheetObject")
			withProps [
				including("statementID")
				includingRef("company") [
					bookmark("coRzn")
					named("Company_Ref").selects("KeyRefNoLinks")
					withOnlyProps("companyID")
				]
				includingRef("balanceSheet") [
					bookmark("bsRzn")
					named("BalanceSheet_Ref").selects("KeyRefWithLinks")
					withOnlyLinks("detail > FinancialStatementObject")
					withProps [
						including("balanceSheetID")
						includingRef("statement") [
							bookmark("stRzn")
							named("FinancialStatement_Ref").selects("KeyRefWithLinks")
							withOnlyLink("detail > BalanceSheetObject")
							withProps [
								including("statementID")
								includingRef("company") [
									shares("coRzn")
								]
								includingRef("balanceSheet") [
									shares("bsRzn")
								]
								includingRef("incomeStatement") [
									bookmark("isRzn")
									named("IncomeStatement_Ref").selects("KeyRefNoLinks")
									withProps [
										including("incomeStatementID")
										includingRef("statement") [
											shares("stRzn")
										]
										includingRef("accountingMethod") [
											bookmark("amRzn").named("AccountingStandard_Ref").selects("KeyRefNoLinks")
											withOnlyProps("accountingStandardID")
										]
										includingRef("comments") [
											bookmark("cmRzn")
											named("Comment_Ref").selects("KeyRefNoLinks")
											withOnlyProps("commentID")
										]
										checkedAll
									]
								]
								includingRef("cashFlowStatement") [
									bookmark("cfRzn")
									named("CashFlowStatement_Ref").selects("KeyRefNoLinks")
									withProps [
										including("cashFlowStatementID")
										includingRef("statement") [
											shares("stRzn")
										]
										includingRef("accountingMethod") [
											shares("amRzn")
										]
										includingRef("comments") [
											shares("cmRzn")
										]
										checkedAll
									]
								]
								checkedAll
							]
						]
						includingRef("accountingMethod") [
							shares("amRzn")
						]
						includingRef("comments") [
							shares("cmRzn")
						]
						checkedAll
					]
				]
				includingRef("incomeStatement") [
					shares("isRzn")
				]
				includingRef("cashFlowStatement") [
					shares("cfRzn")
				]
			]
		].thenCheck(model.tbBalanceSheetObject) [
			named("BalanceSheet_Root").selects("RootObjects")
			withOnlyLinks("detail > FinancialStatementObject")
			withProps [
				including("balanceSheetID")
				includingRef("statement") [
					shares("stRzn")
				]
				includingRef("accountingMethod") [
					shares("amRzn")
				]
				includingRef("comments") [
					shares("cmRzn")
				]
				checkedAll
			]
		]
	}

	def testIncludeAutoLinkableToOR(ZenModel model) {
		model.tbFinancialStatementObject.check [
			named("FinancialStatement_Root").selects("RootObjects")
			withOnlyLinks("detail > BalanceSheetObject")
			withProps [
				including("statementID")
				includingRef("balanceSheet") [
					named("BalanceSheet_Ref").selects("References")
					withNoLinks
					withOnlyProps("balanceSheetID")
				]
				checkedAll
			]
		].thenCheck(model.tbBalanceSheetObject) [
			named("BalanceSheet_Root").selects("RootObjects")
			withOnlyLinks("detail > FinancialStatementObject")
			withProps [
				including("balanceSheetID")
				includingRef("statement") [
					named("FinancialStatement_Ref").selects("References")
					withNoLinks
					withOnlyProps("statementID")
				]
				checkedAll
			]
		]
	}
}
