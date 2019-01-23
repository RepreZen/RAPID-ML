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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Value
 * Range Constraint</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link com.reprezen.rapidml.ValueRangeConstraint#getMinValue <em>Min
 * Value</em>}</li>
 * <li>{@link com.reprezen.rapidml.ValueRangeConstraint#isMinValueExclusive
 * <em>Min Value Exclusive</em>}</li>
 * <li>{@link com.reprezen.rapidml.ValueRangeConstraint#getMaxValue <em>Max
 * Value</em>}</li>
 * <li>{@link com.reprezen.rapidml.ValueRangeConstraint#isMaxValueExclusive
 * <em>Max Value Exclusive</em>}</li>
 * </ul>
 *
 * @see com.reprezen.rapidml.RapidmlPackage#getValueRangeConstraint()
 * @model
 * @generated
 */
public interface ValueRangeConstraint extends Constraint {
	/**
	 * Returns the value of the '<em><b>Min Value</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min Value</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Min Value</em>' attribute.
	 * @see #setMinValue(String)
	 * @see com.reprezen.rapidml.RapidmlPackage#getValueRangeConstraint_MinValue()
	 * @model
	 * @generated
	 */
	String getMinValue();

	/**
	 * Sets the value of the
	 * '{@link com.reprezen.rapidml.ValueRangeConstraint#getMinValue <em>Min
	 * Value</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Min Value</em>' attribute.
	 * @see #getMinValue()
	 * @generated
	 */
	void setMinValue(String value);

	/**
	 * Returns the value of the '<em><b>Min Value Exclusive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min Value Exclusive</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Min Value Exclusive</em>' attribute.
	 * @see #setMinValueExclusive(boolean)
	 * @see com.reprezen.rapidml.RapidmlPackage#getValueRangeConstraint_MinValueExclusive()
	 * @model
	 * @generated
	 */
	boolean isMinValueExclusive();

	/**
	 * Sets the value of the
	 * '{@link com.reprezen.rapidml.ValueRangeConstraint#isMinValueExclusive <em>Min
	 * Value Exclusive</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *            the new value of the '<em>Min Value Exclusive</em>' attribute.
	 * @see #isMinValueExclusive()
	 * @generated
	 */
	void setMinValueExclusive(boolean value);

	/**
	 * Returns the value of the '<em><b>Max Value</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Value</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Max Value</em>' attribute.
	 * @see #setMaxValue(String)
	 * @see com.reprezen.rapidml.RapidmlPackage#getValueRangeConstraint_MaxValue()
	 * @model
	 * @generated
	 */
	String getMaxValue();

	/**
	 * Sets the value of the
	 * '{@link com.reprezen.rapidml.ValueRangeConstraint#getMaxValue <em>Max
	 * Value</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Max Value</em>' attribute.
	 * @see #getMaxValue()
	 * @generated
	 */
	void setMaxValue(String value);

	/**
	 * Returns the value of the '<em><b>Max Value Exclusive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Value Exclusive</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Max Value Exclusive</em>' attribute.
	 * @see #setMaxValueExclusive(boolean)
	 * @see com.reprezen.rapidml.RapidmlPackage#getValueRangeConstraint_MaxValueExclusive()
	 * @model
	 * @generated
	 */
	boolean isMaxValueExclusive();

	/**
	 * Sets the value of the
	 * '{@link com.reprezen.rapidml.ValueRangeConstraint#isMaxValueExclusive <em>Max
	 * Value Exclusive</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *            the new value of the '<em>Max Value Exclusive</em>' attribute.
	 * @see #isMaxValueExclusive()
	 * @generated
	 */
	void setMaxValueExclusive(boolean value);

} // ValueRangeConstraint
