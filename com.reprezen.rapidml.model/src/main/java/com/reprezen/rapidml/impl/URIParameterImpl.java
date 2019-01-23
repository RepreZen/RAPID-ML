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
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.reprezen.rapidml.RapidmlPackage;
import com.reprezen.rapidml.URI;
import com.reprezen.rapidml.URIParameter;
import com.reprezen.rapidml.URISegmentWithParameter;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>URI
 * Parameter</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link com.reprezen.rapidml.impl.URIParameterImpl#getUriSegment <em>Uri
 * Segment</em>}</li>
 * <li>{@link com.reprezen.rapidml.impl.URIParameterImpl#getContainingURI
 * <em>Containing URI</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class URIParameterImpl extends ParameterImpl implements URIParameter {
	/**
	 * The cached value of the '{@link #getUriSegment() <em>Uri Segment</em>}'
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getUriSegment()
	 * @generated
	 * @ordered
	 */
	protected URISegmentWithParameter uriSegment;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected URIParameterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RapidmlPackage.Literals.URI_PARAMETER;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public URISegmentWithParameter getUriSegment() {
		if (uriSegment != null && uriSegment.eIsProxy()) {
			InternalEObject oldUriSegment = (InternalEObject) uriSegment;
			uriSegment = (URISegmentWithParameter) eResolveProxy(oldUriSegment);
			if (uriSegment != oldUriSegment) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RapidmlPackage.URI_PARAMETER__URI_SEGMENT,
							oldUriSegment, uriSegment));
			}
		}
		return uriSegment;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public URISegmentWithParameter basicGetUriSegment() {
		return uriSegment;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setUriSegment(URISegmentWithParameter newUriSegment) {
		URISegmentWithParameter oldUriSegment = uriSegment;
		uriSegment = newUriSegment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RapidmlPackage.URI_PARAMETER__URI_SEGMENT,
					oldUriSegment, uriSegment));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public URI getContainingURI() {
		if (eContainerFeatureID() != RapidmlPackage.URI_PARAMETER__CONTAINING_URI)
			return null;
		return (URI) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetContainingURI(URI newContainingURI, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newContainingURI, RapidmlPackage.URI_PARAMETER__CONTAINING_URI,
				msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setContainingURI(URI newContainingURI) {
		if (newContainingURI != eInternalContainer()
				|| (eContainerFeatureID() != RapidmlPackage.URI_PARAMETER__CONTAINING_URI
						&& newContainingURI != null)) {
			if (EcoreUtil.isAncestor(this, newContainingURI))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newContainingURI != null)
				msgs = ((InternalEObject) newContainingURI).eInverseAdd(this, RapidmlPackage.URI__URI_PARAMETERS,
						URI.class, msgs);
			msgs = basicSetContainingURI(newContainingURI, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RapidmlPackage.URI_PARAMETER__CONTAINING_URI,
					newContainingURI, newContainingURI));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getName() {
		if (uriSegment != null) {
			return uriSegment.getName();
		}
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case RapidmlPackage.URI_PARAMETER__CONTAINING_URI:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetContainingURI((URI) otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case RapidmlPackage.URI_PARAMETER__CONTAINING_URI:
			return basicSetContainingURI(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
		case RapidmlPackage.URI_PARAMETER__CONTAINING_URI:
			return eInternalContainer().eInverseRemove(this, RapidmlPackage.URI__URI_PARAMETERS, URI.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case RapidmlPackage.URI_PARAMETER__URI_SEGMENT:
			if (resolve)
				return getUriSegment();
			return basicGetUriSegment();
		case RapidmlPackage.URI_PARAMETER__CONTAINING_URI:
			return getContainingURI();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case RapidmlPackage.URI_PARAMETER__URI_SEGMENT:
			setUriSegment((URISegmentWithParameter) newValue);
			return;
		case RapidmlPackage.URI_PARAMETER__CONTAINING_URI:
			setContainingURI((URI) newValue);
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
		case RapidmlPackage.URI_PARAMETER__URI_SEGMENT:
			setUriSegment((URISegmentWithParameter) null);
			return;
		case RapidmlPackage.URI_PARAMETER__CONTAINING_URI:
			setContainingURI((URI) null);
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
		case RapidmlPackage.URI_PARAMETER__URI_SEGMENT:
			return uriSegment != null;
		case RapidmlPackage.URI_PARAMETER__CONTAINING_URI:
			return getContainingURI() != null;
		}
		return super.eIsSet(featureID);
	}

} // URIParameterImpl
