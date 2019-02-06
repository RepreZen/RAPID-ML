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
import org.eclipse.emf.ecore.util.InternalEList;

import com.reprezen.rapidml.Extensible;
import com.reprezen.rapidml.Extension;
import com.reprezen.rapidml.HasTitle;
import com.reprezen.rapidml.ImportDeclaration;
import com.reprezen.rapidml.RapidmlPackage;
import com.reprezen.rapidml.ResourceAPI;
import com.reprezen.rapidml.SecuritySchemeLibrary;
import com.reprezen.rapidml.ZenModel;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Zen
 * Model</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link com.reprezen.rapidml.impl.ZenModelImpl#getExtensions
 * <em>Extensions</em>}</li>
 * <li>{@link com.reprezen.rapidml.impl.ZenModelImpl#getTitle
 * <em>Title</em>}</li>
 * <li>{@link com.reprezen.rapidml.impl.ZenModelImpl#getName <em>Name</em>}</li>
 * <li>{@link com.reprezen.rapidml.impl.ZenModelImpl#getNamespace
 * <em>Namespace</em>}</li>
 * <li>{@link com.reprezen.rapidml.impl.ZenModelImpl#getResourceAPIs
 * <em>Resource AP Is</em>}</li>
 * <li>{@link com.reprezen.rapidml.impl.ZenModelImpl#getDataModels <em>Data
 * Models</em>}</li>
 * <li>{@link com.reprezen.rapidml.impl.ZenModelImpl#getMediaTypesLibrary
 * <em>Media Types Library</em>}</li>
 * <li>{@link com.reprezen.rapidml.impl.ZenModelImpl#getLinkRelationsLibrary
 * <em>Link Relations Library</em>}</li>
 * <li>{@link com.reprezen.rapidml.impl.ZenModelImpl#getPrimitiveTypesLibrary
 * <em>Primitive Types Library</em>}</li>
 * <li>{@link com.reprezen.rapidml.impl.ZenModelImpl#getImports
 * <em>Imports</em>}</li>
 * <li>{@link com.reprezen.rapidml.impl.ZenModelImpl#getSecuritySchemesLibrary
 * <em>Security Schemes Library</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ZenModelImpl extends DocumentableImpl implements ZenModel {
	/**
	 * The cached value of the '{@link #getExtensions() <em>Extensions</em>}'
	 * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getExtensions()
	 * @generated
	 * @ordered
	 */
	protected EList<Extension> extensions;

	/**
	 * The default value of the '{@link #getTitle() <em>Title</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected static final String TITLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTitle() <em>Title</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected String title = TITLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getNamespace() <em>Namespace</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getNamespace()
	 * @generated
	 * @ordered
	 */
	protected static final String NAMESPACE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNamespace() <em>Namespace</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getNamespace()
	 * @generated
	 * @ordered
	 */
	protected String namespace = NAMESPACE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getResourceAPIs() <em>Resource AP Is</em>}'
	 * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getResourceAPIs()
	 * @generated
	 * @ordered
	 */
	protected EList<ResourceAPI> resourceAPIs;

	/**
	 * The cached value of the '{@link #getDataModels() <em>Data Models</em>}'
	 * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDataModels()
	 * @generated
	 * @ordered
	 */
	protected EList<com.reprezen.rapidml.DataModel> dataModels;

	/**
	 * The cached value of the '{@link #getMediaTypesLibrary() <em>Media Types
	 * Library</em>}' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getMediaTypesLibrary()
	 * @generated
	 * @ordered
	 */
	protected com.reprezen.rapidml.MediaTypesLibrary mediaTypesLibrary;

	/**
	 * The cached value of the '{@link #getLinkRelationsLibrary() <em>Link Relations
	 * Library</em>}' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getLinkRelationsLibrary()
	 * @generated
	 * @ordered
	 */
	protected com.reprezen.rapidml.LinkRelationsLibrary linkRelationsLibrary;

	/**
	 * The cached value of the '{@link #getPrimitiveTypesLibrary() <em>Primitive
	 * Types Library</em>}' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getPrimitiveTypesLibrary()
	 * @generated
	 * @ordered
	 */
	protected com.reprezen.rapidml.PrimitiveTypesLibrary primitiveTypesLibrary;

	/**
	 * The cached value of the '{@link #getImports() <em>Imports</em>}' containment
	 * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getImports()
	 * @generated
	 * @ordered
	 */
	protected EList<ImportDeclaration> imports;

	/**
	 * The cached value of the '{@link #getSecuritySchemesLibrary() <em>Security
	 * Schemes Library</em>}' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getSecuritySchemesLibrary()
	 * @generated
	 * @ordered
	 */
	protected SecuritySchemeLibrary securitySchemesLibrary;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ZenModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RapidmlPackage.Literals.ZEN_MODEL;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Extension> getExtensions() {
		if (extensions == null) {
			extensions = new EObjectContainmentEList<Extension>(Extension.class, this,
					RapidmlPackage.ZEN_MODEL__EXTENSIONS);
		}
		return extensions;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RapidmlPackage.ZEN_MODEL__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setTitle(String newTitle) {
		String oldTitle = title;
		title = newTitle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RapidmlPackage.ZEN_MODEL__TITLE, oldTitle, title));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getNamespace() {
		return namespace;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setNamespace(String newNamespace) {
		String oldNamespace = namespace;
		namespace = newNamespace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RapidmlPackage.ZEN_MODEL__NAMESPACE, oldNamespace,
					namespace));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<ResourceAPI> getResourceAPIs() {
		if (resourceAPIs == null) {
			resourceAPIs = new EObjectContainmentEList<ResourceAPI>(ResourceAPI.class, this,
					RapidmlPackage.ZEN_MODEL__RESOURCE_AP_IS);
		}
		return resourceAPIs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<com.reprezen.rapidml.DataModel> getDataModels() {
		if (dataModels == null) {
			dataModels = new EObjectContainmentEList<com.reprezen.rapidml.DataModel>(
					com.reprezen.rapidml.DataModel.class, this, RapidmlPackage.ZEN_MODEL__DATA_MODELS);
		}
		return dataModels;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public com.reprezen.rapidml.MediaTypesLibrary getMediaTypesLibrary() {
		return mediaTypesLibrary;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetMediaTypesLibrary(com.reprezen.rapidml.MediaTypesLibrary newMediaTypesLibrary,
			NotificationChain msgs) {
		com.reprezen.rapidml.MediaTypesLibrary oldMediaTypesLibrary = mediaTypesLibrary;
		mediaTypesLibrary = newMediaTypesLibrary;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					RapidmlPackage.ZEN_MODEL__MEDIA_TYPES_LIBRARY, oldMediaTypesLibrary, newMediaTypesLibrary);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setMediaTypesLibrary(com.reprezen.rapidml.MediaTypesLibrary newMediaTypesLibrary) {
		if (newMediaTypesLibrary != mediaTypesLibrary) {
			NotificationChain msgs = null;
			if (mediaTypesLibrary != null)
				msgs = ((InternalEObject) mediaTypesLibrary).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - RapidmlPackage.ZEN_MODEL__MEDIA_TYPES_LIBRARY, null, msgs);
			if (newMediaTypesLibrary != null)
				msgs = ((InternalEObject) newMediaTypesLibrary).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - RapidmlPackage.ZEN_MODEL__MEDIA_TYPES_LIBRARY, null, msgs);
			msgs = basicSetMediaTypesLibrary(newMediaTypesLibrary, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RapidmlPackage.ZEN_MODEL__MEDIA_TYPES_LIBRARY,
					newMediaTypesLibrary, newMediaTypesLibrary));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public com.reprezen.rapidml.LinkRelationsLibrary getLinkRelationsLibrary() {
		return linkRelationsLibrary;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetLinkRelationsLibrary(
			com.reprezen.rapidml.LinkRelationsLibrary newLinkRelationsLibrary, NotificationChain msgs) {
		com.reprezen.rapidml.LinkRelationsLibrary oldLinkRelationsLibrary = linkRelationsLibrary;
		linkRelationsLibrary = newLinkRelationsLibrary;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					RapidmlPackage.ZEN_MODEL__LINK_RELATIONS_LIBRARY, oldLinkRelationsLibrary, newLinkRelationsLibrary);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setLinkRelationsLibrary(com.reprezen.rapidml.LinkRelationsLibrary newLinkRelationsLibrary) {
		if (newLinkRelationsLibrary != linkRelationsLibrary) {
			NotificationChain msgs = null;
			if (linkRelationsLibrary != null)
				msgs = ((InternalEObject) linkRelationsLibrary).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - RapidmlPackage.ZEN_MODEL__LINK_RELATIONS_LIBRARY, null, msgs);
			if (newLinkRelationsLibrary != null)
				msgs = ((InternalEObject) newLinkRelationsLibrary).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - RapidmlPackage.ZEN_MODEL__LINK_RELATIONS_LIBRARY, null, msgs);
			msgs = basicSetLinkRelationsLibrary(newLinkRelationsLibrary, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RapidmlPackage.ZEN_MODEL__LINK_RELATIONS_LIBRARY,
					newLinkRelationsLibrary, newLinkRelationsLibrary));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public com.reprezen.rapidml.PrimitiveTypesLibrary getPrimitiveTypesLibrary() {
		return primitiveTypesLibrary;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetPrimitiveTypesLibrary(
			com.reprezen.rapidml.PrimitiveTypesLibrary newPrimitiveTypesLibrary, NotificationChain msgs) {
		com.reprezen.rapidml.PrimitiveTypesLibrary oldPrimitiveTypesLibrary = primitiveTypesLibrary;
		primitiveTypesLibrary = newPrimitiveTypesLibrary;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					RapidmlPackage.ZEN_MODEL__PRIMITIVE_TYPES_LIBRARY, oldPrimitiveTypesLibrary,
					newPrimitiveTypesLibrary);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setPrimitiveTypesLibrary(com.reprezen.rapidml.PrimitiveTypesLibrary newPrimitiveTypesLibrary) {
		if (newPrimitiveTypesLibrary != primitiveTypesLibrary) {
			NotificationChain msgs = null;
			if (primitiveTypesLibrary != null)
				msgs = ((InternalEObject) primitiveTypesLibrary).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - RapidmlPackage.ZEN_MODEL__PRIMITIVE_TYPES_LIBRARY, null, msgs);
			if (newPrimitiveTypesLibrary != null)
				msgs = ((InternalEObject) newPrimitiveTypesLibrary).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - RapidmlPackage.ZEN_MODEL__PRIMITIVE_TYPES_LIBRARY, null, msgs);
			msgs = basicSetPrimitiveTypesLibrary(newPrimitiveTypesLibrary, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RapidmlPackage.ZEN_MODEL__PRIMITIVE_TYPES_LIBRARY,
					newPrimitiveTypesLibrary, newPrimitiveTypesLibrary));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<ImportDeclaration> getImports() {
		if (imports == null) {
			imports = new EObjectContainmentEList<ImportDeclaration>(ImportDeclaration.class, this,
					RapidmlPackage.ZEN_MODEL__IMPORTS);
		}
		return imports;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public SecuritySchemeLibrary getSecuritySchemesLibrary() {
		return securitySchemesLibrary;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetSecuritySchemesLibrary(SecuritySchemeLibrary newSecuritySchemesLibrary,
			NotificationChain msgs) {
		SecuritySchemeLibrary oldSecuritySchemesLibrary = securitySchemesLibrary;
		securitySchemesLibrary = newSecuritySchemesLibrary;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					RapidmlPackage.ZEN_MODEL__SECURITY_SCHEMES_LIBRARY, oldSecuritySchemesLibrary,
					newSecuritySchemesLibrary);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setSecuritySchemesLibrary(SecuritySchemeLibrary newSecuritySchemesLibrary) {
		if (newSecuritySchemesLibrary != securitySchemesLibrary) {
			NotificationChain msgs = null;
			if (securitySchemesLibrary != null)
				msgs = ((InternalEObject) securitySchemesLibrary).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - RapidmlPackage.ZEN_MODEL__SECURITY_SCHEMES_LIBRARY, null, msgs);
			if (newSecuritySchemesLibrary != null)
				msgs = ((InternalEObject) newSecuritySchemesLibrary).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - RapidmlPackage.ZEN_MODEL__SECURITY_SCHEMES_LIBRARY, null, msgs);
			msgs = basicSetSecuritySchemesLibrary(newSecuritySchemesLibrary, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RapidmlPackage.ZEN_MODEL__SECURITY_SCHEMES_LIBRARY,
					newSecuritySchemesLibrary, newSecuritySchemesLibrary));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case RapidmlPackage.ZEN_MODEL__EXTENSIONS:
			return ((InternalEList<?>) getExtensions()).basicRemove(otherEnd, msgs);
		case RapidmlPackage.ZEN_MODEL__RESOURCE_AP_IS:
			return ((InternalEList<?>) getResourceAPIs()).basicRemove(otherEnd, msgs);
		case RapidmlPackage.ZEN_MODEL__DATA_MODELS:
			return ((InternalEList<?>) getDataModels()).basicRemove(otherEnd, msgs);
		case RapidmlPackage.ZEN_MODEL__MEDIA_TYPES_LIBRARY:
			return basicSetMediaTypesLibrary(null, msgs);
		case RapidmlPackage.ZEN_MODEL__LINK_RELATIONS_LIBRARY:
			return basicSetLinkRelationsLibrary(null, msgs);
		case RapidmlPackage.ZEN_MODEL__PRIMITIVE_TYPES_LIBRARY:
			return basicSetPrimitiveTypesLibrary(null, msgs);
		case RapidmlPackage.ZEN_MODEL__IMPORTS:
			return ((InternalEList<?>) getImports()).basicRemove(otherEnd, msgs);
		case RapidmlPackage.ZEN_MODEL__SECURITY_SCHEMES_LIBRARY:
			return basicSetSecuritySchemesLibrary(null, msgs);
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
		case RapidmlPackage.ZEN_MODEL__EXTENSIONS:
			return getExtensions();
		case RapidmlPackage.ZEN_MODEL__TITLE:
			return getTitle();
		case RapidmlPackage.ZEN_MODEL__NAME:
			return getName();
		case RapidmlPackage.ZEN_MODEL__NAMESPACE:
			return getNamespace();
		case RapidmlPackage.ZEN_MODEL__RESOURCE_AP_IS:
			return getResourceAPIs();
		case RapidmlPackage.ZEN_MODEL__DATA_MODELS:
			return getDataModels();
		case RapidmlPackage.ZEN_MODEL__MEDIA_TYPES_LIBRARY:
			return getMediaTypesLibrary();
		case RapidmlPackage.ZEN_MODEL__LINK_RELATIONS_LIBRARY:
			return getLinkRelationsLibrary();
		case RapidmlPackage.ZEN_MODEL__PRIMITIVE_TYPES_LIBRARY:
			return getPrimitiveTypesLibrary();
		case RapidmlPackage.ZEN_MODEL__IMPORTS:
			return getImports();
		case RapidmlPackage.ZEN_MODEL__SECURITY_SCHEMES_LIBRARY:
			return getSecuritySchemesLibrary();
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
		case RapidmlPackage.ZEN_MODEL__EXTENSIONS:
			getExtensions().clear();
			getExtensions().addAll((Collection<? extends Extension>) newValue);
			return;
		case RapidmlPackage.ZEN_MODEL__TITLE:
			setTitle((String) newValue);
			return;
		case RapidmlPackage.ZEN_MODEL__NAME:
			setName((String) newValue);
			return;
		case RapidmlPackage.ZEN_MODEL__NAMESPACE:
			setNamespace((String) newValue);
			return;
		case RapidmlPackage.ZEN_MODEL__RESOURCE_AP_IS:
			getResourceAPIs().clear();
			getResourceAPIs().addAll((Collection<? extends ResourceAPI>) newValue);
			return;
		case RapidmlPackage.ZEN_MODEL__DATA_MODELS:
			getDataModels().clear();
			getDataModels().addAll((Collection<? extends com.reprezen.rapidml.DataModel>) newValue);
			return;
		case RapidmlPackage.ZEN_MODEL__MEDIA_TYPES_LIBRARY:
			setMediaTypesLibrary((com.reprezen.rapidml.MediaTypesLibrary) newValue);
			return;
		case RapidmlPackage.ZEN_MODEL__LINK_RELATIONS_LIBRARY:
			setLinkRelationsLibrary((com.reprezen.rapidml.LinkRelationsLibrary) newValue);
			return;
		case RapidmlPackage.ZEN_MODEL__PRIMITIVE_TYPES_LIBRARY:
			setPrimitiveTypesLibrary((com.reprezen.rapidml.PrimitiveTypesLibrary) newValue);
			return;
		case RapidmlPackage.ZEN_MODEL__IMPORTS:
			getImports().clear();
			getImports().addAll((Collection<? extends ImportDeclaration>) newValue);
			return;
		case RapidmlPackage.ZEN_MODEL__SECURITY_SCHEMES_LIBRARY:
			setSecuritySchemesLibrary((SecuritySchemeLibrary) newValue);
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
		case RapidmlPackage.ZEN_MODEL__EXTENSIONS:
			getExtensions().clear();
			return;
		case RapidmlPackage.ZEN_MODEL__TITLE:
			setTitle(TITLE_EDEFAULT);
			return;
		case RapidmlPackage.ZEN_MODEL__NAME:
			setName(NAME_EDEFAULT);
			return;
		case RapidmlPackage.ZEN_MODEL__NAMESPACE:
			setNamespace(NAMESPACE_EDEFAULT);
			return;
		case RapidmlPackage.ZEN_MODEL__RESOURCE_AP_IS:
			getResourceAPIs().clear();
			return;
		case RapidmlPackage.ZEN_MODEL__DATA_MODELS:
			getDataModels().clear();
			return;
		case RapidmlPackage.ZEN_MODEL__MEDIA_TYPES_LIBRARY:
			setMediaTypesLibrary((com.reprezen.rapidml.MediaTypesLibrary) null);
			return;
		case RapidmlPackage.ZEN_MODEL__LINK_RELATIONS_LIBRARY:
			setLinkRelationsLibrary((com.reprezen.rapidml.LinkRelationsLibrary) null);
			return;
		case RapidmlPackage.ZEN_MODEL__PRIMITIVE_TYPES_LIBRARY:
			setPrimitiveTypesLibrary((com.reprezen.rapidml.PrimitiveTypesLibrary) null);
			return;
		case RapidmlPackage.ZEN_MODEL__IMPORTS:
			getImports().clear();
			return;
		case RapidmlPackage.ZEN_MODEL__SECURITY_SCHEMES_LIBRARY:
			setSecuritySchemesLibrary((SecuritySchemeLibrary) null);
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
		case RapidmlPackage.ZEN_MODEL__EXTENSIONS:
			return extensions != null && !extensions.isEmpty();
		case RapidmlPackage.ZEN_MODEL__TITLE:
			return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
		case RapidmlPackage.ZEN_MODEL__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case RapidmlPackage.ZEN_MODEL__NAMESPACE:
			return NAMESPACE_EDEFAULT == null ? namespace != null : !NAMESPACE_EDEFAULT.equals(namespace);
		case RapidmlPackage.ZEN_MODEL__RESOURCE_AP_IS:
			return resourceAPIs != null && !resourceAPIs.isEmpty();
		case RapidmlPackage.ZEN_MODEL__DATA_MODELS:
			return dataModels != null && !dataModels.isEmpty();
		case RapidmlPackage.ZEN_MODEL__MEDIA_TYPES_LIBRARY:
			return mediaTypesLibrary != null;
		case RapidmlPackage.ZEN_MODEL__LINK_RELATIONS_LIBRARY:
			return linkRelationsLibrary != null;
		case RapidmlPackage.ZEN_MODEL__PRIMITIVE_TYPES_LIBRARY:
			return primitiveTypesLibrary != null;
		case RapidmlPackage.ZEN_MODEL__IMPORTS:
			return imports != null && !imports.isEmpty();
		case RapidmlPackage.ZEN_MODEL__SECURITY_SCHEMES_LIBRARY:
			return securitySchemesLibrary != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == Extensible.class) {
			switch (derivedFeatureID) {
			case RapidmlPackage.ZEN_MODEL__EXTENSIONS:
				return RapidmlPackage.EXTENSIBLE__EXTENSIONS;
			default:
				return -1;
			}
		}
		if (baseClass == HasTitle.class) {
			switch (derivedFeatureID) {
			case RapidmlPackage.ZEN_MODEL__TITLE:
				return RapidmlPackage.HAS_TITLE__TITLE;
			default:
				return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == Extensible.class) {
			switch (baseFeatureID) {
			case RapidmlPackage.EXTENSIBLE__EXTENSIONS:
				return RapidmlPackage.ZEN_MODEL__EXTENSIONS;
			default:
				return -1;
			}
		}
		if (baseClass == HasTitle.class) {
			switch (baseFeatureID) {
			case RapidmlPackage.HAS_TITLE__TITLE:
				return RapidmlPackage.ZEN_MODEL__TITLE;
			default:
				return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

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
