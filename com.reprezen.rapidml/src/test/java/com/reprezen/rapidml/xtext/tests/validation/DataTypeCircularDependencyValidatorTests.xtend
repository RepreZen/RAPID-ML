/** 
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 */
package com.reprezen.rapidml.xtext.tests.validation

import com.google.inject.Inject
import com.reprezen.rapidml.RapidmlFactory
import com.reprezen.rapidml.ReferenceProperty
import com.reprezen.rapidml.Structure
import com.reprezen.rapidml.xtext.loaders.RepreZenXtextResourceSet
import com.reprezen.rapidml.xtext.tests.RapidMLInjectorProvider
import com.reprezen.rapidml.xtext.tests.util.ValidatorHelper
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith

@InjectWith(typeof(RapidMLInjectorProvider))
@RunWith(typeof(XtextRunner))
class DataTypeCircularDependencyValidatorTests {

	@Inject extension ValidatorHelper
	val factory = RapidmlFactory::eINSTANCE

	@Test 
	def void testSelfContainmentReference() {
		var ReferenceProperty reference1 = createDataTypeWithContainmentReference("ref1")
		var Structure datatype1 = reference1.getContainingDataType()
		reference1.setType(datatype1)
		validate(reference1).assertWarningContains("Circular")
	}

	@Test 
	def void testTwoLevelContainmentCircularReference() {
		var ReferenceProperty reference1 = createDataTypeWithContainmentReference("ref1")
		var Structure datatype1 = reference1.getContainingDataType()
		var ReferenceProperty reference2 = createDataTypeWithContainmentReference("ref2")
		var Structure datatype2 = reference2.getContainingDataType()
		reference1.setType(datatype2)
		reference2.setType(datatype1)
		validate(reference1).assertWarningContains("Circular")
	}

	@Test 
	def void testThreeLevelContainmentCircularReference() {
		var ReferenceProperty reference1 = createDataTypeWithContainmentReference("ref1")
		var Structure datatype1 = reference1.getContainingDataType()
		var ReferenceProperty reference2 = createDataTypeWithContainmentReference("ref2")
		var Structure datatype2 = reference2.getContainingDataType()
		var ReferenceProperty reference3 = createDataTypeWithContainmentReference("ref3")
		var Structure datatype3 = reference3.getContainingDataType()
		reference1.setType(datatype2)
		reference2.setType(datatype3)
		reference3.setType(datatype1)
		validate(reference1).assertWarningContains("Circular")
	}

	@Test 
	def void testNoContainmentCircularReference() {
		var ReferenceProperty reference1 = createDataTypeWithContainmentReference("ref1")
		var Structure datatype1 = reference1.getContainingDataType()
		var ReferenceProperty reference2 = createDataTypeWithContainmentReference("ref2")
		var Structure datatype2 = reference2.getContainingDataType()
		reference1.setType(datatype2)
		// reference2.setType(datatype1);
		validate(reference1).assertOK()
	}

	def protected ReferenceProperty createDataTypeWithContainmentReference(String propertyName) {
		val resource = new RepreZenXtextResourceSet().createResource(URI.createURI("test.rapid"))

		val Structure datatype1 = factory.createStructure()
		datatype1.setName('''DataType_«propertyName»'''.toString)

		val ReferenceProperty reference1 = factory.createReferenceProperty()
		datatype1.getOwnedFeatures().add(reference1)
		reference1.setContainment(true)
		reference1.setName(propertyName)
		resource.contents.add(datatype1)

		return reference1
	}
}
