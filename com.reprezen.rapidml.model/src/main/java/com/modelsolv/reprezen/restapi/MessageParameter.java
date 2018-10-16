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
 * A representation of the model object '<em><b>Message Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.modelsolv.reprezen.restapi.MessageParameter#getContainingMessage <em>Containing Message</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.restapi.MessageParameter#getHttpLocation <em>Http Location</em>}</li>
 * </ul>
 *
 * @see com.modelsolv.reprezen.restapi.RestapiPackage#getMessageParameter()
 * @model
 * @generated
 */
public interface MessageParameter extends Parameter {
	/**
	 * Returns the value of the '<em><b>Containing Message</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link com.modelsolv.reprezen.restapi.TypedMessage#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Containing Message</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Containing Message</em>' container reference.
	 * @see #setContainingMessage(TypedMessage)
	 * @see com.modelsolv.reprezen.restapi.RestapiPackage#getMessageParameter_ContainingMessage()
	 * @see com.modelsolv.reprezen.restapi.TypedMessage#getParameters
	 * @model opposite="parameters" transient="false"
	 * @generated
	 */
	TypedMessage getContainingMessage();

	/**
	 * Sets the value of the '{@link com.modelsolv.reprezen.restapi.MessageParameter#getContainingMessage <em>Containing Message</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Containing Message</em>' container reference.
	 * @see #getContainingMessage()
	 * @generated
	 */
	void setContainingMessage(TypedMessage value);

	/**
	 * Returns the value of the '<em><b>Http Location</b></em>' attribute.
	 * The literals are from the enumeration {@link com.modelsolv.reprezen.restapi.HttpMessageParameterLocation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Http Location</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Http Location</em>' attribute.
	 * @see com.modelsolv.reprezen.restapi.HttpMessageParameterLocation
	 * @see #setHttpLocation(HttpMessageParameterLocation)
	 * @see com.modelsolv.reprezen.restapi.RestapiPackage#getMessageParameter_HttpLocation()
	 * @model
	 * @generated
	 */
	HttpMessageParameterLocation getHttpLocation();

	/**
	 * Sets the value of the '{@link com.modelsolv.reprezen.restapi.MessageParameter#getHttpLocation <em>Http Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Http Location</em>' attribute.
	 * @see com.modelsolv.reprezen.restapi.HttpMessageParameterLocation
	 * @see #getHttpLocation()
	 * @generated
	 */
	void setHttpLocation(HttpMessageParameterLocation value);

} // MessageParameter
