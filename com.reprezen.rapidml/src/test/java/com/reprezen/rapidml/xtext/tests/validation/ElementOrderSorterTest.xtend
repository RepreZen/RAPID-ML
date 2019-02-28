/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 * 
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.xtext.tests.validation

import com.reprezen.rapidml.RapidmlPackage
import com.reprezen.rapidml.xtext.tests.RapidMLInjectorProvider
import com.reprezen.rapidml.xtext.validation.ElementOrderSorter
import java.util.Map
import javax.inject.Inject
import org.eclipse.xtext.Keyword
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*

@InjectWith(typeof(RapidMLInjectorProvider))
@RunWith(typeof(XtextRunner))
class ElementOrderSorterTest {

	@Inject extension ElementOrderSorter sorter;

	var samePriority = <Keyword, Integer>newHashMap()

	@Before
	def void setUpMap() {
		samePriority.put(grammarAccess.referenceEmbedAccess.referenceEmbedKeyword_2, 1)
		samePriority.put(grammarAccess.referenceLinkAccess.referenceLinkKeyword_2, 1)
		samePriority.put(grammarAccess.inlineExampleAccess.exampleKeyword_2, 2)
		samePriority.put(grammarAccess.externalExampleAccess.externalExampleKeyword_2, 2)
	}

	def Keyword[] objectResourceKeywords() {
		#[grammarAccess.includedPropertiesAccess.propertiesKeyword_2_0_2,
			grammarAccess.referenceEmbedAccess.referenceEmbedKeyword_2,
			grammarAccess.referenceLinkAccess.referenceLinkKeyword_2,
			grammarAccess.namedLinkDescriptorAccess.linkDescriptorKeyword_3,
			grammarAccess.objectResourceAccess.mediaTypesKeyword_7_3_3_1, grammarAccess.methodAccess.methodKeyword_3,
			grammarAccess.inlineExampleAccess.exampleKeyword_2,
			grammarAccess.externalExampleAccess.externalExampleKeyword_2]
		}

		@Test
		def void testObjectResource() {
			assertTrue(sorter.hasPriorityTree(RapidmlPackage.Literals.OBJECT_RESOURCE))
			val expected = objectResourceKeywords
			val actual = sorter.getChildren(RapidmlPackage.Literals.OBJECT_RESOURCE)
			assertListEquals(expected, actual);
		}

		@Test
		def void testObjectResourceOrder() {
			assertTrue(sorter.hasPriorityTree(RapidmlPackage.Literals.OBJECT_RESOURCE))
			val tested = objectResourceKeywords
			assertListOrder(tested, sorter.getPriorityTree(RapidmlPackage.Literals.OBJECT_RESOURCE))
		}

		def Keyword[] collectionResourceKeywords() {
			#[grammarAccess.collectionParameterAccess.collectionParamKeyword_4,
				grammarAccess.includedPropertiesAccess.propertiesKeyword_2_0_2,
				grammarAccess.referenceEmbedAccess.referenceEmbedKeyword_2,
				grammarAccess.referenceLinkAccess.referenceLinkKeyword_2,
				grammarAccess.namedLinkDescriptorAccess.linkDescriptorKeyword_3,
				grammarAccess.collectionResourceAccess.mediaTypesKeyword_7_3_4_1,
				grammarAccess.methodAccess.methodKeyword_3, grammarAccess.inlineExampleAccess.exampleKeyword_2,
				grammarAccess.externalExampleAccess.externalExampleKeyword_2]
		}

		@Test
		def void testCollectionResource() {
			assertTrue(sorter.hasPriorityTree(RapidmlPackage.Literals.COLLECTION_RESOURCE))
			val expected = collectionResourceKeywords
			val actual = sorter.getChildren(RapidmlPackage.Literals.COLLECTION_RESOURCE)
			assertListEquals(expected, actual)
		}

		@Test
		def void testCollectionResourceOrder() {
			assertTrue(sorter.hasPriorityTree(RapidmlPackage.Literals.COLLECTION_RESOURCE))
			val tested = collectionResourceKeywords
			assertListOrder(tested, sorter.getPriorityTree(RapidmlPackage.Literals.COLLECTION_RESOURCE))
		}

		def assertListEquals(Keyword[] expected, Keyword[] actual) {
			assertEquals(expected.size, actual.size);
			for (i : 0 ..< expected.size) {
				if (!samePriority.containsKey(expected.get(i)) || !samePriority.containsKey(actual.get(i)) ||
					!samePriority.get(expected.get(i)).equals(samePriority.get(actual.get(i)))) {
					assertEquals(expected.get(i), actual.get(i));
				}
			}
		}

		def assertListOrder(Keyword[] tested, Map<Keyword, Integer> priorityTree) {
			for (i : 0 ..< tested.size - 1) {
				if (samePriority.containsKey(tested.get(i)) && samePriority.containsKey(tested.get(i + 1)) &&
					samePriority.get(tested.get(i)).equals(samePriority.get(tested.get(i + 1)))) {
					assertEquals(priorityTree.get(tested.get(i)), priorityTree.get(tested.get(i + 1)));
				} else {
					assertTrue(priorityTree.get(tested.get(i)) < priorityTree.get(tested.get(i + 1)))
				}
			}
		}

	}
	