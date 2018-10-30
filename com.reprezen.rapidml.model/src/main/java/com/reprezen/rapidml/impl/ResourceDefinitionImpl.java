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
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.reprezen.rapidml.AuthenticationMethod;
import com.reprezen.rapidml.Example;
import com.reprezen.rapidml.HasSecurityValue;
import com.reprezen.rapidml.MediaType;
import com.reprezen.rapidml.Method;
import com.reprezen.rapidml.ResourceDefinition;
import com.reprezen.rapidml.RapidmlPackage;
import com.reprezen.rapidml.URI;
import com.reprezen.rapidml.WithExamples;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.reprezen.rapidml.impl.ResourceDefinitionImpl#getExamples <em>Examples</em>}</li>
 *   <li>{@link com.reprezen.rapidml.impl.ResourceDefinitionImpl#getSecuredBy <em>Secured By</em>}</li>
 *   <li>{@link com.reprezen.rapidml.impl.ResourceDefinitionImpl#getMethods <em>Methods</em>}</li>
 *   <li>{@link com.reprezen.rapidml.impl.ResourceDefinitionImpl#getMediaTypes <em>Media Types</em>}</li>
 *   <li>{@link com.reprezen.rapidml.impl.ResourceDefinitionImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.reprezen.rapidml.impl.ResourceDefinitionImpl#getAllMediaTypes <em>All Media Types</em>}</li>
 *   <li>{@link com.reprezen.rapidml.impl.ResourceDefinitionImpl#getURI <em>URI</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ResourceDefinitionImpl extends RESTElementImpl implements ResourceDefinition {
    /**
	 * The cached value of the '{@link #getExamples() <em>Examples</em>}' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getExamples()
	 * @generated
	 * @ordered
	 */
    protected EList<Example> examples;

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
	 * The cached value of the '{@link #getMethods() <em>Methods</em>}' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getMethods()
	 * @generated
	 * @ordered
	 */
    protected EList<Method> methods;

    /**
	 * The cached value of the '{@link #getMediaTypes() <em>Media Types</em>}' reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getMediaTypes()
	 * @generated
	 * @ordered
	 */
    protected EList<MediaType> mediaTypes;

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
	 * The cached value of the '{@link #getAllMediaTypes() <em>All Media Types</em>}' reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getAllMediaTypes()
	 * @generated
	 * @ordered
	 */
    protected EList<MediaType> allMediaTypes;

    /**
	 * The cached value of the '{@link #getURI() <em>URI</em>}' containment reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getURI()
	 * @generated
	 * @ordered
	 */
    protected URI uri;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected ResourceDefinitionImpl() {
		super();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected EClass eStaticClass() {
		return RapidmlPackage.Literals.RESOURCE_DEFINITION;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList<Example> getExamples() {
		if (examples == null) {
			examples = new EObjectContainmentEList<Example>(Example.class, this, RapidmlPackage.RESOURCE_DEFINITION__EXAMPLES);
		}
		return examples;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList<AuthenticationMethod> getSecuredBy() {
		if (securedBy == null) {
			securedBy = new EObjectContainmentEList<AuthenticationMethod>(AuthenticationMethod.class, this, RapidmlPackage.RESOURCE_DEFINITION__SECURED_BY);
		}
		return securedBy;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList<Method> getMethods() {
		if (methods == null) {
			methods = new EObjectContainmentWithInverseEList<Method>(Method.class, this, RapidmlPackage.RESOURCE_DEFINITION__METHODS, RapidmlPackage.METHOD__CONTAINING_RESOURCE_DEFINITION);
		}
		return methods;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList<MediaType> getMediaTypes() {
		if (mediaTypes == null) {
			mediaTypes = new EObjectResolvingEList<MediaType>(MediaType.class, this, RapidmlPackage.RESOURCE_DEFINITION__MEDIA_TYPES);
		}
		return mediaTypes;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public URI getURI() {
		return uri;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public NotificationChain basicSetURI(URI newURI, NotificationChain msgs) {
		URI oldURI = uri;
		uri = newURI;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RapidmlPackage.RESOURCE_DEFINITION__URI, oldURI, newURI);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setURI(URI newURI) {
		if (newURI != uri) {
			NotificationChain msgs = null;
			if (uri != null)
				msgs = ((InternalEObject)uri).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RapidmlPackage.RESOURCE_DEFINITION__URI, null, msgs);
			if (newURI != null)
				msgs = ((InternalEObject)newURI).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RapidmlPackage.RESOURCE_DEFINITION__URI, null, msgs);
			msgs = basicSetURI(newURI, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RapidmlPackage.RESOURCE_DEFINITION__URI, newURI, newURI));
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
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
			eNotify(new ENotificationImpl(this, Notification.SET, RapidmlPackage.RESOURCE_DEFINITION__NAME, oldName, name));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList<MediaType> getAllMediaTypes() {
		if (allMediaTypes == null) {
			allMediaTypes = new EObjectResolvingEList<MediaType>(MediaType.class, this, RapidmlPackage.RESOURCE_DEFINITION__ALL_MEDIA_TYPES);
		}
		return allMediaTypes;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RapidmlPackage.RESOURCE_DEFINITION__EXAMPLES:
				return ((InternalEList<?>)getExamples()).basicRemove(otherEnd, msgs);
			case RapidmlPackage.RESOURCE_DEFINITION__SECURED_BY:
				return ((InternalEList<?>)getSecuredBy()).basicRemove(otherEnd, msgs);
			case RapidmlPackage.RESOURCE_DEFINITION__METHODS:
				return ((InternalEList<?>)getMethods()).basicRemove(otherEnd, msgs);
			case RapidmlPackage.RESOURCE_DEFINITION__URI:
				return basicSetURI(null, msgs);
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
			case RapidmlPackage.RESOURCE_DEFINITION__EXAMPLES:
				return getExamples();
			case RapidmlPackage.RESOURCE_DEFINITION__SECURED_BY:
				return getSecuredBy();
			case RapidmlPackage.RESOURCE_DEFINITION__METHODS:
				return getMethods();
			case RapidmlPackage.RESOURCE_DEFINITION__MEDIA_TYPES:
				return getMediaTypes();
			case RapidmlPackage.RESOURCE_DEFINITION__NAME:
				return getName();
			case RapidmlPackage.RESOURCE_DEFINITION__ALL_MEDIA_TYPES:
				return getAllMediaTypes();
			case RapidmlPackage.RESOURCE_DEFINITION__URI:
				return getURI();
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
			case RapidmlPackage.RESOURCE_DEFINITION__EXAMPLES:
				getExamples().clear();
				getExamples().addAll((Collection<? extends Example>)newValue);
				return;
			case RapidmlPackage.RESOURCE_DEFINITION__SECURED_BY:
				getSecuredBy().clear();
				getSecuredBy().addAll((Collection<? extends AuthenticationMethod>)newValue);
				return;
			case RapidmlPackage.RESOURCE_DEFINITION__METHODS:
				getMethods().clear();
				getMethods().addAll((Collection<? extends Method>)newValue);
				return;
			case RapidmlPackage.RESOURCE_DEFINITION__MEDIA_TYPES:
				getMediaTypes().clear();
				getMediaTypes().addAll((Collection<? extends MediaType>)newValue);
				return;
			case RapidmlPackage.RESOURCE_DEFINITION__NAME:
				setName((String)newValue);
				return;
			case RapidmlPackage.RESOURCE_DEFINITION__ALL_MEDIA_TYPES:
				getAllMediaTypes().clear();
				getAllMediaTypes().addAll((Collection<? extends MediaType>)newValue);
				return;
			case RapidmlPackage.RESOURCE_DEFINITION__URI:
				setURI((URI)newValue);
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
			case RapidmlPackage.RESOURCE_DEFINITION__EXAMPLES:
				getExamples().clear();
				return;
			case RapidmlPackage.RESOURCE_DEFINITION__SECURED_BY:
				getSecuredBy().clear();
				return;
			case RapidmlPackage.RESOURCE_DEFINITION__METHODS:
				getMethods().clear();
				return;
			case RapidmlPackage.RESOURCE_DEFINITION__MEDIA_TYPES:
				getMediaTypes().clear();
				return;
			case RapidmlPackage.RESOURCE_DEFINITION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case RapidmlPackage.RESOURCE_DEFINITION__ALL_MEDIA_TYPES:
				getAllMediaTypes().clear();
				return;
			case RapidmlPackage.RESOURCE_DEFINITION__URI:
				setURI((URI)null);
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
			case RapidmlPackage.RESOURCE_DEFINITION__EXAMPLES:
				return examples != null && !examples.isEmpty();
			case RapidmlPackage.RESOURCE_DEFINITION__SECURED_BY:
				return securedBy != null && !securedBy.isEmpty();
			case RapidmlPackage.RESOURCE_DEFINITION__METHODS:
				return methods != null && !methods.isEmpty();
			case RapidmlPackage.RESOURCE_DEFINITION__MEDIA_TYPES:
				return mediaTypes != null && !mediaTypes.isEmpty();
			case RapidmlPackage.RESOURCE_DEFINITION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case RapidmlPackage.RESOURCE_DEFINITION__ALL_MEDIA_TYPES:
				return allMediaTypes != null && !allMediaTypes.isEmpty();
			case RapidmlPackage.RESOURCE_DEFINITION__URI:
				return uri != null;
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
		if (baseClass == WithExamples.class) {
			switch (derivedFeatureID) {
				case RapidmlPackage.RESOURCE_DEFINITION__EXAMPLES: return RapidmlPackage.WITH_EXAMPLES__EXAMPLES;
				default: return -1;
			}
		}
		if (baseClass == HasSecurityValue.class) {
			switch (derivedFeatureID) {
				case RapidmlPackage.RESOURCE_DEFINITION__SECURED_BY: return RapidmlPackage.HAS_SECURITY_VALUE__SECURED_BY;
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
		if (baseClass == WithExamples.class) {
			switch (baseFeatureID) {
				case RapidmlPackage.WITH_EXAMPLES__EXAMPLES: return RapidmlPackage.RESOURCE_DEFINITION__EXAMPLES;
				default: return -1;
			}
		}
		if (baseClass == HasSecurityValue.class) {
			switch (baseFeatureID) {
				case RapidmlPackage.HAS_SECURITY_VALUE__SECURED_BY: return RapidmlPackage.RESOURCE_DEFINITION__SECURED_BY;
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
		result.append(')');
		return result.toString();
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
			case RapidmlPackage.RESOURCE_DEFINITION__METHODS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getMethods()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

} //ResourceDefinitionImpl

