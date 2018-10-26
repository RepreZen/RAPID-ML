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

import com.modelsolv.reprezen.rapidml.DataExample;
import com.modelsolv.reprezen.rapidml.RapidmlPackage;
import com.modelsolv.reprezen.rapidml.WithDataExamples;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>With Data Examples</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.modelsolv.reprezen.rapidml.datatypes.impl.WithDataExamplesImpl#getDataExamples <em>Data Examples</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class WithDataExamplesImpl extends EObjectImpl implements WithDataExamples {
    /**
     * The cached value of the '{@link #getDataExamples() <em>Data Examples</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDataExamples()
     * @generated
     * @ordered
     */
    protected EList<DataExample> dataExamples;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected WithDataExamplesImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RapidmlPackage.Literals.WITH_DATA_EXAMPLES;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<DataExample> getDataExamples() {
        if (dataExamples == null) {
            dataExamples = new EObjectContainmentEList<DataExample>(DataExample.class, this, RapidmlPackage.WITH_DATA_EXAMPLES__DATA_EXAMPLES);
        }
        return dataExamples;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case RapidmlPackage.WITH_DATA_EXAMPLES__DATA_EXAMPLES:
                return ((InternalEList<?>)getDataExamples()).basicRemove(otherEnd, msgs);
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
            case RapidmlPackage.WITH_DATA_EXAMPLES__DATA_EXAMPLES:
                return getDataExamples();
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
            case RapidmlPackage.WITH_DATA_EXAMPLES__DATA_EXAMPLES:
                getDataExamples().clear();
                getDataExamples().addAll((Collection<? extends DataExample>)newValue);
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
            case RapidmlPackage.WITH_DATA_EXAMPLES__DATA_EXAMPLES:
                getDataExamples().clear();
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
            case RapidmlPackage.WITH_DATA_EXAMPLES__DATA_EXAMPLES:
                return dataExamples != null && !dataExamples.isEmpty();
        }
        return super.eIsSet(featureID);
    }


} //WithDataExamplesImpl
