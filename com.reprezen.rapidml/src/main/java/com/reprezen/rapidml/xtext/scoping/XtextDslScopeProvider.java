/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.xtext.scoping;

import static com.google.common.collect.Iterables.filter;
import static com.google.common.collect.Iterables.transform;
import static com.reprezen.rapidml.util.PrimitiveTypes.INT;
import static com.reprezen.rapidml.util.PrimitiveTypes.STRING;
import static com.reprezen.rapidml.util.RapidmlModelUtils.getContainingResourceDefinition;
import static com.reprezen.rapidml.xtext.loaders.ZenLibraries.IANA_LINK_RELATIONS;
import static com.reprezen.rapidml.xtext.loaders.ZenLibraries.PRIMITIVE_TYPES;
import static com.reprezen.rapidml.xtext.loaders.ZenLibraries.STANDARD_MEDIA_TYPES;
import static org.eclipse.xtext.EcoreUtil2.getAllContentsOfType;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.common.io.Resources;
import com.google.inject.Inject;
import com.reprezen.rapidml.AuthenticationMethod;
import com.reprezen.rapidml.DataModel;
import com.reprezen.rapidml.Enumeration;
import com.reprezen.rapidml.Feature;
import com.reprezen.rapidml.LinkRelation;
import com.reprezen.rapidml.MediaType;
import com.reprezen.rapidml.Method;
import com.reprezen.rapidml.ObjectRealization;
import com.reprezen.rapidml.PrimitiveProperty;
import com.reprezen.rapidml.PrimitiveType;
import com.reprezen.rapidml.PrimitiveTypeSourceReference;
import com.reprezen.rapidml.PropertyRealization;
import com.reprezen.rapidml.PropertyReference;
import com.reprezen.rapidml.RealizationContainer;
import com.reprezen.rapidml.ReferenceEmbed;
import com.reprezen.rapidml.ReferenceLink;
import com.reprezen.rapidml.ReferenceProperty;
import com.reprezen.rapidml.ReferenceRealization;
import com.reprezen.rapidml.ReferenceRealizationEnum;
import com.reprezen.rapidml.ReferenceTreatment;
import com.reprezen.rapidml.ResourceAPI;
import com.reprezen.rapidml.ResourceDefinition;
import com.reprezen.rapidml.ServiceDataResource;
import com.reprezen.rapidml.Structure;
import com.reprezen.rapidml.TemplateParameter;
import com.reprezen.rapidml.TypedMessage;
import com.reprezen.rapidml.ZenModel;
import com.reprezen.rapidml.util.InheritanceUtils;
import com.reprezen.rapidml.util.PrimitiveTypes;
import com.reprezen.rapidml.xtext.RestApiXtextPlugin;

/**
 * This class contains custom scoping description.
 * 
 * @see: http://www.eclipse.org/Xtext/documentation/latest/xtext.html#scoping on
 *       how and when to use it
 * @author Tatiana Fesenko <tatiana.fesenko@modelsolv.com>
 */
public class XtextDslScopeProvider extends AbstractDeclarativeScopeProvider {

	@Inject
	private ResourceSet resourceSet;

	private ZenModel primitiveTypesLibrary;

	@Override
	public IScope getScope(EObject context, EReference reference) {
		// Prevent editor hanging as in ZEN-3369
		try {
			return super.getScope(context, reference);
		} catch (Exception e) {
			RestApiXtextPlugin.log(e);
		}
		return Scopes.scopeFor(Collections.<EObject>emptyList());
	}

	IScope scope_PrimitiveProperty_type(DataModel dataModel, EReference eRef) {
		// Add library to the scope
		IScope outer = delegateGetScope(dataModel, eRef);
		List<PrimitiveType> elementsFromLib = getPredefinedPrimitiveTypesTypes();
		return Scopes.scopeFor(elementsFromLib, outer);
	}

	IScope scope_UserDefinedType_baseType(DataModel dataModel, EReference eRef) {
		// Add library to the scope
		IScope outer = delegateGetScope(dataModel, eRef);
		List<PrimitiveType> elementsFromLib = getPredefinedPrimitiveTypesTypes();
		return Scopes.scopeFor(elementsFromLib, outer);
	}

	IScope scope_Enumeration_baseType(Enumeration enumeration, EReference eRef) {
		// Add library to the scope
		Collection<PrimitiveType> elementsFromLib = getPredefinedPrimitiveTypesTypes();
		elementsFromLib = Collections2.filter(elementsFromLib, new Predicate<PrimitiveType>() {

			@Override
			public boolean apply(PrimitiveType primType) {
				return PrimitiveTypes.isOneOf(primType.getName(), STRING, INT);
			}
		});
		return Scopes.scopeFor(elementsFromLib);
	}

	IScope scope_PrimitiveTypeSourceReference_simpleType(PrimitiveTypeSourceReference primProperty, EReference eRef) {
		List<PrimitiveType> elementsFromLib = getPredefinedSimpleTypes();
		return Scopes.scopeFor(elementsFromLib);
	}

	private List<PrimitiveType> getPredefinedSimpleTypes() {
		ZenModel library = getSimpleTypeLibraryModel();
		List<PrimitiveType> elementsFromLib = getAllContentsOfType(library, PrimitiveType.class);
		return elementsFromLib;
	}

	private List<PrimitiveType> getPredefinedPrimitiveTypesTypes() {
		ZenModel library = getSimpleTypeLibraryModel();
		List<PrimitiveType> elementsFromLib = getAllContentsOfType(library, PrimitiveType.class);
		return elementsFromLib;
	}

	IScope scope_ResourceDefinition_mediaTypes(ResourceAPI resourceAPI, EReference eRef) {
		IScope outer = delegateGetScope(resourceAPI, eRef);
		// Add library to the scope
		try {
			ZenModel library = getStandardMediaTypesModel();
			List<MediaType> elementsFromLib = getAllContentsOfType(library, MediaType.class);
			return Scopes.scopeFor(elementsFromLib, outer);
		} catch (Exception e) {
			RestApiXtextPlugin.log(e);
		}
		return outer;
	}

	IScope scope_TypedMessage_mediaTypes(TypedMessage message, EReference eRef) {
		IScope outer = delegateGetScope(message, eRef);
		// Add library to the scope
		try {
			ZenModel library = getStandardMediaTypesModel();
			List<MediaType> elementsFromLib = getAllContentsOfType(library, MediaType.class);
			return Scopes.scopeFor(elementsFromLib, outer);
		} catch (Exception e) {
			RestApiXtextPlugin.log(e);
		}
		return outer;
	}

	IScope scope_ReferenceLink_linkRelation(ReferenceLink referenceLink, EReference eRef) {
		IScope outer = delegateGetScope(referenceLink, eRef);
		// Add library to the scope
		try {
			ZenModel library = getIanaLinkRelationsModel();
			List<LinkRelation> elementsFromLib = getAllContentsOfType(library, LinkRelation.class);
			return Scopes.scopeFor(elementsFromLib, outer);
		} catch (Exception e) {
			RestApiXtextPlugin.log(e);
		}
		return outer;
	}

	IScope scope_PropertyReference_conceptualFeature(PropertyReference propertyReference, EReference eRef) {
		ResourceDefinition resource = getContainingResourceDefinition(propertyReference);
		if (resource instanceof ServiceDataResource) {
			return getScopeForDataResource((ServiceDataResource) resource);
		}
		return Scopes.scopeFor(Collections.<EObject>emptyList());
	}

	/**
	 * This scope is used for template proposals reference variables lookup.
	 */
	IScope scope_PropertyReference_conceptualFeature(final com.reprezen.rapidml.URI uri, EReference eRef) {
		if (uri.eContainer() instanceof ServiceDataResource) {
			return getScopeForDataResource((ServiceDataResource) uri.eContainer());
		}
		return Scopes.scopeFor(Collections.<EObject>emptyList());
	}

	/**
	 * This scope is used for template proposals reference variables lookup.
	 */
	IScope scope_PropertyReference_conceptualFeature(Method method, EReference eRef) {
		ResourceDefinition resource = method.getContainingResourceDefinition();
		if (resource instanceof ServiceDataResource) {
			return getScopeForDataResource((ServiceDataResource) resource);
		}
		return Scopes.scopeFor(Collections.<EObject>emptyList());
	}

	IScope scope_ReferenceTreatment_referenceElement(ReferenceTreatment referenceTreatment, EReference eRef) {
		EObject econtainer = referenceTreatment.eContainer();
		final Structure contextDataType;
		if (econtainer instanceof ReferenceEmbed) {
			contextDataType = ((ReferenceEmbed) econtainer).getReferenceElement().getDataType();
		} else if (econtainer instanceof ReferenceRealization) {
			contextDataType = ((ReferenceTreatment) ((ReferenceRealization) econtainer).eContainer())
					.getReferenceElement().getDataType();
		} else if (econtainer instanceof TypedMessage) {
			contextDataType = ((TypedMessage) econtainer).getActualType();
		} else {
			contextDataType = ((RealizationContainer) econtainer).getDataType();
		}

		Iterable<ReferenceProperty> result = Iterables.filter(getAllFeatures(contextDataType), ReferenceProperty.class);
		if (referenceTreatment instanceof ReferenceLink) {
			// leave only containment references, containment reference might
			// not be supported in WADL/XSD generator
			// result = filter(result, isContainmentReferenceProperty());
		}
		return Scopes.scopeFor(result);
	}

	IScope scope_URIParameter_uriSegment(final TemplateParameter templateParameter, EReference eRef) {
		IScope outer = delegateGetScope(templateParameter, eRef);

		Iterable<? extends EObject> transformedElements = transform(outer.getAllElements(),
				new Function<IEObjectDescription, EObject>() {
					@Override
					public EObject apply(IEObjectDescription input) {
						return input.getEObjectOrProxy();
					}
				});

		Iterable<? extends EObject> filteredElements = filter(transformedElements, new Predicate<EObject>() {
			@Override
			public boolean apply(EObject input) {
				return templateParameter.getContainingURI().equals(input.eContainer());
			}
		});

		return Scopes.scopeFor(filteredElements);
	}

	IScope scope_AuthenticationMethod_scopes(AuthenticationMethod method, EReference eRef) {
		return Scopes.scopeFor(method.getScheme().getScopes());
	}

	IScope scope_IncludedProperty_baseProperty(ObjectRealization includedProperties, EReference eRef) {
		return getTypeFeatureScope(includedProperties.getDataType());
	}

	IScope scope_IncludedProperty_baseProperty(ServiceDataResource resourceDefinition, EReference eRef) {
		return getTypeFeatureScope(resourceDefinition.getDataType());
	}

	IScope scope_ObjectRealization_excludedProperties(ObjectRealization includedProperties, EReference eRef) {
		return getTypeFeatureScope(includedProperties.getDataType());
	}

	IScope scope_ObjectRealization_overriddenPropertyList(ObjectRealization includedProperties, EReference eRef) {
		return getTypeFeatureScope(includedProperties.getDataType());
	}

	IScope scope_ObjectRealization_exclusivePropertyList(TypedMessage includedProperties, EReference eRef) {
		return getTypeFeatureScope(includedProperties.getDataType());
	}

	IScope scope_ObjectRealization_exclusivePropertyList(ReferenceRealization referenceRealization, EReference eRef) {
		Structure type = referenceRealization.getDataType();
		if (type != null) {
			Collection<? extends EObject> result = getAllFeatures(type);
			if (referenceRealization.getRealizationType() == ReferenceRealizationEnum.LINK) {
				result = Lists.newArrayList(Iterables.filter(result, PrimitiveProperty.class));
			}
			return Scopes.scopeFor(result);
		}
		return null;
	}

	IScope scope_ObjectRealization_excludedProperties(ServiceDataResource resourceDefinition, EReference eRef) {
		return getTypeFeatureScope(resourceDefinition.getDataType());
	}

	IScope scope_ObjectRealization_overriddenPropertyList(ServiceDataResource resourceDefinition, EReference eRef) {
		return getTypeFeatureScope(resourceDefinition.getDataType());
	}

	IScope scope_ObjectRealization_exclusivePropertyList(ServiceDataResource resourceDefinition, EReference eRef) {
		return getTypeFeatureScope(resourceDefinition.getDataType());
	}

	IScope scope_PropertyRealization_baseProperty(PropertyRealization includedProperty, EReference eRef) {
		ObjectRealization includedProperties = (ObjectRealization) includedProperty.eContainer();
		return getTypeFeatureScope(includedProperties.getDataType());
	}

	IScope scope_ReferenceProperty_inverse(final ReferenceProperty referenceProperty, EReference eRef) {
		final Structure containerType = referenceProperty.getContainingDataType();
		Structure referencedType = referenceProperty.getType();
		if (referencedType != null) {
			Iterable<ReferenceProperty> result = referencedType.getReferenceProperties();
			result = Iterables.filter(result, new Predicate<ReferenceProperty>() {

				@Override
				public boolean apply(ReferenceProperty inverseReference) {
					return (inverseReference != referenceProperty) && (inverseReference.getType() == containerType);
				}
			});
			return Scopes.scopeFor(result);
		}
		return null;
	}

	// IScope scope_LinkDescriptor_includedFeatures(ObjectRealization
	// linkDescriptor, EReference eRef) {
	// if (linkDescriptor.eContainer() instanceof ReferenceTreatment) {
	// return scope_LinkDescriptor_includedFeatures((ReferenceTreatment)
	// linkDescriptor.eContainer(), eRef);
	// } else if (linkDescriptor.eContainer() instanceof ServiceDataResource) {
	// return scope_LinkDescriptor_includedFeatures((ServiceDataResource)
	// linkDescriptor.eContainer(), eRef);
	// }
	// return null;
	// }
	//
	// /** scope for template content assist */
	// IScope scope_LinkDescriptor_includedFeatures(ServiceDataResource resource,
	// EReference eRef) {
	// Structure type = resource.getDataType();
	// if (type != null) {
	// return getTypeFeatureScope(type);
	// }
	// return null;
	// }
	//
	// IScope scope_LinkDescriptor_includedFeatures(ReferenceTreatment
	// referenceTreatment, EReference eRef) {
	// // anonymous link descriptor
	// Structure type = referenceTreatment.getReferenceElement().getDataType();
	// if (type != null) {
	// Collection<? extends EObject> result = getAllFeatures(type);
	// if (referenceTreatment instanceof ReferenceLink) {
	// result = Lists.newArrayList(Iterables.filter(result,
	// PrimitiveProperty.class));
	// }
	// return Scopes.scopeFor(result);
	// }
	// return null;
	// }

	private IScope getTypeFeatureScope(Structure type) {
		return Scopes.scopeFor(getAllFeatures(type));
	}

	private Collection<Feature> getAllFeatures(Structure type) {
		Collection<Feature> result = Sets.newLinkedHashSet();
		if (type != null) {
			result.addAll(getAllContentsOfType(type, Feature.class));
			result.addAll(InheritanceUtils.getInheritedFeatures(type));
		}
		return result;
	}

	private ZenModel getSimpleTypeLibraryModel() {
		if (primitiveTypesLibrary == null) {
			primitiveTypesLibrary = getLibraryModel(PRIMITIVE_TYPES);
		}
		return primitiveTypesLibrary;
	}

	private ZenModel getStandardMediaTypesModel() {
		return getLibraryModel(STANDARD_MEDIA_TYPES);
	}

	private ZenModel getIanaLinkRelationsModel() {
		return getLibraryModel(IANA_LINK_RELATIONS);
	}

	private ZenModel getLibraryModel(URI modelURI) {
		Resource resource = resourceSet.getResource(modelURI, false);
		if (resource == null) {
			resource = resourceSet.createResource(modelURI);
		}
		if (resource.getContents().isEmpty()) {
			URL url = Resources.getResource(XtextDslScopeProvider.class, "libraries/" + modelURI.lastSegment());
			try (InputStream stream = url.openStream()) {
				resource.load(stream, null);
			} catch (IllegalArgumentException | IOException e) {
				throw new RuntimeException(e);
			}
		}
		return (ZenModel) resource.getContents().get(0);
	}

	private IScope getScopeForDataResource(ServiceDataResource dataResource) {
		Set<PrimitiveProperty> result = Sets.newLinkedHashSet();
		if (dataResource != null && dataResource.getDataType() != null) {
			Structure structure = dataResource.getDataType();
			result.addAll(getAllContentsOfType(structure, PrimitiveProperty.class));
			result.addAll(getInheritedPrimitiveProperties(structure));
		}
		return Scopes.scopeFor(result);
	}

	private Collection<PrimitiveProperty> getInheritedPrimitiveProperties(Structure structure) {
		return Lists.newArrayList(
				Iterables.filter(InheritanceUtils.getInheritedFeatures(structure), PrimitiveProperty.class));
	}

}