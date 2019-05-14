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
import com.reprezen.rapidml.InlineExample
import com.reprezen.rapidml.Method
import com.reprezen.rapidml.TypedMessage
import com.reprezen.rapidml.ZenModel
import com.reprezen.rapidml.xtext.tests.RapidMLInjectorProvider
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.junit.Test
import org.junit.runner.RunWith

import static org.hamcrest.CoreMatchers.*
import static org.junit.Assert.*

@InjectWith(typeof(RapidMLInjectorProvider))
@RunWith(typeof(XtextRunner))
class ImplicitExamplesTest {

	@Inject extension ValidationTestHelper
	@Inject extension ZenModelUtils
	@Inject
	ParseHelper<ZenModel> parser

	def String textualModel(
		String requestExample,
		String responseExample,
		String resourceExample,
		String dataTypeExample,
		String messageResourceType
	) {
		'''
			rapidModel TestModel
				resourceAPI MyInterface
					collectionResource ExamplesResource type myDataType
						method GET getExamplesResource
							request «messageResourceType»
								«requestExample»
							response «messageResourceType» statusCode 200
								«responseExample»
						«resourceExample»
				dataModel ExamplesDataModel
					structure myDataType
						id : string
						«dataTypeExample»
		'''
	}
	
		def String textualModel(
		String requestExample,
		String responseExample,
		String resourceExample,
		String dataTypeExample
	) {
		textualModel(requestExample, responseExample, resourceExample, dataTypeExample, "ExamplesResource")
	}

	ZenModel model

	@Test
	def void explicitRequestMessage() {
		model = parser.parse(textualModel("example '''request'''", "", "example '''resource'''", "dataExample '''dataType'''"))
		model.assertNoErrors
		val method = requireFirstMethod()
		assertThat(method.request.firstExampleBody, equalTo("request"));
	}

	@Test
	def void resourceExampleForRequest() {
		model = parser.parse(textualModel("", "", "example '''resource'''", "dataExample '''dataType'''"))
		model.assertNoErrors
		val method = requireFirstMethod()
		assertThat(method.request.firstExampleBody, equalTo("resource"));
	}
	
	@Test
	def void thisResourceExampleForRequest() {
		model = loadModelAndNormalize(textualModel("", "", "example '''resource'''", "dataExample '''dataType'''", "this"))
		val method = requireFirstMethod()
		assertThat(method.request.firstExampleBody, equalTo("resource"));
	}

	@Test
	def void dataTypeExampleForRequest() {
		model = parser.parse(textualModel("", "", "", "dataExample '''dataType'''"))
		model.assertNoErrors
		val method = requireFirstMethod()
		assertThat(method.request.firstExampleBody, equalTo("dataType"));
	}

	@Test
	def void explicitResponseMessage() {
		model = parser.parse(textualModel("", "example '''response'''", "example '''resource'''", "dataExample '''dataType'''"))
		model.assertNoErrors
		val method = requireFirstMethod()
		assertThat(method.responses.findFirst[true].firstExampleBody, equalTo("response"));
	}

	@Test
	def void resourceExampleForResponse() {
		model = parser.parse(textualModel("", "", "example '''resource'''", "dataExample '''dataType'''"))
		model.assertNoErrors
		val method = requireFirstMethod()
		assertThat(method.responses.findFirst[true].firstExampleBody, equalTo("resource"));
	}
	
	@Test
	def void thisResourceExampleForResponse() {
		model = loadModelAndNormalize(textualModel("", "", "example '''resource'''", "dataExample '''dataType'''", "this"))
		val method = requireFirstMethod()
		assertThat(method.responses.findFirst[true].firstExampleBody, equalTo("resource"));
	}

	@Test
	def void dataTypeExampleForResponse() {
		model = parser.parse(textualModel("", "", "", "dataExample '''dataType'''"))
		model.assertNoErrors
		val method = requireFirstMethod()
		assertThat(method.responses.findFirst[true].firstExampleBody, equalTo("dataType"));
	}

	def Method requireFirstMethod() {
		val resourceAPI = model.firstResourceAPI
		assertThat(resourceAPI, notNullValue)
		val resource = resourceAPI.firstResourceDefinition
		assertThat(resource, notNullValue)
		val result = resource.firstMethod
		return result
	}

	def String getFirstExampleBody(TypedMessage message) {
		return (message.allExamples.findFirst[true] as InlineExample).body
	}

}
