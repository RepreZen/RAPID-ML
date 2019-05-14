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
import com.reprezen.rapidml.xtext.tests.RapidMLInjectorProvider
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith

@InjectWith(typeof(RapidMLInjectorProvider))
@RunWith(typeof(XtextRunner))
class RequestInclusivePropertyListTest extends ComplexIncludedPropertyCardinalityOverrideTest {

	@Inject extension ZenModelUtils

	override String simpleIncludedPropertiesModel(String includedProperties) {
		'''rapidModel InclusiveProperties
	resourceAPI InclusivePropertiesInterface baseURI "http://my-namespace.com"
		objectResource InclusivePropertiesObject type InclusiveProperties
			URI /uri
			mediaTypes
				application/xml
			method PUT putInclusivePropertiesObject
				request type InclusiveProperties
					«includedProperties»
				response statusCode 200
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

	@Test def void foo() {
	}

	override PropertyRealization requireIncludedProperty(String propertyName) {
		val resource = requireFirstDataResource()
		val result = getIncludedProperty(resource, propertyName)
		return result
	}

	override PropertyRealization getIncludedProperty(ServiceDataResource resource, String propertyName) {
		resource.methods.get(0).request.includedProperties.findFirst[baseProperty.name == propertyName]
	}

	override Optional<ReferenceTreatment> findReferenceTreatment(String propertyName) {
		val referenceTreatments = model.firstResourceAPI.firstResourceDefinition.methods.get(0).request.
			referenceTreatments
		findReferenceTreatment(referenceTreatments, propertyName)
	}

}
