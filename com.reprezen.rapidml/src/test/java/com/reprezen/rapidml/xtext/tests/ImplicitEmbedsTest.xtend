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
import java.util.Collections
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
class ImplicitEmbedsTest {

		def String textualModel(String theOnlyResourceType) {
		'''rapidModel TheModel
	resourceAPI AnAPI baseURI "http://my-namespace.com"
		objectResource TheOnlyResource type «theOnlyResourceType»
	
	dataModel TheDataModel
		structure AA
			refAB : reference to BB
			refAC : reference to CC
			refAD : reference to DD
		structure BB
			refBA : reference to AA
			refBC : reference to CC
			refBD : reference to DD
		structure CC
			refCA : reference to AA
			refCB : reference to BB
			refCD : reference to DD
		structure DD
			refDA : reference to AA
			refDB : reference to BB
			refDC : reference to CC
		structure Root3
			chain32 : reference to Root2
		structure Root2
			chain21 : reference to Root1
		structure Root1
			chain1A : reference to AA
			chain1B : reference to BB
		'''
	}

	@Inject extension ZenModelUtils

	@Test
	def void testBeforeThreshold_AssumingThresholdAtLeast3() {
		val referenceTreatments = loadModelAndGetReferenceTreatments("Root1")

		referenceTreatments.assertNotFound("chain21")
		referenceTreatments.assertFound("chain1A")
		referenceTreatments.assertFound("chain1B")

		referenceTreatments.assertFound("chain1A", "refAB")
		referenceTreatments.assertFound("chain1A", "refAC")
		referenceTreatments.assertFound("chain1A", "refAD")

		referenceTreatments.assertFound("chain1B", "refBC")
		referenceTreatments.assertFound("chain1B", "refBD")
		referenceTreatments.assertFound("chain1B", "refBA")

		referenceTreatments.assertFound("chain1A", "refAB", "refBC")
		referenceTreatments.assertFound("chain1B", "refBC", "refCA")
		referenceTreatments.assertFound("chain1B", "refBC", "refCD")
	}


	def private void assertNotFound(Iterable<ReferenceTreatment> rootList, String ... chain) {
		assertThat(findForPath(rootList, chain).size, equalTo(0))
	}

	def private ReferenceEmbed assertFound(Iterable<ReferenceTreatment> rootList, String ... chain) {
		val found = findForPath(rootList, chain).filter(ReferenceEmbed)
		assertThat(found.size, equalTo(1))
		return found.head
	}

	def private Iterable<ReferenceTreatment> findForPath(Iterable<ReferenceTreatment> rootList, String ... chain) {
		if (chain.empty) {
			throw new IllegalArgumentException
		}
		if (rootList.empty) {
			return Collections::emptyList
		}
		val next = rootList.findReferenceTreatmentForPropertyName(chain.get(0))
		if (chain.size == 1) {
			return next
		}
		val subChain = chain.subList(1, chain.size)
		return next.filter(ReferenceEmbed).map[it.nestedReferenceTreatments.findForPath(subChain)].flatten
	}

	def private List<ReferenceTreatment> loadModelAndGetReferenceTreatments(String resourceType) {
		val model = loadModelAndNormalize(textualModel(resourceType))
		return model.referenceTreatments
	}

}
