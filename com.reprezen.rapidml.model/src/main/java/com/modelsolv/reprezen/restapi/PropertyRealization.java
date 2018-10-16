/**
 * Copyright © 2013-2016 Modelsolv, Inc.
 * All Rights Reserved.
 * 
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 */
package com.modelsolv.reprezen.restapi;

import com.modelsolv.reprezen.restapi.ConstrainableType;
import com.modelsolv.reprezen.restapi.Feature;
import com.modelsolv.reprezen.restapi.PrimitiveType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Realization</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.modelsolv.reprezen.restapi.PropertyRealization#getBaseProperty <em>Base Property</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.restapi.PropertyRealization#getCardinality <em>Cardinality</em>}</li>
 * </ul>
 *
 * @see com.modelsolv.reprezen.restapi.RestapiPackage#getPropertyRealization()
 * @model
 * @generated
 */
public interface PropertyRealization extends com.modelsolv.reprezen.restapi.ConstrainableType {
	/**
	 * Returns the value of the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Property</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Property</em>' reference.
	 * @see #setBaseProperty(com.modelsolv.reprezen.restapi.Feature)
	 * @see com.modelsolv.reprezen.restapi.RestapiPackage#getPropertyRealization_BaseProperty()
	 * @model required="true"
	 * @generated
	 */
	com.modelsolv.reprezen.restapi.Feature getBaseProperty();

	/**
	 * Sets the value of the '{@link com.modelsolv.reprezen.restapi.PropertyRealization#getBaseProperty <em>Base Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Property</em>' reference.
	 * @see #getBaseProperty()
	 * @generated
	 */
	void setBaseProperty(com.modelsolv.reprezen.restapi.Feature value);

	/**
	 * Returns the value of the '<em><b>Cardinality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cardinality</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cardinality</em>' attribute.
	 * @see #setCardinality(int[])
	 * @see com.modelsolv.reprezen.restapi.RestapiPackage#getPropertyRealization_Cardinality()
	 * @model dataType="com.modelsolv.reprezen.restapi.CardinalityOverride"
	 * @generated
	 */
	int[] getCardinality();

	/**
	 * Sets the value of the '{@link com.modelsolv.reprezen.restapi.PropertyRealization#getCardinality <em>Cardinality</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cardinality</em>' attribute.
	 * @see #getCardinality()
	 * @generated
	 */
	void setCardinality(int[] value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if (getCardinality() == null || getCardinality().length != 2) {\n     return getBaseProperty().getMinOccurs();\n}\nreturn getCardinality()[0];'"
	 * @generated
	 */
	int getMinOccurs();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if (getCardinality() == null || getCardinality().length != 2) {\n     return getBaseProperty().getMaxOccurs();\n}\nreturn getCardinality()[1];'"
	 * @generated
	 */
	int getMaxOccurs();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if (getBaseProperty() instanceof PrimitiveProperty) {\n    return ((PrimitiveProperty) getBaseProperty()).getPrimitiveType();\n}\nreturn null;'"
	 * @generated
	 */
	com.modelsolv.reprezen.restapi.PrimitiveType getPrimitiveType();

} // PropertyRealization
