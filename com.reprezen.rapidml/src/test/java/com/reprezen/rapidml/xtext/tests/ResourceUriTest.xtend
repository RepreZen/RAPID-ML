/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.xtext.tests

import com.google.inject.Inject
import com.reprezen.rapidml.ZenModel
import com.reprezen.rapidml.xtext.tests.RapidMLInjectorProvider
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.junit.Test
import org.junit.runner.RunWith

@InjectWith(typeof(RapidMLInjectorProvider))
@RunWith(typeof(XtextRunner))
class ResourceUriTest {

	@Inject extension ValidationTestHelper
	@Inject
	ParseHelper<ZenModel> parser

	def String textualModel(String resourceUri) {
		'''
			rapidModel TestModel
				resourceAPI MyInterface
					objectResource myResource type myDataType
						URI «resourceUri»
				dataModel dm
					structure myDataType
						id : string
		'''
	}

	ZenModel model

	@Test
	def void testSimpleUri() {
		testResourceUri("/taxFilings")
	}

	@Test
	def void testCompositeUri() {
		testResourceUri("/taxFilings/person")
	}

	@Test
	def void testCompositeUriWithParam() {
		testResourceUri("/taxFilings/person/{id}")
	}

	@Test
	def void testCompositeUriWithParamInMiddle() {
		testResourceUri("/taxFilings/{id}/person")
	}

	@Test
	def void testCompositeUriWithTwoParams() {
		testResourceUri("/taxFilings/{taxFilingID}/person/{personID}")
	}

	@Test
	def void testUriWithHyphen() {
		testResourceUri("/tax-filings")
	}

	@Test
	def void testUriWithDot() {
		testResourceUri("/tax.filings")
	}

	@Test
	def void testUriWithTilde() {
		testResourceUri("/tax~filings")
	}

	@Test
	def void testUriWithUnderscore() {
		testResourceUri("/tax_filings")
	}

	@Test
	def void testUriWithHex() {
		testResourceUri("/bertram/marie%2Dclaude")
	}
	
	@Test
	def void testUriWithHex2() {
		testResourceUri("schule/1s/%3c/dl%3e%3cp%3e%3ca%20href=/P120")
	}

	@Test
	def void testUriWithDelims1() {
		testResourceUri("/tax!filings")
	}

	@Test
	def void testUriWithDelims2() {
		testResourceUri("/tax$filings")
	}

	@Test
	def void testUriWithDelims3() {
		testResourceUri("/tax&filings")
	}

// TODO: FIX 
	@Test(expected= AssertionError)	
	def void testUriWithDelims4() {
		testResourceUri("/tax'filings")
	}

	@Test
	def void testUriWithDelims5() {
		testResourceUri("/tax(filings")
	}

	@Test
	def void testUriWithDelims6() {
		testResourceUri("/tax)filings")
	}

	@Test
	def void testUriWithDelims7() {
		testResourceUri("/tax*filings")
	}

	@Test
	def void testUriWithDelims8() {
		testResourceUri("/tax+filings")
	}

	@Test
	def void testUriWithDelims9() {
		testResourceUri("/tax,filings")
	}

	@Test
	def void testUriWithDelims10() {
		testResourceUri("/tax;filings")
	}

	@Test
	def void testUriWithDelims11() {
		testResourceUri("/tax=filings")
	}

	def void testResourceUri(String resourceUri) {
		model = parser.parse(textualModel(resourceUri))
		model.assertNoErrors
	}

}
