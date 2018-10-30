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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import com.google.common.base.Strings;
import com.reprezen.rapidml.AuthenticationMethod;
import com.reprezen.rapidml.HTTPMethods;
import com.reprezen.rapidml.HasSecurityValue;
import com.reprezen.rapidml.Method;
import com.reprezen.rapidml.ResourceDefinition;
import com.reprezen.rapidml.RapidmlFactory;
import com.reprezen.rapidml.RapidmlPackage;
import com.reprezen.rapidml.TypedRequest;
import com.reprezen.rapidml.TypedResponse;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Method</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.reprezen.rapidml.impl.MethodImpl#getSecuredBy <em>Secured By</em>}</li>
 *   <li>{@link com.reprezen.rapidml.impl.MethodImpl#getRequest <em>Request</em>}</li>
 *   <li>{@link com.reprezen.rapidml.impl.MethodImpl#getResponses <em>Responses</em>}</li>
 *   <li>{@link com.reprezen.rapidml.impl.MethodImpl#getId <em>Id</em>}</li>
 *   <li>{@link com.reprezen.rapidml.impl.MethodImpl#getHttpMethod <em>Http Method</em>}</li>
 *   <li>{@link com.reprezen.rapidml.impl.MethodImpl#getContainingResourceDefinition <em>Containing Resource Definition</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MethodImpl extends RESTElementImpl implements Method {
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
	 * The cached value of the '{@link #getRequest() <em>Request</em>}' containment reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getRequest()
	 * @generated
	 * @ordered
	 */
    protected TypedRequest request;

    /**
	 * The cached value of the '{@link #getResponses() <em>Responses</em>}' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getResponses()
	 * @generated
	 * @ordered
	 */
    protected EList<TypedResponse> responses;

    /**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
    protected static final String ID_EDEFAULT = null;

    /**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
    protected String id = ID_EDEFAULT;

    /**
	 * The default value of the '{@link #getHttpMethod() <em>Http Method</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getHttpMethod()
	 * @generated
	 * @ordered
	 */
    protected static final HTTPMethods HTTP_METHOD_EDEFAULT = HTTPMethods.GET;

    /**
	 * The cached value of the '{@link #getHttpMethod() <em>Http Method</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getHttpMethod()
	 * @generated
	 * @ordered
	 */
    protected HTTPMethods httpMethod = HTTP_METHOD_EDEFAULT;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected MethodImpl() {
		super();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected EClass eStaticClass() {
		return RapidmlPackage.Literals.METHOD;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList<AuthenticationMethod> getSecuredBy() {
		if (securedBy == null) {
			securedBy = new EObjectContainmentEList<AuthenticationMethod>(AuthenticationMethod.class, this, RapidmlPackage.METHOD__SECURED_BY);
		}
		return securedBy;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public TypedRequest getRequest() {
		return request;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public NotificationChain basicSetRequest(TypedRequest newRequest, NotificationChain msgs) {
		TypedRequest oldRequest = request;
		request = newRequest;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RapidmlPackage.METHOD__REQUEST, oldRequest, newRequest);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setRequest(TypedRequest newRequest) {
		if (newRequest != request) {
			NotificationChain msgs = null;
			if (request != null)
				msgs = ((InternalEObject)request).eInverseRemove(this, RapidmlPackage.TYPED_REQUEST__CONTAINING_METHOD, TypedRequest.class, msgs);
			if (newRequest != null)
				msgs = ((InternalEObject)newRequest).eInverseAdd(this, RapidmlPackage.TYPED_REQUEST__CONTAINING_METHOD, TypedRequest.class, msgs);
			msgs = basicSetRequest(newRequest, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RapidmlPackage.METHOD__REQUEST, newRequest, newRequest));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList<TypedResponse> getResponses() {
		if (responses == null) {
			responses = new EObjectContainmentWithInverseEList<TypedResponse>(TypedResponse.class, this, RapidmlPackage.METHOD__RESPONSES, RapidmlPackage.TYPED_RESPONSE__CONTAINING_METHOD);
		}
		return responses;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public String getId() {
		return id;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RapidmlPackage.METHOD__ID, oldId, id));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public HTTPMethods getHttpMethod() {
		return httpMethod;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setHttpMethod(HTTPMethods newHttpMethod) {
		HTTPMethods oldHttpMethod = httpMethod;
		httpMethod = newHttpMethod == null ? HTTP_METHOD_EDEFAULT : newHttpMethod;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RapidmlPackage.METHOD__HTTP_METHOD, oldHttpMethod, httpMethod));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public ResourceDefinition getContainingResourceDefinition() {
		if (eContainerFeatureID() != RapidmlPackage.METHOD__CONTAINING_RESOURCE_DEFINITION) return null;
		return (ResourceDefinition)eInternalContainer();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public NotificationChain basicSetContainingResourceDefinition(ResourceDefinition newContainingResourceDefinition, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newContainingResourceDefinition, RapidmlPackage.METHOD__CONTAINING_RESOURCE_DEFINITION, msgs);
		return msgs;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setContainingResourceDefinition(ResourceDefinition newContainingResourceDefinition) {
		if (newContainingResourceDefinition != eInternalContainer() || (eContainerFeatureID() != RapidmlPackage.METHOD__CONTAINING_RESOURCE_DEFINITION && newContainingResourceDefinition != null)) {
			if (EcoreUtil.isAncestor(this, newContainingResourceDefinition))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newContainingResourceDefinition != null)
				msgs = ((InternalEObject)newContainingResourceDefinition).eInverseAdd(this, RapidmlPackage.RESOURCE_DEFINITION__METHODS, ResourceDefinition.class, msgs);
			msgs = basicSetContainingResourceDefinition(newContainingResourceDefinition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RapidmlPackage.METHOD__CONTAINING_RESOURCE_DEFINITION, newContainingResourceDefinition, newContainingResourceDefinition));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public String getName() {
		if (getId() == null || Strings.isNullOrEmpty(getId().trim())) {
		    return getHttpMethod().toString().toLowerCase() + getContainingResourceDefinition().getName();
		}
		return getId();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RapidmlPackage.METHOD__REQUEST:
				if (request != null)
					msgs = ((InternalEObject)request).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RapidmlPackage.METHOD__REQUEST, null, msgs);
				return basicSetRequest((TypedRequest)otherEnd, msgs);
			case RapidmlPackage.METHOD__RESPONSES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getResponses()).basicAdd(otherEnd, msgs);
			case RapidmlPackage.METHOD__CONTAINING_RESOURCE_DEFINITION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetContainingResourceDefinition((ResourceDefinition)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

    protected boolean needsDefaultRequest() {
        return true;
    }

    protected TypedRequest createDefaultRequest() {
        TypedRequest result = RapidmlFactory.eINSTANCE.createTypedRequest();
        switch (getHttpMethod()) {
        case PUT:
        case POST:
        case PATCH:
        case DELETE:
            ResourceDefinition containingResource = (ResourceDefinition) eContainer();
            result.setResourceType(containingResource);
            break;
        default: // do nothing;
        }
        return result;
    }

    protected boolean needsDefaultResponse() {
        return true;
    }

    protected TypedResponse createDefaultResponse() {
        TypedResponse result = RapidmlFactory.eINSTANCE.createTypedResponse();
        result.setStatusCode(200);
        switch (getHttpMethod()) {
        case GET:
        case POST:
        case PATCH:
        case DELETE:
            ResourceDefinition containingResource = (ResourceDefinition) eContainer();
            result.setResourceType(containingResource);
            break;
        default: // do nothing;
        }
        return result;
    }
    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RapidmlPackage.METHOD__SECURED_BY:
				return ((InternalEList<?>)getSecuredBy()).basicRemove(otherEnd, msgs);
			case RapidmlPackage.METHOD__REQUEST:
				return basicSetRequest(null, msgs);
			case RapidmlPackage.METHOD__RESPONSES:
				return ((InternalEList<?>)getResponses()).basicRemove(otherEnd, msgs);
			case RapidmlPackage.METHOD__CONTAINING_RESOURCE_DEFINITION:
				return basicSetContainingResourceDefinition(null, msgs);
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
			case RapidmlPackage.METHOD__CONTAINING_RESOURCE_DEFINITION:
				return eInternalContainer().eInverseRemove(this, RapidmlPackage.RESOURCE_DEFINITION__METHODS, ResourceDefinition.class, msgs);
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
			case RapidmlPackage.METHOD__SECURED_BY:
				return getSecuredBy();
			case RapidmlPackage.METHOD__REQUEST:
				return getRequest();
			case RapidmlPackage.METHOD__RESPONSES:
				return getResponses();
			case RapidmlPackage.METHOD__ID:
				return getId();
			case RapidmlPackage.METHOD__HTTP_METHOD:
				return getHttpMethod();
			case RapidmlPackage.METHOD__CONTAINING_RESOURCE_DEFINITION:
				return getContainingResourceDefinition();
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
			case RapidmlPackage.METHOD__SECURED_BY:
				getSecuredBy().clear();
				getSecuredBy().addAll((Collection<? extends AuthenticationMethod>)newValue);
				return;
			case RapidmlPackage.METHOD__REQUEST:
				setRequest((TypedRequest)newValue);
				return;
			case RapidmlPackage.METHOD__RESPONSES:
				getResponses().clear();
				getResponses().addAll((Collection<? extends TypedResponse>)newValue);
				return;
			case RapidmlPackage.METHOD__ID:
				setId((String)newValue);
				return;
			case RapidmlPackage.METHOD__HTTP_METHOD:
				setHttpMethod((HTTPMethods)newValue);
				return;
			case RapidmlPackage.METHOD__CONTAINING_RESOURCE_DEFINITION:
				setContainingResourceDefinition((ResourceDefinition)newValue);
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
			case RapidmlPackage.METHOD__SECURED_BY:
				getSecuredBy().clear();
				return;
			case RapidmlPackage.METHOD__REQUEST:
				setRequest((TypedRequest)null);
				return;
			case RapidmlPackage.METHOD__RESPONSES:
				getResponses().clear();
				return;
			case RapidmlPackage.METHOD__ID:
				setId(ID_EDEFAULT);
				return;
			case RapidmlPackage.METHOD__HTTP_METHOD:
				setHttpMethod(HTTP_METHOD_EDEFAULT);
				return;
			case RapidmlPackage.METHOD__CONTAINING_RESOURCE_DEFINITION:
				setContainingResourceDefinition((ResourceDefinition)null);
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
			case RapidmlPackage.METHOD__SECURED_BY:
				return securedBy != null && !securedBy.isEmpty();
			case RapidmlPackage.METHOD__REQUEST:
				return request != null;
			case RapidmlPackage.METHOD__RESPONSES:
				return responses != null && !responses.isEmpty();
			case RapidmlPackage.METHOD__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case RapidmlPackage.METHOD__HTTP_METHOD:
				return httpMethod != HTTP_METHOD_EDEFAULT;
			case RapidmlPackage.METHOD__CONTAINING_RESOURCE_DEFINITION:
				return getContainingResourceDefinition() != null;
		}
		return super.eIsSet(featureID);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == HasSecurityValue.class) {
			switch (derivedFeatureID) {
				case RapidmlPackage.METHOD__SECURED_BY: return RapidmlPackage.HAS_SECURITY_VALUE__SECURED_BY;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == HasSecurityValue.class) {
			switch (baseFeatureID) {
				case RapidmlPackage.HAS_SECURITY_VALUE__SECURED_BY: return RapidmlPackage.METHOD__SECURED_BY;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (id: ");
		result.append(id);
		result.append(", httpMethod: ");
		result.append(httpMethod);
		result.append(')');
		return result.toString();
	}

} //MethodImpl
