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
 * A representation of the model object '<em><b>Media Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.modelsolv.reprezen.restapi.MediaType#getName <em>Name</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.restapi.MediaType#getSpecURL <em>Spec URL</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.restapi.MediaType#getDerivedFrom <em>Derived From</em>}</li>
 * </ul>
 *
 * @see com.modelsolv.reprezen.restapi.RestapiPackage#getMediaType()
 * @model
 * @generated
 */
public interface MediaType extends RESTElement {
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
	 * @see com.modelsolv.reprezen.restapi.RestapiPackage#getMediaType_Name()
	 * @model id="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.modelsolv.reprezen.restapi.MediaType#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Spec URL</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Spec URL</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Spec URL</em>' attribute.
	 * @see #setSpecURL(String)
	 * @see com.modelsolv.reprezen.restapi.RestapiPackage#getMediaType_SpecURL()
	 * @model
	 * @generated
	 */
	String getSpecURL();

	/**
	 * Sets the value of the '{@link com.modelsolv.reprezen.restapi.MediaType#getSpecURL <em>Spec URL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Spec URL</em>' attribute.
	 * @see #getSpecURL()
	 * @generated
	 */
	void setSpecURL(String value);

	/**
	 * Returns the value of the '<em><b>Derived From</b></em>' reference list.
	 * The list contents are of type {@link com.modelsolv.reprezen.restapi.MediaType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Derived From</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Derived From</em>' reference list.
	 * @see com.modelsolv.reprezen.restapi.RestapiPackage#getMediaType_DerivedFrom()
	 * @model
	 * @generated
	 */
	EList<MediaType> getDerivedFrom();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return null == getName() ? 0 : getName().hashCode();'"
	 * @generated
	 */
	int hashCode();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='if (other == null || !(other instanceof MediaType)) {\r\n    return false;\r\n}\r\nMediaType otherMediaType = (MediaType) other;\r\nString otherName = otherMediaType.getName();\r\nString thisName = this.getName();        \r\nif (otherName == null &amp;&amp; thisName == null) {\r\n    return true;\r\n}\r\nif (otherName == null || thisName == null) {\r\n\treturn false;\r\n}       \r\n// Media types are not case sensitive.\r\nreturn thisName.equalsIgnoreCase((otherName));'"
	 * @generated
	 */
	boolean equals(Object other);

} // MediaType
