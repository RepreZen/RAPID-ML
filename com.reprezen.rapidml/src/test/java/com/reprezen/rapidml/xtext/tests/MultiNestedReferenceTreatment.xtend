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
import javax.inject.Inject
import org.eclipse.xtext.junit4.AbstractXtextTests
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith

import static org.hamcrest.CoreMatchers.*

@InjectWith(typeof(RapidMLInjectorProvider))
@RunWith(typeof(XtextRunner))
class MultiNestedReferenceTreatment extends AbstractXtextTests {
	@Inject extension ZenModelUtils
	private ZenModel model
	
	def String getTextualModel(String attribute, String explicitReferenceTreatment, String resources) {
		'''
			rapidModel Test
				resourceAPI Test baseURI "http://modelsolv.com"
					objectResource TaxFilingObject type TaxFiling
						«explicitReferenceTreatment»
					«resources»
				dataModel Test
					structure TaxFiling
						taxpayer : «attribute» reference Person
						controller : «attribute» reference Person
					structure Person
						homeAddress : «attribute» reference Address
						address : «attribute» reference Address
					structure Address
						propertyRecord1 : «attribute» reference PropertyRecord
						propertyRecord2 : «attribute» reference PropertyRecord
					structure PropertyRecord
						taxFiling : «attribute» reference TaxFiling
		'''
	}

	def void prepare(String attribute, String explicitReferenceTreatment, String resources) {
		model = loadModelAndNormalize(getTextualModel(attribute, explicitReferenceTreatment, resources));
	}

	// TODO: FIX
	@Test(expected= AssertionError)
	def void testMultiReferenceEmbeds() {
		prepare("containing", "", "")
		val taxpayer = assureReferenceEmbed("TaxFilingObject", "taxpayer")
		val controller = assureReferenceEmbed("TaxFilingObject", "controller")
		val homeAddress1 = assureNestedReferenceEmbed(taxpayer, "homeAddress")
		val homeAddress2 = assureNestedReferenceEmbed(controller, "homeAddress")
		val address1 = assureNestedReferenceEmbed(taxpayer, "address")
		val address2 = assureNestedReferenceEmbed(controller, "address")
		val propertyRecord11 = assureNestedReferenceEmbed(homeAddress1, "propertyRecord1")
		val propertyRecord12 = assureNestedReferenceEmbed(homeAddress2, "propertyRecord1")
		val propertyRecord13 = assureNestedReferenceEmbed(address1, "propertyRecord1")
		val propertyRecord14 = assureNestedReferenceEmbed(address2, "propertyRecord1")
		val propertyRecord21 = assureNestedReferenceEmbed(homeAddress1, "propertyRecord2")
		val propertyRecord22 = assureNestedReferenceEmbed(homeAddress2, "propertyRecord2")
		val propertyRecord23 = assureNestedReferenceEmbed(address1, "propertyRecord2")
		val propertyRecord24 = assureNestedReferenceEmbed(address2, "propertyRecord2")
		assertTrue(propertyRecord11.nestedReferenceTreatments.empty)
		assertTrue(propertyRecord12.nestedReferenceTreatments.empty)
		assertTrue(propertyRecord13.nestedReferenceTreatments.empty)
		assertTrue(propertyRecord14.nestedReferenceTreatments.empty)
		assertTrue(propertyRecord21.nestedReferenceTreatments.empty)
		assertTrue(propertyRecord22.nestedReferenceTreatments.empty)
		assertTrue(propertyRecord23.nestedReferenceTreatments.empty)
		assertTrue(propertyRecord24.nestedReferenceTreatments.empty)
	}
	
	// TODO: FIX
	@Test(expected= AssertionError)
	def void testContainmentMultiReferenceEmbeds() {
		prepare("", "", "")
		val taxpayer = assureReferenceEmbed("TaxFilingObject", "taxpayer")
		val controller = assureReferenceEmbed("TaxFilingObject", "controller")
		val homeAddress1 = assureNestedReferenceEmbed(taxpayer, "homeAddress")
		val homeAddress2 = assureNestedReferenceEmbed(controller, "homeAddress")
		val address1 = assureNestedReferenceEmbed(taxpayer, "address")
		val address2 = assureNestedReferenceEmbed(controller, "address")
		val propertyRecord11 = assureNestedReferenceEmbed(homeAddress1, "propertyRecord1")
		val propertyRecord12 = assureNestedReferenceEmbed(homeAddress2, "propertyRecord1")
		val propertyRecord13 = assureNestedReferenceEmbed(address1, "propertyRecord1")
		val propertyRecord14 = assureNestedReferenceEmbed(address2, "propertyRecord1")
		val propertyRecord21 = assureNestedReferenceEmbed(homeAddress1, "propertyRecord2")
		val propertyRecord22 = assureNestedReferenceEmbed(homeAddress2, "propertyRecord2")
		val propertyRecord23 = assureNestedReferenceEmbed(address1, "propertyRecord2")
		val propertyRecord24 = assureNestedReferenceEmbed(address2, "propertyRecord2")
		assertTrue(propertyRecord11.nestedReferenceTreatments.empty)
		assertTrue(propertyRecord12.nestedReferenceTreatments.empty)
		assertTrue(propertyRecord13.nestedReferenceTreatments.empty)
		assertTrue(propertyRecord14.nestedReferenceTreatments.empty)
		assertTrue(propertyRecord21.nestedReferenceTreatments.empty)
		assertTrue(propertyRecord22.nestedReferenceTreatments.empty)
		assertTrue(propertyRecord23.nestedReferenceTreatments.empty)
		assertTrue(propertyRecord24.nestedReferenceTreatments.empty)
	}
	
	// TODO: FIX
	@Test(expected=AssertionError)
	def void testExplicitLink() {
		prepare("", 
				'''
					referenceLink > controller
						targetResource ControllerObject
				''', 
				'''
					objectResource ControllerObject type Person
					objectResource TaxpayerObject type Person
				''')
		val taxpayer = assureReferenceEmbed("TaxFilingObject", "taxpayer")
		val controller = assureReferenceLink("TaxFilingObject", "controller")
		assureTargetResource(controller, "ControllerObject")
		val homeAddress1 = assureNestedReferenceEmbed(taxpayer, "homeAddress")
		val address1 = assureNestedReferenceEmbed(taxpayer, "address")
		val propertyRecord11 = assureNestedReferenceEmbed(homeAddress1, "propertyRecord1")
		val propertyRecord13 = assureNestedReferenceEmbed(address1, "propertyRecord1")
		val propertyRecord21 = assureNestedReferenceEmbed(homeAddress1, "propertyRecord2")
		val propertyRecord23 = assureNestedReferenceEmbed(address1, "propertyRecord2")
		assertTrue(propertyRecord11.nestedReferenceTreatments.empty)
		assertTrue(propertyRecord13.nestedReferenceTreatments.empty)
		assertTrue(propertyRecord21.nestedReferenceTreatments.empty)
		assertTrue(propertyRecord23.nestedReferenceTreatments.empty)
	}
	
	@Test
	def void testNestedExplicitLink() {
		prepare("",
				'''
					referenceEmbed > controller
						referenceLink > homeAddress
							targetResource AddressObject
				''',
				'''
					objectResource AddressObject type  Address
					objectResource AddressObject2 type  Address
				''')
		assureReferenceEmbed("TaxFilingObject", "taxpayer")
		val controller = assureReferenceEmbed("TaxFilingObject", "controller")
		val address2 = assureNestedReferenceLink(controller, "homeAddress")
		assureNestedReferenceEmbed(controller, "address")
		assureTargetResource(address2, "AddressObject")
		
	}
	
	@Test
	def void testDefaultResource() {
		prepare("", "", "objectResource PersonObject type Person")
		val taxpayer = assureReferenceLink("TaxFilingObject", "taxpayer")
		val controller = assureReferenceLink("TaxFilingObject", "controller")
		assureTargetResource(controller, "PersonObject")
		assureTargetResource(taxpayer, "PersonObject")
	}
	
	def ReferenceTreatment assureNestedReferenceTreatment(ReferenceEmbed embed, String name) {
		val refs = embed.nestedReferenceTreatments.findReferenceTreatmentForPropertyName(name)
		assertThat(refs.size, equalTo(1))
		refs.findFirst[true]
	}
	
	def ReferenceEmbed assureNestedReferenceEmbed(ReferenceEmbed embed, String name) {
		val nested = assureNestedReferenceTreatment(embed, name)
		assertThat(nested, instanceOf(typeof(ReferenceEmbed)))
		return nested as ReferenceEmbed
	}
	
	def ReferenceLink assureNestedReferenceLink(ReferenceEmbed embed, String name) {
		val nested = assureNestedReferenceTreatment(embed, name)
		assertThat(nested, instanceOf(typeof(ReferenceLink)))
		return nested as  ReferenceLink
	}
	
	def ServiceDataResource getDataResource(String resName) {
		val resources = model.resourceAPIs.get(0).ownedResourceDefinitions.filter[resName == name];
		assertThat(resources.size, equalTo(1))
		return resources.findFirst[true] as ServiceDataResource
	}
	
	def ReferenceTreatment getReferenceTreatment(String resName, String prop) {
		val res = getDataResource(resName)
		val refs = res.referenceTreatments.findReferenceTreatmentForPropertyName(prop)
		assertThat(refs.size, equalTo(1))
		refs.findFirst[true]	
	}
	
	def void assureTargetResource(ReferenceLink link, String expected) {
		assertNotNull(link.targetResource)
	    assertEquals(expected, link.targetResource.name)		
	}
	
	def ReferenceLink assureReferenceLink(String resName, String prop) {
		val treatment = getReferenceTreatment(resName, prop)
		assertThat(treatment, instanceOf(typeof(ReferenceLink)))
		return treatment as ReferenceLink
	}
	
	def ReferenceEmbed assureReferenceEmbed(String resName, String prop) {
		val link = getReferenceTreatment(resName, prop)
		assertThat(link, instanceOf(typeof(ReferenceEmbed)))
		return link as ReferenceEmbed
	}
}