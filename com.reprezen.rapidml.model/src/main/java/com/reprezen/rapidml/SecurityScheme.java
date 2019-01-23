/**
 * Copyright © 2013-2016 Modelsolv, Inc.
 * All Rights Reserved.
 * 
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 */
package com.reprezen.rapidml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Security
 * Scheme</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.reprezen.rapidml.SecurityScheme#getName <em>Name</em>}</li>
 * <li>{@link com.reprezen.rapidml.SecurityScheme#getType <em>Type</em>}</li>
 * <li>{@link com.reprezen.rapidml.SecurityScheme#getScopes
 * <em>Scopes</em>}</li>
 * <li>{@link com.reprezen.rapidml.SecurityScheme#getSettings
 * <em>Settings</em>}</li>
 * <li>{@link com.reprezen.rapidml.SecurityScheme#getParameters
 * <em>Parameters</em>}</li>
 * <li>{@link com.reprezen.rapidml.SecurityScheme#getErrorResponses <em>Error
 * Responses</em>}</li>
 * <li>{@link com.reprezen.rapidml.SecurityScheme#getFlow <em>Flow</em>}</li>
 * </ul>
 *
 * @see com.reprezen.rapidml.RapidmlPackage#getSecurityScheme()
 * @model
 * @generated
 */
public interface SecurityScheme extends Documentable, RESTElement {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.reprezen.rapidml.RapidmlPackage#getSecurityScheme_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.reprezen.rapidml.SecurityScheme#getName
	 * <em>Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute. The literals are
	 * from the enumeration {@link com.reprezen.rapidml.AuthenticationTypes}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see com.reprezen.rapidml.AuthenticationTypes
	 * @see #setType(AuthenticationTypes)
	 * @see com.reprezen.rapidml.RapidmlPackage#getSecurityScheme_Type()
	 * @model
	 * @generated
	 */
	AuthenticationTypes getType();

	/**
	 * Sets the value of the '{@link com.reprezen.rapidml.SecurityScheme#getType
	 * <em>Type</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Type</em>' attribute.
	 * @see com.reprezen.rapidml.AuthenticationTypes
	 * @see #getType()
	 * @generated
	 */
	void setType(AuthenticationTypes value);

	/**
	 * Returns the value of the '<em><b>Scopes</b></em>' containment reference list.
	 * The list contents are of type {@link com.reprezen.rapidml.SecurityScope}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scopes</em>' containment reference list isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Scopes</em>' containment reference list.
	 * @see com.reprezen.rapidml.RapidmlPackage#getSecurityScheme_Scopes()
	 * @model containment="true"
	 * @generated
	 */
	EList<SecurityScope> getScopes();

	/**
	 * Returns the value of the '<em><b>Settings</b></em>' containment reference
	 * list. The list contents are of type
	 * {@link com.reprezen.rapidml.SecuritySchemeParameter}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Settings</em>' containment reference list isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Settings</em>' containment reference list.
	 * @see com.reprezen.rapidml.RapidmlPackage#getSecurityScheme_Settings()
	 * @model containment="true"
	 * @generated
	 */
	EList<SecuritySchemeParameter> getSettings();

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference
	 * list. The list contents are of type
	 * {@link com.reprezen.rapidml.MessageParameter}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see com.reprezen.rapidml.RapidmlPackage#getSecurityScheme_Parameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<MessageParameter> getParameters();

	/**
	 * Returns the value of the '<em><b>Error Responses</b></em>' containment
	 * reference list. The list contents are of type
	 * {@link com.reprezen.rapidml.TypedResponse}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Error Responses</em>' containment reference list
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Error Responses</em>' containment reference
	 *         list.
	 * @see com.reprezen.rapidml.RapidmlPackage#getSecurityScheme_ErrorResponses()
	 * @model containment="true"
	 * @generated
	 */
	EList<TypedResponse> getErrorResponses();

	/**
	 * Returns the value of the '<em><b>Flow</b></em>' attribute. The literals are
	 * from the enumeration {@link com.reprezen.rapidml.AuthenticationFlows}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Flow</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Flow</em>' attribute.
	 * @see com.reprezen.rapidml.AuthenticationFlows
	 * @see #setFlow(AuthenticationFlows)
	 * @see com.reprezen.rapidml.RapidmlPackage#getSecurityScheme_Flow()
	 * @model
	 * @generated
	 */
	AuthenticationFlows getFlow();

	/**
	 * Sets the value of the '{@link com.reprezen.rapidml.SecurityScheme#getFlow
	 * <em>Flow</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Flow</em>' attribute.
	 * @see com.reprezen.rapidml.AuthenticationFlows
	 * @see #getFlow()
	 * @generated
	 */
	void setFlow(AuthenticationFlows value);

} // SecurityScheme
