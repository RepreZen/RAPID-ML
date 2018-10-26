/*
 * generated by Xtext 2.9.2
 */
package com.reprezen.rapidml.xtext.tests

import com.google.inject.Inject
import com.reprezen.rapidml.ZenModel
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(XtextRunner)
@InjectWith(RapidMLInjectorProvider)
class RapidMLParsingTest{

	@Inject
	ParseHelper<ZenModel> parseHelper;

	@Test 
	def void loadModel() {
		val result = parseHelper.parse('''
			Hello Xtext!
		''')
		Assert.assertNotNull(result)
	}

}