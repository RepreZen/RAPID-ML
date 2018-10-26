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
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.reprezen.rapidml.PropertyReference;
import com.reprezen.rapidml.RapidmlPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.reprezen.rapidml.impl.PropertyReferenceImpl#getConceptualFeature <em>Conceptual Feature</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PropertyReferenceImpl extends SourceReferenceImpl implements PropertyReference {
    /**
	 * The cached value of the '{@link #getConceptualFeature() <em>Conceptual Feature</em>}' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getConceptualFeature()
	 * @generated
	 * @ordered
	 */
    protected com.reprezen.rapidml.PrimitiveProperty conceptualFeature;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected PropertyReferenceImpl() {
		super();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected EClass eStaticClass() {
		return RapidmlPackage.Literals.PROPERTY_REFERENCE;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public com.reprezen.rapidml.PrimitiveProperty getConceptualFeature() {
		if (conceptualFeature != null && conceptualFeature.eIsProxy()) {
			InternalEObject oldConceptualFeature = (InternalEObject)conceptualFeature;
			conceptualFeature = (com.reprezen.rapidml.PrimitiveProperty)eResolveProxy(oldConceptualFeature);
			if (conceptualFeature != oldConceptualFeature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RapidmlPackage.PROPERTY_REFERENCE__CONCEPTUAL_FEATURE, oldConceptualFeature, conceptualFeature));
			}
		}
		return conceptualFeature;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public com.reprezen.rapidml.PrimitiveProperty basicGetConceptualFeature() {
		return conceptualFeature;
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConceptualFeature(com.reprezen.rapidml.PrimitiveProperty newConceptualFeature) {
		com.reprezen.rapidml.PrimitiveProperty oldConceptualFeature = conceptualFeature;
		conceptualFeature = newConceptualFeature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RapidmlPackage.PROPERTY_REFERENCE__CONCEPTUAL_FEATURE, oldConceptualFeature, conceptualFeature));
	}

				/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public com.reprezen.rapidml.SingleValueType getType() {
		return getConceptualFeature().getType();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList<com.reprezen.rapidml.Constraint> getConstraints() {
		return getConceptualFeature().getConstraints();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RapidmlPackage.PROPERTY_REFERENCE__CONCEPTUAL_FEATURE:
				if (resolve) return getConceptualFeature();
				return basicGetConceptualFeature();
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
			case RapidmlPackage.PROPERTY_REFERENCE__CONCEPTUAL_FEATURE:
				setConceptualFeature((com.reprezen.rapidml.PrimitiveProperty)newValue);
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
			case RapidmlPackage.PROPERTY_REFERENCE__CONCEPTUAL_FEATURE:
				setConceptualFeature((com.reprezen.rapidml.PrimitiveProperty)null);
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
			case RapidmlPackage.PROPERTY_REFERENCE__CONCEPTUAL_FEATURE:
				return conceptualFeature != null;
		}
		return super.eIsSet(featureID);
	}

} //PropertyReferenceImpl
