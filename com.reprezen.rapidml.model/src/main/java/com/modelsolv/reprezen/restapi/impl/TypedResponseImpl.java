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
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.modelsolv.reprezen.restapi.Method;
import com.modelsolv.reprezen.restapi.RestapiPackage;
import com.modelsolv.reprezen.restapi.TypedResponse;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Typed Response</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.modelsolv.reprezen.restapi.impl.TypedResponseImpl#getStatusCode <em>Status Code</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.restapi.impl.TypedResponseImpl#getContainingMethod <em>Containing Method</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TypedResponseImpl extends TypedMessageImpl implements TypedResponse {
    /**
	 * The default value of the '{@link #getStatusCode() <em>Status Code</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getStatusCode()
	 * @generated
	 * @ordered
	 */
    protected static final int STATUS_CODE_EDEFAULT = -1;

    /**
	 * The cached value of the '{@link #getStatusCode() <em>Status Code</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getStatusCode()
	 * @generated
	 * @ordered
	 */
    protected int statusCode = STATUS_CODE_EDEFAULT;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected TypedResponseImpl() {
		super();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected EClass eStaticClass() {
		return RestapiPackage.Literals.TYPED_RESPONSE;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public int getStatusCode() {
		return statusCode;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setStatusCode(int newStatusCode) {
		int oldStatusCode = statusCode;
		statusCode = newStatusCode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RestapiPackage.TYPED_RESPONSE__STATUS_CODE, oldStatusCode, statusCode));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public Method getContainingMethod() {
		if (eContainerFeatureID() != RestapiPackage.TYPED_RESPONSE__CONTAINING_METHOD) return null;
		return (Method)eInternalContainer();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public NotificationChain basicSetContainingMethod(Method newContainingMethod, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newContainingMethod, RestapiPackage.TYPED_RESPONSE__CONTAINING_METHOD, msgs);
		return msgs;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setContainingMethod(Method newContainingMethod) {
		if (newContainingMethod != eInternalContainer() || (eContainerFeatureID() != RestapiPackage.TYPED_RESPONSE__CONTAINING_METHOD && newContainingMethod != null)) {
			if (EcoreUtil.isAncestor(this, newContainingMethod))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newContainingMethod != null)
				msgs = ((InternalEObject)newContainingMethod).eInverseAdd(this, RestapiPackage.METHOD__RESPONSES, Method.class, msgs);
			msgs = basicSetContainingMethod(newContainingMethod, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RestapiPackage.TYPED_RESPONSE__CONTAINING_METHOD, newContainingMethod, newContainingMethod));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RestapiPackage.TYPED_RESPONSE__CONTAINING_METHOD:
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
			case RestapiPackage.TYPED_RESPONSE__CONTAINING_METHOD:
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
			case RestapiPackage.TYPED_RESPONSE__CONTAINING_METHOD:
				return eInternalContainer().eInverseRemove(this, RestapiPackage.METHOD__RESPONSES, Method.class, msgs);
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
			case RestapiPackage.TYPED_RESPONSE__STATUS_CODE:
				return getStatusCode();
			case RestapiPackage.TYPED_RESPONSE__CONTAINING_METHOD:
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
			case RestapiPackage.TYPED_RESPONSE__STATUS_CODE:
				setStatusCode((Integer)newValue);
				return;
			case RestapiPackage.TYPED_RESPONSE__CONTAINING_METHOD:
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
			case RestapiPackage.TYPED_RESPONSE__STATUS_CODE:
				setStatusCode(STATUS_CODE_EDEFAULT);
				return;
			case RestapiPackage.TYPED_RESPONSE__CONTAINING_METHOD:
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
			case RestapiPackage.TYPED_RESPONSE__STATUS_CODE:
				return statusCode != STATUS_CODE_EDEFAULT;
			case RestapiPackage.TYPED_RESPONSE__CONTAINING_METHOD:
				return getContainingMethod() != null;
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
		result.append(" (statusCode: ");
		result.append(statusCode);
		result.append(')');
		return result.toString();
	}

} //TypedResponseImpl
