/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.datatypes.util;

import java.util.Objects;
import java.util.function.Predicate;

import com.reprezen.rapidml.ReferenceElement;
import com.reprezen.rapidml.ReferenceProperty;
import com.reprezen.rapidml.ReferenceTreatment;

/**
 * Custom operations for {@link ReferenceTreatment}
 * 
 * @author Tatiana Fesenko <tatiana.fesenko@modelsolv.com>
 *
 */
public class ReferenceTreatmentOperations {

	/**
	 * Checks for the same reference path.
	 *
	 * @param anotherReferenceLink
	 *            the another reference link
	 * @return the predicate
	 */
	public static Predicate<ReferenceTreatment> hasTheSameReferencePath(ReferenceTreatment anotherReferenceLink) {
		return input -> Objects.equals(anotherReferenceLink, input) || semanticallyEqual(anotherReferenceLink, input);
	}

	/**
	 * Checks if the referenceTreatment type is not null.
	 *
	 * @return the predicate
	 */
	public static java.util.function.Predicate<ReferenceTreatment> hasDeclaredType() {
		return input -> {
			if (null != input) {
				ReferenceElement reference = input.getReferenceElement();
				return reference != null && null != reference.getDataType();
			}
			return false;
		};
	}

	/**
	 * checks ReferenceTreatment for treating the given referenceProperty
	 * 
	 * @param referenceProperty
	 * @return the predicate
	 */
	public static java.util.function.Predicate<ReferenceTreatment> treatsReferenceProperty(
			ReferenceProperty referenceProperty) {
		return input -> Objects.equals(referenceProperty, input.getReferenceElement());
	}

	protected static boolean semanticallyEqual(ReferenceTreatment link1, ReferenceTreatment link2) {
		return Objects.equals(link1, link2)
				|| java.util.Objects.equals(link1.getReferenceElement(), link2.getReferenceElement());
	}

}
