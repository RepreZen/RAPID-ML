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
import com.reprezen.rapidml.ResourceAPI
import com.reprezen.rapidml.ServiceDataResource
import com.reprezen.rapidml.ZenModel
import com.reprezen.rapidml.implicit.ZenModelNormalizer
import com.reprezen.rapidml.xtext.tests.RapidMLInjectorProvider
import java.util.List
import javax.inject.Inject
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.resource.XtextResourceSet
import org.junit.Test
import org.junit.runner.RunWith

import static com.reprezen.rapidml.util.ReferenceTreatmentUtils.*
import static org.hamcrest.CoreMatchers.*
import static org.junit.Assert.*
import com.google.common.io.Resources

@InjectWith(typeof(RapidMLInjectorProvider))
@RunWith(typeof(XtextRunner))
class ImplicitChainedReferenceLinkTest {

	@Inject extension ZenModelUtils

	@Test
	def void testCustomerResourceLink() {
		var restInterface = loadModelAndGetRestfulInterface
		val resource = restInterface.getOwnedResourceDefinitions.get(0) as ServiceDataResource
		assertThat(resource, notNullValue)
		assertThat(resource.name, equalTo("CustomerObject"))
		val List<ReferenceTreatment> referenceTreatments = resource.referenceTreatments
		assertFalse(referenceTreatments.isEmpty)
		val orders = referenceTreatments.filter[getLabel(referenceElement) == ">Orders"]
		assertThat(orders.size, equalTo(1))
		val lineItems = (orders.findFirst[true] as ReferenceEmbed).getNestedReferenceTreatments().filter[getLabel(referenceElement) == ">LineItems"]
		assertThat(lineItems.size, equalTo(1))
		val product = (lineItems.findFirst[true] as ReferenceEmbed).nestedReferenceTreatments.filter[getLabel(referenceElement) == ">Product"]
		assertThat(product.size, equalTo(1))
		val refLink = product.findFirst[true]
		assertThat(refLink, instanceOf(typeof(ReferenceLink)))
	}

	@Test
	def void testProductResourceLink() {
		var restInterface = loadModelAndGetRestfulInterface
		val resource = restInterface.getOwnedResourceDefinitions.get(1) as ServiceDataResource
		assertThat(resource, notNullValue)
		assertThat(resource.name, equalTo("ProductObject"))
		val List<ReferenceTreatment> referenceTreatments = resource.referenceTreatments
		assertTrue(referenceTreatments.isEmpty)
	}

	@Test
	def void testOrderReferenceLink() {
		var restInterface = loadModelAndGetRestfulInterface
		val resource = restInterface.getOwnedResourceDefinitions.get(2) as ServiceDataResource
		assertThat(resource, notNullValue)
		assertThat(resource.name, equalTo("OrderObject"))
		val link = getNestedReferenceTreatment(resource, "LineItems/Product")
		assertNotNull(link.targetResource)
		assertEquals("ProductObject", link.targetResource.name)
	}

	@Test
	def void testBigOrderResourceLink() {
		var restInterface = loadModelAndGetRestfulInterface
		val resource = restInterface.getOwnedResourceDefinitions.get(3) as ServiceDataResource
		assertThat(resource, notNullValue)
		assertThat(resource.name, equalTo("BigOrderObject"))
		val link = getNestedReferenceTreatment(resource, "LineItems/Product")
		assertNotNull(link.targetResource)
		assertEquals("ProductObject", link.targetResource.name)
	}

	def ZenModel loadModel() {
		val modelUri = URI::createFileURI(Resources.getResource(class, "/dsl/Customer.rapid").file)
		val Resource resource = new XtextResourceSet().getResource(modelUri, true);
		resource.contents.get(0) as ZenModel
	}

	def ResourceAPI loadModelAndGetRestfulInterface() {
		val model = loadModel()
		new ZenModelNormalizer().normalize(model)

		model.firstResourceAPI
	}
	
	def ReferenceLink getNestedReferenceTreatment(ServiceDataResource resource, String path) {
		val tokens = path.split("/").iterator
		assertTrue(tokens.hasNext)
		val token = tokens.next
		var referenceTreatments = resource.referenceTreatments.findReferenceTreatmentForPropertyName(token)
		assertThat(referenceTreatments.size, equalTo(1))
		var current = referenceTreatments.findFirst[true]
		assertNotNull(current)
		while (tokens.hasNext) {
			assertThat(current, instanceOf(typeof(ReferenceEmbed)))
			val embed = current as ReferenceEmbed
			val next = tokens.next
			referenceTreatments = embed.nestedReferenceTreatments.findReferenceTreatmentForPropertyName(next)
			assertThat(referenceTreatments.size, equalTo(1))
			current = referenceTreatments.findFirst[true]
			assertNotNull(current)
		}
		assertThat(current, instanceOf(typeof(ReferenceLink)))
		current as ReferenceLink
	}
}
