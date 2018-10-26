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

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.modelsolv.reprezen.rapidml.AuthenticationMethod;
import com.modelsolv.reprezen.rapidml.HasSecurityValue;
import com.modelsolv.reprezen.rapidml.RapidmlPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Has Security Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.modelsolv.reprezen.rapidml.impl.HasSecurityValueImpl#getSecuredBy <em>Secured By</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class HasSecurityValueImpl extends EObjectImpl implements HasSecurityValue {
    /**
	 * The cached value of the '{@link #getSecuredBy() <em>Secured By</em>}' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getSecuredBy()
	 * @generated
	 * @ordered
	 */
    protected EList<AuthenticationMethod> securedBy;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected HasSecurityValueImpl() {
		super();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected EClass eStaticClass() {
		return RapidmlPackage.Literals.HAS_SECURITY_VALUE;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList<AuthenticationMethod> getSecuredBy() {
		if (securedBy == null) {
			securedBy = new EObjectContainmentEList<AuthenticationMethod>(AuthenticationMethod.class, this, RapidmlPackage.HAS_SECURITY_VALUE__SECURED_BY);
		}
		return securedBy;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RapidmlPackage.HAS_SECURITY_VALUE__SECURED_BY:
				return ((InternalEList<?>)getSecuredBy()).basicRemove(otherEnd, msgs);
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
			case RapidmlPackage.HAS_SECURITY_VALUE__SECURED_BY:
				return getSecuredBy();
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
			case RapidmlPackage.HAS_SECURITY_VALUE__SECURED_BY:
				getSecuredBy().clear();
				getSecuredBy().addAll((Collection<? extends AuthenticationMethod>)newValue);
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
			case RapidmlPackage.HAS_SECURITY_VALUE__SECURED_BY:
				getSecuredBy().clear();
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
			case RapidmlPackage.HAS_SECURITY_VALUE__SECURED_BY:
				return securedBy != null && !securedBy.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //HasSecurityValueImpl
