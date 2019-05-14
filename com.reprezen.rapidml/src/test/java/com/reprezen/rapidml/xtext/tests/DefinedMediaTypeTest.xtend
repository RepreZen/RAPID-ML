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
import com.reprezen.rapidml.MediaType
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
class DefinedMediaTypeTest {

	@Inject extension ValidationTestHelper
	@Inject extension ZenModelUtils
	@Inject
	ParseHelper<ZenModel> parser

	def String textualModel(String mediaType) {
		'''
			rapidModel TestModel
				resourceAPI MyInterface
					collectionResource myResource type myDataType
						mediaTypes 
							«mediaType»
					mediaType «mediaType»
				dataModel dm
					structure myDataType
						id : string
		'''
	}
	
	ZenModel model
	
	@Test
	def void testDefinedMediaTypeSimple() {
		testMediaType("application/mediaTypeName")
	}

	@Test
	def void testDefinedMediaTypeWithDotsPlusAndMinusSymbols() {
		testMediaType("application/vnd.google-earth.kml+xml")
	}
	
	@Test
	def void testdMediaTypeWithKeywordInParameters() {
		testMediaType("\"application/atom+xml;type=entry\"")
	}

	@Test
	def void testExplicitMediaTypeWithParameters() {
		testMediaType("application/atom+xml;typ=entry")
	}

	@Test
	def void testDefinedMediaTypeWithHyphenedParameters() {
		testMediaType("\"text/html; charset=UTF-8\"")
	}

	def void testMediaType(String testedMediaType) {
  		model = parser.parse(textualModel(testedMediaType))
		model.assertNoErrors
		assertHasDefinedMediaType(testedMediaType)
		assertHasExplicitMediaType(testedMediaType)
	}
	
    def MediaType assertHasDefinedMediaType(String expectedName) {
		val interface_ = model.firstResourceAPI
		assertThat(interface_, notNullValue)
		val result = interface_.definedMediaTypes.findFirst[name==expectedName]
		assertThat(result, notNullValue)
		return result
	}
	
    def MediaType assertHasExplicitMediaType(String expectedName) {
		val resource = model.firstResourceAPI.firstResourceDefinition
		assertThat(resource, notNullValue)
		val result = resource.mediaTypes.findFirst[name==expectedName]
		assertThat(result, notNullValue)
		return result
	}
}
