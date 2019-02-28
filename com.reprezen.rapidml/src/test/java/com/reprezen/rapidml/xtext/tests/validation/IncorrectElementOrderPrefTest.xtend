/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.xtext.tests.validation

import com.google.inject.Inject
import com.reprezen.rapidml.ServiceDataResource
import com.reprezen.rapidml.ZenModel
import com.reprezen.rapidml.xtext.nls.Messages
import com.reprezen.rapidml.xtext.preferences.DefaultRapidMLPreferences
import com.reprezen.rapidml.xtext.tests.RapidMLInjectorProvider
import com.reprezen.rapidml.xtext.tests.ZenModelUtils
import com.reprezen.rapidml.xtext.tests.util.AssertableDiagnostics
import com.reprezen.rapidml.xtext.tests.util.ValidatorTester
import com.reprezen.rapidml.xtext.validation.XtextDslJavaValidator
import org.eclipse.emf.common.util.Diagnostic
import org.eclipse.osgi.util.NLS
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.validation.SeverityConverter
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*

@InjectWith(typeof(RapidMLInjectorProvider))
@RunWith(typeof(XtextRunner))
class IncorrectElementOrderPrefTest { 
	
	@Inject ParseHelper<ZenModel> parser
	@Inject ValidatorTester<XtextDslJavaValidator> tester;
	@Inject DefaultRapidMLPreferences preferenceStoreAccess
	@Inject extension ZenModelUtils
	
	def String textualModel(String resource) {
		'''
			rapidModel TaxBlaster
				resourceAPI TaxBlasterInterface baseURI "http://taxblaster.com/api"
					«resource»
				dataModel TaxBlasterDataModel
					structure TaxFiling
						filingID : integer
						taxpayer : reference Person
						controller : reference Person
					structure Person
		'''
	}
	
	def tripleQuotes() {
		"'''"
	}
	
	def String getIncorrectCollectionResource() {
		'''
			collectionResource TaxFilingCollection type TaxFiling
				URI index
				method GET getIndex
					response TaxFilingCollection statusCode 200
					response statusCode 404
				referenceLink > taxpayer
				only properties
					filingID
					taxpayer
				collectionParam param1 type string
				referenceEmbed > controller
				example «tripleQuotes» «tripleQuotes»
				linkDescriptor desc
				mediaTypes
					application/xml, application/atom+xml
		'''
	}
	
	def String getIncorrectObjectResource() {
		'''
			objectResource TaxFilingObject type TaxFiling
				URI index
				linkDescriptor desc
				method GET getIndex
					response TaxFilingObject statusCode 200
					response statusCode 404
				referenceLink > taxpayer
				only properties
					filingID
					taxpayer
				referenceEmbed > controller
				example «tripleQuotes» «tripleQuotes»
				mediaTypes
					application/xml
		'''
	}
	
	def ServiceDataResource loadModelAndGetResource(String resourceName, String resource) {
		val model = parser.parse(textualModel(resource))
		val dataResource = model.firstResourceAPI.firstResourceDefinition as ServiceDataResource
		assertEquals(resourceName, dataResource.name)
		dataResource
	}
	
	def String getPrefKey(ServiceDataResource resource) {
		NLS.bind(Messages.RepreZenValidatorConfigurationBlock_random_order_issue_key_all, 
			resource.eClass.name)
	}
	
	def String[] allKeywords() {
		#["collectionParam", "only", "referenceEmbed", "referenceLink", "linkDescriptor",
			"mediaTypes", "method", "example"]
	}
	
	def String getPrefKey(ServiceDataResource resource, String keyword) {
		NLS.bind(Messages.RepreZenValidatorConfigurationBlock_random_order_issue_key, 
			resource.eClass.name, keyword)
	}
	
	/**
	 * sets IGNORE setting to all listed keywords (the rest keywords have WARNING setting)
	 */
	def void setIgnoreProps(ServiceDataResource resource, String... keywords) {
		preferenceStoreAccess.setValue(getPrefKey(resource), SeverityConverter.SEVERITY_WARNING)
		for (String str : allKeywords) {
			if (keywords.contains(str)) {
				preferenceStoreAccess.setValue(getPrefKey(resource, str), SeverityConverter.SEVERITY_IGNORE)
			} else {
				preferenceStoreAccess.setValue(getPrefKey(resource, str), SeverityConverter.SEVERITY_WARNING)
			}
		}
	}
	
	def void assertMore(int expected, int actual, String keyword) {
		assertTrue("on " + keyword + " expected more than " + expected + ", but was " + actual, expected <= actual)
	}
	
	@Test
	def void testCollectionResourceAll() {
		val resource = loadModelAndGetResource("TaxFilingCollection", incorrectCollectionResource)
		preferenceStoreAccess.setValue(getPrefKey(resource), SeverityConverter.SEVERITY_IGNORE)
		tester.validate(resource).assertOK
		setIgnoreProps(resource)
	}
	
	@Test
	def void testObjectResourceAll() {
		val resource = loadModelAndGetResource("TaxFilingObject", incorrectObjectResource)
		preferenceStoreAccess.setValue(getPrefKey(resource), SeverityConverter.SEVERITY_IGNORE)
		tester.validate(resource).assertOK
		setIgnoreProps(resource)
	}
	
	@Test
	def void testCollectionResourceParticular() {
		val resource = loadModelAndGetResource("TaxFilingCollection", incorrectCollectionResource)
		for (String k : allKeywords) {
			setIgnoreProps(resource, k)		
			val diagnostics = tester.validate(resource)
			assertMore(7, diagnostics.allDiagnostics.size, k)
			val pred = AssertableDiagnostics.warningMsg(k)
			for (Diagnostic d : diagnostics.allDiagnostics) {
					assertFalse("on " + k, pred.apply(d))				
			}
		}
		setIgnoreProps(resource)
	}
	
	@Test
	def void testObjecResourceParticular() {
		val resource = loadModelAndGetResource("TaxFilingObject", incorrectObjectResource)
		for (String k : allKeywords) {
			if (!"collectionParam".equals(k)){
				setIgnoreProps(resource, k)		
				val diagnostics = tester.validate(resource)
				assertMore(6, diagnostics.allDiagnostics.size, k)
				val pred = AssertableDiagnostics.warningMsg(k)
				for (Diagnostic d : diagnostics.allDiagnostics) {
					assertFalse("on " + k, pred.apply(d))
				}
			}
		}
		setIgnoreProps(resource)
	}
	
}