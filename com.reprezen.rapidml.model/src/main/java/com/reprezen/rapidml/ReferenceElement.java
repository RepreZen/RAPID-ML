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
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.reprezen.rapidml.ReferenceElement#getDataType <em>Data Type</em>}</li>
 * </ul>
 *
 * @see com.reprezen.rapidml.RapidmlPackage#getReferenceElement()
 * @model abstract="true"
 * @generated
 */
public interface ReferenceElement extends Element {
	/**
	 * Returns the value of the '<em><b>Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Type</em>' reference.
	 * @see #setDataType(Structure)
	 * @see com.reprezen.rapidml.RapidmlPackage#getReferenceElement_DataType()
	 * @model
	 * @generated
	 */
	Structure getDataType();

	/**
	 * Sets the value of the '{@link com.reprezen.rapidml.ReferenceElement#getDataType <em>Data Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Type</em>' reference.
	 * @see #getDataType()
	 * @generated
	 */
	void setDataType(Structure value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	String getName();

} // ReferenceElement
