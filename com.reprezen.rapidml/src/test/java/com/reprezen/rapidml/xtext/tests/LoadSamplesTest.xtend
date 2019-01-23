/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 * 
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.xtext.tests

import com.google.common.io.Resources
import com.google.inject.Inject
import com.reprezen.rapidml.RapidmlPackage
import com.reprezen.rapidml.ZenModel
import com.reprezen.rapidml.xtext.tests.RapidMLInjectorProvider
import com.reprezen.rapidml.xtext.validation.XtextDslJavaValidator
import java.nio.file.Files
import java.nio.file.Paths
import java.util.stream.Collectors
import org.eclipse.emf.common.util.Diagnostic
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.eclipse.xtext.junit4.validation.ValidatorTester
import org.eclipse.xtext.resource.XtextResourceSet
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters

import static org.junit.Assert.*

@InjectWith(RapidMLInjectorProvider)
@RunWith(Parameterized)
@Parameterized.UseParametersRunnerFactory(ParameterizedXtextRunner.XtextParametersRunnerFactory)
class LoadSamplesTest {

	val static public XTEXT_RESOURCES_FOLDER = Resources.getResource(LoadSamplesTest, "/dsl")

	@Inject ValidatorTester<XtextDslJavaValidator> tester
	extension ValidationTestHelper = new ValidationTestHelper

	@Parameters(name="{index}: {0}")
	def static Iterable<Object[]> data() {
		Files.find(Paths.get(XTEXT_RESOURCES_FOLDER.toURI), 10, [p, e|p.toFile.name.endsWith("rapid")]) //
			.map [ #[it.toFile.canonicalPath ] as Object[] ] //
			.collect(Collectors.toList)
	}

	val String modelPath

	new(String modelPath) {
		this.modelPath = modelPath
	}

	@Test
	def void testModel() {
		val modelUri = URI::createFileURI(modelPath)
		loadSampleAndAssertNoError(modelUri)
	}

	def ZenModel loadSampleAndAssertNoError(URI modelUri) {
		RapidmlPackage.eINSTANCE.eClass()

		val resource = new XtextResourceSet().getResource(modelUri, true)
		val model = resource.contents.get(0) as ZenModel
		if (resource.errors.size != 0) {
			fail(resource.errors.head.toString)
		}
		assertNoErrors(model)

		val result = tester.validate(model).allDiagnostics.filter[e|e.severity == Diagnostic::ERROR].toList

		if (result.size != 0) {
			fail(result.head.toString)
		}
		model
	}
}
