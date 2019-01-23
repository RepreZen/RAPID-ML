/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.xtext.tests.validation

import com.reprezen.rapidml.ReferenceTreatment
import com.reprezen.rapidml.ServiceDataResource
import com.reprezen.rapidml.ZenModel
import com.reprezen.rapidml.xtext.tests.RapidMLInjectorProvider
import com.reprezen.rapidml.xtext.tests.ZenModelUtils
import com.reprezen.rapidml.xtext.validation.XtextDslJavaValidator
import java.util.List
import javax.inject.Inject
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.junit4.validation.ValidatorTester
import org.junit.Test
import org.junit.runner.RunWith

@InjectWith(typeof(RapidMLInjectorProvider))
@RunWith(typeof(XtextRunner))
class ReferenceTreatmentValidatorTests {

	def String textualModel(String referenceTreatmentText) {
		'''
			rapidModel ReferenceTreatmentValidation
				resourceAPI ReferenceTreatmentValidationInterface baseURI "http://my-namespace.com"
					objectResource ReferenceTreatmentValidationResource type DataType1
						referenceLink > dataType1_dataType2a
							targetResource DataType2Resource
						referenceEmbed > dataType1_dataType2b
						referenceEmbed > dataType1_dataType2cont
							 referenceEmbed > dataType2_dataType3a
						«referenceTreatmentText»
					objectResource DataType2Resource type DataType2
				dataModel ReferenceTreatmentValidationDataModel
					structure DataType1
						id : string
						dataType1_dataType2cont : containing reference DataType2
						dataType1_dataType2cont_b : containing reference DataType2
						dataType1_dataType2a : reference DataType2
						dataType1_dataType2b : reference DataType2
					structure DataType2
						id : string
						dataType2_dataType3cont : reference DataType3
						dataType2_dataType3a : reference DataType3
						dataType2_dataType3b : reference DataType3
					structure DataType3
						id : string
		'''
	}

	@Inject ParseHelper<ZenModel> parser
	@Inject extension ZenModelUtils
	private ZenModel model
	@Inject private ValidatorTester<XtextDslJavaValidator> tester;
	val errorMessageFragment = "may have at most one reference treatment"
	
	@Test 
	def void testValidModel() {
		val referenceTreatmentText = ""
		var referenceTreatment = loadModelAndGetReferenceTreatments(referenceTreatmentText).get(0)
		tester.validate(referenceTreatment).assertOK
		referenceTreatment = loadModelAndGetReferenceTreatments(referenceTreatmentText).get(1)
		tester.validate(referenceTreatment).assertOK
		referenceTreatment = loadModelAndGetReferenceTreatments(referenceTreatmentText).get(2)
		tester.validate(referenceTreatment).assertOK
	}
	
	@Test 
	def void testDuplicateReferenceTreatment_simplePath() {
		val referenceTreatmentText = "referenceEmbed > dataType1_dataType2a"
		val referenceTreatment = loadModelAndGetReferenceTreatments(referenceTreatmentText).get(3)
		tester.validate(referenceTreatment).assertErrorContains(errorMessageFragment);
	}
	
	@Test 
	def void testReferenceTreatment_sameFirstFragment() {
		val referenceTreatmentText = 
			'''
				referenceEmbed
					referenceEmbed dataType1_dataType2cont > dataType2_dataType3b
			'''
		val referenceTreatment = loadModelAndGetReferenceTreatments(referenceTreatmentText).get(3)
		tester.validate(referenceTreatment).assertOK
	}

	@Test 
	def void testReferenceTreatment_sameSecondFragment() {
		val referenceTreatmentText = 
			'''
				referenceEmbed > dataType1_dataType2cont_b
					referenceEmbed > dataType2_dataType3a
			'''
		val referenceTreatment = loadModelAndGetReferenceTreatments(referenceTreatmentText).get(3)
		tester.validate(referenceTreatment).assertOK
	}

	@Test 
	def void testReferenceTreatment_samePath() {
		val referenceTreatmentText = 
			'''
				referenceEmbed > dataType1_dataType2cont
					referenceEmbed > dataType2_dataType3a
			'''
		val referenceTreatment = loadModelAndGetReferenceTreatments(referenceTreatmentText).get(3)
		tester.validate(referenceTreatment).assertErrorContains(errorMessageFragment);
	}

	def ZenModel loadModel(String referenceTreatment) {
		model = parser.parse(textualModel(referenceTreatment))
	}
	
	def List<ReferenceTreatment> loadModelAndGetReferenceTreatments(String referenceTreatmentText) {
		val model = loadModel(referenceTreatmentText)
		val resource = model.firstResourceAPI.firstResourceDefinition as ServiceDataResource
		return resource.referenceTreatments
	}
}
