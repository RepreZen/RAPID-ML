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
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

import static org.hamcrest.CoreMatchers.*
import static org.junit.Assert.*

@InjectWith(typeof(RapidMLInjectorProvider))
@RunWith(typeof(XtextRunner))
class ApiModelPropertiesTest {

	@Inject extension ValidationTestHelper
	@Inject extension ZenModelUtils
	@Inject
	ParseHelper<ZenModel> parser

	val String textualModel = '''
		rapidModel MyProject
			/**model comment*/
			resourceAPI myModelName baseURI "https://www.sample.org/temp"
	'''

	ZenModel model

	@Before
	def void setUp() {
		model = parser.parse(textualModel)
	}

	@Test
	def void testProjectName() {
		assertEquals("MyProject", model.name)
	}

	@Test
	def void testBaseURL() {
		val interface_ = model.firstResourceAPI
		assertThat(interface_, notNullValue)
		assertThat(interface_.baseURI, equalTo("https://www.sample.org/temp"))
	}

	@Test
	def void testParsing() {
		model.assertNoErrors
	}

}
