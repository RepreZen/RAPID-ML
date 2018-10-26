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
import org.eclipse.emf.ecore.util.InternalEList;

import com.modelsolv.reprezen.rapidml.RapidmlPackage;
import com.modelsolv.reprezen.rapidml.SecurityScheme;
import com.modelsolv.reprezen.rapidml.SecuritySchemeLibrary;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Security Scheme Library</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.modelsolv.reprezen.rapidml.impl.SecuritySchemeLibraryImpl#getSecuritySchemes <em>Security Schemes</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.rapidml.impl.SecuritySchemeLibraryImpl#getName <em>Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SecuritySchemeLibraryImpl extends DocumentableImpl implements SecuritySchemeLibrary {
    /**
	 * The cached value of the '{@link #getSecuritySchemes() <em>Security Schemes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getSecuritySchemes()
	 * @generated
	 * @ordered
	 */
    protected EList<SecurityScheme> securitySchemes;

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
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected SecuritySchemeLibraryImpl() {
		super();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected EClass eStaticClass() {
		return RapidmlPackage.Literals.SECURITY_SCHEME_LIBRARY;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList<SecurityScheme> getSecuritySchemes() {
		if (securitySchemes == null) {
			securitySchemes = new EObjectContainmentEList<SecurityScheme>(SecurityScheme.class, this, RapidmlPackage.SECURITY_SCHEME_LIBRARY__SECURITY_SCHEMES);
		}
		return securitySchemes;
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
			eNotify(new ENotificationImpl(this, Notification.SET, RapidmlPackage.SECURITY_SCHEME_LIBRARY__NAME, oldName, name));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RapidmlPackage.SECURITY_SCHEME_LIBRARY__SECURITY_SCHEMES:
				return ((InternalEList<?>)getSecuritySchemes()).basicRemove(otherEnd, msgs);
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
			case RapidmlPackage.SECURITY_SCHEME_LIBRARY__SECURITY_SCHEMES:
				return getSecuritySchemes();
			case RapidmlPackage.SECURITY_SCHEME_LIBRARY__NAME:
				return getName();
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
			case RapidmlPackage.SECURITY_SCHEME_LIBRARY__SECURITY_SCHEMES:
				getSecuritySchemes().clear();
				getSecuritySchemes().addAll((Collection<? extends SecurityScheme>)newValue);
				return;
			case RapidmlPackage.SECURITY_SCHEME_LIBRARY__NAME:
				setName((String)newValue);
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
			case RapidmlPackage.SECURITY_SCHEME_LIBRARY__SECURITY_SCHEMES:
				getSecuritySchemes().clear();
				return;
			case RapidmlPackage.SECURITY_SCHEME_LIBRARY__NAME:
				setName(NAME_EDEFAULT);
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
			case RapidmlPackage.SECURITY_SCHEME_LIBRARY__SECURITY_SCHEMES:
				return securitySchemes != null && !securitySchemes.isEmpty();
			case RapidmlPackage.SECURITY_SCHEME_LIBRARY__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //SecuritySchemeLibraryImpl
