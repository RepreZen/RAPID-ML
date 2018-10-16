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
 * A representation of the model object '<em><b>URI Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.modelsolv.reprezen.restapi.URIParameter#getUriSegment <em>Uri Segment</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.restapi.URIParameter#getContainingURI <em>Containing URI</em>}</li>
 * </ul>
 *
 * @see com.modelsolv.reprezen.restapi.RestapiPackage#getURIParameter()
 * @model abstract="true"
 * @generated
 */
public interface URIParameter extends Parameter {
	/**
	 * Returns the value of the '<em><b>Uri Segment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uri Segment</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uri Segment</em>' reference.
	 * @see #setUriSegment(URISegmentWithParameter)
	 * @see com.modelsolv.reprezen.restapi.RestapiPackage#getURIParameter_UriSegment()
	 * @model
	 * @generated
	 */
	URISegmentWithParameter getUriSegment();

	/**
	 * Sets the value of the '{@link com.modelsolv.reprezen.restapi.URIParameter#getUriSegment <em>Uri Segment</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uri Segment</em>' reference.
	 * @see #getUriSegment()
	 * @generated
	 */
	void setUriSegment(URISegmentWithParameter value);

	/**
	 * Returns the value of the '<em><b>Containing URI</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link com.modelsolv.reprezen.restapi.URI#getUriParameters <em>Uri Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Containing URI</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Containing URI</em>' container reference.
	 * @see #setContainingURI(URI)
	 * @see com.modelsolv.reprezen.restapi.RestapiPackage#getURIParameter_ContainingURI()
	 * @see com.modelsolv.reprezen.restapi.URI#getUriParameters
	 * @model opposite="uriParameters" transient="false"
	 * @generated
	 */
	URI getContainingURI();

	/**
	 * Sets the value of the '{@link com.modelsolv.reprezen.restapi.URIParameter#getContainingURI <em>Containing URI</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Containing URI</em>' container reference.
	 * @see #getContainingURI()
	 * @generated
	 */
	void setContainingURI(URI value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if (uriSegment != null) {\r\n    return uriSegment.getName();\r\n}\r\nreturn name;'"
	 * @generated
	 */
	String getName();

} // URIParameter
