/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.xtext.tests

import com.reprezen.rapidml.Constraint
import com.reprezen.rapidml.LengthConstraint
import com.reprezen.rapidml.RegExConstraint
import com.reprezen.rapidml.ServiceDataResource
import com.reprezen.rapidml.xtext.tests.RapidMLInjectorProvider
import javax.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith

import static org.hamcrest.CoreMatchers.*
import static org.junit.Assert.*

@InjectWith(typeof(RapidMLInjectorProvider))
@RunWith(typeof(XtextRunner))
class ResourceRealizationConstraintsOverrideTest {

	def String textualModel() {
		'''
rapidModel ResourceRealizationConstraints 
	resourceAPI ResourceAPI baseURI "baseURI"
		objectResource MyObject type Structure
			URI /uri
			all properties
				// override constraints of stringProp1 in resource realization
				stringProp1
					length from 5 to 10
			mediaTypes
				application/xml
			method GET getMyObject
				request type Structure
					// override constraints of stringProp2 in TypedMessage
					all properties
						stringProp2
							length from 0 to 5
				response MyObject statusCode 200
	dataModel DataModel
		simpleType StringLenType defined as string
			length from 0 to 50
		simpleType StringRegType defined as string
			matching regex "([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})+"
		simpleType StringComplexType defined as string
			length from 0 to 50
			matching regex "[A-Z]+"
		simpleType IntRangeType defined as integer
			valueRange from '1' to maximum '10'

		structure Structure
			stringProp1: StringLenType
				length from 1 to 40
				matching regex "[A-Za-z0-9\\w]*"
			stringProp2: StringRegType
				length to 10
			stringProp3: string
				length from 10
			intProp1: IntRangeType
				valueRange from '2' to maximum '9'
		'''
	}

	@Inject extension ZenModelUtils

	@Test
	def void testResourceOverride() {
		val props = loadModelAndGetResource().includedProperties
		val constraints1 = props.findFirst[e|e.baseProperty.name == "stringProp1"].allConstraints
		// overrided constraints
		assertThat(constraints1.length, equalTo(2))
		assertLenConstraint(constraints1.get(0), 5, 10)
		assertRegexConstraint(constraints1.get(1), "[A-Za-z0-9\\w]*")
		
		// inherited constraints
		val constraints2 = props.findFirst[e|e.baseProperty.name == "stringProp2"].allConstraints
		assertThat(constraints2.length, equalTo(2))
		assertLenConstraint(constraints2.get(0), 0, 10)
		assertRegexConstraint(constraints2.get(1), "([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})+")
	}

	@Test
	def void testMessageOverride() {
		val props = loadModelAndGetResource().firstMethod.request.includedProperties
		val constraints1 = props.findFirst[e| e.baseProperty.name == "stringProp2"].allConstraints
		assertThat(constraints1.length, equalTo(2))
		assertLenConstraint(constraints1.get(0), 0, 5)
		assertRegexConstraint(constraints1.get(1), "([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})+")

		// inherited constraints from Model
		val constraints2 = props.findFirst[e|e.baseProperty.name == "stringProp1"].allConstraints;
		assertThat(constraints2.length, equalTo(2))
		assertLenConstraint(constraints2.get(0), 1, 40)
		assertRegexConstraint(constraints2.get(1), "[A-Za-z0-9\\w]*")

		val constraints3 = props.findFirst[e|e.baseProperty.name == "stringProp3"].allConstraints;
		assertThat(constraints3.length, equalTo(1))
		assertLenConstraint(constraints3.get(0), 10, 0)
	}

	def void assertRegexConstraint(Constraint constraint, String pattern) {
		assertTrue("Expected RegExConstraint but was " + constraint.class, constraint instanceof RegExConstraint)
		val RegExConstraint regex = constraint as RegExConstraint
		assertEquals(pattern, regex.pattern)
	}

	def void assertLenConstraint(Constraint constraint, int minLength, int maxLength) {
		assertTrue("Expected LengthConstraint but was " + constraint.class, constraint instanceof LengthConstraint)
		val LengthConstraint len = constraint as LengthConstraint
		assertEquals(minLength, len.minLength)
		assertEquals(maxLength, len.maxLength)
	}

	def ServiceDataResource loadModelAndGetResource() {
		val model = loadModelAndNormalize(textualModel())
		model.firstResourceAPI.firstResourceDefinition as ServiceDataResource
	}
}
