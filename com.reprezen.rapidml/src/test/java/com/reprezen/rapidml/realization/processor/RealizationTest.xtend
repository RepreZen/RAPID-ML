/*******************************************************************************
 * Copyright © 2013, 2018 Modelsolv, Inc.
 * All Rights Reserved.
 * 
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.realization.processor

import com.google.common.io.Resources
import com.reprezen.rapidml.ZenModel
import com.reprezen.rapidml.implicit.ZenModelNormalizer
import com.reprezen.rapidml.xtext.XtextDslStandaloneSetup
import com.reprezen.rapidml.xtext.loaders.ZenModelLoader
import java.lang.reflect.InvocationTargetException
import java.util.List
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtext.validation.IResourceValidator
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ErrorCollector
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters
import com.reprezen.rapidml.RapidmlPackage
import org.eclipse.emf.ecore.EPackage

/**
 * Tests of realization processor, using test scenarios outlined in cmr.resources.test/models/autoRealization.
 * 
 * Test strategy is to load a test model with normalization, and verify that realizations appearing in the model are as expected. 
 * No code generation is performed by these tests.
 */
@RunWith(Parameterized)
class RealizationTest extends Assert {

	@Parameters(name="{index} - {0}: {1}_{3} | {5}")
	def static data() {
		val checkers = #[
			RapidModelChecker,
			EffectiveRealizationChecker,
			null
		]
		val data = #[ //
		// [milestone, test case set, test class, [test case...]]
		// test class defaults to '''«test case set»Tests''' in subpackage milestone.toLowerCase
		// non-default test class should be specified via fully-qualified class name
			#["M1", "InclusivePropertySet", null, #[
				"Simple",
				"ExcludePrimitive",
				"ExcludeReference"
			]],
			#["M1", "ExclusivePropertySet", null, #[
				"OnlyReference",
				"OnlyPrimitive"
			]],
			#["M1", "ReferenceLevel", null, #[
				"RootOnly",
				"RootsAndRefs"
			]],
			#["M1", "KeyProperties", null, #[
				"IncludeKeys",
				"IncludeNonKeys",
				"ExcludeNonKeys",
				"ExcludeKeys",
				"KeysOrAll"
			]],
			#["M1", "Containment", null, #[
				"ContainingRefs",
				"ContainerRefs",
				"ExcludeContainer",
				"ExcludeContaining",
				"IncludeContainer",
				"IncludeContaining"
			]],
			#["M1", "Multiplicity", null, #[
				"ExcludeMultiValued",
				"ExcludeSingleValued",
				"Match"
			]],
			#["M1", "RealizationRef", null, #[
				"KeysInLevelTwoRefs"
			]],
			#["M1", "Requiredness", null, #[
				"IncludeRequired",
				"ExcludeRequired"
			]],
			#["M1", "ResourceType", null, #[
				"ObjectResourceRefsOnly",
				"CollectionResourceRefsOnly"
			]],
			#["M1", "MessageType", null, #[
				"KeysInNoKeysOut"
			]],
			#["M2", "LinkSpec", null, #[
				"ObjectResource",
				"IncludeAutoLinkableToOR",
				"CollectionResource"
			]],
			#["M2", "LinkRef", null, #[
				"ObjectResource"
			]],
			#["M2", "ComplexLinks", null, #[
				"ConditionalLink",
				"LinkSwitch"
			]],
			#["M2", "Reuse", null, #[
				"CollectionRoots",
				"ObjectAndMessageRoots",
				"SingleValuedRootsAndRefs",
				"MultiValuedRootsAndRefs",
				"SingleAndMultiValuedRoots"
			]],
			#["M2", "Errors", null, #[
				"NameCollision"
			]],
			#["Zen4007", "Zen4007", null, #[
				"Zen4007"
			]],
			#[] // this one's here so commenting out the last entry won't break the syntax. It's filtered out below
		].filter[it.size > 0]
		data.map [ test |
			(test.get(3) as List<String>).map [ subtest |
				checkers.filter[it !== null].map [ checker |
					#[test.get(0), test.get(1), test.get(2), subtest, checker.name, checker.simpleName].toArray
				]
			]
		].flatten.flatten
	}

	val private String milestone
	val private String test
	val private String subtest
	val private String testClassName
	val private String checkerClassName

	new(String milestone, String test, String testClassName, String subtest, String checkerClassName,
		String checkerSimpleName) {
		this.milestone = milestone
		this.test = test
		this.testClassName = testClassName
		this.subtest = subtest
		this.checkerClassName = checkerClassName
	}

// with this rule, assertions wrapped in a try block can record the error but then 
// continue execution, so we can get a list of all failing assertsion in each test
	@Rule
	val public errors = new ErrorCollector()

	var ZenModelLoader loader = null

	@Before
	def void setUp() {
		val injector = XtextDslStandaloneSetup.doSetup()
		loader = new ZenModelLoader(
			injector.getInstance(ResourceSet),
			injector.getInstance(IResourceValidator)
		)
	}

	@Test
	def void testNormalizedRealizations() {
		// force package registration otherwise tests could fail
		EPackage.Registry.INSTANCE.put(RapidmlPackage.eNS_URI, RapidmlPackage.eINSTANCE)

		val modelPath = Resources.getResource( 
			'''realizations/«milestone»/«test»/«test»_«subtest».rapid''')

		val model = loader.loadAndValidateModel(URI::createURI(modelPath.toExternalForm))

		new ZenModelNormalizer().normalize(model)

		val testClass = Class.forName(testClassName ?: defaultTestClassName)
		val testClassConstructor = testClass.getDeclaredConstructor(ModelChecker)
		testClassConstructor.accessible = true
		val testMethod = testClass.getDeclaredMethod('''test«subtest»''', ZenModel)
		testMethod.accessible = true
		val checkerConstructor = Class.forName(checkerClassName).getDeclaredConstructor(ErrorCollector)
		checkerConstructor.accessible = true
		try {
			val checker = checkerConstructor.newInstance(errors) as ModelChecker<?>
			val testClassInstance = testClassConstructor.newInstance(checker)
			testMethod.invoke(testClassInstance, model)
			checker.done
		} catch (InvocationTargetException e) {
			throw if(e.cause != null) e.cause else e
		}
	}

	def private String getDefaultTestClassName() {
		val pkg = class.name.substring(0, class.name.lastIndexOf("."))
		'''«pkg».«milestone.toLowerCase».«test»Tests'''
	}
}
