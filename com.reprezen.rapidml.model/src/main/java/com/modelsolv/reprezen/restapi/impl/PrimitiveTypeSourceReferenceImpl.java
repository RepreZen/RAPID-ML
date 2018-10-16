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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.modelsolv.reprezen.restapi.ConstrainableType;
import com.modelsolv.reprezen.restapi.PrimitiveTypeSourceReference;
import com.modelsolv.reprezen.restapi.RestapiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Primitive Type Source Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.modelsolv.reprezen.restapi.impl.PrimitiveTypeSourceReferenceImpl#getSimpleType <em>Simple Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PrimitiveTypeSourceReferenceImpl extends SourceReferenceImpl implements PrimitiveTypeSourceReference {
    /**
	 * The cached value of the '{@link #getSimpleType() <em>Simple Type</em>}' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getSimpleType()
	 * @generated
	 * @ordered
	 */
    protected com.modelsolv.reprezen.restapi.PrimitiveType simpleType;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected PrimitiveTypeSourceReferenceImpl() {
		super();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected EClass eStaticClass() {
		return RestapiPackage.Literals.PRIMITIVE_TYPE_SOURCE_REFERENCE;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public com.modelsolv.reprezen.restapi.PrimitiveType getSimpleType() {
		if (simpleType != null && simpleType.eIsProxy()) {
			InternalEObject oldSimpleType = (InternalEObject)simpleType;
			simpleType = (com.modelsolv.reprezen.restapi.PrimitiveType)eResolveProxy(oldSimpleType);
			if (simpleType != oldSimpleType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RestapiPackage.PRIMITIVE_TYPE_SOURCE_REFERENCE__SIMPLE_TYPE, oldSimpleType, simpleType));
			}
		}
		return simpleType;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public com.modelsolv.reprezen.restapi.PrimitiveType basicGetSimpleType() {
		return simpleType;
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSimpleType(com.modelsolv.reprezen.restapi.PrimitiveType newSimpleType) {
		com.modelsolv.reprezen.restapi.PrimitiveType oldSimpleType = simpleType;
		simpleType = newSimpleType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RestapiPackage.PRIMITIVE_TYPE_SOURCE_REFERENCE__SIMPLE_TYPE, oldSimpleType, simpleType));
	}

				/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public com.modelsolv.reprezen.restapi.SingleValueType getType() {
		return getSimpleType();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList<com.modelsolv.reprezen.restapi.Constraint> getConstraints() {
		if (getSimpleType() instanceof ConstrainableType) {
		    return ((ConstrainableType)getSimpleType()).getConstraints();
		}
		return ECollections.emptyEList();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RestapiPackage.PRIMITIVE_TYPE_SOURCE_REFERENCE__SIMPLE_TYPE:
				if (resolve) return getSimpleType();
				return basicGetSimpleType();
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
			case RestapiPackage.PRIMITIVE_TYPE_SOURCE_REFERENCE__SIMPLE_TYPE:
				setSimpleType((com.modelsolv.reprezen.restapi.PrimitiveType)newValue);
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
			case RestapiPackage.PRIMITIVE_TYPE_SOURCE_REFERENCE__SIMPLE_TYPE:
				setSimpleType((com.modelsolv.reprezen.restapi.PrimitiveType)null);
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
			case RestapiPackage.PRIMITIVE_TYPE_SOURCE_REFERENCE__SIMPLE_TYPE:
				return simpleType != null;
		}
		return super.eIsSet(featureID);
	}

} //PrimitiveTypeSourceReferenceImpl
