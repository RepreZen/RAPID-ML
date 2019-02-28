/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.xtext.tests.importing

import com.reprezen.rapidml.RapidmlPackage
import com.reprezen.rapidml.ZenModel
import com.reprezen.rapidml.xtext.tests.RapidMLInjectorProvider
import com.reprezen.rapidml.xtext.tests.importing.help.DataModelImport
import javax.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.junit.Test
import org.junit.runner.RunWith

@InjectWith(typeof(RapidMLInjectorProvider))
@RunWith(typeof(XtextRunner))
class AmbigiousImportTest {

	@Inject ParseHelper<ZenModel> parser
	@Inject extension ValidationTestHelper

	val IMP_MODEL = new DataModelImport('ModelForImport.dataModelForImport', 'import/ModelForImport.zen', 'mfi')
	val IMP_MODEL_WS = new DataModelImport('nsForImport.ModelForImportWithNS.dataModelForImportWithNS',
		'import/ModelForImportWithNS.zen', 'mfins')

	def String modelImportingTypeA() {
		'''
			«IMP_MODEL.importString»
			«IMP_MODEL_WS.importString»
			rapidModel modelWithTypeA
				resourceAPI dataInterface baseURI "http://my-namespace.com"
					objectResource dataObject type typeA
		'''
	}

	def String modelImportingEnumE() {
		'''
			«IMP_MODEL.importString»
			«IMP_MODEL_WS.importString»
			rapidModel modelWithTypeA
				resourceAPI dataInterface baseURI "http://my-namespace.com"
					objectResource dataObject type TypeB
				dataModel dm
					structure TypeB
						modelWithTypeA : enumE
		'''
	}

	@Test
	def void structureAmbigiousImportTest() {
		val model = parser.parse(modelImportingTypeA());
		model.assertError(RapidmlPackage::eINSTANCE.objectResource, 
			"org.eclipse.xtext.diagnostics.Diagnostic.Linking", 
			"Couldn't resolve reference to Structure 'typeA'")
	}

	@Test
	def void enumAmbigiousImportTest() {
		val model = parser.parse(modelImportingEnumE())
		model.assertError(RapidmlPackage::eINSTANCE.primitiveProperty, 
			"org.eclipse.xtext.diagnostics.Diagnostic.Linking", 
			"Couldn't resolve reference to SingleValueType 'enumE'")
	}
}
