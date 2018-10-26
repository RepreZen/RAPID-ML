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
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.reprezen.rapidml.AuthenticationMethod;
import com.reprezen.rapidml.HasSecurityValue;
import com.reprezen.rapidml.HasTitle;
import com.reprezen.rapidml.LinkRelation;
import com.reprezen.rapidml.MediaType;
import com.reprezen.rapidml.RealizationModelLocation;
import com.reprezen.rapidml.ReferenceRealization;
import com.reprezen.rapidml.ResourceAPI;
import com.reprezen.rapidml.ResourceDefinition;
import com.reprezen.rapidml.RapidmlPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource API</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.reprezen.rapidml.impl.ResourceAPIImpl#getSecuredBy <em>Secured By</em>}</li>
 *   <li>{@link com.reprezen.rapidml.impl.ResourceAPIImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link com.reprezen.rapidml.impl.ResourceAPIImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.reprezen.rapidml.impl.ResourceAPIImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link com.reprezen.rapidml.impl.ResourceAPIImpl#getBaseURI <em>Base URI</em>}</li>
 *   <li>{@link com.reprezen.rapidml.impl.ResourceAPIImpl#getOwnedResourceDefinitions <em>Owned Resource Definitions</em>}</li>
 *   <li>{@link com.reprezen.rapidml.impl.ResourceAPIImpl#getServiceDataModels <em>Service Data Models</em>}</li>
 *   <li>{@link com.reprezen.rapidml.impl.ResourceAPIImpl#getFormats <em>Formats</em>}</li>
 *   <li>{@link com.reprezen.rapidml.impl.ResourceAPIImpl#getDefinedMediaTypes <em>Defined Media Types</em>}</li>
 *   <li>{@link com.reprezen.rapidml.impl.ResourceAPIImpl#getDefinedLinkRelations <em>Defined Link Relations</em>}</li>
 *   <li>{@link com.reprezen.rapidml.impl.ResourceAPIImpl#getDefaultReferenceRealizations <em>Default Reference Realizations</em>}</li>
 *   <li>{@link com.reprezen.rapidml.impl.ResourceAPIImpl#getAutoRealizations <em>Auto Realizations</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ResourceAPIImpl extends RESTElementImpl implements ResourceAPI {
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
	 * The default value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
    protected static final String TITLE_EDEFAULT = null;

    /**
	 * The cached value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
    protected String title = TITLE_EDEFAULT;

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
	 * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
    protected static final String VERSION_EDEFAULT = null;

    /**
	 * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
    protected String version = VERSION_EDEFAULT;

    /**
	 * The default value of the '{@link #getBaseURI() <em>Base URI</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getBaseURI()
	 * @generated
	 * @ordered
	 */
    protected static final String BASE_URI_EDEFAULT = null;

    /**
	 * The cached value of the '{@link #getBaseURI() <em>Base URI</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getBaseURI()
	 * @generated
	 * @ordered
	 */
    protected String baseURI = BASE_URI_EDEFAULT;

    /**
	 * The cached value of the '{@link #getOwnedResourceDefinitions() <em>Owned Resource Definitions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getOwnedResourceDefinitions()
	 * @generated
	 * @ordered
	 */
    protected EList<ResourceDefinition> ownedResourceDefinitions;

    /**
	 * The cached value of the '{@link #getServiceDataModels() <em>Service Data Models</em>}' reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getServiceDataModels()
	 * @generated
	 * @ordered
	 */
    protected EList<com.reprezen.rapidml.DataModel> serviceDataModels;

    /**
	 * The cached value of the '{@link #getFormats() <em>Formats</em>}' reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getFormats()
	 * @generated
	 * @ordered
	 */
    protected EList<MediaType> formats;

    /**
	 * The cached value of the '{@link #getDefinedMediaTypes() <em>Defined Media Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getDefinedMediaTypes()
	 * @generated
	 * @ordered
	 */
    protected EList<MediaType> definedMediaTypes;

    /**
	 * The cached value of the '{@link #getDefinedLinkRelations() <em>Defined Link Relations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getDefinedLinkRelations()
	 * @generated
	 * @ordered
	 */
    protected EList<LinkRelation> definedLinkRelations;

    /**
	 * The cached value of the '{@link #getDefaultReferenceRealizations() <em>Default Reference Realizations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getDefaultReferenceRealizations()
	 * @generated
	 * @ordered
	 */
    protected EList<ReferenceRealization> defaultReferenceRealizations;

    /**
	 * The cached value of the '{@link #getAutoRealizations() <em>Auto Realizations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getAutoRealizations()
	 * @generated
	 * @ordered
	 */
    protected EList<RealizationModelLocation> autoRealizations;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected ResourceAPIImpl() {
		super();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected EClass eStaticClass() {
		return RapidmlPackage.Literals.RESOURCE_API;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList<AuthenticationMethod> getSecuredBy() {
		if (securedBy == null) {
			securedBy = new EObjectContainmentEList<AuthenticationMethod>(AuthenticationMethod.class, this, RapidmlPackage.RESOURCE_API__SECURED_BY);
		}
		return securedBy;
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
			eNotify(new ENotificationImpl(this, Notification.SET, RapidmlPackage.RESOURCE_API__NAME, oldName, name));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public String getTitle() {
		return title;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setTitle(String newTitle) {
		String oldTitle = title;
		title = newTitle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RapidmlPackage.RESOURCE_API__TITLE, oldTitle, title));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public String getVersion() {
		return version;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setVersion(String newVersion) {
		String oldVersion = version;
		version = newVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RapidmlPackage.RESOURCE_API__VERSION, oldVersion, version));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public String getBaseURI() {
		return baseURI;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setBaseURI(String newBaseURI) {
		String oldBaseURI = baseURI;
		baseURI = newBaseURI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RapidmlPackage.RESOURCE_API__BASE_URI, oldBaseURI, baseURI));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList<ResourceDefinition> getOwnedResourceDefinitions() {
		if (ownedResourceDefinitions == null) {
			ownedResourceDefinitions = new EObjectContainmentEList<ResourceDefinition>(ResourceDefinition.class, this, RapidmlPackage.RESOURCE_API__OWNED_RESOURCE_DEFINITIONS);
		}
		return ownedResourceDefinitions;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList<com.reprezen.rapidml.DataModel> getServiceDataModels() {
		if (serviceDataModels == null) {
			serviceDataModels = new EObjectResolvingEList<com.reprezen.rapidml.DataModel>(com.reprezen.rapidml.DataModel.class, this, RapidmlPackage.RESOURCE_API__SERVICE_DATA_MODELS);
		}
		return serviceDataModels;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList<MediaType> getFormats() {
		if (formats == null) {
			formats = new EObjectResolvingEList<MediaType>(MediaType.class, this, RapidmlPackage.RESOURCE_API__FORMATS);
		}
		return formats;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList<MediaType> getDefinedMediaTypes() {
		if (definedMediaTypes == null) {
			definedMediaTypes = new EObjectContainmentEList<MediaType>(MediaType.class, this, RapidmlPackage.RESOURCE_API__DEFINED_MEDIA_TYPES);
		}
		return definedMediaTypes;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList<LinkRelation> getDefinedLinkRelations() {
		if (definedLinkRelations == null) {
			definedLinkRelations = new EObjectContainmentEList<LinkRelation>(LinkRelation.class, this, RapidmlPackage.RESOURCE_API__DEFINED_LINK_RELATIONS);
		}
		return definedLinkRelations;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList<ReferenceRealization> getDefaultReferenceRealizations() {
		if (defaultReferenceRealizations == null) {
			defaultReferenceRealizations = new EObjectContainmentEList<ReferenceRealization>(ReferenceRealization.class, this, RapidmlPackage.RESOURCE_API__DEFAULT_REFERENCE_REALIZATIONS);
		}
		return defaultReferenceRealizations;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList<RealizationModelLocation> getAutoRealizations() {
		if (autoRealizations == null) {
			autoRealizations = new EObjectContainmentEList<RealizationModelLocation>(RealizationModelLocation.class, this, RapidmlPackage.RESOURCE_API__AUTO_REALIZATIONS);
		}
		return autoRealizations;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RapidmlPackage.RESOURCE_API__SECURED_BY:
				return ((InternalEList<?>)getSecuredBy()).basicRemove(otherEnd, msgs);
			case RapidmlPackage.RESOURCE_API__OWNED_RESOURCE_DEFINITIONS:
				return ((InternalEList<?>)getOwnedResourceDefinitions()).basicRemove(otherEnd, msgs);
			case RapidmlPackage.RESOURCE_API__DEFINED_MEDIA_TYPES:
				return ((InternalEList<?>)getDefinedMediaTypes()).basicRemove(otherEnd, msgs);
			case RapidmlPackage.RESOURCE_API__DEFINED_LINK_RELATIONS:
				return ((InternalEList<?>)getDefinedLinkRelations()).basicRemove(otherEnd, msgs);
			case RapidmlPackage.RESOURCE_API__DEFAULT_REFERENCE_REALIZATIONS:
				return ((InternalEList<?>)getDefaultReferenceRealizations()).basicRemove(otherEnd, msgs);
			case RapidmlPackage.RESOURCE_API__AUTO_REALIZATIONS:
				return ((InternalEList<?>)getAutoRealizations()).basicRemove(otherEnd, msgs);
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
			case RapidmlPackage.RESOURCE_API__SECURED_BY:
				return getSecuredBy();
			case RapidmlPackage.RESOURCE_API__TITLE:
				return getTitle();
			case RapidmlPackage.RESOURCE_API__NAME:
				return getName();
			case RapidmlPackage.RESOURCE_API__VERSION:
				return getVersion();
			case RapidmlPackage.RESOURCE_API__BASE_URI:
				return getBaseURI();
			case RapidmlPackage.RESOURCE_API__OWNED_RESOURCE_DEFINITIONS:
				return getOwnedResourceDefinitions();
			case RapidmlPackage.RESOURCE_API__SERVICE_DATA_MODELS:
				return getServiceDataModels();
			case RapidmlPackage.RESOURCE_API__FORMATS:
				return getFormats();
			case RapidmlPackage.RESOURCE_API__DEFINED_MEDIA_TYPES:
				return getDefinedMediaTypes();
			case RapidmlPackage.RESOURCE_API__DEFINED_LINK_RELATIONS:
				return getDefinedLinkRelations();
			case RapidmlPackage.RESOURCE_API__DEFAULT_REFERENCE_REALIZATIONS:
				return getDefaultReferenceRealizations();
			case RapidmlPackage.RESOURCE_API__AUTO_REALIZATIONS:
				return getAutoRealizations();
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
			case RapidmlPackage.RESOURCE_API__SECURED_BY:
				getSecuredBy().clear();
				getSecuredBy().addAll((Collection<? extends AuthenticationMethod>)newValue);
				return;
			case RapidmlPackage.RESOURCE_API__TITLE:
				setTitle((String)newValue);
				return;
			case RapidmlPackage.RESOURCE_API__NAME:
				setName((String)newValue);
				return;
			case RapidmlPackage.RESOURCE_API__VERSION:
				setVersion((String)newValue);
				return;
			case RapidmlPackage.RESOURCE_API__BASE_URI:
				setBaseURI((String)newValue);
				return;
			case RapidmlPackage.RESOURCE_API__OWNED_RESOURCE_DEFINITIONS:
				getOwnedResourceDefinitions().clear();
				getOwnedResourceDefinitions().addAll((Collection<? extends ResourceDefinition>)newValue);
				return;
			case RapidmlPackage.RESOURCE_API__SERVICE_DATA_MODELS:
				getServiceDataModels().clear();
				getServiceDataModels().addAll((Collection<? extends com.reprezen.rapidml.DataModel>)newValue);
				return;
			case RapidmlPackage.RESOURCE_API__FORMATS:
				getFormats().clear();
				getFormats().addAll((Collection<? extends MediaType>)newValue);
				return;
			case RapidmlPackage.RESOURCE_API__DEFINED_MEDIA_TYPES:
				getDefinedMediaTypes().clear();
				getDefinedMediaTypes().addAll((Collection<? extends MediaType>)newValue);
				return;
			case RapidmlPackage.RESOURCE_API__DEFINED_LINK_RELATIONS:
				getDefinedLinkRelations().clear();
				getDefinedLinkRelations().addAll((Collection<? extends LinkRelation>)newValue);
				return;
			case RapidmlPackage.RESOURCE_API__DEFAULT_REFERENCE_REALIZATIONS:
				getDefaultReferenceRealizations().clear();
				getDefaultReferenceRealizations().addAll((Collection<? extends ReferenceRealization>)newValue);
				return;
			case RapidmlPackage.RESOURCE_API__AUTO_REALIZATIONS:
				getAutoRealizations().clear();
				getAutoRealizations().addAll((Collection<? extends RealizationModelLocation>)newValue);
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
			case RapidmlPackage.RESOURCE_API__SECURED_BY:
				getSecuredBy().clear();
				return;
			case RapidmlPackage.RESOURCE_API__TITLE:
				setTitle(TITLE_EDEFAULT);
				return;
			case RapidmlPackage.RESOURCE_API__NAME:
				setName(NAME_EDEFAULT);
				return;
			case RapidmlPackage.RESOURCE_API__VERSION:
				setVersion(VERSION_EDEFAULT);
				return;
			case RapidmlPackage.RESOURCE_API__BASE_URI:
				setBaseURI(BASE_URI_EDEFAULT);
				return;
			case RapidmlPackage.RESOURCE_API__OWNED_RESOURCE_DEFINITIONS:
				getOwnedResourceDefinitions().clear();
				return;
			case RapidmlPackage.RESOURCE_API__SERVICE_DATA_MODELS:
				getServiceDataModels().clear();
				return;
			case RapidmlPackage.RESOURCE_API__FORMATS:
				getFormats().clear();
				return;
			case RapidmlPackage.RESOURCE_API__DEFINED_MEDIA_TYPES:
				getDefinedMediaTypes().clear();
				return;
			case RapidmlPackage.RESOURCE_API__DEFINED_LINK_RELATIONS:
				getDefinedLinkRelations().clear();
				return;
			case RapidmlPackage.RESOURCE_API__DEFAULT_REFERENCE_REALIZATIONS:
				getDefaultReferenceRealizations().clear();
				return;
			case RapidmlPackage.RESOURCE_API__AUTO_REALIZATIONS:
				getAutoRealizations().clear();
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
			case RapidmlPackage.RESOURCE_API__SECURED_BY:
				return securedBy != null && !securedBy.isEmpty();
			case RapidmlPackage.RESOURCE_API__TITLE:
				return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
			case RapidmlPackage.RESOURCE_API__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case RapidmlPackage.RESOURCE_API__VERSION:
				return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
			case RapidmlPackage.RESOURCE_API__BASE_URI:
				return BASE_URI_EDEFAULT == null ? baseURI != null : !BASE_URI_EDEFAULT.equals(baseURI);
			case RapidmlPackage.RESOURCE_API__OWNED_RESOURCE_DEFINITIONS:
				return ownedResourceDefinitions != null && !ownedResourceDefinitions.isEmpty();
			case RapidmlPackage.RESOURCE_API__SERVICE_DATA_MODELS:
				return serviceDataModels != null && !serviceDataModels.isEmpty();
			case RapidmlPackage.RESOURCE_API__FORMATS:
				return formats != null && !formats.isEmpty();
			case RapidmlPackage.RESOURCE_API__DEFINED_MEDIA_TYPES:
				return definedMediaTypes != null && !definedMediaTypes.isEmpty();
			case RapidmlPackage.RESOURCE_API__DEFINED_LINK_RELATIONS:
				return definedLinkRelations != null && !definedLinkRelations.isEmpty();
			case RapidmlPackage.RESOURCE_API__DEFAULT_REFERENCE_REALIZATIONS:
				return defaultReferenceRealizations != null && !defaultReferenceRealizations.isEmpty();
			case RapidmlPackage.RESOURCE_API__AUTO_REALIZATIONS:
				return autoRealizations != null && !autoRealizations.isEmpty();
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
				case RapidmlPackage.RESOURCE_API__SECURED_BY: return RapidmlPackage.HAS_SECURITY_VALUE__SECURED_BY;
				default: return -1;
			}
		}
		if (baseClass == HasTitle.class) {
			switch (derivedFeatureID) {
				case RapidmlPackage.RESOURCE_API__TITLE: return RapidmlPackage.HAS_TITLE__TITLE;
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
				case RapidmlPackage.HAS_SECURITY_VALUE__SECURED_BY: return RapidmlPackage.RESOURCE_API__SECURED_BY;
				default: return -1;
			}
		}
		if (baseClass == HasTitle.class) {
			switch (baseFeatureID) {
				case RapidmlPackage.HAS_TITLE__TITLE: return RapidmlPackage.RESOURCE_API__TITLE;
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
		result.append(" (title: ");
		result.append(title);
		result.append(", name: ");
		result.append(name);
		result.append(", version: ");
		result.append(version);
		result.append(", baseURI: ");
		result.append(baseURI);
		result.append(')');
		return result.toString();
	}

} //ResourceAPIImpl
