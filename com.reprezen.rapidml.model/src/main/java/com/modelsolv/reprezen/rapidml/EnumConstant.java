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
 * A representation of the model object '<em><b>Enum Constant</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.modelsolv.reprezen.rapidml.EnumConstant#getName <em>Name</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.rapidml.EnumConstant#getIntegerValue <em>Integer Value</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.rapidml.EnumConstant#getLiteralValue <em>Literal Value</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.rapidml.EnumConstant#getEnumeration <em>Enumeration</em>}</li>
 * </ul>
 *
 * @see com.modelsolv.reprezen.rapidml.RapidmlPackage#getEnumConstant()
 * @model
 * @generated
 */
public interface EnumConstant extends Documentable {
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
	 * @see com.modelsolv.reprezen.rapidml.RapidmlPackage#getEnumConstant_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.modelsolv.reprezen.rapidml.EnumConstant#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Integer Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Integer Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Integer Value</em>' attribute.
	 * @see #isSetIntegerValue()
	 * @see #unsetIntegerValue()
	 * @see #setIntegerValue(int)
	 * @see com.modelsolv.reprezen.rapidml.RapidmlPackage#getEnumConstant_IntegerValue()
	 * @model unsettable="true"
	 * @generated
	 */
	int getIntegerValue();

	/**
	 * Sets the value of the '{@link com.modelsolv.reprezen.rapidml.EnumConstant#getIntegerValue <em>Integer Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Integer Value</em>' attribute.
	 * @see #isSetIntegerValue()
	 * @see #unsetIntegerValue()
	 * @see #getIntegerValue()
	 * @generated
	 */
	void setIntegerValue(int value);

	/**
	 * Unsets the value of the '{@link com.modelsolv.reprezen.rapidml.EnumConstant#getIntegerValue <em>Integer Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIntegerValue()
	 * @see #getIntegerValue()
	 * @see #setIntegerValue(int)
	 * @generated
	 */
	void unsetIntegerValue();

	/**
	 * Returns whether the value of the '{@link com.modelsolv.reprezen.rapidml.EnumConstant#getIntegerValue <em>Integer Value</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Integer Value</em>' attribute is set.
	 * @see #unsetIntegerValue()
	 * @see #getIntegerValue()
	 * @see #setIntegerValue(int)
	 * @generated
	 */
	boolean isSetIntegerValue();

	/**
	 * Returns the value of the '<em><b>Literal Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Literal Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Literal Value</em>' attribute.
	 * @see #setLiteralValue(String)
	 * @see com.modelsolv.reprezen.rapidml.RapidmlPackage#getEnumConstant_LiteralValue()
	 * @model
	 * @generated
	 */
	String getLiteralValue();

	/**
	 * Sets the value of the '{@link com.modelsolv.reprezen.rapidml.EnumConstant#getLiteralValue <em>Literal Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Literal Value</em>' attribute.
	 * @see #getLiteralValue()
	 * @generated
	 */
	void setLiteralValue(String value);

	/**
	 * Returns the value of the '<em><b>Enumeration</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link com.modelsolv.reprezen.rapidml.Enumeration#getEnumConstants <em>Enum Constants</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enumeration</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enumeration</em>' container reference.
	 * @see #setEnumeration(Enumeration)
	 * @see com.modelsolv.reprezen.rapidml.RapidmlPackage#getEnumConstant_Enumeration()
	 * @see com.modelsolv.reprezen.rapidml.Enumeration#getEnumConstants
	 * @model opposite="enumConstants" transient="false"
	 * @generated
	 */
	Enumeration getEnumeration();

	/**
	 * Sets the value of the '{@link com.modelsolv.reprezen.rapidml.EnumConstant#getEnumeration <em>Enumeration</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enumeration</em>' container reference.
	 * @see #getEnumeration()
	 * @generated
	 */
	void setEnumeration(Enumeration value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return getEnumeration().getEnumConstants().indexOf(this);'"
	 * @generated
	 */
	int getImplicitIntegerValue();

} // EnumConstant
