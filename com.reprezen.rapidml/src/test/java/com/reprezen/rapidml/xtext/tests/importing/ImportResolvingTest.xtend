/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.xtext.tests.importing

import com.google.common.io.Resources
import com.google.inject.Inject
import com.reprezen.rapidml.Enumeration
import com.reprezen.rapidml.ObjectResource
import com.reprezen.rapidml.PrimitiveProperty
import com.reprezen.rapidml.ZenModel
import com.reprezen.rapidml.implicit.ZenModelNormalizer
import com.reprezen.rapidml.xtext.loaders.ZenModelLoader
import com.reprezen.rapidml.xtext.tests.RapidMLInjectorProvider
import com.reprezen.rapidml.xtext.tests.ZenModelUtils
import com.reprezen.rapidml.xtext.tests.importing.help.AliasedDataModelImport
import com.reprezen.rapidml.xtext.tests.importing.help.DataModelImport
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

import static org.hamcrest.CoreMatchers.*
import static org.junit.Assert.*

@InjectWith(typeof(RapidMLInjectorProvider))
@RunWith(typeof(XtextRunner))
class ImportResolvingTest {
	
	@Inject extension ZenModelUtils	
	@Inject ZenModelLoader loader
	
	val static TYPE_A = 'typeA'
	val static TYPE_A_LOCAL_FQN = 'modelWithTypeA.dm.typeA'
	val static ENUM_E = 'enumE'
	val static ENUM_E_LOCAL_FQN = 'modelWithTypeA.dm.enumE'
	
	def static type_a_fqn(DataModelImport dmi) {
		dmi.fqn(TYPE_A);
	}
	
	def static enum_e_fqn(DataModelImport dmi) {
		dmi.fqn(ENUM_E);
	}
	
	def static type_a_alias(AliasedDataModelImport dmi) {
		dmi.alias(TYPE_A);
	}
	
	def static enum_e_alias(AliasedDataModelImport dmi) {
		dmi.alias(ENUM_E);
	}
	
	val IMP_MODEL = new DataModelImport('ModelForImport.dataModelForImport', 'import/ModelForImport.rapid', 'mfi')
	val IMP_MODEL_WS = new DataModelImport('nsForImport.ModelForImportWithNS.dataModelForImportWithNS', 'import/ModelForImportWithNS.rapid', 'mfins')
	val IMP_MODEL_A = new AliasedDataModelImport('ModelForImport.dataModelForImport', 'import/ModelForImport.rapid', 'mfi', "al1")
	val IMP_MODEL_WS_A = new AliasedDataModelImport('nsForImport.ModelForImportWithNS.dataModelForImportWithNS', 'import/ModelForImportWithNS.rapid', 'mfins', "al2")
	
	val NOISE_IMP_MODEL = new DataModelImport('ModelForImportNoise.dataModelForImport', 'import/ModelForImportNoise.rapid', 'noise_mfia')
	val NOISE_IMP_MODEL_WS = new DataModelImport('nsForImport.ModelForImportWithNSNoise.dataModelForImportWithNS', 'import/ModelForImportWithNSNoise.rapid', 'noise_mfinsa')
	
	val ALL_IMPORTS = #[IMP_MODEL, IMP_MODEL_WS, IMP_MODEL_A, IMP_MODEL_WS_A]
	val IMPORTS_WITH_ALIAS = #[IMP_MODEL_A, IMP_MODEL_WS_A]
	
	def String modelWithTypeA(String impString, String type) {
		'''
			«impString»
			«NOISE_IMP_MODEL.importString»
			«NOISE_IMP_MODEL_WS.importString»
			rapidModel modelWithTypeA
				resourceAPI dataInterface baseURI "http://my-namespace.com"
					objectResource dataObject type «type»
				dataModel dm
					structure typeA
						modelWithTypeA : string
		'''
	}
	
	def String modelWithoutTypeA(String impString, String type) {
		'''
			«impString»
			rapidModel modelWithTypeA
				resourceAPI dataInterface baseURI "http://my-namespace.com"
					objectResource dataObject type «type»
		'''
	}
		
	def String modelWithEnumE(String impString, String enumType) {
		'''
			«impString»
			«NOISE_IMP_MODEL.importString»
			«NOISE_IMP_MODEL_WS.importString»
			rapidModel modelWithTypeA
				resourceAPI dataInterface baseURI "http://my-namespace.com"
					objectResource dataObject type typeA
				dataModel dm
					structure typeA
						modelWithTypeA : «enumType»
					enum string enumE
						modelWithEnumE: "modelWithEnumE"
		'''
	}
	
	def String modelWithoutEnumE(String impString, String enumType) {
		'''
			«impString»
			rapidModel modelWithTypeA
				resourceAPI dataInterface baseURI "http://my-namespace.com"
					objectResource dataObject type typeA
				dataModel dm
					structure typeA
						modelWithTypeA : «enumType»
		'''
	}
	
	def getTypeAFieldName(ZenModel rapidModel) {
		rapidModel.resourceAPIs.head
			.ownedResourceDefinitions.filter(ObjectResource).head
				.includedProperties.head.baseProperty.name	
	}
	
	def checkTypeAFromDependentModel(DataModelImport dmi, ZenModel rapidModel) {
		Assert.assertEquals(dmi.toString + ': resolved type not from dependency model', 'modelWithTypeA', getTypeAFieldName(rapidModel))
	} 
	
	def checkTypeAFromImportedModel(DataModelImport dmi, ZenModel rapidModel) {
		Assert.assertEquals(dmi.toString + ': resolved type not from imported model', dmi.label, getTypeAFieldName(rapidModel))
	}
	
	@Test
	def structureSimpleNameResolvedToDependent() {
		ALL_IMPORTS.forEach[DataModelImport dmi | 
			checkTypeAFromDependentModel(dmi, parse(modelWithTypeA(dmi.importString, TYPE_A)))
		]
	}
	
	@Test
	def structureSimpleNameResolvedToImport() {
		ALL_IMPORTS.forEach[DataModelImport dmi | 
			checkTypeAFromImportedModel(dmi, parse(modelWithoutTypeA(dmi.importString, TYPE_A)))
		]
	}
	
	@Test
	def structureFQNResolvedToImported() {
		ALL_IMPORTS.forEach[DataModelImport dmi | 
			checkTypeAFromImportedModel(dmi, parse(modelWithTypeA(dmi.importString, dmi.type_a_fqn)))
		]
	}
	
	@Test
	def structureFQNResolvedToDependent() {
		ALL_IMPORTS.forEach[DataModelImport dmi | 
			checkTypeAFromDependentModel(dmi, parse(modelWithTypeA(dmi.importString, TYPE_A_LOCAL_FQN)))
		]
	}
	
	@Test
	def structureAliasResolvedToImported() {
		IMPORTS_WITH_ALIAS.forEach[AliasedDataModelImport dmi | 
			checkTypeAFromImportedModel(dmi, parse(modelWithTypeA(dmi.importString, dmi.type_a_alias)))
		]
	}
	
	//@Test
	def importedStructureWithInheritedProperties() {
		// we need to load imported models via RepreZenImportUriGlobalScopeProvider
		// HeadlessZenModelLoader does it, and test parser does not
		val model = loader.loadAndValidateModel(
			URI::createFileURI(
				Resources.getResource(class, "/dsl/import/inheritance/EntityClassAPI.rapid").file))
		new ZenModelNormalizer().normalize(model)

		val entityClassObjectResource = model.resourceAPIs.get(0).ownedResourceDefinitions.get(0) as ObjectResource
		val entityClassType = entityClassObjectResource.dataType
		assertThat("Inherited properties are not available", entityClassType.ownedFeatures.map[name], hasItems(#["keyValueCategoryId", "key", "value", "description", "sequence", "system"]))
	}	
	
	def getEnumEKey(ZenModel rapidModel) {
		((rapidModel.resourceAPIs.head.ownedResourceDefinitions.filter(ObjectResource).head
			.includedProperties.head.baseProperty as PrimitiveProperty).type
			 as Enumeration).enumConstants.head.name
	}
	
	def checkEnumEFromDependentModel(DataModelImport dmi, ZenModel rapidModel) {
		Assert.assertEquals(dmi.toString + ': resolved enum not from dependency model', 'modelWithEnumE', getEnumEKey(rapidModel))
	}
	
	def checkEnumEFromImportedModel(DataModelImport dmi, ZenModel rapidModel) {
		Assert.assertEquals(dmi.toString + ': resolved enum not from imported model', dmi.label, getEnumEKey(rapidModel))
	}

	@Test
	def enumSimpleNameResolvedToDependent() {
		ALL_IMPORTS.forEach[DataModelImport dmi | 
			checkEnumEFromDependentModel(dmi, parse(modelWithEnumE(dmi.importString, ENUM_E)))
		]
	}
	
	@Test
	def enumSimpleNameResolvedToImported() {
		ALL_IMPORTS.forEach[DataModelImport dmi | 
			checkEnumEFromImportedModel(dmi, parse(modelWithoutEnumE(dmi.importString, ENUM_E)))
		]
	}
	
	@Test
	def enumFQNResolvedToImported() {
		ALL_IMPORTS.forEach[DataModelImport dmi | 
			checkEnumEFromImportedModel(dmi, parse(modelWithEnumE(dmi.importString, dmi.enum_e_fqn)))
		]
	}
	
	@Test
	def enumFQNResolvedToDependent() {
		ALL_IMPORTS.forEach[DataModelImport dmi | 
			checkEnumEFromDependentModel(dmi, parse(modelWithEnumE(dmi.importString, ENUM_E_LOCAL_FQN)))
		]
	}
	
	@Test
	def enumAliasedResolvedToImported() {
		IMPORTS_WITH_ALIAS.forEach[AliasedDataModelImport dmi | 
			checkEnumEFromImportedModel(dmi, parse(modelWithEnumE(dmi.importString, dmi.enum_e_alias)))
		]
	}

	def parse(String textualModel) {
		var zModel = loadModelAndNormalize(textualModel)
		zModel
	}
}