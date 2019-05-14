package com.reprezen.rapidml.xtext.tests

import com.google.common.io.Resources
import com.google.inject.Inject
import java.nio.charset.Charset
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ResourceHelper
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*
import com.reprezen.rapidml.ZenModel
import com.reprezen.rapidml.realization.parser.RealizationModelParser

@RunWith(XtextRunner)
@InjectWith(RapidMLInjectorProvider)
class RealizationParseTest {

	@Inject
	ResourceHelper resourceHelper;

	@Test 
	def void loadModel() {
		val url = Resources.getResource("realizations/InclusivePropertySet_Simple.rapid")
		val resource = resourceHelper.resource(Resources.toString(url, Charset.forName("UTF-8")), 
			URI.createURI(url.toExternalForm)
		) 
		resource.load(null)

		val result = resource.getContents().get(0) as ZenModel

		assertNotNull(result)
		assertEquals(1, result.resourceAPIs.get(0).autoRealizations.size)
		assertNotNull(result.resourceAPIs.get(0).autoRealizations.get(0).realizationModel)
		assertNotNull(result.resourceAPIs.get(0).autoRealizations.get(0).realizationModel.getRealizationRule("AllObjectRefsAsInlineObjects"))
	}

	@Test
	def void testRealizationParser() {
		val base = Resources.getResource("realizations/InclusivePropertySet_Simple.rapid")		
		val spec = Resources.toString(Resources.getResource("realizations/InclusivePropertySet_Simple.yaml"), Charset.forName("UTF-8")) 

		val result = new RealizationModelParser().parse(spec, base)
		assertNotNull(result)	
		assertNotNull(result.getRealizationRule("AllObjectRefsAsInlineObjects"))
	}
}