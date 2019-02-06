/**
 * Copyright © 2013-2016 Modelsolv, Inc.
 * All Rights Reserved.
 * 
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 */
package com.reprezen.rapidml;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>User
 * Defined Type</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.reprezen.rapidml.UserDefinedType#getBaseType <em>Base
 * Type</em>}</li>
 * </ul>
 *
 * @see com.reprezen.rapidml.RapidmlPackage#getUserDefinedType()
 * @model
 * @generated
 */
public interface UserDefinedType extends SimpleType, ConstrainableType {
	/**
	 * Returns the value of the '<em><b>Base Type</b></em>' reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Type</em>' reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Base Type</em>' reference.
	 * @see #setBaseType(SimpleType)
	 * @see com.reprezen.rapidml.RapidmlPackage#getUserDefinedType_BaseType()
	 * @model required="true"
	 * @generated
	 */
	SimpleType getBaseType();

	/**
	 * Sets the value of the
	 * '{@link com.reprezen.rapidml.UserDefinedType#getBaseType <em>Base Type</em>}'
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Base Type</em>' reference.
	 * @see #getBaseType()
	 * @generated
	 */
	void setBaseType(SimpleType value);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model kind="operation" annotation="http://www.eclipse.org/emf/2002/GenModel
	 *        body='return getBaseType().getPrimitiveType();'"
	 * @generated
	 */
	PrimitiveType getPrimitiveType();

} // UserDefinedType
