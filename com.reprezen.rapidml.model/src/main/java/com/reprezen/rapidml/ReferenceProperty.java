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
 * <!-- begin-user-doc --> A representation of the model object
 * '<em><b>Reference Property</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.reprezen.rapidml.ReferenceProperty#getType <em>Type</em>}</li>
 * <li>{@link com.reprezen.rapidml.ReferenceProperty#getInverse
 * <em>Inverse</em>}</li>
 * <li>{@link com.reprezen.rapidml.ReferenceProperty#isContainment
 * <em>Containment</em>}</li>
 * <li>{@link com.reprezen.rapidml.ReferenceProperty#isContainer
 * <em>Container</em>}</li>
 * </ul>
 *
 * @see com.reprezen.rapidml.RapidmlPackage#getReferenceProperty()
 * @model
 * @generated
 */
public interface ReferenceProperty extends Feature, ReferenceElement {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(Structure)
	 * @see com.reprezen.rapidml.RapidmlPackage#getReferenceProperty_Type()
	 * @model required="true"
	 * @generated
	 */
	Structure getType();

	/**
	 * Sets the value of the '{@link com.reprezen.rapidml.ReferenceProperty#getType
	 * <em>Type</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(Structure value);

	/**
	 * Returns the value of the '<em><b>Inverse</b></em>' reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inverse</em>' reference isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Inverse</em>' reference.
	 * @see #setInverse(ReferenceProperty)
	 * @see com.reprezen.rapidml.RapidmlPackage#getReferenceProperty_Inverse()
	 * @model
	 * @generated
	 */
	ReferenceProperty getInverse();

	/**
	 * Sets the value of the
	 * '{@link com.reprezen.rapidml.ReferenceProperty#getInverse <em>Inverse</em>}'
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Inverse</em>' reference.
	 * @see #getInverse()
	 * @generated
	 */
	void setInverse(ReferenceProperty value);

	/**
	 * Returns the value of the '<em><b>Containment</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Containment</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Containment</em>' attribute.
	 * @see #setContainment(boolean)
	 * @see com.reprezen.rapidml.RapidmlPackage#getReferenceProperty_Containment()
	 * @model
	 * @generated
	 */
	boolean isContainment();

	/**
	 * Sets the value of the
	 * '{@link com.reprezen.rapidml.ReferenceProperty#isContainment
	 * <em>Containment</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *            the new value of the '<em>Containment</em>' attribute.
	 * @see #isContainment()
	 * @generated
	 */
	void setContainment(boolean value);

	/**
	 * Returns the value of the '<em><b>Container</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Container</em>' attribute.
	 * @see #setContainer(boolean)
	 * @see com.reprezen.rapidml.RapidmlPackage#getReferenceProperty_Container()
	 * @model
	 * @generated
	 */
	boolean isContainer();

	/**
	 * Sets the value of the
	 * '{@link com.reprezen.rapidml.ReferenceProperty#isContainer
	 * <em>Container</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Container</em>' attribute.
	 * @see #isContainer()
	 * @generated
	 */
	void setContainer(boolean value);

} // ReferenceProperty
