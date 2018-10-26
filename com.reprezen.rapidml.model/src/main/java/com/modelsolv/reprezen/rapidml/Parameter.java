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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.modelsolv.reprezen.rapidml.Parameter#getName <em>Name</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.rapidml.Parameter#isRequired <em>Required</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.rapidml.Parameter#getDefault <em>Default</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.rapidml.Parameter#getFixed <em>Fixed</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.rapidml.Parameter#getSourceReference <em>Source Reference</em>}</li>
 * </ul>
 *
 * @see com.modelsolv.reprezen.rapidml.RapidmlPackage#getParameter()
 * @model abstract="true"
 * @generated
 */
public interface Parameter extends RESTElement, Extensible {
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
	 * @see com.modelsolv.reprezen.rapidml.RapidmlPackage#getParameter_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.modelsolv.reprezen.rapidml.Parameter#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Required</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required</em>' attribute.
	 * @see #setRequired(boolean)
	 * @see com.modelsolv.reprezen.rapidml.RapidmlPackage#getParameter_Required()
	 * @model
	 * @generated
	 */
	boolean isRequired();

	/**
	 * Sets the value of the '{@link com.modelsolv.reprezen.rapidml.Parameter#isRequired <em>Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Required</em>' attribute.
	 * @see #isRequired()
	 * @generated
	 */
	void setRequired(boolean value);

	/**
	 * Returns the value of the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default</em>' attribute.
	 * @see #setDefault(String)
	 * @see com.modelsolv.reprezen.rapidml.RapidmlPackage#getParameter_Default()
	 * @model
	 * @generated
	 */
	String getDefault();

	/**
	 * Sets the value of the '{@link com.modelsolv.reprezen.rapidml.Parameter#getDefault <em>Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default</em>' attribute.
	 * @see #getDefault()
	 * @generated
	 */
	void setDefault(String value);

	/**
	 * Returns the value of the '<em><b>Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fixed</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fixed</em>' attribute.
	 * @see #setFixed(String)
	 * @see com.modelsolv.reprezen.rapidml.RapidmlPackage#getParameter_Fixed()
	 * @model
	 * @generated
	 */
	String getFixed();

	/**
	 * Sets the value of the '{@link com.modelsolv.reprezen.rapidml.Parameter#getFixed <em>Fixed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fixed</em>' attribute.
	 * @see #getFixed()
	 * @generated
	 */
	void setFixed(String value);

	/**
	 * Returns the value of the '<em><b>Source Reference</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link com.modelsolv.reprezen.rapidml.SourceReference#getContainingParameter <em>Containing Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Reference</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Reference</em>' containment reference.
	 * @see #setSourceReference(SourceReference)
	 * @see com.modelsolv.reprezen.rapidml.RapidmlPackage#getParameter_SourceReference()
	 * @see com.modelsolv.reprezen.rapidml.SourceReference#getContainingParameter
	 * @model opposite="containingParameter" containment="true"
	 * @generated
	 */
	SourceReference getSourceReference();

	/**
	 * Sets the value of the '{@link com.modelsolv.reprezen.rapidml.Parameter#getSourceReference <em>Source Reference</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Reference</em>' containment reference.
	 * @see #getSourceReference()
	 * @generated
	 */
	void setSourceReference(SourceReference value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return getSourceReference().getType();'"
	 * @generated
	 */
	com.modelsolv.reprezen.rapidml.SingleValueType getType();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return getType().getPrimitiveType();'"
	 * @generated
	 */
	com.modelsolv.reprezen.rapidml.PrimitiveType getPrimitiveType();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return getSourceReference().getConstraints();'"
	 * @generated
	 */
	EList<com.modelsolv.reprezen.rapidml.Constraint> getConstraints();

} // Parameter
