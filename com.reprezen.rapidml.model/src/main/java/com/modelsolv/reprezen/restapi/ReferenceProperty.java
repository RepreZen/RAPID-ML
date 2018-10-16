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
 * A representation of the model object '<em><b>Reference Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.modelsolv.reprezen.restapi.ReferenceProperty#getType <em>Type</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.restapi.ReferenceProperty#getInverse <em>Inverse</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.restapi.ReferenceProperty#isContainment <em>Containment</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.restapi.ReferenceProperty#isContainer <em>Container</em>}</li>
 * </ul>
 *
 * @see com.modelsolv.reprezen.restapi.RestapiPackage#getReferenceProperty()
 * @model
 * @generated
 */
public interface ReferenceProperty extends Feature, ReferenceElement {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(Structure)
	 * @see com.modelsolv.reprezen.restapi.RestapiPackage#getReferenceProperty_Type()
	 * @model required="true"
	 * @generated
	 */
	Structure getType();

	/**
	 * Sets the value of the '{@link com.modelsolv.reprezen.restapi.ReferenceProperty#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(Structure value);

	/**
	 * Returns the value of the '<em><b>Inverse</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inverse</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inverse</em>' reference.
	 * @see #setInverse(ReferenceProperty)
	 * @see com.modelsolv.reprezen.restapi.RestapiPackage#getReferenceProperty_Inverse()
	 * @model
	 * @generated
	 */
	ReferenceProperty getInverse();

	/**
	 * Sets the value of the '{@link com.modelsolv.reprezen.restapi.ReferenceProperty#getInverse <em>Inverse</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inverse</em>' reference.
	 * @see #getInverse()
	 * @generated
	 */
	void setInverse(ReferenceProperty value);

	/**
	 * Returns the value of the '<em><b>Containment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Containment</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Containment</em>' attribute.
	 * @see #setContainment(boolean)
	 * @see com.modelsolv.reprezen.restapi.RestapiPackage#getReferenceProperty_Containment()
	 * @model
	 * @generated
	 */
	boolean isContainment();

	/**
	 * Sets the value of the '{@link com.modelsolv.reprezen.restapi.ReferenceProperty#isContainment <em>Containment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Containment</em>' attribute.
	 * @see #isContainment()
	 * @generated
	 */
	void setContainment(boolean value);

	/**
	 * Returns the value of the '<em><b>Container</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container</em>' attribute.
	 * @see #setContainer(boolean)
	 * @see com.modelsolv.reprezen.restapi.RestapiPackage#getReferenceProperty_Container()
	 * @model
	 * @generated
	 */
	boolean isContainer();

	/**
	 * Sets the value of the '{@link com.modelsolv.reprezen.restapi.ReferenceProperty#isContainer <em>Container</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container</em>' attribute.
	 * @see #isContainer()
	 * @generated
	 */
	void setContainer(boolean value);

} // ReferenceProperty
