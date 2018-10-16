/**
 * Copyright © 2013-2016 Modelsolv, Inc.
 * All Rights Reserved.
 * 
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 */
package com.modelsolv.reprezen.restapi;

import com.modelsolv.reprezen.restapi.Constraint;
import com.modelsolv.reprezen.restapi.PrimitiveProperty;
import com.modelsolv.reprezen.restapi.SingleValueType;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.modelsolv.reprezen.restapi.PropertyReference#getConceptualFeature <em>Conceptual Feature</em>}</li>
 * </ul>
 *
 * @see com.modelsolv.reprezen.restapi.RestapiPackage#getPropertyReference()
 * @model
 * @generated
 */
public interface PropertyReference extends SourceReference {
	/**
	 * Returns the value of the '<em><b>Conceptual Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Conceptual Feature</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Conceptual Feature</em>' reference.
	 * @see #setConceptualFeature(com.modelsolv.reprezen.restapi.PrimitiveProperty)
	 * @see com.modelsolv.reprezen.restapi.RestapiPackage#getPropertyReference_ConceptualFeature()
	 * @model
	 * @generated
	 */
	com.modelsolv.reprezen.restapi.PrimitiveProperty getConceptualFeature();

	/**
	 * Sets the value of the '{@link com.modelsolv.reprezen.restapi.PropertyReference#getConceptualFeature <em>Conceptual Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Conceptual Feature</em>' reference.
	 * @see #getConceptualFeature()
	 * @generated
	 */
	void setConceptualFeature(com.modelsolv.reprezen.restapi.PrimitiveProperty value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return getConceptualFeature().getType();'"
	 * @generated
	 */
	com.modelsolv.reprezen.restapi.SingleValueType getType();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return getConceptualFeature().getConstraints();'"
	 * @generated
	 */
	EList<com.modelsolv.reprezen.restapi.Constraint> getConstraints();

} // PropertyReference
