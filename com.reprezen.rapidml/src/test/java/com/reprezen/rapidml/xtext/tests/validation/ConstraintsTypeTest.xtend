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
import com.reprezen.rapidml.xtext.loaders.RepreZenXtextResourceSet
import com.reprezen.rapidml.xtext.nls.Messages
import com.reprezen.rapidml.xtext.tests.RapidMLInjectorProvider
import com.reprezen.rapidml.xtext.validation.XtextDslJavaValidator
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.junit4.validation.AssertableDiagnostics
import org.eclipse.xtext.junit4.validation.ValidatorTester
import org.junit.Test
import org.junit.runner.RunWith

@InjectWith(typeof(RapidMLInjectorProvider))
@RunWith(typeof(XtextRunner))
class ConstraintsTypeTest {
	@Inject ParseHelper<ZenModel> parser;
	@Inject private ValidatorTester<XtextDslJavaValidator> tester;

	@Test
	def void testUserDataType_ValueRangeForStringError() {
		'''
			rapidModel MyModel
				dataModel DataModel
					simpleType StringLenBaseType defined as string
						valueRange from '1' to maximum '10'
		'''.assertError(Messages::XtextDslJavaValidator_constraintsNumericType)
	}

	@Test
	def void testUserDataType_StringForNumericError() {
		'''
			rapidModel MyModel
				dataModel DataModel
					simpleType NumericBaseType defined as double
						length from 0 to 50
		'''.assertError(Messages::XtextDslJavaValidator_constraintsStringType)
	}

	@Test
	def void testStructure_NumericForStringError() {
		'''
			rapidModel MyModel
				dataModel DataModel
					structure Structure
						prop1: string
							valueRange from '1' to maximum '10'
		'''.assertError(Messages::XtextDslJavaValidator_constraintsNumericType)
	}

	@Test
	def void testStructure_StringForNumericError() {
		'''
			rapidModel MyModel
				dataModel DataModel
					structure Structure
						prop1: double
							length from 10
		'''.assertError(Messages::XtextDslJavaValidator_constraintsStringType)
	}

	@Test
	def void testStructure_ConstraintForNonPrimitiveError() {
		'''
			rapidModel MyModel
				dataModel DataModel
					enum int Enum1
						prop1
					structure Structure
						prop1: Enum1
							length from 10
		'''.assertError(Messages::XtextDslJavaValidator_constraintsPrimitiveType)
	}
	
	@Test
	def void testResource_NumericForStringError() {
		'''
			rapidModel MyModel
				resourceAPI ResourceAPI baseURI "http://localhost"
					objectResource MyObject type Structure
						URI /uri
						all properties
							prop1
								valueRange from '1' to '2'
				dataModel DataModel
					enum int Enum1
						prop1
					structure Structure
						prop1: string
		'''.assertError(Messages::XtextDslJavaValidator_constraintsNumericType)
	}

	@Test
	def void testResource_StringForNumericError() {
		'''
			rapidModel MyModel
				resourceAPI ResourceAPI baseURI "http://localhost"
					objectResource MyObject type Structure
						URI /uri
						all properties
							prop1
								length up to 10
				dataModel DataModel
					enum int Enum1
						prop1
					structure Structure
						prop1: double
		'''.assertError(Messages::XtextDslJavaValidator_constraintsStringType)
	}
	
	// in case of infinite loop it will produce fail after 10 seconds
	@Test(timeout = 10000)
	def void testConstraintsCycleError() {
		'''
			rapidModel ConstraintsCycles 
				dataModel DataModel
					simpleType String1Type defined as String2Type
						valueRange from '1' to maximum '10'
					simpleType String2Type defined as String1Type
		'''.assertError(Messages::XtextDslJavaValidator_constraintsPrimitiveType)
	}
	
		@Test
	def void testUserDataType_ValueRangeOK() {
		'''
			rapidModel MyModel
				dataModel DataModel
					simpleType StringLenBaseType defined as string
						length from 0 to 50
		'''.assertOK
	}

	@Test
	def void testUserDataType_StringOK() {
		'''
			rapidModel MyModel
				dataModel DataModel
					simpleType NumericBaseType defined as double
						valueRange from '1' to maximum '10'
		'''.assertOK
	}
	
	def assertError(CharSequence model, String error) {
		val ResourceSet rset = new RepreZenXtextResourceSet();
		val rapidModel = parser.parse(model, rset)
		val diag = tester.validate(rapidModel)
		diag.assertAny(AssertableDiagnostics::errorMsg(error))
	}
	
	def assertOK(CharSequence model) {
		val ResourceSet rset = new RepreZenXtextResourceSet();
		val rapidModel = parser.parse(model, rset)
		val diag = tester.validate(rapidModel)
		diag.assertOK
	}
}
