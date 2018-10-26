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
package com.modelsolv.reprezen.rapidml.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import com.modelsolv.reprezen.rapidml.ImportDeclaration;
import com.modelsolv.reprezen.rapidml.RapidmlPackage;
import com.modelsolv.reprezen.rapidml.ZenModel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Import Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.modelsolv.reprezen.rapidml.impl.ImportDeclarationImpl#getImportURI <em>Import URI</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.rapidml.impl.ImportDeclarationImpl#getImportedNamespace <em>Imported Namespace</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.rapidml.impl.ImportDeclarationImpl#getAlias <em>Alias</em>}</li>
 *   <li>{@link com.modelsolv.reprezen.rapidml.impl.ImportDeclarationImpl#getImportedModel <em>Imported Model</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ImportDeclarationImpl extends EObjectImpl implements ImportDeclaration {
    /**
	 * The default value of the '{@link #getImportURI() <em>Import URI</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getImportURI()
	 * @generated
	 * @ordered
	 */
    protected static final String IMPORT_URI_EDEFAULT = null;

    /**
	 * The cached value of the '{@link #getImportURI() <em>Import URI</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getImportURI()
	 * @generated
	 * @ordered
	 */
    protected String importURI = IMPORT_URI_EDEFAULT;

    /**
	 * The default value of the '{@link #getImportedNamespace() <em>Imported Namespace</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getImportedNamespace()
	 * @generated
	 * @ordered
	 */
    protected static final String IMPORTED_NAMESPACE_EDEFAULT = null;

    /**
	 * The cached value of the '{@link #getImportedNamespace() <em>Imported Namespace</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getImportedNamespace()
	 * @generated
	 * @ordered
	 */
    protected String importedNamespace = IMPORTED_NAMESPACE_EDEFAULT;

    /**
	 * The default value of the '{@link #getAlias() <em>Alias</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getAlias()
	 * @generated
	 * @ordered
	 */
    protected static final String ALIAS_EDEFAULT = null;

    /**
	 * The cached value of the '{@link #getAlias() <em>Alias</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getAlias()
	 * @generated
	 * @ordered
	 */
    protected String alias = ALIAS_EDEFAULT;

    /**
	 * The cached value of the '{@link #getImportedModel() <em>Imported Model</em>}' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getImportedModel()
	 * @generated
	 * @ordered
	 */
    protected ZenModel importedModel;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected ImportDeclarationImpl() {
		super();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected EClass eStaticClass() {
		return RapidmlPackage.Literals.IMPORT_DECLARATION;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public String getImportURI() {
		return importURI;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setImportURI(String newImportURI) {
		String oldImportURI = importURI;
		importURI = newImportURI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RapidmlPackage.IMPORT_DECLARATION__IMPORT_URI, oldImportURI, importURI));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public String getImportedNamespace() {
		return importedNamespace;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setImportedNamespace(String newImportedNamespace) {
		String oldImportedNamespace = importedNamespace;
		importedNamespace = newImportedNamespace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RapidmlPackage.IMPORT_DECLARATION__IMPORTED_NAMESPACE, oldImportedNamespace, importedNamespace));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public String getAlias() {
		return alias;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setAlias(String newAlias) {
		String oldAlias = alias;
		alias = newAlias;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RapidmlPackage.IMPORT_DECLARATION__ALIAS, oldAlias, alias));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public ZenModel getImportedModel() {
		if (importedModel != null && importedModel.eIsProxy()) {
			InternalEObject oldImportedModel = (InternalEObject)importedModel;
			importedModel = (ZenModel)eResolveProxy(oldImportedModel);
			if (importedModel != oldImportedModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RapidmlPackage.IMPORT_DECLARATION__IMPORTED_MODEL, oldImportedModel, importedModel));
			}
		}
		return importedModel;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public ZenModel basicGetImportedModel() {
		return importedModel;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setImportedModel(ZenModel newImportedModel) {
		ZenModel oldImportedModel = importedModel;
		importedModel = newImportedModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RapidmlPackage.IMPORT_DECLARATION__IMPORTED_MODEL, oldImportedModel, importedModel));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RapidmlPackage.IMPORT_DECLARATION__IMPORT_URI:
				return getImportURI();
			case RapidmlPackage.IMPORT_DECLARATION__IMPORTED_NAMESPACE:
				return getImportedNamespace();
			case RapidmlPackage.IMPORT_DECLARATION__ALIAS:
				return getAlias();
			case RapidmlPackage.IMPORT_DECLARATION__IMPORTED_MODEL:
				if (resolve) return getImportedModel();
				return basicGetImportedModel();
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
			case RapidmlPackage.IMPORT_DECLARATION__IMPORT_URI:
				setImportURI((String)newValue);
				return;
			case RapidmlPackage.IMPORT_DECLARATION__IMPORTED_NAMESPACE:
				setImportedNamespace((String)newValue);
				return;
			case RapidmlPackage.IMPORT_DECLARATION__ALIAS:
				setAlias((String)newValue);
				return;
			case RapidmlPackage.IMPORT_DECLARATION__IMPORTED_MODEL:
				setImportedModel((ZenModel)newValue);
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
			case RapidmlPackage.IMPORT_DECLARATION__IMPORT_URI:
				setImportURI(IMPORT_URI_EDEFAULT);
				return;
			case RapidmlPackage.IMPORT_DECLARATION__IMPORTED_NAMESPACE:
				setImportedNamespace(IMPORTED_NAMESPACE_EDEFAULT);
				return;
			case RapidmlPackage.IMPORT_DECLARATION__ALIAS:
				setAlias(ALIAS_EDEFAULT);
				return;
			case RapidmlPackage.IMPORT_DECLARATION__IMPORTED_MODEL:
				setImportedModel((ZenModel)null);
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
			case RapidmlPackage.IMPORT_DECLARATION__IMPORT_URI:
				return IMPORT_URI_EDEFAULT == null ? importURI != null : !IMPORT_URI_EDEFAULT.equals(importURI);
			case RapidmlPackage.IMPORT_DECLARATION__IMPORTED_NAMESPACE:
				return IMPORTED_NAMESPACE_EDEFAULT == null ? importedNamespace != null : !IMPORTED_NAMESPACE_EDEFAULT.equals(importedNamespace);
			case RapidmlPackage.IMPORT_DECLARATION__ALIAS:
				return ALIAS_EDEFAULT == null ? alias != null : !ALIAS_EDEFAULT.equals(alias);
			case RapidmlPackage.IMPORT_DECLARATION__IMPORTED_MODEL:
				return importedModel != null;
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
		result.append(" (importURI: ");
		result.append(importURI);
		result.append(", importedNamespace: ");
		result.append(importedNamespace);
		result.append(", alias: ");
		result.append(alias);
		result.append(')');
		return result.toString();
	}

} //ImportDeclarationImpl
