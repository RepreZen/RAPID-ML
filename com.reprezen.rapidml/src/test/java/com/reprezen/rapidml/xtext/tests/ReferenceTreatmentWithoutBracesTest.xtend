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
class ReferenceTreatmentWithoutBracesTest {
	
	@Inject extension ValidationTestHelper
	@Inject ParseHelper<ZenModel> parser
	
	def String textualModel(String referenceTreatment1, String referenceTreatment2) {
		'''
			rapidModel ReferenceEmbed
				resourceAPI ReferenceEmbedInterface baseURI "http://my-namespace.com"
					objectResource ReferenceEmbedObject type myDataType
						«referenceTreatment1»
						«referenceTreatment2»
					objectResource OrderImageOnlineObject type Image
				dataModel ReferenceEmbedDataModel
					structure myDataType
						orderID : string
						orderDate : string
						order : reference DataType3
						image : reference Image
					structure DataType3
						orderID : string
						orderDate : string
						lineItems : reference LineItem
						image : reference Image
					structure LineItem
						id : string
						product : reference Product
						image : reference Image
					structure Product
						productName : string
						productID : string
						productPrice : string
						image : reference Image
					structure Image
						id : string
		'''
	}
	
	@Test
	def void testEmptyReferenceTreatments() {
		var model = parser.parse(textualModel("referenceEmbed > order", "referenceLink > image"))
		model.assertNoErrors
	}
	
	@Test
	def void testEmptyReferenceTreatmentsInsideReferenceEmbed() {
		var model = parser.parse(textualModel(
		'''
				referenceEmbed > order
					referenceEmbed > lineItems
					referenceLink > image
			''', 
			"referenceLink > image"))
		model.assertNoErrors
	}
	
}