/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 * 
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.xtext.tests.validation

import com.google.common.io.Resources
import com.reprezen.rapidml.ZenModel
import com.reprezen.rapidml.xtext.tests.RapidMLInjectorProvider
import com.reprezen.rapidml.xtext.tests.ZenModelUtils
import com.reprezen.rapidml.xtext.validation.XtextDslJavaValidator
import javax.inject.Inject
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.junit4.validation.ValidatorTester
import org.junit.Test
import org.junit.runner.RunWith

@InjectWith(typeof(RapidMLInjectorProvider))
@RunWith(typeof(XtextRunner))
/**
 * Tests for ZEN-936: Basic Data Model Sharing - validation
 */
class ImportDeclarationValidatorTests {

	@Inject extension ZenModelUtils

	def String textualModel(String input, String input2) {
		'''
			«input»
			«input2»
			rapidModel TestMediaTypes
				resourceAPI TestMediaTypesInterface
					objectResource TestMediaTypesResource type Type
					
				dataModel MyDataModel
					structure Type
				   '''
	}

	@Inject ParseHelper<ZenModel> parser
	@Inject ValidatorTester<XtextDslJavaValidator> tester;

	@Test
	def void testAliasUnique_happyPath() {
		val model1 = loadModelAndNormalize(textualModel( //
		importLine("com.modelsolv.reprezen.ModelA.DataModelA", "import/ModelA.rapid", "imp1"), //
		importLine("com.modelsolv.reprezen.ModelB.DataModelB", "import/ModelB.rapid", "imp2")))
		tester.validate(model1).assertOK()
	}

	@Test
	def void testAliasUnique_failOnDuplicate() {
		val model2 = parser.parse(textualModel( //
		importLine("com.modelsolv.reprezen.ModelA.DataModelA", "import/ModelA.rapid", "imp1"), //
		importLine("com.modelsolv.reprezen.ModelB.DataModelB", "import/ModelB.rapid", "imp1")))
		tester.validate(model2).assertErrorContains("Duplicate alias imp1")
	}

	@Test
	def void testNamespaceError() {
		validate(importLine("incorrect_namespace.ModelA.DataModelA", "import/ModelA.rapid", "imp1"), '').
			assertErrorContains("Incorrect namespace")
	}

	def validate(String input, String input2) {
		tester.validate(parser.parse(textualModel(input, input2)))
	}

	val static public String XTEXT_RESOURCES_FOLDER = Resources.getResource(ImportDeclarationValidatorTests, "/dsl/").file

	def String importLine(String what, String file,
		String alias) {
		'''
			import «what» from "«URI::createFileURI(XTEXT_RESOURCES_FOLDER + file)»"«IF null != alias» as «alias»«ENDIF»
		'''
	}
}
