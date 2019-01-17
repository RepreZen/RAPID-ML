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
import com.reprezen.rapidml.CollectionRealizationEnum
import com.reprezen.rapidml.CollectionResource
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

/*
 * Tests for the specification:
 * A Collection Resource represents a list of references to its bound Data Structure.  These references may be realized as embedded representations, or as hyperlinks, according to the following rules:

•	If the Collection Resource specifies a Property Set, specifies one or more Reference Links, or specifies one or more Reference Embeds:
o	The Collection Resource is realized as a list of embedded objects, following the realization model specified in the Property Set, Reference Links and/or Reference Embeds.
•	If the Collection Resource does not specify a Property Set and does not specify any Reference Links or Reference Embeds:
o	If there is a Default Object Resource for the bound Data Structure in scope, the Collection Resource will be realized as a list of hyperlinks targeting the Default Object Resource.
o	If there is not a Default Object Resource for the bound Data Structure in scope, the Collection Resource will be realized as a list embedded objects, using the default realization rules.
 */
@InjectWith(typeof(RapidMLInjectorProvider))
@RunWith(typeof(XtextRunner))
class CollectionResource_IncludedProperty_Zen2653 {

	@Inject extension ZenModelUtils
	
	val overriddenProperty = '''
	with all properties
	including
		id!'''

	val excludedProperty = '''
	with all properties
	excluding
		id'''
		
	val itemized = '''
	with only properties
		id'''

	val referenceLink = "referenceLink >ref1"
	val referenceEmbed = "referenceEmbed > ref2"

	def String simpleIncludedPropertiesModel(String propertySet, boolean withDefaultObjectResource) {
		'''
rapidModel zen2653
	resourceAPI zen2653API baseURI "http://my-namespace.com"

		collectionResource myCollection type root
			URI /uri
			«propertySet»

		«IF withDefaultObjectResource»
		objectResource myObject type root
			URI /uri/{id}
			mediaTypes
				application/xml
		«ENDIF»
		objectResource otherObject type object2
			URI /uri/{id}
			mediaTypes
				application/xml
		

	dataModel zen2653DataModel
		structure root
			id : string
			prop2: string
			ref1 : reference object2
			ref2 : reference object3
			ref3 : reference object2
			ref4 : reference object3
		structure object2
			id : string
		structure object3
			id : string'''
	}

	val referenceTreatmentNumForReferenceEmbed = 4;

	ZenModel model

	@Test
	def void test_DefaultProps_wDefaultResource() {
		val resource = loadModelAndRequireFirstDataResource("", true)
		assertThat(resource.resourceRealizationKind, equalTo(CollectionRealizationEnum::REFERENCE_LINK_LIST))
		assertThat(resource.referenceTreatments.size, equalTo(1))
		assertThat(resource.referenceLinks.size, equalTo(1))
	}

	@Test
	def void test_DefaultProps_noDefaultResource() {
		val resource = loadModelAndRequireFirstDataResource("", false)
		assertThat(resource.resourceRealizationKind, equalTo(CollectionRealizationEnum::EMBEDDED_OBJECT_LIST))
		assertThat(resource.referenceTreatments.size, equalTo(referenceTreatmentNumForReferenceEmbed))
	}

	@Test
	def void test_OverriddenProperty_wDefaultResource() {
		val resource = loadModelAndRequireFirstDataResource(overriddenProperty, true)
		assertThat(resource.resourceRealizationKind, equalTo(CollectionRealizationEnum::EMBEDDED_OBJECT_LIST))
		assertThat(resource.referenceTreatments.size, equalTo(referenceTreatmentNumForReferenceEmbed))
	}

	@Test
	def void test_ExcludedProperty_wDefaultResource() {
		val resource = loadModelAndRequireFirstDataResource(excludedProperty, true)
		assertThat(resource.resourceRealizationKind, equalTo(CollectionRealizationEnum::EMBEDDED_OBJECT_LIST))
		assertThat(resource.referenceTreatments.size, equalTo(referenceTreatmentNumForReferenceEmbed))
	}
	
	@Test
	def void test_Itemized_wDefaultResource() {
		val resource = loadModelAndRequireFirstDataResource(itemized, true)
		assertThat(resource.resourceRealizationKind, equalTo(CollectionRealizationEnum::EMBEDDED_OBJECT_LIST))
		assertThat(resource.referenceTreatments.size, equalTo(0)) // only "id" is included
	}

	@Test
	def void test_ReferenceLink_wDefaultResource() {
		val resource = loadModelAndRequireFirstDataResource(referenceLink, true)
		assertThat(resource.resourceRealizationKind, equalTo(CollectionRealizationEnum::EMBEDDED_OBJECT_LIST))
		assertThat(resource.referenceTreatments.size, equalTo(referenceTreatmentNumForReferenceEmbed))
	}

	@Test
	def void test_ReferenceEmbed_wDefaultResource() {
		val resource = loadModelAndRequireFirstDataResource(referenceEmbed, true)
		assertThat(resource.resourceRealizationKind, equalTo(CollectionRealizationEnum::EMBEDDED_OBJECT_LIST))
		assertThat(resource.referenceTreatments.size, equalTo(referenceTreatmentNumForReferenceEmbed))
	}

	@Test
	def void test_OverriddenProperty_noDefaultResource() {
		val resource = loadModelAndRequireFirstDataResource(overriddenProperty, false)
		assertThat(resource.resourceRealizationKind, equalTo(CollectionRealizationEnum::EMBEDDED_OBJECT_LIST))
		assertThat(resource.referenceTreatments.size, equalTo(referenceTreatmentNumForReferenceEmbed))
	}

	@Test
	def void test_ExcludedProperty_noDefaultResource() {
		val resource = loadModelAndRequireFirstDataResource(excludedProperty, false)
		assertThat(resource.resourceRealizationKind, equalTo(CollectionRealizationEnum::EMBEDDED_OBJECT_LIST))
		assertThat(resource.referenceTreatments.size, equalTo(referenceTreatmentNumForReferenceEmbed))
	}
	
	@Test
	def void test_Itemized_noDefaultResource() {
		val resource = loadModelAndRequireFirstDataResource(itemized, false)
		assertThat(resource.resourceRealizationKind, equalTo(CollectionRealizationEnum::EMBEDDED_OBJECT_LIST))
		assertThat(resource.referenceTreatments.size, equalTo(0)) // only "id" is included
	}

	@Test
	def void test_ReferenceLink_noDefaultResource() {
		val resource = loadModelAndRequireFirstDataResource(referenceLink, false)
		assertThat(resource.resourceRealizationKind, equalTo(CollectionRealizationEnum::EMBEDDED_OBJECT_LIST))
		assertThat(resource.referenceTreatments.size, equalTo(referenceTreatmentNumForReferenceEmbed))
	}

	@Test
	def void test_ReferenceEmbed_noDefaultResource() {
		val resource = loadModelAndRequireFirstDataResource(referenceEmbed, false)
		assertThat(resource.resourceRealizationKind, equalTo(CollectionRealizationEnum::EMBEDDED_OBJECT_LIST))
		assertThat(resource.referenceTreatments.size, equalTo(referenceTreatmentNumForReferenceEmbed))
	}

	def CollectionResource loadModelAndRequireFirstDataResource(String propertySet, boolean wDefaultResource) {
		model = loadModelAndNormalize(simpleIncludedPropertiesModel(propertySet, wDefaultResource))
		val resource = model.firstResourceAPI.firstResourceDefinition as ServiceDataResource
		assertThat(resource, notNullValue)
		return resource as CollectionResource
	}

	def PropertyRealization getIncludedProperty(ServiceDataResource resource, String propertyName) {
		resource.includedProperties.findFirst[baseProperty.name == propertyName]
	}

}