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

import static com.reprezen.rapidml.HTTPMethods.*
import static org.hamcrest.CoreMatchers.*
import static org.junit.Assert.*

@InjectWith(typeof(RapidMLInjectorProvider))
@RunWith(typeof(XtextRunner))
class ImplicitMethodRequestTest {

	@Inject extension ZenModelUtils
	
	def String textualModel(HTTPMethods methodType, String requestText) {
		'''
			rapidModel TestModel
				resourceAPI TestInterface baseURI "http://modelsolv.com"
					collectionResource TestResource type myDataModel.DT
						method «methodType.getName» getMethod
							«requestText»
							response
				dataModel myDataModel
					structure DT
		'''
	}

	ZenModel model

	@Test
	def void testDefaultRequestInGetMethod() {
		val method = parseAndRequireMethod(GET, '')
		val request = method.request
		assertThat(request, notNullValue)
		assertThat(request.resourceType, nullValue)
	}

	@Test
	def void testDefaultRequestInPutMethod() {
		testDefaultRequestWithResource(PUT, '')
	}

	@Test
	def void testDefaultRequestInPostMethod() {
		testDefaultRequestWithResource(POST, '')
	}

	@Test
	def void testDefaultRequestInPatchMethod() {
		testDefaultRequestWithResource(PATCH, '')
	}

	@Test
	def void testDefaultRequestInDeleteMethod() {
		testDefaultRequestWithResource(DELETE, '')
	}
	
	@Test
	def void testSelfTypeReference() {
		testDefaultRequestWithResource(GET, 'request this')
	}

	@Test
	def void testEmptyResourceType() {
		val method = parseAndRequireMethod(GET, 'request')
		val request = method.request
		assertThat(request, notNullValue)
		assertThat(request.resourceType, nullValue)
	}
	
	def void testDefaultRequestWithResource(HTTPMethods methodKind, String xtextNotation) {
		val resource = parseAndRequireRESTfulInterface(methodKind, xtextNotation)
		val method = resource.firstMethod
		val request = method.request
		assertThat(request, notNullValue)
		assertThat(request.resourceType, equalTo(resource))
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
