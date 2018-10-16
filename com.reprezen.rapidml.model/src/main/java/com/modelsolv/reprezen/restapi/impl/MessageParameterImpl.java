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

import com.modelsolv.reprezen.restapi.HttpMessageParameterLocation;
import com.modelsolv.reprezen.restapi.MessageParameter;
import com.modelsolv.reprezen.restapi.RestapiPackage;
import com.modelsolv.reprezen.restapi.TypedMessage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Message Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.modelsolv.reprezen.restapi.impl.MessageParameterImpl#getContainingMessage <em>Containing Message</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.restapi.impl.MessageParameterImpl#getHttpLocation <em>Http Location</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MessageParameterImpl extends ParameterImpl implements MessageParameter {
    /**
	 * The default value of the '{@link #getHttpLocation() <em>Http Location</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getHttpLocation()
	 * @generated
	 * @ordered
	 */
    protected static final HttpMessageParameterLocation HTTP_LOCATION_EDEFAULT = HttpMessageParameterLocation.NONE;

    /**
	 * The cached value of the '{@link #getHttpLocation() <em>Http Location</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getHttpLocation()
	 * @generated
	 * @ordered
	 */
    protected HttpMessageParameterLocation httpLocation = HTTP_LOCATION_EDEFAULT;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected MessageParameterImpl() {
		super();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected EClass eStaticClass() {
		return RestapiPackage.Literals.MESSAGE_PARAMETER;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public TypedMessage getContainingMessage() {
		if (eContainerFeatureID() != RestapiPackage.MESSAGE_PARAMETER__CONTAINING_MESSAGE) return null;
		return (TypedMessage)eInternalContainer();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public NotificationChain basicSetContainingMessage(TypedMessage newContainingMessage, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newContainingMessage, RestapiPackage.MESSAGE_PARAMETER__CONTAINING_MESSAGE, msgs);
		return msgs;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setContainingMessage(TypedMessage newContainingMessage) {
		if (newContainingMessage != eInternalContainer() || (eContainerFeatureID() != RestapiPackage.MESSAGE_PARAMETER__CONTAINING_MESSAGE && newContainingMessage != null)) {
			if (EcoreUtil.isAncestor(this, newContainingMessage))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newContainingMessage != null)
				msgs = ((InternalEObject)newContainingMessage).eInverseAdd(this, RestapiPackage.TYPED_MESSAGE__PARAMETERS, TypedMessage.class, msgs);
			msgs = basicSetContainingMessage(newContainingMessage, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RestapiPackage.MESSAGE_PARAMETER__CONTAINING_MESSAGE, newContainingMessage, newContainingMessage));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public HttpMessageParameterLocation getHttpLocation() {
		return httpLocation;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setHttpLocation(HttpMessageParameterLocation newHttpLocation) {
		HttpMessageParameterLocation oldHttpLocation = httpLocation;
		httpLocation = newHttpLocation == null ? HTTP_LOCATION_EDEFAULT : newHttpLocation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RestapiPackage.MESSAGE_PARAMETER__HTTP_LOCATION, oldHttpLocation, httpLocation));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RestapiPackage.MESSAGE_PARAMETER__CONTAINING_MESSAGE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetContainingMessage((TypedMessage)otherEnd, msgs);
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
			case RestapiPackage.MESSAGE_PARAMETER__CONTAINING_MESSAGE:
				return basicSetContainingMessage(null, msgs);
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
			case RestapiPackage.MESSAGE_PARAMETER__CONTAINING_MESSAGE:
				return eInternalContainer().eInverseRemove(this, RestapiPackage.TYPED_MESSAGE__PARAMETERS, TypedMessage.class, msgs);
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
			case RestapiPackage.MESSAGE_PARAMETER__CONTAINING_MESSAGE:
				return getContainingMessage();
			case RestapiPackage.MESSAGE_PARAMETER__HTTP_LOCATION:
				return getHttpLocation();
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
			case RestapiPackage.MESSAGE_PARAMETER__CONTAINING_MESSAGE:
				setContainingMessage((TypedMessage)newValue);
				return;
			case RestapiPackage.MESSAGE_PARAMETER__HTTP_LOCATION:
				setHttpLocation((HttpMessageParameterLocation)newValue);
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
			case RestapiPackage.MESSAGE_PARAMETER__CONTAINING_MESSAGE:
				setContainingMessage((TypedMessage)null);
				return;
			case RestapiPackage.MESSAGE_PARAMETER__HTTP_LOCATION:
				setHttpLocation(HTTP_LOCATION_EDEFAULT);
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
			case RestapiPackage.MESSAGE_PARAMETER__CONTAINING_MESSAGE:
				return getContainingMessage() != null;
			case RestapiPackage.MESSAGE_PARAMETER__HTTP_LOCATION:
				return httpLocation != HTTP_LOCATION_EDEFAULT;
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
		result.append(" (httpLocation: ");
		result.append(httpLocation);
		result.append(')');
		return result.toString();
	}

} //MessageParameterImpl
