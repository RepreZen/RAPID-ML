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
import com.reprezen.rapidml.ResourceAPI
import com.reprezen.rapidml.ZenModel
import com.reprezen.rapidml.xtext.tests.RapidMLInjectorProvider
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*

@InjectWith(typeof(RapidMLInjectorProvider))
@RunWith(typeof(XtextRunner))
class DocumentationTest {

	@Inject extension ValidationTestHelper
	@Inject extension ZenModelUtils
	@Inject
	ParseHelper<ZenModel> parser

	def String textualModel(String modelComment) {
		'''
			rapidModel TestModel
				«modelComment»
				resourceAPI MyInterface
					collectionResource myResource type myDataType
				dataModel dm
					structure myDataType
						id : string
		'''
	}
	
	ZenModel model
	
	@Test
	def void testJavaDocComment() {
		val doc = parseAndRequireFirstResourceAPI("/**model comment*/").documentation
 		assertEquals("model comment", doc.text)
	}

	@Test
	def void testMultilineJavaDocComment() {
		val doc = parseAndRequireFirstResourceAPI("/**model\ncomment*/").documentation
 		assertEquals("model" + System::lineSeparator + "comment", doc.text)
	}

	@Test
	def void testJavaComment() {
		//should not be parsed as documentation
		val doc = parseAndRequireFirstResourceAPI("/* model comment*/").documentation
 		assertNull(doc)
	}

	@Test
	def void testInvalidComment() {
  		model = parser.parse(textualModel("/**model comment"))
		assertTrue(model.validate.size > 0)
	}

	@Test
	def void testInvalidComment2() {
  		model = parser.parse(textualModel("/**model */comment*/"))
		assertTrue(model.validate.size > 0)
	}

    @Test
    def void testFormattedComment() {
        val doc = parseAndRequireFirstResourceAPI("/**model\n\t\t   comment\n\t\t    \n\t\t   second line*/").documentation
        assertEquals("model" + System::lineSeparator + "comment" + System::lineSeparator + System::lineSeparator + "second line", doc.text)
    }

	def ResourceAPI parseAndRequireFirstResourceAPI(String param) {
  		model = parser.parse(textualModel(param))
		model.assertNoErrors
		model.firstResourceAPI
	}
}
