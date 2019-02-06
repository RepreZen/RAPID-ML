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
 * '<em><b>Constrainable Type</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.reprezen.rapidml.ConstrainableType#getConstraints
 * <em>Constraints</em>}</li>
 * </ul>
 *
 * @see com.reprezen.rapidml.RapidmlPackage#getConstrainableType()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface ConstrainableType extends Extensible {
	/**
	 * Returns the value of the '<em><b>Constraints</b></em>' containment reference
	 * list. The list contents are of type {@link com.reprezen.rapidml.Constraint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraints</em>' containment reference list isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Constraints</em>' containment reference list.
	 * @see com.reprezen.rapidml.RapidmlPackage#getConstrainableType_Constraints()
	 * @model containment="true"
	 * @generated
	 */
	EList<Constraint> getConstraints();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model kind="operation" annotation="http://www.eclipse.org/emf/2002/GenModel
	 *        body='return
	 *        com.reprezen.rapidml.datatypes.util.ConstraintsUtils.getConstrainableParent(this);'"
	 * @generated
	 */
	ConstrainableType getConstrainableParent();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model kind="operation" annotation="http://www.eclipse.org/emf/2002/GenModel
	 *        body='ConstraintProcessor.addParentConstraints(this);\nreturn
	 *        getConstraints();'"
	 * @generated
	 */
	EList<Constraint> getAllConstraints();

} // ConstrainableType
