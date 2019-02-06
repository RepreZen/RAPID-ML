/**
 * Copyright © 2013-2016 Modelsolv, Inc.
 * All Rights Reserved.
 * 
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 */
package com.reprezen.rapidml;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Reg Ex
 * Constraint</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.reprezen.rapidml.RegExConstraint#getPattern
 * <em>Pattern</em>}</li>
 * </ul>
 *
 * @see com.reprezen.rapidml.RapidmlPackage#getRegExConstraint()
 * @model
 * @generated
 */
public interface RegExConstraint extends Constraint {
	/**
	 * Returns the value of the '<em><b>Pattern</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pattern</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Pattern</em>' attribute.
	 * @see #setPattern(String)
	 * @see com.reprezen.rapidml.RapidmlPackage#getRegExConstraint_Pattern()
	 * @model
	 * @generated
	 */
	String getPattern();

	/**
	 * Sets the value of the '{@link com.reprezen.rapidml.RegExConstraint#getPattern
	 * <em>Pattern</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Pattern</em>' attribute.
	 * @see #getPattern()
	 * @generated
	 */
	void setPattern(String value);

} // RegExConstraint
