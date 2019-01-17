/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.xtext.tests.validation

import com.google.inject.Inject
import com.reprezen.rapidml.ZenModel
import com.reprezen.rapidml.xtext.tests.RapidMLInjectorProvider
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.junit.Test
import org.junit.runner.RunWith

@InjectWith(typeof(RapidMLInjectorProvider))
@RunWith(typeof(XtextRunner))
class DataTypeErroneousCircularDependencyTest {
	@Inject ParseHelper<ZenModel> parser;
	@Inject extension ValidationTestHelper

	/**
     * Test for ZEN-687 Erroneous Circular Dependency warning
     */
	@Test
	def void testFalseCircularDependency() {
		val rapidModel = parser.parse(
			'''
				rapidModel MyModel
					dataModel MyDataModel
						structure Order
							OrderID : string
							LineItems : containing reference LineItem*
							Quantity : decimal
							lineItem : reference LineItem
						structure LineItem
							lineItemID : string
							product : containing reference Product inverse lineItem
							containmentProduct : containing reference Product inverse lineItem2
						structure Product
							lineItem : container reference LineItem inverse product
							lineItem2 : container reference LineItem inverse containmentProduct
							order : reference Order
 			''')
		rapidModel.assertNoIssues
	}
}
