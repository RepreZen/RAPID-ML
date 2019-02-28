/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.xtext.tests

import com.reprezen.rapidml.ObjectResource
import com.reprezen.rapidml.ReferenceLink
import com.reprezen.rapidml.ZenModel
import com.reprezen.rapidml.xtext.tests.RapidMLInjectorProvider
import javax.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith

import static org.hamcrest.CoreMatchers.*
import static org.junit.Assert.*

/**
 * Test for ZEN-1833 JsonSchema/Swagger GenTemplates: implicit referenceLinks are not realized as hyperlinks
 */
@InjectWith(typeof(RapidMLInjectorProvider))
@RunWith(typeof(XtextRunner))
class ImplicitReferenceLinkForZen1833Test {

	def String textualModel() {
		'''rapidModel WithDeepReferences
	resourceAPI GeometryAPI baseURI "http://my-namespace.com"
		objectResource TriangleObject type Triangle
			URI /triangle/{id}
			method GET getTriangle
				request
				response TriangleObject statusCode 200
		// A Rhomh has two references to Triangel - upperTriangle and bottomTriangle
		objectResource RhombObject type Rhomb
			URI /rhomb/{id}
			method GET getRhomb
				request
				response RhombObject statusCode 200
		objectResource SegmentObject type Segment
			URI /segment/{id}
			method GET getSegment
				request
				response SegmentObject statusCode 200
		objectResource PathObject type Path
			URI /path/{id}
			method GET getPath
				request
				response PathObject statusCode 200
	
	dataModel GeometryDataModel
		// basic nesting
		structure Triangle
			id : string
			pointA: reference to Point
			pointB: reference to Point  
			pointC: reference to Point

		// same-named features (pointA/pointB) in different classes
		structure Segment
			id : string
			pointA: reference to Point
			pointB: reference to Point
		
		// deep nesting + cardinality 'many'
		structure Path 
			id : string
			segments : reference to Segment*
			
		// deep nesting + cardinality 'one'
		structure Rhomb 
			id : string 
			upperTriangle : reference to Triangle
			bottomTriangle : reference to Triangle  

		structure Point
			x: int
			y: int'''
	}

	@Inject extension ZenModelUtils
	private ZenModel model

	@Test
	def void testIncludedReferenceLink() {
		var model = loadModel()
		val ObjectResource rhombResource = model.firstResourceAPI.ownedResourceDefinitions.findFirst[name == "RhombObject"] as ObjectResource
		assertThat(rhombResource, notNullValue)
		val ObjectResource triangleResource = model.firstResourceAPI.ownedResourceDefinitions.findFirst[name == "TriangleObject"] as ObjectResource
		assertThat(triangleResource, notNullValue)
		
		val upperTriangle = rhombResource.referenceTreatments.findFirst[referenceElement.name == "upperTriangle"]
		assertThat(upperTriangle, notNullValue)
		assertThat(upperTriangle, instanceOf(typeof(ReferenceLink)))
		assertThat((upperTriangle as ReferenceLink).targetResource, equalTo(triangleResource))
		
		val bottomTriangle = rhombResource.referenceTreatments.findFirst[referenceElement.name == "bottomTriangle"]
		assertThat(bottomTriangle, notNullValue)
		assertThat(bottomTriangle, instanceOf(typeof(ReferenceLink)))
		assertThat((bottomTriangle as ReferenceLink).targetResource, equalTo(triangleResource))
	}

	def ZenModel loadModel() {
		model = loadModelAndNormalize(textualModel())
		return model
	}

}
