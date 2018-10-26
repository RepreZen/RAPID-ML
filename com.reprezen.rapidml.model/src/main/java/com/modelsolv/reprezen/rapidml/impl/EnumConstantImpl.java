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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.modelsolv.reprezen.rapidml.RapidmlPackage;
import com.modelsolv.reprezen.rapidml.EnumConstant;
import com.modelsolv.reprezen.rapidml.Enumeration;
import com.modelsolv.reprezen.rapidml.impl.DocumentableImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Enum Constant</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.modelsolv.reprezen.rapidml.datatypes.impl.EnumConstantImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.rapidml.datatypes.impl.EnumConstantImpl#getIntegerValue <em>Integer Value</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.rapidml.datatypes.impl.EnumConstantImpl#getLiteralValue <em>Literal Value</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.rapidml.datatypes.impl.EnumConstantImpl#getEnumeration <em>Enumeration</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EnumConstantImpl extends DocumentableImpl implements EnumConstant {
    /**
     * The default value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected static final String NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected String name = NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getIntegerValue() <em>Integer Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getIntegerValue()
     * @generated
     * @ordered
     */
    protected static final int INTEGER_VALUE_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getIntegerValue() <em>Integer Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getIntegerValue()
     * @generated
     * @ordered
     */
    protected int integerValue = INTEGER_VALUE_EDEFAULT;

    /**
     * This is true if the Integer Value attribute has been set.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    protected boolean integerValueESet;

    /**
     * The default value of the '{@link #getLiteralValue() <em>Literal Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLiteralValue()
     * @generated
     * @ordered
     */
    protected static final String LITERAL_VALUE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getLiteralValue() <em>Literal Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLiteralValue()
     * @generated
     * @ordered
     */
    protected String literalValue = LITERAL_VALUE_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected EnumConstantImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RapidmlPackage.Literals.ENUM_CONSTANT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getName() {
        return name;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setName(String newName) {
        String oldName = name;
        name = newName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, RapidmlPackage.ENUM_CONSTANT__NAME, oldName, name));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getIntegerValueGen() {
        return integerValue;
    }
    
    /**
     * @generated NOT
     */
    public int getIntegerValue() {
        if (!isSetIntegerValue() && "int".equals(getEnumeration().getBaseType().getName())) {
            setIntegerValue(getImplicitIntegerValue());
        }
        return getIntegerValueGen();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setIntegerValue(int newIntegerValue) {
        int oldIntegerValue = integerValue;
        integerValue = newIntegerValue;
        boolean oldIntegerValueESet = integerValueESet;
        integerValueESet = true;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, RapidmlPackage.ENUM_CONSTANT__INTEGER_VALUE, oldIntegerValue, integerValue, !oldIntegerValueESet));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void unsetIntegerValue() {
        int oldIntegerValue = integerValue;
        boolean oldIntegerValueESet = integerValueESet;
        integerValue = INTEGER_VALUE_EDEFAULT;
        integerValueESet = false;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.UNSET, RapidmlPackage.ENUM_CONSTANT__INTEGER_VALUE, oldIntegerValue, INTEGER_VALUE_EDEFAULT, oldIntegerValueESet));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isSetIntegerValue() {
        return integerValueESet;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getLiteralValueGen() {
        return literalValue;
    }
    
    /**
     * @generated NOT
     */
    public String getLiteralValue() {
        if (getLiteralValueGen() == null && "string".equals(getEnumeration().getBaseType().getName())) {
            setLiteralValue(getName());
        }
        return getLiteralValueGen();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLiteralValue(String newLiteralValue) {
        String oldLiteralValue = literalValue;
        literalValue = newLiteralValue;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, RapidmlPackage.ENUM_CONSTANT__LITERAL_VALUE, oldLiteralValue, literalValue));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Enumeration getEnumeration() {
        if (eContainerFeatureID() != RapidmlPackage.ENUM_CONSTANT__ENUMERATION) return null;
        return (Enumeration)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetEnumeration(Enumeration newEnumeration, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newEnumeration, RapidmlPackage.ENUM_CONSTANT__ENUMERATION, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setEnumeration(Enumeration newEnumeration) {
        if (newEnumeration != eInternalContainer() || (eContainerFeatureID() != RapidmlPackage.ENUM_CONSTANT__ENUMERATION && newEnumeration != null)) {
            if (EcoreUtil.isAncestor(this, newEnumeration))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newEnumeration != null)
                msgs = ((InternalEObject)newEnumeration).eInverseAdd(this, RapidmlPackage.ENUMERATION__ENUM_CONSTANTS, Enumeration.class, msgs);
            msgs = basicSetEnumeration(newEnumeration, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, RapidmlPackage.ENUM_CONSTANT__ENUMERATION, newEnumeration, newEnumeration));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getImplicitIntegerValue() {
        return getEnumeration().getEnumConstants().indexOf(this);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case RapidmlPackage.ENUM_CONSTANT__ENUMERATION:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetEnumeration((Enumeration)otherEnd, msgs);
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
            case RapidmlPackage.ENUM_CONSTANT__ENUMERATION:
                return basicSetEnumeration(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
        switch (eContainerFeatureID()) {
            case RapidmlPackage.ENUM_CONSTANT__ENUMERATION:
                return eInternalContainer().eInverseRemove(this, RapidmlPackage.ENUMERATION__ENUM_CONSTANTS, Enumeration.class, msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case RapidmlPackage.ENUM_CONSTANT__NAME:
                return getName();
            case RapidmlPackage.ENUM_CONSTANT__INTEGER_VALUE:
                return getIntegerValue();
            case RapidmlPackage.ENUM_CONSTANT__LITERAL_VALUE:
                return getLiteralValue();
            case RapidmlPackage.ENUM_CONSTANT__ENUMERATION:
                return getEnumeration();
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
            case RapidmlPackage.ENUM_CONSTANT__NAME:
                setName((String)newValue);
                return;
            case RapidmlPackage.ENUM_CONSTANT__INTEGER_VALUE:
                setIntegerValue((Integer)newValue);
                return;
            case RapidmlPackage.ENUM_CONSTANT__LITERAL_VALUE:
                setLiteralValue((String)newValue);
                return;
            case RapidmlPackage.ENUM_CONSTANT__ENUMERATION:
                setEnumeration((Enumeration)newValue);
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
            case RapidmlPackage.ENUM_CONSTANT__NAME:
                setName(NAME_EDEFAULT);
                return;
            case RapidmlPackage.ENUM_CONSTANT__INTEGER_VALUE:
                unsetIntegerValue();
                return;
            case RapidmlPackage.ENUM_CONSTANT__LITERAL_VALUE:
                setLiteralValue(LITERAL_VALUE_EDEFAULT);
                return;
            case RapidmlPackage.ENUM_CONSTANT__ENUMERATION:
                setEnumeration((Enumeration)null);
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
            case RapidmlPackage.ENUM_CONSTANT__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case RapidmlPackage.ENUM_CONSTANT__INTEGER_VALUE:
                return isSetIntegerValue();
            case RapidmlPackage.ENUM_CONSTANT__LITERAL_VALUE:
                return LITERAL_VALUE_EDEFAULT == null ? literalValue != null : !LITERAL_VALUE_EDEFAULT.equals(literalValue);
            case RapidmlPackage.ENUM_CONSTANT__ENUMERATION:
                return getEnumeration() != null;
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
        result.append(" (name: ");
        result.append(name);
        result.append(", integerValue: ");
        if (integerValueESet) result.append(integerValue); else result.append("<unset>");
        result.append(", literalValue: ");
        result.append(literalValue);
        result.append(')');
        return result.toString();
    }

} //EnumConstantImpl
