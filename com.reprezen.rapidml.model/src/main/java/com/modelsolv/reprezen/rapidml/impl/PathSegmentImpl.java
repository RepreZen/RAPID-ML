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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import com.modelsolv.reprezen.rapidml.PathSegment;
import com.modelsolv.reprezen.rapidml.RapidmlPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Path Segment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.modelsolv.reprezen.rapidml.impl.PathSegmentImpl#getReferenceElement <em>Reference Element</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class PathSegmentImpl extends EObjectImpl implements PathSegment {
    /**
	 * The cached value of the '{@link #getReferenceElement() <em>Reference Element</em>}' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getReferenceElement()
	 * @generated
	 * @ordered
	 */
    protected com.modelsolv.reprezen.rapidml.ReferenceElement referenceElement;
    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected PathSegmentImpl() {
		super();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected EClass eStaticClass() {
		return RapidmlPackage.Literals.PATH_SEGMENT;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public com.modelsolv.reprezen.rapidml.ReferenceElement getReferenceElement() {
		if (referenceElement != null && referenceElement.eIsProxy()) {
			InternalEObject oldReferenceElement = (InternalEObject)referenceElement;
			referenceElement = (com.modelsolv.reprezen.rapidml.ReferenceElement)eResolveProxy(oldReferenceElement);
			if (referenceElement != oldReferenceElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RapidmlPackage.PATH_SEGMENT__REFERENCE_ELEMENT, oldReferenceElement, referenceElement));
			}
		}
		return referenceElement;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public com.modelsolv.reprezen.rapidml.ReferenceElement basicGetReferenceElement() {
		return referenceElement;
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferenceElement(com.modelsolv.reprezen.rapidml.ReferenceElement newReferenceElement) {
		com.modelsolv.reprezen.rapidml.ReferenceElement oldReferenceElement = referenceElement;
		referenceElement = newReferenceElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RapidmlPackage.PATH_SEGMENT__REFERENCE_ELEMENT, oldReferenceElement, referenceElement));
	}

				/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RapidmlPackage.PATH_SEGMENT__REFERENCE_ELEMENT:
				if (resolve) return getReferenceElement();
				return basicGetReferenceElement();
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
			case RapidmlPackage.PATH_SEGMENT__REFERENCE_ELEMENT:
				setReferenceElement((com.modelsolv.reprezen.rapidml.ReferenceElement)newValue);
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
			case RapidmlPackage.PATH_SEGMENT__REFERENCE_ELEMENT:
				setReferenceElement((com.modelsolv.reprezen.rapidml.ReferenceElement)null);
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
			case RapidmlPackage.PATH_SEGMENT__REFERENCE_ELEMENT:
				return referenceElement != null;
		}
		return super.eIsSet(featureID);
	}

} //PathSegmentImpl
