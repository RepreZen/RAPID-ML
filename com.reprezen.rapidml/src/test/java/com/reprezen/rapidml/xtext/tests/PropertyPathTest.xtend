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
import com.reprezen.rapidml.RapidmlPackage
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
class PropertyPathTest {

	@Inject extension ValidationTestHelper
	@Inject
	ParseHelper<ZenModel> parser

	def String textualModel(String referenceEmbed) {
		'''
			rapidModel TestModel
				resourceAPI TestInterface baseURI "http://modelsolv.com"
					objectResource TestResource type DataModel.DataType1
						«referenceEmbed»
					objectResource DataType2Resource type DataModel.DataType2
					objectResource DataType3Resource type DataModel.DataType3
					objectResource DataType4Resource type DataModel.DataType4
				dataModel DataModel
					structure DataType1
						dataType1_containment : containing reference DataType2
						dataType1_ref : reference DataType2
					structure DataType2
						dataType2_containment : containing reference DataType3
						dataType2_ref : reference DataType3
					structure DataType3
						dataType3_containment : containing reference DataType4
						dataType3_ref : reference DataType4
					structure DataType4
						dataType4_containment : containing reference DataType1
						dataType4_ref : reference DataType1
		'''
	}
	
	ZenModel model
	
	@Test
	def void testSimpleReference() {
		testPropertyPath("> dataType1_ref", "DataType2Resource")
	}

	@Test
	def void testSecondLevelReference() {
		testPropertyPath(
			'''
				referenceEmbed >dataType1_containment 
					referenceLink >dataType2_ref
						targetResource DataType3Resource
			'''
		)
	}

	@Test
	def void testThirdLevelReference() {
		testPropertyPath(
			'''
				referenceEmbed >dataType1_containment
					referenceEmbed > dataType2_containment
						referenceLink >dataType3_ref
							targetResource DataType4Resource
			'''
		)
	}

//	@Test
//	def void testContainmentFails() {
//		testPropertyPathFails(">dataType1_containment", "DataType2Resource")
//	}

	@Test
	def void testReferenceWithIncorrectPathFails() {
		testPropertyPathFails("> dataType2_ref", "DataType3Resource")
	}

	def void testPropertyPath(String referenceEmbed) {
  		model = parser.parse(textualModel(referenceEmbed))
		model.assertNoErrors
	}
	
	def void testPropertyPath(String testedPath, String targetResource) {
		testPropertyPath(createReferenceTreatmentFor(testedPath, targetResource))
	}
	
	def String createReferenceTreatmentFor(String testedPath, String targetResource) {
		'''
			referenceLink «testedPath»
				targetResource «targetResource»
		''';
	}

	def void testPropertyPathFails(String testedPath, String targetResource) {
  		model = parser.parse(textualModel(createReferenceTreatmentFor(testedPath, targetResource)))
		model.assertError(RapidmlPackage::eINSTANCE.referenceTreatment, 
			"org.eclipse.xtext.diagnostics.Diagnostic.Linking", 
			"Couldn't resolve reference to ReferenceElement")
	}

}
