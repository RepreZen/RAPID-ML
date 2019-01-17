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

class ContainmentTests<T> extends RealizationTestSuite<T> {

	extension RapidHelper = new RapidHelper

	new(ModelChecker<T> checker) {
		super(checker)
	}

	def testContainingRefs(ZenModel model) {
		model.api("TaxBlasterAPI").resource("AccountantObject").check [
			named("Accountant_Root").selects("RootObjects")
			withProps [
				including("employeeID", "lastName", "firstName")
				includingRef("officeAddress") [
					named("Address_ContainingRef")
					withOnlyProps("addressLine1", "addressLine2", "city", "stateOrProvince", "postalCode", "country",
						"attentionLine")
				]
				includingRef("clients") [
					named("Person_NonContainingRef").selects("NonContainingRefs")
					withOnlyProps("taxpayerID")
				]
				checkedAll
			]
		]
	}

	def testContainerRefs(ZenModel model) {
		model.tbFinancialStatementObject.check [
			named("FinancialStatement_Root").selects("RootObjects")
			withProps [
				including("statementID", "statementDate", "beginDate", "endDate", "fiscalYear")
				includingRef("company") [
					named("Company_NonContainmentRef").selects("NonContainmentRefs")
					withNoProps
				]
				includingRef("balanceSheet") [
					named("BalanceSheet_ContainingRef").selects("ContainingRefs")
					withProps [
						including("balanceSheetID", "assets", "liabilities", "equity")
						includingRef("statement") [
							bookmark("finStmt")
							named("FinancialStatement_ContainerRef").selects("ContainerRefs")
							withOnlyProps("statementID")
						]
						includingRef("accountingMethod") [
							bookmark("acctMeth")
							named("AccountingStandard_NonContainmentRef").selects("NonContainmentRefs")
							withNoProps
						]
						includingRef("comments") [
							bookmark("comments")
							named("Comment_ContainingRef").selects("ContainingRefs")
							withOnlyProps("commentID", "timestamp", "comment")
						]
						checkedAll
					]
				].includingRef("incomeStatement") [
					named("IncomeStatement_ContainingRef").selects("ContainingRefs")
					withProps [
						including("incomeStatementID", "income", "expenses", "netIncome")
						includingRef("statement") [
							shares("finStmt")
						]
						includingRef("accountingMethod") [
							shares("acctMeth")
						]
						includingRef("comments") [
							shares("comments")
						]
						checkedAll
					]
				].includingRef("cashFlowStatement") [
					named("CashFlowStatement_ContainingRef").selects("ContainingRefs")
					withProps [
						including("cashFlowStatementID", "startingCashPosition", "endingCashPosition")
						includingRef("statement") [
							shares("finStmt")
						]
						includingRef("accountingMethod") [
							shares("acctMeth")
						]
						includingRef("comments") [
							shares("comments")
						]
						checkedAll
					]
				]
				checkedAll
			]
		]
	}

	def testExcludeContainer(ZenModel model) {
		model.tbFinancialStatementObject.check [
			named("FinancialStatement_Root").selects("RootObjects")
			withProps [
				including("statementID", "statementDate", "beginDate", "endDate", "fiscalYear")
				includingRef("company") [
					named("Company_NonContainingRef").selects("NonContainingRefs")
					withOnlyProps("companyID", "companyName")
				]
				includingRef("balanceSheet") [
					named("BalanceSheet_ContainingRef").selects("ContainingRefs")
					withProps [
						including("balanceSheetID", "assets", "liabilities", "equity")
						includingRef("accountingMethod") [
							bookmark("acctMeth")
							named("AccountingStandard_NonContainingRef").selects("NonContainingRefs")
							withOnlyProps("accountingStandardID", "name", "revision", "revisionDate")
						]
						includingRef("comments") [
							bookmark("comments")
							named("Comment_ContainingRef").selects("ContainingRefs")
							withOnlyProps("commentID", "timestamp", "comment")
						]
						checkedAll
					]
				]
				includingRef("incomeStatement") [
					named("IncomeStatement_ContainingRef").selects("ContainingRefs")
					withProps [
						including("incomeStatementID", "income", "expenses", "netIncome")
						includingRef("accountingMethod") [
							shares("acctMeth")
						]
						includingRef("comments") [
							shares("comments")
						]
						checkedAll
					]
				]
				includingRef("cashFlowStatement") [
					named("CashFlowStatement_ContainingRef").selects("ContainingRefs")
					withProps [
						including("cashFlowStatementID", "startingCashPosition", "endingCashPosition")
						includingRef("accountingMethod") [
							shares("acctMeth")
						]
						includingRef("comments") [
							shares("comments")
						]
						checkedAll
					]
				]
			]
		]
	}

	def testExcludeContaining(ZenModel model) {
		model.tbFinancialStatementObject.check [
			named("FinancialStatement_Root").selects("RootObjects")
			withProps [
				including("statementID", "statementDate", "beginDate", "endDate", "fiscalYear")
				includingRef("company") [
					named("Company_Ref").selects("RefObjects")
					withOnlyProps("companyID", "companyName")
				]
				checkedAll
			]
		]
	}

	def testIncludeContainer(ZenModel model) {
		model.tbBalanceSheetObject.check [
			named("BalanceSheet_Root").selects("RootObjects")
			withProps [
				including("balanceSheetID", "assets", "liabilities", "equity")
				includingRef("statement") [
					named("FinancialStatement_Ref").selects("RefObjects")
					withOnlyProps("statementID")
				]
				checkedAll
			]
		].thenCheck(model.tbIncomeStatementObject) [
			named("IncomeStatement_Root").selects("RootObjects")
			withProps [
				including("incomeStatementID", "income", "expenses", "netIncome")
				includingRef("statement") [
					named("FinancialStatement_Ref").selects("RefObjects")
					withOnlyProps("statementID")
				]
				checkedAll
			]
		]
	}

	def testIncludeContaining(ZenModel model) {
		model.tbFinancialStatementObject.check [
			named("FinancialStatement_Root").selects("RootObjects")
			withProps [
				including("statementID", "statementDate", "beginDate", "endDate", "fiscalYear")
				includingRef("balanceSheet") [
					named("BalanceSheet_Ref").selects("RefObjects")
					withOnlyProps("balanceSheetID")
				]
				includingRef("incomeStatement") [
					named("IncomeStatement_Ref").selects("RefObjects")
					withOnlyProps("incomeStatementID")
				]
				includingRef("cashFlowStatement") [
					named("CashFlowStatement_Ref").selects("RefObjects")
					withOnlyProps("cashFlowStatementID")
				]
				checkedAll
			]
		]
	}
}
