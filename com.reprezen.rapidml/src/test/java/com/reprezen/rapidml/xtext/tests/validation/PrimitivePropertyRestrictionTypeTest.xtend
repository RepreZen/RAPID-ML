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
import com.reprezen.rapidml.Feature
import com.reprezen.rapidml.PrimitiveProperty
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
class PrimitivePropertyRestrictionTypeTest {

	@Inject ParseHelper<ZenModel> parser
	@Inject ValidatorTester<XtextDslJavaValidator> tester;

	def model(String type) {
		'''
rapidModel TaxBlaster

	resourceAPI TaxBlasterInterface baseURI "http://taxblaster.com/api"
	
	dataModel TaxBlasterDataModel
	
		structure TaxFiling
			filingID : TaxFilingIdType
			jurisdiction : string
			year : gYear

		simpleType TaxFilingIdType defined as string
			of length from 2 to 20
	
		simpleType TaxFilingIdTypeWConstraints defined as TaxFilingIdType
			of length from 5 to 19
		
		simpleType SecondLevelType defined as TaxFilingIdTypeWConstraints
			of length 10
		
		structure IndividualTaxFiling extends TaxFiling
			restrict filingID: «type»

'''
	}

	@Test
	def void test_OK_OnSameProperty() {
		val model = parser.parse(model("TaxFilingIdType"))
		val diagnostics = tester.validate(model)
		diagnostics.assertOK
	}

	@Test
	def void test_OK_OnDirectSubtype() {
		val model = parser.parse(model("TaxFilingIdTypeWConstraints"))
		val diagnostics = tester.validate(model)
		diagnostics.assertOK
	}

	@Test
	def void test_OK_OnSecondLevelSubtype() {
		val model = parser.parse(model("SecondLevelType"))
		val diagnostics = tester.validate(model)
		diagnostics.assertOK
	}

	@Test
	def void test_OK_OnSameTypeWithConstraints() {
		val model = parser.parse('''
rapidModel TaxBlaster

	resourceAPI TaxBlasterInterface baseURI "http://taxblaster.com/api"
	
	dataModel TaxBlasterDataModel
	
		structure TaxFiling
			filingID : string
			jurisdiction : string
			year : gYear

		structure IndividualTaxFiling extends TaxFiling
			restrict filingID: string
				of length 10
''')
		val diagnostics = tester.validate(model)
		diagnostics.assertOK
	}

	@Test
	def void test_Error_OnUnrelatedType() {
		val model = parser.parse(model("integer"))

		val diagnostics = tester.validate(model)

		assertNotEquals(Diagnostic::OK, diagnostics.diagnostic.severity)

		diagnostics.assertErrorContains(
			"The type of property 'filingID' is incompatible with inherited property type: 'TaxFilingIdType'")

		val source = diagnostics.diagnostic.children.get(0).data.get(0)
		assertTrue(source instanceof PrimitiveProperty)
		assertEquals("Validation error is displayed on a wrong property", "filingID", (source as Feature).name)
	}

	@Test
	def void test_Error_OnSupertype() {
		val model = parser.parse(model("string"))

		val diagnostics = tester.validate(model)

		assertNotEquals(Diagnostic::OK, diagnostics.diagnostic.severity)

		diagnostics.assertErrorContains(
			"The type of property 'filingID' is incompatible with inherited property type: 'TaxFilingIdType'")

		val source = diagnostics.diagnostic.children.get(0).data.get(0)
		assertTrue(source instanceof PrimitiveProperty)
		assertEquals("Validation error is displayed on a wrong property", "filingID", (source as Feature).name)
	}

	@Test
	def void test_Name_Error_OnRestrictsMissingElement() {
		val model = parser.parse('''
rapidModel TaxBlaster

	resourceAPI TaxBlasterInterface baseURI "http://taxblaster.com/api"
	
	dataModel TaxBlasterDataModel
	
		structure Type1
			filingID : string
			jurisdiction : string
			year : gYear

		structure Type2 extends Type1 
			restrict pizza: string  
''')
		val diagnostics = tester.validate(model)

		assertNotEquals(Diagnostic::OK, diagnostics.diagnostic.severity)

		diagnostics.assertErrorContains("'pizza' restricts a property which does not exist in extended supertypes")

		val source = diagnostics.diagnostic.children.get(0).data.get(0)
		assertTrue(source instanceof PrimitiveProperty)
		assertEquals("Validation error is displayed on a wrong property", "pizza", (source as Feature).name)
	}

	@Test
	def void test_Cadinality_OK_OnCompatible() {
		val model = parser.parse('''
rapidModel TaxBlaster

	resourceAPI TaxBlasterInterface baseURI "http://taxblaster.com/api"
	
	dataModel TaxBlasterDataModel
	
		structure Type1
			prop1 : string
			prop2 : string*
	
		structure Type2 extends Type1 
			 restrict prop1: string!
			 restrict prop2: string+
''')
		val diagnostics = tester.validate(model)

		diagnostics.assertOK
	}

	@Test
	def void test_Cadinality_Error_OnConflicting_singleValued() {
		val model = parser.parse('''
rapidModel TaxBlaster

	resourceAPI TaxBlasterInterface baseURI "http://taxblaster.com/api"
	
	dataModel TaxBlasterDataModel
	
		structure Type1
			prop1 : string!
	
		structure Type2 extends Type1 
			restrict prop1: string
''')
		val diagnostics = tester.validate(model)

		assertNotEquals(Diagnostic::OK, diagnostics.diagnostic.severity)

		diagnostics.assertErrorContains(
			"The cardinality of property 'prop1' is incompatible with inherited property cardinality: '!' ([1, 1])")

		val source = diagnostics.diagnostic.children.get(0).data.get(0)
		assertTrue(source instanceof PrimitiveProperty)
		assertEquals("Validation error is displayed on a wrong property", "prop1", (source as Feature).name)
	}

	@Test
	def void test_Cadinality_Error_OnConflicting_multiValued() {
		val model = parser.parse('''
rapidModel TaxBlaster

	resourceAPI TaxBlasterInterface baseURI "http://taxblaster.com/api"
	
	dataModel TaxBlasterDataModel
	
		structure Type1
			prop2 : string+
	
		structure Type2 extends Type1 
			restrict prop2: string*
''')
		val diagnostics = tester.validate(model)

		assertNotEquals(Diagnostic::OK, diagnostics.diagnostic.severity)

		diagnostics.assertErrorContains(
			"The cardinality of property 'prop2' is incompatible with inherited property cardinality: '+' ([1, *])")

		val source = diagnostics.diagnostic.children.get(0).data.get(0)
		assertTrue(source instanceof PrimitiveProperty)
		assertEquals("Validation error is displayed on a wrong property", "prop2", (source as Feature).name)
	}

	@Test
	def void test_Cadinality_OK_On_multiValued() {
		val model = parser.parse('''
rapidModel TaxBlaster

	resourceAPI TaxBlasterInterface baseURI "http://taxblaster.com/api"
	
	dataModel TaxBlasterDataModel
	
		structure Type1
			prop2 : string*// 1..*
	
		structure Type2 extends Type1 
			restrict prop2: string!//1..1
''')
		val diagnostics = tester.validate(model)

		diagnostics.assertOK
	}
	
}
