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
import com.reprezen.rapidml.xtext.validation.XtextDslJavaValidator
import org.eclipse.emf.common.util.Diagnostic
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.junit4.validation.ValidatorTester
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*

@InjectWith(typeof(RapidMLInjectorProvider))
@RunWith(typeof(XtextRunner))
class CircularInheritanceTest {

	@Inject ParseHelper<ZenModel> parser
	@Inject ValidatorTester<XtextDslJavaValidator> tester;

	@Test
	def void test_Error_OnExtendsItself() {
		val modelText = '''
rapidModel Inheritance

	dataModel Inheritance_DataModel
				
		structure Type1 extends Type2
			prop1 : string
		
		structure Type2 extends Type1
			prop2 : string 
		'''
		val model = parser.parse(modelText)
		val diagnostics = tester.validate(model)

		assertNotEquals(Diagnostic::OK, diagnostics.diagnostic.severity)

		for (d : diagnostics.diagnostic.children) {
			assertEquals("Circular inheritance, please check that the supertype hierarchy does not contain loops",
				d.message)
			assertEquals(Diagnostic.ERROR, d.severity);
		}
	}

	@Test
	def void test_Error_OnExtendsItself2() {
		val modelText = '''
rapidModel Inheritance

	dataModel Inheritance_DataModel
				
		structure Type1 extends Type2
			prop1 : string
		
		structure Type2 extends Type1
			prop2 : string 

		structure Type3 extends Type1
			prop3 : string 
		'''
		val model = parser.parse(modelText)
		val diagnostics = tester.validate(model)

		assertNotEquals(Diagnostic::OK, diagnostics.diagnostic.severity)

		for (d : diagnostics.diagnostic.children) {
			assertEquals("Circular inheritance, please check that the supertype hierarchy does not contain loops",
				d.message)
			assertEquals(Diagnostic.ERROR, d.severity);
		}
	}

	@Test
	def void test_Error_OnSecondLevelInheritance() {
		val modelText = '''
rapidModel Inheritance

	dataModel Inheritance_DataModel
				
		structure Type1 extends Type3
			prop1 : string
		
		structure Type2 extends Type1
			prop2 : string 

		structure Type3 extends Type2
			prop3 : string 
		'''
		val model = parser.parse(modelText)
		val diagnostics = tester.validate(model)

		assertNotEquals(Diagnostic::OK, diagnostics.diagnostic.severity)

		for (d : diagnostics.diagnostic.children) {
			assertEquals("Circular inheritance, please check that the supertype hierarchy does not contain loops",
				d.message)
			assertEquals(Diagnostic.ERROR, d.severity);
		}
	}

}
