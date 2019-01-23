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
import com.reprezen.rapidml.ServiceDataResource
import com.reprezen.rapidml.ZenModel
import com.reprezen.rapidml.xtext.tests.RapidMLInjectorProvider
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith

import static org.hamcrest.CoreMatchers.*
import static org.junit.Assert.*

@InjectWith(typeof(RapidMLInjectorProvider))
@RunWith(typeof(XtextRunner))
class DefaultIncludedPropertesTest {

	@Inject extension ZenModelUtils
	@Inject

	def String textualModel() {
		'''
			rapidModel CardinalityOverrides
				resourceAPI Customer baseURI "http://modelsolv.com"
					objectResource Required type Customer
						// include all properties from Customer by default
				dataModel Customer
					structure Customer
						optionalListProperty : string *
		'''
	}

	ZenModel model

	@Test
	def void testDefaultMultiplicity() {
		val resource = loadModelAndRequireFirstDataResource
		val property = resource.includedProperties.findFirst[baseProperty.name == "optionalListProperty"]
		assertThat(property, notNullValue)
		assertThat(property.cardinality, equalTo(null))
		assertThat(resource.isIncluded(property.baseProperty), equalTo(true))
	}

	def ServiceDataResource loadModelAndRequireFirstDataResource() {
		model = loadModelAndNormalize(textualModel())
		val resource = model.firstResourceAPI.firstResourceDefinition as ServiceDataResource
		assertThat(resource, notNullValue)
		return resource
	}

}
