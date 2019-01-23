/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.xtext.tests.validation

import com.reprezen.rapidml.ZenModel
import com.reprezen.rapidml.xtext.tests.RapidMLInjectorProvider
import com.reprezen.rapidml.xtext.validation.XtextDslJavaValidator
import java.util.List
import javax.inject.Inject
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.eclipse.xtext.junit4.validation.ValidatorTester
import org.eclipse.xtext.validation.Issue
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*

/**
 * Tests for ZEN-839: Disallow duplicate mediaTypes or properties entries
 */
@InjectWith(typeof(RapidMLInjectorProvider))
@RunWith(typeof(XtextRunner))
class DuplicateElementsValidatorTests {

	def String textualModel(String input) {
		'''rapidModel TestMediaTypes
	resourceAPI TestMediaTypesInterface
		objectResource TestMediaTypesResource type MyStructure
			«input»
	dataModel dm
		structure MyStructure
			prop1: string'''
	}

	def String textualMessageModel(String input) {
		'''rapidModel TestMediaTypes
	resourceAPI TestMediaTypesInterface
		objectResource TestMediaTypesResource type MyStructure
			method GET getMediaTypesResource
				request type MyStructure
					«input»
				response type MyStructure statusCode 200
					«input»
	dataModel dm
		structure MyStructure
			prop1: string'''
	}

	def String textualModelDuplicate(String input) {
		textualModel(
			'''«input»
«input»''')
	}

	def String textualMessageModelDuplicate(String input) {
		textualMessageModel(
			'''«input»
«input»''')
	}

	def tripleQuotes() {
		"'''"
	}

	def String textualModelDuplicateWithExample(String input) {
		textualModel(
			'''«input»
example «tripleQuotes» «tripleQuotes»
«input»''')
	}

	@Inject ParseHelper<ZenModel> parser
	@Inject private ValidatorTester<XtextDslJavaValidator> tester;
	@Inject extension ValidationTestHelper
	
	@Test
	def void testMediaTypes() {
		assertEquals(0, getErrors(textualModel("mediaTypes\n\ttext/xml")).length);
		validateDuplicateCombinations_andAssertErrors("mediaTypes\n\ttext/xml", "mediaTypes");
	}

	@Test
	def void testTypedMessageMediaTypes() {
		assertEquals(0, getErrors(textualMessageModel("mediaTypes\n\ttext/xml")).length);
		assertDuplicateException(textualMessageModelDuplicate("mediaTypes\n\ttext/xml"), "mediaTypes", 2);
	}

	@Test
	def void testDuplicateIncludedProperties() {
		val entry = "only properties\n\tprop1";
		assertEquals(0, getErrors(textualModel(entry)).length);
		validateDuplicateCombinations_andAssertErrors(entry, "properties");
	}

	@Test
	def void testDuplicateIncludedPropertiesNewNotation() {
		val entry = "properties\n\tprop1";
		assertEquals(0, getErrors(textualModel(entry)).length);
		validateDuplicateCombinations_andAssertErrors(entry, "properties");
	}

	@Test
	def void testDuplicateExcludedProperties() {
		val entry = '''all properties
excluding 
	prop1''';
		assertEquals(0, getErrors(textualModel(entry)).length);
		validateDuplicateCombinations_andAssertErrors(entry, "properties");
	}

	@Test
	def void testIncludingDuplicateExcludedProperties() {
		val entry = '''all properties
	prop1
excluding 
	prop1''';
		// we use "ValidatorTester<XtextDslJavaValidator>" instead of ValidationTestHelper 
		// because it incorrect register validator in case of synthetic model
		val errors = tester.validate(parser.parse(textualModel(entry))).diagnostic.children
		assertEquals(2, errors.size)
		assertEquals(
			"The property 'prop1' is referenced in the list of included properties, and in the list of " +
				"excluded properties. Each property may be referenced in at most one of these lists.", errors.head.message);
	}

	@Test
	def void testDuplicateIncluded_oldNotationAndExcluded() {
		val entry1 = "only properties\n\tprop1";
		val entry2 = '''all properties
excluding 
	prop1''';
		assertDuplicateException(
			textualModel(
				'''«entry1»
«entry2»'''), "properties", 1);
		assertDuplicateException(
			textualModel(
				'''«entry2»
«entry1»'''), "properties", 1);
	}

	def void validateDuplicateCombinations_andAssertErrors(String input, String token) {
		assertDuplicateException(textualModelDuplicate(input), token, 1);
		assertDuplicateException(textualMessageModelDuplicate(input), token, 2);
		assertDuplicateException(textualModelDuplicateWithExample(input), token, 1);
	}

	def void assertDuplicateException(String model, String token, int expectedErrorsCount) {
		val errors = getErrors(model);
		assertEquals(expectedErrorsCount, errors.length)
		assertEquals("Duplicate '" + token + "' token", errors.get(0).message);
	}

	def List<Issue> getErrors(String model) {
		parser.parse(model).validate
	}
}
