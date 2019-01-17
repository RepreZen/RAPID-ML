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
import com.reprezen.rapidml.ServiceDataResource
import com.reprezen.rapidml.ZenModel
import com.reprezen.rapidml.xtext.tests.RapidMLInjectorProvider
import com.reprezen.rapidml.xtext.tests.ZenModelUtils
import com.reprezen.rapidml.xtext.validation.XtextDslJavaValidator
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.junit4.validation.AssertableDiagnostics
import org.eclipse.xtext.junit4.validation.ValidatorTester
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*

@InjectWith(typeof(RapidMLInjectorProvider))
@RunWith(typeof(XtextRunner))
class IncorrectElementOrderTest {

	@Inject ParseHelper<ZenModel> parser
	@Inject extension ValidatorTester<XtextDslJavaValidator> tester
	@Inject extension ZenModelUtils
	
	def String textualModel(String resource) {
		'''
			rapidModel TaxBlaster
				resourceAPI TaxBlasterInterface baseURI "http://taxblaster.com/api"
					«resource»
				dataModel TaxBlasterDataModel
					structure TaxFiling
						filingID : integer
						taxpayer : reference Person
						controller : reference Person
					structure Person
		'''
	}
	
	def tripleQuotes() {
		"'''"
	}
	
	def String getIncorrectCollectionResource() {
		'''
			collectionResource TaxFilingCollection type TaxFiling
				URI index
				method GET getIndex
					response TaxFilingCollection statusCode 200
					response statusCode 404
				referenceLink > taxpayer
				only properties
					filingID, taxpayer
				collectionParam param1 type string
				referenceEmbed > controller
				example «tripleQuotes» «tripleQuotes»
				linkDescriptor desc
				mediaTypes
					application/xml, application/atom+xml
		'''
	}
	
	def String getIncorrectObjectResource() {
		'''
			objectResource TaxFilingObject type TaxFiling
				URI index
				linkDescriptor desc
				method GET getIndex
					response TaxFilingObject statusCode 200
					response statusCode 404
				referenceLink > taxpayer
				only properties
					filingID, taxpayer
				referenceEmbed > controller
				example «tripleQuotes» «tripleQuotes»
				mediaTypes
					application/xml
		'''
	}
	
	def String getCorrectObjectResource() {
		'''
			objectResource TaxFilingObject type TaxFiling
				URI index
				only properties
					filingID
					taxpayer
				referenceLink > taxpayer
				referenceEmbed > controller
				linkDescriptor desc
				mediaTypes
					application/xml
				method GET getIndex
					response TaxFilingObject statusCode 200
					response statusCode 404
				example «tripleQuotes» «tripleQuotes»
		'''
	}
	
	def String getCorrectCollectionResource() {
		'''
			collectionResource TaxFilingCollection type TaxFiling
				URI index
				collectionParam name type string 
				only properties
					filingID
					taxpayer
					controller
				referenceLink > controller
				referenceEmbed > taxpayer
				linkDescriptor desc
				mediaTypes
					application/xml
				method GET getIndex
					response TaxFilingCollection statusCode 200
					response statusCode 404
				example «tripleQuotes» «tripleQuotes»
		'''
	}

	def String getCorrectCollectionResourceExamples() {
		'''
			collectionResource TaxFilingCollection type TaxFiling
				URI index
				collectionParam name type string 
				only properties
					filingID
					taxpayer
					controller
				referenceLink > controller
				referenceEmbed > taxpayer
				linkDescriptor desc
				mediaTypes
					application/xml
				method GET getIndex
					response TaxFilingCollection statusCode 200
					response statusCode 404
						example «tripleQuotes» «tripleQuotes»
				method GET getIndex2
					response TaxFilingCollection statusCode 200
					response statusCode 404
						example «tripleQuotes» «tripleQuotes»
				example «tripleQuotes» «tripleQuotes»
		'''
	}
	
		def String getCorrectObjectResourceExample() {
		'''
			objectResource TaxFilingObject type TaxFiling
				URI index
				only properties
					filingID
					taxpayer
				referenceLink > taxpayer
				referenceEmbed > controller
				linkDescriptor desc
				mediaTypes
					application/xml
				method GET getIndex
					response TaxFilingObject statusCode 200
					response statusCode 404
						example «tripleQuotes» «tripleQuotes»
				method GET getIndex2
					response TaxFilingObject statusCode 200
					response statusCode 404
						example «tripleQuotes» «tripleQuotes»
				example «tripleQuotes» «tripleQuotes»
		'''
	}
	
	@Test
	def void testCollectionResource() {
		val resource = loadModelAndGetResource("TaxFilingCollection", incorrectCollectionResource)
		
		val diagnostics = tester.validate(resource)
		diagnostics.assertDiagnosticsCount(8)
		diagnostics.assertAny(AssertableDiagnostics.warningMsg("collectionParam"),
			AssertableDiagnostics.warningMsg("only"),	
			AssertableDiagnostics.warningMsg("referenceEmbed"),
			AssertableDiagnostics.warningMsg("referenceLink"),	
			AssertableDiagnostics.warningMsg("method"),
			AssertableDiagnostics.warningMsg("mediaTypes"),
			AssertableDiagnostics.warningMsg("linkDescriptor"),
			AssertableDiagnostics.warningMsg("example"))
	}
	
	@Test
	def void testCollectionResourceCorrectOrder() {
		val resource = loadModelAndGetResource("TaxFilingCollection", correctCollectionResource)
		tester.validate(resource).assertOK
	}
	
	@Test
	def void testObjectResource() {
		val resource = loadModelAndGetResource("TaxFilingObject", incorrectObjectResource)		
		val diagnostics = tester.validate(resource)
		diagnostics.assertDiagnosticsCount(7)		
		diagnostics.assertAny(AssertableDiagnostics.warningMsg("linkDescriptor"),	
			AssertableDiagnostics.warningMsg("method"),
			AssertableDiagnostics.warningMsg("referenceLink"),
			AssertableDiagnostics.warningMsg("referenceEmbed"),
			AssertableDiagnostics.warningMsg("only"),
			AssertableDiagnostics.warningMsg("example"),
			AssertableDiagnostics.warningMsg("mediaTypes"))
	}
	
	@Test
	def void testObjectResourceCorrectOrder() {
		val resource = loadModelAndGetResource("TaxFilingObject", correctObjectResource)
		tester.validate(resource).assertOK
	}

	@Test
	def void testObjectResourceCorrectOrderExample() {
		val resource = loadModelAndGetResource("TaxFilingObject", correctObjectResourceExample)
		tester.validate(resource).assertOK
	}

	@Test
	def void testCollectionResourcesCorrectOrderExample() {
		val resource = loadModelAndGetResource("TaxFilingCollection", correctCollectionResourceExamples)
		tester.validate(resource).assertOK
	}
	
	def ServiceDataResource loadModelAndGetResource(String resourceName, String resource) {
		val model = parser.parse(textualModel(resource))
		val dataResource = model.firstResourceAPI.firstResourceDefinition as ServiceDataResource
		assertEquals(resourceName, dataResource.name)
		dataResource
	}
}