/**
 * Copyright © 2013-2016 Modelsolv, Inc.
 * All Rights Reserved.
 * 
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 */
package com.modelsolv.reprezen.rapidml.util;

import com.modelsolv.reprezen.rapidml.*;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;

import com.modelsolv.reprezen.rapidml.AuthenticationMethod;
import com.modelsolv.reprezen.rapidml.CollectionParameter;
import com.modelsolv.reprezen.rapidml.CollectionReferenceElement;
import com.modelsolv.reprezen.rapidml.CollectionResource;
import com.modelsolv.reprezen.rapidml.Documentable;
import com.modelsolv.reprezen.rapidml.Documentation;
import com.modelsolv.reprezen.rapidml.Example;
import com.modelsolv.reprezen.rapidml.Extensible;
import com.modelsolv.reprezen.rapidml.Extension;
import com.modelsolv.reprezen.rapidml.ExternalExample;
import com.modelsolv.reprezen.rapidml.HasSecurityValue;
import com.modelsolv.reprezen.rapidml.HasStringValue;
import com.modelsolv.reprezen.rapidml.ImportDeclaration;
import com.modelsolv.reprezen.rapidml.InlineExample;
import com.modelsolv.reprezen.rapidml.LinkRelation;
import com.modelsolv.reprezen.rapidml.MatrixParameter;
import com.modelsolv.reprezen.rapidml.MediaType;
import com.modelsolv.reprezen.rapidml.MessageParameter;
import com.modelsolv.reprezen.rapidml.Method;
import com.modelsolv.reprezen.rapidml.NamedLinkDescriptor;
import com.modelsolv.reprezen.rapidml.ObjectRealization;
import com.modelsolv.reprezen.rapidml.ObjectResource;
import com.modelsolv.reprezen.rapidml.Parameter;
import com.modelsolv.reprezen.rapidml.PathSegment;
import com.modelsolv.reprezen.rapidml.PrimitiveTypeSourceReference;
import com.modelsolv.reprezen.rapidml.PropertyRealization;
import com.modelsolv.reprezen.rapidml.PropertyReference;
import com.modelsolv.reprezen.rapidml.RESTElement;
import com.modelsolv.reprezen.rapidml.RealizationContainer;
import com.modelsolv.reprezen.rapidml.ReferenceEmbed;
import com.modelsolv.reprezen.rapidml.ReferenceLink;
import com.modelsolv.reprezen.rapidml.ReferenceRealization;
import com.modelsolv.reprezen.rapidml.ReferenceTreatment;
import com.modelsolv.reprezen.rapidml.ResourceAPI;
import com.modelsolv.reprezen.rapidml.ResourceDefinition;
import com.modelsolv.reprezen.rapidml.RapidmlPackage;
import com.modelsolv.reprezen.rapidml.SecurityScheme;
import com.modelsolv.reprezen.rapidml.SecuritySchemeLibrary;
import com.modelsolv.reprezen.rapidml.SecuritySchemeParameter;
import com.modelsolv.reprezen.rapidml.SecurityScope;
import com.modelsolv.reprezen.rapidml.ServiceDataResource;
import com.modelsolv.reprezen.rapidml.SourceReference;
import com.modelsolv.reprezen.rapidml.TemplateParameter;
import com.modelsolv.reprezen.rapidml.TypedMessage;
import com.modelsolv.reprezen.rapidml.TypedRequest;
import com.modelsolv.reprezen.rapidml.TypedResponse;
import com.modelsolv.reprezen.rapidml.URI;
import com.modelsolv.reprezen.rapidml.URIParameter;
import com.modelsolv.reprezen.rapidml.URISegment;
import com.modelsolv.reprezen.rapidml.URISegmentWithParameter;
import com.modelsolv.reprezen.rapidml.WithExamples;
import com.modelsolv.reprezen.rapidml.ZenModel;
import com.modelsolv.reprezen.rapidml.ConstrainableType;
import com.modelsolv.reprezen.rapidml.Element;
import com.modelsolv.reprezen.rapidml.ReferenceElement;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see com.modelsolv.reprezen.rapidml.RapidmlPackage
 * @generated
 */
public class RapidmlSwitch<T> extends Switch<T> {
    /**
	 * The cached model package
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected static RapidmlPackage modelPackage;

    /**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public RapidmlSwitch() {
		if (modelPackage == null) {
			modelPackage = RapidmlPackage.eINSTANCE;
		}
	}

    /**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
    @Override
    protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

    /**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
    @Override
    protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case RapidmlPackage.RESOURCE_DEFINITION: {
				ResourceDefinition resourceDefinition = (ResourceDefinition)theEObject;
				T result = caseResourceDefinition(resourceDefinition);
				if (result == null) result = caseRESTElement(resourceDefinition);
				if (result == null) result = caseWithExamples(resourceDefinition);
				if (result == null) result = caseHasSecurityValue(resourceDefinition);
				if (result == null) result = caseDocumentable(resourceDefinition);
				if (result == null) result = caseExtensible(resourceDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapidmlPackage.TYPED_MESSAGE: {
				TypedMessage typedMessage = (TypedMessage)theEObject;
				T result = caseTypedMessage(typedMessage);
				if (result == null) result = caseRealizationContainer(typedMessage);
				if (result == null) result = caseRESTElement(typedMessage);
				if (result == null) result = caseWithExamples(typedMessage);
				if (result == null) result = caseExtensible(typedMessage);
				if (result == null) result = caseDocumentable(typedMessage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapidmlPackage.METHOD: {
				Method method = (Method)theEObject;
				T result = caseMethod(method);
				if (result == null) result = caseRESTElement(method);
				if (result == null) result = caseHasSecurityValue(method);
				if (result == null) result = caseDocumentable(method);
				if (result == null) result = caseExtensible(method);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapidmlPackage.PARAMETER: {
				Parameter parameter = (Parameter)theEObject;
				T result = caseParameter(parameter);
				if (result == null) result = caseRESTElement(parameter);
				if (result == null) result = caseDocumentable(parameter);
				if (result == null) result = caseExtensible(parameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapidmlPackage.REST_ELEMENT: {
				RESTElement restElement = (RESTElement)theEObject;
				T result = caseRESTElement(restElement);
				if (result == null) result = caseDocumentable(restElement);
				if (result == null) result = caseExtensible(restElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapidmlPackage.DOCUMENTATION: {
				Documentation documentation = (Documentation)theEObject;
				T result = caseDocumentation(documentation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapidmlPackage.DOCUMENTABLE: {
				Documentable documentable = (Documentable)theEObject;
				T result = caseDocumentable(documentable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapidmlPackage.MEDIA_TYPE: {
				MediaType mediaType = (MediaType)theEObject;
				T result = caseMediaType(mediaType);
				if (result == null) result = caseRESTElement(mediaType);
				if (result == null) result = caseDocumentable(mediaType);
				if (result == null) result = caseExtensible(mediaType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapidmlPackage.TYPED_REQUEST: {
				TypedRequest typedRequest = (TypedRequest)theEObject;
				T result = caseTypedRequest(typedRequest);
				if (result == null) result = caseTypedMessage(typedRequest);
				if (result == null) result = caseRealizationContainer(typedRequest);
				if (result == null) result = caseRESTElement(typedRequest);
				if (result == null) result = caseWithExamples(typedRequest);
				if (result == null) result = caseExtensible(typedRequest);
				if (result == null) result = caseDocumentable(typedRequest);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapidmlPackage.TYPED_RESPONSE: {
				TypedResponse typedResponse = (TypedResponse)theEObject;
				T result = caseTypedResponse(typedResponse);
				if (result == null) result = caseTypedMessage(typedResponse);
				if (result == null) result = caseRealizationContainer(typedResponse);
				if (result == null) result = caseRESTElement(typedResponse);
				if (result == null) result = caseWithExamples(typedResponse);
				if (result == null) result = caseExtensible(typedResponse);
				if (result == null) result = caseDocumentable(typedResponse);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapidmlPackage.URI_PARAMETER: {
				URIParameter uriParameter = (URIParameter)theEObject;
				T result = caseURIParameter(uriParameter);
				if (result == null) result = caseParameter(uriParameter);
				if (result == null) result = caseRESTElement(uriParameter);
				if (result == null) result = caseDocumentable(uriParameter);
				if (result == null) result = caseExtensible(uriParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapidmlPackage.MATRIX_PARAMETER: {
				MatrixParameter matrixParameter = (MatrixParameter)theEObject;
				T result = caseMatrixParameter(matrixParameter);
				if (result == null) result = caseURIParameter(matrixParameter);
				if (result == null) result = caseParameter(matrixParameter);
				if (result == null) result = caseRESTElement(matrixParameter);
				if (result == null) result = caseDocumentable(matrixParameter);
				if (result == null) result = caseExtensible(matrixParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapidmlPackage.TEMPLATE_PARAMETER: {
				TemplateParameter templateParameter = (TemplateParameter)theEObject;
				T result = caseTemplateParameter(templateParameter);
				if (result == null) result = caseURIParameter(templateParameter);
				if (result == null) result = caseParameter(templateParameter);
				if (result == null) result = caseRESTElement(templateParameter);
				if (result == null) result = caseDocumentable(templateParameter);
				if (result == null) result = caseExtensible(templateParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapidmlPackage.COLLECTION_RESOURCE: {
				CollectionResource collectionResource = (CollectionResource)theEObject;
				T result = caseCollectionResource(collectionResource);
				if (result == null) result = caseServiceDataResource(collectionResource);
				if (result == null) result = caseRealizationContainer(collectionResource);
				if (result == null) result = caseResourceDefinition(collectionResource);
				if (result == null) result = caseRESTElement(collectionResource);
				if (result == null) result = caseWithExamples(collectionResource);
				if (result == null) result = caseHasSecurityValue(collectionResource);
				if (result == null) result = caseExtensible(collectionResource);
				if (result == null) result = caseDocumentable(collectionResource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapidmlPackage.OBJECT_RESOURCE: {
				ObjectResource objectResource = (ObjectResource)theEObject;
				T result = caseObjectResource(objectResource);
				if (result == null) result = caseServiceDataResource(objectResource);
				if (result == null) result = caseRealizationContainer(objectResource);
				if (result == null) result = caseResourceDefinition(objectResource);
				if (result == null) result = caseRESTElement(objectResource);
				if (result == null) result = caseWithExamples(objectResource);
				if (result == null) result = caseHasSecurityValue(objectResource);
				if (result == null) result = caseExtensible(objectResource);
				if (result == null) result = caseDocumentable(objectResource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapidmlPackage.COLLECTION_PARAMETER: {
				CollectionParameter collectionParameter = (CollectionParameter)theEObject;
				T result = caseCollectionParameter(collectionParameter);
				if (result == null) result = caseParameter(collectionParameter);
				if (result == null) result = caseRESTElement(collectionParameter);
				if (result == null) result = caseDocumentable(collectionParameter);
				if (result == null) result = caseExtensible(collectionParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapidmlPackage.PROPERTY_REFERENCE: {
				PropertyReference propertyReference = (PropertyReference)theEObject;
				T result = casePropertyReference(propertyReference);
				if (result == null) result = caseSourceReference(propertyReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapidmlPackage.SOURCE_REFERENCE: {
				SourceReference sourceReference = (SourceReference)theEObject;
				T result = caseSourceReference(sourceReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapidmlPackage.MESSAGE_PARAMETER: {
				MessageParameter messageParameter = (MessageParameter)theEObject;
				T result = caseMessageParameter(messageParameter);
				if (result == null) result = caseParameter(messageParameter);
				if (result == null) result = caseRESTElement(messageParameter);
				if (result == null) result = caseDocumentable(messageParameter);
				if (result == null) result = caseExtensible(messageParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapidmlPackage.ZEN_MODEL: {
				ZenModel zenModel = (ZenModel)theEObject;
				T result = caseZenModel(zenModel);
				if (result == null) result = caseDocumentable(zenModel);
				if (result == null) result = caseExtensible(zenModel);
				if (result == null) result = caseHasTitle(zenModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapidmlPackage.RESOURCE_API: {
				ResourceAPI resourceAPI = (ResourceAPI)theEObject;
				T result = caseResourceAPI(resourceAPI);
				if (result == null) result = caseRESTElement(resourceAPI);
				if (result == null) result = caseHasSecurityValue(resourceAPI);
				if (result == null) result = caseHasTitle(resourceAPI);
				if (result == null) result = caseDocumentable(resourceAPI);
				if (result == null) result = caseExtensible(resourceAPI);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapidmlPackage.SERVICE_DATA_RESOURCE: {
				ServiceDataResource serviceDataResource = (ServiceDataResource)theEObject;
				T result = caseServiceDataResource(serviceDataResource);
				if (result == null) result = caseRealizationContainer(serviceDataResource);
				if (result == null) result = caseResourceDefinition(serviceDataResource);
				if (result == null) result = caseRESTElement(serviceDataResource);
				if (result == null) result = caseWithExamples(serviceDataResource);
				if (result == null) result = caseHasSecurityValue(serviceDataResource);
				if (result == null) result = caseExtensible(serviceDataResource);
				if (result == null) result = caseDocumentable(serviceDataResource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapidmlPackage.REFERENCE_TREATMENT: {
				ReferenceTreatment referenceTreatment = (ReferenceTreatment)theEObject;
				T result = caseReferenceTreatment(referenceTreatment);
				if (result == null) result = caseExtensible(referenceTreatment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapidmlPackage.REFERENCE_REALIZATION: {
				ReferenceRealization referenceRealization = (ReferenceRealization)theEObject;
				T result = caseReferenceRealization(referenceRealization);
				if (result == null) result = caseRealizationContainer(referenceRealization);
				if (result == null) result = caseExtensible(referenceRealization);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapidmlPackage.REFERENCE_LINK: {
				ReferenceLink referenceLink = (ReferenceLink)theEObject;
				T result = caseReferenceLink(referenceLink);
				if (result == null) result = caseReferenceTreatment(referenceLink);
				if (result == null) result = caseExtensible(referenceLink);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapidmlPackage.REFERENCE_EMBED: {
				ReferenceEmbed referenceEmbed = (ReferenceEmbed)theEObject;
				T result = caseReferenceEmbed(referenceEmbed);
				if (result == null) result = caseReferenceTreatment(referenceEmbed);
				if (result == null) result = caseExtensible(referenceEmbed);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapidmlPackage.NAMED_LINK_DESCRIPTOR: {
				NamedLinkDescriptor namedLinkDescriptor = (NamedLinkDescriptor)theEObject;
				T result = caseNamedLinkDescriptor(namedLinkDescriptor);
				if (result == null) result = caseObjectRealization(namedLinkDescriptor);
				if (result == null) result = caseExtensible(namedLinkDescriptor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapidmlPackage.PATH_SEGMENT: {
				PathSegment pathSegment = (PathSegment)theEObject;
				T result = casePathSegment(pathSegment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapidmlPackage.PRIMITIVE_TYPE_SOURCE_REFERENCE: {
				PrimitiveTypeSourceReference primitiveTypeSourceReference = (PrimitiveTypeSourceReference)theEObject;
				T result = casePrimitiveTypeSourceReference(primitiveTypeSourceReference);
				if (result == null) result = caseSourceReference(primitiveTypeSourceReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapidmlPackage.URI: {
				URI uri = (URI)theEObject;
				T result = caseURI(uri);
				if (result == null) result = caseHasStringValue(uri);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapidmlPackage.URI_SEGMENT: {
				URISegment uriSegment = (URISegment)theEObject;
				T result = caseURISegment(uriSegment);
				if (result == null) result = caseHasStringValue(uriSegment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapidmlPackage.URI_SEGMENT_WITH_PARAMETER: {
				URISegmentWithParameter uriSegmentWithParameter = (URISegmentWithParameter)theEObject;
				T result = caseURISegmentWithParameter(uriSegmentWithParameter);
				if (result == null) result = caseURISegment(uriSegmentWithParameter);
				if (result == null) result = caseHasStringValue(uriSegmentWithParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapidmlPackage.PROPERTY_REALIZATION: {
				PropertyRealization propertyRealization = (PropertyRealization)theEObject;
				T result = casePropertyRealization(propertyRealization);
				if (result == null) result = caseConstrainableType(propertyRealization);
				if (result == null) result = caseExtensible(propertyRealization);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapidmlPackage.LINK_RELATION: {
				LinkRelation linkRelation = (LinkRelation)theEObject;
				T result = caseLinkRelation(linkRelation);
				if (result == null) result = caseDocumentable(linkRelation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapidmlPackage.WITH_EXAMPLES: {
				WithExamples withExamples = (WithExamples)theEObject;
				T result = caseWithExamples(withExamples);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapidmlPackage.EXAMPLE: {
				Example example = (Example)theEObject;
				T result = caseExample(example);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapidmlPackage.INLINE_EXAMPLE: {
				InlineExample inlineExample = (InlineExample)theEObject;
				T result = caseInlineExample(inlineExample);
				if (result == null) result = caseExample(inlineExample);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapidmlPackage.EXTERNAL_EXAMPLE: {
				ExternalExample externalExample = (ExternalExample)theEObject;
				T result = caseExternalExample(externalExample);
				if (result == null) result = caseExample(externalExample);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapidmlPackage.HAS_STRING_VALUE: {
				HasStringValue hasStringValue = (HasStringValue)theEObject;
				T result = caseHasStringValue(hasStringValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapidmlPackage.IMPORT_DECLARATION: {
				ImportDeclaration importDeclaration = (ImportDeclaration)theEObject;
				T result = caseImportDeclaration(importDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapidmlPackage.OBJECT_REALIZATION: {
				ObjectRealization objectRealization = (ObjectRealization)theEObject;
				T result = caseObjectRealization(objectRealization);
				if (result == null) result = caseExtensible(objectRealization);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapidmlPackage.COLLECTION_REFERENCE_ELEMENT: {
				CollectionReferenceElement collectionReferenceElement = (CollectionReferenceElement)theEObject;
				T result = caseCollectionReferenceElement(collectionReferenceElement);
				if (result == null) result = caseReferenceElement(collectionReferenceElement);
				if (result == null) result = caseElement(collectionReferenceElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapidmlPackage.HAS_SECURITY_VALUE: {
				HasSecurityValue hasSecurityValue = (HasSecurityValue)theEObject;
				T result = caseHasSecurityValue(hasSecurityValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapidmlPackage.SECURITY_SCHEME: {
				SecurityScheme securityScheme = (SecurityScheme)theEObject;
				T result = caseSecurityScheme(securityScheme);
				if (result == null) result = caseRESTElement(securityScheme);
				if (result == null) result = caseDocumentable(securityScheme);
				if (result == null) result = caseExtensible(securityScheme);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapidmlPackage.AUTHENTICATION_METHOD: {
				AuthenticationMethod authenticationMethod = (AuthenticationMethod)theEObject;
				T result = caseAuthenticationMethod(authenticationMethod);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapidmlPackage.SECURITY_SCOPE: {
				SecurityScope securityScope = (SecurityScope)theEObject;
				T result = caseSecurityScope(securityScope);
				if (result == null) result = caseDocumentable(securityScope);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapidmlPackage.SECURITY_SCHEME_PARAMETER: {
				SecuritySchemeParameter securitySchemeParameter = (SecuritySchemeParameter)theEObject;
				T result = caseSecuritySchemeParameter(securitySchemeParameter);
				if (result == null) result = caseDocumentable(securitySchemeParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapidmlPackage.SECURITY_SCHEME_LIBRARY: {
				SecuritySchemeLibrary securitySchemeLibrary = (SecuritySchemeLibrary)theEObject;
				T result = caseSecuritySchemeLibrary(securitySchemeLibrary);
				if (result == null) result = caseDocumentable(securitySchemeLibrary);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapidmlPackage.REALIZATION_CONTAINER: {
				RealizationContainer realizationContainer = (RealizationContainer)theEObject;
				T result = caseRealizationContainer(realizationContainer);
				if (result == null) result = caseExtensible(realizationContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapidmlPackage.EXTENSIBLE: {
				Extensible extensible = (Extensible)theEObject;
				T result = caseExtensible(extensible);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapidmlPackage.EXTENSION: {
				Extension extension = (Extension)theEObject;
				T result = caseExtension(extension);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapidmlPackage.REALIZATION_MODEL_LOCATION: {
				RealizationModelLocation realizationModelLocation = (RealizationModelLocation)theEObject;
				T result = caseRealizationModelLocation(realizationModelLocation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapidmlPackage.HAS_TITLE: {
				HasTitle hasTitle = (HasTitle)theEObject;
				T result = caseHasTitle(hasTitle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapidmlPackage.OPERATION: {
				Operation operation = (Operation)theEObject;
				T result = caseOperation(operation);
				if (result == null) result = caseDocumentable(operation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapidmlPackage.FEATURE: {
				Feature feature = (Feature)theEObject;
				T result = caseFeature(feature);
				if (result == null) result = caseDocumentable(feature);
				if (result == null) result = caseElement(feature);
				if (result == null) result = caseExtensible(feature);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapidmlPackage.REFERENCE_PROPERTY: {
				ReferenceProperty referenceProperty = (ReferenceProperty)theEObject;
				T result = caseReferenceProperty(referenceProperty);
				if (result == null) result = caseFeature(referenceProperty);
				if (result == null) result = caseReferenceElement(referenceProperty);
				if (result == null) result = caseDocumentable(referenceProperty);
				if (result == null) result = caseElement(referenceProperty);
				if (result == null) result = caseExtensible(referenceProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapidmlPackage.PRIMITIVE_PROPERTY: {
				PrimitiveProperty primitiveProperty = (PrimitiveProperty)theEObject;
				T result = casePrimitiveProperty(primitiveProperty);
				if (result == null) result = caseFeature(primitiveProperty);
				if (result == null) result = caseHasStringValue(primitiveProperty);
				if (result == null) result = caseConstrainableType(primitiveProperty);
				if (result == null) result = caseDocumentable(primitiveProperty);
				if (result == null) result = caseElement(primitiveProperty);
				if (result == null) result = caseExtensible(primitiveProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapidmlPackage.STRUCTURE: {
				Structure structure = (Structure)theEObject;
				T result = caseStructure(structure);
				if (result == null) result = caseDataType(structure);
				if (result == null) result = caseWithDataExamples(structure);
				if (result == null) result = caseInheritable(structure);
				if (result == null) result = caseDocumentable(structure);
				if (result == null) result = caseExtensible(structure);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapidmlPackage.DATA_MODEL: {
				DataModel dataModel = (DataModel)theEObject;
				T result = caseDataModel(dataModel);
				if (result == null) result = caseDocumentable(dataModel);
				if (result == null) result = caseHasTitle(dataModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapidmlPackage.WITH_DATA_EXAMPLES: {
				WithDataExamples withDataExamples = (WithDataExamples)theEObject;
				T result = caseWithDataExamples(withDataExamples);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapidmlPackage.DATA_EXAMPLE: {
				DataExample dataExample = (DataExample)theEObject;
				T result = caseDataExample(dataExample);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapidmlPackage.INLINE_DATA_EXAMPLE: {
				InlineDataExample inlineDataExample = (InlineDataExample)theEObject;
				T result = caseInlineDataExample(inlineDataExample);
				if (result == null) result = caseDataExample(inlineDataExample);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapidmlPackage.CONSTRAINT: {
				Constraint constraint = (Constraint)theEObject;
				T result = caseConstraint(constraint);
				if (result == null) result = caseExtensible(constraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapidmlPackage.ENUMERATION: {
				Enumeration enumeration = (Enumeration)theEObject;
				T result = caseEnumeration(enumeration);
				if (result == null) result = caseSingleValueType(enumeration);
				if (result == null) result = caseDataType(enumeration);
				if (result == null) result = caseDocumentable(enumeration);
				if (result == null) result = caseExtensible(enumeration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapidmlPackage.SIMPLE_TYPE: {
				SimpleType simpleType = (SimpleType)theEObject;
				T result = caseSimpleType(simpleType);
				if (result == null) result = caseSingleValueType(simpleType);
				if (result == null) result = caseDataType(simpleType);
				if (result == null) result = caseDocumentable(simpleType);
				if (result == null) result = caseExtensible(simpleType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapidmlPackage.ENUM_CONSTANT: {
				EnumConstant enumConstant = (EnumConstant)theEObject;
				T result = caseEnumConstant(enumConstant);
				if (result == null) result = caseDocumentable(enumConstant);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapidmlPackage.USER_DEFINED_TYPE: {
				UserDefinedType userDefinedType = (UserDefinedType)theEObject;
				T result = caseUserDefinedType(userDefinedType);
				if (result == null) result = caseSimpleType(userDefinedType);
				if (result == null) result = caseConstrainableType(userDefinedType);
				if (result == null) result = caseSingleValueType(userDefinedType);
				if (result == null) result = caseDataType(userDefinedType);
				if (result == null) result = caseDocumentable(userDefinedType);
				if (result == null) result = caseExtensible(userDefinedType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapidmlPackage.PRIMITIVE_TYPE: {
				PrimitiveType primitiveType = (PrimitiveType)theEObject;
				T result = casePrimitiveType(primitiveType);
				if (result == null) result = caseSimpleType(primitiveType);
				if (result == null) result = caseSingleValueType(primitiveType);
				if (result == null) result = caseDataType(primitiveType);
				if (result == null) result = caseDocumentable(primitiveType);
				if (result == null) result = caseExtensible(primitiveType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapidmlPackage.DATA_TYPE: {
				DataType dataType = (DataType)theEObject;
				T result = caseDataType(dataType);
				if (result == null) result = caseDocumentable(dataType);
				if (result == null) result = caseExtensible(dataType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapidmlPackage.SINGLE_VALUE_TYPE: {
				SingleValueType singleValueType = (SingleValueType)theEObject;
				T result = caseSingleValueType(singleValueType);
				if (result == null) result = caseDataType(singleValueType);
				if (result == null) result = caseDocumentable(singleValueType);
				if (result == null) result = caseExtensible(singleValueType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapidmlPackage.ELEMENT: {
				com.modelsolv.reprezen.rapidml.Element element = (com.modelsolv.reprezen.rapidml.Element)theEObject;
				T result = caseElement(element);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapidmlPackage.REFERENCE_ELEMENT: {
				com.modelsolv.reprezen.rapidml.ReferenceElement referenceElement = (com.modelsolv.reprezen.rapidml.ReferenceElement)theEObject;
				T result = caseReferenceElement(referenceElement);
				if (result == null) result = caseElement(referenceElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapidmlPackage.LENGTH_CONSTRAINT: {
				LengthConstraint lengthConstraint = (LengthConstraint)theEObject;
				T result = caseLengthConstraint(lengthConstraint);
				if (result == null) result = caseConstraint(lengthConstraint);
				if (result == null) result = caseExtensible(lengthConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapidmlPackage.REG_EX_CONSTRAINT: {
				RegExConstraint regExConstraint = (RegExConstraint)theEObject;
				T result = caseRegExConstraint(regExConstraint);
				if (result == null) result = caseConstraint(regExConstraint);
				if (result == null) result = caseExtensible(regExConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapidmlPackage.VALUE_RANGE_CONSTRAINT: {
				ValueRangeConstraint valueRangeConstraint = (ValueRangeConstraint)theEObject;
				T result = caseValueRangeConstraint(valueRangeConstraint);
				if (result == null) result = caseConstraint(valueRangeConstraint);
				if (result == null) result = caseExtensible(valueRangeConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapidmlPackage.CONSTRAINABLE_TYPE: {
				com.modelsolv.reprezen.rapidml.ConstrainableType constrainableType = (com.modelsolv.reprezen.rapidml.ConstrainableType)theEObject;
				T result = caseConstrainableType(constrainableType);
				if (result == null) result = caseExtensible(constrainableType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapidmlPackage.INHERITABLE: {
				Inheritable inheritable = (Inheritable)theEObject;
				T result = caseInheritable(inheritable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapidmlPackage.MEDIA_TYPES_LIBRARY: {
				MediaTypesLibrary mediaTypesLibrary = (MediaTypesLibrary)theEObject;
				T result = caseMediaTypesLibrary(mediaTypesLibrary);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapidmlPackage.LINK_RELATIONS_LIBRARY: {
				LinkRelationsLibrary linkRelationsLibrary = (LinkRelationsLibrary)theEObject;
				T result = caseLinkRelationsLibrary(linkRelationsLibrary);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RapidmlPackage.PRIMITIVE_TYPES_LIBRARY: {
				PrimitiveTypesLibrary primitiveTypesLibrary = (PrimitiveTypesLibrary)theEObject;
				T result = casePrimitiveTypesLibrary(primitiveTypesLibrary);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Resource Definition</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseResourceDefinition(ResourceDefinition object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Typed Message</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Typed Message</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseTypedMessage(TypedMessage object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Method</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Method</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseMethod(Method object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Parameter</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseParameter(Parameter object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>REST Element</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>REST Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseRESTElement(RESTElement object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Documentation</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Documentation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseDocumentation(Documentation object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Documentable</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Documentable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseDocumentable(Documentable object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Media Type</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Media Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseMediaType(MediaType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Typed Request</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Typed Request</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseTypedRequest(TypedRequest object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Typed Response</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Typed Response</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseTypedResponse(TypedResponse object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>URI Parameter</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>URI Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseURIParameter(URIParameter object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Matrix Parameter</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Matrix Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseMatrixParameter(MatrixParameter object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Template Parameter</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Template Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseTemplateParameter(TemplateParameter object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Collection Resource</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collection Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseCollectionResource(CollectionResource object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Object Resource</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Object Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseObjectResource(ObjectResource object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Collection Parameter</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collection Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseCollectionParameter(CollectionParameter object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Property Reference</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T casePropertyReference(PropertyReference object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Source Reference</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Source Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseSourceReference(SourceReference object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Message Parameter</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Message Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseMessageParameter(MessageParameter object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Zen Model</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Zen Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseZenModel(ZenModel object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Resource API</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource API</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseResourceAPI(ResourceAPI object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Service Data Resource</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Service Data Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseServiceDataResource(ServiceDataResource object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Reference Treatment</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reference Treatment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseReferenceTreatment(ReferenceTreatment object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Reference Realization</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reference Realization</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseReferenceRealization(ReferenceRealization object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Reference Link</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reference Link</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseReferenceLink(ReferenceLink object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Reference Embed</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reference Embed</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseReferenceEmbed(ReferenceEmbed object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Named Link Descriptor</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Link Descriptor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseNamedLinkDescriptor(NamedLinkDescriptor object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Path Segment</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Path Segment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T casePathSegment(PathSegment object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Primitive Type Source Reference</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primitive Type Source Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T casePrimitiveTypeSourceReference(PrimitiveTypeSourceReference object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>URI</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>URI</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseURI(URI object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>URI Segment</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>URI Segment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseURISegment(URISegment object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>URI Segment With Parameter</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>URI Segment With Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseURISegmentWithParameter(URISegmentWithParameter object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Property Realization</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Realization</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T casePropertyRealization(PropertyRealization object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Link Relation</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Link Relation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseLinkRelation(LinkRelation object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>With Examples</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>With Examples</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseWithExamples(WithExamples object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Example</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Example</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseExample(Example object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Inline Example</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Inline Example</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseInlineExample(InlineExample object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>External Example</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>External Example</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseExternalExample(ExternalExample object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Has String Value</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Has String Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseHasStringValue(HasStringValue object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Import Declaration</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Import Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseImportDeclaration(ImportDeclaration object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Object Realization</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Object Realization</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseObjectRealization(ObjectRealization object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Collection Reference Element</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collection Reference Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseCollectionReferenceElement(CollectionReferenceElement object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Has Security Value</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Has Security Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseHasSecurityValue(HasSecurityValue object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Security Scheme</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Security Scheme</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseSecurityScheme(SecurityScheme object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Authentication Method</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Authentication Method</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseAuthenticationMethod(AuthenticationMethod object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Security Scope</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Security Scope</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseSecurityScope(SecurityScope object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Security Scheme Parameter</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Security Scheme Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseSecuritySchemeParameter(SecuritySchemeParameter object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Security Scheme Library</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Security Scheme Library</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseSecuritySchemeLibrary(SecuritySchemeLibrary object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Realization Container</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Realization Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseRealizationContainer(RealizationContainer object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Extensible</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extensible</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseExtensible(Extensible object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Extension</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extension</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseExtension(Extension object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Realization Model Location</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Realization Model Location</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseRealizationModelLocation(RealizationModelLocation object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Has Title</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Has Title</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public T caseHasTitle(HasTitle object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperation(Operation object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Feature</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Feature</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFeature(Feature object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Reference Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reference Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReferenceProperty(ReferenceProperty object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Primitive Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primitive Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrimitiveProperty(PrimitiveProperty object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Structure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Structure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStructure(Structure object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataModel(DataModel object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>With Data Examples</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>With Data Examples</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWithDataExamples(WithDataExamples object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Example</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Example</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataExample(DataExample object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Inline Data Example</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Inline Data Example</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInlineDataExample(InlineDataExample object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConstraint(Constraint object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Enumeration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enumeration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumeration(Enumeration object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Simple Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Simple Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSimpleType(SimpleType object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Enum Constant</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enum Constant</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumConstant(EnumConstant object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>User Defined Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>User Defined Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUserDefinedType(UserDefinedType object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Primitive Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primitive Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrimitiveType(PrimitiveType object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataType(DataType object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Single Value Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Single Value Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSingleValueType(SingleValueType object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElement(com.modelsolv.reprezen.rapidml.Element object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Reference Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reference Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReferenceElement(com.modelsolv.reprezen.rapidml.ReferenceElement object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Length Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Length Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLengthConstraint(LengthConstraint object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Reg Ex Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reg Ex Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRegExConstraint(RegExConstraint object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Value Range Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Value Range Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseValueRangeConstraint(ValueRangeConstraint object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Constrainable Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constrainable Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConstrainableType(com.modelsolv.reprezen.rapidml.ConstrainableType object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Inheritable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Inheritable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInheritable(Inheritable object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Media Types Library</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Media Types Library</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMediaTypesLibrary(MediaTypesLibrary object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Link Relations Library</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Link Relations Library</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLinkRelationsLibrary(LinkRelationsLibrary object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Primitive Types Library</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primitive Types Library</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrimitiveTypesLibrary(PrimitiveTypesLibrary object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch, but this is the last case anyway.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
    @Override
    public T defaultCase(EObject object) {
		return null;
	}

} //RapidmlSwitch
