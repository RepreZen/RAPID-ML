/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
/**
 */
package com.reprezen.rapidml.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.reprezen.rapidml.RapidmlPackage;
import com.reprezen.rapidml.ValueRangeConstraint;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Value
 * Range Constraint</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link com.reprezen.rapidml.datatypes.impl.ValueRangeConstraintImpl#getMinValue
 * <em>Min Value</em>}</li>
 * <li>{@link com.reprezen.rapidml.datatypes.impl.ValueRangeConstraintImpl#isMinValueExclusive
 * <em>Min Value Exclusive</em>}</li>
 * <li>{@link com.reprezen.rapidml.datatypes.impl.ValueRangeConstraintImpl#getMaxValue
 * <em>Max Value</em>}</li>
 * <li>{@link com.reprezen.rapidml.datatypes.impl.ValueRangeConstraintImpl#isMaxValueExclusive
 * <em>Max Value Exclusive</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ValueRangeConstraintImpl extends ConstraintImpl implements ValueRangeConstraint {
	/**
	 * The default value of the '{@link #getMinValue() <em>Min Value</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getMinValue()
	 * @generated
	 * @ordered
	 */
	protected static final String MIN_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMinValue() <em>Min Value</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getMinValue()
	 * @generated
	 * @ordered
	 */
	protected String minValue = MIN_VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #isMinValueExclusive() <em>Min Value
	 * Exclusive</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isMinValueExclusive()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MIN_VALUE_EXCLUSIVE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isMinValueExclusive() <em>Min Value
	 * Exclusive</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isMinValueExclusive()
	 * @generated
	 * @ordered
	 */
	protected boolean minValueExclusive = MIN_VALUE_EXCLUSIVE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxValue() <em>Max Value</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getMaxValue()
	 * @generated
	 * @ordered
	 */
	protected static final String MAX_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMaxValue() <em>Max Value</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getMaxValue()
	 * @generated
	 * @ordered
	 */
	protected String maxValue = MAX_VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #isMaxValueExclusive() <em>Max Value
	 * Exclusive</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isMaxValueExclusive()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MAX_VALUE_EXCLUSIVE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isMaxValueExclusive() <em>Max Value
	 * Exclusive</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isMaxValueExclusive()
	 * @generated
	 * @ordered
	 */
	protected boolean maxValueExclusive = MAX_VALUE_EXCLUSIVE_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ValueRangeConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RapidmlPackage.Literals.VALUE_RANGE_CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public String getMinValue() {
		return removeSurroundingQuotes(minValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setMinValue(String newMinValue) {
		String oldMinValue = minValue;
		minValue = newMinValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RapidmlPackage.VALUE_RANGE_CONSTRAINT__MIN_VALUE,
					oldMinValue, minValue));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isMinValueExclusive() {
		return minValueExclusive;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setMinValueExclusive(boolean newMinValueExclusive) {
		boolean oldMinValueExclusive = minValueExclusive;
		minValueExclusive = newMinValueExclusive;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					RapidmlPackage.VALUE_RANGE_CONSTRAINT__MIN_VALUE_EXCLUSIVE, oldMinValueExclusive,
					minValueExclusive));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public String getMaxValue() {
		return removeSurroundingQuotes(maxValue);
	}

	protected String removeSurroundingQuotes(String string) {
		return (string == null) ? null : string.replaceAll("^\"|\"$", "").replaceAll("^\'|\'$", "");
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setMaxValue(String newMaxValue) {
		String oldMaxValue = maxValue;
		maxValue = newMaxValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RapidmlPackage.VALUE_RANGE_CONSTRAINT__MAX_VALUE,
					oldMaxValue, maxValue));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isMaxValueExclusive() {
		return maxValueExclusive;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setMaxValueExclusive(boolean newMaxValueExclusive) {
		boolean oldMaxValueExclusive = maxValueExclusive;
		maxValueExclusive = newMaxValueExclusive;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					RapidmlPackage.VALUE_RANGE_CONSTRAINT__MAX_VALUE_EXCLUSIVE, oldMaxValueExclusive,
					maxValueExclusive));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case RapidmlPackage.VALUE_RANGE_CONSTRAINT__MIN_VALUE:
			return getMinValue();
		case RapidmlPackage.VALUE_RANGE_CONSTRAINT__MIN_VALUE_EXCLUSIVE:
			return isMinValueExclusive();
		case RapidmlPackage.VALUE_RANGE_CONSTRAINT__MAX_VALUE:
			return getMaxValue();
		case RapidmlPackage.VALUE_RANGE_CONSTRAINT__MAX_VALUE_EXCLUSIVE:
			return isMaxValueExclusive();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case RapidmlPackage.VALUE_RANGE_CONSTRAINT__MIN_VALUE:
			setMinValue((String) newValue);
			return;
		case RapidmlPackage.VALUE_RANGE_CONSTRAINT__MIN_VALUE_EXCLUSIVE:
			setMinValueExclusive((Boolean) newValue);
			return;
		case RapidmlPackage.VALUE_RANGE_CONSTRAINT__MAX_VALUE:
			setMaxValue((String) newValue);
			return;
		case RapidmlPackage.VALUE_RANGE_CONSTRAINT__MAX_VALUE_EXCLUSIVE:
			setMaxValueExclusive((Boolean) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case RapidmlPackage.VALUE_RANGE_CONSTRAINT__MIN_VALUE:
			setMinValue(MIN_VALUE_EDEFAULT);
			return;
		case RapidmlPackage.VALUE_RANGE_CONSTRAINT__MIN_VALUE_EXCLUSIVE:
			setMinValueExclusive(MIN_VALUE_EXCLUSIVE_EDEFAULT);
			return;
		case RapidmlPackage.VALUE_RANGE_CONSTRAINT__MAX_VALUE:
			setMaxValue(MAX_VALUE_EDEFAULT);
			return;
		case RapidmlPackage.VALUE_RANGE_CONSTRAINT__MAX_VALUE_EXCLUSIVE:
			setMaxValueExclusive(MAX_VALUE_EXCLUSIVE_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case RapidmlPackage.VALUE_RANGE_CONSTRAINT__MIN_VALUE:
			return MIN_VALUE_EDEFAULT == null ? minValue != null : !MIN_VALUE_EDEFAULT.equals(minValue);
		case RapidmlPackage.VALUE_RANGE_CONSTRAINT__MIN_VALUE_EXCLUSIVE:
			return minValueExclusive != MIN_VALUE_EXCLUSIVE_EDEFAULT;
		case RapidmlPackage.VALUE_RANGE_CONSTRAINT__MAX_VALUE:
			return MAX_VALUE_EDEFAULT == null ? maxValue != null : !MAX_VALUE_EDEFAULT.equals(maxValue);
		case RapidmlPackage.VALUE_RANGE_CONSTRAINT__MAX_VALUE_EXCLUSIVE:
			return maxValueExclusive != MAX_VALUE_EXCLUSIVE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (minValue: ");
		result.append(minValue);
		result.append(", minValueExclusive: ");
		result.append(minValueExclusive);
		result.append(", maxValue: ");
		result.append(maxValue);
		result.append(", maxValueExclusive: ");
		result.append(maxValueExclusive);
		result.append(')');
		return result.toString();
	}

} // ValueRangeConstraintImpl
