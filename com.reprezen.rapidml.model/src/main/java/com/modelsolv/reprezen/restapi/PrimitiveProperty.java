/**
 * Copyright © 2013-2016 Modelsolv, Inc.
 * All Rights Reserved.
 * 
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 */
package com.modelsolv.reprezen.restapi;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Primitive Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.modelsolv.reprezen.restapi.PrimitiveProperty#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see com.modelsolv.reprezen.restapi.RestapiPackage#getPrimitiveProperty()
 * @model
 * @generated
 */
public interface PrimitiveProperty extends Feature, HasStringValue, ConstrainableType {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(SingleValueType)
	 * @see com.modelsolv.reprezen.restapi.RestapiPackage#getPrimitiveProperty_Type()
	 * @model required="true"
	 * @generated
	 */
	SingleValueType getType();

	/**
	 * Sets the value of the '{@link com.modelsolv.reprezen.restapi.PrimitiveProperty#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(SingleValueType value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body=' return getType().getPrimitiveType();'"
	 * @generated
	 */
	PrimitiveType getPrimitiveType();

} // PrimitiveProperty
