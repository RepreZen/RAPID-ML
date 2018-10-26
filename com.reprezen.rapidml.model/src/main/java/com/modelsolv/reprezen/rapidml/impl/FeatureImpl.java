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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import com.modelsolv.reprezen.rapidml.Extensible;
import com.modelsolv.reprezen.rapidml.Extension;
import com.modelsolv.reprezen.rapidml.RapidmlPackage;
import com.modelsolv.reprezen.rapidml.Element;
import com.modelsolv.reprezen.rapidml.Feature;
import com.modelsolv.reprezen.rapidml.Structure;
import com.modelsolv.reprezen.rapidml.impl.DocumentableImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.modelsolv.reprezen.rapidml.datatypes.impl.FeatureImpl#getCardinality <em>Cardinality</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.rapidml.datatypes.impl.FeatureImpl#getExtensions <em>Extensions</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.rapidml.datatypes.impl.FeatureImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.rapidml.datatypes.impl.FeatureImpl#getContainingDataType <em>Containing Data Type</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.rapidml.datatypes.impl.FeatureImpl#isRestriction <em>Restriction</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.rapidml.datatypes.impl.FeatureImpl#isReadOnly <em>Read Only</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.rapidml.datatypes.impl.FeatureImpl#isKey <em>Key</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class FeatureImpl extends DocumentableImpl implements Feature {
    /**
     * The default value of the '{@link #getCardinality() <em>Cardinality</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCardinality()
     * @generated
     * @ordered
     */
    protected static final int[] CARDINALITY_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getCardinality() <em>Cardinality</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCardinality()
     * @generated
     * @ordered
     */
    protected int[] cardinality = CARDINALITY_EDEFAULT;

    /**
     * The cached value of the '{@link #getExtensions() <em>Extensions</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getExtensions()
     * @generated
     * @ordered
     */
    protected EList<Extension> extensions;

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
     * The default value of the '{@link #isRestriction() <em>Restriction</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isRestriction()
     * @generated
     * @ordered
     */
    protected static final boolean RESTRICTION_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isRestriction() <em>Restriction</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isRestriction()
     * @generated
     * @ordered
     */
    protected boolean restriction = RESTRICTION_EDEFAULT;

    /**
     * The default value of the '{@link #isReadOnly() <em>Read Only</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isReadOnly()
     * @generated
     * @ordered
     */
    protected static final boolean READ_ONLY_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isReadOnly() <em>Read Only</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isReadOnly()
     * @generated
     * @ordered
     */
    protected boolean readOnly = READ_ONLY_EDEFAULT;

    /**
     * The default value of the '{@link #isKey() <em>Key</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isKey()
     * @generated
     * @ordered
     */
    protected static final boolean KEY_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isKey() <em>Key</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isKey()
     * @generated
     * @ordered
     */
    protected boolean key = KEY_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected FeatureImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RapidmlPackage.Literals.FEATURE;
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
            eNotify(new ENotificationImpl(this, Notification.SET, RapidmlPackage.FEATURE__NAME, oldName, name));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int[] getCardinality() {
        return cardinality;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setCardinality(int[] newCardinality) {
        int[] oldCardinality = cardinality;
        cardinality = newCardinality;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, RapidmlPackage.FEATURE__CARDINALITY, oldCardinality, cardinality));
    }




    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Extension> getExtensions() {
        if (extensions == null) {
            extensions = new EObjectContainmentEList<Extension>(Extension.class, this, RapidmlPackage.FEATURE__EXTENSIONS);
        }
        return extensions;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Structure getContainingDataType() {
        if (eContainerFeatureID() != RapidmlPackage.FEATURE__CONTAINING_DATA_TYPE) return null;
        return (Structure)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetContainingDataType(Structure newContainingDataType, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newContainingDataType, RapidmlPackage.FEATURE__CONTAINING_DATA_TYPE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setContainingDataType(Structure newContainingDataType) {
        if (newContainingDataType != eInternalContainer() || (eContainerFeatureID() != RapidmlPackage.FEATURE__CONTAINING_DATA_TYPE && newContainingDataType != null)) {
            if (EcoreUtil.isAncestor(this, newContainingDataType))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newContainingDataType != null)
                msgs = ((InternalEObject)newContainingDataType).eInverseAdd(this, RapidmlPackage.STRUCTURE__OWNED_FEATURES, Structure.class, msgs);
            msgs = basicSetContainingDataType(newContainingDataType, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, RapidmlPackage.FEATURE__CONTAINING_DATA_TYPE, newContainingDataType, newContainingDataType));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isRestriction() {
        return restriction;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setRestriction(boolean newRestriction) {
        boolean oldRestriction = restriction;
        restriction = newRestriction;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, RapidmlPackage.FEATURE__RESTRICTION, oldRestriction, restriction));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isReadOnly() {
        return readOnly;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setReadOnly(boolean newReadOnly) {
        boolean oldReadOnly = readOnly;
        readOnly = newReadOnly;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, RapidmlPackage.FEATURE__READ_ONLY, oldReadOnly, readOnly));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isKey() {
        return key;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setKey(boolean newKey) {
        boolean oldKey = key;
        key = newKey;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, RapidmlPackage.FEATURE__KEY, oldKey, key));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getMinOccurs() {
        if (getCardinality() == null || getCardinality().length != 2) {
             //default value
             return 0;
        }
        return getCardinality()[0];
        
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getMaxOccurs() {
        if (getCardinality() == null || getCardinality().length != 2) {
             //default value
             return 1;
        }
        return getCardinality()[1];
        
    }



 

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isMultiValued() {
        return (1 < getMaxOccurs()) || (-1 == getMaxOccurs());
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Structure getDataType() {
        // TODO: implement this method
        // Ensure that you remove @generated or mark it @generated NOT
        throw new UnsupportedOperationException();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case RapidmlPackage.FEATURE__CONTAINING_DATA_TYPE:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetContainingDataType((Structure)otherEnd, msgs);
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
            case RapidmlPackage.FEATURE__EXTENSIONS:
                return ((InternalEList<?>)getExtensions()).basicRemove(otherEnd, msgs);
            case RapidmlPackage.FEATURE__CONTAINING_DATA_TYPE:
                return basicSetContainingDataType(null, msgs);
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
            case RapidmlPackage.FEATURE__CONTAINING_DATA_TYPE:
                return eInternalContainer().eInverseRemove(this, RapidmlPackage.STRUCTURE__OWNED_FEATURES, Structure.class, msgs);
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
            case RapidmlPackage.FEATURE__CARDINALITY:
                return getCardinality();
            case RapidmlPackage.FEATURE__EXTENSIONS:
                return getExtensions();
            case RapidmlPackage.FEATURE__NAME:
                return getName();
            case RapidmlPackage.FEATURE__CONTAINING_DATA_TYPE:
                return getContainingDataType();
            case RapidmlPackage.FEATURE__RESTRICTION:
                return isRestriction();
            case RapidmlPackage.FEATURE__READ_ONLY:
                return isReadOnly();
            case RapidmlPackage.FEATURE__KEY:
                return isKey();
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
            case RapidmlPackage.FEATURE__CARDINALITY:
                setCardinality((int[])newValue);
                return;
            case RapidmlPackage.FEATURE__EXTENSIONS:
                getExtensions().clear();
                getExtensions().addAll((Collection<? extends Extension>)newValue);
                return;
            case RapidmlPackage.FEATURE__NAME:
                setName((String)newValue);
                return;
            case RapidmlPackage.FEATURE__CONTAINING_DATA_TYPE:
                setContainingDataType((Structure)newValue);
                return;
            case RapidmlPackage.FEATURE__RESTRICTION:
                setRestriction((Boolean)newValue);
                return;
            case RapidmlPackage.FEATURE__READ_ONLY:
                setReadOnly((Boolean)newValue);
                return;
            case RapidmlPackage.FEATURE__KEY:
                setKey((Boolean)newValue);
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
            case RapidmlPackage.FEATURE__CARDINALITY:
                setCardinality(CARDINALITY_EDEFAULT);
                return;
            case RapidmlPackage.FEATURE__EXTENSIONS:
                getExtensions().clear();
                return;
            case RapidmlPackage.FEATURE__NAME:
                setName(NAME_EDEFAULT);
                return;
            case RapidmlPackage.FEATURE__CONTAINING_DATA_TYPE:
                setContainingDataType((Structure)null);
                return;
            case RapidmlPackage.FEATURE__RESTRICTION:
                setRestriction(RESTRICTION_EDEFAULT);
                return;
            case RapidmlPackage.FEATURE__READ_ONLY:
                setReadOnly(READ_ONLY_EDEFAULT);
                return;
            case RapidmlPackage.FEATURE__KEY:
                setKey(KEY_EDEFAULT);
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
            case RapidmlPackage.FEATURE__CARDINALITY:
                return CARDINALITY_EDEFAULT == null ? cardinality != null : !CARDINALITY_EDEFAULT.equals(cardinality);
            case RapidmlPackage.FEATURE__EXTENSIONS:
                return extensions != null && !extensions.isEmpty();
            case RapidmlPackage.FEATURE__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case RapidmlPackage.FEATURE__CONTAINING_DATA_TYPE:
                return getContainingDataType() != null;
            case RapidmlPackage.FEATURE__RESTRICTION:
                return restriction != RESTRICTION_EDEFAULT;
            case RapidmlPackage.FEATURE__READ_ONLY:
                return readOnly != READ_ONLY_EDEFAULT;
            case RapidmlPackage.FEATURE__KEY:
                return key != KEY_EDEFAULT;
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
        if (baseClass == Element.class) {
            switch (derivedFeatureID) {
                case RapidmlPackage.FEATURE__CARDINALITY: return RapidmlPackage.ELEMENT__CARDINALITY;
                default: return -1;
            }
        }
        if (baseClass == Extensible.class) {
            switch (derivedFeatureID) {
                case RapidmlPackage.FEATURE__EXTENSIONS: return RapidmlPackage.EXTENSIBLE__EXTENSIONS;
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
        if (baseClass == Element.class) {
            switch (baseFeatureID) {
                case RapidmlPackage.ELEMENT__CARDINALITY: return RapidmlPackage.FEATURE__CARDINALITY;
                default: return -1;
            }
        }
        if (baseClass == Extensible.class) {
            switch (baseFeatureID) {
                case RapidmlPackage.EXTENSIBLE__EXTENSIONS: return RapidmlPackage.FEATURE__EXTENSIONS;
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
        result.append(" (cardinality: ");
        result.append(cardinality);
        result.append(", name: ");
        result.append(name);
        result.append(", restriction: ");
        result.append(restriction);
        result.append(", readOnly: ");
        result.append(readOnly);
        result.append(", key: ");
        result.append(key);
        result.append(')');
        return result.toString();
    }

} //FeatureImpl
