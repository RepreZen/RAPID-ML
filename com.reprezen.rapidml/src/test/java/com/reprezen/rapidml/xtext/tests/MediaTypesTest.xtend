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
import com.reprezen.rapidml.HTTPMethods
import com.reprezen.rapidml.MediaType
import com.reprezen.rapidml.ZenModel
import com.reprezen.rapidml.implicit.ZenModelNormalizer
import com.reprezen.rapidml.xtext.tests.RapidMLInjectorProvider
import java.util.Arrays
import java.util.Collections
import java.util.LinkedList
import java.util.List
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.hamcrest.core.Is
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@InjectWith(typeof(RapidMLInjectorProvider))
@RunWith(typeof(XtextRunner))
class MediaTypesTest {
	@Inject
	ParseHelper<ZenModel> parser

	def String textualModel() {
		'''
			rapidModel WithMediaTypes
				resourceAPI WithMediaTypesAPI baseURI "http://my-namespace.com"
					objectResource WithMediaTypesObject type WithMediaTypes
						URI /uri/{id}
						mediaTypes
							application/xml
							application/json
						method GET getWithExplicitMediaTypesSet
							request 
								mediaTypes
									text/plain
							response WithMediaTypesObject statusCode 200
								mediaTypes
									application/json
									text/plain
						method PUT putImplicitMediaTypes
							request WithMediaTypesObject
							response WithMediaTypesObject statusCode 211
			
				dataModel WithMediaTypesDataModel
					structure WithMediaTypes
						id : string
		'''
	}

	@Test
	def void testMediaTypesImplicitValues() {
		val model = parser.parse(textualModel())
		Assert.assertNotNull(model)
		val resource = model.resourceAPIs.get(0).ownedResourceDefinitions.get(0)

		val explicitlySetMedia = resource.methods.findFirst[httpMethod == HTTPMethods::GET]
		assertMediaTypes(explicitlySetMedia.request.mediaTypes, "text/plain")
		assertMediaTypes(explicitlySetMedia.responses.findFirst[statusCode == 200].mediaTypes, "application/json",
			"text/plain")

		val implicitMediaTypes = resource.methods.findFirst[httpMethod == HTTPMethods::PUT]

		//both are empty before generating implicit values
		assertMediaTypes(implicitMediaTypes.responses.findFirst[statusCode == 211].mediaTypes, #[])
		assertMediaTypes(implicitMediaTypes.request.mediaTypes, #[])

		new ZenModelNormalizer().normalize(model)

		//now what was empty gets the value from the resource
		assertMediaTypes(implicitMediaTypes.responses.findFirst[statusCode == 211].mediaTypes, "application/xml",
			"application/json")
		assertMediaTypes(implicitMediaTypes.request.mediaTypes, "application/xml", "application/json")

		//but what was not empty is unchanged
		assertMediaTypes(explicitlySetMedia.request.mediaTypes, "text/plain")
		assertMediaTypes(explicitlySetMedia.responses.findFirst[statusCode == 200].mediaTypes, "application/json",
			"text/plain")
	}

	def void assertMediaTypes(Iterable<MediaType> actual, String... expected) {
		val safeActual = actual ?: Collections::<MediaType>emptyList
		val List<String> actualNames = new LinkedList()
		actualNames.addAll(safeActual.map[name])
		Assert.assertThat(actualNames, Is.is(Arrays::<String>asList(expected)))
	}

}
