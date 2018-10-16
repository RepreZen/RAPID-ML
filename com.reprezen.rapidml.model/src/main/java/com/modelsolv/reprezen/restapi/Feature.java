/**
 * Copyright © 2013-2016 Modelsolv, Inc.
 * All Rights Reserved.
 * 
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 */
package com.modelsolv.reprezen.restapi;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.modelsolv.reprezen.restapi.Feature#getName <em>Name</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.restapi.Feature#getContainingDataType <em>Containing Data Type</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.restapi.Feature#isRestriction <em>Restriction</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.restapi.Feature#isReadOnly <em>Read Only</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.restapi.Feature#isKey <em>Key</em>}</li>
 * </ul>
 *
 * @see com.modelsolv.reprezen.restapi.RestapiPackage#getFeature()
 * @model abstract="true"
 * @generated
 */
public interface Feature extends Documentable, Element, Extensible {
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
	 * @see com.modelsolv.reprezen.restapi.RestapiPackage#getFeature_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.modelsolv.reprezen.restapi.Feature#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Containing Data Type</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link com.modelsolv.reprezen.restapi.Structure#getOwnedFeatures <em>Owned Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Containing Data Type</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Containing Data Type</em>' container reference.
	 * @see #setContainingDataType(Structure)
	 * @see com.modelsolv.reprezen.restapi.RestapiPackage#getFeature_ContainingDataType()
	 * @see com.modelsolv.reprezen.restapi.Structure#getOwnedFeatures
	 * @model opposite="ownedFeatures" transient="false"
	 * @generated
	 */
	Structure getContainingDataType();

	/**
	 * Sets the value of the '{@link com.modelsolv.reprezen.restapi.Feature#getContainingDataType <em>Containing Data Type</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Containing Data Type</em>' container reference.
	 * @see #getContainingDataType()
	 * @generated
	 */
	void setContainingDataType(Structure value);

	/**
	 * Returns the value of the '<em><b>Restriction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Restriction</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Restriction</em>' attribute.
	 * @see #setRestriction(boolean)
	 * @see com.modelsolv.reprezen.restapi.RestapiPackage#getFeature_Restriction()
	 * @model
	 * @generated
	 */
	boolean isRestriction();

	/**
	 * Sets the value of the '{@link com.modelsolv.reprezen.restapi.Feature#isRestriction <em>Restriction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Restriction</em>' attribute.
	 * @see #isRestriction()
	 * @generated
	 */
	void setRestriction(boolean value);

	/**
	 * Returns the value of the '<em><b>Read Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Read Only</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Read Only</em>' attribute.
	 * @see #setReadOnly(boolean)
	 * @see com.modelsolv.reprezen.restapi.RestapiPackage#getFeature_ReadOnly()
	 * @model
	 * @generated
	 */
	boolean isReadOnly();

	/**
	 * Sets the value of the '{@link com.modelsolv.reprezen.restapi.Feature#isReadOnly <em>Read Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Read Only</em>' attribute.
	 * @see #isReadOnly()
	 * @generated
	 */
	void setReadOnly(boolean value);

	/**
	 * Returns the value of the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Key</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Key</em>' attribute.
	 * @see #setKey(boolean)
	 * @see com.modelsolv.reprezen.restapi.RestapiPackage#getFeature_Key()
	 * @model
	 * @generated
	 */
	boolean isKey();

	/**
	 * Sets the value of the '{@link com.modelsolv.reprezen.restapi.Feature#isKey <em>Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Key</em>' attribute.
	 * @see #isKey()
	 * @generated
	 */
	void setKey(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if (getCardinality() == null || getCardinality().length != 2) {\r\n     //default value\r\n     return 0;\r\n}\r\nreturn getCardinality()[0];\r\n'"
	 * @generated
	 */
	int getMinOccurs();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if (getCardinality() == null || getCardinality().length != 2) {\n     //default value\n     return 1;\n}\nreturn getCardinality()[1];\n'"
	 * @generated
	 */
	int getMaxOccurs();

} // Feature
