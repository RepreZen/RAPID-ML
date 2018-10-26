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
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.reprezen.rapidml.Documentable;
import com.reprezen.rapidml.Documentation;
import com.reprezen.rapidml.Example;
import com.reprezen.rapidml.MediaType;
import com.reprezen.rapidml.MessageParameter;
import com.reprezen.rapidml.Method;
import com.reprezen.rapidml.PropertyRealization;
import com.reprezen.rapidml.RESTElement;
import com.reprezen.rapidml.ReferenceLink;
import com.reprezen.rapidml.ResourceDefinition;
import com.reprezen.rapidml.RapidmlPackage;
import com.reprezen.rapidml.Structure;
import com.reprezen.rapidml.TypedMessage;
import com.reprezen.rapidml.WithExamples;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Typed Message</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.reprezen.rapidml.impl.TypedMessageImpl#getDocumentation <em>Documentation</em>}</li>
 *   <li>{@link com.reprezen.rapidml.impl.TypedMessageImpl#getExamples <em>Examples</em>}</li>
 *   <li>{@link com.reprezen.rapidml.impl.TypedMessageImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link com.reprezen.rapidml.impl.TypedMessageImpl#getResourceType <em>Resource Type</em>}</li>
 *   <li>{@link com.reprezen.rapidml.impl.TypedMessageImpl#isUseParentTypeReference <em>Use Parent Type Reference</em>}</li>
 *   <li>{@link com.reprezen.rapidml.impl.TypedMessageImpl#getMediaTypes <em>Media Types</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class TypedMessageImpl extends RealizationContainerImpl implements TypedMessage {
    /**
	 * The cached value of the '{@link #getDocumentation() <em>Documentation</em>}' containment reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getDocumentation()
	 * @generated
	 * @ordered
	 */
    protected Documentation documentation;

    /**
     * The cached value of the '{@link #getExamples() <em>Examples</em>}' containment reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getExamples()
     * @generated
     * @ordered
     */
    protected EList<Example> examples;

    /**
     * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getParameters()
     * @generated
     * @ordered
     */
    protected EList<MessageParameter> parameters;

    /**
	 * The cached value of the '{@link #getResourceType() <em>Resource Type</em>}' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getResourceType()
	 * @generated
	 * @ordered
	 */
    protected ResourceDefinition resourceType;

    /**
     * The default value of the '{@link #isUseParentTypeReference() <em>Use Parent Type Reference</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #isUseParentTypeReference()
     * @generated
     * @ordered
     */
    protected static final boolean USE_PARENT_TYPE_REFERENCE_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isUseParentTypeReference() <em>Use Parent Type Reference</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #isUseParentTypeReference()
     * @generated
     * @ordered
     */
    protected boolean useParentTypeReference = USE_PARENT_TYPE_REFERENCE_EDEFAULT;

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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    protected TypedMessageImpl() {
		super();
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected EClass eStaticClass() {
		return RapidmlPackage.Literals.TYPED_MESSAGE;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public Documentation getDocumentation() {
		return documentation;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public NotificationChain basicSetDocumentation(Documentation newDocumentation, NotificationChain msgs) {
		Documentation oldDocumentation = documentation;
		documentation = newDocumentation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RapidmlPackage.TYPED_MESSAGE__DOCUMENTATION, oldDocumentation, newDocumentation);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setDocumentation(Documentation newDocumentation) {
		if (newDocumentation != documentation) {
			NotificationChain msgs = null;
			if (documentation != null)
				msgs = ((InternalEObject)documentation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RapidmlPackage.TYPED_MESSAGE__DOCUMENTATION, null, msgs);
			if (newDocumentation != null)
				msgs = ((InternalEObject)newDocumentation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RapidmlPackage.TYPED_MESSAGE__DOCUMENTATION, null, msgs);
			msgs = basicSetDocumentation(newDocumentation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RapidmlPackage.TYPED_MESSAGE__DOCUMENTATION, newDocumentation, newDocumentation));
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public EList<Example> getExamples() {
		if (examples == null) {
			examples = new EObjectContainmentEList<Example>(Example.class, this, RapidmlPackage.TYPED_MESSAGE__EXAMPLES);
		}
		return examples;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public EList<MessageParameter> getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentWithInverseEList<MessageParameter>(MessageParameter.class, this, RapidmlPackage.TYPED_MESSAGE__PARAMETERS, RapidmlPackage.MESSAGE_PARAMETER__CONTAINING_MESSAGE);
		}
		return parameters;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public ResourceDefinition getResourceTypeGen() {
		if (resourceType != null && resourceType.eIsProxy()) {
			InternalEObject oldResourceType = (InternalEObject)resourceType;
			resourceType = (ResourceDefinition)eResolveProxy(oldResourceType);
			if (resourceType != oldResourceType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RapidmlPackage.TYPED_MESSAGE__RESOURCE_TYPE, oldResourceType, resourceType));
			}
		}
		return resourceType;
	}

    @Override
    public ResourceDefinition getResourceType() {
        if (getResourceTypeGen() == null && isUseParentTypeReference()) {
            if (eContainer() != null) {
                ResourceDefinition containingResource = ((Method) eContainer()).getContainingResourceDefinition();
                if (containingResource != null) {
                    setResourceType(containingResource);
                }
            }
        }
        return getResourceTypeGen();
    }
    


    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public ResourceDefinition basicGetResourceType() {
		return resourceType;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public void setResourceType(ResourceDefinition newResourceType) {
		ResourceDefinition oldResourceType = resourceType;
		resourceType = newResourceType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RapidmlPackage.TYPED_MESSAGE__RESOURCE_TYPE, oldResourceType, resourceType));
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public boolean isUseParentTypeReference() {
		return useParentTypeReference;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public void setUseParentTypeReference(boolean newUseParentTypeReference) {
		boolean oldUseParentTypeReference = useParentTypeReference;
		useParentTypeReference = newUseParentTypeReference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RapidmlPackage.TYPED_MESSAGE__USE_PARENT_TYPE_REFERENCE, oldUseParentTypeReference, useParentTypeReference));
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EList<MediaType> getMediaTypes() {
		if (mediaTypes == null) {
			mediaTypes = new EObjectResolvingEList<MediaType>(MediaType.class, this, RapidmlPackage.TYPED_MESSAGE__MEDIA_TYPES);
		}
		return mediaTypes;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public EList<Example> getAllExamples() {
		return com.reprezen.rapidml.util.ExampleUtils.getAllExamples(this);
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIncluded(final com.reprezen.rapidml.Feature feature) {
		return com.reprezen.rapidml.util.RapidmlModelUtils.isFeatureIncluded(this, feature);
	}

				/**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    @Override
    public EList<PropertyRealization> getIncludedProperties() {
        if (getProperties() == null) {
            return ECollections.emptyEList();
        }
        return getProperties().getAllIncludedProperties();
    }
    
    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public com.reprezen.rapidml.Structure getActualType() {
		Structure structure = getDataType();
		if (structure == null && getResourceType() instanceof com.reprezen.rapidml.ServiceDataResource) {
		    structure = ((com.reprezen.rapidml.ServiceDataResource) getResourceType()).getDataType();
		}
		return structure;
		
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public EList<ReferenceLink> getReferenceLinks() {
		Collection<ReferenceLink> referenceTreatments = com.google.common.collect.Lists.newArrayList(com.google.common.collect.Iterables.filter(getReferenceTreatments(), ReferenceLink.class));
		return new org.eclipse.emf.common.util.BasicEList<ReferenceLink>(referenceTreatments);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RapidmlPackage.TYPED_MESSAGE__PARAMETERS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getParameters()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RapidmlPackage.TYPED_MESSAGE__DOCUMENTATION:
				return basicSetDocumentation(null, msgs);
			case RapidmlPackage.TYPED_MESSAGE__EXAMPLES:
				return ((InternalEList<?>)getExamples()).basicRemove(otherEnd, msgs);
			case RapidmlPackage.TYPED_MESSAGE__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RapidmlPackage.TYPED_MESSAGE__DOCUMENTATION:
				return getDocumentation();
			case RapidmlPackage.TYPED_MESSAGE__EXAMPLES:
				return getExamples();
			case RapidmlPackage.TYPED_MESSAGE__PARAMETERS:
				return getParameters();
			case RapidmlPackage.TYPED_MESSAGE__RESOURCE_TYPE:
				if (resolve) return getResourceType();
				return basicGetResourceType();
			case RapidmlPackage.TYPED_MESSAGE__USE_PARENT_TYPE_REFERENCE:
				return isUseParentTypeReference();
			case RapidmlPackage.TYPED_MESSAGE__MEDIA_TYPES:
				return getMediaTypes();
		}
		return super.eGet(featureID, resolve, coreType);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case RapidmlPackage.TYPED_MESSAGE__DOCUMENTATION:
				setDocumentation((Documentation)newValue);
				return;
			case RapidmlPackage.TYPED_MESSAGE__EXAMPLES:
				getExamples().clear();
				getExamples().addAll((Collection<? extends Example>)newValue);
				return;
			case RapidmlPackage.TYPED_MESSAGE__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends MessageParameter>)newValue);
				return;
			case RapidmlPackage.TYPED_MESSAGE__RESOURCE_TYPE:
				setResourceType((ResourceDefinition)newValue);
				return;
			case RapidmlPackage.TYPED_MESSAGE__USE_PARENT_TYPE_REFERENCE:
				setUseParentTypeReference((Boolean)newValue);
				return;
			case RapidmlPackage.TYPED_MESSAGE__MEDIA_TYPES:
				getMediaTypes().clear();
				getMediaTypes().addAll((Collection<? extends MediaType>)newValue);
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
			case RapidmlPackage.TYPED_MESSAGE__DOCUMENTATION:
				setDocumentation((Documentation)null);
				return;
			case RapidmlPackage.TYPED_MESSAGE__EXAMPLES:
				getExamples().clear();
				return;
			case RapidmlPackage.TYPED_MESSAGE__PARAMETERS:
				getParameters().clear();
				return;
			case RapidmlPackage.TYPED_MESSAGE__RESOURCE_TYPE:
				setResourceType((ResourceDefinition)null);
				return;
			case RapidmlPackage.TYPED_MESSAGE__USE_PARENT_TYPE_REFERENCE:
				setUseParentTypeReference(USE_PARENT_TYPE_REFERENCE_EDEFAULT);
				return;
			case RapidmlPackage.TYPED_MESSAGE__MEDIA_TYPES:
				getMediaTypes().clear();
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
			case RapidmlPackage.TYPED_MESSAGE__DOCUMENTATION:
				return documentation != null;
			case RapidmlPackage.TYPED_MESSAGE__EXAMPLES:
				return examples != null && !examples.isEmpty();
			case RapidmlPackage.TYPED_MESSAGE__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case RapidmlPackage.TYPED_MESSAGE__RESOURCE_TYPE:
				return resourceType != null;
			case RapidmlPackage.TYPED_MESSAGE__USE_PARENT_TYPE_REFERENCE:
				return useParentTypeReference != USE_PARENT_TYPE_REFERENCE_EDEFAULT;
			case RapidmlPackage.TYPED_MESSAGE__MEDIA_TYPES:
				return mediaTypes != null && !mediaTypes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == Documentable.class) {
			switch (derivedFeatureID) {
				case RapidmlPackage.TYPED_MESSAGE__DOCUMENTATION: return RapidmlPackage.DOCUMENTABLE__DOCUMENTATION;
				default: return -1;
			}
		}
		if (baseClass == RESTElement.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == WithExamples.class) {
			switch (derivedFeatureID) {
				case RapidmlPackage.TYPED_MESSAGE__EXAMPLES: return RapidmlPackage.WITH_EXAMPLES__EXAMPLES;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == Documentable.class) {
			switch (baseFeatureID) {
				case RapidmlPackage.DOCUMENTABLE__DOCUMENTATION: return RapidmlPackage.TYPED_MESSAGE__DOCUMENTATION;
				default: return -1;
			}
		}
		if (baseClass == RESTElement.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == WithExamples.class) {
			switch (baseFeatureID) {
				case RapidmlPackage.WITH_EXAMPLES__EXAMPLES: return RapidmlPackage.TYPED_MESSAGE__EXAMPLES;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (useParentTypeReference: ");
		result.append(useParentTypeReference);
		result.append(')');
		return result.toString();
	}

} // TypedMessageImpl
