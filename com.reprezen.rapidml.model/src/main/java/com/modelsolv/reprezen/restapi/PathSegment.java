/**
 * Copyright © 2013-2016 Modelsolv, Inc.
 * All Rights Reserved.
 * 
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 */
package com.modelsolv.reprezen.restapi;

import com.modelsolv.reprezen.restapi.ReferenceElement;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Path Segment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.modelsolv.reprezen.restapi.PathSegment#getReferenceElement <em>Reference Element</em>}</li>
 * </ul>
 *
 * @see com.modelsolv.reprezen.restapi.RestapiPackage#getPathSegment()
 * @model abstract="true"
 * @generated
 */
public interface PathSegment extends EObject {
	/**
	 * Returns the value of the '<em><b>Reference Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reference Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reference Element</em>' reference.
	 * @see #setReferenceElement(com.modelsolv.reprezen.restapi.ReferenceElement)
	 * @see com.modelsolv.reprezen.restapi.RestapiPackage#getPathSegment_ReferenceElement()
	 * @model
	 * @generated
	 */
	com.modelsolv.reprezen.restapi.ReferenceElement getReferenceElement();

	/**
	 * Sets the value of the '{@link com.modelsolv.reprezen.restapi.PathSegment#getReferenceElement <em>Reference Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reference Element</em>' reference.
	 * @see #getReferenceElement()
	 * @generated
	 */
	void setReferenceElement(com.modelsolv.reprezen.restapi.ReferenceElement value);

} // PathSegment
