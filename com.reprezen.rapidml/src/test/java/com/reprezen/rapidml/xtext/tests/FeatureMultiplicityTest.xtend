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
import com.reprezen.rapidml.PrimitiveProperty
import com.reprezen.rapidml.ZenModel
import com.reprezen.rapidml.xtext.tests.RapidMLInjectorProvider
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.junit.Test
import org.junit.runner.RunWith

import static org.hamcrest.CoreMatchers.*
import static org.junit.Assert.*

@InjectWith(typeof(RapidMLInjectorProvider))
@RunWith(typeof(XtextRunner))
class FeatureMultiplicityTest {

	@Inject extension ValidationTestHelper
	@Inject extension ZenModelUtils
	@Inject
	ParseHelper<ZenModel> parser

	def String textualModel(String multiplicity) {
		'''
			rapidModel MyModel
				dataModel myDataModel
					structure User
						login : string«multiplicity»
		'''
	}

	ZenModel model

	@Test
	def void testDefaultMultiplicity() {
		testPrimitiveProperty("", 0, 1)
	}

	@Test
	def void test0to1() {
		testPrimitiveProperty("[0..1]", 0, 1)
	}

	@Test
	def void test1to1() {
		testPrimitiveProperty("[1..1]", 1, 1)
	}

	@Test
	def void test0toUnlimited() {
		testPrimitiveProperty("[0..*]", 0, -1)
	}

	@Test
	def void test1toUnlimited() {
		testPrimitiveProperty("[1..*]", 1, -1)
	}

	@Test
	def void test1to1Shortcut() {
		testPrimitiveProperty("!", 1, 1)
	}

	@Test
	def void test0toUnlimitedShortcut() {
		testPrimitiveProperty("*", 0, -1)
	}

	@Test
	def void test1toUnlimitedShortcut() {
		testPrimitiveProperty("+", 1, -1)
	}

	@Test
	def void test0to1Shortcut() {
		testPrimitiveProperty("?", 0, 1)
	}

	def void testPrimitiveProperty(String xtextNotation, int expectedMinOccurs, int expectedMaxOccurs) {
		model = parser.parse(textualModel(xtextNotation))
		model.assertNoErrors
		val PrimitiveProperty prop1 = requirePrimitiveProperty('login')
		assertThat(prop1.minOccurs, equalTo(expectedMinOccurs))
		assertThat(prop1.maxOccurs, equalTo(expectedMaxOccurs))
	}

	def PrimitiveProperty requirePrimitiveProperty(String expectedName) {
		val interfaceDataType = model.firstInterfaceDataModel.requireInterfaceDataType("User")
		val result = interfaceDataType.ownedFeatures.findFirst[name == expectedName] as PrimitiveProperty
		assertThat(result, notNullValue)
		result
	}
}
