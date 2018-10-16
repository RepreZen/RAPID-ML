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
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.modelsolv.reprezen.restapi.ConstrainableType;
import com.modelsolv.reprezen.restapi.Constraint;
import com.modelsolv.reprezen.restapi.RestapiPackage;
import com.modelsolv.reprezen.restapi.PrimitiveType;
import com.modelsolv.reprezen.restapi.SimpleType;
import com.modelsolv.reprezen.restapi.UserDefinedType;
import com.modelsolv.reprezen.restapi.implicit.ConstraintProcessor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>User Defined Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.modelsolv.reprezen.restapi.datatypes.impl.UserDefinedTypeImpl#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.restapi.datatypes.impl.UserDefinedTypeImpl#getBaseType <em>Base Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class UserDefinedTypeImpl extends SimpleTypeImpl implements UserDefinedType {
    /**
     * The cached value of the '{@link #getConstraints() <em>Constraints</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getConstraints()
     * @generated
     * @ordered
     */
    protected EList<Constraint> constraints;

    /**
     * The cached value of the '{@link #getBaseType() <em>Base Type</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBaseType()
     * @generated
     * @ordered
     */
    protected SimpleType baseType;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected UserDefinedTypeImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RestapiPackage.Literals.USER_DEFINED_TYPE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Constraint> getConstraints() {
        if (constraints == null) {
            constraints = new EObjectContainmentEList<Constraint>(Constraint.class, this, RestapiPackage.USER_DEFINED_TYPE__CONSTRAINTS);
        }
        return constraints;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SimpleType getBaseType() {
        if (baseType != null && baseType.eIsProxy()) {
            InternalEObject oldBaseType = (InternalEObject)baseType;
            baseType = (SimpleType)eResolveProxy(oldBaseType);
            if (baseType != oldBaseType) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, RestapiPackage.USER_DEFINED_TYPE__BASE_TYPE, oldBaseType, baseType));
            }
        }
        return baseType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SimpleType basicGetBaseType() {
        return baseType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setBaseType(SimpleType newBaseType) {
        SimpleType oldBaseType = baseType;
        baseType = newBaseType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, RestapiPackage.USER_DEFINED_TYPE__BASE_TYPE, oldBaseType, baseType));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ConstrainableType getConstrainableParent() {
        return com.modelsolv.reprezen.restapi.datatypes.util.ConstraintsUtils.getConstrainableParent(this);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Constraint> getAllConstraints() {
        ConstraintProcessor.addParentConstraints(this);
        return getConstraints();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case RestapiPackage.USER_DEFINED_TYPE__CONSTRAINTS:
                return ((InternalEList<?>)getConstraints()).basicRemove(otherEnd, msgs);
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
            case RestapiPackage.USER_DEFINED_TYPE__CONSTRAINTS:
                return getConstraints();
            case RestapiPackage.USER_DEFINED_TYPE__BASE_TYPE:
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
            case RestapiPackage.USER_DEFINED_TYPE__CONSTRAINTS:
                getConstraints().clear();
                getConstraints().addAll((Collection<? extends Constraint>)newValue);
                return;
            case RestapiPackage.USER_DEFINED_TYPE__BASE_TYPE:
                setBaseType((SimpleType)newValue);
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
            case RestapiPackage.USER_DEFINED_TYPE__CONSTRAINTS:
                getConstraints().clear();
                return;
            case RestapiPackage.USER_DEFINED_TYPE__BASE_TYPE:
                setBaseType((SimpleType)null);
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
            case RestapiPackage.USER_DEFINED_TYPE__CONSTRAINTS:
                return constraints != null && !constraints.isEmpty();
            case RestapiPackage.USER_DEFINED_TYPE__BASE_TYPE:
                return baseType != null;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
        if (baseClass == ConstrainableType.class) {
            switch (derivedFeatureID) {
                case RestapiPackage.USER_DEFINED_TYPE__CONSTRAINTS: return RestapiPackage.CONSTRAINABLE_TYPE__CONSTRAINTS;
                default: return -1;
            }
        }
        return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
        if (baseClass == ConstrainableType.class) {
            switch (baseFeatureID) {
                case RestapiPackage.CONSTRAINABLE_TYPE__CONSTRAINTS: return RestapiPackage.USER_DEFINED_TYPE__CONSTRAINTS;
                default: return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }
    
    @Override
    public PrimitiveType getPrimitiveType() {
        return getBaseType().getPrimitiveType();
    }

} //UserDefinedTypeImpl
