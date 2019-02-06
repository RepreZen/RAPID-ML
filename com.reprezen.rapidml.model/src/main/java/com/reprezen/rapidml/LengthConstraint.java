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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Length
 * Constraint</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.reprezen.rapidml.LengthConstraint#getMinLength <em>Min
 * Length</em>}</li>
 * <li>{@link com.reprezen.rapidml.LengthConstraint#getMaxLength <em>Max
 * Length</em>}</li>
 * </ul>
 *
 * @see com.reprezen.rapidml.RapidmlPackage#getLengthConstraint()
 * @model features="length" lengthDataType="org.eclipse.emf.ecore.EInt"
 *        lengthTransient="true" lengthVolatile="true" lengthDerived="true"
 *        lengthSuppressedGetVisibility="true"
 * @generated
 */
public interface LengthConstraint extends Constraint {
	/**
	 * Returns the value of the '<em><b>Min Length</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min Length</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Min Length</em>' attribute.
	 * @see #isSetMinLength()
	 * @see #unsetMinLength()
	 * @see #setMinLength(int)
	 * @see com.reprezen.rapidml.RapidmlPackage#getLengthConstraint_MinLength()
	 * @model unsettable="true"
	 * @generated
	 */
	int getMinLength();

	/**
	 * Sets the value of the
	 * '{@link com.reprezen.rapidml.LengthConstraint#getMinLength <em>Min
	 * Length</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Min Length</em>' attribute.
	 * @see #isSetMinLength()
	 * @see #unsetMinLength()
	 * @see #getMinLength()
	 * @generated
	 */
	void setMinLength(int value);

	/**
	 * Unsets the value of the
	 * '{@link com.reprezen.rapidml.LengthConstraint#getMinLength <em>Min
	 * Length</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isSetMinLength()
	 * @see #getMinLength()
	 * @see #setMinLength(int)
	 * @generated
	 */
	void unsetMinLength();

	/**
	 * Returns whether the value of the
	 * '{@link com.reprezen.rapidml.LengthConstraint#getMinLength <em>Min
	 * Length</em>}' attribute is set. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return whether the value of the '<em>Min Length</em>' attribute is set.
	 * @see #unsetMinLength()
	 * @see #getMinLength()
	 * @see #setMinLength(int)
	 * @generated
	 */
	boolean isSetMinLength();

	/**
	 * Returns the value of the '<em><b>Max Length</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Length</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Max Length</em>' attribute.
	 * @see #isSetMaxLength()
	 * @see #unsetMaxLength()
	 * @see #setMaxLength(int)
	 * @see com.reprezen.rapidml.RapidmlPackage#getLengthConstraint_MaxLength()
	 * @model unsettable="true"
	 * @generated
	 */
	int getMaxLength();

	/**
	 * Sets the value of the
	 * '{@link com.reprezen.rapidml.LengthConstraint#getMaxLength <em>Max
	 * Length</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Max Length</em>' attribute.
	 * @see #isSetMaxLength()
	 * @see #unsetMaxLength()
	 * @see #getMaxLength()
	 * @generated
	 */
	void setMaxLength(int value);

	/**
	 * Unsets the value of the
	 * '{@link com.reprezen.rapidml.LengthConstraint#getMaxLength <em>Max
	 * Length</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isSetMaxLength()
	 * @see #getMaxLength()
	 * @see #setMaxLength(int)
	 * @generated
	 */
	void unsetMaxLength();

	/**
	 * Returns whether the value of the
	 * '{@link com.reprezen.rapidml.LengthConstraint#getMaxLength <em>Max
	 * Length</em>}' attribute is set. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return whether the value of the '<em>Max Length</em>' attribute is set.
	 * @see #unsetMaxLength()
	 * @see #getMaxLength()
	 * @see #setMaxLength(int)
	 * @generated
	 */
	boolean isSetMaxLength();

	/**
	 * Sets the value of the '{@link com.reprezen.rapidml.LengthConstraint#getLength
	 * <em>Length</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Length</em>' attribute.
	 * @see #getLength()
	 * @generated
	 */
	void setLength(int value);

} // LengthConstraint
