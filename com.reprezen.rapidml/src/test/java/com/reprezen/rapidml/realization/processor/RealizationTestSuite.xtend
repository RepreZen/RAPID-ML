/*******************************************************************************
 * Copyright © 2013, 2018 Modelsolv, Inc.
 * All Rights Reserved.
 * 
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.realization.processor

import com.google.common.collect.Lists
import com.reprezen.rapidml.RealizationContainer
import com.reprezen.rapidml.ResourceDefinition
import com.reprezen.rapidml.realization.processor.ModelChecker.RootChecker
import java.util.List
import org.junit.rules.ErrorCollector

class RealizationTestSuite<T> {

	var ModelChecker<T> checker = null
	val List<ModelChecker<T>> pushedCheckers = Lists.newArrayList

	new(ModelChecker<T> checker) {
		this.checker = checker
	}

	def protected getChecker() {
		return checker
	}

	// so far this is needed only for ErrorsTest#testNameCollision
	def protected pushChecker() {
		pushedCheckers.add(checker)
		val cons = checker.class.getDeclaredConstructor(ErrorCollector)
		cons.accessible = true
		val newErrors = new VisibleErrorCollector
		checker = cons.newInstance(newErrors)
	}

	def protected popChecker() {
		val errors = (checker.errors as VisibleErrorCollector).errors
		checker = pushedCheckers.remove(pushedCheckers.size - 1)
		return errors
	}

	def check(RealizationContainer rznContainer, (RootChecker<T>)=>void code) {
		checker.check(rznContainer, code)
	}

	def check(ResourceDefinition resource, (RootChecker<T>)=>void code) {
		checker.check(resource, code)
	}

	private static class VisibleErrorCollector extends ErrorCollector {
		val private List<Throwable> visibleErrors = Lists.newArrayList

		override addError(Throwable t) {
			super.addError(t)
			visibleErrors.add(t)
		}

		def List<Throwable> getErrors() {
			return visibleErrors
		}
	}
}
