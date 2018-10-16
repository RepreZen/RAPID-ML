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

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.modelsolv.reprezen.restapi.RestapiPackage;
import com.modelsolv.reprezen.restapi.URI;
import com.modelsolv.reprezen.restapi.URIParameter;
import com.modelsolv.reprezen.restapi.URISegment;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>URI</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.modelsolv.reprezen.restapi.impl.URIImpl#getSegments <em>Segments</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.restapi.impl.URIImpl#getUriParameters <em>Uri Parameters</em>}</li>
 * </ul>
 *
 * @generated
 */
public class URIImpl extends EObjectImpl implements URI {
    /**
	 * The cached value of the '{@link #getSegments() <em>Segments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getSegments()
	 * @generated
	 * @ordered
	 */
    protected EList<URISegment> segments;

    /**
	 * The cached value of the '{@link #getUriParameters() <em>Uri Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getUriParameters()
	 * @generated
	 * @ordered
	 */
    protected EList<URIParameter> uriParameters;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected URIImpl() {
		super();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected EClass eStaticClass() {
		return RestapiPackage.Literals.URI;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList<URISegment> getSegments() {
		if (segments == null) {
			segments = new EObjectContainmentEList<URISegment>(URISegment.class, this, RestapiPackage.URI__SEGMENTS);
		}
		return segments;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList<URIParameter> getUriParameters() {
		if (uriParameters == null) {
			uriParameters = new EObjectContainmentWithInverseEList<URIParameter>(URIParameter.class, this, RestapiPackage.URI__URI_PARAMETERS, RestapiPackage.URI_PARAMETER__CONTAINING_URI);
		}
		return uriParameters;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public String toString() {
		if (eIsProxy()) {
			return super.toString();
		}
		StringBuffer result = new StringBuffer(super.toString());
		return com.modelsolv.reprezen.restapi.util.RestapiModelUtils.getStringValue(this, result);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RestapiPackage.URI__URI_PARAMETERS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getUriParameters()).basicAdd(otherEnd, msgs);
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
			case RestapiPackage.URI__SEGMENTS:
				return ((InternalEList<?>)getSegments()).basicRemove(otherEnd, msgs);
			case RestapiPackage.URI__URI_PARAMETERS:
				return ((InternalEList<?>)getUriParameters()).basicRemove(otherEnd, msgs);
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
			case RestapiPackage.URI__SEGMENTS:
				return getSegments();
			case RestapiPackage.URI__URI_PARAMETERS:
				return getUriParameters();
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
			case RestapiPackage.URI__SEGMENTS:
				getSegments().clear();
				getSegments().addAll((Collection<? extends URISegment>)newValue);
				return;
			case RestapiPackage.URI__URI_PARAMETERS:
				getUriParameters().clear();
				getUriParameters().addAll((Collection<? extends URIParameter>)newValue);
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
			case RestapiPackage.URI__SEGMENTS:
				getSegments().clear();
				return;
			case RestapiPackage.URI__URI_PARAMETERS:
				getUriParameters().clear();
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
			case RestapiPackage.URI__SEGMENTS:
				return segments != null && !segments.isEmpty();
			case RestapiPackage.URI__URI_PARAMETERS:
				return uriParameters != null && !uriParameters.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //URIImpl
