/** 
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 */
package com.reprezen.rapidml.xtext.scoping

import com.google.common.collect.Collections2
import com.google.common.collect.Iterables
import com.google.common.collect.Lists
import com.google.common.collect.Sets
import com.google.common.io.Resources
import com.google.inject.Guice
import com.google.inject.Injector
import com.reprezen.rapidml.AuthenticationMethod
import com.reprezen.rapidml.DataModel
import com.reprezen.rapidml.Enumeration
import com.reprezen.rapidml.Feature
import com.reprezen.rapidml.LinkRelation
import com.reprezen.rapidml.MediaType
import com.reprezen.rapidml.Method
import com.reprezen.rapidml.ObjectRealization
import com.reprezen.rapidml.PrimitiveProperty
import com.reprezen.rapidml.PrimitiveType
import com.reprezen.rapidml.PrimitiveTypeSourceReference
import com.reprezen.rapidml.PropertyRealization
import com.reprezen.rapidml.PropertyReference
import com.reprezen.rapidml.RealizationContainer
import com.reprezen.rapidml.ReferenceEmbed
import com.reprezen.rapidml.ReferenceLink
import com.reprezen.rapidml.ReferenceProperty
import com.reprezen.rapidml.ReferenceRealization
import com.reprezen.rapidml.ReferenceRealizationEnum
import com.reprezen.rapidml.ReferenceTreatment
import com.reprezen.rapidml.ResourceAPI
import com.reprezen.rapidml.ResourceDefinition
import com.reprezen.rapidml.ServiceDataResource
import com.reprezen.rapidml.Structure
import com.reprezen.rapidml.TemplateParameter
import com.reprezen.rapidml.TypedMessage
import com.reprezen.rapidml.ZenModel
import com.reprezen.rapidml.util.InheritanceUtils
import com.reprezen.rapidml.xtext.RapidMLRuntimeModule
import com.reprezen.rapidml.xtext.RapidMLStandaloneSetup
import com.reprezen.rapidml.xtext.libraries.util.PrimitiveTypes
import java.io.IOException
import java.util.Collection
import java.util.Collections
import java.util.List
import java.util.Set
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.scoping.IScope
import org.eclipse.xtext.scoping.Scopes
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider

import static com.google.common.collect.Iterables.filter
import static com.google.common.collect.Iterables.transform
import static com.reprezen.rapidml.util.RapidmlModelUtils.getContainingResourceDefinition
import static com.reprezen.rapidml.xtext.libraries.util.PrimitiveTypes.INT
import static com.reprezen.rapidml.xtext.libraries.util.PrimitiveTypes.STRING
import static com.reprezen.rapidml.xtext.loaders.ZenLibraries.IANA_LINK_RELATIONS
import static com.reprezen.rapidml.xtext.loaders.ZenLibraries.PRIMITIVE_TYPES
import static com.reprezen.rapidml.xtext.loaders.ZenLibraries.STANDARD_MEDIA_TYPES
import static org.eclipse.xtext.EcoreUtil2.getAllContentsOfType

/** 
 * This class contains custom scoping description.
 * @see: http://www.eclipse.org/Xtext/documentation/latest/xtext.html#scoping on how and when to use it
 * @author Tatiana Fesenko <tatiana.fesenko@modelsolv.com>
 */
class RapidMLScopeProvider extends AbstractDeclarativeScopeProvider {

	override IScope getScope(EObject context, EReference reference) {
		// Prevent editor hanging as in ZEN-3369
		try {
			return super.getScope(context, reference)
		} catch (Exception e) {
			// TODO
			e.printStackTrace()
		}

		return Scopes.scopeFor(Collections.<EObject>emptyList())
	}

	ZenModel primitiveTypesLibrary

	def package IScope scope_PrimitiveProperty_type(DataModel dataModel, EReference eRef) {
		// Add library to the scope
		var IScope outer = delegateGetScope(dataModel, eRef)
		var List<PrimitiveType> elementsFromLib = getPredefinedPrimitiveTypesTypes()
		return Scopes.scopeFor(elementsFromLib, outer)
	}

	def package IScope scope_UserDefinedType_baseType(DataModel dataModel, EReference eRef) {
		// Add library to the scope
		var IScope outer = delegateGetScope(dataModel, eRef)
		var List<PrimitiveType> elementsFromLib = getPredefinedPrimitiveTypesTypes()
		return Scopes.scopeFor(elementsFromLib, outer)
	}

	def package IScope scope_Enumeration_baseType(Enumeration enumeration, EReference eRef) {
		// Add library to the scope
		var Collection<PrimitiveType> elementsFromLib = getPredefinedPrimitiveTypesTypes()
		elementsFromLib = Collections2.filter(elementsFromLib, [ PrimitiveType primType |
			return PrimitiveTypes.isOneOf(primType.getName(), STRING, INT)
		])
		return Scopes.scopeFor(elementsFromLib)
	}

	def package IScope scope_PrimitiveTypeSourceReference_simpleType(PrimitiveTypeSourceReference primProperty,
		EReference eRef) {
		var List<PrimitiveType> elementsFromLib = getPredefinedSimpleTypes()
		return Scopes.scopeFor(elementsFromLib)
	}

	def private List<PrimitiveType> getPredefinedSimpleTypes() {
		var ZenModel library = getSimpleTypeLibraryModel()
		var List<PrimitiveType> elementsFromLib = getAllContentsOfType(library, PrimitiveType)
		return elementsFromLib
	}

	def private List<PrimitiveType> getPredefinedPrimitiveTypesTypes() {
		var ZenModel library = getSimpleTypeLibraryModel()
		var List<PrimitiveType> elementsFromLib = getAllContentsOfType(library, PrimitiveType)
		return elementsFromLib
	}

	def package IScope scope_ResourceDefinition_mediaTypes(ResourceAPI resourceAPI, EReference eRef) {
		var IScope outer = delegateGetScope(resourceAPI, eRef)
		// Add library to the scope
		try {
			var ZenModel library = getStandardMediaTypesModel()
			var List<MediaType> elementsFromLib = getAllContentsOfType(library, MediaType)
			return Scopes.scopeFor(elementsFromLib, outer)
		} catch (Exception e) {
			// TODO
			e.printStackTrace()
		}

		return outer
	}

	def package IScope scope_TypedMessage_mediaTypes(TypedMessage message, EReference eRef) {
		var IScope outer = delegateGetScope(message, eRef)
		// Add library to the scope
		try {
			var ZenModel library = getStandardMediaTypesModel()
			var List<MediaType> elementsFromLib = getAllContentsOfType(library, MediaType)
			return Scopes.scopeFor(elementsFromLib, outer)
		} catch (Exception e) {
			// TODO
			e.printStackTrace()
		}

		return outer
	}

	def package IScope scope_ReferenceLink_linkRelation(ReferenceLink referenceLink, EReference eRef) {
		var IScope outer = delegateGetScope(referenceLink, eRef)
		// Add library to the scope
		try {
			var ZenModel library = getIanaLinkRelationsModel()
			var List<LinkRelation> elementsFromLib = getAllContentsOfType(library, LinkRelation)
			return Scopes.scopeFor(elementsFromLib, outer)
		} catch (Exception e) {
			// TODO
			e.printStackTrace()
		}

		return outer
	}

	def package IScope scope_PropertyReference_conceptualFeature(PropertyReference propertyReference, EReference eRef) {
		var ResourceDefinition resource = getContainingResourceDefinition(propertyReference)
		if (resource instanceof ServiceDataResource) {
			return getScopeForDataResource((resource as ServiceDataResource))
		}
		return Scopes.scopeFor(Collections.<EObject>emptyList())
	}

	/** 
	 * This scope is used for template proposals reference variables lookup.
	 */
	def package IScope scope_PropertyReference_conceptualFeature(com.reprezen.rapidml.URI uri, EReference eRef) {
		if (uri.eContainer() instanceof ServiceDataResource) {
			return getScopeForDataResource((uri.eContainer() as ServiceDataResource))
		}
		return Scopes.scopeFor(Collections.<EObject>emptyList())
	}

	/** 
	 * This scope is used for template proposals reference variables lookup.
	 */
	def package IScope scope_PropertyReference_conceptualFeature(Method method, EReference eRef) {
		var ResourceDefinition resource = method.getContainingResourceDefinition()
		if (resource instanceof ServiceDataResource) {
			return getScopeForDataResource((resource as ServiceDataResource))
		}
		return Scopes.scopeFor(Collections.<EObject>emptyList())
	}

	def package IScope scope_ReferenceTreatment_referenceElement(ReferenceTreatment referenceTreatment,
		EReference eRef) {
		var EObject econtainer = referenceTreatment.eContainer()
		var Structure contextDataType /* FIXME empty initializer for final variable is not supported */
		if (econtainer instanceof ReferenceEmbed) {
			contextDataType = ((econtainer as ReferenceEmbed)).getReferenceElement().getDataType()
		} else if (econtainer instanceof ReferenceRealization) {
			contextDataType = ((((econtainer as ReferenceRealization)).eContainer() as ReferenceTreatment)).
				getReferenceElement().getDataType()
		} else if (econtainer instanceof TypedMessage) {
			contextDataType = ((econtainer as TypedMessage)).getActualType()
		} else {
			contextDataType = ((econtainer as RealizationContainer)).getDataType()
		}
		var Iterable<ReferenceProperty> result = Iterables.filter(getAllFeatures(contextDataType), ReferenceProperty)
		if (referenceTreatment instanceof ReferenceLink) { // leave only containment references, containment reference might
			// not be supported in WADL/XSD generator
			// result = filter(result, isContainmentReferenceProperty());
		}
		return Scopes.scopeFor(result)
	}

	def package IScope scope_URIParameter_uriSegment(TemplateParameter templateParameter, EReference eRef) {
		var IScope outer = delegateGetScope(templateParameter, eRef)
		var Iterable<? extends EObject> transformedElements = transform(
			outer.getAllElements(), [ IEObjectDescription input |
				return input.getEObjectOrProxy()
			])
		var Iterable<? extends EObject> filteredElements = filter(transformedElements, [ EObject input |
			return templateParameter.getContainingURI().equals(input.eContainer())
		])
		return Scopes.scopeFor(filteredElements)
	}

	def package IScope scope_AuthenticationMethod_scopes(AuthenticationMethod method, EReference eRef) {
		return Scopes.scopeFor(method.getScheme().getScopes())
	}

	def package IScope scope_IncludedProperty_baseProperty(ObjectRealization includedProperties, EReference eRef) {
		return getTypeFeatureScope(includedProperties.getDataType())
	}

	def package IScope scope_IncludedProperty_baseProperty(ServiceDataResource resourceDefinition, EReference eRef) {
		return getTypeFeatureScope(resourceDefinition.getDataType())
	}

	def package IScope scope_ObjectRealization_excludedProperties(ObjectRealization includedProperties,
		EReference eRef) {
		return getTypeFeatureScope(includedProperties.getDataType())
	}

	def package IScope scope_ObjectRealization_overriddenPropertyList(ObjectRealization includedProperties,
		EReference eRef) {
		return getTypeFeatureScope(includedProperties.getDataType())
	}

	def package IScope scope_ObjectRealization_exclusivePropertyList(TypedMessage includedProperties, EReference eRef) {
		return getTypeFeatureScope(includedProperties.getDataType())
	}

	def package IScope scope_ObjectRealization_exclusivePropertyList(ReferenceRealization referenceRealization,
		EReference eRef) {
		var Structure type = referenceRealization.getDataType()
		if (type !== null) {
			var Collection<? extends EObject> result = getAllFeatures(type)
			if (referenceRealization.getRealizationType() === ReferenceRealizationEnum.LINK) {
				result = Lists.newArrayList(Iterables.filter(result, PrimitiveProperty))
			}
			return Scopes.scopeFor(result)
		}
		return null
	}

	def package IScope scope_ObjectRealization_excludedProperties(ServiceDataResource resourceDefinition,
		EReference eRef) {
		return getTypeFeatureScope(resourceDefinition.getDataType())
	}

	def package IScope scope_ObjectRealization_overriddenPropertyList(ServiceDataResource resourceDefinition,
		EReference eRef) {
		return getTypeFeatureScope(resourceDefinition.getDataType())
	}

	def package IScope scope_ObjectRealization_exclusivePropertyList(ServiceDataResource resourceDefinition,
		EReference eRef) {
		return getTypeFeatureScope(resourceDefinition.getDataType())
	}

	def package IScope scope_PropertyRealization_baseProperty(PropertyRealization includedProperty, EReference eRef) {
		var ObjectRealization includedProperties = (includedProperty.eContainer() as ObjectRealization)
		return getTypeFeatureScope(includedProperties.getDataType())
	}

	def package IScope scope_ReferenceProperty_inverse(ReferenceProperty referenceProperty, EReference eRef) {
		val Structure containerType = referenceProperty.getContainingDataType()
		var Structure referencedType = referenceProperty.getType()
		if (referencedType !== null) {
			var Iterable<ReferenceProperty> result = referencedType.getReferenceProperties()
			result = Iterables.filter(result, [ ReferenceProperty inverseReference |
				return (inverseReference !== referenceProperty) && (inverseReference.getType() === containerType)
			])
			return Scopes.scopeFor(result)
		}
		return null
	}

// IScope scope_LinkDescriptor_includedFeatures(ObjectRealization linkDescriptor, EReference eRef) {
// if (linkDescriptor.eContainer() instanceof ReferenceTreatment) {
// return scope_LinkDescriptor_includedFeatures((ReferenceTreatment) linkDescriptor.eContainer(), eRef);
// } else if (linkDescriptor.eContainer() instanceof ServiceDataResource) {
// return scope_LinkDescriptor_includedFeatures((ServiceDataResource) linkDescriptor.eContainer(), eRef);
// }
// return null;
// }
//
// /** scope for template content assist */
// IScope scope_LinkDescriptor_includedFeatures(ServiceDataResource resource, EReference eRef) {
// Structure type = resource.getDataType();
// if (type != null) {
// return getTypeFeatureScope(type);
// }
// return null;
// }
//
// IScope scope_LinkDescriptor_includedFeatures(ReferenceTreatment referenceTreatment, EReference eRef) {
// // anonymous link descriptor
// Structure type = referenceTreatment.getReferenceElement().getDataType();
// if (type != null) {
// Collection<? extends EObject> result = getAllFeatures(type);
// if (referenceTreatment instanceof ReferenceLink) {
// result = Lists.newArrayList(Iterables.filter(result, PrimitiveProperty.class));
// }
// return Scopes.scopeFor(result);
// }
// return null;
// }
	def private IScope getTypeFeatureScope(Structure type) {
		return Scopes.scopeFor(getAllFeatures(type))
	}

	def private Collection<Feature> getAllFeatures(Structure type) {
		var Collection<Feature> result = Sets.newLinkedHashSet()
		if (type !== null) {
			result.addAll(getAllContentsOfType(type, Feature))
			result.addAll(InheritanceUtils.getInheritedFeatures(type))
		}
		return result
	}

	def private ZenModel getSimpleTypeLibraryModel() {
		if (primitiveTypesLibrary === null) {
			primitiveTypesLibrary = getLibraryModel(PRIMITIVE_TYPES)
		}
		return primitiveTypesLibrary
	}

	def private ZenModel getStandardMediaTypesModel() {
		return getLibraryModel(STANDARD_MEDIA_TYPES)
	}

	def private ZenModel getIanaLinkRelationsModel() {
		return getLibraryModel(IANA_LINK_RELATIONS)
	}

	def private ZenModel getLibraryModel(URI modelURI) {
		// TODO can we make this work when we're really in a platform scenario?
		// if (Platform.isRunning()) {
		// var IWorkspaceRoot eclipseWorkspace = ResourcesPlugin.getWorkspace().getRoot()
		// var Workspace workspace = new EmfWorkspace(eclipseWorkspace)
		// var RestModelLoader loader = new DslRestModelLoader(workspace)
		// return loader.load(modelURI)
		// } else {
		// workaround to load libraries in headless generation mode
		new RapidMLStandaloneSetup().createInjectorAndDoEMFRegistration()
		var Injector injector = Guice.createInjector(new RapidMLRuntimeModule())
		var XtextResourceSet resourceSet = injector.getInstance(XtextResourceSet)
		resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE)
		var Resource resource = resourceSet.createResource(modelURI)
		try {
			val stream = Resources.getResource(RapidMLScopeProvider, '''libraries/«modelURI.lastSegment()»''').
				openStream()
			resource.load(stream, null)

		} catch (IOException e) {
			throw new RuntimeException(e)
		}

		return (resource.getContents().get(0) as ZenModel)
	// }
	}

	def private IScope getScopeForDataResource(ServiceDataResource dataResource) {
		var Set<PrimitiveProperty> result = Sets.newLinkedHashSet()
		if (dataResource !== null && dataResource.getDataType() !== null) {
			var Structure structure = dataResource.getDataType()
			result.addAll(getAllContentsOfType(structure, PrimitiveProperty))
			result.addAll(getInheritedPrimitiveProperties(structure))
		}
		return Scopes.scopeFor(result)
	}

	def private Collection<PrimitiveProperty> getInheritedPrimitiveProperties(Structure structure) {
		return Lists.newArrayList(Iterables.filter(InheritanceUtils.getInheritedFeatures(structure), PrimitiveProperty))
	}
}
