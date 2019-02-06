/**
 * Copyright © 2013-2016 Modelsolv, Inc.
 * All Rights Reserved.
 * 
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 */
package com.reprezen.rapidml.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.reprezen.rapidml.MediaType;
import com.reprezen.rapidml.MediaTypesLibrary;
import com.reprezen.rapidml.RapidmlPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Media
 * Types Library</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link com.reprezen.rapidml.impl.MediaTypesLibraryImpl#getMediaTypes
 * <em>Media Types</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MediaTypesLibraryImpl extends EObjectImpl implements MediaTypesLibrary {
	/**
	 * The cached value of the '{@link #getMediaTypes() <em>Media Types</em>}'
	 * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getMediaTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<MediaType> mediaTypes;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected MediaTypesLibraryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RapidmlPackage.Literals.MEDIA_TYPES_LIBRARY;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<MediaType> getMediaTypes() {
		if (mediaTypes == null) {
			mediaTypes = new EObjectContainmentEList.Unsettable<MediaType>(MediaType.class, this,
					RapidmlPackage.MEDIA_TYPES_LIBRARY__MEDIA_TYPES);
		}
		return mediaTypes;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void unsetMediaTypes() {
		if (mediaTypes != null)
			((InternalEList.Unsettable<?>) mediaTypes).unset();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isSetMediaTypes() {
		return mediaTypes != null && ((InternalEList.Unsettable<?>) mediaTypes).isSet();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case RapidmlPackage.MEDIA_TYPES_LIBRARY__MEDIA_TYPES:
			return ((InternalEList<?>) getMediaTypes()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case RapidmlPackage.MEDIA_TYPES_LIBRARY__MEDIA_TYPES:
			return getMediaTypes();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case RapidmlPackage.MEDIA_TYPES_LIBRARY__MEDIA_TYPES:
			getMediaTypes().clear();
			getMediaTypes().addAll((Collection<? extends MediaType>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case RapidmlPackage.MEDIA_TYPES_LIBRARY__MEDIA_TYPES:
			unsetMediaTypes();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case RapidmlPackage.MEDIA_TYPES_LIBRARY__MEDIA_TYPES:
			return isSetMediaTypes();
		}
		return super.eIsSet(featureID);
	}

} // MediaTypesLibraryImpl
