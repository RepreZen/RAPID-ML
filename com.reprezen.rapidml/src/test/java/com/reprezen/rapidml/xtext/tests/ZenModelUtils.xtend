/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 * 
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.xtext.tests

import com.reprezen.rapidml.DataModel
import com.reprezen.rapidml.DataType
import com.reprezen.rapidml.Feature
import com.reprezen.rapidml.Method
import com.reprezen.rapidml.ReferenceLink
import com.reprezen.rapidml.ReferenceTreatment
import com.reprezen.rapidml.ResourceAPI
import com.reprezen.rapidml.ResourceDefinition
import com.reprezen.rapidml.ServiceDataResource
import com.reprezen.rapidml.Structure
import com.reprezen.rapidml.ZenModel
import com.reprezen.rapidml.implicit.ZenModelNormalizer
import com.reprezen.rapidml.xtext.tests.RapidMLInjectorProvider
import java.util.List
import javax.inject.Inject
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.junit4.validation.ValidationTestHelper

import static org.hamcrest.CoreMatchers.*
import static org.junit.Assert.*

@InjectWith(typeof(RapidMLInjectorProvider))
class ZenModelUtils {

	@Inject ParseHelper<ZenModel> parser
	@Inject extension ValidationTestHelper

	def ZenModel loadModelAndNormalize(CharSequence modelAsText) {
		val model = parser.parse(modelAsText)
		model.assertNoErrors
		new ZenModelNormalizer().normalize(model)
		model
	}

	def ResourceAPI firstResourceAPI(ZenModel model) {
		assertNotNull(model)
		model.resourceAPIs.head
	}

	def ResourceDefinition firstResourceDefinition(ResourceAPI resourceAPI) {
		assertNotNull(resourceAPI)
		resourceAPI.getOwnedResourceDefinitions.head
	}

	def Method firstMethod(ResourceDefinition resDefinition) {
		assertNotNull(resDefinition)
		resDefinition.methods.head
	}

	/* InterfaceDataModel */
	def DataModel firstInterfaceDataModel(ZenModel model) {
		assertNotNull(model)
		model.dataModels.head
	}

	def DataType firstInterfaceDataType(DataModel model) {
		assertThat(model, notNullValue)
		model.ownedDataTypes.head
	}

	def DataType requireDataType(DataModel model, String dataTypeName) {
		assertThat(model, notNullValue)
		val result = model.ownedDataTypes.findFirst[name == dataTypeName]
		assertThat(result, notNullValue)
		return result
	}

	def Structure requireInterfaceDataType(DataModel model, String dataTypeName) {
		val result = requireDataType(model, dataTypeName)
		assertThat(result, instanceOf(typeof(Structure)))
		result as Structure
	}

	def Feature requireFeature(Structure interfaceDataType, String featureName) {
		val result = interfaceDataType.ownedFeatures.findFirst[name == featureName]
		assertThat(result, notNullValue)
		result
	}

	def List<ReferenceTreatment> getReferenceTreatments(ZenModel model) {
		val resource = model.firstResourceAPI.firstResourceDefinition as ServiceDataResource
		assertThat(resource, notNullValue)
		val result = resource.referenceTreatments
		return result
	}

	def findReferenceTreatmentForPropertyName(Iterable<ReferenceTreatment> referenceTreatments, String propertyName) {
		referenceTreatments.filter[referenceElement.name == propertyName]
	}

	def findReferenceLinkForPropertyName(List<ReferenceLink> referenceTreatments, String propertyName) {
		referenceTreatments.filter[referenceElement.name == propertyName]
	}
}
