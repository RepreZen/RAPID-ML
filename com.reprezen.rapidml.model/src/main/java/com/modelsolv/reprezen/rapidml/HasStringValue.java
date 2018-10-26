/**
 * Copyright © 2013-2016 Modelsolv, Inc.
 * All Rights Reserved.
 * 
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 */
package com.modelsolv.reprezen.rapidml;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Has String Value</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see com.modelsolv.reprezen.rapidml.RapidmlPackage#getHasStringValue()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface HasStringValue extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='if (eIsProxy()) {\r\n\treturn super.toString();\r\n}\r\nStringBuffer result = new StringBuffer(super.toString());\r\nreturn com.modelsolv.reprezen.rapidml.util.RapidmlModelUtils.getStringValue(this, result);'"
	 * @generated
	 */
	String toString();

} // HasStringValue
