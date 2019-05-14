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
import com.reprezen.rapidml.ReferenceProperty
import com.reprezen.rapidml.ZenModel
import com.reprezen.rapidml.xtext.tests.RapidMLInjectorProvider
import com.reprezen.rapidml.xtext.tests.util.ValidatorTester
import com.reprezen.rapidml.xtext.validation.XtextDslJavaValidator
import org.eclipse.emf.common.util.Diagnostic
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*

@InjectWith(typeof(RapidMLInjectorProvider))
@RunWith(typeof(XtextRunner))
class ReferencePropertyRestrictionTypeTest {

	@Inject ParseHelper<ZenModel> parser
	@Inject ValidatorTester<XtextDslJavaValidator> tester

	def model(String ref) {
		'''
rapidModel TaxBlaster

	resourceAPI TaxBlasterInterface baseURI "http://taxblaster.com/api"
	
	dataModel TaxBlasterDataModel
	
		structure TaxFiling
			filingID : string
			taxpayer : reference to Taxpayer
			jurisdiction : string
			year : gYear
			period : int
			currency : string
			grossIncome : decimal
			taxLiability : decimal

		structure Supertype

		structure Taxpayer extends Supertype
			taxpayerID : string
			
		structure Person extends Taxpayer
			lastName : string
			firstName : string
			otherNames : string*
			dob : date
		
		structure PersonSubtype extends Person
			
		structure IndividualTaxFiling extends TaxFiling
			restrict taxpayer: reference to «ref»
		
		structure UnrelatedType

'''
	}

	@Test
	def void test_OK_OnSameProperty() {
		val model = parser.parse(model("Taxpayer"))
		val diagnostics = tester.validate(model)
		diagnostics.assertOK
	}

	@Test
	def void test_OK_OnDirectSubtype() {
		val model = parser.parse(model("Person"))
		val diagnostics = tester.validate(model)
		diagnostics.assertOK
	}

	@Test
	def void test_OK_OnSecondLevelSubtype() {
		val model = parser.parse(model("PersonSubtype"))
		val diagnostics = tester.validate(model)
		diagnostics.assertOK
	}

	@Test
	def void test_Error_OnUnrelatedType() {
		val model = parser.parse(model("UnrelatedType"))

		val diagnostics = tester.validate(model)

		assertNotEquals(Diagnostic::OK, diagnostics.diagnostic.severity)

		diagnostics.assertErrorContains(
			"The type of property 'taxpayer' is incompatible with inherited property type: 'Taxpayer'")

		val source = diagnostics.diagnostic.children.get(0).data.get(0)
		assertTrue(source instanceof ReferenceProperty)
		assertEquals("Validation error is displayed on a wrong property", "taxpayer", (source as Feature).name)
	}

	@Test
	def void test_Error_OnSupertype() {
		val model = parser.parse(model("Supertype"))

		val diagnostics = tester.validate(model)

		assertNotEquals(Diagnostic::OK, diagnostics.diagnostic.severity)

		diagnostics.assertErrorContains(
			"The type of property 'taxpayer' is incompatible with inherited property type: 'Taxpayer'")

		val source = diagnostics.diagnostic.children.get(0).data.get(0)
		assertTrue(source instanceof ReferenceProperty)
		assertEquals("Validation error is displayed on a wrong property", "taxpayer", (source as Feature).name)
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
			restrict pizza: reference to Type1  
''')
		val diagnostics = tester.validate(model)

		assertNotEquals(Diagnostic::OK, diagnostics.diagnostic.severity)

		diagnostics.assertErrorContains("'pizza' restricts a property which does not exist in extended supertypes")

		val source = diagnostics.diagnostic.children.get(0).data.get(0)
		assertTrue(source instanceof ReferenceProperty)
		assertEquals("Validation error is displayed on a wrong property", "pizza", (source as Feature).name)
	}

}
