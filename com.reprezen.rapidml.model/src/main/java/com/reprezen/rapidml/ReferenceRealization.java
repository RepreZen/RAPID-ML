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
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference Realization</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.reprezen.rapidml.ReferenceRealization#getTargetResource <em>Target Resource</em>}</li>
 *   <li>{@link com.reprezen.rapidml.ReferenceRealization#getRealizationType <em>Realization Type</em>}</li>
 *   <li>{@link com.reprezen.rapidml.ReferenceRealization#isMultiValued <em>Multi Valued</em>}</li>
 * </ul>
 *
 * @see com.reprezen.rapidml.RapidmlPackage#getReferenceRealization()
 * @model
 * @generated
 */
public interface ReferenceRealization extends RealizationContainer {
	/**
	 * Returns the value of the '<em><b>Target Resource</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Resource</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Resource</em>' reference.
	 * @see #setTargetResource(ResourceDefinition)
	 * @see com.reprezen.rapidml.RapidmlPackage#getReferenceRealization_TargetResource()
	 * @model
	 * @generated
	 */
	ResourceDefinition getTargetResource();

	/**
	 * Sets the value of the '{@link com.reprezen.rapidml.ReferenceRealization#getTargetResource <em>Target Resource</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Resource</em>' reference.
	 * @see #getTargetResource()
	 * @generated
	 */
	void setTargetResource(ResourceDefinition value);

	/**
	 * Returns the value of the '<em><b>Realization Type</b></em>' attribute.
	 * The literals are from the enumeration {@link com.reprezen.rapidml.ReferenceRealizationEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Realization Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Realization Type</em>' attribute.
	 * @see com.reprezen.rapidml.ReferenceRealizationEnum
	 * @see #setRealizationType(ReferenceRealizationEnum)
	 * @see com.reprezen.rapidml.RapidmlPackage#getReferenceRealization_RealizationType()
	 * @model
	 * @generated
	 */
	ReferenceRealizationEnum getRealizationType();

	/**
	 * Sets the value of the '{@link com.reprezen.rapidml.ReferenceRealization#getRealizationType <em>Realization Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Realization Type</em>' attribute.
	 * @see com.reprezen.rapidml.ReferenceRealizationEnum
	 * @see #getRealizationType()
	 * @generated
	 */
	void setRealizationType(ReferenceRealizationEnum value);

	/**
	 * Returns the value of the '<em><b>Multi Valued</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Multi Valued</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Multi Valued</em>' attribute.
	 * @see #setMultiValued(boolean)
	 * @see com.reprezen.rapidml.RapidmlPackage#getReferenceRealization_MultiValued()
	 * @model default="false"
	 * @generated
	 */
	boolean isMultiValued();

	/**
	 * Sets the value of the '{@link com.reprezen.rapidml.ReferenceRealization#isMultiValued <em>Multi Valued</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Multi Valued</em>' attribute.
	 * @see #isMultiValued()
	 * @generated
	 */
	void setMultiValued(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	ObjectRealization getLinkDescriptor();

} // ReferenceRealization
