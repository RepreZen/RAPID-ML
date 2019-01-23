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
 * <!-- begin-user-doc --> A representation of the model object
 * '<em><b>Primitive Type Source Reference</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.reprezen.rapidml.PrimitiveTypeSourceReference#getSimpleType
 * <em>Simple Type</em>}</li>
 * </ul>
 *
 * @see com.reprezen.rapidml.RapidmlPackage#getPrimitiveTypeSourceReference()
 * @model
 * @generated
 */
public interface PrimitiveTypeSourceReference extends SourceReference {
	/**
	 * Returns the value of the '<em><b>Simple Type</b></em>' reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Simple Type</em>' reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Simple Type</em>' reference.
	 * @see #setSimpleType(com.reprezen.rapidml.PrimitiveType)
	 * @see com.reprezen.rapidml.RapidmlPackage#getPrimitiveTypeSourceReference_SimpleType()
	 * @model
	 * @generated
	 */
	com.reprezen.rapidml.PrimitiveType getSimpleType();

	/**
	 * Sets the value of the
	 * '{@link com.reprezen.rapidml.PrimitiveTypeSourceReference#getSimpleType
	 * <em>Simple Type</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *            the new value of the '<em>Simple Type</em>' reference.
	 * @see #getSimpleType()
	 * @generated
	 */
	void setSimpleType(com.reprezen.rapidml.PrimitiveType value);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model kind="operation" annotation="http://www.eclipse.org/emf/2002/GenModel
	 *        body='return getSimpleType();'"
	 * @generated
	 */
	com.reprezen.rapidml.SingleValueType getType();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model kind="operation" annotation="http://www.eclipse.org/emf/2002/GenModel
	 *        body='if (getSimpleType() instanceof ConstrainableType) {\n return
	 *        ((ConstrainableType)getSimpleType()).getConstraints();\n}\nreturn
	 *        ECollections.emptyEList();'"
	 * @generated
	 */
	EList<com.reprezen.rapidml.Constraint> getConstraints();

} // PrimitiveTypeSourceReference
