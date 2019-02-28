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
import com.reprezen.rapidml.ExternalExample
import com.reprezen.rapidml.TypedResponse
import com.reprezen.rapidml.ZenModel
import com.reprezen.rapidml.xtext.tests.RapidMLInjectorProvider
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.resource.XtextResourceSet
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*

@InjectWith(typeof(RapidMLInjectorProvider))
@RunWith(typeof(XtextRunner))
class ExternalExampleTest {

	@Inject extension ZenModelUtils

	@Test
	def void testSiblingExample() {
		val rapidModel = loadSampleAndAssertNoError()
		val response = rapidModel.findResponseForMethod('SameDirectory')
		val example = response.examples.get(0) as ExternalExample
		assertEquals("Content1", example.body)
	}

	@Test
	def void testExampleInSubdirectory() {
		val rapidModel = loadSampleAndAssertNoError()
		val response = rapidModel.findResponseForMethod('SubDirectory')
		val example = response.examples.get(0) as ExternalExample
		assertEquals("Content2", example.body)
	}

	@Test
	def void testExampleIRelativePath() {
		val rapidModel = loadSampleAndAssertNoError()
		val response = rapidModel.findResponseForMethod('Relative')
		val example = response.examples.get(0) as ExternalExample
		assertEquals(
			'''{
  "filingID": "taxFiling1"
  "jurisdiction": ""
  "year": 2012
  "currency": "USD"
  "grossIncome": 12345.67
  "taxLiability": 12.34
}'''.
				toString, example.body)
	}

// TODO:
// Remove as platform URI are not supported anymore
//	@Test
	def void testPlatfromPluginExample() {
		val rapidModel = loadSampleAndAssertNoError()
		val response = rapidModel.findResponseForMethod('Platform')
		val example = response.examples.get(0) as ExternalExample
		assertEquals("Content1", example.body)
	}

	@Test
	def void testInexistentExample() {
		val rapidModel = loadSampleAndAssertNoError()
		val response = rapidModel.findResponseForMethod('Inexistent')
		val example = response.examples.get(0) as ExternalExample
		assertNull(example.body)
	}

	def ZenModel loadSampleAndAssertNoError() {
		val modelUri = URI::createFileURI(
			Resources.getResource(ExternalExample, "/dsl/mockservice/mockexamples/ExternalExamples.rapid").file)

		val resource = new XtextResourceSet().getResource(modelUri, true) as XtextResource
		val model = resource.contents.get(0) as ZenModel
		if (resource.errors.size != 0) {
			fail(resource.errors.head.toString)
		}
		model
	}

	def TypedResponse findResponseForMethod(ZenModel model, String methodName) {
		model.firstResourceAPI.getOwnedResourceDefinitions.findFirst[name == methodName].firstMethod.
			responses.get(0)
	}

}
