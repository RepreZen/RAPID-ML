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
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.junit4.validation.ValidatorTester
import org.junit.Test
import org.junit.runner.RunWith

@InjectWith(typeof(RapidMLInjectorProvider))
@RunWith(typeof(XtextRunner))
class DuplicateNameTest {

	def String textualModel(String content) {
		'''
			rapidModel DuplicateNameTest
				«content»
		'''
	}

	@Inject ParseHelper<ZenModel> parser

	@Inject ValidatorTester<XtextDslJavaValidator> tester;

	@Test
	def void testResourceAPI() {
		assureDuplicateError(
			'''
				resourceAPI TestResourceAPI
				resourceAPI TestResourceAPI
			''',
			"TestResourceAPI", "resource API")
	}
	
	@Test
	def void testDataModel() {
		assureDuplicateError(
			'''
				dataModel TestDataModel
					structure S1
				dataModel TestDataModel
					structure S2
			''',
			"TestDataModel", "data model")
	}
	
	@Test
	def void testDataType() {
		assureDuplicateError(
			'''
				dataModel TestDataModel
					structure DataType1
					structure DataType1
			''',
			"DataType1", "data type")
	}
	
	@Test
	def void testDataTypeWithEnum() {
		assureDuplicateError(
			'''
				dataModel TestDataModel
					structure DataType1
					enum string DataType1
			''',
			"DataType1", "data type")
	}
	
	@Test
	def void testDataTypeOnlyEnum() {
		assureDuplicateError(
			'''
				dataModel TestDataModel
					enum int DataType1
						EN1
					enum string DataType1
						EN1
			''',
			"DataType1", "data type")
	}
	
	@Test
	def void testPrimitiveFeature() {
		assureDuplicateError(
			'''
				dataModel TestDataModel
					structure DataType1
						prop1 : string
						prop1 : boolean
			''',
			"prop1", " property")
	}
	
	@Test
	def void testMixedFeature() {
		assureDuplicateError(
			'''
				dataModel TestDataModel
					structure DataType1
						prop1 : string
						prop1 : reference DataType2
					structure DataType2 
			''',
			"prop1", "property")
	}
	
	@Test
	def void testReferenceFeature() {
		assureDuplicateError(
			'''
				dataModel TestDataModel
					structure DataType1
						prop1 : reference to DataType2
						prop1 : reference to DataType2
					structure DataType2
			''',
			"prop1", "property")
	}
	
	def void assureDuplicateError(String content, String objectName, String objectType) {
		val model = parser.parse(
			textualModel(content))
		val diag = tester.validate(model)
		diag.assertErrorContains("Duplicate")
		diag.assertErrorContains("name")
		diag.assertErrorContains(objectName)
		diag.assertErrorContains(objectType)
	}
	
	@Test
	def void testOKStructuresDifferentDataModels() {
		assureOK(
			'''
				dataModel TestDataModel1
					structure DataType1
				dataModel TestDataModel2
						structure DataType1
			''')
	}
	
	@Test
	def void testOKStructureAndEnumDifferentDataModels() {
		assureOK(
			'''
				dataModel TestDataModel1
					structure DataType1
				dataModel TestDataModel2
					enum string DataType1 
			''')
	}
	
	@Test
	def void testOKReferenceFeatureDifferentStructures() {
		assureOK(
			'''
				dataModel TestDataModel
					structure DataType1
						prop1 : reference to DataType3
					structure DataType2
						prop1 : reference to DataType3
					structure DataType3
			''')
	}
	
	@Test
	def void testOKPrimitiveFeaturesDifferentStructures() {
		assureOK(
			'''
				dataModel TestDataModel
					structure DataType1
						prop1 : string
				structure DataType2
					prop1 : string
				structure DataType3
			''')
	}
	
	@Test
	def void testOKReferenceFeatureAndStructure() {
		assureOK(
			'''
				dataModel TestDataModel
					structure DataType1
						DataType2 : reference to DataType3
					structure DataType2
						DataType1 : reference to DataType3
					structure DataType3
			''')
	}
	
	@Test
	def void testOKReferenceFeatureAndEnum() {
		assureOK(
			'''
				dataModel TestDataModel
					structure DataType1
						DataType2 : DataType2
					enum string DataType2
			''')
	}
	
	@Test
	def void testOKPrimitiveFeatureAndStructure() {
		assureOK(
			'''
				dataModel TestDataModel
					structure DataType1
						DataType2 : string
					structure DataType2
						DataType1 : string
			''')
	}
	
	@Test
	def void testOKPrimitiveFeatureAndEnum() {
		assureOK(
			'''
				dataModel TestDataModel
					structure DataType1
						DataType2 : string
					enum string DataType2
			''')
	}
	
	@Test
	def void testOKStructureAndDataModel() {
		assureOK(
			'''
				dataModel TestDataModel1
					structure TestDataModel1
			''')
	}
	
	@Test
	def void testOKEnumAndDataModel() {
		assureOK(
			'''
				dataModel TestDataModel1
					enum string TestDataModel1
			''')
	}
	
	@Test
	def void testOKPrimitiveFeatureAndDataModel() {
		assureOK(
			'''
				dataModel TestDataModel1
					structure DataType1
					TestDataModel1 : string
			''')
	}
	
	@Test
	def void testOKReferenceFeatureAndDataModel() {
		assureOK(
			'''
				dataModel TestDataModel1
					structure DataType1
						TestDataModel1 : reference to DataType2
					structure DataType2
			''')
	}
	
	def assureOK(String content) {
		val model = parser.parse(
			textualModel(content))
		val diag = tester.validate(model)
		diag.assertOK()
	}
}
