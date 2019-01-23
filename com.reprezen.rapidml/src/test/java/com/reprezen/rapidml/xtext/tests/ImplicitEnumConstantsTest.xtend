/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.xtext.tests

import com.reprezen.rapidml.Enumeration
import com.reprezen.rapidml.xtext.tests.RapidMLInjectorProvider
import javax.inject.Inject
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith

import static org.hamcrest.CoreMatchers.*
import static org.junit.Assert.*

@InjectWith(typeof(RapidMLInjectorProvider))
@RunWith(typeof(XtextRunner))
class ImplicitEnumConstantsTest {

	def String textualModel(String enumType) {
		'''
			rapidModel Enumerations
				dataModel EnumerationsDataModel
					enum «enumType» Colors
						RED
						GREEN
						BLUE
		'''
	}

	@Inject extension ZenModelUtils

	@Test
	def void testImplicitEnumLiteralValueForStringEnums() {
		var enum_ = loadModelAndGetEnumeration("string")
		assertThat(enum_.enumConstants.get(0).literalValue, equalTo("RED"))
		assertThat(enum_.enumConstants.get(1).literalValue, equalTo("GREEN"))
		assertThat(enum_.enumConstants.get(2).literalValue, equalTo("BLUE"))
	}

	@Test
	def void testExplicitEnumLiteralValueForStringEnums() {
		val model = loadModelAndNormalize(
			'''
				rapidModel Enumerations
					dataModel EnumerationsDataModel
						enum string Colors
							RED: "red"
							GREEN: "green"
							BLUE: "blue"
			''')
		val enum_ = model.firstInterfaceDataModel.firstInterfaceDataType as Enumeration
		assertThat(enum_.enumConstants.get(0).literalValue, equalTo("red"))
		assertThat(enum_.enumConstants.get(1).literalValue, equalTo("green"))
		assertThat(enum_.enumConstants.get(2).literalValue, equalTo("blue"))
	}

	@Test
	def void testImplicitEnumLiteralValueForIntEnums() {
		var enum_ = loadModelAndGetEnumeration("int")
		assertThat(enum_.enumConstants.get(0).integerValue, equalTo(0))
		assertThat(enum_.enumConstants.get(1).integerValue, equalTo(1))
		assertThat(enum_.enumConstants.get(2).integerValue, equalTo(2))
	}

	@Test
	def void testMixedExplicitAndImplicitEnumValuesForIntEnums() {
		val modelText = 
			'''
				rapidModel Enumerations
					dataModel EnumerationsDataModel
						enum int Colors
							RED:10
							GREEN
							BLUE
			'''
		val model = loadModelAndNormalize(modelText)
		val enum_ = model.firstInterfaceDataModel.firstInterfaceDataType as Enumeration
		assertThat(enum_.enumConstants.get(0).integerValue, equalTo(10))
		assertThat(enum_.enumConstants.get(1).integerValue, equalTo(1))
		assertThat(enum_.enumConstants.get(2).integerValue, equalTo(2))
	}

	def Enumeration loadModelAndGetEnumeration(String enumType) {
		val model = loadModelAndNormalize(textualModel(enumType))
		return model.firstInterfaceDataModel.firstInterfaceDataType as Enumeration
	}
}
