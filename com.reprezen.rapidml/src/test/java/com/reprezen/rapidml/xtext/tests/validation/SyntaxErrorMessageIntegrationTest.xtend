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
import com.reprezen.rapidml.ZenModel
import com.reprezen.rapidml.xtext.tests.RapidMLInjectorProvider
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.hamcrest.CoreMatchers
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*

@InjectWith(typeof(RapidMLInjectorProvider))
@RunWith(typeof(XtextRunner))
class SyntaxErrorMessageIntegrationTest {

	@Inject ParseHelper<ZenModel> parser

	@Test
	def void testMissingDataModelName() {
		'''
			rapidModel MyModel
				dataModel
					
		'''.assertError("Missing name in dataModel before line break")
	}

	@Test
	def void testMissingAttribute() {
		'''
			rapidModel MyModel
				dataModel MyDataModel
					structure
						OrderID: string
		'''.assertError("Structure name is missing")
	}

	@Test
	def void testEndOfFile() {
		'''
			rapidModel MyModel
				dataModel MyDataModel
					structure Order
						/*
						OrderID : string
						LineItems : reference LineItem*
		'''.assertError("Invalid token '/': check that multiline comment is closed")
	}

	@Test
	def void testInvalidDocumentationIndent() {
		testDocumentationForElement("resourceAPI TestDI", 1)
		testDocumentationForElement("objectResource TestObjResource", 2)
		testDocumentationForElement("matrixParam testMatrixParam", 4)
		testDocumentationForElement("templateParam testTemplateParam", 4)
		testDocumentationForElement("method GET testMethod", 3)
		testDocumentationForElement("request", 4)
		testDocumentationForElement("response TestObjResource", 4)
		testDocumentationForElement("param testMessageParam", 5)
		testDocumentationForElement("collectionResource TestColResource", 2)
		testDocumentationForElement("collectionParam testColParam", 3)
		testDocumentationForElement("dataModel TestDM", 1)
		testDocumentationForElement("structure TestST", 2)
		testDocumentationForElement("testfld : string", 3)
		testDocumentationForElement("testref1 : reference to TestST", 3)
		testDocumentationForElement("enum string TestEnum", 2)
		testDocumentationForElement("VAL : \"VAL\"", 3)
		testDocumentationForElement("mediaType testMediaType", 2)
		testDocumentationForElement("linkRelation testLinkRelation", 2)
	}

	def testDocumentationForElement(String element, int validDocumentationIndent) {
		for (indentLevel : 0 ..< validDocumentationIndent + 2) {
			if (indentLevel != validDocumentationIndent) {
				checkInvalidDocumentationIndentError(element, createIndent(indentLevel))
				checkInvalidDocumentationIndentError(element,
					createIndentWithLineBreak(indentLevel, validDocumentationIndent))
			} else {
				checkValidDocumentationIndent(element, createIndent(indentLevel))
			}
		}
	}

	def createIndent(int indentLevel) {
		val sb = new StringBuilder()
		for (i : 0 ..< indentLevel) {
			sb.append('\t')
		}
		sb.toString()
	}

	def createIndentWithLineBreak(int indentLevel, int validIndentLevel) {
		createIndent(validIndentLevel) + '\n' + createIndent(indentLevel)
	}

	def void checkInvalidDocumentationIndentError(String element, String indentedDocumentation) {
		insertDocumentationWithIndentBeforeLine(element, indentedDocumentation).assertErrorsContain(
			"Documentation must be at the same indent level as the associated definition that follows",
			"Next line has invalid indent level");
	}

	def void checkValidDocumentationIndent(String element, String indentedDocumentation) {
		insertDocumentationWithIndentBeforeLine(element, indentedDocumentation).assertNoError()
	}

	def insertDocumentationWithIndentBeforeLine(String line, String indent) {
		val model = modelForInsertingDocumentation()
		val tab = new Character('\t')
		for (index : model.indexOf(line) - 1 >.. 0) {
			if (tab != model.charAt(index)) {
				return new StringBuilder(model).insert(index + 1, indent + '/** doc */\n').toString();
			}
		}
	}

	def String modelForInsertingDocumentation() {
		'''
			rapidModel TestZM
				resourceAPI TestDI
					objectResource TestObjResource type TestST
						URI /uri/{testTemplateParam}
							matrixParam testMatrixParam property testfld
							templateParam testTemplateParam property testfld
						method GET testMethod
							request
							response TestObjResource statusCode 200
								param testMessageParam type string
					collectionResource TestColResource type TestST
						collectionParam testColParam type string
				dataModel TestDM
					structure TestST
						testfld : string
						testref : reference to TestST
						testref1 : reference to TestST
					enum string TestEnum
						VAL : "VAL"
				mediaTypesLibrary
					mediaType testMediaType
				linkRelationsLibrary
					linkRelation testLinkRelation
		'''
	}

	def replaceLineEndingsByLF(CharSequence str) {
		str.toString.split("\r?\n").join("\n")
	}

	def private assertNoError(CharSequence str) {
		val ZenModel model = parser.parse(replaceLineEndingsByLF(str))
		assertTrue("Model should be valid", model.eResource.errors.empty)
	}

	def private assertError(CharSequence str, String errorMessage) {
		val ZenModel model = parser.parse(replaceLineEndingsByLF(str))
		assertFalse("Model should contains at least one error", model.eResource.errors.empty)
		assertEquals(errorMessage, model.eResource.errors.head.message)
	}

	/** 
	 * Check that resource errors contain one of getting error messages.
	 */
	def private assertErrorsContain(CharSequence str, String... errorMessages) {
		val ZenModel model = parser.parse(replaceLineEndingsByLF(str))
		assertFalse("Model should contains at least one error", model.eResource.errors.empty)
		assertThat(model.eResource.errors.map[it.message],
			CoreMatchers.<Iterable<String>>anyOf(errorMessages.map[CoreMatchers.hasItem(it)]))
	}
}
