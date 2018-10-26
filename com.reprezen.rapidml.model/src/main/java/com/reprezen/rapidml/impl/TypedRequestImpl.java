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

import com.reprezen.rapidml.Method;
import com.reprezen.rapidml.RapidmlPackage;
import com.reprezen.rapidml.TypedRequest;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Typed Request</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.reprezen.rapidml.impl.TypedRequestImpl#getContainingMethod <em>Containing Method</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TypedRequestImpl extends TypedMessageImpl implements TypedRequest {
    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected TypedRequestImpl() {
		super();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected EClass eStaticClass() {
		return RapidmlPackage.Literals.TYPED_REQUEST;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public Method getContainingMethod() {
		if (eContainerFeatureID() != RapidmlPackage.TYPED_REQUEST__CONTAINING_METHOD) return null;
		return (Method)eInternalContainer();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public NotificationChain basicSetContainingMethod(Method newContainingMethod, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newContainingMethod, RapidmlPackage.TYPED_REQUEST__CONTAINING_METHOD, msgs);
		return msgs;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setContainingMethod(Method newContainingMethod) {
		if (newContainingMethod != eInternalContainer() || (eContainerFeatureID() != RapidmlPackage.TYPED_REQUEST__CONTAINING_METHOD && newContainingMethod != null)) {
			if (EcoreUtil.isAncestor(this, newContainingMethod))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newContainingMethod != null)
				msgs = ((InternalEObject)newContainingMethod).eInverseAdd(this, RapidmlPackage.METHOD__REQUEST, Method.class, msgs);
			msgs = basicSetContainingMethod(newContainingMethod, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RapidmlPackage.TYPED_REQUEST__CONTAINING_METHOD, newContainingMethod, newContainingMethod));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RapidmlPackage.TYPED_REQUEST__CONTAINING_METHOD:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetContainingMethod((Method)otherEnd, msgs);
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
			case RapidmlPackage.TYPED_REQUEST__CONTAINING_METHOD:
				return basicSetContainingMethod(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case RapidmlPackage.TYPED_REQUEST__CONTAINING_METHOD:
				return eInternalContainer().eInverseRemove(this, RapidmlPackage.METHOD__REQUEST, Method.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RapidmlPackage.TYPED_REQUEST__CONTAINING_METHOD:
				return getContainingMethod();
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
			case RapidmlPackage.TYPED_REQUEST__CONTAINING_METHOD:
				setContainingMethod((Method)newValue);
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
			case RapidmlPackage.TYPED_REQUEST__CONTAINING_METHOD:
				setContainingMethod((Method)null);
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
			case RapidmlPackage.TYPED_REQUEST__CONTAINING_METHOD:
				return getContainingMethod() != null;
		}
		return super.eIsSet(featureID);
	}

} //TypedRequestImpl
