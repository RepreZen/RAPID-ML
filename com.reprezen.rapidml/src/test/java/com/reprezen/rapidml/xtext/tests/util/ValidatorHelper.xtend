package com.reprezen.rapidml.xtext.tests.util

import com.reprezen.rapidml.ZenModel
import com.reprezen.rapidml.xtext.loaders.RepreZenXtextResourceSet
import java.util.List
import javax.inject.Inject
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtext.diagnostics.Severity
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.eclipse.xtext.validation.Issue

import static org.junit.Assert.*

class ValidatorHelper extends ValidationTestHelper {

	@Inject ParseHelper<ZenModel> parser

	def assertError(CharSequence model, String error) {
		val ResourceSet rset = new RepreZenXtextResourceSet();
		val rapidModel = parser.parse(model, rset)
		val diag = validate(rapidModel)

		if (!diag.exists[e|e.severity === Severity.ERROR && e.message === error])
			fail('''error «error» not found''')
	}

	def assertOK(List<Issue> issues) {
		if (!issues.empty)
			fail("There are expected to be no diagnostics.")
	}

	def assertOK(CharSequence model) {
		val ResourceSet rset = new RepreZenXtextResourceSet();
		val rapidModel = parser.parse(model, rset)
		validate(rapidModel).assertOK
	}

	def void assertWarningContains(List<Issue> issues, String message) {
		if (!issues.exists[e | e.severity === Severity.WARNING && e.message.contains(message)])
			fail('''warning with message «message» does not exist''')
	}

	def void assertErrorContains(List<Issue> issues, String message) {
		if (!issues.exists[e | e.severity === Severity.ERROR && e.message.contains(message)])
			fail('''error with message «message» does not exist''')
	}
}
