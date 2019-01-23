package com.reprezen.rapidml.xtext.tests

import org.eclipse.xtext.junit4.XtextRunner
import org.junit.runners.parameterized.TestWithParameters
import org.junit.runners.model.InitializationError
import java.util.List
import org.junit.runners.parameterized.ParametersRunnerFactory

class ParameterizedXtextRunner extends XtextRunner {

	static class XtextParametersRunnerFactory implements ParametersRunnerFactory {
		override createRunnerForTestWithParameters(TestWithParameters test) throws InitializationError {
			new ParameterizedXtextRunner(test)
		}
	}

	val Object[] parameters

	new(TestWithParameters test) throws InitializationError {
		super(test.testClass.javaClass)
		parameters = test.parameters
	}

	override protected createTest() throws Exception {
		val object = testClass.onlyConstructor.newInstance(parameters)
		val injectorProvider = getOrCreateInjectorProvider
		if (injectorProvider !== null) {
			val injector = injectorProvider.injector
			if (injector !== null)
				injector.injectMembers(object)
		}
		return object
	}

	override protected void validateConstructor(List<Throwable> errors) {
		validateOnlyOneConstructor(errors)
	}

}

