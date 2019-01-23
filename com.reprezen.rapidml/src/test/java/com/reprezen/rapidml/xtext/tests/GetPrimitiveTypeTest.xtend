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
import com.reprezen.rapidml.ServiceDataResource
import com.reprezen.rapidml.SingleValueType
import com.reprezen.rapidml.Structure
import com.reprezen.rapidml.ZenModel
import com.reprezen.rapidml.xtext.tests.RapidMLInjectorProvider
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

import static org.hamcrest.CoreMatchers.*
import static org.junit.Assert.*

@InjectWith(typeof(RapidMLInjectorProvider))
@RunWith(typeof(XtextRunner))
class GetPrimitiveTypeTest {

	@Inject extension ZenModelUtils	

	def String modelText() {
		'''
rapidModel GetPrimitiveType
	resourceAPI GetPrimitiveTypeAPI baseURI "http://my-namespace.com"
		objectResource GetPrimitiveTypeObject type GetPrimitiveType
			URI /uri/{p1}
				required templateParam p1 property stringProp
			with only properties
				stringProp
				integerProp
				stringEnum
				intEnum 
				simpleStringType
				nestedStringType
	dataModel GetPrimitiveTypeDataModel
		structure GetPrimitiveType
			stringProp : string
			integerProp : integer
			stringEnum : MyStringEnum
			intEnum : MyIntEnum
			simpleStringType: MySimpleStringType
			nestedStringType : MyNestedSimpleType
		enum string MyStringEnum
			ITEM1 : "value1"
		enum int MyIntEnum
			ITEM1
		simpleType MySimpleStringType defined as string
			matching regex r"value1"
		simpleType MyNestedSimpleType defined as MySimpleStringType
		'''
	}

	ZenModel model

	@Before
	def void setUp() throws Exception {
		loadModel()
	}

	@Test
	def void testStringEnum() {
		val MyStringEnum = requireDataType(model.firstInterfaceDataModel, "MyStringEnum") as SingleValueType
		assertThat(MyStringEnum.primitiveType.name, equalTo("string"))
	}

	@Test
	def void testIntEnum() {
		val MyIntEnum = requireDataType(model.firstInterfaceDataModel, "MyIntEnum") as SingleValueType
		assertThat(MyIntEnum.primitiveType.name, equalTo("int"))
	}

	@Test
	def void testSimpleStringType() {
		val MySimpleStringType = requireDataType(model.firstInterfaceDataModel, "MySimpleStringType") as SingleValueType
		assertThat(MySimpleStringType.primitiveType.name, equalTo("string"))
	}

	@Test
	def void testNestedSimpleType() {
		val MyNestedSimpleType = requireDataType(model.firstInterfaceDataModel, "MyNestedSimpleType") as SingleValueType
		assertThat(MyNestedSimpleType.primitiveType.name, equalTo("string"))
	}

	@Test
	def void testPrimitiveProperty() {
		val getPrimitiveType = requireDataType(model.firstInterfaceDataModel, "GetPrimitiveType") as Structure
		assertThat(
			(getPrimitiveType.ownedFeatures.findFirst[it.name == "stringProp"] as PrimitiveProperty).primitiveType.name,
			equalTo("string"))
		assertThat(
			(getPrimitiveType.ownedFeatures.findFirst[it.name == "integerProp"] as PrimitiveProperty).primitiveType.name,
			equalTo("integer"))
		assertThat(
			(getPrimitiveType.ownedFeatures.findFirst[it.name == "stringEnum"] as PrimitiveProperty).primitiveType.name,
			equalTo("string"))
		assertThat(
			(getPrimitiveType.ownedFeatures.findFirst[it.name == "intEnum"] as PrimitiveProperty).primitiveType.name,
			equalTo("int"))
		assertThat(
			(getPrimitiveType.ownedFeatures.findFirst[it.name == "simpleStringType"] as PrimitiveProperty).primitiveType.
				name, equalTo("string"))
		assertThat(
			(getPrimitiveType.ownedFeatures.findFirst[it.name == "nestedStringType"] as PrimitiveProperty).primitiveType.
				name, equalTo("string"))

	}

	@Test
	def void testParameter() {
		val parameter = model.firstResourceAPI.firstResourceDefinition.URI.uriParameters.head
		assertThat(parameter.primitiveType.name, equalTo("string"))
	}

	@Test
	def void testIncludedProperty() {
		val properties = (model.firstResourceAPI.firstResourceDefinition as ServiceDataResource).properties.
			allIncludedProperties
		assertThat(
			(properties.map[it.baseProperty].findFirst[it.name == "stringProp"] as PrimitiveProperty).primitiveType.name,
			equalTo("string"))
		assertThat(
			(properties.map[it.baseProperty].findFirst[it.name == "integerProp"] as PrimitiveProperty).primitiveType.
				name, equalTo("integer"))
		assertThat(
			(properties.map[it.baseProperty].findFirst[it.name == "stringEnum"] as PrimitiveProperty).primitiveType.name,
			equalTo("string"))
		assertThat(
			(properties.map[it.baseProperty].findFirst[it.name == "intEnum"] as PrimitiveProperty).primitiveType.name,
			equalTo("int"))
		assertThat(
			(properties.map[it.baseProperty].findFirst[it.name == "simpleStringType"] as PrimitiveProperty).
				primitiveType.name, equalTo("string"))
		assertThat(
			(properties.map[it.baseProperty].findFirst[it.name == "nestedStringType"] as PrimitiveProperty).
				primitiveType.name, equalTo("string"))
	}

	def loadModel() {
		model = loadModelAndNormalize(modelText())
	}

}
