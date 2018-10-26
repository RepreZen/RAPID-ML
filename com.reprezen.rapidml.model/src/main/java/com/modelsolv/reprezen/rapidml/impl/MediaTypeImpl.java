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
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import com.modelsolv.reprezen.rapidml.MediaType;
import com.modelsolv.reprezen.rapidml.RapidmlPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Media Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.modelsolv.reprezen.rapidml.impl.MediaTypeImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.rapidml.impl.MediaTypeImpl#getSpecURL <em>Spec URL</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.rapidml.impl.MediaTypeImpl#getDerivedFrom <em>Derived From</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MediaTypeImpl extends RESTElementImpl implements MediaType {
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
	 * The default value of the '{@link #getSpecURL() <em>Spec URL</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getSpecURL()
	 * @generated
	 * @ordered
	 */
    protected static final String SPEC_URL_EDEFAULT = null;

    /**
	 * The cached value of the '{@link #getSpecURL() <em>Spec URL</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getSpecURL()
	 * @generated
	 * @ordered
	 */
    protected String specURL = SPEC_URL_EDEFAULT;

    /**
	 * The cached value of the '{@link #getDerivedFrom() <em>Derived From</em>}' reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getDerivedFrom()
	 * @generated
	 * @ordered
	 */
    protected EList<MediaType> derivedFrom;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected MediaTypeImpl() {
		super();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected EClass eStaticClass() {
		return RapidmlPackage.Literals.MEDIA_TYPE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, RapidmlPackage.MEDIA_TYPE__NAME, oldName, name));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public String getSpecURL() {
		return specURL;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setSpecURL(String newSpecURL) {
		String oldSpecURL = specURL;
		specURL = newSpecURL;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RapidmlPackage.MEDIA_TYPE__SPEC_URL, oldSpecURL, specURL));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList<MediaType> getDerivedFrom() {
		if (derivedFrom == null) {
			derivedFrom = new EObjectResolvingEList<MediaType>(MediaType.class, this, RapidmlPackage.MEDIA_TYPE__DERIVED_FROM);
		}
		return derivedFrom;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public int hashCode() {
		return null == getName() ? 0 : getName().hashCode();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public boolean equals(final Object other) {
		if (other == null || !(other instanceof MediaType)) {
		    return false;
		}
		MediaType otherMediaType = (MediaType) other;
		String otherName = otherMediaType.getName();
		String thisName = this.getName();        
		if (otherName == null && thisName == null) {
		    return true;
		}
		if (otherName == null || thisName == null) {
			return false;
		}       
		// Media types are not case sensitive.
		return thisName.equalsIgnoreCase((otherName));
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RapidmlPackage.MEDIA_TYPE__NAME:
				return getName();
			case RapidmlPackage.MEDIA_TYPE__SPEC_URL:
				return getSpecURL();
			case RapidmlPackage.MEDIA_TYPE__DERIVED_FROM:
				return getDerivedFrom();
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
			case RapidmlPackage.MEDIA_TYPE__NAME:
				setName((String)newValue);
				return;
			case RapidmlPackage.MEDIA_TYPE__SPEC_URL:
				setSpecURL((String)newValue);
				return;
			case RapidmlPackage.MEDIA_TYPE__DERIVED_FROM:
				getDerivedFrom().clear();
				getDerivedFrom().addAll((Collection<? extends MediaType>)newValue);
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
			case RapidmlPackage.MEDIA_TYPE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case RapidmlPackage.MEDIA_TYPE__SPEC_URL:
				setSpecURL(SPEC_URL_EDEFAULT);
				return;
			case RapidmlPackage.MEDIA_TYPE__DERIVED_FROM:
				getDerivedFrom().clear();
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
			case RapidmlPackage.MEDIA_TYPE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case RapidmlPackage.MEDIA_TYPE__SPEC_URL:
				return SPEC_URL_EDEFAULT == null ? specURL != null : !SPEC_URL_EDEFAULT.equals(specURL);
			case RapidmlPackage.MEDIA_TYPE__DERIVED_FROM:
				return derivedFrom != null && !derivedFrom.isEmpty();
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
		result.append(", specURL: ");
		result.append(specURL);
		result.append(')');
		return result.toString();
	}

} //MediaTypeImpl
