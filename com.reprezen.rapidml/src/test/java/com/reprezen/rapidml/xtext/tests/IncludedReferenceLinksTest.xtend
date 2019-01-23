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
import com.reprezen.rapidml.ReferenceTreatment
import com.reprezen.rapidml.ZenModel
import com.reprezen.rapidml.xtext.tests.RapidMLInjectorProvider
import java.util.List
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith

import static org.hamcrest.CoreMatchers.*
import static org.junit.Assert.*

@InjectWith(typeof(RapidMLInjectorProvider))
@RunWith(typeof(XtextRunner))
class IncludedReferenceLinksTest {

	@Inject extension ZenModelUtils

	def String textualModel(String includedProperties, String referenceLink) {
		'''
			rapidModel IncludedReferenceLinks
				resourceAPI Customer baseURI "http://modelsolv.com"
					objectResource CustomerResource type Customer
						«IF !includedProperties.empty»
						only properties
							«includedProperties»
						«ENDIF»
						referenceLink > «referenceLink»
							targetResource CustomerResource
				dataModel Customer
					structure Customer
						optionalListProperty : string *
						myReferenceProperty1 : reference Customer ?
						myReferenceProperty2 : reference Customer ?
						myReferenceProperty3 : reference Customer ?
		'''
	}

	ZenModel model

	@Test
	def void testNoIncluded() {
		val referenceLinks = loadModelAndGetReferenceLinks("", "myReferenceProperty1")
		assertThat(referenceLinks.size, equalTo(3))
		val first = referenceLinks.get(0)
		assertThat((first.referenceElement).name, equalTo("myReferenceProperty1"))
		val second = referenceLinks.get(1)
		assertThat((second.referenceElement).name, equalTo("myReferenceProperty2"))
		val third = referenceLinks.get(2)
		assertThat((third.referenceElement).name, equalTo("myReferenceProperty3"))
	}

	@Test
	def void testReference1Included() {
		val referenceLinks = loadModelAndGetReferenceLinks("myReferenceProperty1", "myReferenceProperty1")
		assertThat(referenceLinks.size, equalTo(1))
		val first = referenceLinks.get(0)
		assertThat((first.referenceElement).name, equalTo("myReferenceProperty1"))
	}

	@Test
	def void testReference2Included() {
		val referenceLinks = loadModelAndGetReferenceLinks("myReferenceProperty2", "myReferenceProperty1")
//		assertThat(referenceLinks.size, equalTo(2))
		val first = referenceLinks.get(0)
		assertThat((first.referenceElement).name, equalTo("myReferenceProperty1"))
		val second = referenceLinks.get(1)
		assertThat((second.referenceElement).name, equalTo("myReferenceProperty2"))
	}

	def List<ReferenceTreatment> loadModelAndGetReferenceLinks(String includedProperties, String referenceLink) {
		model = loadModelAndNormalize(textualModel(includedProperties, referenceLink))
		return model.referenceTreatments
	}

}
