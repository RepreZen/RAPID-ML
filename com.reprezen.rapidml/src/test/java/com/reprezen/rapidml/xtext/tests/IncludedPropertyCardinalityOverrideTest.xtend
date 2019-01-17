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
import com.reprezen.rapidml.PropertyRealization
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
class IncludedPropertyCardinalityOverrideTest {

	@Inject extension ZenModelUtils
	
	def String simpleIncludedPropertiesModel(String multiplicity) {
		'''
			rapidModel CardinalityOverrides
				resourceAPI Customer baseURI "http://modelsolv.com"
					objectResource Required type Customer
						only properties
							// valid
							optionalListProperty «multiplicity»
				dataModel Customer
					structure Customer
						optionalListProperty : string *
						excludedProperty: string
		'''
	}

	ZenModel model

	@Test
	def void testDefaultMultiplicity() {
		val includedProperty = loadModelAndRequireIncludedProperty("")
		assertThat(includedProperty.cardinality, equalTo(null))
	}

	@Test
	def void testRequiredProperty() {
		val includedProperty = loadModelAndRequireIncludedProperty("!")
		assertThat(includedProperty.minOccurs, equalTo(1));
		assertThat(includedProperty.maxOccurs, equalTo(1));
	}

	@Test
	def void testIsIncluded_excluded() {
		val resource = loadModelAndRequireFirstDataResource("")
		val includedProperty = getIncludedProperty(resource, "excludedProperty")
		assertThat(includedProperty, nullValue)
		val property = model.firstInterfaceDataModel.requireInterfaceDataType("Customer").requireFeature("excludedProperty")
		assertThat(property, notNullValue)
		assertThat(resource.isIncluded(property), equalTo(false));
	}

	@Test
	def void testIsIncluded_included() {
		val resource = loadModelAndRequireFirstDataResource("")
		val includedProperty = getIncludedProperty(resource, "optionalListProperty")
		assertThat(includedProperty, notNullValue)
		assertThat(resource.isIncluded(includedProperty.baseProperty), equalTo(true));
	}

	def PropertyRealization loadModelAndRequireIncludedProperty(String xtextNotation) {
		val resource = loadModelAndRequireFirstDataResource(xtextNotation)
		val result = getIncludedProperty(resource, "optionalListProperty")
		assertThat(result, notNullValue)
		return result
	}

	def ServiceDataResource loadModelAndRequireFirstDataResource(String xtextNotation) {
		model = loadModelAndNormalize(simpleIncludedPropertiesModel(xtextNotation))
		val resource = model.firstResourceAPI.firstResourceDefinition as ServiceDataResource
		assertThat(resource, notNullValue)
		return resource
	}

	def PropertyRealization getIncludedProperty(ServiceDataResource resource, String propertyName) {
		resource.includedProperties.findFirst[baseProperty.name == propertyName]
	}

}
