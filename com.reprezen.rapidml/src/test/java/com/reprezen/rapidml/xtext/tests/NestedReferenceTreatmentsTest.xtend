/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.xtext.tests

import com.reprezen.rapidml.NamedLinkDescriptor
import com.reprezen.rapidml.ReferenceEmbed
import com.reprezen.rapidml.ReferenceLink
import com.reprezen.rapidml.ReferenceTreatment
import com.reprezen.rapidml.ServiceDataResource
import com.reprezen.rapidml.ZenModel
import com.reprezen.rapidml.xtext.tests.RapidMLInjectorProvider
import javax.inject.Inject
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith

import static org.hamcrest.CoreMatchers.*
import static org.junit.Assert.*

@InjectWith(typeof(RapidMLInjectorProvider))
@RunWith(typeof(XtextRunner))
class NestedReferenceTreatmentsTest {
	
	@Inject extension ZenModelUtils
	private ZenModel model
	
	def String getTextualModel(String attribute, String explicitReferenceTreatment, String resources) {
		'''
			rapidModel Test
				resourceAPI Test baseURI "http://modelsolv.com"
					objectResource TaxFilingObject type TaxFiling
						«explicitReferenceTreatment»
					«resources»
					objectResource PersonObject type Person
					objectResource PropertyRecordObject type PropertyRecord
				dataModel Test
					structure TaxFiling
						taxpayer : «attribute» reference Person
					structure Person
						personID : integer
						address : «attribute» reference Address
					structure Address
						addressId : integer
						propertyRecord : «attribute» reference PropertyRecord
					structure PropertyRecord
		'''
	}
	
	def void prepare(String attribute, String explicitReferenceTreatment, String resources) {
		val modelText = getTextualModel(attribute, explicitReferenceTreatment, resources)
		model = loadModelAndNormalize(modelText)
	}
	
	/**
 	 * ZEN-822 test for nested referencies
 	 * @see <a href="https://modelsolv.atlassian.net/browse/ZEN-822?focusedCommentId=16116&page=com.atlassian.jira.plugin.system.issuetabpanels:comment-tabpanel#comment-16116">expected behavior</a>
 	 */
	@Test
	def void testNonContainmentReferencies() {
		assureReferencesWithoutExplicitReferenceTreatments("")
	}
	
	/**
 	 * ZEN-822 test for nested referencies
 	 * @see <a href="https://modelsolv.atlassian.net/browse/ZEN-822?focusedCommentId=16116&page=com.atlassian.jira.plugin.system.issuetabpanels:comment-tabpanel#comment-16116">expected behavior</a>
 	 */
	@Test
	def void testContainmentReferencies() {
		assureReferencesWithoutExplicitReferenceTreatments("containing")	
	}
	
	@Test
	def void testExplicitReferenceEmbedForTaxPayer() {
		prepare("", "referenceEmbed > taxpayer", "")
		assureReferenceEmbed("PersonObject", "address")
		val taxpayer = assureReferenceEmbed("TaxFilingObject", "taxpayer")
		val address = assureNestedreferenceTreatment(taxpayer, "address")		
		assertThat(address, instanceOf(typeof(ReferenceEmbed)))
		val propertyRecord = assureNestedreferenceTreatment(address as ReferenceEmbed, "propertyRecord")
		assertThat(propertyRecord, instanceOf(typeof(ReferenceLink)))
		assureTargetResource(propertyRecord as ReferenceLink, "PropertyRecordObject")
	}
	
	@Test
	def void testExcludedReferencesForTaxPayer() {
		prepare("",
				'''
					referenceEmbed > taxpayer
						targetProperties
							personID
				''',
				"")
		val taxpayer = assureReferenceEmbed("TaxFilingObject", "taxpayer")
		assertTrue(taxpayer.nestedReferenceTreatments.empty)
	}
	
	@Test
	def void testEmptyAnonymousLinkDescriptor() {
		prepare("",
				'''
					referenceEmbed > taxpayer
						targetProperties
				''',
				"")
		assureReferenceEmbed("PersonObject", "address")
		val taxpayer = assureReferenceEmbed("TaxFilingObject", "taxpayer")
		val address = assureNestedreferenceTreatment(taxpayer, "address")		
		assertThat(address, instanceOf(typeof(ReferenceEmbed)))
		val propertyRecord = assureNestedreferenceTreatment(address as ReferenceEmbed, "propertyRecord")
		assertThat(propertyRecord, instanceOf(typeof(ReferenceLink)))
		assureTargetResource(propertyRecord as ReferenceLink, "PropertyRecordObject")
	}
	
	@Test
	def void testReferenceEmbedInAnonymousLinkDescriptor() {
		prepare("",
				'''
					referenceEmbed > taxpayer
						targetProperties
							address
				''',
				"")
		assureReferenceEmbed("PersonObject", "address")
		val taxpayer = assureReferenceEmbed("TaxFilingObject", "taxpayer")
		val address = assureNestedreferenceTreatment(taxpayer, "address")		
		assertThat(address, instanceOf(typeof(ReferenceEmbed)))
		val propertyRecord = assureNestedreferenceTreatment(address as ReferenceEmbed, "propertyRecord")
		assertThat(propertyRecord, instanceOf(typeof(ReferenceLink)))
		assureTargetResource(propertyRecord as ReferenceLink, "PropertyRecordObject")
	}
	
	@Test
	def void testReferenceLinkInAnonymousLinkDescriptor() {
		prepare("",
				'''
					referenceEmbed > taxpayer
						targetProperties
							address
				''',
				"objectResource AddressObject type Address")
		val taxpayer = assureReferenceEmbed("TaxFilingObject", "taxpayer")
		val address = assureNestedreferenceTreatment(taxpayer, "address")
		assertThat(address, instanceOf(typeof(ReferenceLink)))
		assureTargetResource(address as ReferenceLink, "AddressObject")
	}
	
	@Test
	def void testNestedEmptyAnonymousLinkDescriptor() {
		prepare("",
				'''
					referenceEmbed > taxpayer
						referenceEmbed > address
							targetProperties
				''',
				"")
		assureReferenceEmbed("PersonObject", "address")
		val taxpayer = assureReferenceEmbed("TaxFilingObject", "taxpayer")
		val address = assureNestedreferenceTreatment(taxpayer, "address")		
		assertThat(address, instanceOf(typeof(ReferenceEmbed)))
		val propertyRecord = assureNestedreferenceTreatment(address as ReferenceEmbed, "propertyRecord")
		assertThat(propertyRecord, instanceOf(typeof(ReferenceLink)))
		assureTargetResource(propertyRecord as ReferenceLink, "PropertyRecordObject")
	}
	
	@Test
	def void testExplicitReferenceEmbedForTaxPayerAndAddress() {
		prepare("",
				'''
					referenceEmbed > taxpayer
						referenceEmbed > address
				''',
				"")
		assureReferenceEmbed("PersonObject", "address")
		val taxpayer = assureReferenceEmbed("TaxFilingObject", "taxpayer")
		val address = assureNestedreferenceTreatment(taxpayer, "address")		
		assertThat(address, instanceOf(typeof(ReferenceEmbed)))
		val propertyRecord = assureNestedreferenceTreatment(address as ReferenceEmbed, "propertyRecord")
		assertThat(propertyRecord, instanceOf(typeof(ReferenceLink)))
		assureTargetResource(propertyRecord as ReferenceLink, "PropertyRecordObject")
	}
	
	@Test
	def void testExcludedReferenceForAddress() {
		prepare("",
				'''
					referenceEmbed > taxpayer
						referenceEmbed > address
							targetProperties
								addressId
				''',
				"")
		assureReferenceEmbed("PersonObject", "address")
		val taxpayer = assureReferenceEmbed("TaxFilingObject", "taxpayer")
		val address = assureNestedreferenceTreatment(taxpayer, "address")		
		assertThat(address, instanceOf(typeof(ReferenceEmbed)))
		assertTrue((address as ReferenceEmbed).nestedReferenceTreatments.empty)
	}	
		
	@Test
	def void testExplicitReferenceLink() {
		prepare("",
				'''
					referenceLink > taxpayer
						targetResource PersonObject2
				''',
				"objectResource PersonObject2 type Person")
		val taxpayer = assureReferenceLink("TaxFilingObject", "taxpayer")
		assureTargetResource(taxpayer, "PersonObject2")
	}
	
	@Test
	def void testNestedExplicitReferenceLink() {
		prepare("",
				'''
					referenceEmbed > taxpayer
						referenceLink > address
							targetResource AddressObject
							linkDescriptor AddressObject.AddressId
				''',
				'''
					objectResource AddressObject type Address
						default linkDescriptor AddressId
					
					objectResource AddressObject2 type Address
				''')
		val taxpayer = assureReferenceEmbed("TaxFilingObject", "taxpayer")
		val address = assureNestedreferenceTreatment(taxpayer, "address")
		assertThat(address, instanceOf(typeof(ReferenceLink)))
		assertNotNull(address.linkDescriptor)
		assertThat(address.linkDescriptor, instanceOf(typeof(NamedLinkDescriptor)))
		assertEquals((address.linkDescriptor as NamedLinkDescriptor).name, "AddressId")
	}
	
	def void assureReferencesWithoutExplicitReferenceTreatments(String attribute) {
		prepare(attribute, "", "")
		assureTargetResource(assureReferenceLink("TaxFilingObject", "taxpayer"), "PersonObject")
		val address = assureReferenceEmbed("PersonObject", "address")
		val propertyRecord = assureNestedreferenceTreatment(address, "propertyRecord")
		assertThat(propertyRecord, instanceOf(typeof(ReferenceLink)))
		assureTargetResource(propertyRecord as ReferenceLink, "PropertyRecordObject")
	}

	def ReferenceTreatment assureNestedreferenceTreatment(ReferenceEmbed embed, String name) {
		assertThat(embed.nestedReferenceTreatments.size, equalTo(1))
		val nested = embed.nestedReferenceTreatments.findFirst[true]
		assertEquals(nested.referenceElement.name, name)
		return nested
	}
	
	def ServiceDataResource getDataResource(String resName) {
		val resources = model.resourceAPIs.get(0).ownedResourceDefinitions.filter[resName == name];
		assertThat(resources.size, equalTo(1))
		return resources.findFirst[true] as ServiceDataResource
	}
	
	def ReferenceTreatment getReferenceTreatment(String resName, String prop) {
		val res = getDataResource(resName)
		assertThat(res.referenceTreatments.size, equalTo(1))
		val link = res.referenceTreatments.findFirst[true]
		assertEquals(prop, link.referenceElement.name)
		return link		
	}
	def ReferenceLink assureReferenceLink(String resName, String prop) {
		val treatment = getReferenceTreatment(resName, prop)
		assertThat(treatment, instanceOf(typeof(ReferenceLink)))
		return treatment as ReferenceLink
	}
	
	def void assureTargetResource(ReferenceLink link, String expected) {
		assertNotNull(link.targetResource)
	    assertEquals(expected, link.targetResource.name)		
	}
	
	def ReferenceEmbed assureReferenceEmbed(String resName, String prop) {
		val link = getReferenceTreatment(resName, prop)
		assertThat(link, instanceOf(typeof(ReferenceEmbed)))
		return link as ReferenceEmbed
	}
	
}