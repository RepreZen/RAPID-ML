/**
 * Copyright © 2013-2016 Modelsolv, Inc.
 * All Rights Reserved.
 * 
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 */
package com.reprezen.rapidml;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Path
 * Segment</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.reprezen.rapidml.PathSegment#getReferenceElement <em>Reference
 * Element</em>}</li>
 * </ul>
 *
 * @see com.reprezen.rapidml.RapidmlPackage#getPathSegment()
 * @model abstract="true"
 * @generated
 */
public interface PathSegment extends EObject {
	/**
	 * Returns the value of the '<em><b>Reference Element</b></em>' reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reference Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Reference Element</em>' reference.
	 * @see #setReferenceElement(com.reprezen.rapidml.ReferenceElement)
	 * @see com.reprezen.rapidml.RapidmlPackage#getPathSegment_ReferenceElement()
	 * @model
	 * @generated
	 */
	com.reprezen.rapidml.ReferenceElement getReferenceElement();

	/**
	 * Sets the value of the
	 * '{@link com.reprezen.rapidml.PathSegment#getReferenceElement <em>Reference
	 * Element</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Reference Element</em>' reference.
	 * @see #getReferenceElement()
	 * @generated
	 */
	void setReferenceElement(com.reprezen.rapidml.ReferenceElement value);

} // PathSegment
