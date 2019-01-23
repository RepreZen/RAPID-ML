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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Resource
 * Definition</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.reprezen.rapidml.ResourceDefinition#getMethods
 * <em>Methods</em>}</li>
 * <li>{@link com.reprezen.rapidml.ResourceDefinition#getMediaTypes <em>Media
 * Types</em>}</li>
 * <li>{@link com.reprezen.rapidml.ResourceDefinition#getName
 * <em>Name</em>}</li>
 * <li>{@link com.reprezen.rapidml.ResourceDefinition#getAllMediaTypes <em>All
 * Media Types</em>}</li>
 * <li>{@link com.reprezen.rapidml.ResourceDefinition#getURI <em>URI</em>}</li>
 * </ul>
 *
 * @see com.reprezen.rapidml.RapidmlPackage#getResourceDefinition()
 * @model abstract="true"
 * @generated
 */
public interface ResourceDefinition extends RESTElement, WithExamples, HasSecurityValue {
	/**
	 * Returns the value of the '<em><b>Methods</b></em>' containment reference
	 * list. The list contents are of type {@link com.reprezen.rapidml.Method}. It
	 * is bidirectional and its opposite is
	 * '{@link com.reprezen.rapidml.Method#getContainingResourceDefinition
	 * <em>Containing Resource Definition</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Methods</em>' containment reference list isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Methods</em>' containment reference list.
	 * @see com.reprezen.rapidml.RapidmlPackage#getResourceDefinition_Methods()
	 * @see com.reprezen.rapidml.Method#getContainingResourceDefinition
	 * @model opposite="containingResourceDefinition" containment="true"
	 * @generated
	 */
	EList<Method> getMethods();

	/**
	 * Returns the value of the '<em><b>Media Types</b></em>' reference list. The
	 * list contents are of type {@link com.reprezen.rapidml.MediaType}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Media Types</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Media Types</em>' reference list.
	 * @see com.reprezen.rapidml.RapidmlPackage#getResourceDefinition_MediaTypes()
	 * @model
	 * @generated
	 */
	EList<MediaType> getMediaTypes();

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
	 * @see com.reprezen.rapidml.RapidmlPackage#getResourceDefinition_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.reprezen.rapidml.ResourceDefinition#getName
	 * <em>Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>All Media Types</b></em>' reference list.
	 * The list contents are of type {@link com.reprezen.rapidml.MediaType}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>All Media Types</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>All Media Types</em>' reference list.
	 * @see com.reprezen.rapidml.RapidmlPackage#getResourceDefinition_AllMediaTypes()
	 * @model
	 * @generated
	 */
	EList<MediaType> getAllMediaTypes();

	/**
	 * Returns the value of the '<em><b>URI</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>URI</em>' containment reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>URI</em>' containment reference.
	 * @see #setURI(URI)
	 * @see com.reprezen.rapidml.RapidmlPackage#getResourceDefinition_URI()
	 * @model containment="true"
	 * @generated
	 */
	URI getURI();

	/**
	 * Sets the value of the '{@link com.reprezen.rapidml.ResourceDefinition#getURI
	 * <em>URI</em>}' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>URI</em>' containment reference.
	 * @see #getURI()
	 * @generated
	 */
	void setURI(URI value);

} // ResourceDefinition
