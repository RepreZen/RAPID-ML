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
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.reprezen.rapidml.Element#getCardinality <em>Cardinality</em>}</li>
 * </ul>
 *
 * @see com.reprezen.rapidml.RapidmlPackage#getElement()
 * @model abstract="true"
 * @generated
 */
public interface Element extends EObject {
	/**
	 * Returns the value of the '<em><b>Cardinality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cardinality</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cardinality</em>' attribute.
	 * @see #setCardinality(int[])
	 * @see com.reprezen.rapidml.RapidmlPackage#getElement_Cardinality()
	 * @model dataType="com.reprezen.rapidml.Cardinality"
	 * @generated
	 */
	int[] getCardinality();

	/**
	 * Sets the value of the '{@link com.reprezen.rapidml.Element#getCardinality <em>Cardinality</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cardinality</em>' attribute.
	 * @see #getCardinality()
	 * @generated
	 */
	void setCardinality(int[] value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if (getCardinality() == null || getCardinality().length != 2) {\n     return 1;\n}\nreturn getCardinality()[0];'"
	 * @generated
	 */
	int getMinOccurs();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if (getCardinality() == null || getCardinality().length != 2) {\n     return 1;\n}\nreturn getCardinality()[1];'"
	 * @generated
	 */
	int getMaxOccurs();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	Structure getDataType();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return (1 &lt; getMaxOccurs()) || (-1 == getMaxOccurs());'"
	 * @generated
	 */
	boolean isMultiValued();

} // Element
