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
import com.reprezen.rapidml.HasSecurityValue
import com.reprezen.rapidml.Method
import com.reprezen.rapidml.ResourceAPI
import com.reprezen.rapidml.ResourceDefinition
import com.reprezen.rapidml.ZenModel
import com.reprezen.rapidml.xtext.tests.RapidMLInjectorProvider
import java.util.List
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
class ImplicitAuthenticationMethodTest {

	@Inject extension ValidationTestHelper
	@Inject extension ZenModelUtils
	@Inject
	ParseHelper<ZenModel> parser

	def String textualModel(String resourceApiScheme, String resourceScheme, String methodScheme) {
		'''rapidModel SecuritySchemes
	resourceAPI SecuritySchemesAPI baseURI "http://my-namespace.com"
		«securedBy(resourceApiScheme)»
		objectResource SecuritySchemesObject type SecuritySchemes
			URI /uri
			«securedBy(resourceScheme)»
			method GET getSecuritySchemesObject
				«securedBy(methodScheme)»
				request
				response SecuritySchemesObject statusCode 200
			method PUT putSecuritySchemesObject
				request SecuritySchemesObject
				response statusCode 200
				response statusCode 400

	dataModel SecuritySchemesDataModel
		structure SecuritySchemes
			id : string
	
	securitySchemesLibrary LocalSchemes
		securityScheme Scheme1
			type basic
			methodInvocation
				requires authorization
					param basic_credentials type base64Binary in header
				errorResponse statusCode 401 //Unauthorized

		securityScheme Scheme2
			type basic
			methodInvocation
				requires authorization
					param basic_credentials type base64Binary in header
				errorResponse statusCode 401 //Unauthorized

		securityScheme Scheme3
			type basic
			methodInvocation
				requires authorization
					param basic_credentials type base64Binary in header
				errorResponse statusCode 401 //Unauthorized'''
	}

	def String securedBy(String scheme) {
		if (scheme == null)
			""
		else '''secured by
	«scheme»'''
	}

	ZenModel model

	@Test
	def void testResourceApi() {
		model = parser.parse(textualModel("Scheme1", null, null))
		model.assertNoErrors
		testedResourceAPI.assertHasSecuritySchemes(#["Scheme1"])
		testedResource.assertHasSecuritySchemes(#[])
		testedMethod.assertHasSecuritySchemes(#[])
	}

	@Test
	def void testResourceApi_Resource() {
		model = parser.parse(textualModel("Scheme1", "Scheme2", null))
		model.assertNoErrors
		testedResourceAPI.assertHasSecuritySchemes(#["Scheme1"])
		testedResource.assertHasSecuritySchemes(#["Scheme2"])
		testedMethod.assertHasSecuritySchemes(#[])
	}

	@Test
	def void testResourceApi_Resource_Method() {
		model = parser.parse(textualModel("Scheme1", "Scheme2", "Scheme3"))
		model.assertNoErrors
		testedResourceAPI.assertHasSecuritySchemes(#["Scheme1"])
		testedResource.assertHasSecuritySchemes(#["Scheme2"])
		testedMethod.assertHasSecuritySchemes(#["Scheme3"])
	}

	@Test
	def void testResourceApi_Method() {
		model = parser.parse(textualModel("Scheme1", null, "Scheme3"))
		model.assertNoErrors
		testedResourceAPI.assertHasSecuritySchemes(#["Scheme1"])
		testedResource.assertHasSecuritySchemes(#[])
		testedMethod.assertHasSecuritySchemes(#["Scheme3"])
	}

	@Test
	def void testResource_Method() {
		model = parser.parse(textualModel("Scheme1", null, "Scheme3"))
		model.assertNoErrors
		testedResourceAPI.assertHasSecuritySchemes(#["Scheme1"])
		testedResource.assertHasSecuritySchemes(#[])
		testedMethod.assertHasSecuritySchemes(#["Scheme3"])
	}

	@Test
	def void testMethod() {
		model = parser.parse(textualModel(null, null, "Scheme3"))
		model.assertNoErrors
		testedResourceAPI.assertHasSecuritySchemes(#[])
		testedResource.assertHasSecuritySchemes(#[])
		testedMethod.assertHasSecuritySchemes(#["Scheme3"])
	}

	@Test
	def void testNoSecSchemes() {
		model = parser.parse(textualModel(null, null, null))
		model.assertNoErrors
		testedResourceAPI.assertHasSecuritySchemes(#[])
		testedResource.assertHasSecuritySchemes(#[])
		testedMethod.assertHasSecuritySchemes(#[])
	}

	@Test
	def void testMultiValued() {
		model = parser.parse(textualModel("Scheme1\nScheme2", null, "Scheme3"))
		model.assertNoErrors
		testedResourceAPI.assertHasSecuritySchemes(#["Scheme1", "Scheme2"])
		testedResource.assertHasSecuritySchemes(#[])
		testedMethod.assertHasSecuritySchemes(#["Scheme3"])
	}

	def ResourceAPI getTestedResourceAPI() {
		model.firstResourceAPI
	}

	def ResourceDefinition getTestedResource() {
		testedResourceAPI.firstResourceDefinition
	}

	def Method getTestedMethod() {
		testedResource.firstMethod
	}

	def void assertHasSecuritySchemes(HasSecurityValue element, List<String> schemeNames) {
		val List<String> actualSchemeNames = element.securedBy.map[it.scheme.name]
		assertThat(actualSchemeNames, equalTo(schemeNames))
	}
}
