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
import com.reprezen.rapidml.ReferenceTreatment
import com.reprezen.rapidml.xtext.tests.RapidMLInjectorProvider
import java.util.List
import javax.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith

import static org.hamcrest.CoreMatchers.*
import static org.junit.Assert.*

@InjectWith(typeof(RapidMLInjectorProvider))
@RunWith(typeof(XtextRunner))
class ReferenceToDatatypeWithoutResourceTest {
	
	@Inject extension ZenModelUtils
	
	@Test
	def void testReferenceToDatatypeWithoutResource() {
		var referenceTreatments = loadModelAndGetReferenceTreatments()
		val filtered = referenceTreatments.findReferenceTreatmentForPropertyName("address")
		assertThat(filtered.size, equalTo(1))
		val ref = filtered.findFirst[true]
		assertThat(ref, instanceOf(typeof(ReferenceEmbed)))
	}
	
	def List<ReferenceTreatment> loadModelAndGetReferenceTreatments() {
		val model = loadModelAndNormalize(
			'''
				rapidModel TaxBlaster
					resourceAPI TaxBlasterInterface baseURI "http://taxblaster.com/api/1.0"
						objectResource PersonObject type Person
							URI people/{id}
								required templateParam id property taxpayerID
							mediaTypes
								application/xml
							method GET getPersonObject
								request
								response PersonObject statusCode 200
								response statusCode 404
					dataModel TaxBlasterDataModel
						structure Person
							taxpayerID : string
							lastName : string
							firstName : string
							DOB : date
							address : reference Address
						structure Address
							addressOf : reference Person
							street : string
							city : string
							state : string
							zip : string
			''')
		return model.referenceTreatments
	}	
}