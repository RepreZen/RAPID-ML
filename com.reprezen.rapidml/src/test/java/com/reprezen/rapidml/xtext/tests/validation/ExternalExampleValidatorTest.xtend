/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.xtext.tests.validation

import com.reprezen.rapidml.ExternalExample
import com.reprezen.rapidml.ZenModel
import com.reprezen.rapidml.xtext.tests.RapidMLInjectorProvider
import com.reprezen.rapidml.xtext.validation.XtextDslJavaValidator
import java.nio.file.Files
import javax.inject.Inject
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.junit4.validation.ValidatorTester
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*

@InjectWith(typeof(RapidMLInjectorProvider))
@RunWith(typeof(XtextRunner))
class ExternalExampleValidatorTest {
	@Inject private ParseHelper<ZenModel> parser
	@Inject private ValidatorTester<XtextDslJavaValidator> tester;

	def String textualModel(String path) {
		'''
			rapidModel zen
				resourceAPI ResourceAPI baseURI "http://localhost"
					objectResource SomeObject type SomeType
						URI whatever
						externalExample "«path»"
			
				dataModel zenData
					structure SomeType
						id : string
		'''
	}

	def String goodPath() {
		//we don't want to bother with real example files here, all we need is uri which can be resolved to stream
		//as validator only checks the presents of the stream, not the contents
		//so we will just construct something that should work 
		val file = Files.createTempFile("rzntest", ".tmp")
		file.toFile.deleteOnExit
		Files.write(file, "hello".bytes)
		return URI.createFileURI(file.toString).toString
	}

	def String badPath() {
		goodPath + "_doesNotExist"
	}

	@Test
	def void testWithGoodPath() {
		var withGoodPath = loadModelAndGetExample(goodPath);
		assertNotNull(withGoodPath)
		val validator = tester.validate(withGoodPath)
		validator.assertOK
	}

	@Test
	def void testWithBadPath() {
		var withBadPath = loadModelAndGetExample(badPath);
		assertNotNull(withBadPath)
		val validator = tester.validate(withBadPath)
		validator.assertWarningContains("Cannot read example at")
	}

	def ExternalExample loadModelAndGetExample(String path) {
		val model = parser.parse(textualModel(path))
		assertNotNull(model)
		return model.eAllContents.filter(typeof(ExternalExample)).head;
	}
}
