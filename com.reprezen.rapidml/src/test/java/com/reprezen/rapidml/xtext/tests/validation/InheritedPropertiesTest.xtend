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
import com.reprezen.rapidml.PrimitiveProperty
import com.reprezen.rapidml.Structure
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
class InheritedPropertiesTest {

	@Inject ParseHelper<ZenModel> parser
	@Inject ValidatorTester<XtextDslJavaValidator> tester;

	@Test
	def void test_Error_OnDuplicateName_noOverride() {
		val modelText = '''
rapidModel Inheritance

	dataModel Inheritance_DataModel
				
		structure Person
			taxpayerID : string
			lastName : string
			firstName : string
			otherNames : string*
		
		structure IndividualTaxpayer extends Person
			clientID : string
			headOfHousehold : boolean
			dob : date
			restrict taxpayerID: string
			firstName : string				
		'''
		val model = parser.parse(modelText)
		val diagnostics = tester.validate(model)

		assertNotEquals(Diagnostic::OK, diagnostics.diagnostic.severity)

		diagnostics.assertErrorContains("Duplicate name: property 'firstName' is already defined in 'Person'")

		val source = diagnostics.diagnostic.children.get(0).data.get(0)
		assertTrue(source instanceof PrimitiveProperty)
		assertEquals("Validation error is displayed on a wrong DataType", "IndividualTaxpayer",
			(source as PrimitiveProperty).containingDataType.name)
	}

	@Test
	def void test_OK_OnDuplicateName_wOverride() {
		val modelText = '''
rapidModel Inheritance

	dataModel Inheritance_DataModel
				
		structure Person
			taxpayerID : string
			lastName : string
			firstName : string
			otherNames : string*
		
		structure IndividualTaxpayer extends Person
			clientID : string
			headOfHousehold : boolean
			dob : date
			restrict taxpayerID: string
			restrict firstName : string				
		'''
		val model = parser.parse(modelText)
		val diagnostics = tester.validate(model)
		diagnostics.assertOK
	}

	@Test
	def void test_OK_OnDiamondInheritance() {
		val modelText = '''
rapidModel Inheritance

	dataModel Inheritance_DataModel
				
		structure Species
			latinName : string
			commonNames : string*
		 
		structure Animal extends Species
			isVertebrate : boolean
			indigenousToRegions : string*
			
		structure EndangeredSpecies extends Species
			endangeredStatus : int
			statusLastUpdated : date
			
		structure EndangeredAnimal extends Animal, EndangeredSpecies
			family : string
			locomotion : string			
		'''
		val model = parser.parse(modelText)
		val diagnostics = tester.validate(model)

		diagnostics.assertOK
	}

	@Test
	def void test_Error_OnDiamondInheritance_wRestriction() {
		val modelText = '''
rapidModel Inheritance

	dataModel Inheritance_DataModel
				
		structure Species
			latinName : string
			commonNames : string*
		 
		structure Animal extends Species
			restrict latinName : string
				of length from 1 to 40
			isVertebrate : boolean
			indigenousToRegions : string*
			
		structure EndangeredSpecies extends Species
			restrict latinName : string
				of length from 1 to 40
			endangeredStatus : int
			statusLastUpdated : date
			
		structure EndangeredAnimal extends Animal, EndangeredSpecies
			family : string
			locomotion : string	
		'''
		val model = parser.parse(modelText)
		val diagnostics = tester.validate(model)

		assertNotEquals(Diagnostic::OK, diagnostics.diagnostic.severity)

		diagnostics.assertErrorContains(
			"Property 'latinName' is defined in more than one branch of the inheritance hierarchy: data types Animal, EndangeredSpecies")

		val source = diagnostics.diagnostic.children.get(0).data.get(0)
		assertTrue(source instanceof Structure)
		assertEquals("Validation error is displayed on a wrong DataType", "EndangeredAnimal",
			(source as Structure).name)
	}

	@Test
	def void test_OK_OnInheritedRestriction() {
		val modelText = '''
rapidModel Inheritance

	dataModel Inheritance_DataModel
				
		structure Species
			latinName : string
			commonNames : string*
		
		structure Animal extends Species
			restrict latinName : string
				of length from 1 to 40
			isVertebrate : boolean
			indigenousToRegions : string*
			
		structure EndangeredSpecies extends Species
			endangeredStatus : int
			statusLastUpdated : date
			
		structure EndangeredAnimal extends Animal, EndangeredSpecies
			family : string
			locomotion : string	
		'''
		val model = parser.parse(modelText)
		val diagnostics = tester.validate(model)

		diagnostics.assertOK
	}

	@Test
	def void test_Error_OnPropertiesFromDifferentBranches() {
		val modelText = '''
rapidModel Inheritance

	dataModel Inheritance_DataModel
				
		structure Manager
			name : string
			title : string
			department : string
			
		structure Director
			name : string
			startDate : date
			endDate : date
			
		structure ManagingDirector extends Manager, Director
			employeeID : string
		'''
		val model = parser.parse(modelText)
		val diagnostics = tester.validate(model)

		assertNotEquals(Diagnostic::OK, diagnostics.diagnostic.severity)

		diagnostics.assertErrorContains(
			"Property 'name' is defined in more than one branch of the inheritance hierarchy: data types Manager, Director")

		val source = diagnostics.diagnostic.children.get(0).data.get(0)
		assertTrue(source instanceof Structure)
		assertEquals("Validation error is displayed on a wrong DataType", "ManagingDirector",
			(source as Structure).name)
	}

	@Test
	def void test_OK_OnDiamondHierarchy2() {
		val modelText = '''
rapidModel Inheritance

	dataModel Inheritance_DataModel
				
		structure HasName
			name : string
		 
		structure Manager extends HasName
			title : string
			department : string
			
		structure Director extends HasName
			startDate : date
			endDate : date
			
		structure ManagingDirector extends Manager, Director
			employeeID : string
		'''
		val model = parser.parse(modelText)
		val diagnostics = tester.validate(model)

		diagnostics.assertOK
	}
}
