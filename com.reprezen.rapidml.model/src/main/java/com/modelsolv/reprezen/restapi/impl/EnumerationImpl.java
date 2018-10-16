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
package com.modelsolv.reprezen.restapi.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.modelsolv.reprezen.restapi.EnumConstant;
import com.modelsolv.reprezen.restapi.Enumeration;
import com.modelsolv.reprezen.restapi.PrimitiveType;
import com.modelsolv.reprezen.restapi.RestapiPackage;
import com.modelsolv.reprezen.restapi.SimpleType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Enumeration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.modelsolv.reprezen.restapi.datatypes.impl.EnumerationImpl#getEnumConstants <em>Enum Constants</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.restapi.datatypes.impl.EnumerationImpl#getBaseType <em>Base Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EnumerationImpl extends SingleValueTypeImpl implements Enumeration {
    /**
     * The cached value of the '{@link #getEnumConstants() <em>Enum Constants</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEnumConstants()
     * @generated
     * @ordered
     */
    protected EList<EnumConstant> enumConstants;

    /**
     * The cached value of the '{@link #getBaseType() <em>Base Type</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBaseType()
     * @generated
     * @ordered
     */
    protected PrimitiveType baseType;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected EnumerationImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RestapiPackage.Literals.ENUMERATION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<EnumConstant> getEnumConstants() {
        if (enumConstants == null) {
            enumConstants = new EObjectContainmentWithInverseEList<EnumConstant>(EnumConstant.class, this, RestapiPackage.ENUMERATION__ENUM_CONSTANTS, RestapiPackage.ENUM_CONSTANT__ENUMERATION);
        }
        return enumConstants;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PrimitiveType getBaseType() {
        if (baseType != null && baseType.eIsProxy()) {
            InternalEObject oldBaseType = (InternalEObject)baseType;
            baseType = (PrimitiveType)eResolveProxy(oldBaseType);
            if (baseType != oldBaseType) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, RestapiPackage.ENUMERATION__BASE_TYPE, oldBaseType, baseType));
            }
        }
        return baseType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PrimitiveType basicGetBaseType() {
        return baseType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setBaseType(PrimitiveType newBaseType) {
        PrimitiveType oldBaseType = baseType;
        baseType = newBaseType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, RestapiPackage.ENUMERATION__BASE_TYPE, oldBaseType, baseType));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case RestapiPackage.ENUMERATION__ENUM_CONSTANTS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getEnumConstants()).basicAdd(otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case RestapiPackage.ENUMERATION__ENUM_CONSTANTS:
                return ((InternalEList<?>)getEnumConstants()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case RestapiPackage.ENUMERATION__ENUM_CONSTANTS:
                return getEnumConstants();
            case RestapiPackage.ENUMERATION__BASE_TYPE:
                if (resolve) return getBaseType();
                return basicGetBaseType();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case RestapiPackage.ENUMERATION__ENUM_CONSTANTS:
                getEnumConstants().clear();
                getEnumConstants().addAll((Collection<? extends EnumConstant>)newValue);
                return;
            case RestapiPackage.ENUMERATION__BASE_TYPE:
                setBaseType((PrimitiveType)newValue);
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
            case RestapiPackage.ENUMERATION__ENUM_CONSTANTS:
                getEnumConstants().clear();
                return;
            case RestapiPackage.ENUMERATION__BASE_TYPE:
                setBaseType((PrimitiveType)null);
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
            case RestapiPackage.ENUMERATION__ENUM_CONSTANTS:
                return enumConstants != null && !enumConstants.isEmpty();
            case RestapiPackage.ENUMERATION__BASE_TYPE:
                return baseType != null;
        }
        return super.eIsSet(featureID);
    }
    
    @Override
    public PrimitiveType getPrimitiveType() {
        return (PrimitiveType) getBaseType();
    }
    
} //EnumerationImpl
