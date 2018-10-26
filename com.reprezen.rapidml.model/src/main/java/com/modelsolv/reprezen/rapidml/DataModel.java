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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.modelsolv.reprezen.rapidml.DataModel#getOwnedDataTypes <em>Owned Data Types</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.rapidml.DataModel#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see com.modelsolv.reprezen.rapidml.RapidmlPackage#getDataModel()
 * @model
 * @generated
 */
public interface DataModel extends Documentable, HasTitle {
	/**
	 * Returns the value of the '<em><b>Owned Data Types</b></em>' containment reference list.
	 * The list contents are of type {@link com.modelsolv.reprezen.rapidml.DataType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Data Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Data Types</em>' containment reference list.
	 * @see com.modelsolv.reprezen.rapidml.RapidmlPackage#getDataModel_OwnedDataTypes()
	 * @model containment="true"
	 * @generated
	 */
	EList<DataType> getOwnedDataTypes();

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
	 * @see com.modelsolv.reprezen.rapidml.RapidmlPackage#getDataModel_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.modelsolv.reprezen.rapidml.DataModel#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // DataModel
