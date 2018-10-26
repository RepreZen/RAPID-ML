/*******************************************************************************
 * Copyright � 2013, 2018 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.realization.processor

import java.util.IdentityHashMap

class CycleDetector<T> {
	val visiting = new IdentityHashMap<T, T>()
	
	def visit(T t) {
		if (visiting.containsKey(t)) {
			return false
		} else {
			visiting.put(t, t);
			return true
		}
	}

	def leave(T t) {
		visiting.remove(t);
	}
}
