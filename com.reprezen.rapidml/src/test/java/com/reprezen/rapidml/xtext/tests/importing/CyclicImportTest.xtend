package com.reprezen.rapidml.xtext.tests.importing

import com.reprezen.rapidml.Structure
import com.reprezen.rapidml.ZenModel
import com.reprezen.rapidml.xtext.loaders.ZenModelLoader
import com.reprezen.rapidml.xtext.tests.RapidMLInjectorProvider
import javax.inject.Inject
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*
import com.google.common.io.Resources

@InjectWith(RapidMLInjectorProvider)
@RunWith(XtextRunner)
class CyclicImportTest {

	val uri = URI.createFileURI(Resources.getResource(CyclicImportTest, "/dsl/cycles/Person.rapid").file)

	@Inject ResourceSet resourceSet
	@Inject ZenModelLoader loader

	@Test
	def void testLoadingResourceSet() {
		val resource = resourceSet.getResource(uri, true)

		assertNotNull(resource)

		val model = resource.contents.get(0) as ZenModel
		assertNotNull(model)
		assertEquals(1, model.imports.size)

		val dataModel = model.dataModels.get(0)
		val person = dataModel.ownedDataTypes.get(0) as Structure

		val ref = person.referenceProperties.get(0)
		assertEquals("personDocuments", ref.name)
		assertNotNull(ref.inverse)
		assertEquals("person", ref.inverse.name)
	}

	@Test
	def void testLoadingZenModelLoader() {		
		val model = loader.loadAndValidateModel(uri)
		assertNotNull(model)
		assertEquals(1, model.imports.size)

		val dataModel = model.dataModels.get(0)
		val person = dataModel.ownedDataTypes.get(0) as Structure

		val ref2 = person.referenceProperties.get(0)
		assertEquals("personDocuments", ref2.name)
		assertNotNull(ref2.inverse)
		assertEquals("person", ref2.inverse.name)
	}
}
