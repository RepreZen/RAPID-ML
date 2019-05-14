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
import com.reprezen.rapidml.xtext.loaders.RepreZenXtextResourceSet
import com.reprezen.rapidml.xtext.tests.RapidMLInjectorProvider
import com.reprezen.rapidml.xtext.tests.util.ValidatorHelper
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*

@InjectWith(typeof(RapidMLInjectorProvider))
@RunWith(typeof(XtextRunner))
/** 
 * Tests for incomplete or additional new line with indent
 */
class NewLineValidationTest {

	@Inject ParseHelper<ZenModel> parser
	@Inject extension ValidatorHelper

	@Test
	def void testNewLineRestfulInterface() {
		assertOK(
			'''
			rapidModel testMtype
				resourceAPI testMtypeInterface baseURI "http://my-namespace.com"
				 
			''')
	}
	
	def assertOK(String content) {
		val ResourceSet rset = new RepreZenXtextResourceSet();
		val model = parser.parse(content, rset)
		val diag = validate(model)
		diag.assertOK()
		val errors = rset.resources.head.errors
		if (!errors.empty) {
			fail(errors.head.message)
		}
	}
}
