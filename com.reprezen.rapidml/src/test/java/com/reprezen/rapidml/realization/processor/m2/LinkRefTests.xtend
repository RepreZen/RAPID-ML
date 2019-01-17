/*******************************************************************************
 * Copyright © 2013, 2018 Modelsolv, Inc.
 * All Rights Reserved.
 * 
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.realization.processor.m2

import com.reprezen.rapidml.ZenModel
import com.reprezen.rapidml.realization.processor.ModelChecker
import com.reprezen.rapidml.realization.processor.RealizationTestSuite

class LinkRefTests<T> extends RealizationTestSuite<T> {

	val private ModelChecker<T> myChecker

	new(ModelChecker<T> checker) {
		super(checker)
		this.myChecker = checker
	}

	def testObjectResource(ZenModel model) {
		// This model is the same as for LinkSpec_ObjectResource, but the realization 
		// model puts link specs in components rather than inlining them. End result 
		// should be identical
		new LinkSpecTests(myChecker).testObjectResource(model)
	}
}
