/**
 * Copyright © 2013-2016 Modelsolv, Inc.
 * All Rights Reserved.
 * 
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 */
package com.modelsolv.reprezen.rapidml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.modelsolv.reprezen.rapidml.CollectionParameter#getContainingResourceDefinition <em>Containing Resource Definition</em>}</li>
 * </ul>
 *
 * @see com.modelsolv.reprezen.rapidml.RapidmlPackage#getCollectionParameter()
 * @model
 * @generated
 */
public interface CollectionParameter extends Parameter {
	/**
	 * Returns the value of the '<em><b>Containing Resource Definition</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link com.modelsolv.reprezen.rapidml.CollectionResource#getCollectionParameters <em>Collection Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Containing Resource Definition</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Containing Resource Definition</em>' container reference.
	 * @see #setContainingResourceDefinition(CollectionResource)
	 * @see com.modelsolv.reprezen.rapidml.RapidmlPackage#getCollectionParameter_ContainingResourceDefinition()
	 * @see com.modelsolv.reprezen.rapidml.CollectionResource#getCollectionParameters
	 * @model opposite="collectionParameters" transient="false"
	 * @generated
	 */
	CollectionResource getContainingResourceDefinition();

	/**
	 * Sets the value of the '{@link com.modelsolv.reprezen.rapidml.CollectionParameter#getContainingResourceDefinition <em>Containing Resource Definition</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Containing Resource Definition</em>' container reference.
	 * @see #getContainingResourceDefinition()
	 * @generated
	 */
	void setContainingResourceDefinition(CollectionResource value);

} // CollectionParameter
