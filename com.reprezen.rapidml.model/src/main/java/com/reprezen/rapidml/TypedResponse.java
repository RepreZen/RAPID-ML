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
 * A representation of the model object '<em><b>Typed Response</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.reprezen.rapidml.TypedResponse#getStatusCode <em>Status Code</em>}</li>
 *   <li>{@link com.reprezen.rapidml.TypedResponse#getContainingMethod <em>Containing Method</em>}</li>
 * </ul>
 *
 * @see com.reprezen.rapidml.RapidmlPackage#getTypedResponse()
 * @model
 * @generated
 */
public interface TypedResponse extends TypedMessage {
	/**
	 * Returns the value of the '<em><b>Status Code</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Status Code</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Status Code</em>' attribute.
	 * @see #setStatusCode(int)
	 * @see com.reprezen.rapidml.RapidmlPackage#getTypedResponse_StatusCode()
	 * @model default="-1"
	 * @generated
	 */
	int getStatusCode();

	/**
	 * Sets the value of the '{@link com.reprezen.rapidml.TypedResponse#getStatusCode <em>Status Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Status Code</em>' attribute.
	 * @see #getStatusCode()
	 * @generated
	 */
	void setStatusCode(int value);

	/**
	 * Returns the value of the '<em><b>Containing Method</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link com.reprezen.rapidml.Method#getResponses <em>Responses</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Containing Method</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Containing Method</em>' container reference.
	 * @see #setContainingMethod(Method)
	 * @see com.reprezen.rapidml.RapidmlPackage#getTypedResponse_ContainingMethod()
	 * @see com.reprezen.rapidml.Method#getResponses
	 * @model opposite="responses" transient="false"
	 * @generated
	 */
	Method getContainingMethod();

	/**
	 * Sets the value of the '{@link com.reprezen.rapidml.TypedResponse#getContainingMethod <em>Containing Method</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Containing Method</em>' container reference.
	 * @see #getContainingMethod()
	 * @generated
	 */
	void setContainingMethod(Method value);

} // TypedResponse
