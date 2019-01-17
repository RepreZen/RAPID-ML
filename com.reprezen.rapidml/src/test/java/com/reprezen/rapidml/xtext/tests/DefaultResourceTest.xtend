/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.xtext.tests

import com.reprezen.rapidml.ReferenceEmbed
import com.reprezen.rapidml.ReferenceLink
import com.reprezen.rapidml.ReferenceTreatment
import com.reprezen.rapidml.ServiceDataResource
import com.reprezen.rapidml.ZenModel
import com.reprezen.rapidml.xtext.tests.RapidMLInjectorProvider
import java.util.ArrayList
import java.util.Collections
import javax.inject.Inject
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith

import static org.hamcrest.CoreMatchers.*
import static org.junit.Assert.*

@InjectWith(typeof(RapidMLInjectorProvider))
@RunWith(typeof(XtextRunner))
class DefaultResourceTest {

	@Inject extension ZenModelUtils
	private ZenModel model
	
	def String textualModel(String objectResources, String collectionResources) {
		'''
			rapidModel Customer_inlineLinkDescriptor
				resourceAPI Customer baseURI "http://modelsolv.com"
					objectResource CustomerObject type Customer
						only properties
							Order
						referenceEmbed > Order
							referenceEmbed > LineItems
								referenceLink  > Products
									targetResource ProductObject
									linkRelation related
								referenceLink  > Product
									targetResource ProductObject
						mediaTypes
							application/xml
						method GET Customer
							request
							response CustomerObject statusCode 200
					«objectResources»
					«collectionResources»
					default objectResource OrderObject type Order
					objectResource LineItemObject type LineItem
				dataModel Customer
					structure Customer
						/**Orders reference*/
						Order : containing reference Order
					structure Order
						LineItems : containing reference LineItem *
					structure LineItem
						Products : reference Product*
						Product : reference Product
					structure Product
		'''
	}

	@Test
	def void testExplicitDefaultResource() {
		loadModel(
			'''
				objectResource ProductObject type Product
				default objectResource ProductObject2 type Product
			''',
			'''
				collectionResource ProductCollection type Product
				default collectionResource ProductCollection2 type Product
			''')
		// explicit choice of default resource
		checkDefaultResource("LineItemObject", "Products", "ProductCollection2")
		checkDefaultResource("LineItemObject", "Product", "ProductObject2")
		
		// explicit targetResource
		checkDefaultResource("CustomerObject", "Products", "ProductObject")
		checkDefaultResource("CustomerObject", "Product", "ProductObject")
		
	}
	
	@Test
	def void testOnlyOnePossibleDefaultResource() {
		loadModel(
			'''
				objectResource ProductObject type Product
			''',
			'''
				collectionResource ProductCollection type Product
			''')
		// choice of only one declared resource as default
		checkDefaultResource("LineItemObject", "Products", "ProductCollection")
		checkDefaultResource("LineItemObject", "Product", "ProductObject")
		
		// explicit targetResource
		checkDefaultResource("CustomerObject", "Products", "ProductObject")
		checkDefaultResource("CustomerObject", "Product", "ProductObject")
		
	}
	
	@Test
	def void testNoDefaultResource() {
		loadModel(
			'''
				objectResource ProductObject type Product
				objectResource ProductObject2 type Product
			''',
			'''
				collectionResource ProductCollection type Product
				collectionResource ProductCollection2 type Product
			''')
		// can not find default resource
		checkNullDefaultResource("LineItemObject", "Products")
		checkNullDefaultResource("LineItemObject", "Product")
		
		// explicit targetResource
		checkDefaultResource("CustomerObject", "Products", "ProductObject")
		checkDefaultResource("CustomerObject", "Product", "ProductObject")
		
	}
	
	@Test
	def void testNoDefaultResourceForMultiValue() {
		loadModel(
			'''
				objectResource ProductObject type Product
			''', 
			'''
				collectionResource ProductCollection type Product
				collectionResource ProductCollection2 type Product
			''')
		// now a multi-valued property is bound to the object resource
		// when its collection resource is not present
		checkDefaultResource("LineItemObject", "Products", "ProductObject")
		checkDefaultResource("LineItemObject", "Product", "ProductObject")
		
		// explicit targetResource
		checkDefaultResource("CustomerObject", "Products", "ProductObject")
		checkDefaultResource("CustomerObject", "Product", "ProductObject")
		
	}
	
	@Test
	def void testNoDefaultResourceForSingleValue() {
		loadModel(
			'''
				objectResource ProductObject type Product
				objectResource ProductObject2 type Product
			''',
			'''
				collectionResource ProductCollection type Product
			''')
		
		// can not find default resource for single-valued reference
		checkDefaultResource("LineItemObject", "Products", "ProductCollection")
		checkNullDefaultResource("LineItemObject", "Product")
		
		// explicit targetResource
		checkDefaultResource("CustomerObject", "Products", "ProductObject")
		checkDefaultResource("CustomerObject", "Product", "ProductObject")
		
	}
	
	def ZenModel loadModel(String objectResources, String collectionResources) {
		model = loadModelAndNormalize(textualModel(objectResources, collectionResources))
		return model
	}
	
	def ServiceDataResource getDataResource(String resName) {
		val resources = model.resourceAPIs.get(0).ownedResourceDefinitions.filter[resName == name];
		assertThat(resources.size, equalTo(1))
		return resources.findFirst[true] as ServiceDataResource
	}
	
	def ReferenceLink getReferenceLink(String resName, String prop) {
		val res = getDataResource(resName)
		val links = res.getAllReferenceTreatments().findReferenceTreatmentForPropertyName(prop)
		assertThat(links.size, equalTo(1))
		return links.findFirst[true] as ReferenceLink
	}

	def getAllReferenceTreatments(ServiceDataResource resource) {
		val result = new ArrayList(resource.referenceTreatments)
		result.addAll(
			resource.referenceTreatments.map[getReferenceTreatments()].reduce[p1, p2|
				if(p1 == null) p2 else if(p2 == null) p1 else p1 + p2])
		return result
	}

	def dispatch Iterable<ReferenceTreatment> getReferenceTreatments(ReferenceEmbed referenceEmbed) {
		val result = new ArrayList(referenceEmbed.nestedReferenceTreatments)
		val embeddedReferenceTreaments = referenceEmbed.nestedReferenceTreatments.map[getReferenceTreatments()];
		val flatEmbeddedReferenceTreatments = embeddedReferenceTreaments.reduce[p1, p2|
			if(p1 == null) p2 else if(p2 == null) p1 else p1 + p2]
		if (flatEmbeddedReferenceTreatments != null) { // reduce can return null and it will cause NPE in addAll
			result.addAll(flatEmbeddedReferenceTreatments)
		}
		return result
	}

	def dispatch Iterable<ReferenceTreatment> getReferenceTreatments(ReferenceLink referenceLink) {
		Collections::emptyList
	}
		
	def ReferenceLink getNullableReferenceLink(String resName, String prop) {
		val res = getDataResource(resName)
		val links = res.referenceLinks.findReferenceLinkForPropertyName(prop)
		return links.findFirst[true]
	}
	
	def void checkDefaultResource(String resName, String ref, String expected) {		
		val prop = getReferenceLink(resName, ref)
		assertNotNull(prop.targetResource)
	    assertEquals(expected, prop.targetResource.name)
	}
	
	def void checkNullDefaultResource(String resName, String ref) {		
		val prop = getNullableReferenceLink(resName, ref)
		assertTrue(null == prop || null == prop.targetResource)
	}
	
}