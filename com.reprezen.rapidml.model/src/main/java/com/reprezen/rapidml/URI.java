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
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>URI</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.reprezen.rapidml.URI#getSegments <em>Segments</em>}</li>
 *   <li>{@link com.reprezen.rapidml.URI#getUriParameters <em>Uri Parameters</em>}</li>
 * </ul>
 *
 * @see com.reprezen.rapidml.RapidmlPackage#getURI()
 * @model
 * @generated
 */
public interface URI extends HasStringValue {
	/**
	 * Returns the value of the '<em><b>Segments</b></em>' containment reference list.
	 * The list contents are of type {@link com.reprezen.rapidml.URISegment}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Segments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Segments</em>' containment reference list.
	 * @see com.reprezen.rapidml.RapidmlPackage#getURI_Segments()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<URISegment> getSegments();

	/**
	 * Returns the value of the '<em><b>Uri Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link com.reprezen.rapidml.URIParameter}.
	 * It is bidirectional and its opposite is '{@link com.reprezen.rapidml.URIParameter#getContainingURI <em>Containing URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uri Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uri Parameters</em>' containment reference list.
	 * @see com.reprezen.rapidml.RapidmlPackage#getURI_UriParameters()
	 * @see com.reprezen.rapidml.URIParameter#getContainingURI
	 * @model opposite="containingURI" containment="true"
	 * @generated
	 */
	EList<URIParameter> getUriParameters();

} // URI
