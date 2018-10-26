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
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.reprezen.rapidml.ReferenceElement;
import com.reprezen.rapidml.ReferenceProperty;
import com.reprezen.rapidml.RapidmlPackage;
import com.reprezen.rapidml.Structure;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.reprezen.rapidml.datatypes.impl.ReferencePropertyImpl#getDataType <em>Data Type</em>}</li>
 *   <li>{@link com.reprezen.rapidml.datatypes.impl.ReferencePropertyImpl#getType <em>Type</em>}</li>
 *   <li>{@link com.reprezen.rapidml.datatypes.impl.ReferencePropertyImpl#getInverse <em>Inverse</em>}</li>
 *   <li>{@link com.reprezen.rapidml.datatypes.impl.ReferencePropertyImpl#isContainment <em>Containment</em>}</li>
 *   <li>{@link com.reprezen.rapidml.datatypes.impl.ReferencePropertyImpl#isContainer <em>Container</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ReferencePropertyImpl extends FeatureImpl implements ReferenceProperty {


    /**
     * The cached value of the '{@link #getDataType() <em>Data Type</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDataType()
     * @generated
     * @ordered
     */
    protected Structure dataType;

    /**
     * The cached value of the '{@link #getType() <em>Type</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getType()
     * @generated
     * @ordered
     */
    protected Structure type;

    /**
     * The cached value of the '{@link #getInverse() <em>Inverse</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInverse()
     * @generated
     * @ordered
     */
    protected ReferenceProperty inverse;

    /**
     * The default value of the '{@link #isContainment() <em>Containment</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isContainment()
     * @generated
     * @ordered
     */
    protected static final boolean CONTAINMENT_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isContainment() <em>Containment</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isContainment()
     * @generated
     * @ordered
     */
    protected boolean containment = CONTAINMENT_EDEFAULT;

    /**
     * The default value of the '{@link #isContainer() <em>Container</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isContainer()
     * @generated
     * @ordered
     */
    protected static final boolean CONTAINER_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isContainer() <em>Container</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isContainer()
     * @generated
     * @ordered
     */
    protected boolean container = CONTAINER_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ReferencePropertyImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RapidmlPackage.Literals.REFERENCE_PROPERTY;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Structure getType() {
        if (type != null && type.eIsProxy()) {
            InternalEObject oldType = (InternalEObject)type;
            type = (Structure)eResolveProxy(oldType);
            if (type != oldType) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, RapidmlPackage.REFERENCE_PROPERTY__TYPE, oldType, type));
            }
        }
        return type;
    }
    
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */    @Override
    public Structure getDataType() {
        return getType();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Structure basicGetDataType() {
        return dataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDataType(Structure newDataType) {
        Structure oldDataType = dataType;
        dataType = newDataType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, RapidmlPackage.REFERENCE_PROPERTY__DATA_TYPE, oldDataType, dataType));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Structure basicGetType() {
        return type;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setType(Structure newType) {
        Structure oldType = type;
        type = newType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, RapidmlPackage.REFERENCE_PROPERTY__TYPE, oldType, type));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ReferenceProperty getInverse() {
        if (inverse != null && inverse.eIsProxy()) {
            InternalEObject oldInverse = (InternalEObject)inverse;
            inverse = (ReferenceProperty)eResolveProxy(oldInverse);
            if (inverse != oldInverse) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, RapidmlPackage.REFERENCE_PROPERTY__INVERSE, oldInverse, inverse));
            }
        }
        return inverse;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ReferenceProperty basicGetInverse() {
        return inverse;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setInverse(ReferenceProperty newInverse) {
        ReferenceProperty oldInverse = inverse;
        inverse = newInverse;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, RapidmlPackage.REFERENCE_PROPERTY__INVERSE, oldInverse, inverse));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isContainment() {
        return containment;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setContainment(boolean newContainment) {
        boolean oldContainment = containment;
        containment = newContainment;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, RapidmlPackage.REFERENCE_PROPERTY__CONTAINMENT, oldContainment, containment));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isContainer() {
        return container;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setContainer(boolean newContainer) {
        boolean oldContainer = container;
        container = newContainer;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, RapidmlPackage.REFERENCE_PROPERTY__CONTAINER, oldContainer, container));
    }


    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case RapidmlPackage.REFERENCE_PROPERTY__DATA_TYPE:
                if (resolve) return getDataType();
                return basicGetDataType();
            case RapidmlPackage.REFERENCE_PROPERTY__TYPE:
                if (resolve) return getType();
                return basicGetType();
            case RapidmlPackage.REFERENCE_PROPERTY__INVERSE:
                if (resolve) return getInverse();
                return basicGetInverse();
            case RapidmlPackage.REFERENCE_PROPERTY__CONTAINMENT:
                return isContainment();
            case RapidmlPackage.REFERENCE_PROPERTY__CONTAINER:
                return isContainer();
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
            case RapidmlPackage.REFERENCE_PROPERTY__DATA_TYPE:
                setDataType((Structure)newValue);
                return;
            case RapidmlPackage.REFERENCE_PROPERTY__TYPE:
                setType((Structure)newValue);
                return;
            case RapidmlPackage.REFERENCE_PROPERTY__INVERSE:
                setInverse((ReferenceProperty)newValue);
                return;
            case RapidmlPackage.REFERENCE_PROPERTY__CONTAINMENT:
                setContainment((Boolean)newValue);
                return;
            case RapidmlPackage.REFERENCE_PROPERTY__CONTAINER:
                setContainer((Boolean)newValue);
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
            case RapidmlPackage.REFERENCE_PROPERTY__DATA_TYPE:
                setDataType((Structure)null);
                return;
            case RapidmlPackage.REFERENCE_PROPERTY__TYPE:
                setType((Structure)null);
                return;
            case RapidmlPackage.REFERENCE_PROPERTY__INVERSE:
                setInverse((ReferenceProperty)null);
                return;
            case RapidmlPackage.REFERENCE_PROPERTY__CONTAINMENT:
                setContainment(CONTAINMENT_EDEFAULT);
                return;
            case RapidmlPackage.REFERENCE_PROPERTY__CONTAINER:
                setContainer(CONTAINER_EDEFAULT);
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
            case RapidmlPackage.REFERENCE_PROPERTY__DATA_TYPE:
                return dataType != null;
            case RapidmlPackage.REFERENCE_PROPERTY__TYPE:
                return type != null;
            case RapidmlPackage.REFERENCE_PROPERTY__INVERSE:
                return inverse != null;
            case RapidmlPackage.REFERENCE_PROPERTY__CONTAINMENT:
                return containment != CONTAINMENT_EDEFAULT;
            case RapidmlPackage.REFERENCE_PROPERTY__CONTAINER:
                return container != CONTAINER_EDEFAULT;
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
        if (baseClass == ReferenceElement.class) {
            switch (derivedFeatureID) {
                case RapidmlPackage.REFERENCE_PROPERTY__DATA_TYPE: return RapidmlPackage.REFERENCE_ELEMENT__DATA_TYPE;
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
        if (baseClass == ReferenceElement.class) {
            switch (baseFeatureID) {
                case RapidmlPackage.REFERENCE_ELEMENT__DATA_TYPE: return RapidmlPackage.REFERENCE_PROPERTY__DATA_TYPE;
                default: return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
        result.append(" (containment: ");
        result.append(containment);
        result.append(", container: ");
        result.append(container);
        result.append(')');
        return result.toString();
    }

} //ReferencePropertyImpl
