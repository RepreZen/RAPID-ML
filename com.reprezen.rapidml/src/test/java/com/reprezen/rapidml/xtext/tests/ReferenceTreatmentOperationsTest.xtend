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
import com.reprezen.rapidml.ObjectResource
import com.reprezen.rapidml.ReferenceEmbed
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
class ReferenceTreatmentOperationsTest {

	@Inject extension ZenModelUtils
	@Inject

	def String simplifiedCustomerModel() {
		'''
			rapidModel Customer
				resourceAPI Customer /* or Client */ baseURI "http://modelsolv.com"
					objectResource CustomerObject type Customer
						referenceEmbed > Orders
							referenceEmbed > LineItems
								referenceLink > Product
									targetResource ProductObject
					objectResource ProductObject type Product
						linkDescriptor ProductLink
							ProductID
				dataModel Customer
					structure Customer
						Orders : containing reference Order*
					structure Order
						LineItems : containing reference LineItem*
					structure LineItem
						Product : reference Product
					structure Product
						ProductID : string
		'''
	}

	ZenModel model

	@Test
	def void testResource_allReferenceTreatments() {
		val resource = requireCustomerObject
		val allReferenceTreatments = resource.allReferenceTreatments
		assertThat(allReferenceTreatments.size, equalTo(3))
	}

	@Test
	def void testOrders_allNestedReferenceTreatments() {
		val resource = requireCustomerObject
		val orders = resource.referenceTreatments.get(0) as ReferenceEmbed
		val allReferenceTreatments = orders.allNestedReferenceTreatments
		assertThat(allReferenceTreatments.size, equalTo(2))
	}

	@Test
	def void testLineItems_allNestedReferenceTreatments() {
		val resource = requireCustomerObject
		val orders = resource.referenceTreatments.get(0) as ReferenceEmbed
		val lineItems = orders.nestedReferenceTreatments.get(0) as ReferenceEmbed
		val allReferenceTreatments = lineItems.allNestedReferenceTreatments
		assertThat(allReferenceTreatments.size, equalTo(1))
	}

	@Test
	def void testOrders_embedHierarchy() {
		val resource = requireCustomerObject
		val orders = resource.referenceTreatments.get(0) as ReferenceEmbed
		val embedHierarchy = orders.embedHierarchy
		assertThat(embedHierarchy.size, equalTo(0))
	}

	@Test
	def void testLineItems_embedHierarchy() {
		val resource = requireCustomerObject
		val orders = resource.referenceTreatments.get(0) as ReferenceEmbed
		val lineItems = orders.nestedReferenceTreatments.get(0) as ReferenceEmbed
		val embedHierarchy = lineItems.embedHierarchy
		assertThat(embedHierarchy.size, equalTo(1))
	}

	@Test
	def void testProduct_embedHierarchy() {
		val resource = requireCustomerObject
		val orders = resource.referenceTreatments.get(0) as ReferenceEmbed
		val lineItems = orders.nestedReferenceTreatments.get(0) as ReferenceEmbed
		val product = lineItems.nestedReferenceTreatments.get(0)
		val embedHierarchy = product.embedHierarchy
		assertThat(embedHierarchy.size, equalTo(2))
	}

	def ObjectResource requireCustomerObject() {
		model = loadModelAndNormalize(simplifiedCustomerModel())
		model.firstResourceAPI.firstResourceDefinition as ObjectResource
	}

}
