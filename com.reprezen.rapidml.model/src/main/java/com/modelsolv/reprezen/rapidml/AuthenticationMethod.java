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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Authentication Method</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.modelsolv.reprezen.rapidml.AuthenticationMethod#getScheme <em>Scheme</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.rapidml.AuthenticationMethod#getScopes <em>Scopes</em>}</li>
 * </ul>
 *
 * @see com.modelsolv.reprezen.rapidml.RapidmlPackage#getAuthenticationMethod()
 * @model
 * @generated
 */
public interface AuthenticationMethod extends EObject {
	/**
	 * Returns the value of the '<em><b>Scheme</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scheme</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scheme</em>' reference.
	 * @see #setScheme(SecurityScheme)
	 * @see com.modelsolv.reprezen.rapidml.RapidmlPackage#getAuthenticationMethod_Scheme()
	 * @model required="true"
	 * @generated
	 */
	SecurityScheme getScheme();

	/**
	 * Sets the value of the '{@link com.modelsolv.reprezen.rapidml.AuthenticationMethod#getScheme <em>Scheme</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scheme</em>' reference.
	 * @see #getScheme()
	 * @generated
	 */
	void setScheme(SecurityScheme value);

	/**
	 * Returns the value of the '<em><b>Scopes</b></em>' reference list.
	 * The list contents are of type {@link com.modelsolv.reprezen.rapidml.SecurityScope}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scopes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scopes</em>' reference list.
	 * @see com.modelsolv.reprezen.rapidml.RapidmlPackage#getAuthenticationMethod_Scopes()
	 * @model
	 * @generated
	 */
	EList<SecurityScope> getScopes();

} // AuthenticationMethod
