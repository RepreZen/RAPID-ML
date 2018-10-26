/**
 * Copyright © 2013-2016 Modelsolv, Inc.
 * All Rights Reserved.
 * 
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 */
package com.reprezen.rapidml.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import com.google.common.base.Strings;
import com.reprezen.realization.model.RealizationModel;
import com.reprezen.realization.parser.RealizationModelParser;
import com.reprezen.rapidml.RealizationModelLocation;
import com.reprezen.rapidml.RapidmlPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Realization Model Location</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.reprezen.rapidml.impl.RealizationModelLocationImpl#getUri <em>Uri</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RealizationModelLocationImpl extends EObjectImpl implements RealizationModelLocation {
    /**
     * The default value of the '{@link #getUri() <em>Uri</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @see #getUri()
     * @generated
     * @ordered
     */
    protected static final String URI_EDEFAULT = null;

    /**
	 * The cached value of the '{@link #getUri() <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getUri()
	 * @generated
	 * @ordered
	 */
    protected String uri = URI_EDEFAULT;

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    protected RealizationModelLocationImpl() {
		super();
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected EClass eStaticClass() {
		return RapidmlPackage.Literals.REALIZATION_MODEL_LOCATION;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public String getUri() {
		return uri;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public void setUri(String newUri) {
		String oldUri = uri;
		uri = newUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RapidmlPackage.REALIZATION_MODEL_LOCATION__URI, oldUri, uri));
	}

    private RealizationModel realizationModel = null;
    private boolean failed = false;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    @Override
    public RealizationModel getRealizationModel() {
        if (realizationModel == null && !failed) {
            RealizationModelParser parser = new RealizationModelParser();
            URI baseURI = eResource().getURI();
            if (baseURI != null && Strings.emptyToNull(getUri()) != null) {
                try {

                    URI realizationUri;
                    if (baseURI.isPlatformPlugin() || baseURI.isPlatformResource()) {
                        realizationUri = URI.createURI(getUri(), true).resolve(baseURI);
                    } else {
                        realizationUri = URI.createFileURI(getUri()).resolve(baseURI);
                    }

                    if (!eResource().getResourceSet().getURIConverter().exists(realizationUri, null)) {
                        throw new IOException("Realization file does not exist.");
                    }

                    URL realizationUrl = new URL(realizationUri.toString());

                    String content = "";
                    try (BufferedReader reader = new BufferedReader(
                            new InputStreamReader(realizationUrl.openStream(), StandardCharsets.UTF_8))) {
                        content = reader.lines().collect(Collectors.joining("\n"));
                    }
                    realizationModel = parser.parse(content, realizationUrl);

                } catch (Exception e) {
                    // TODO
                    // RestApiPlugin.logWarning("Cannot load a RealizationModel for " + getUri(), e);
                    failed = true;
                    return null;
                }
            }
        }
        return realizationModel;
    }

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RapidmlPackage.REALIZATION_MODEL_LOCATION__URI:
				return getUri();
		}
		return super.eGet(featureID, resolve, coreType);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case RapidmlPackage.REALIZATION_MODEL_LOCATION__URI:
				setUri((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public void eUnset(int featureID) {
		switch (featureID) {
			case RapidmlPackage.REALIZATION_MODEL_LOCATION__URI:
				setUri(URI_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public boolean eIsSet(int featureID) {
		switch (featureID) {
			case RapidmlPackage.REALIZATION_MODEL_LOCATION__URI:
				return URI_EDEFAULT == null ? uri != null : !URI_EDEFAULT.equals(uri);
		}
		return super.eIsSet(featureID);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (uri: ");
		result.append(uri);
		result.append(')');
		return result.toString();
	}

} // RealizationModelLocationImpl
