package com.reprezen.rapidml.xtext.tests

import com.google.common.io.Resources
import com.reprezen.rapidml.RegExConstraint
import com.reprezen.rapidml.UserDefinedType
import com.reprezen.rapidml.ZenModel
import java.nio.charset.Charset
import javax.inject.Inject
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.validation.CheckMode
import org.eclipse.xtext.validation.IResourceValidator
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*

@RunWith(XtextRunner)
@InjectWith(RapidMLInjectorProvider)
class RawStringTest {

	@Inject
	ParseHelper<ZenModel> parseHelper

	@Inject
	IResourceValidator validator

	@Test
	def void testRawString() {
		val resource = Resources.toString(Resources.getResource("RawString.rapid"), Charset.forName("UTF-8"))
		val result = parseHelper.parse(resource)

		assertNotNull(result)

		val issues = validator.validate(result.eResource, CheckMode.ALL, CancelIndicator.NullImpl)
		assertEquals(0, issues.size)

		val dataModel = result.dataModels.get(0)
		val req1 = dataModel.ownedDataTypes.get(0) as UserDefinedType
		val req2 = dataModel.ownedDataTypes.get(1) as UserDefinedType

		val c1 = req1.constraints.get(0) as RegExConstraint
		val c2 = req2.constraints.get(0) as RegExConstraint

		val matcher = ''':20":REF'/hh123'''

		assertTrue(matcher.matches(c1.pattern))
		assertTrue(matcher.matches(c2.pattern))
	}

}
