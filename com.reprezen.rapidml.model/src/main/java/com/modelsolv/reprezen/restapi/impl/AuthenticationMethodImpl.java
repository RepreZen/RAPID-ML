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
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import com.modelsolv.reprezen.restapi.AuthenticationMethod;
import com.modelsolv.reprezen.restapi.RestapiPackage;
import com.modelsolv.reprezen.restapi.SecurityScheme;
import com.modelsolv.reprezen.restapi.SecurityScope;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Authentication Method</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.modelsolv.reprezen.restapi.impl.AuthenticationMethodImpl#getScheme <em>Scheme</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.restapi.impl.AuthenticationMethodImpl#getScopes <em>Scopes</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AuthenticationMethodImpl extends EObjectImpl implements AuthenticationMethod {
    /**
	 * The cached value of the '{@link #getScheme() <em>Scheme</em>}' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getScheme()
	 * @generated
	 * @ordered
	 */
    protected SecurityScheme scheme;

    /**
	 * The cached value of the '{@link #getScopes() <em>Scopes</em>}' reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getScopes()
	 * @generated
	 * @ordered
	 */
    protected EList<SecurityScope> scopes;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected AuthenticationMethodImpl() {
		super();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected EClass eStaticClass() {
		return RestapiPackage.Literals.AUTHENTICATION_METHOD;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public SecurityScheme getScheme() {
		if (scheme != null && scheme.eIsProxy()) {
			InternalEObject oldScheme = (InternalEObject)scheme;
			scheme = (SecurityScheme)eResolveProxy(oldScheme);
			if (scheme != oldScheme) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RestapiPackage.AUTHENTICATION_METHOD__SCHEME, oldScheme, scheme));
			}
		}
		return scheme;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public SecurityScheme basicGetScheme() {
		return scheme;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setScheme(SecurityScheme newScheme) {
		SecurityScheme oldScheme = scheme;
		scheme = newScheme;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RestapiPackage.AUTHENTICATION_METHOD__SCHEME, oldScheme, scheme));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList<SecurityScope> getScopes() {
		if (scopes == null) {
			scopes = new EObjectResolvingEList<SecurityScope>(SecurityScope.class, this, RestapiPackage.AUTHENTICATION_METHOD__SCOPES);
		}
		return scopes;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RestapiPackage.AUTHENTICATION_METHOD__SCHEME:
				if (resolve) return getScheme();
				return basicGetScheme();
			case RestapiPackage.AUTHENTICATION_METHOD__SCOPES:
				return getScopes();
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
			case RestapiPackage.AUTHENTICATION_METHOD__SCHEME:
				setScheme((SecurityScheme)newValue);
				return;
			case RestapiPackage.AUTHENTICATION_METHOD__SCOPES:
				getScopes().clear();
				getScopes().addAll((Collection<? extends SecurityScope>)newValue);
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
			case RestapiPackage.AUTHENTICATION_METHOD__SCHEME:
				setScheme((SecurityScheme)null);
				return;
			case RestapiPackage.AUTHENTICATION_METHOD__SCOPES:
				getScopes().clear();
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
			case RestapiPackage.AUTHENTICATION_METHOD__SCHEME:
				return scheme != null;
			case RestapiPackage.AUTHENTICATION_METHOD__SCOPES:
				return scopes != null && !scopes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //AuthenticationMethodImpl
