/**
 * Copyright © 2013-2016 Modelsolv, Inc.
 * All Rights Reserved.
 * 
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 */
package com.modelsolv.reprezen.rapidml;

import com.modelsolv.reprezen.rapidml.Constraint;
import com.modelsolv.reprezen.rapidml.PrimitiveType;
import com.modelsolv.reprezen.rapidml.SingleValueType;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Source Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.modelsolv.reprezen.rapidml.SourceReference#getContainingParameter <em>Containing Parameter</em>}</li>
 * </ul>
 *
 * @see com.modelsolv.reprezen.rapidml.RapidmlPackage#getSourceReference()
 * @model abstract="true"
 * @generated
 */
public interface SourceReference extends EObject {
	/**
	 * Returns the value of the '<em><b>Containing Parameter</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link com.modelsolv.reprezen.rapidml.Parameter#getSourceReference <em>Source Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Containing Parameter</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Containing Parameter</em>' container reference.
	 * @see #setContainingParameter(Parameter)
	 * @see com.modelsolv.reprezen.rapidml.RapidmlPackage#getSourceReference_ContainingParameter()
	 * @see com.modelsolv.reprezen.rapidml.Parameter#getSourceReference
	 * @model opposite="sourceReference" transient="false"
	 * @generated
	 */
	Parameter getContainingParameter();

	/**
	 * Sets the value of the '{@link com.modelsolv.reprezen.rapidml.SourceReference#getContainingParameter <em>Containing Parameter</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Containing Parameter</em>' container reference.
	 * @see #getContainingParameter()
	 * @generated
	 */
	void setContainingParameter(Parameter value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	com.modelsolv.reprezen.rapidml.SingleValueType getType();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<com.modelsolv.reprezen.rapidml.Constraint> getConstraints();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	com.modelsolv.reprezen.rapidml.PrimitiveType getPrimitiveType();

} // SourceReference
