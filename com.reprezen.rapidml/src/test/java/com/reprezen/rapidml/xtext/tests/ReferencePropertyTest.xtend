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

@InjectWith(typeof(RapidMLInjectorProvider))
@RunWith(typeof(XtextRunner))
class ReferencePropertyTest {
	@Inject extension ValidationTestHelper
	@Inject
	ParseHelper<ZenModel> parser

	val String textualModel = 
		'''
			rapidModel Test
				dataModel TestDataModel
					structure myDataType
					structure myDataType2
						prop1 : reference myDataType
						prop2 : container reference myDataType
						prop3 : containing reference myDataType
						prop4 : reference to myDataType
						prop5 : container reference to myDataType
						prop6 : containing reference to myDataType
						prop7 : container myDataType
						prop8 : containing myDataType
						prop21 : as reference myDataType
						prop22 : as container reference myDataType
						prop23 : as containing reference myDataType
						prop24 : as reference to myDataType
						prop25 : as container reference to myDataType
						prop26 : as containing reference to myDataType
						prop27 : as container myDataType
						prop28 : as containing myDataType
		'''
		
	ZenModel model
 
 	@Before
	def void setUp() {		
  		model = parser.parse(textualModel)
 	}	
	
	@Test
	def void testParsing() {
		model.assertNoErrors
	}
}