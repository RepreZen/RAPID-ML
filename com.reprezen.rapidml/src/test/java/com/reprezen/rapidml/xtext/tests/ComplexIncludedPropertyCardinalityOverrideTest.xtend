/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.xtext.tests

import com.google.common.base.Optional
import com.google.inject.Inject
import com.reprezen.rapidml.PropertyRealization
import com.reprezen.rapidml.ReferenceTreatment
import com.reprezen.rapidml.ServiceDataResource
import com.reprezen.rapidml.ZenModel
import com.reprezen.rapidml.xtext.tests.RapidMLInjectorProvider
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith

import static org.hamcrest.CoreMatchers.*
import static org.junit.Assert.*

@InjectWith(typeof(RapidMLInjectorProvider))
@RunWith(typeof(XtextRunner))
class ComplexIncludedPropertyCardinalityOverrideTest {

	@Inject extension ZenModelUtils

	def String simpleIncludedPropertiesModel(String includedProperties) {
		'''rapidModel InclusiveProperties
	resourceAPI InclusivePropertiesInterface baseURI "http://my-namespace.com"
		objectResource InclusivePropertiesObject type InclusiveProperties
			URI /uri
			«includedProperties»
			mediaTypes
				application/xml
			method GET getInclusivePropertiesObject
				request
				response InclusivePropertiesObject statusCode 200
			method PUT putInclusivePropertiesObject
				request InclusivePropertiesObject
				response statusCode 200
				response statusCode 400

		objectResource MyStructure2Resource type MyStructure2
			URI /uri2
			mediaTypes
				application/xml

	dataModel InclusivePropertiesDataModel
		structure InclusiveProperties
			id : string
			prop1: string*
			prop2: string*
			prop3: string
			ref1: reference InclusiveProperties
			ref2: reference MyStructure2*
		structure MyStructure2
			id: string'''
	}

	protected ZenModel model

	@Test
	def void testOverriddenProperty() {
		model = loadModelAndNormalize(
			simpleIncludedPropertiesModel(
				'''all properties including
	prop1+'''))

		// overriden
		val prop1 = requireIncludedProperty("prop1")
		assertNotNull(prop1)
		assertThat(prop1.minOccurs, equalTo(1));
		assertThat(prop1.maxOccurs, equalTo(-1));

		val prop2 = requireIncludedProperty("prop2")
		assertNotNull(prop2)
		assertThat(prop2.minOccurs, equalTo(0));
		assertThat(prop2.maxOccurs, equalTo(-1));

		val prop3 = requireIncludedProperty("prop3")
		assertNotNull(prop3)
		assertThat(prop3.minOccurs, equalTo(0));
		assertThat(prop3.maxOccurs, equalTo(1));

		val ref1 = requireIncludedProperty("ref1")
		assertNotNull(ref1)

		val refTreatment = findReferenceTreatment("ref1")
		assertTrue(refTreatment.present)
	}

	@Test
	def void testOverriddenReference() {
		model = loadModelAndNormalize(
			simpleIncludedPropertiesModel(
				'''all properties including
	ref2!'''))

		val refTreatment = findReferenceTreatment("ref2")
		assertTrue(refTreatment.present)

		val refProp = requireIncludedProperty("ref2")
		assertNotNull(refProp)
		assertThat(refProp.minOccurs, equalTo(1));
		assertThat(refProp.maxOccurs, equalTo(1));
	}

	@Test
	def void testSimpleReference() {
		model = loadModelAndNormalize(
			simpleIncludedPropertiesModel(
				'''all properties including
	ref2'''))

		val refTreatment = findReferenceTreatment("ref2")
		assertTrue(refTreatment.present)

		val refProp = requireIncludedProperty("ref2")
		assertNotNull(refProp)
		assertThat(refProp.minOccurs, equalTo(0));
		assertThat(refProp.maxOccurs, equalTo(-1));
	}

	@Test
	def void testExcludedProperty() {
		val modelText = simpleIncludedPropertiesModel(
				'''all properties excluding
	prop2''')
		model = loadModelAndNormalize(
			modelText)


		val prop1 = requireIncludedProperty("prop1")
		assertNotNull(prop1)
		assertThat(prop1.minOccurs, equalTo(0));
		assertThat(prop1.maxOccurs, equalTo(-1));

		// excluded
		val prop2 = requireIncludedProperty("prop2")
		assertNull(prop2)

		val prop3 = requireIncludedProperty("prop3")
		assertNotNull(prop3)
		assertThat(prop3.minOccurs, equalTo(0));
		assertThat(prop3.maxOccurs, equalTo(1));

		val ref1 = requireIncludedProperty("ref1")
		assertNotNull(ref1)

		val refTreatment = findReferenceTreatment("ref1")
		assertTrue(refTreatment.present)

	}

	@Test
	def void testExcludedReference() {
		model = loadModelAndNormalize(
			simpleIncludedPropertiesModel(
				'''all properties excluding
	ref1'''))

		val prop1 = requireIncludedProperty("prop1")
		assertNotNull(prop1)

		val prop2 = requireIncludedProperty("prop2")
		assertNotNull(prop2)

		val prop3 = requireIncludedProperty("prop3")
		assertNotNull(prop3)

		val ref1 = requireIncludedProperty("ref1")
		assertNull(ref1)

		val refTreatment = findReferenceTreatment("ref1")
		assertFalse(refTreatment.present)

	}

	@Test
	def void testImplicitlyIncludedProperty() {
		val modelText = 
			simpleIncludedPropertiesModel(
				'''with only properties
	prop3''')

		model = loadModelAndNormalize(modelText)

		val prop1 = requireIncludedProperty("prop1")
		assertNull(prop1)

		// excluded
		val prop2 = requireIncludedProperty("prop2")
		assertNull(prop2)

		val includedProperty = requireIncludedProperty("prop3")
		assertNotNull(includedProperty)
		assertThat(includedProperty.minOccurs, equalTo(0));
		assertThat(includedProperty.maxOccurs, equalTo(1));

		val ref1 = requireIncludedProperty("ref1")
		assertNull(ref1)

		val refTreatment = findReferenceTreatment("ref1")
		assertFalse(refTreatment.present)

	}

	def PropertyRealization requireIncludedProperty(String propertyName) {
		val resource = requireFirstDataResource()
		val result = getIncludedProperty(resource, propertyName)
		return result
	}

	def ServiceDataResource requireFirstDataResource() {
		val resource = model.firstResourceAPI.firstResourceDefinition as ServiceDataResource
		assertThat(resource, notNullValue)
		return resource
	}

	def PropertyRealization getIncludedProperty(ServiceDataResource resource, String propertyName) {
		resource.includedProperties.findFirst[baseProperty.name == propertyName]
	}

	def Optional<ReferenceTreatment> findReferenceTreatment(String propertyName) {
		findReferenceTreatment(model.referenceTreatments, propertyName)
	}

	def Optional<ReferenceTreatment> findReferenceTreatment(Iterable<ReferenceTreatment> referenceTreatments,
		String propertyName) {
		val referenceTreatmentsForName = referenceTreatments.filter[
			referenceElement.name == propertyName]
		if (referenceTreatmentsForName.size > 0) {
			Optional::of(referenceTreatmentsForName.head)
		} else {
			Optional::absent
		}
	}

}
