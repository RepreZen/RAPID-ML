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
import com.reprezen.rapidml.PrimitiveProperty
import com.reprezen.rapidml.PrimitiveType
import com.reprezen.rapidml.ZenModel
import com.reprezen.rapidml.xtext.tests.RapidMLInjectorProvider
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.junit.Test
import org.junit.runner.RunWith

import static org.hamcrest.CoreMatchers.*
import static org.junit.Assert.*
import org.junit.Before

@InjectWith(typeof(RapidMLInjectorProvider))
@RunWith(typeof(XtextRunner))
class PredefinedPrimitiveTypesTest {

	@Inject extension ValidationTestHelper
	@Inject extension ZenModelUtils
	@Inject
	ParseHelper<ZenModel> parser

	val String textualModel = 
		'''
			rapidModel MyModel
				dataModel myDataModel
					structure User
						id : decimal
						login : string
		'''
	
	ZenModel model
	
	@Before
	def void setUp() {		
  		model = parser.parse(textualModel)
 		assertThat(model.name, equalTo("MyModel"))
	}
	
	@Test
	def void testParsing() {
		model.assertNoErrors
	}
	
	@Test
	def void referencesDecimal() {
		val interfaceDataType = model.firstInterfaceDataModel.requireInterfaceDataType("User")
		val property = interfaceDataType.ownedFeatures.get(0) as PrimitiveProperty
 		val primType = property.type as PrimitiveType
 		assertNotNull(primType)
 		assertThat(primType.name, equalTo("decimal"))
 		assertThat((primType.eContainer.eContainer as ZenModel).name, equalTo("PrimitiveTypes"))	}
	
	@Test
	def void referencesString() {
		val interfaceDataType = model.firstInterfaceDataModel.requireInterfaceDataType("User")
		val property = interfaceDataType.ownedFeatures.get(1) as PrimitiveProperty
 		val primType = property.type as PrimitiveType
 		assertNotNull(primType)
 		assertThat(primType.name, equalTo("string"))
 		assertThat((primType.eContainer.eContainer as ZenModel).name, equalTo("PrimitiveTypes"))
	}
	
}
