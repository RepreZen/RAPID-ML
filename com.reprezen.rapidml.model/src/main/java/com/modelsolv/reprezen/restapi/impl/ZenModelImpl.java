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

import com.modelsolv.reprezen.restapi.Extensible;
import com.modelsolv.reprezen.restapi.Extension;
import com.modelsolv.reprezen.restapi.HasTitle;
import com.modelsolv.reprezen.restapi.ImportDeclaration;
import com.modelsolv.reprezen.restapi.ResourceAPI;
import com.modelsolv.reprezen.restapi.RestapiPackage;
import com.modelsolv.reprezen.restapi.SecuritySchemeLibrary;
import com.modelsolv.reprezen.restapi.ZenModel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Zen Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.modelsolv.reprezen.restapi.impl.ZenModelImpl#getExtensions <em>Extensions</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.restapi.impl.ZenModelImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.restapi.impl.ZenModelImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.restapi.impl.ZenModelImpl#getNamespace <em>Namespace</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.restapi.impl.ZenModelImpl#getResourceAPIs <em>Resource AP Is</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.restapi.impl.ZenModelImpl#getDataModels <em>Data Models</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.restapi.impl.ZenModelImpl#getMediaTypesLibrary <em>Media Types Library</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.restapi.impl.ZenModelImpl#getLinkRelationsLibrary <em>Link Relations Library</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.restapi.impl.ZenModelImpl#getPrimitiveTypesLibrary <em>Primitive Types Library</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.restapi.impl.ZenModelImpl#getImports <em>Imports</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.restapi.impl.ZenModelImpl#getSecuritySchemesLibrary <em>Security Schemes Library</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ZenModelImpl extends DocumentableImpl implements ZenModel {
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
	 * The default value of the '{@link #getNamespace() <em>Namespace</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getNamespace()
	 * @generated
	 * @ordered
	 */
    protected static final String NAMESPACE_EDEFAULT = null;

    /**
	 * The cached value of the '{@link #getNamespace() <em>Namespace</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getNamespace()
	 * @generated
	 * @ordered
	 */
    protected String namespace = NAMESPACE_EDEFAULT;

    /**
	 * The cached value of the '{@link #getResourceAPIs() <em>Resource AP Is</em>}' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getResourceAPIs()
	 * @generated
	 * @ordered
	 */
    protected EList<ResourceAPI> resourceAPIs;

    /**
	 * The cached value of the '{@link #getDataModels() <em>Data Models</em>}' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getDataModels()
	 * @generated
	 * @ordered
	 */
    protected EList<com.modelsolv.reprezen.restapi.DataModel> dataModels;

    /**
	 * The cached value of the '{@link #getMediaTypesLibrary() <em>Media Types Library</em>}' containment reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getMediaTypesLibrary()
	 * @generated
	 * @ordered
	 */
    protected com.modelsolv.reprezen.restapi.MediaTypesLibrary mediaTypesLibrary;

    /**
	 * The cached value of the '{@link #getLinkRelationsLibrary() <em>Link Relations Library</em>}' containment reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getLinkRelationsLibrary()
	 * @generated
	 * @ordered
	 */
    protected com.modelsolv.reprezen.restapi.LinkRelationsLibrary linkRelationsLibrary;

    /**
	 * The cached value of the '{@link #getPrimitiveTypesLibrary() <em>Primitive Types Library</em>}' containment reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getPrimitiveTypesLibrary()
	 * @generated
	 * @ordered
	 */
    protected com.modelsolv.reprezen.restapi.PrimitiveTypesLibrary primitiveTypesLibrary;

    /**
	 * The cached value of the '{@link #getImports() <em>Imports</em>}' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getImports()
	 * @generated
	 * @ordered
	 */
    protected EList<ImportDeclaration> imports;

    /**
	 * The cached value of the '{@link #getSecuritySchemesLibrary() <em>Security Schemes Library</em>}' containment reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getSecuritySchemesLibrary()
	 * @generated
	 * @ordered
	 */
    protected SecuritySchemeLibrary securitySchemesLibrary;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected ZenModelImpl() {
		super();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected EClass eStaticClass() {
		return RestapiPackage.Literals.ZEN_MODEL;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList<Extension> getExtensions() {
		if (extensions == null) {
			extensions = new EObjectContainmentEList<Extension>(Extension.class, this, RestapiPackage.ZEN_MODEL__EXTENSIONS);
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
			eNotify(new ENotificationImpl(this, Notification.SET, RestapiPackage.ZEN_MODEL__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, RestapiPackage.ZEN_MODEL__TITLE, oldTitle, title));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public String getNamespace() {
		return namespace;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setNamespace(String newNamespace) {
		String oldNamespace = namespace;
		namespace = newNamespace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RestapiPackage.ZEN_MODEL__NAMESPACE, oldNamespace, namespace));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList<ResourceAPI> getResourceAPIs() {
		if (resourceAPIs == null) {
			resourceAPIs = new EObjectContainmentEList<ResourceAPI>(ResourceAPI.class, this, RestapiPackage.ZEN_MODEL__RESOURCE_AP_IS);
		}
		return resourceAPIs;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList<com.modelsolv.reprezen.restapi.DataModel> getDataModels() {
		if (dataModels == null) {
			dataModels = new EObjectContainmentEList<com.modelsolv.reprezen.restapi.DataModel>(com.modelsolv.reprezen.restapi.DataModel.class, this, RestapiPackage.ZEN_MODEL__DATA_MODELS);
		}
		return dataModels;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public com.modelsolv.reprezen.restapi.MediaTypesLibrary getMediaTypesLibrary() {
		return mediaTypesLibrary;
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMediaTypesLibrary(com.modelsolv.reprezen.restapi.MediaTypesLibrary newMediaTypesLibrary, NotificationChain msgs) {
		com.modelsolv.reprezen.restapi.MediaTypesLibrary oldMediaTypesLibrary = mediaTypesLibrary;
		mediaTypesLibrary = newMediaTypesLibrary;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RestapiPackage.ZEN_MODEL__MEDIA_TYPES_LIBRARY, oldMediaTypesLibrary, newMediaTypesLibrary);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMediaTypesLibrary(com.modelsolv.reprezen.restapi.MediaTypesLibrary newMediaTypesLibrary) {
		if (newMediaTypesLibrary != mediaTypesLibrary) {
			NotificationChain msgs = null;
			if (mediaTypesLibrary != null)
				msgs = ((InternalEObject)mediaTypesLibrary).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RestapiPackage.ZEN_MODEL__MEDIA_TYPES_LIBRARY, null, msgs);
			if (newMediaTypesLibrary != null)
				msgs = ((InternalEObject)newMediaTypesLibrary).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RestapiPackage.ZEN_MODEL__MEDIA_TYPES_LIBRARY, null, msgs);
			msgs = basicSetMediaTypesLibrary(newMediaTypesLibrary, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RestapiPackage.ZEN_MODEL__MEDIA_TYPES_LIBRARY, newMediaTypesLibrary, newMediaTypesLibrary));
	}

				/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public com.modelsolv.reprezen.restapi.LinkRelationsLibrary getLinkRelationsLibrary() {
		return linkRelationsLibrary;
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLinkRelationsLibrary(com.modelsolv.reprezen.restapi.LinkRelationsLibrary newLinkRelationsLibrary, NotificationChain msgs) {
		com.modelsolv.reprezen.restapi.LinkRelationsLibrary oldLinkRelationsLibrary = linkRelationsLibrary;
		linkRelationsLibrary = newLinkRelationsLibrary;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RestapiPackage.ZEN_MODEL__LINK_RELATIONS_LIBRARY, oldLinkRelationsLibrary, newLinkRelationsLibrary);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinkRelationsLibrary(com.modelsolv.reprezen.restapi.LinkRelationsLibrary newLinkRelationsLibrary) {
		if (newLinkRelationsLibrary != linkRelationsLibrary) {
			NotificationChain msgs = null;
			if (linkRelationsLibrary != null)
				msgs = ((InternalEObject)linkRelationsLibrary).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RestapiPackage.ZEN_MODEL__LINK_RELATIONS_LIBRARY, null, msgs);
			if (newLinkRelationsLibrary != null)
				msgs = ((InternalEObject)newLinkRelationsLibrary).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RestapiPackage.ZEN_MODEL__LINK_RELATIONS_LIBRARY, null, msgs);
			msgs = basicSetLinkRelationsLibrary(newLinkRelationsLibrary, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RestapiPackage.ZEN_MODEL__LINK_RELATIONS_LIBRARY, newLinkRelationsLibrary, newLinkRelationsLibrary));
	}

				/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public com.modelsolv.reprezen.restapi.PrimitiveTypesLibrary getPrimitiveTypesLibrary() {
		return primitiveTypesLibrary;
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPrimitiveTypesLibrary(com.modelsolv.reprezen.restapi.PrimitiveTypesLibrary newPrimitiveTypesLibrary, NotificationChain msgs) {
		com.modelsolv.reprezen.restapi.PrimitiveTypesLibrary oldPrimitiveTypesLibrary = primitiveTypesLibrary;
		primitiveTypesLibrary = newPrimitiveTypesLibrary;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RestapiPackage.ZEN_MODEL__PRIMITIVE_TYPES_LIBRARY, oldPrimitiveTypesLibrary, newPrimitiveTypesLibrary);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrimitiveTypesLibrary(com.modelsolv.reprezen.restapi.PrimitiveTypesLibrary newPrimitiveTypesLibrary) {
		if (newPrimitiveTypesLibrary != primitiveTypesLibrary) {
			NotificationChain msgs = null;
			if (primitiveTypesLibrary != null)
				msgs = ((InternalEObject)primitiveTypesLibrary).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RestapiPackage.ZEN_MODEL__PRIMITIVE_TYPES_LIBRARY, null, msgs);
			if (newPrimitiveTypesLibrary != null)
				msgs = ((InternalEObject)newPrimitiveTypesLibrary).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RestapiPackage.ZEN_MODEL__PRIMITIVE_TYPES_LIBRARY, null, msgs);
			msgs = basicSetPrimitiveTypesLibrary(newPrimitiveTypesLibrary, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RestapiPackage.ZEN_MODEL__PRIMITIVE_TYPES_LIBRARY, newPrimitiveTypesLibrary, newPrimitiveTypesLibrary));
	}

				/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList<ImportDeclaration> getImports() {
		if (imports == null) {
			imports = new EObjectContainmentEList<ImportDeclaration>(ImportDeclaration.class, this, RestapiPackage.ZEN_MODEL__IMPORTS);
		}
		return imports;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public SecuritySchemeLibrary getSecuritySchemesLibrary() {
		return securitySchemesLibrary;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public NotificationChain basicSetSecuritySchemesLibrary(SecuritySchemeLibrary newSecuritySchemesLibrary, NotificationChain msgs) {
		SecuritySchemeLibrary oldSecuritySchemesLibrary = securitySchemesLibrary;
		securitySchemesLibrary = newSecuritySchemesLibrary;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RestapiPackage.ZEN_MODEL__SECURITY_SCHEMES_LIBRARY, oldSecuritySchemesLibrary, newSecuritySchemesLibrary);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setSecuritySchemesLibrary(SecuritySchemeLibrary newSecuritySchemesLibrary) {
		if (newSecuritySchemesLibrary != securitySchemesLibrary) {
			NotificationChain msgs = null;
			if (securitySchemesLibrary != null)
				msgs = ((InternalEObject)securitySchemesLibrary).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RestapiPackage.ZEN_MODEL__SECURITY_SCHEMES_LIBRARY, null, msgs);
			if (newSecuritySchemesLibrary != null)
				msgs = ((InternalEObject)newSecuritySchemesLibrary).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RestapiPackage.ZEN_MODEL__SECURITY_SCHEMES_LIBRARY, null, msgs);
			msgs = basicSetSecuritySchemesLibrary(newSecuritySchemesLibrary, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RestapiPackage.ZEN_MODEL__SECURITY_SCHEMES_LIBRARY, newSecuritySchemesLibrary, newSecuritySchemesLibrary));
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RestapiPackage.ZEN_MODEL__EXTENSIONS:
				return ((InternalEList<?>)getExtensions()).basicRemove(otherEnd, msgs);
			case RestapiPackage.ZEN_MODEL__RESOURCE_AP_IS:
				return ((InternalEList<?>)getResourceAPIs()).basicRemove(otherEnd, msgs);
			case RestapiPackage.ZEN_MODEL__DATA_MODELS:
				return ((InternalEList<?>)getDataModels()).basicRemove(otherEnd, msgs);
			case RestapiPackage.ZEN_MODEL__MEDIA_TYPES_LIBRARY:
				return basicSetMediaTypesLibrary(null, msgs);
			case RestapiPackage.ZEN_MODEL__LINK_RELATIONS_LIBRARY:
				return basicSetLinkRelationsLibrary(null, msgs);
			case RestapiPackage.ZEN_MODEL__PRIMITIVE_TYPES_LIBRARY:
				return basicSetPrimitiveTypesLibrary(null, msgs);
			case RestapiPackage.ZEN_MODEL__IMPORTS:
				return ((InternalEList<?>)getImports()).basicRemove(otherEnd, msgs);
			case RestapiPackage.ZEN_MODEL__SECURITY_SCHEMES_LIBRARY:
				return basicSetSecuritySchemesLibrary(null, msgs);
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
			case RestapiPackage.ZEN_MODEL__EXTENSIONS:
				return getExtensions();
			case RestapiPackage.ZEN_MODEL__TITLE:
				return getTitle();
			case RestapiPackage.ZEN_MODEL__NAME:
				return getName();
			case RestapiPackage.ZEN_MODEL__NAMESPACE:
				return getNamespace();
			case RestapiPackage.ZEN_MODEL__RESOURCE_AP_IS:
				return getResourceAPIs();
			case RestapiPackage.ZEN_MODEL__DATA_MODELS:
				return getDataModels();
			case RestapiPackage.ZEN_MODEL__MEDIA_TYPES_LIBRARY:
				return getMediaTypesLibrary();
			case RestapiPackage.ZEN_MODEL__LINK_RELATIONS_LIBRARY:
				return getLinkRelationsLibrary();
			case RestapiPackage.ZEN_MODEL__PRIMITIVE_TYPES_LIBRARY:
				return getPrimitiveTypesLibrary();
			case RestapiPackage.ZEN_MODEL__IMPORTS:
				return getImports();
			case RestapiPackage.ZEN_MODEL__SECURITY_SCHEMES_LIBRARY:
				return getSecuritySchemesLibrary();
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
			case RestapiPackage.ZEN_MODEL__EXTENSIONS:
				getExtensions().clear();
				getExtensions().addAll((Collection<? extends Extension>)newValue);
				return;
			case RestapiPackage.ZEN_MODEL__TITLE:
				setTitle((String)newValue);
				return;
			case RestapiPackage.ZEN_MODEL__NAME:
				setName((String)newValue);
				return;
			case RestapiPackage.ZEN_MODEL__NAMESPACE:
				setNamespace((String)newValue);
				return;
			case RestapiPackage.ZEN_MODEL__RESOURCE_AP_IS:
				getResourceAPIs().clear();
				getResourceAPIs().addAll((Collection<? extends ResourceAPI>)newValue);
				return;
			case RestapiPackage.ZEN_MODEL__DATA_MODELS:
				getDataModels().clear();
				getDataModels().addAll((Collection<? extends com.modelsolv.reprezen.restapi.DataModel>)newValue);
				return;
			case RestapiPackage.ZEN_MODEL__MEDIA_TYPES_LIBRARY:
				setMediaTypesLibrary((com.modelsolv.reprezen.restapi.MediaTypesLibrary)newValue);
				return;
			case RestapiPackage.ZEN_MODEL__LINK_RELATIONS_LIBRARY:
				setLinkRelationsLibrary((com.modelsolv.reprezen.restapi.LinkRelationsLibrary)newValue);
				return;
			case RestapiPackage.ZEN_MODEL__PRIMITIVE_TYPES_LIBRARY:
				setPrimitiveTypesLibrary((com.modelsolv.reprezen.restapi.PrimitiveTypesLibrary)newValue);
				return;
			case RestapiPackage.ZEN_MODEL__IMPORTS:
				getImports().clear();
				getImports().addAll((Collection<? extends ImportDeclaration>)newValue);
				return;
			case RestapiPackage.ZEN_MODEL__SECURITY_SCHEMES_LIBRARY:
				setSecuritySchemesLibrary((SecuritySchemeLibrary)newValue);
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
			case RestapiPackage.ZEN_MODEL__EXTENSIONS:
				getExtensions().clear();
				return;
			case RestapiPackage.ZEN_MODEL__TITLE:
				setTitle(TITLE_EDEFAULT);
				return;
			case RestapiPackage.ZEN_MODEL__NAME:
				setName(NAME_EDEFAULT);
				return;
			case RestapiPackage.ZEN_MODEL__NAMESPACE:
				setNamespace(NAMESPACE_EDEFAULT);
				return;
			case RestapiPackage.ZEN_MODEL__RESOURCE_AP_IS:
				getResourceAPIs().clear();
				return;
			case RestapiPackage.ZEN_MODEL__DATA_MODELS:
				getDataModels().clear();
				return;
			case RestapiPackage.ZEN_MODEL__MEDIA_TYPES_LIBRARY:
				setMediaTypesLibrary((com.modelsolv.reprezen.restapi.MediaTypesLibrary)null);
				return;
			case RestapiPackage.ZEN_MODEL__LINK_RELATIONS_LIBRARY:
				setLinkRelationsLibrary((com.modelsolv.reprezen.restapi.LinkRelationsLibrary)null);
				return;
			case RestapiPackage.ZEN_MODEL__PRIMITIVE_TYPES_LIBRARY:
				setPrimitiveTypesLibrary((com.modelsolv.reprezen.restapi.PrimitiveTypesLibrary)null);
				return;
			case RestapiPackage.ZEN_MODEL__IMPORTS:
				getImports().clear();
				return;
			case RestapiPackage.ZEN_MODEL__SECURITY_SCHEMES_LIBRARY:
				setSecuritySchemesLibrary((SecuritySchemeLibrary)null);
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
			case RestapiPackage.ZEN_MODEL__EXTENSIONS:
				return extensions != null && !extensions.isEmpty();
			case RestapiPackage.ZEN_MODEL__TITLE:
				return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
			case RestapiPackage.ZEN_MODEL__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case RestapiPackage.ZEN_MODEL__NAMESPACE:
				return NAMESPACE_EDEFAULT == null ? namespace != null : !NAMESPACE_EDEFAULT.equals(namespace);
			case RestapiPackage.ZEN_MODEL__RESOURCE_AP_IS:
				return resourceAPIs != null && !resourceAPIs.isEmpty();
			case RestapiPackage.ZEN_MODEL__DATA_MODELS:
				return dataModels != null && !dataModels.isEmpty();
			case RestapiPackage.ZEN_MODEL__MEDIA_TYPES_LIBRARY:
				return mediaTypesLibrary != null;
			case RestapiPackage.ZEN_MODEL__LINK_RELATIONS_LIBRARY:
				return linkRelationsLibrary != null;
			case RestapiPackage.ZEN_MODEL__PRIMITIVE_TYPES_LIBRARY:
				return primitiveTypesLibrary != null;
			case RestapiPackage.ZEN_MODEL__IMPORTS:
				return imports != null && !imports.isEmpty();
			case RestapiPackage.ZEN_MODEL__SECURITY_SCHEMES_LIBRARY:
				return securitySchemesLibrary != null;
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
				case RestapiPackage.ZEN_MODEL__EXTENSIONS: return RestapiPackage.EXTENSIBLE__EXTENSIONS;
				default: return -1;
			}
		}
		if (baseClass == HasTitle.class) {
			switch (derivedFeatureID) {
				case RestapiPackage.ZEN_MODEL__TITLE: return RestapiPackage.HAS_TITLE__TITLE;
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
				case RestapiPackage.EXTENSIBLE__EXTENSIONS: return RestapiPackage.ZEN_MODEL__EXTENSIONS;
				default: return -1;
			}
		}
		if (baseClass == HasTitle.class) {
			switch (baseFeatureID) {
				case RestapiPackage.HAS_TITLE__TITLE: return RestapiPackage.ZEN_MODEL__TITLE;
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
		result.append(", namespace: ");
		result.append(namespace);
		result.append(')');
		return result.toString();
	}
} // ZenModelImpl
