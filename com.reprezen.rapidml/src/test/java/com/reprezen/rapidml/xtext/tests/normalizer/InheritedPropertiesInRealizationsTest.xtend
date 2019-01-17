package com.reprezen.rapidml.xtext.tests.normalizer

import com.google.inject.Inject
import com.reprezen.rapidml.Feature
import com.reprezen.rapidml.LengthConstraint
import com.reprezen.rapidml.PropertyRealization
import com.reprezen.rapidml.ServiceDataResource
import com.reprezen.rapidml.ZenModel
import com.reprezen.rapidml.xtext.tests.RapidMLInjectorProvider
import com.reprezen.rapidml.xtext.tests.ZenModelUtils
import java.util.List
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith

import static org.hamcrest.CoreMatchers.*
import static org.junit.Assert.*

@InjectWith(typeof(RapidMLInjectorProvider))
@RunWith(typeof(XtextRunner))
class InheritedPropertiesInRealizationsTest {

	@Inject extension ZenModelUtils

	def String textualModel() {
		'''
rapidModel Inheritance_realizations
	resourceAPI Inheritance_realizationsAPI baseURI "http://my-namespace.com"
		objectResource Inheritance_realizationsObject type Manager
			URI /uri/{id}
			
			with all properties excluding
				lastName, foo, taxpayerID
			
			method POST postInheritance_realizationsObject
			
				request type Manager
					with all properties 
					including
						taxpayerID!
						lastName
							of length from 2 to 11
					excluding
						firstName, bar
						
				response Inheritance_realizationsObject statusCode 200
			

	dataModel Inheritance_realizationsDataModel
		structure Person
			/** A unique, system-assigned identifier for the user. */
			taxpayerID : string
			/** Legal family name. */
			lastName : string
			/** Legal first name. */
			firstName : string
			/** Names previously used **/
			otherNames : string*
			
		structure Manager extends Person
			foo: string
			bar: string
			restrict taxpayerID: string
				of length from 5 to 15


'''
	}

	ZenModel model

	@Test
	def void testResourceRealization() {
		model = loadModelAndNormalize(textualModel())

		val resource = model.firstResourceAPI.firstResourceDefinition as ServiceDataResource
		assertThat(resource, notNullValue)

		val propertyRealization = resource.properties
		val includedProperties = propertyRealization.allIncludedProperties
		val List<String> includedPropertyNames = includedProperties.map[it.baseProperty.name]

		val List<String> expectedProperties = #['bar', 'firstName', 'otherNames']
		assertEquals(expectedProperties, includedPropertyNames)
		for (PropertyRealization prop : includedProperties) {
			assertTrue(prop.baseProperty.name + " should be included, but it's not",
				resource.isIncluded(prop.baseProperty))
			assertTrue(resource.isIncluded(prop.baseProperty))
		}

		val List<String> expectedExcludedProperties = #['lastName', 'foo', 'taxpayerID']
		assertEquals(expectedExcludedProperties, propertyRealization.excludedProperties.map[it.name])
		for (Feature prop : propertyRealization.excludedProperties) {
			assertFalse(prop.name + " should NOT be included, but it is", resource.isIncluded(prop))
		}
	}

	@Test
	def void testMessageRealization() {
		model = loadModelAndNormalize(textualModel())
		
		val resource = model.firstResourceAPI.firstResourceDefinition as ServiceDataResource
		assertThat(resource, notNullValue)

		val requestWRealization = resource.methods.get(0).request
		val propertyRealization = requestWRealization.properties
		val includedProperties = propertyRealization.allIncludedProperties
		val List<String> includedPropertyNames = includedProperties.map[it.baseProperty.name]

		val List<String> expectedProperties = #['foo', 'taxpayerID', 'lastName', 'otherNames']
		assertEquals(expectedProperties, includedPropertyNames)
		for (PropertyRealization prop : includedProperties) {
			assertTrue(prop.baseProperty.name + " should be included, but it's not",
				requestWRealization.isIncluded(prop.baseProperty))
		}

		val List<String> expectedExcludedProperties = #['firstName', 'bar']
		assertEquals(expectedExcludedProperties, propertyRealization.excludedProperties.map[it.name])
		for (Feature prop : propertyRealization.excludedProperties) {
			assertFalse(prop.name + " should NOT be included, but it is", requestWRealization.isIncluded(prop))
		}
	}

	@Test
	def void testConstraintInMessageRealization() {
		model = loadModelAndNormalize(textualModel())
	
		val resource = model.firstResourceAPI.firstResourceDefinition as ServiceDataResource
		assertThat(resource, notNullValue)

		val requestWRealization = resource.methods.get(0).request
		val propertyRealization = requestWRealization.properties
		val includedProperties = propertyRealization.allIncludedProperties
		
		val PropertyRealization propWConstraint = includedProperties.findFirst[it.baseProperty.name == "lastName"]
		assertEquals(1, propWConstraint.allConstraints.size())
		val constraint = propWConstraint.allConstraints.get(0) as LengthConstraint

		assertThat(constraint.minLength, equalTo(2))
		assertThat(constraint.maxLength, equalTo(11))

	}

}
