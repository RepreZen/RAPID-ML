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
package com.modelsolv.reprezen.rapidml.impl;

import com.modelsolv.reprezen.rapidml.LengthConstraint;
import com.modelsolv.reprezen.rapidml.RapidmlPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Length Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.modelsolv.reprezen.rapidml.datatypes.impl.LengthConstraintImpl#getMinLength <em>Min Length</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.rapidml.datatypes.impl.LengthConstraintImpl#getMaxLength <em>Max Length</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.rapidml.datatypes.impl.LengthConstraintImpl#getLength <em>Length</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LengthConstraintImpl extends ConstraintImpl implements LengthConstraint {
    /**
     * The default value of the '{@link #getMinLength() <em>Min Length</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMinLength()
     * @generated
     * @ordered
     */
    protected static final int MIN_LENGTH_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getMinLength() <em>Min Length</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMinLength()
     * @generated
     * @ordered
     */
    protected int minLength = MIN_LENGTH_EDEFAULT;

    /**
     * This is true if the Min Length attribute has been set.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    protected boolean minLengthESet;

    /**
     * The default value of the '{@link #getMaxLength() <em>Max Length</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMaxLength()
     * @generated
     * @ordered
     */
    protected static final int MAX_LENGTH_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getMaxLength() <em>Max Length</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMaxLength()
     * @generated
     * @ordered
     */
    protected int maxLength = MAX_LENGTH_EDEFAULT;

    /**
     * This is true if the Max Length attribute has been set.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    protected boolean maxLengthESet;

    /**
     * The default value of the '{@link #getLength() <em>Length</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLength()
     * @generated
     * @ordered
     */
    protected static final int LENGTH_EDEFAULT = 0;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected LengthConstraintImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RapidmlPackage.Literals.LENGTH_CONSTRAINT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getMinLength() {
        return minLength;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setMinLength(int newMinLength) {
        int oldMinLength = minLength;
        minLength = newMinLength;
        boolean oldMinLengthESet = minLengthESet;
        minLengthESet = true;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, RapidmlPackage.LENGTH_CONSTRAINT__MIN_LENGTH, oldMinLength, minLength, !oldMinLengthESet));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void unsetMinLength() {
        int oldMinLength = minLength;
        boolean oldMinLengthESet = minLengthESet;
        minLength = MIN_LENGTH_EDEFAULT;
        minLengthESet = false;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.UNSET, RapidmlPackage.LENGTH_CONSTRAINT__MIN_LENGTH, oldMinLength, MIN_LENGTH_EDEFAULT, oldMinLengthESet));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isSetMinLength() {
        return minLengthESet;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getMaxLength() {
        return maxLength;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setMaxLength(int newMaxLength) {
        int oldMaxLength = maxLength;
        maxLength = newMaxLength;
        boolean oldMaxLengthESet = maxLengthESet;
        maxLengthESet = true;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, RapidmlPackage.LENGTH_CONSTRAINT__MAX_LENGTH, oldMaxLength, maxLength, !oldMaxLengthESet));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void unsetMaxLength() {
        int oldMaxLength = maxLength;
        boolean oldMaxLengthESet = maxLengthESet;
        maxLength = MAX_LENGTH_EDEFAULT;
        maxLengthESet = false;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.UNSET, RapidmlPackage.LENGTH_CONSTRAINT__MAX_LENGTH, oldMaxLength, MAX_LENGTH_EDEFAULT, oldMaxLengthESet));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isSetMaxLength() {
        return maxLengthESet;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public int getLength() {
        // We need returns value in any cases for correct work Xtext validation
        return 0;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public void setLength(int newLength) {
        this.setMaxLength(newLength);
        this.setMinLength(newLength);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case RapidmlPackage.LENGTH_CONSTRAINT__MIN_LENGTH:
                return getMinLength();
            case RapidmlPackage.LENGTH_CONSTRAINT__MAX_LENGTH:
                return getMaxLength();
            case RapidmlPackage.LENGTH_CONSTRAINT__LENGTH:
                return getLength();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case RapidmlPackage.LENGTH_CONSTRAINT__MIN_LENGTH:
                setMinLength((Integer)newValue);
                return;
            case RapidmlPackage.LENGTH_CONSTRAINT__MAX_LENGTH:
                setMaxLength((Integer)newValue);
                return;
            case RapidmlPackage.LENGTH_CONSTRAINT__LENGTH:
                setLength((Integer)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
            case RapidmlPackage.LENGTH_CONSTRAINT__MIN_LENGTH:
                unsetMinLength();
                return;
            case RapidmlPackage.LENGTH_CONSTRAINT__MAX_LENGTH:
                unsetMaxLength();
                return;
            case RapidmlPackage.LENGTH_CONSTRAINT__LENGTH:
                setLength(LENGTH_EDEFAULT);
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case RapidmlPackage.LENGTH_CONSTRAINT__MIN_LENGTH:
                return isSetMinLength();
            case RapidmlPackage.LENGTH_CONSTRAINT__MAX_LENGTH:
                return isSetMaxLength();
            case RapidmlPackage.LENGTH_CONSTRAINT__LENGTH:
                return getLength() != LENGTH_EDEFAULT;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (minLength: ");
        if (minLengthESet) result.append(minLength); else result.append("<unset>");
        result.append(", maxLength: ");
        if (maxLengthESet) result.append(maxLength); else result.append("<unset>");
        result.append(')');
        return result.toString();
    }

} //LengthConstraintImpl
