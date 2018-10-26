/**
 * Copyright © 2013-2016 Modelsolv, Inc.
 * All Rights Reserved.
 * 
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 */
package com.modelsolv.reprezen.rapidml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enumeration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.modelsolv.reprezen.rapidml.Enumeration#getEnumConstants <em>Enum Constants</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.rapidml.Enumeration#getBaseType <em>Base Type</em>}</li>
 * </ul>
 *
 * @see com.modelsolv.reprezen.rapidml.RapidmlPackage#getEnumeration()
 * @model
 * @generated
 */
public interface Enumeration extends SingleValueType {
	/**
	 * Returns the value of the '<em><b>Enum Constants</b></em>' containment reference list.
	 * The list contents are of type {@link com.modelsolv.reprezen.rapidml.EnumConstant}.
	 * It is bidirectional and its opposite is '{@link com.modelsolv.reprezen.rapidml.EnumConstant#getEnumeration <em>Enumeration</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enum Constants</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enum Constants</em>' containment reference list.
	 * @see com.modelsolv.reprezen.rapidml.RapidmlPackage#getEnumeration_EnumConstants()
	 * @see com.modelsolv.reprezen.rapidml.EnumConstant#getEnumeration
	 * @model opposite="enumeration" containment="true"
	 * @generated
	 */
	EList<EnumConstant> getEnumConstants();

	/**
	 * Returns the value of the '<em><b>Base Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Type</em>' reference.
	 * @see #setBaseType(PrimitiveType)
	 * @see com.modelsolv.reprezen.rapidml.RapidmlPackage#getEnumeration_BaseType()
	 * @model required="true"
	 * @generated
	 */
	PrimitiveType getBaseType();

	/**
	 * Sets the value of the '{@link com.modelsolv.reprezen.rapidml.Enumeration#getBaseType <em>Base Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Type</em>' reference.
	 * @see #getBaseType()
	 * @generated
	 */
	void setBaseType(PrimitiveType value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return getBaseType();'"
	 * @generated
	 */
	PrimitiveType getPrimitiveType();

} // Enumeration
