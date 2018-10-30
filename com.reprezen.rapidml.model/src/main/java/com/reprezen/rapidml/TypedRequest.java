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
 * A representation of the model object '<em><b>Typed Request</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.reprezen.rapidml.TypedRequest#getContainingMethod <em>Containing Method</em>}</li>
 * </ul>
 *
 * @see com.reprezen.rapidml.RapidmlPackage#getTypedRequest()
 * @model
 * @generated
 */
public interface TypedRequest extends TypedMessage {
	/**
	 * Returns the value of the '<em><b>Containing Method</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link com.reprezen.rapidml.Method#getRequest <em>Request</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Containing Method</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Containing Method</em>' container reference.
	 * @see #setContainingMethod(Method)
	 * @see com.reprezen.rapidml.RapidmlPackage#getTypedRequest_ContainingMethod()
	 * @see com.reprezen.rapidml.Method#getRequest
	 * @model opposite="request" transient="false"
	 * @generated
	 */
	Method getContainingMethod();

	/**
	 * Sets the value of the '{@link com.reprezen.rapidml.TypedRequest#getContainingMethod <em>Containing Method</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Containing Method</em>' container reference.
	 * @see #getContainingMethod()
	 * @generated
	 */
	void setContainingMethod(Method value);

} // TypedRequest
