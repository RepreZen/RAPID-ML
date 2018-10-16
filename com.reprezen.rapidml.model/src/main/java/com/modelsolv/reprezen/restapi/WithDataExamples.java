/**
 * Copyright © 2013-2016 Modelsolv, Inc.
 * All Rights Reserved.
 * 
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 */
package com.modelsolv.reprezen.restapi;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>With Data Examples</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.modelsolv.reprezen.restapi.WithDataExamples#getDataExamples <em>Data Examples</em>}</li>
 * </ul>
 *
 * @see com.modelsolv.reprezen.restapi.RestapiPackage#getWithDataExamples()
 * @model abstract="true"
 * @generated
 */
public interface WithDataExamples extends EObject {
	/**
	 * Returns the value of the '<em><b>Data Examples</b></em>' containment reference list.
	 * The list contents are of type {@link com.modelsolv.reprezen.restapi.DataExample}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Examples</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Examples</em>' containment reference list.
	 * @see com.modelsolv.reprezen.restapi.RestapiPackage#getWithDataExamples_DataExamples()
	 * @model containment="true"
	 * @generated
	 */
	EList<DataExample> getDataExamples();

} // WithDataExamples
