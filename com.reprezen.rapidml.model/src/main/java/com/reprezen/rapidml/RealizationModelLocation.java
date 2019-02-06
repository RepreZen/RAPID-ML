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

import com.reprezen.rapidml.realization.model.RealizationModel;

/**
 * <!-- begin-user-doc --> A representation of the model object
 * '<em><b>Realization Model Location</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.reprezen.rapidml.RealizationModelLocation#getUri
 * <em>Uri</em>}</li>
 * </ul>
 *
 * @see com.reprezen.rapidml.RapidmlPackage#getRealizationModelLocation()
 * @model
 * @generated
 */
public interface RealizationModelLocation extends EObject {
	/**
	 * Returns the value of the '<em><b>Uri</b></em>' attribute. <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Uri</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Uri</em>' attribute.
	 * @see #setUri(String)
	 * @see com.reprezen.rapidml.RapidmlPackage#getRealizationModelLocation_Uri()
	 * @model
	 * @generated
	 */
	String getUri();

	/**
	 * Sets the value of the
	 * '{@link com.reprezen.rapidml.RealizationModelLocation#getUri <em>Uri</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Uri</em>' attribute.
	 * @see #getUri()
	 * @generated
	 */
	void setUri(String value);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model kind="operation" dataType="com.reprezen.rapidml.RealizationModel"
	 * @generated
	 */
	RealizationModel getRealizationModel();

} // RealizationModelLocation
