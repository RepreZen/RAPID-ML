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
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.modelsolv.reprezen.restapi.AuthenticationFlows;
import com.modelsolv.reprezen.restapi.AuthenticationTypes;
import com.modelsolv.reprezen.restapi.Extensible;
import com.modelsolv.reprezen.restapi.Extension;
import com.modelsolv.reprezen.restapi.MessageParameter;
import com.modelsolv.reprezen.restapi.RESTElement;
import com.modelsolv.reprezen.restapi.RestapiPackage;
import com.modelsolv.reprezen.restapi.SecurityScheme;
import com.modelsolv.reprezen.restapi.SecuritySchemeParameter;
import com.modelsolv.reprezen.restapi.SecurityScope;
import com.modelsolv.reprezen.restapi.TypedResponse;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Security Scheme</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.modelsolv.reprezen.restapi.impl.SecuritySchemeImpl#getExtensions <em>Extensions</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.restapi.impl.SecuritySchemeImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.restapi.impl.SecuritySchemeImpl#getType <em>Type</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.restapi.impl.SecuritySchemeImpl#getScopes <em>Scopes</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.restapi.impl.SecuritySchemeImpl#getSettings <em>Settings</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.restapi.impl.SecuritySchemeImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.restapi.impl.SecuritySchemeImpl#getErrorResponses <em>Error Responses</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.restapi.impl.SecuritySchemeImpl#getFlow <em>Flow</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SecuritySchemeImpl extends DocumentableImpl implements SecurityScheme {
    /**
	 * The cached value of the '{@link #getExtensions() <em>Extensions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getExtensions()
	 * @generated
	 * @ordered
	 */
    protected EList<Extension> extensions;

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
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
    protected static final AuthenticationTypes TYPE_EDEFAULT = AuthenticationTypes.BASIC;

    /**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
    protected AuthenticationTypes type = TYPE_EDEFAULT;

    /**
	 * The cached value of the '{@link #getScopes() <em>Scopes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getScopes()
	 * @generated
	 * @ordered
	 */
    protected EList<SecurityScope> scopes;

    /**
	 * The cached value of the '{@link #getSettings() <em>Settings</em>}' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getSettings()
	 * @generated
	 * @ordered
	 */
    protected EList<SecuritySchemeParameter> settings;

    /**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
    protected EList<MessageParameter> parameters;

    /**
	 * The cached value of the '{@link #getErrorResponses() <em>Error Responses</em>}' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getErrorResponses()
	 * @generated
	 * @ordered
	 */
    protected EList<TypedResponse> errorResponses;

    /**
	 * The default value of the '{@link #getFlow() <em>Flow</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getFlow()
	 * @generated
	 * @ordered
	 */
    protected static final AuthenticationFlows FLOW_EDEFAULT = AuthenticationFlows.IMPLICIT;

    /**
	 * The cached value of the '{@link #getFlow() <em>Flow</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getFlow()
	 * @generated
	 * @ordered
	 */
    protected AuthenticationFlows flow = FLOW_EDEFAULT;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected SecuritySchemeImpl() {
		super();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected EClass eStaticClass() {
		return RestapiPackage.Literals.SECURITY_SCHEME;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList<Extension> getExtensions() {
		if (extensions == null) {
			extensions = new EObjectContainmentEList<Extension>(Extension.class, this, RestapiPackage.SECURITY_SCHEME__EXTENSIONS);
		}
		return extensions;
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
			eNotify(new ENotificationImpl(this, Notification.SET, RestapiPackage.SECURITY_SCHEME__NAME, oldName, name));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public AuthenticationTypes getType() {
		return type;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setType(AuthenticationTypes newType) {
		AuthenticationTypes oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RestapiPackage.SECURITY_SCHEME__TYPE, oldType, type));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList<SecurityScope> getScopes() {
		if (scopes == null) {
			scopes = new EObjectContainmentEList<SecurityScope>(SecurityScope.class, this, RestapiPackage.SECURITY_SCHEME__SCOPES);
		}
		return scopes;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList<SecuritySchemeParameter> getSettings() {
		if (settings == null) {
			settings = new EObjectContainmentEList<SecuritySchemeParameter>(SecuritySchemeParameter.class, this, RestapiPackage.SECURITY_SCHEME__SETTINGS);
		}
		return settings;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList<MessageParameter> getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentEList<MessageParameter>(MessageParameter.class, this, RestapiPackage.SECURITY_SCHEME__PARAMETERS);
		}
		return parameters;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList<TypedResponse> getErrorResponses() {
		if (errorResponses == null) {
			errorResponses = new EObjectContainmentEList<TypedResponse>(TypedResponse.class, this, RestapiPackage.SECURITY_SCHEME__ERROR_RESPONSES);
		}
		return errorResponses;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public AuthenticationFlows getFlow() {
		return flow;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setFlow(AuthenticationFlows newFlow) {
		AuthenticationFlows oldFlow = flow;
		flow = newFlow == null ? FLOW_EDEFAULT : newFlow;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RestapiPackage.SECURITY_SCHEME__FLOW, oldFlow, flow));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RestapiPackage.SECURITY_SCHEME__EXTENSIONS:
				return ((InternalEList<?>)getExtensions()).basicRemove(otherEnd, msgs);
			case RestapiPackage.SECURITY_SCHEME__SCOPES:
				return ((InternalEList<?>)getScopes()).basicRemove(otherEnd, msgs);
			case RestapiPackage.SECURITY_SCHEME__SETTINGS:
				return ((InternalEList<?>)getSettings()).basicRemove(otherEnd, msgs);
			case RestapiPackage.SECURITY_SCHEME__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
			case RestapiPackage.SECURITY_SCHEME__ERROR_RESPONSES:
				return ((InternalEList<?>)getErrorResponses()).basicRemove(otherEnd, msgs);
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
			case RestapiPackage.SECURITY_SCHEME__EXTENSIONS:
				return getExtensions();
			case RestapiPackage.SECURITY_SCHEME__NAME:
				return getName();
			case RestapiPackage.SECURITY_SCHEME__TYPE:
				return getType();
			case RestapiPackage.SECURITY_SCHEME__SCOPES:
				return getScopes();
			case RestapiPackage.SECURITY_SCHEME__SETTINGS:
				return getSettings();
			case RestapiPackage.SECURITY_SCHEME__PARAMETERS:
				return getParameters();
			case RestapiPackage.SECURITY_SCHEME__ERROR_RESPONSES:
				return getErrorResponses();
			case RestapiPackage.SECURITY_SCHEME__FLOW:
				return getFlow();
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
			case RestapiPackage.SECURITY_SCHEME__EXTENSIONS:
				getExtensions().clear();
				getExtensions().addAll((Collection<? extends Extension>)newValue);
				return;
			case RestapiPackage.SECURITY_SCHEME__NAME:
				setName((String)newValue);
				return;
			case RestapiPackage.SECURITY_SCHEME__TYPE:
				setType((AuthenticationTypes)newValue);
				return;
			case RestapiPackage.SECURITY_SCHEME__SCOPES:
				getScopes().clear();
				getScopes().addAll((Collection<? extends SecurityScope>)newValue);
				return;
			case RestapiPackage.SECURITY_SCHEME__SETTINGS:
				getSettings().clear();
				getSettings().addAll((Collection<? extends SecuritySchemeParameter>)newValue);
				return;
			case RestapiPackage.SECURITY_SCHEME__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends MessageParameter>)newValue);
				return;
			case RestapiPackage.SECURITY_SCHEME__ERROR_RESPONSES:
				getErrorResponses().clear();
				getErrorResponses().addAll((Collection<? extends TypedResponse>)newValue);
				return;
			case RestapiPackage.SECURITY_SCHEME__FLOW:
				setFlow((AuthenticationFlows)newValue);
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
			case RestapiPackage.SECURITY_SCHEME__EXTENSIONS:
				getExtensions().clear();
				return;
			case RestapiPackage.SECURITY_SCHEME__NAME:
				setName(NAME_EDEFAULT);
				return;
			case RestapiPackage.SECURITY_SCHEME__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case RestapiPackage.SECURITY_SCHEME__SCOPES:
				getScopes().clear();
				return;
			case RestapiPackage.SECURITY_SCHEME__SETTINGS:
				getSettings().clear();
				return;
			case RestapiPackage.SECURITY_SCHEME__PARAMETERS:
				getParameters().clear();
				return;
			case RestapiPackage.SECURITY_SCHEME__ERROR_RESPONSES:
				getErrorResponses().clear();
				return;
			case RestapiPackage.SECURITY_SCHEME__FLOW:
				setFlow(FLOW_EDEFAULT);
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
			case RestapiPackage.SECURITY_SCHEME__EXTENSIONS:
				return extensions != null && !extensions.isEmpty();
			case RestapiPackage.SECURITY_SCHEME__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case RestapiPackage.SECURITY_SCHEME__TYPE:
				return type != TYPE_EDEFAULT;
			case RestapiPackage.SECURITY_SCHEME__SCOPES:
				return scopes != null && !scopes.isEmpty();
			case RestapiPackage.SECURITY_SCHEME__SETTINGS:
				return settings != null && !settings.isEmpty();
			case RestapiPackage.SECURITY_SCHEME__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case RestapiPackage.SECURITY_SCHEME__ERROR_RESPONSES:
				return errorResponses != null && !errorResponses.isEmpty();
			case RestapiPackage.SECURITY_SCHEME__FLOW:
				return flow != FLOW_EDEFAULT;
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
		if (baseClass == Extensible.class) {
			switch (derivedFeatureID) {
				case RestapiPackage.SECURITY_SCHEME__EXTENSIONS: return RestapiPackage.EXTENSIBLE__EXTENSIONS;
				default: return -1;
			}
		}
		if (baseClass == RESTElement.class) {
			switch (derivedFeatureID) {
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
		if (baseClass == Extensible.class) {
			switch (baseFeatureID) {
				case RestapiPackage.EXTENSIBLE__EXTENSIONS: return RestapiPackage.SECURITY_SCHEME__EXTENSIONS;
				default: return -1;
			}
		}
		if (baseClass == RESTElement.class) {
			switch (baseFeatureID) {
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
		result.append(" (name: ");
		result.append(name);
		result.append(", type: ");
		result.append(type);
		result.append(", flow: ");
		result.append(flow);
		result.append(')');
		return result.toString();
	}

} //SecuritySchemeImpl
