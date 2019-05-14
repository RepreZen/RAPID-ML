package com.reprezen.rapidml.xtext.tests.validation

import com.reprezen.rapidml.ZenModel
import com.reprezen.rapidml.xtext.tests.RapidMLInjectorProvider
import com.reprezen.rapidml.xtext.tests.util.ValidatorHelper
import javax.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.junit.Test
import org.junit.runner.RunWith

@InjectWith(typeof(RapidMLInjectorProvider))
@RunWith(typeof(XtextRunner))
class KeywordsAsPropertyTest {

	@Inject ParseHelper<ZenModel> parser
	@Inject extension ValidatorHelper

	@Test
	def void test_NoError() {
		val modelText = '''
rapidModel TaxBlasterModel
	resourceAPI TaxBlasterAPI baseURI "http://my-namespace.com"
		//object resource with GET and PUT methods
		objectResource PersonObject type Person
			URI /uri/{id}
			referenceEmbed > currentTaxfilings
				targetProperties
					title, year, period, taxDue, currency, taxpayer
					year
					title
			referenceEmbed > pastTaxfilings
				targetProperties
					title
					year
					period
			referenceLink > pendingTaxfilings
				targetResource TaxFilingObject
				targetProperties
					title, year, period, taxDue, currency, taxpayer
					title, year, period, taxDue, currency
					title
			referenceLink > amendedTaxfilings
				targetResource TaxFilingObject
				targetProperties					
					title, year, period, taxDue, currency, taxpayer
					title, year, period, taxDue, currency
					title
					year
					period
			referenceEmbed > title
				targetProperties
					^property
			mediaTypes
				application/json
			method GET getPerson
				request
				response PersonObject statusCode 200
			method PUT putPerson
				request PersonObject
				response statusCode 200
				response statusCode 400
		
		//collection resource with GET and POST methods
		collectionResource PersonCollection type Person
			URI /uri
			referenceLink > title
				targetResource PropertyTitleObject
			mediaTypes
				application/json
			method GET getPeople
				request
				response PersonCollection statusCode 200
			method POST postPerson
				request with type Person
				response statusCode 200
				response statusCode 400
				
		objectResource TaxFilingObject type TaxFiling
			URI /tax_filings/{id}
				required templateParam id property title
				
			with all properties 
			including				
				year
				period
				taxDue
				currency
				taxpayer
			excluding
				title
			linkDescriptor TaxFilingLink
				title
				year
				period
			method GET getTaxFilingObject
				request with type TaxFiling
					with all properties excluding
						title
					param titleParam property title in query
					
				response with  statusCode 200
		objectResource PropertyTitleObject type PropertyTitle
			URI /uri/{id}
				required templateParam id property ^property
			mediaTypes
				application/json
			method GET getPropertyTitleObject
				request
				response PropertyTitleObject statusCode 200
		

	dataModel TaxBlasterDataModel
		structure Person
			personID : string
			firstName: string
			lastName: string
			title: reference to PropertyTitle inverse owner
			currentTaxfilings: reference to TaxFiling*
			pastTaxfilings: reference to TaxFiling*
			pendingTaxfilings: reference to TaxFiling*
			amendedTaxfilings: reference to TaxFiling*
			
		structure TaxFiling
			title: string
			year: integer
			period: string
			taxDue: decimal
			currency: string
			taxpayer: as reference to Person
			
		structure PropertyTitle
			^property : string
			owner : reference to Person inverse title
		'''
		val model = parser.parse(modelText)
		validate(model).assertOK
	}
}
