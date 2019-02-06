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
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Has
 * Security Value</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.reprezen.rapidml.HasSecurityValue#getSecuredBy <em>Secured
 * By</em>}</li>
 * </ul>
 *
 * @see com.reprezen.rapidml.RapidmlPackage#getHasSecurityValue()
 * @model abstract="true"
 * @generated
 */
public interface HasSecurityValue extends EObject {
	/**
	 * Returns the value of the '<em><b>Secured By</b></em>' containment reference
	 * list. The list contents are of type
	 * {@link com.reprezen.rapidml.AuthenticationMethod}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Secured By</em>' containment reference list isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Secured By</em>' containment reference list.
	 * @see com.reprezen.rapidml.RapidmlPackage#getHasSecurityValue_SecuredBy()
	 * @model containment="true"
	 * @generated
	 */
	EList<AuthenticationMethod> getSecuredBy();

} // HasSecurityValue
