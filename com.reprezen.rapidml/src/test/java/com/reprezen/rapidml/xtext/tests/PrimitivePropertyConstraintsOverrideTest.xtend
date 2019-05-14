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
import com.reprezen.rapidml.PrimitiveProperty
import com.reprezen.rapidml.RegExConstraint
import com.reprezen.rapidml.Structure
import com.reprezen.rapidml.ValueRangeConstraint
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
class PrimitivePropertyConstraintsOverrideTest {

	def String textualModel() {
		'''
rapidModel PrimitivePropertyConstraints 
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
			fixedString: string
				length 5
			intProp1: IntRangeType
				valueRange from '2' to maximum '9'
		'''
	}

	@Inject extension ZenModelUtils

	@Test
	def void testConstraintOverride() {
		val constraints = loadModelAndGetProperty("stringProp1").allConstraints;
		assertThat(constraints.length, equalTo(2));
		assertLenConstraint(constraints.get(0), 1, 40)
		assertRegexConstraint(constraints.get(1), "[A-Za-z0-9\\w]*")
	}
	
	@Test
	def void testConstraintAdd() {
		val constraints = loadModelAndGetProperty("stringProp2").allConstraints;
		assertThat(constraints.length, equalTo(2));
		assertLenConstraint(constraints.get(0), 0, 10)
		assertRegexConstraint(constraints.get(1), "([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})+")
	}

	@Test
	def void testConstraintForPrimitiveType() {
		val constraints = loadModelAndGetProperty("stringProp3").allConstraints;
		assertThat(constraints.length, equalTo(1));
		assertLenConstraint(constraints.get(0), 10, 0)
	}

	@Test
	def void testRangeConstraintOverride() {
		val constraints = loadModelAndGetProperty("intProp1").allConstraints;
		assertThat(constraints.length, equalTo(1));
		assertRangeConstraint(constraints.get(0), "2", "9")
	}

	@Test
	def void testFixedStringConstraints() {
		val constraints = loadModelAndGetProperty("fixedString").allConstraints;
		assertThat(constraints.length, equalTo(1));
		assertLenConstraint(constraints.get(0), 5, 5)
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

	def void assertRangeConstraint(Constraint constraint, String minValue, String maxValue) {
		assertTrue("Expected ValueRangeConstraint but was " + constraint.class, constraint instanceof ValueRangeConstraint)
		val ValueRangeConstraint range = constraint as ValueRangeConstraint
		assertEquals(minValue, range.minValue) 	
		assertEquals(maxValue, range.maxValue) 	
	}

	def PrimitiveProperty loadModelAndGetProperty(String name) {
		val model = loadModelAndNormalize(textualModel())
		val structure = model.firstInterfaceDataModel.ownedDataTypes.findFirst[e | e.name == "Structure"] as Structure
		structure.primitiveProperties.findFirst[e | e.name == name] as PrimitiveProperty
	}
}
