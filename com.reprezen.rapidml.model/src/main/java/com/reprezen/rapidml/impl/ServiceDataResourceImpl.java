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
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.reprezen.rapidml.AuthenticationMethod;
import com.reprezen.rapidml.Documentable;
import com.reprezen.rapidml.Documentation;
import com.reprezen.rapidml.Example;
import com.reprezen.rapidml.HasSecurityValue;
import com.reprezen.rapidml.MediaType;
import com.reprezen.rapidml.Method;
import com.reprezen.rapidml.NamedLinkDescriptor;
import com.reprezen.rapidml.PropertyRealization;
import com.reprezen.rapidml.RESTElement;
import com.reprezen.rapidml.RapidmlPackage;
import com.reprezen.rapidml.ReferenceEmbed;
import com.reprezen.rapidml.ReferenceLink;
import com.reprezen.rapidml.ReferenceTreatment;
import com.reprezen.rapidml.ResourceDefinition;
import com.reprezen.rapidml.ServiceDataResource;
import com.reprezen.rapidml.URI;
import com.reprezen.rapidml.WithExamples;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Service
 * Data Resource</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link com.reprezen.rapidml.impl.ServiceDataResourceImpl#getDocumentation
 * <em>Documentation</em>}</li>
 * <li>{@link com.reprezen.rapidml.impl.ServiceDataResourceImpl#getExamples
 * <em>Examples</em>}</li>
 * <li>{@link com.reprezen.rapidml.impl.ServiceDataResourceImpl#getSecuredBy
 * <em>Secured By</em>}</li>
 * <li>{@link com.reprezen.rapidml.impl.ServiceDataResourceImpl#getMethods
 * <em>Methods</em>}</li>
 * <li>{@link com.reprezen.rapidml.impl.ServiceDataResourceImpl#getMediaTypes
 * <em>Media Types</em>}</li>
 * <li>{@link com.reprezen.rapidml.impl.ServiceDataResourceImpl#getName
 * <em>Name</em>}</li>
 * <li>{@link com.reprezen.rapidml.impl.ServiceDataResourceImpl#getAllMediaTypes
 * <em>All Media Types</em>}</li>
 * <li>{@link com.reprezen.rapidml.impl.ServiceDataResourceImpl#getURI
 * <em>URI</em>}</li>
 * <li>{@link com.reprezen.rapidml.impl.ServiceDataResourceImpl#isDefault
 * <em>Default</em>}</li>
 * <li>{@link com.reprezen.rapidml.impl.ServiceDataResourceImpl#getDefinedLinkDescriptors
 * <em>Defined Link Descriptors</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ServiceDataResourceImpl extends RealizationContainerImpl implements ServiceDataResource {
	/**
	 * The cached value of the '{@link #getDocumentation() <em>Documentation</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDocumentation()
	 * @generated
	 * @ordered
	 */
	protected Documentation documentation;

	/**
	 * The cached value of the '{@link #getExamples() <em>Examples</em>}'
	 * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getExamples()
	 * @generated
	 * @ordered
	 */
	protected EList<Example> examples;

	/**
	 * The cached value of the '{@link #getSecuredBy() <em>Secured By</em>}'
	 * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSecuredBy()
	 * @generated
	 * @ordered
	 */
	protected EList<AuthenticationMethod> securedBy;

	/**
	 * The cached value of the '{@link #getMethods() <em>Methods</em>}' containment
	 * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getMethods()
	 * @generated
	 * @ordered
	 */
	protected EList<Method> methods;

	/**
	 * The cached value of the '{@link #getMediaTypes() <em>Media Types</em>}'
	 * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getMediaTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<MediaType> mediaTypes;

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
	 * The cached value of the '{@link #getAllMediaTypes() <em>All Media
	 * Types</em>}' reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getAllMediaTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<MediaType> allMediaTypes;

	/**
	 * The cached value of the '{@link #getURI() <em>URI</em>}' containment
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getURI()
	 * @generated
	 * @ordered
	 */
	protected URI uri;

	/**
	 * The default value of the '{@link #isDefault() <em>Default</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isDefault()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DEFAULT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDefault() <em>Default</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isDefault()
	 * @generated
	 * @ordered
	 */
	protected boolean default_ = DEFAULT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDefinedLinkDescriptors() <em>Defined Link
	 * Descriptors</em>}' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getDefinedLinkDescriptors()
	 * @generated
	 * @ordered
	 */
	protected EList<NamedLinkDescriptor> definedLinkDescriptors;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ServiceDataResourceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RapidmlPackage.Literals.SERVICE_DATA_RESOURCE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Documentation getDocumentation() {
		return documentation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetDocumentation(Documentation newDocumentation, NotificationChain msgs) {
		Documentation oldDocumentation = documentation;
		documentation = newDocumentation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					RapidmlPackage.SERVICE_DATA_RESOURCE__DOCUMENTATION, oldDocumentation, newDocumentation);
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
	public void setDocumentation(Documentation newDocumentation) {
		if (newDocumentation != documentation) {
			NotificationChain msgs = null;
			if (documentation != null)
				msgs = ((InternalEObject) documentation).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - RapidmlPackage.SERVICE_DATA_RESOURCE__DOCUMENTATION, null, msgs);
			if (newDocumentation != null)
				msgs = ((InternalEObject) newDocumentation).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - RapidmlPackage.SERVICE_DATA_RESOURCE__DOCUMENTATION, null, msgs);
			msgs = basicSetDocumentation(newDocumentation, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RapidmlPackage.SERVICE_DATA_RESOURCE__DOCUMENTATION,
					newDocumentation, newDocumentation));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Example> getExamples() {
		if (examples == null) {
			examples = new EObjectContainmentEList<Example>(Example.class, this,
					RapidmlPackage.SERVICE_DATA_RESOURCE__EXAMPLES);
		}
		return examples;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<AuthenticationMethod> getSecuredBy() {
		if (securedBy == null) {
			securedBy = new EObjectContainmentEList<AuthenticationMethod>(AuthenticationMethod.class, this,
					RapidmlPackage.SERVICE_DATA_RESOURCE__SECURED_BY);
		}
		return securedBy;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Method> getMethods() {
		if (methods == null) {
			methods = new EObjectContainmentWithInverseEList<Method>(Method.class, this,
					RapidmlPackage.SERVICE_DATA_RESOURCE__METHODS,
					RapidmlPackage.METHOD__CONTAINING_RESOURCE_DEFINITION);
		}
		return methods;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<MediaType> getMediaTypes() {
		if (mediaTypes == null) {
			mediaTypes = new EObjectResolvingEList<MediaType>(MediaType.class, this,
					RapidmlPackage.SERVICE_DATA_RESOURCE__MEDIA_TYPES);
		}
		return mediaTypes;
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
			eNotify(new ENotificationImpl(this, Notification.SET, RapidmlPackage.SERVICE_DATA_RESOURCE__NAME, oldName,
					name));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<MediaType> getAllMediaTypes() {
		if (allMediaTypes == null) {
			allMediaTypes = new EObjectResolvingEList<MediaType>(MediaType.class, this,
					RapidmlPackage.SERVICE_DATA_RESOURCE__ALL_MEDIA_TYPES);
		}
		return allMediaTypes;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public URI getURI() {
		return uri;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetURI(URI newURI, NotificationChain msgs) {
		URI oldURI = uri;
		uri = newURI;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					RapidmlPackage.SERVICE_DATA_RESOURCE__URI, oldURI, newURI);
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
	public void setURI(URI newURI) {
		if (newURI != uri) {
			NotificationChain msgs = null;
			if (uri != null)
				msgs = ((InternalEObject) uri).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - RapidmlPackage.SERVICE_DATA_RESOURCE__URI, null, msgs);
			if (newURI != null)
				msgs = ((InternalEObject) newURI).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - RapidmlPackage.SERVICE_DATA_RESOURCE__URI, null, msgs);
			msgs = basicSetURI(newURI, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RapidmlPackage.SERVICE_DATA_RESOURCE__URI, newURI,
					newURI));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isDefault() {
		return default_;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setDefault(boolean newDefault) {
		boolean oldDefault = default_;
		default_ = newDefault;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RapidmlPackage.SERVICE_DATA_RESOURCE__DEFAULT,
					oldDefault, default_));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<NamedLinkDescriptor> getDefinedLinkDescriptors() {
		if (definedLinkDescriptors == null) {
			definedLinkDescriptors = new EObjectContainmentEList<NamedLinkDescriptor>(NamedLinkDescriptor.class, this,
					RapidmlPackage.SERVICE_DATA_RESOURCE__DEFINED_LINK_DESCRIPTORS);
		}
		return definedLinkDescriptors;
	}

	/**
	 * @generated NOT
	 */
	public EList<PropertyRealization> getIncludedProperties() {
		if (getProperties() == null) {
			return ECollections.emptyEList();
		}
		return getProperties().getAllIncludedProperties();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case RapidmlPackage.SERVICE_DATA_RESOURCE__METHODS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getMethods()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NamedLinkDescriptor getDefaultLinkDescriptor() {
		return com.reprezen.rapidml.util.RapidmlModelUtils.getDefaultLinkDescriptor(this);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isIncluded(final com.reprezen.rapidml.Feature feature) {
		return com.reprezen.rapidml.util.RapidmlModelUtils.isFeatureIncluded(this, feature);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<ReferenceLink> getReferenceLinks() {
		Collection<ReferenceLink> referenceTreatments = Lists
				.newArrayList(Iterables.filter(getReferenceTreatments(), ReferenceLink.class));
		return new BasicEList<ReferenceLink>(referenceTreatments);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<ReferenceTreatment> getAllReferenceTreatments() {
		List<ReferenceTreatment> allReferenceTreatments = Lists.newArrayList(getReferenceTreatments());
		Iterable<ReferenceEmbed> referenceEmbeds = Iterables.filter(allReferenceTreatments, ReferenceEmbed.class);
		Iterable<List<ReferenceTreatment>> nestedReferenceTreatmentsAsList = Iterables.transform(referenceEmbeds,
				new Function<ReferenceEmbed, List<ReferenceTreatment>>() {

					@Override
					public List<ReferenceTreatment> apply(ReferenceEmbed input) {
						return input.getAllNestedReferenceTreatments();
					}
				});
		Iterable<ReferenceTreatment> flatNestedReferenceTreatments = Iterables.concat(nestedReferenceTreatmentsAsList);
		allReferenceTreatments.addAll(Lists.newArrayList(flatNestedReferenceTreatments));
		return ECollections.unmodifiableEList(allReferenceTreatments);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case RapidmlPackage.SERVICE_DATA_RESOURCE__DOCUMENTATION:
			return basicSetDocumentation(null, msgs);
		case RapidmlPackage.SERVICE_DATA_RESOURCE__EXAMPLES:
			return ((InternalEList<?>) getExamples()).basicRemove(otherEnd, msgs);
		case RapidmlPackage.SERVICE_DATA_RESOURCE__SECURED_BY:
			return ((InternalEList<?>) getSecuredBy()).basicRemove(otherEnd, msgs);
		case RapidmlPackage.SERVICE_DATA_RESOURCE__METHODS:
			return ((InternalEList<?>) getMethods()).basicRemove(otherEnd, msgs);
		case RapidmlPackage.SERVICE_DATA_RESOURCE__URI:
			return basicSetURI(null, msgs);
		case RapidmlPackage.SERVICE_DATA_RESOURCE__DEFINED_LINK_DESCRIPTORS:
			return ((InternalEList<?>) getDefinedLinkDescriptors()).basicRemove(otherEnd, msgs);
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
		case RapidmlPackage.SERVICE_DATA_RESOURCE__DOCUMENTATION:
			return getDocumentation();
		case RapidmlPackage.SERVICE_DATA_RESOURCE__EXAMPLES:
			return getExamples();
		case RapidmlPackage.SERVICE_DATA_RESOURCE__SECURED_BY:
			return getSecuredBy();
		case RapidmlPackage.SERVICE_DATA_RESOURCE__METHODS:
			return getMethods();
		case RapidmlPackage.SERVICE_DATA_RESOURCE__MEDIA_TYPES:
			return getMediaTypes();
		case RapidmlPackage.SERVICE_DATA_RESOURCE__NAME:
			return getName();
		case RapidmlPackage.SERVICE_DATA_RESOURCE__ALL_MEDIA_TYPES:
			return getAllMediaTypes();
		case RapidmlPackage.SERVICE_DATA_RESOURCE__URI:
			return getURI();
		case RapidmlPackage.SERVICE_DATA_RESOURCE__DEFAULT:
			return isDefault();
		case RapidmlPackage.SERVICE_DATA_RESOURCE__DEFINED_LINK_DESCRIPTORS:
			return getDefinedLinkDescriptors();
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
		case RapidmlPackage.SERVICE_DATA_RESOURCE__DOCUMENTATION:
			setDocumentation((Documentation) newValue);
			return;
		case RapidmlPackage.SERVICE_DATA_RESOURCE__EXAMPLES:
			getExamples().clear();
			getExamples().addAll((Collection<? extends Example>) newValue);
			return;
		case RapidmlPackage.SERVICE_DATA_RESOURCE__SECURED_BY:
			getSecuredBy().clear();
			getSecuredBy().addAll((Collection<? extends AuthenticationMethod>) newValue);
			return;
		case RapidmlPackage.SERVICE_DATA_RESOURCE__METHODS:
			getMethods().clear();
			getMethods().addAll((Collection<? extends Method>) newValue);
			return;
		case RapidmlPackage.SERVICE_DATA_RESOURCE__MEDIA_TYPES:
			getMediaTypes().clear();
			getMediaTypes().addAll((Collection<? extends MediaType>) newValue);
			return;
		case RapidmlPackage.SERVICE_DATA_RESOURCE__NAME:
			setName((String) newValue);
			return;
		case RapidmlPackage.SERVICE_DATA_RESOURCE__ALL_MEDIA_TYPES:
			getAllMediaTypes().clear();
			getAllMediaTypes().addAll((Collection<? extends MediaType>) newValue);
			return;
		case RapidmlPackage.SERVICE_DATA_RESOURCE__URI:
			setURI((URI) newValue);
			return;
		case RapidmlPackage.SERVICE_DATA_RESOURCE__DEFAULT:
			setDefault((Boolean) newValue);
			return;
		case RapidmlPackage.SERVICE_DATA_RESOURCE__DEFINED_LINK_DESCRIPTORS:
			getDefinedLinkDescriptors().clear();
			getDefinedLinkDescriptors().addAll((Collection<? extends NamedLinkDescriptor>) newValue);
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
		case RapidmlPackage.SERVICE_DATA_RESOURCE__DOCUMENTATION:
			setDocumentation((Documentation) null);
			return;
		case RapidmlPackage.SERVICE_DATA_RESOURCE__EXAMPLES:
			getExamples().clear();
			return;
		case RapidmlPackage.SERVICE_DATA_RESOURCE__SECURED_BY:
			getSecuredBy().clear();
			return;
		case RapidmlPackage.SERVICE_DATA_RESOURCE__METHODS:
			getMethods().clear();
			return;
		case RapidmlPackage.SERVICE_DATA_RESOURCE__MEDIA_TYPES:
			getMediaTypes().clear();
			return;
		case RapidmlPackage.SERVICE_DATA_RESOURCE__NAME:
			setName(NAME_EDEFAULT);
			return;
		case RapidmlPackage.SERVICE_DATA_RESOURCE__ALL_MEDIA_TYPES:
			getAllMediaTypes().clear();
			return;
		case RapidmlPackage.SERVICE_DATA_RESOURCE__URI:
			setURI((URI) null);
			return;
		case RapidmlPackage.SERVICE_DATA_RESOURCE__DEFAULT:
			setDefault(DEFAULT_EDEFAULT);
			return;
		case RapidmlPackage.SERVICE_DATA_RESOURCE__DEFINED_LINK_DESCRIPTORS:
			getDefinedLinkDescriptors().clear();
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
		case RapidmlPackage.SERVICE_DATA_RESOURCE__DOCUMENTATION:
			return documentation != null;
		case RapidmlPackage.SERVICE_DATA_RESOURCE__EXAMPLES:
			return examples != null && !examples.isEmpty();
		case RapidmlPackage.SERVICE_DATA_RESOURCE__SECURED_BY:
			return securedBy != null && !securedBy.isEmpty();
		case RapidmlPackage.SERVICE_DATA_RESOURCE__METHODS:
			return methods != null && !methods.isEmpty();
		case RapidmlPackage.SERVICE_DATA_RESOURCE__MEDIA_TYPES:
			return mediaTypes != null && !mediaTypes.isEmpty();
		case RapidmlPackage.SERVICE_DATA_RESOURCE__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case RapidmlPackage.SERVICE_DATA_RESOURCE__ALL_MEDIA_TYPES:
			return allMediaTypes != null && !allMediaTypes.isEmpty();
		case RapidmlPackage.SERVICE_DATA_RESOURCE__URI:
			return uri != null;
		case RapidmlPackage.SERVICE_DATA_RESOURCE__DEFAULT:
			return default_ != DEFAULT_EDEFAULT;
		case RapidmlPackage.SERVICE_DATA_RESOURCE__DEFINED_LINK_DESCRIPTORS:
			return definedLinkDescriptors != null && !definedLinkDescriptors.isEmpty();
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
		if (baseClass == Documentable.class) {
			switch (derivedFeatureID) {
			case RapidmlPackage.SERVICE_DATA_RESOURCE__DOCUMENTATION:
				return RapidmlPackage.DOCUMENTABLE__DOCUMENTATION;
			default:
				return -1;
			}
		}
		if (baseClass == RESTElement.class) {
			switch (derivedFeatureID) {
			default:
				return -1;
			}
		}
		if (baseClass == WithExamples.class) {
			switch (derivedFeatureID) {
			case RapidmlPackage.SERVICE_DATA_RESOURCE__EXAMPLES:
				return RapidmlPackage.WITH_EXAMPLES__EXAMPLES;
			default:
				return -1;
			}
		}
		if (baseClass == HasSecurityValue.class) {
			switch (derivedFeatureID) {
			case RapidmlPackage.SERVICE_DATA_RESOURCE__SECURED_BY:
				return RapidmlPackage.HAS_SECURITY_VALUE__SECURED_BY;
			default:
				return -1;
			}
		}
		if (baseClass == ResourceDefinition.class) {
			switch (derivedFeatureID) {
			case RapidmlPackage.SERVICE_DATA_RESOURCE__METHODS:
				return RapidmlPackage.RESOURCE_DEFINITION__METHODS;
			case RapidmlPackage.SERVICE_DATA_RESOURCE__MEDIA_TYPES:
				return RapidmlPackage.RESOURCE_DEFINITION__MEDIA_TYPES;
			case RapidmlPackage.SERVICE_DATA_RESOURCE__NAME:
				return RapidmlPackage.RESOURCE_DEFINITION__NAME;
			case RapidmlPackage.SERVICE_DATA_RESOURCE__ALL_MEDIA_TYPES:
				return RapidmlPackage.RESOURCE_DEFINITION__ALL_MEDIA_TYPES;
			case RapidmlPackage.SERVICE_DATA_RESOURCE__URI:
				return RapidmlPackage.RESOURCE_DEFINITION__URI;
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
		if (baseClass == Documentable.class) {
			switch (baseFeatureID) {
			case RapidmlPackage.DOCUMENTABLE__DOCUMENTATION:
				return RapidmlPackage.SERVICE_DATA_RESOURCE__DOCUMENTATION;
			default:
				return -1;
			}
		}
		if (baseClass == RESTElement.class) {
			switch (baseFeatureID) {
			default:
				return -1;
			}
		}
		if (baseClass == WithExamples.class) {
			switch (baseFeatureID) {
			case RapidmlPackage.WITH_EXAMPLES__EXAMPLES:
				return RapidmlPackage.SERVICE_DATA_RESOURCE__EXAMPLES;
			default:
				return -1;
			}
		}
		if (baseClass == HasSecurityValue.class) {
			switch (baseFeatureID) {
			case RapidmlPackage.HAS_SECURITY_VALUE__SECURED_BY:
				return RapidmlPackage.SERVICE_DATA_RESOURCE__SECURED_BY;
			default:
				return -1;
			}
		}
		if (baseClass == ResourceDefinition.class) {
			switch (baseFeatureID) {
			case RapidmlPackage.RESOURCE_DEFINITION__METHODS:
				return RapidmlPackage.SERVICE_DATA_RESOURCE__METHODS;
			case RapidmlPackage.RESOURCE_DEFINITION__MEDIA_TYPES:
				return RapidmlPackage.SERVICE_DATA_RESOURCE__MEDIA_TYPES;
			case RapidmlPackage.RESOURCE_DEFINITION__NAME:
				return RapidmlPackage.SERVICE_DATA_RESOURCE__NAME;
			case RapidmlPackage.RESOURCE_DEFINITION__ALL_MEDIA_TYPES:
				return RapidmlPackage.SERVICE_DATA_RESOURCE__ALL_MEDIA_TYPES;
			case RapidmlPackage.RESOURCE_DEFINITION__URI:
				return RapidmlPackage.SERVICE_DATA_RESOURCE__URI;
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
		result.append(" (name: ");
		result.append(name);
		result.append(", default: ");
		result.append(default_);
		result.append(')');
		return result.toString();
	}

} // ServiceDataResourceImpl
