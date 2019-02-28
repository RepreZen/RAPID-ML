/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 * 
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.xtext.tests

import com.reprezen.rapidml.ConstrainableType
import com.reprezen.rapidml.RapidmlPackage
import com.reprezen.rapidml.ZenModel
import com.reprezen.rapidml.implicit.ZenModelNormalizer
import javax.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*

@InjectWith(typeof(RapidMLInjectorProvider))
@RunWith(typeof(XtextRunner))
class ConstraintsCyclesTest {

	@Inject ParseHelper<ZenModel> parser

	def String textualModel() {
		'''
rapidModel ConstraintsCycles 
	dataModel DataModel
		// this is incorrect reference
		simpleType StringLenType defined as StringComplexType
			length from 0 to 50
		simpleType StringRegType defined as string
			matching regex "([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})+"
		simpleType StringComplexType defined as StringLenType
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
	@Inject extension ValidationTestHelper

	@Test
	def void testCycleConstraintsError() {
		// do NOT call this method as it validates the model and the model has validation errors
		// val model = loadModelAndNormalize(textualModel())
		val model = parser.parse(textualModel())
		new ZenModelNormalizer().normalize(model)

		val type = model.firstInterfaceDataModel.ownedDataTypes.
			findFirst[e|e.name == "StringLenType"] as ConstrainableType
		assertNull(type.constrainableParent)

		model.assertError(RapidmlPackage.Literals.DATA_TYPE, null, "Circular reference in base type: StringLenType")
//		tester.validate(model).assertAny(
//			AssertableDiagnostics.errorMsg("Circular reference in base type: StringLenType"))
	}
}
