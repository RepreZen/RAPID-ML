/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.xtext.tests.validation

import com.reprezen.rapidml.ZenModel
import com.reprezen.rapidml.xtext.tests.RapidMLInjectorProvider
import com.reprezen.rapidml.xtext.validation.XtextDslJavaValidator
import javax.inject.Inject
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.junit4.validation.ValidatorTester
import org.junit.Test
import org.junit.runner.RunWith

@InjectWith(typeof(RapidMLInjectorProvider))
@RunWith(typeof(XtextRunner))
class TypedMessageThisKeywordValidatorTest {

	@Inject ParseHelper<ZenModel> parser
	@Inject ValidatorTester<XtextDslJavaValidator> tester;

	@Test
	def void testValidUsageOnRequestAndResponse() {
		assertOK('''
		rapidModel model
			resourceAPI modelAPI baseURI "http://my-namespace.com"
				objectResource modelObject type model
					URI /uri/{id}
					mediaTypes
						application/json
					method PUT putmodelObject
						request this modelObject
						response this modelObject statusCode 200
						response statusCode 400

			dataModel modelDataModel
				structure model
					id : string
					name: string
		''')
	}

	@Test
	def void testInvalidUsageOnRequest() {
		val diag = validate('''
		rapidModel model
			resourceAPI modelAPI baseURI "http://my-namespace.com"
				collectionResource modelCollection type model
					URI /uri
					mediaTypes
						application/json
					method GET getmodelCollection
						request
						response modelCollection statusCode 200
					method POST postmodelCollection
						request modelCollection
						response statusCode 200
						response statusCode 400

				objectResource modelObject type model
					URI /uri/{id}
					mediaTypes
						application/json
					method PUT putmodelObject
						request this modelCollection
						response this modelObject statusCode 200
						response statusCode 400

			dataModel modelDataModel
				structure model
					id : string
					name: string
		''')

		diag.assertErrorContains("request")
		diag.assertErrorContains("this")
	}

	@Test
	def void testInvalidUsageOnResponse() {
		val diag = validate('''
		rapidModel model
			resourceAPI modelAPI baseURI "http://my-namespace.com"
				collectionResource modelCollection type model
					URI /uri
					mediaTypes
						application/json
					method GET getmodelCollection
						request
						response modelCollection statusCode 200
					method POST postmodelCollection
						request modelCollection
						response statusCode 200
						response statusCode 400

				objectResource modelObject type model
					URI /uri/{id}
					mediaTypes
						application/json
					method PUT putmodelObject
						request this modelObject
						response this modelCollection statusCode 200
						response statusCode 400

			dataModel modelDataModel
				structure model
					id : string
					name: string
		''')

		diag.assertErrorContains("response")
		diag.assertErrorContains("this")
	}

	@Test
	def void testValidUsageOnRequestType() {
		assertOK('''
		rapidModel model
			resourceAPI modelAPI baseURI "http://my-namespace.com"
				collectionResource modelCollection type model
					URI /uri
					mediaTypes
						application/json
					method GET getmodelCollection
						request
						response modelCollection statusCode 200
					method POST postmodelCollection
						request modelCollection
						response statusCode 200
						response statusCode 400

				objectResource modelObject type model
					URI /uri/{id}
					mediaTypes
						application/json
					method PUT putmodelObject
						request type model
						response this modelObject statusCode 200
						response statusCode 400

			dataModel modelDataModel
				structure other
					id: string
				structure model
					id : string
					name: string
		''')
	}
	
	@Test
	def void testInvalidUsageOnRequestType() {
		val diag = validate('''
		rapidModel model
			resourceAPI modelAPI baseURI "http://my-namespace.com"
				collectionResource modelCollection type model
					URI /uri
					mediaTypes
						application/json
					method GET getmodelCollection
						request
						response modelCollection statusCode 200
					method POST postmodelCollection
						request modelCollection
						response statusCode 200
						response statusCode 400

				objectResource modelObject type model
					URI /uri/{id}
					mediaTypes
						application/json
					method PUT putmodelObject
						request this type other
						response this modelObject statusCode 200
						response statusCode 400

			dataModel modelDataModel
				structure other
					id: string
				structure model
					id : string
					name: string
		''')

		diag.assertErrorContains("not supported")
	}

	@Test
	def void testInvalidUsageOnResponseType() {
		val diag = validate('''
		rapidModel model
			resourceAPI modelAPI baseURI "http://my-namespace.com"
				collectionResource modelCollection type model
					URI /uri
					mediaTypes
						application/json
					method GET getmodelCollection
						request
						response modelCollection statusCode 200
					method POST postmodelCollection
						request modelCollection
						response statusCode 200
						response statusCode 400

				objectResource modelObject type model
					URI /uri/{id}
					mediaTypes
						application/json
					method PUT putmodelObject
						request this modelObject
						response this type other statusCode 200
						response statusCode 400

			dataModel modelDataModel
				structure other
					id: string
				structure model
					id : string
					name: string
		''')

		diag.assertErrorContains("not supported")
	}

	@Test
	def void testValidUsageWhenUsingPropertySets() {
		assertOK('''
		rapidModel model
			resourceAPI modelAPI baseURI "http://my-namespace.com"
				collectionResource modelCollection type model
					URI /uri
					mediaTypes
						application/json
					method GET getmodelCollection
						request
						response modelCollection statusCode 200
					method POST postmodelCollection
						request modelCollection
						response statusCode 200
						response statusCode 400

				objectResource modelObject type model
					URI /uri/{id}
					mediaTypes
						application/json
					method PUT putmodelObject
						request type model
							with all properties excluding
								name
						response this modelObject statusCode 200
						response statusCode 400

			dataModel modelDataModel
				structure other
					id: string
				structure model
					id : string
					name: string
		''')
	}

	@Test
	def void testInvalidUsageWhenUsingPropertySets() {
		val diag = validate('''
		rapidModel model
			resourceAPI modelAPI baseURI "http://my-namespace.com"
				collectionResource modelCollection type model
					URI /uri
					mediaTypes
						application/json
					method GET getmodelCollection
						request
						response modelCollection statusCode 200
					method POST postmodelCollection
						request modelCollection
						response statusCode 200
						response statusCode 400

				objectResource modelObject type model
					URI /uri/{id}
					mediaTypes
						application/json
					method PUT putmodelObject
						request this
							with all properties excluding
								name
						response this modelObject statusCode 200
						response statusCode 400

			dataModel modelDataModel
				structure other
					id: string
				structure model
					id : string
					name: string
		''')

		diag.assertErrorContains("not supported")
	}

	def validate(String content) {
		val model = parser.parse(content)
		tester.validate(model)
	}

	def assertOK(String content) {
		validate(content).assertOK()
	}

}