package com.reprezen.rapidml.xtext.tests

import com.google.common.io.Resources
import com.reprezen.rapidml.ZenModel
import java.nio.charset.Charset
import javax.inject.Inject
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import com.reprezen.rapidml.xtext.serializers.RepreZenTextSerializer

@RunWith(XtextRunner)
@InjectWith(RapidMLInjectorProvider)
class SerializerTest {
	
	@Inject
	ParseHelper<ZenModel> parseHelper;

	@Inject
	RepreZenTextSerializer serializer

	@Test
	def void testSerialize() {
		val resource = Resources.toString(Resources.getResource("TaxBlaster.rapid"), Charset.forName("UTF-8"))
		val model = parseHelper.parse(resource)
		val result = serializer.serializeToDslString(model)
		
		println(result)
		Assert.assertEquals(resource, result)
	}
}