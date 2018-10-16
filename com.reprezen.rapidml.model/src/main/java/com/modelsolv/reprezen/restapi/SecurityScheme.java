/**
 * Copyright © 2013-2016 Modelsolv, Inc.
 * All Rights Reserved.
 * 
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 */
package com.modelsolv.reprezen.restapi;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Security Scheme</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.modelsolv.reprezen.restapi.SecurityScheme#getName <em>Name</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.restapi.SecurityScheme#getType <em>Type</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.restapi.SecurityScheme#getScopes <em>Scopes</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.restapi.SecurityScheme#getSettings <em>Settings</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.restapi.SecurityScheme#getParameters <em>Parameters</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.restapi.SecurityScheme#getErrorResponses <em>Error Responses</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.restapi.SecurityScheme#getFlow <em>Flow</em>}</li>
 * </ul>
 *
 * @see com.modelsolv.reprezen.restapi.RestapiPackage#getSecurityScheme()
 * @model
 * @generated
 */
public interface SecurityScheme extends Documentable, RESTElement {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.modelsolv.reprezen.restapi.RestapiPackage#getSecurityScheme_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.modelsolv.reprezen.restapi.SecurityScheme#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link com.modelsolv.reprezen.restapi.AuthenticationTypes}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see com.modelsolv.reprezen.restapi.AuthenticationTypes
	 * @see #setType(AuthenticationTypes)
	 * @see com.modelsolv.reprezen.restapi.RestapiPackage#getSecurityScheme_Type()
	 * @model
	 * @generated
	 */
	AuthenticationTypes getType();

	/**
	 * Sets the value of the '{@link com.modelsolv.reprezen.restapi.SecurityScheme#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see com.modelsolv.reprezen.restapi.AuthenticationTypes
	 * @see #getType()
	 * @generated
	 */
	void setType(AuthenticationTypes value);

	/**
	 * Returns the value of the '<em><b>Scopes</b></em>' containment reference list.
	 * The list contents are of type {@link com.modelsolv.reprezen.restapi.SecurityScope}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scopes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scopes</em>' containment reference list.
	 * @see com.modelsolv.reprezen.restapi.RestapiPackage#getSecurityScheme_Scopes()
	 * @model containment="true"
	 * @generated
	 */
	EList<SecurityScope> getScopes();

	/**
	 * Returns the value of the '<em><b>Settings</b></em>' containment reference list.
	 * The list contents are of type {@link com.modelsolv.reprezen.restapi.SecuritySchemeParameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Settings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Settings</em>' containment reference list.
	 * @see com.modelsolv.reprezen.restapi.RestapiPackage#getSecurityScheme_Settings()
	 * @model containment="true"
	 * @generated
	 */
	EList<SecuritySchemeParameter> getSettings();

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link com.modelsolv.reprezen.restapi.MessageParameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see com.modelsolv.reprezen.restapi.RestapiPackage#getSecurityScheme_Parameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<MessageParameter> getParameters();

	/**
	 * Returns the value of the '<em><b>Error Responses</b></em>' containment reference list.
	 * The list contents are of type {@link com.modelsolv.reprezen.restapi.TypedResponse}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Error Responses</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Error Responses</em>' containment reference list.
	 * @see com.modelsolv.reprezen.restapi.RestapiPackage#getSecurityScheme_ErrorResponses()
	 * @model containment="true"
	 * @generated
	 */
	EList<TypedResponse> getErrorResponses();

	/**
	 * Returns the value of the '<em><b>Flow</b></em>' attribute.
	 * The literals are from the enumeration {@link com.modelsolv.reprezen.restapi.AuthenticationFlows}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Flow</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Flow</em>' attribute.
	 * @see com.modelsolv.reprezen.restapi.AuthenticationFlows
	 * @see #setFlow(AuthenticationFlows)
	 * @see com.modelsolv.reprezen.restapi.RestapiPackage#getSecurityScheme_Flow()
	 * @model
	 * @generated
	 */
	AuthenticationFlows getFlow();

	/**
	 * Sets the value of the '{@link com.modelsolv.reprezen.restapi.SecurityScheme#getFlow <em>Flow</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Flow</em>' attribute.
	 * @see com.modelsolv.reprezen.restapi.AuthenticationFlows
	 * @see #getFlow()
	 * @generated
	 */
	void setFlow(AuthenticationFlows value);

} // SecurityScheme
