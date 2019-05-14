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
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.junit.Test
import org.junit.runner.RunWith

@InjectWith(typeof(RapidMLInjectorProvider))
@RunWith(typeof(XtextRunner))
class ParameterTypeTest {

	@Inject extension ValidationTestHelper
	@Inject
	ParseHelper<ZenModel> parser

	def String textualModel(String xsdTypeName) {
		'''
			rapidModel TestModel
				resourceAPI TestInterface baseURI "http://modelsolv.com"
					collectionResource TestResource type myDataType
						URI /{param1}
							required templateParam param1 type «xsdTypeName»
						required collectionParam param2 type «xsdTypeName»
						method GET getMethod
							request
							response
								param param3 type «xsdTypeName»
				dataModel dm
					structure myDataType
						id : string
		'''
	}
	
	ZenModel model
	
	@Test
	def void testUsingString() {
  		model = parser.parse(textualModel("string"))
		model.assertNoErrors
	}

}
