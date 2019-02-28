/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 * 
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.xtext.tests.validation

import com.reprezen.rapidml.Enumeration
import com.reprezen.rapidml.ZenModel
import com.reprezen.rapidml.xtext.tests.RapidMLInjectorProvider
import com.reprezen.rapidml.xtext.tests.ZenModelUtils
import com.reprezen.rapidml.xtext.tests.util.ValidatorHelper
import javax.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert

@InjectWith(typeof(RapidMLInjectorProvider))
@RunWith(typeof(XtextRunner))
class EnumerationValidatorTests {

	def String textualModel(String enumType, String enumConstantValue) {
		'''
			rapidModel zen
				dataModel EnumerationsDataModel
					enum «enumType» Suit
						SUIT_CLUBS : «enumConstantValue»
						
		'''
	}

	@Inject ParseHelper<ZenModel> parser
	@Inject extension ZenModelUtils
	@Inject extension ValidatorHelper

	@Test
	def void testValidIntEnum() {
		var enum_ = loadModelAndGetEnumeration("int", "5")
		validate(enum_.enumConstants.get(0)).assertOK
	}

	@Test
	def void testStringConstantInIntEnum() {
		var enum_ = loadModelAndGetEnumeration("int", "\"qwerty\"")
		validate(enum_.enumConstants.get(0)).assertErrorContains("An int enumeration may use only int enum constants")
	}

	@Test
	def void testValidStringEnum() {
		var enum_ = loadModelAndGetEnumeration("string", "\"asdfgh\"")
		validate(enum_.enumConstants.get(0)).assertOK
	}

	@Test
	def void testIntConstantInStringEnum() {
		var enum_ = loadModelAndGetEnumeration("string", "3")
		validate(enum_.enumConstants.get(0)).assertErrorContains(
			"A string enumeration may use only string enum constants")
	}

	@Test
	def void testIntEnumWithoutExplicitValue() {
		val model = parser.parse(
			'''
			rapidModel zen
				dataModel EnumerationsDataModel
					enum int Suit
						SUIT_CLUBS
		''')
		val enum_ = model.firstInterfaceDataModel.firstInterfaceDataType as Enumeration
		validate(enum_.enumConstants.get(0)).assertOK
	}

	@Test
	def void testEnumConstantNameUniqueness() {
		val model = parser.parse(
			'''
			rapidModel zen
				dataModel EnumerationsDataModel
					enum string Numbers
						ONE
						ONE
		''')
		val enum_ = model.firstInterfaceDataModel.firstInterfaceDataType as Enumeration
		validate(enum_).assertErrorContains("Enumeration constants must have unique names")
	}

	@Test
	def void testImplicitLiteralsForSomeStringConstants() {
		val model = parser.parse(
			'''
			rapidModel zen
				dataModel EnumerationsDataModel
					enum string Numbers
						ONE: "one"
						TWO
		''')
		val enum_ = model.firstInterfaceDataModel.firstInterfaceDataType as Enumeration
		validate(enum_).assertOK
		Assert.assertEquals("one", enum_.enumConstants.head.literalValue)
	}

	@Test
	def void testImplicitLiteralsForSomeIntConstants() {
		val model = parser.parse(
			'''
			rapidModel zen
				dataModel EnumerationsDataModel
					enum int Numbers
						ONE
						TWO:2
		''')
		val enum_ = model.firstInterfaceDataModel.firstInterfaceDataType as Enumeration
		validate(enum_).assertOK
	}

	@Test
	def void testDuplicateImplicitLiteralsForSomeIntConstants() {
		val model = parser.parse(
			'''
			rapidModel zen
				dataModel EnumerationsDataModel
					enum int Numbers
						ONE:1
						TWO // TWO will have the integerValue 1 causing a duplicate
		''')
		val enum_ = model.firstInterfaceDataModel.firstInterfaceDataType as Enumeration
		val errors = validate(enum_)
		errors.assertWarningContains("duplicate")
		errors.assertWarningContains("TWO")
	}

	def Enumeration loadModelAndGetEnumeration(String enumType, String enumConstantValue) {
		val model = parser.parse(textualModel(enumType, enumConstantValue))
		val result = model.firstInterfaceDataModel.firstInterfaceDataType as Enumeration
		return result
	}
}
