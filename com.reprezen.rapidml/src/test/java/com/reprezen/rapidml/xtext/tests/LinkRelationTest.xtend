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
import com.reprezen.rapidml.ResourceAPI
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
class LinkRelationTest {

	@Inject extension ZenModelUtils

	def String textualModel(String linkRelation) {
		'''
			rapidModel LinkRelations
				resourceAPI MyInterfaceName baseURI "http://my-namespace.com"
					objectResource MyNamedResource type myDataType
						URI uri/{id} 
							required templateParam id property id
						referenceLink > selfRef
							targetResource MyNamedResource
							«linkRelation»
						mediaTypes
							application/xml
						method GET getMyNamedResource 
							request
							response MyNamedResource statusCode 200
							response statusCode 404
					linkRelation myLinkRel1
					linkRelation myLinkRel2 specURL "something.com/blabla"
				dataModel myDataModel
					structure myDataType
						id : string
						selfRef : reference myDataType
		'''
	}

	ZenModel model

	@Test
	def void testNewLinkRelDefinition() {
		val interface_ = loadModelAndGetFirstInterface()
		val rels = interface_.definedLinkRelations
		assertThat(rels.size, equalTo(2))
		val firstRel = rels.get(0)
		assertThat(firstRel.name, equalTo("myLinkRel1"))
		assertThat(firstRel.specURL, nullValue)
		val secondRel = rels.get(1)
		assertThat(secondRel.name, equalTo("myLinkRel2"))
		assertThat(secondRel.specURL, equalTo("something.com/blabla"))
	}

	@Test
	def void testUnsetRel() {
		val interface_ = loadModelAndGetFirstInterface()
		val referenceLinks = (interface_.firstResourceDefinition() as ServiceDataResource).referenceLinks
		assertThat(referenceLinks.size, equalTo(1))
		val firstRefLink = referenceLinks.get(0)
		assertThat(firstRefLink.linkRelation, nullValue)
	}

	@Test
	def void testSelfRelUsage() {
		val interface_ = loadModelAndGetFirstInterface("self")
		val referenceLinks = (interface_.firstResourceDefinition() as ServiceDataResource).referenceLinks
		assertThat(referenceLinks.size, equalTo(1))
		val firstRefLink = referenceLinks.get(0)
		assertThat(firstRefLink.linkRelation.name, equalTo("self"))
	}

	@Test
	def void testCustomRelUsage() {
		val interface_ = loadModelAndGetFirstInterface("myLinkRel1")
		val referenceLinks = (interface_.firstResourceDefinition() as ServiceDataResource).referenceLinks
		assertThat(referenceLinks.size, equalTo(1))
		val firstRefLink = referenceLinks.get(0)
		assertThat(firstRefLink.linkRelation.name, equalTo("myLinkRel1"))
	}

	def ResourceAPI loadModelAndGetFirstInterface() {
		doLoadModelAndGetFirstInterface("")
	}

	def ResourceAPI loadModelAndGetFirstInterface(String linkRel) {
		doLoadModelAndGetFirstInterface("linkRelation " + linkRel)
	}

	def ResourceAPI doLoadModelAndGetFirstInterface(String linkRel) {
		model = loadModelAndNormalize(textualModel(linkRel))
		val resourceAPI = model.firstResourceAPI
		assertThat(resourceAPI, notNullValue)
		return resourceAPI
	}

}
