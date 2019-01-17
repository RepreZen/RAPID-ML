/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.xtext.tests

import com.reprezen.rapidml.ReferenceEmbed
import com.reprezen.rapidml.ReferenceLink
import com.reprezen.rapidml.ReferenceTreatment
import com.reprezen.rapidml.ZenModel
import com.reprezen.rapidml.xtext.tests.RapidMLInjectorProvider
import java.util.List
import javax.inject.Inject
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.junit.Test
import org.junit.runner.RunWith

import static org.hamcrest.CoreMatchers.*
import static org.junit.Assert.*

@InjectWith(typeof(RapidMLInjectorProvider))
@RunWith(typeof(XtextRunner))
class ImplicitReferenceLinkTest {
	
	@Inject extension ValidationTestHelper
	

	def String textualModel() {
		'''rapidModel ReferenceTreatmentValidation
	resourceAPI ReferenceTreatmentValidationInterface baseURI "http://my-namespace.com"
		objectResource ReferenceTreatmentValidationResource type DataType1
			only properties
				dataType1_dataType2cont, dataType1_dataType2a
			referenceLink > dataType1_dataType2b
				targetResource DataType2Resource
			referenceEmbed > dataType1_dataType2c
		objectResource DataType2Resource type DataType2
	dataModel ReferenceTreatmentValidationDataModel
		structure DataType1
			id : string
			dataType1_dataType2cont : containing reference DataType2
			dataType1_dataType2cont_b : containing reference DataType2
			dataType1_dataType2cont_c : containing reference DataType2
			dataType1_dataType2a : reference DataType2
			dataType1_dataType2b : reference DataType2
			dataType1_dataType2c : reference DataType2
			dataType1_dataType2d : reference DataType2
		structure DataType2
			id : string
			dataType2_p : string
			dataType2_dataType3cont : reference DataType3
			dataType2_dataType3cont_b : reference DataType3
			dataType2_dataType3a : reference DataType3
			dataType2_dataType3b : reference DataType3
		structure DataType3
			id : string'''
	}

	@Inject ParseHelper<ZenModel> parser
	@Inject extension ZenModelUtils
	private ZenModel model

	@Test
	def void testIncludedReferenceLink() {
		var referenceTreatments = loadModelAndGetReferenceTreatments()
		val filtered = referenceTreatments.findReferenceTreatmentForPropertyName("dataType1_dataType2a")
		assertThat(filtered.size, equalTo(1))
		val refLink = filtered.findFirst[true]
		assertThat(refLink, instanceOf(typeof(ReferenceLink)))
	}

// TODO: FIX
	@Test(expected= AssertionError)
	def void testIncludedReferenceEmbed() {
		var referenceTreatments = loadModelAndGetReferenceTreatments()
		val filtered = referenceTreatments.findReferenceTreatmentForPropertyName("dataType1_dataType2cont")
		assertThat(filtered.size, equalTo(1))
		val refLink = filtered.findFirst[true]
		assertThat(refLink, instanceOf(typeof(ReferenceEmbed)))
	}

	@Test
	def void testExplicitReferenceLink() {
		var referenceTreatments = loadModelAndGetReferenceTreatments()
		val filtered = referenceTreatments.findReferenceTreatmentForPropertyName("dataType1_dataType2b")
		assertThat(filtered.size, equalTo(1))
		val refLink = filtered.findFirst[true]
		assertThat(refLink, instanceOf(typeof(ReferenceLink)))
	}

	@Test
	def void testExplicitEmbedLink() {
		var referenceTreatments = loadModelAndGetReferenceTreatments()
		val filtered = referenceTreatments.findReferenceTreatmentForPropertyName("dataType1_dataType2c")
		assertThat(filtered.size, equalTo(1))
		val refLink = filtered.findFirst[true]
		assertThat(refLink, instanceOf(typeof(ReferenceEmbed)))
	}
	
	@Test
	def void testExplicitEmbedImplicitValues() {
		var referenceTreatments = loadModelAndGetReferenceTreatments()
		val filtered = referenceTreatments.findReferenceTreatmentForPropertyName("dataType1_dataType2c")
		assertThat(filtered.size, equalTo(1))
		val refLink = filtered.findFirst[true]
		assertThat(refLink, instanceOf(typeof(ReferenceEmbed)))
		assertNotNull(refLink.linkDescriptor)
		assertThat("Invalid number of included properties, actual included properties: "+ refLink.linkDescriptor.allIncludedProperties.map[baseProperty.name], refLink.linkDescriptor.allIncludedProperties.size, equalTo(6))
	}

	@Test
	def void testExcludedReferenceLink() {
		var referenceTreatments = loadModelAndGetReferenceTreatments()
		val filtered = referenceTreatments.findReferenceTreatmentForPropertyName("dataType1_dataType2d")
		assertThat(filtered.size, equalTo(0))
	}

	@Test
	def void testExcludedReferenceEmbed() {
		var referenceTreatments = loadModelAndGetReferenceTreatments()
		val filtered = referenceTreatments.findReferenceTreatmentForPropertyName("dataType1_dataType2cont_b")
		assertThat(filtered.size, equalTo(0))
	}

	def ZenModel loadModel(String referenceTreatment) {
		model = parser.parse(textualModel())
		model.assertNoErrors
		return model
	}

	def List<ReferenceTreatment> loadModelAndGetReferenceTreatments() {
		val model = loadModelAndNormalize(textualModel)
		return model.referenceTreatments
	}
}
