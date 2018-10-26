/**
 * Copyright © 2013-2016 Modelsolv, Inc.
 * All Rights Reserved.
 * 
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 */
package com.modelsolv.reprezen.rapidml;

import com.modelsolv.reprezen.realization.processor.EffectiveRealization;

import com.modelsolv.reprezen.rapidml.Structure;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Realization Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.modelsolv.reprezen.rapidml.RealizationContainer#isWithDefaultRealization <em>With Default Realization</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.rapidml.RealizationContainer#getInlineObjectRealization <em>Inline Object Realization</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.rapidml.RealizationContainer#getProperties <em>Properties</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.rapidml.RealizationContainer#getReferenceTreatments <em>Reference Treatments</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.rapidml.RealizationContainer#getDataType <em>Data Type</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.rapidml.RealizationContainer#getRealizationName <em>Realization Name</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.rapidml.RealizationContainer#getEffectiveRealization <em>Effective Realization</em>}</li>
 * </ul>
 *
 * @see com.modelsolv.reprezen.rapidml.RapidmlPackage#getRealizationContainer()
 * @model abstract="true"
 * @generated
 */
public interface RealizationContainer extends Extensible {
	/**
	 * Returns the value of the '<em><b>With Default Realization</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>With Default Realization</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>With Default Realization</em>' attribute.
	 * @see #setWithDefaultRealization(boolean)
	 * @see com.modelsolv.reprezen.rapidml.RapidmlPackage#getRealizationContainer_WithDefaultRealization()
	 * @model transient="true"
	 * @generated
	 */
	boolean isWithDefaultRealization();

	/**
	 * Sets the value of the '{@link com.modelsolv.reprezen.rapidml.RealizationContainer#isWithDefaultRealization <em>With Default Realization</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>With Default Realization</em>' attribute.
	 * @see #isWithDefaultRealization()
	 * @generated
	 */
	void setWithDefaultRealization(boolean value);

	/**
	 * Returns the value of the '<em><b>Inline Object Realization</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link com.modelsolv.reprezen.rapidml.ObjectRealization#getRealizationContainer <em>Realization Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inline Object Realization</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inline Object Realization</em>' containment reference.
	 * @see #setInlineObjectRealization(ObjectRealization)
	 * @see com.modelsolv.reprezen.rapidml.RapidmlPackage#getRealizationContainer_InlineObjectRealization()
	 * @see com.modelsolv.reprezen.rapidml.ObjectRealization#getRealizationContainer
	 * @model opposite="realizationContainer" containment="true"
	 * @generated
	 */
	ObjectRealization getInlineObjectRealization();

	/**
	 * Sets the value of the '{@link com.modelsolv.reprezen.rapidml.RealizationContainer#getInlineObjectRealization <em>Inline Object Realization</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inline Object Realization</em>' containment reference.
	 * @see #getInlineObjectRealization()
	 * @generated
	 */
	void setInlineObjectRealization(ObjectRealization value);

	/**
	 * Returns the value of the '<em><b>Properties</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' reference.
	 * @see #setProperties(ObjectRealization)
	 * @see com.modelsolv.reprezen.rapidml.RapidmlPackage#getRealizationContainer_Properties()
	 * @model
	 * @generated
	 */
	ObjectRealization getProperties();

	/**
	 * Sets the value of the '{@link com.modelsolv.reprezen.rapidml.RealizationContainer#getProperties <em>Properties</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Properties</em>' reference.
	 * @see #getProperties()
	 * @generated
	 */
	void setProperties(ObjectRealization value);

	/**
	 * Returns the value of the '<em><b>Reference Treatments</b></em>' containment reference list.
	 * The list contents are of type {@link com.modelsolv.reprezen.rapidml.ReferenceTreatment}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reference Treatments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reference Treatments</em>' containment reference list.
	 * @see com.modelsolv.reprezen.rapidml.RapidmlPackage#getRealizationContainer_ReferenceTreatments()
	 * @model containment="true"
	 * @generated
	 */
	EList<ReferenceTreatment> getReferenceTreatments();

	/**
	 * Returns the value of the '<em><b>Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Type</em>' reference.
	 * @see #setDataType(com.modelsolv.reprezen.rapidml.Structure)
	 * @see com.modelsolv.reprezen.rapidml.RapidmlPackage#getRealizationContainer_DataType()
	 * @model
	 * @generated
	 */
	com.modelsolv.reprezen.rapidml.Structure getDataType();

	/**
	 * Sets the value of the '{@link com.modelsolv.reprezen.rapidml.RealizationContainer#getDataType <em>Data Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Type</em>' reference.
	 * @see #getDataType()
	 * @generated
	 */
	void setDataType(com.modelsolv.reprezen.rapidml.Structure value);

	/**
	 * Returns the value of the '<em><b>Realization Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Realization Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Realization Name</em>' attribute.
	 * @see #setRealizationName(String)
	 * @see com.modelsolv.reprezen.rapidml.RapidmlPackage#getRealizationContainer_RealizationName()
	 * @model
	 * @generated
	 */
	String getRealizationName();

	/**
	 * Sets the value of the '{@link com.modelsolv.reprezen.rapidml.RealizationContainer#getRealizationName <em>Realization Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Realization Name</em>' attribute.
	 * @see #getRealizationName()
	 * @generated
	 */
	void setRealizationName(String value);

	/**
	 * Returns the value of the '<em><b>Effective Realization</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Effective Realization</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Effective Realization</em>' attribute.
	 * @see #setEffectiveRealization(EffectiveRealization)
	 * @see com.modelsolv.reprezen.rapidml.RapidmlPackage#getRealizationContainer_EffectiveRealization()
	 * @model dataType="com.modelsolv.reprezen.rapidml.EffectiveRealization"
	 * @generated
	 */
	EffectiveRealization getEffectiveRealization();

	/**
	 * Sets the value of the '{@link com.modelsolv.reprezen.rapidml.RealizationContainer#getEffectiveRealization <em>Effective Realization</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Effective Realization</em>' attribute.
	 * @see #getEffectiveRealization()
	 * @generated
	 */
	void setEffectiveRealization(EffectiveRealization value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	com.modelsolv.reprezen.rapidml.Structure getActualType();

} // RealizationContainer
