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
import com.reprezen.rapidml.HTTPMethods
import com.reprezen.rapidml.Method
import com.reprezen.rapidml.ServiceDataResource
import com.reprezen.rapidml.ZenModel
import com.reprezen.rapidml.xtext.tests.RapidMLInjectorProvider
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith

import static org.hamcrest.CoreMatchers.*
import static org.junit.Assert.*

@InjectWith(typeof(RapidMLInjectorProvider))
@RunWith(typeof(XtextRunner))
class ImplicitMethodResponseTest {

	@Inject extension ZenModelUtils

	def String textualModel(HTTPMethods methodType, String responseText) {
		'''
			rapidModel TestModel
				resourceAPI TestInterface baseURI "http://modelsolv.com"
					collectionResource TestResource type testDataModel.DT
						method «methodType.getName» getMethod
							request
							«responseText»
				dataModel testDataModel
					structure DT
		'''
	}

	ZenModel model

	@Test
	def void testDefaultResponseInGetMethod() {
		testDefaultResponseWithResource(HTTPMethods.GET, '')
	}

	@Test
	def void testDefaultResponseInPutMethod() {
		val method = parseAndRequireMethod(HTTPMethods.PUT, '')
		val responses = method.responses
		assertThat(responses.size, equalTo(1))
		val response = responses.get(0)
		assertThat(response, notNullValue)
		assertThat(response.statusCode, equalTo(200))
	}

	@Test
	def void testDefaultResponseInPostMethod() {
		testDefaultResponseWithResource(HTTPMethods.POST, '')
	}

	@Test
	def void testDefaultResponseInPatchMethod() {
		testDefaultResponseWithResource(HTTPMethods.PATCH, '')
	}

	@Test
	def void testDefaultResponseInDeleteMethod() {
		testDefaultResponseWithResource(HTTPMethods.DELETE, '')
	}
	
	@Test
	def void testDefaultResponseWithResource() {
		testDefaultResponseWithResource(HTTPMethods.GET, 'response this statusCode 200')
	}

	@Test
	def void testEmptyResourceType() {
		val method = parseAndRequireMethod(HTTPMethods.GET, 'response statusCode 200')
		val request = method.request
		assertThat(request, notNullValue)
		assertThat(request.resourceType, nullValue)
	}

	def void testDefaultResponseWithResource(HTTPMethods methodKind, String xtextNotation) {
		val resource = parseAndRequireRESTfulInterface(methodKind, xtextNotation)
		val method = resource.firstMethod
		val responses = method.responses
		assertThat(responses.size, equalTo(1))
		val response = responses.get(0)
		assertThat(response, notNullValue)
		assertThat(response.resourceType, equalTo(resource))
		assertThat(response.statusCode, equalTo(200))
	}

	def ServiceDataResource parseAndRequireRESTfulInterface(HTTPMethods methodKind, String xtextNotation) {
		model = loadModelAndNormalize(textualModel(methodKind, xtextNotation))
		val result = model.firstResourceAPI.firstResourceDefinition
		assertThat(result, notNullValue)
		assertThat(result, instanceOf(typeof(ServiceDataResource)))
		result as ServiceDataResource
	}

	def Method parseAndRequireMethod(HTTPMethods methodKind, String xtextNotation) {
		val result = parseAndRequireRESTfulInterface(methodKind, xtextNotation).firstMethod
		assertThat(result, notNullValue)
		result
	}
}
