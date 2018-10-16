/**
 * Copyright © 2013-2016 Modelsolv, Inc.
 * All Rights Reserved.
 * 
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 */
package com.modelsolv.reprezen.restapi.util;

import com.modelsolv.reprezen.restapi.*;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import com.modelsolv.reprezen.restapi.AuthenticationMethod;
import com.modelsolv.reprezen.restapi.CollectionParameter;
import com.modelsolv.reprezen.restapi.CollectionReferenceElement;
import com.modelsolv.reprezen.restapi.CollectionResource;
import com.modelsolv.reprezen.restapi.Documentable;
import com.modelsolv.reprezen.restapi.Documentation;
import com.modelsolv.reprezen.restapi.Example;
import com.modelsolv.reprezen.restapi.Extensible;
import com.modelsolv.reprezen.restapi.Extension;
import com.modelsolv.reprezen.restapi.ExternalExample;
import com.modelsolv.reprezen.restapi.HasSecurityValue;
import com.modelsolv.reprezen.restapi.HasStringValue;
import com.modelsolv.reprezen.restapi.ImportDeclaration;
import com.modelsolv.reprezen.restapi.InlineExample;
import com.modelsolv.reprezen.restapi.LinkRelation;
import com.modelsolv.reprezen.restapi.MatrixParameter;
import com.modelsolv.reprezen.restapi.MediaType;
import com.modelsolv.reprezen.restapi.MessageParameter;
import com.modelsolv.reprezen.restapi.Method;
import com.modelsolv.reprezen.restapi.NamedLinkDescriptor;
import com.modelsolv.reprezen.restapi.ObjectRealization;
import com.modelsolv.reprezen.restapi.ObjectResource;
import com.modelsolv.reprezen.restapi.Parameter;
import com.modelsolv.reprezen.restapi.PathSegment;
import com.modelsolv.reprezen.restapi.PrimitiveTypeSourceReference;
import com.modelsolv.reprezen.restapi.PropertyRealization;
import com.modelsolv.reprezen.restapi.PropertyReference;
import com.modelsolv.reprezen.restapi.RESTElement;
import com.modelsolv.reprezen.restapi.RealizationContainer;
import com.modelsolv.reprezen.restapi.ReferenceEmbed;
import com.modelsolv.reprezen.restapi.ReferenceLink;
import com.modelsolv.reprezen.restapi.ReferenceRealization;
import com.modelsolv.reprezen.restapi.ReferenceTreatment;
import com.modelsolv.reprezen.restapi.ResourceAPI;
import com.modelsolv.reprezen.restapi.ResourceDefinition;
import com.modelsolv.reprezen.restapi.RestapiPackage;
import com.modelsolv.reprezen.restapi.SecurityScheme;
import com.modelsolv.reprezen.restapi.SecuritySchemeLibrary;
import com.modelsolv.reprezen.restapi.SecuritySchemeParameter;
import com.modelsolv.reprezen.restapi.SecurityScope;
import com.modelsolv.reprezen.restapi.ServiceDataResource;
import com.modelsolv.reprezen.restapi.SourceReference;
import com.modelsolv.reprezen.restapi.TemplateParameter;
import com.modelsolv.reprezen.restapi.TypedMessage;
import com.modelsolv.reprezen.restapi.TypedRequest;
import com.modelsolv.reprezen.restapi.TypedResponse;
import com.modelsolv.reprezen.restapi.URI;
import com.modelsolv.reprezen.restapi.URIParameter;
import com.modelsolv.reprezen.restapi.URISegment;
import com.modelsolv.reprezen.restapi.URISegmentWithParameter;
import com.modelsolv.reprezen.restapi.WithExamples;
import com.modelsolv.reprezen.restapi.ZenModel;
import com.modelsolv.reprezen.restapi.ConstrainableType;
import com.modelsolv.reprezen.restapi.Element;
import com.modelsolv.reprezen.restapi.ReferenceElement;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.modelsolv.reprezen.restapi.RestapiPackage
 * @generated
 */
public class RestapiAdapterFactory extends AdapterFactoryImpl {
    /**
	 * The cached model package.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected static RestapiPackage modelPackage;

    /**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public RestapiAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = RestapiPackage.eINSTANCE;
		}
	}

    /**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
     * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
     * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
    @Override
    public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

    /**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected RestapiSwitch<Adapter> modelSwitch =
        new RestapiSwitch<Adapter>() {
			@Override
			public Adapter caseResourceDefinition(ResourceDefinition object) {
				return createResourceDefinitionAdapter();
			}
			@Override
			public Adapter caseTypedMessage(TypedMessage object) {
				return createTypedMessageAdapter();
			}
			@Override
			public Adapter caseMethod(Method object) {
				return createMethodAdapter();
			}
			@Override
			public Adapter caseParameter(Parameter object) {
				return createParameterAdapter();
			}
			@Override
			public Adapter caseRESTElement(RESTElement object) {
				return createRESTElementAdapter();
			}
			@Override
			public Adapter caseDocumentation(Documentation object) {
				return createDocumentationAdapter();
			}
			@Override
			public Adapter caseDocumentable(Documentable object) {
				return createDocumentableAdapter();
			}
			@Override
			public Adapter caseMediaType(MediaType object) {
				return createMediaTypeAdapter();
			}
			@Override
			public Adapter caseTypedRequest(TypedRequest object) {
				return createTypedRequestAdapter();
			}
			@Override
			public Adapter caseTypedResponse(TypedResponse object) {
				return createTypedResponseAdapter();
			}
			@Override
			public Adapter caseURIParameter(URIParameter object) {
				return createURIParameterAdapter();
			}
			@Override
			public Adapter caseMatrixParameter(MatrixParameter object) {
				return createMatrixParameterAdapter();
			}
			@Override
			public Adapter caseTemplateParameter(TemplateParameter object) {
				return createTemplateParameterAdapter();
			}
			@Override
			public Adapter caseCollectionResource(CollectionResource object) {
				return createCollectionResourceAdapter();
			}
			@Override
			public Adapter caseObjectResource(ObjectResource object) {
				return createObjectResourceAdapter();
			}
			@Override
			public Adapter caseCollectionParameter(CollectionParameter object) {
				return createCollectionParameterAdapter();
			}
			@Override
			public Adapter casePropertyReference(PropertyReference object) {
				return createPropertyReferenceAdapter();
			}
			@Override
			public Adapter caseSourceReference(SourceReference object) {
				return createSourceReferenceAdapter();
			}
			@Override
			public Adapter caseMessageParameter(MessageParameter object) {
				return createMessageParameterAdapter();
			}
			@Override
			public Adapter caseZenModel(ZenModel object) {
				return createZenModelAdapter();
			}
			@Override
			public Adapter caseResourceAPI(ResourceAPI object) {
				return createResourceAPIAdapter();
			}
			@Override
			public Adapter caseServiceDataResource(ServiceDataResource object) {
				return createServiceDataResourceAdapter();
			}
			@Override
			public Adapter caseReferenceTreatment(ReferenceTreatment object) {
				return createReferenceTreatmentAdapter();
			}
			@Override
			public Adapter caseReferenceRealization(ReferenceRealization object) {
				return createReferenceRealizationAdapter();
			}
			@Override
			public Adapter caseReferenceLink(ReferenceLink object) {
				return createReferenceLinkAdapter();
			}
			@Override
			public Adapter caseReferenceEmbed(ReferenceEmbed object) {
				return createReferenceEmbedAdapter();
			}
			@Override
			public Adapter caseNamedLinkDescriptor(NamedLinkDescriptor object) {
				return createNamedLinkDescriptorAdapter();
			}
			@Override
			public Adapter casePathSegment(PathSegment object) {
				return createPathSegmentAdapter();
			}
			@Override
			public Adapter casePrimitiveTypeSourceReference(PrimitiveTypeSourceReference object) {
				return createPrimitiveTypeSourceReferenceAdapter();
			}
			@Override
			public Adapter caseURI(URI object) {
				return createURIAdapter();
			}
			@Override
			public Adapter caseURISegment(URISegment object) {
				return createURISegmentAdapter();
			}
			@Override
			public Adapter caseURISegmentWithParameter(URISegmentWithParameter object) {
				return createURISegmentWithParameterAdapter();
			}
			@Override
			public Adapter casePropertyRealization(PropertyRealization object) {
				return createPropertyRealizationAdapter();
			}
			@Override
			public Adapter caseLinkRelation(LinkRelation object) {
				return createLinkRelationAdapter();
			}
			@Override
			public Adapter caseWithExamples(WithExamples object) {
				return createWithExamplesAdapter();
			}
			@Override
			public Adapter caseExample(Example object) {
				return createExampleAdapter();
			}
			@Override
			public Adapter caseInlineExample(InlineExample object) {
				return createInlineExampleAdapter();
			}
			@Override
			public Adapter caseExternalExample(ExternalExample object) {
				return createExternalExampleAdapter();
			}
			@Override
			public Adapter caseHasStringValue(HasStringValue object) {
				return createHasStringValueAdapter();
			}
			@Override
			public Adapter caseImportDeclaration(ImportDeclaration object) {
				return createImportDeclarationAdapter();
			}
			@Override
			public Adapter caseObjectRealization(ObjectRealization object) {
				return createObjectRealizationAdapter();
			}
			@Override
			public Adapter caseCollectionReferenceElement(CollectionReferenceElement object) {
				return createCollectionReferenceElementAdapter();
			}
			@Override
			public Adapter caseHasSecurityValue(HasSecurityValue object) {
				return createHasSecurityValueAdapter();
			}
			@Override
			public Adapter caseSecurityScheme(SecurityScheme object) {
				return createSecuritySchemeAdapter();
			}
			@Override
			public Adapter caseAuthenticationMethod(AuthenticationMethod object) {
				return createAuthenticationMethodAdapter();
			}
			@Override
			public Adapter caseSecurityScope(SecurityScope object) {
				return createSecurityScopeAdapter();
			}
			@Override
			public Adapter caseSecuritySchemeParameter(SecuritySchemeParameter object) {
				return createSecuritySchemeParameterAdapter();
			}
			@Override
			public Adapter caseSecuritySchemeLibrary(SecuritySchemeLibrary object) {
				return createSecuritySchemeLibraryAdapter();
			}
			@Override
			public Adapter caseRealizationContainer(RealizationContainer object) {
				return createRealizationContainerAdapter();
			}
			@Override
			public Adapter caseExtensible(Extensible object) {
				return createExtensibleAdapter();
			}
			@Override
			public Adapter caseExtension(Extension object) {
				return createExtensionAdapter();
			}
			@Override
			public Adapter caseRealizationModelLocation(RealizationModelLocation object) {
				return createRealizationModelLocationAdapter();
			}
			@Override
			public Adapter caseHasTitle(HasTitle object) {
				return createHasTitleAdapter();
			}
			@Override
			public Adapter caseOperation(Operation object) {
				return createOperationAdapter();
			}
			@Override
			public Adapter caseFeature(Feature object) {
				return createFeatureAdapter();
			}
			@Override
			public Adapter caseReferenceProperty(ReferenceProperty object) {
				return createReferencePropertyAdapter();
			}
			@Override
			public Adapter casePrimitiveProperty(PrimitiveProperty object) {
				return createPrimitivePropertyAdapter();
			}
			@Override
			public Adapter caseStructure(Structure object) {
				return createStructureAdapter();
			}
			@Override
			public Adapter caseDataModel(DataModel object) {
				return createDataModelAdapter();
			}
			@Override
			public Adapter caseWithDataExamples(WithDataExamples object) {
				return createWithDataExamplesAdapter();
			}
			@Override
			public Adapter caseDataExample(DataExample object) {
				return createDataExampleAdapter();
			}
			@Override
			public Adapter caseInlineDataExample(InlineDataExample object) {
				return createInlineDataExampleAdapter();
			}
			@Override
			public Adapter caseConstraint(Constraint object) {
				return createConstraintAdapter();
			}
			@Override
			public Adapter caseEnumeration(Enumeration object) {
				return createEnumerationAdapter();
			}
			@Override
			public Adapter caseSimpleType(SimpleType object) {
				return createSimpleTypeAdapter();
			}
			@Override
			public Adapter caseEnumConstant(EnumConstant object) {
				return createEnumConstantAdapter();
			}
			@Override
			public Adapter caseUserDefinedType(UserDefinedType object) {
				return createUserDefinedTypeAdapter();
			}
			@Override
			public Adapter casePrimitiveType(PrimitiveType object) {
				return createPrimitiveTypeAdapter();
			}
			@Override
			public Adapter caseDataType(DataType object) {
				return createDataTypeAdapter();
			}
			@Override
			public Adapter caseSingleValueType(SingleValueType object) {
				return createSingleValueTypeAdapter();
			}
			@Override
			public Adapter caseElement(com.modelsolv.reprezen.restapi.Element object) {
				return createElementAdapter();
			}
			@Override
			public Adapter caseReferenceElement(com.modelsolv.reprezen.restapi.ReferenceElement object) {
				return createReferenceElementAdapter();
			}
			@Override
			public Adapter caseLengthConstraint(LengthConstraint object) {
				return createLengthConstraintAdapter();
			}
			@Override
			public Adapter caseRegExConstraint(RegExConstraint object) {
				return createRegExConstraintAdapter();
			}
			@Override
			public Adapter caseValueRangeConstraint(ValueRangeConstraint object) {
				return createValueRangeConstraintAdapter();
			}
			@Override
			public Adapter caseConstrainableType(com.modelsolv.reprezen.restapi.ConstrainableType object) {
				return createConstrainableTypeAdapter();
			}
			@Override
			public Adapter caseInheritable(Inheritable object) {
				return createInheritableAdapter();
			}
			@Override
			public Adapter caseMediaTypesLibrary(MediaTypesLibrary object) {
				return createMediaTypesLibraryAdapter();
			}
			@Override
			public Adapter caseLinkRelationsLibrary(LinkRelationsLibrary object) {
				return createLinkRelationsLibraryAdapter();
			}
			@Override
			public Adapter casePrimitiveTypesLibrary(PrimitiveTypesLibrary object) {
				return createPrimitiveTypesLibraryAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

    /**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
    @Override
    public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


    /**
	 * Creates a new adapter for an object of class '{@link com.modelsolv.reprezen.restapi.ResourceDefinition <em>Resource Definition</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.modelsolv.reprezen.restapi.ResourceDefinition
	 * @generated
	 */
    public Adapter createResourceDefinitionAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link com.modelsolv.reprezen.restapi.TypedMessage <em>Typed Message</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.modelsolv.reprezen.restapi.TypedMessage
	 * @generated
	 */
    public Adapter createTypedMessageAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link com.modelsolv.reprezen.restapi.Method <em>Method</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.modelsolv.reprezen.restapi.Method
	 * @generated
	 */
    public Adapter createMethodAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link com.modelsolv.reprezen.restapi.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.modelsolv.reprezen.restapi.Parameter
	 * @generated
	 */
    public Adapter createParameterAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link com.modelsolv.reprezen.restapi.RESTElement <em>REST Element</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.modelsolv.reprezen.restapi.RESTElement
	 * @generated
	 */
    public Adapter createRESTElementAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link com.modelsolv.reprezen.restapi.Documentation <em>Documentation</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.modelsolv.reprezen.restapi.Documentation
	 * @generated
	 */
    public Adapter createDocumentationAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link com.modelsolv.reprezen.restapi.Documentable <em>Documentable</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.modelsolv.reprezen.restapi.Documentable
	 * @generated
	 */
    public Adapter createDocumentableAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link com.modelsolv.reprezen.restapi.MediaType <em>Media Type</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.modelsolv.reprezen.restapi.MediaType
	 * @generated
	 */
    public Adapter createMediaTypeAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link com.modelsolv.reprezen.restapi.TypedRequest <em>Typed Request</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.modelsolv.reprezen.restapi.TypedRequest
	 * @generated
	 */
    public Adapter createTypedRequestAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link com.modelsolv.reprezen.restapi.TypedResponse <em>Typed Response</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.modelsolv.reprezen.restapi.TypedResponse
	 * @generated
	 */
    public Adapter createTypedResponseAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link com.modelsolv.reprezen.restapi.URIParameter <em>URI Parameter</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.modelsolv.reprezen.restapi.URIParameter
	 * @generated
	 */
    public Adapter createURIParameterAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link com.modelsolv.reprezen.restapi.MatrixParameter <em>Matrix Parameter</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.modelsolv.reprezen.restapi.MatrixParameter
	 * @generated
	 */
    public Adapter createMatrixParameterAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link com.modelsolv.reprezen.restapi.TemplateParameter <em>Template Parameter</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.modelsolv.reprezen.restapi.TemplateParameter
	 * @generated
	 */
    public Adapter createTemplateParameterAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link com.modelsolv.reprezen.restapi.CollectionResource <em>Collection Resource</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.modelsolv.reprezen.restapi.CollectionResource
	 * @generated
	 */
    public Adapter createCollectionResourceAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link com.modelsolv.reprezen.restapi.ObjectResource <em>Object Resource</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.modelsolv.reprezen.restapi.ObjectResource
	 * @generated
	 */
    public Adapter createObjectResourceAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link com.modelsolv.reprezen.restapi.CollectionParameter <em>Collection Parameter</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.modelsolv.reprezen.restapi.CollectionParameter
	 * @generated
	 */
    public Adapter createCollectionParameterAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link com.modelsolv.reprezen.restapi.PropertyReference <em>Property Reference</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.modelsolv.reprezen.restapi.PropertyReference
	 * @generated
	 */
    public Adapter createPropertyReferenceAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link com.modelsolv.reprezen.restapi.SourceReference <em>Source Reference</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.modelsolv.reprezen.restapi.SourceReference
	 * @generated
	 */
    public Adapter createSourceReferenceAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link com.modelsolv.reprezen.restapi.MessageParameter <em>Message Parameter</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.modelsolv.reprezen.restapi.MessageParameter
	 * @generated
	 */
    public Adapter createMessageParameterAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link com.modelsolv.reprezen.restapi.ZenModel <em>Zen Model</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.modelsolv.reprezen.restapi.ZenModel
	 * @generated
	 */
    public Adapter createZenModelAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link com.modelsolv.reprezen.restapi.ResourceAPI <em>Resource API</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.modelsolv.reprezen.restapi.ResourceAPI
	 * @generated
	 */
    public Adapter createResourceAPIAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link com.modelsolv.reprezen.restapi.ServiceDataResource <em>Service Data Resource</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.modelsolv.reprezen.restapi.ServiceDataResource
	 * @generated
	 */
    public Adapter createServiceDataResourceAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link com.modelsolv.reprezen.restapi.ReferenceTreatment <em>Reference Treatment</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.modelsolv.reprezen.restapi.ReferenceTreatment
	 * @generated
	 */
    public Adapter createReferenceTreatmentAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link com.modelsolv.reprezen.restapi.ReferenceRealization <em>Reference Realization</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.modelsolv.reprezen.restapi.ReferenceRealization
	 * @generated
	 */
    public Adapter createReferenceRealizationAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link com.modelsolv.reprezen.restapi.ReferenceLink <em>Reference Link</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.modelsolv.reprezen.restapi.ReferenceLink
	 * @generated
	 */
    public Adapter createReferenceLinkAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link com.modelsolv.reprezen.restapi.ReferenceEmbed <em>Reference Embed</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.modelsolv.reprezen.restapi.ReferenceEmbed
	 * @generated
	 */
    public Adapter createReferenceEmbedAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link com.modelsolv.reprezen.restapi.NamedLinkDescriptor <em>Named Link Descriptor</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.modelsolv.reprezen.restapi.NamedLinkDescriptor
	 * @generated
	 */
    public Adapter createNamedLinkDescriptorAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link com.modelsolv.reprezen.restapi.PathSegment <em>Path Segment</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.modelsolv.reprezen.restapi.PathSegment
	 * @generated
	 */
    public Adapter createPathSegmentAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link com.modelsolv.reprezen.restapi.PrimitiveTypeSourceReference <em>Primitive Type Source Reference</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.modelsolv.reprezen.restapi.PrimitiveTypeSourceReference
	 * @generated
	 */
    public Adapter createPrimitiveTypeSourceReferenceAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link com.modelsolv.reprezen.restapi.URI <em>URI</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.modelsolv.reprezen.restapi.URI
	 * @generated
	 */
    public Adapter createURIAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link com.modelsolv.reprezen.restapi.URISegment <em>URI Segment</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.modelsolv.reprezen.restapi.URISegment
	 * @generated
	 */
    public Adapter createURISegmentAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link com.modelsolv.reprezen.restapi.URISegmentWithParameter <em>URI Segment With Parameter</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.modelsolv.reprezen.restapi.URISegmentWithParameter
	 * @generated
	 */
    public Adapter createURISegmentWithParameterAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link com.modelsolv.reprezen.restapi.PropertyRealization <em>Property Realization</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.modelsolv.reprezen.restapi.PropertyRealization
	 * @generated
	 */
    public Adapter createPropertyRealizationAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link com.modelsolv.reprezen.restapi.LinkRelation <em>Link Relation</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.modelsolv.reprezen.restapi.LinkRelation
	 * @generated
	 */
    public Adapter createLinkRelationAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link com.modelsolv.reprezen.restapi.WithExamples <em>With Examples</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.modelsolv.reprezen.restapi.WithExamples
	 * @generated
	 */
    public Adapter createWithExamplesAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link com.modelsolv.reprezen.restapi.Example <em>Example</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.modelsolv.reprezen.restapi.Example
	 * @generated
	 */
    public Adapter createExampleAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link com.modelsolv.reprezen.restapi.InlineExample <em>Inline Example</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.modelsolv.reprezen.restapi.InlineExample
	 * @generated
	 */
    public Adapter createInlineExampleAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link com.modelsolv.reprezen.restapi.ExternalExample <em>External Example</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.modelsolv.reprezen.restapi.ExternalExample
	 * @generated
	 */
    public Adapter createExternalExampleAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link com.modelsolv.reprezen.restapi.HasStringValue <em>Has String Value</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.modelsolv.reprezen.restapi.HasStringValue
	 * @generated
	 */
    public Adapter createHasStringValueAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link com.modelsolv.reprezen.restapi.ImportDeclaration <em>Import Declaration</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.modelsolv.reprezen.restapi.ImportDeclaration
	 * @generated
	 */
    public Adapter createImportDeclarationAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link com.modelsolv.reprezen.restapi.ObjectRealization <em>Object Realization</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.modelsolv.reprezen.restapi.ObjectRealization
	 * @generated
	 */
    public Adapter createObjectRealizationAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link com.modelsolv.reprezen.restapi.CollectionReferenceElement <em>Collection Reference Element</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.modelsolv.reprezen.restapi.CollectionReferenceElement
	 * @generated
	 */
    public Adapter createCollectionReferenceElementAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link com.modelsolv.reprezen.restapi.HasSecurityValue <em>Has Security Value</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.modelsolv.reprezen.restapi.HasSecurityValue
	 * @generated
	 */
    public Adapter createHasSecurityValueAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link com.modelsolv.reprezen.restapi.SecurityScheme <em>Security Scheme</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.modelsolv.reprezen.restapi.SecurityScheme
	 * @generated
	 */
    public Adapter createSecuritySchemeAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link com.modelsolv.reprezen.restapi.AuthenticationMethod <em>Authentication Method</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.modelsolv.reprezen.restapi.AuthenticationMethod
	 * @generated
	 */
    public Adapter createAuthenticationMethodAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link com.modelsolv.reprezen.restapi.SecurityScope <em>Security Scope</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.modelsolv.reprezen.restapi.SecurityScope
	 * @generated
	 */
    public Adapter createSecurityScopeAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link com.modelsolv.reprezen.restapi.SecuritySchemeParameter <em>Security Scheme Parameter</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.modelsolv.reprezen.restapi.SecuritySchemeParameter
	 * @generated
	 */
    public Adapter createSecuritySchemeParameterAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link com.modelsolv.reprezen.restapi.SecuritySchemeLibrary <em>Security Scheme Library</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.modelsolv.reprezen.restapi.SecuritySchemeLibrary
	 * @generated
	 */
    public Adapter createSecuritySchemeLibraryAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link com.modelsolv.reprezen.restapi.RealizationContainer <em>Realization Container</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.modelsolv.reprezen.restapi.RealizationContainer
	 * @generated
	 */
    public Adapter createRealizationContainerAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link com.modelsolv.reprezen.restapi.Extensible <em>Extensible</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.modelsolv.reprezen.restapi.Extensible
	 * @generated
	 */
    public Adapter createExtensibleAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link com.modelsolv.reprezen.restapi.Extension <em>Extension</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.modelsolv.reprezen.restapi.Extension
	 * @generated
	 */
    public Adapter createExtensionAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link com.modelsolv.reprezen.restapi.RealizationModelLocation <em>Realization Model Location</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.modelsolv.reprezen.restapi.RealizationModelLocation
	 * @generated
	 */
    public Adapter createRealizationModelLocationAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link com.modelsolv.reprezen.restapi.HasTitle <em>Has Title</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.modelsolv.reprezen.restapi.HasTitle
	 * @generated
	 */
    public Adapter createHasTitleAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link com.modelsolv.reprezen.restapi.Operation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.modelsolv.reprezen.restapi.Operation
	 * @generated
	 */
	public Adapter createOperationAdapter() {
		return null;
	}

				/**
	 * Creates a new adapter for an object of class '{@link com.modelsolv.reprezen.restapi.Feature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.modelsolv.reprezen.restapi.Feature
	 * @generated
	 */
	public Adapter createFeatureAdapter() {
		return null;
	}

				/**
	 * Creates a new adapter for an object of class '{@link com.modelsolv.reprezen.restapi.ReferenceProperty <em>Reference Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.modelsolv.reprezen.restapi.ReferenceProperty
	 * @generated
	 */
	public Adapter createReferencePropertyAdapter() {
		return null;
	}

				/**
	 * Creates a new adapter for an object of class '{@link com.modelsolv.reprezen.restapi.PrimitiveProperty <em>Primitive Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.modelsolv.reprezen.restapi.PrimitiveProperty
	 * @generated
	 */
	public Adapter createPrimitivePropertyAdapter() {
		return null;
	}

				/**
	 * Creates a new adapter for an object of class '{@link com.modelsolv.reprezen.restapi.Structure <em>Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.modelsolv.reprezen.restapi.Structure
	 * @generated
	 */
	public Adapter createStructureAdapter() {
		return null;
	}

				/**
	 * Creates a new adapter for an object of class '{@link com.modelsolv.reprezen.restapi.DataModel <em>Data Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.modelsolv.reprezen.restapi.DataModel
	 * @generated
	 */
	public Adapter createDataModelAdapter() {
		return null;
	}

				/**
	 * Creates a new adapter for an object of class '{@link com.modelsolv.reprezen.restapi.WithDataExamples <em>With Data Examples</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.modelsolv.reprezen.restapi.WithDataExamples
	 * @generated
	 */
	public Adapter createWithDataExamplesAdapter() {
		return null;
	}

				/**
	 * Creates a new adapter for an object of class '{@link com.modelsolv.reprezen.restapi.DataExample <em>Data Example</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.modelsolv.reprezen.restapi.DataExample
	 * @generated
	 */
	public Adapter createDataExampleAdapter() {
		return null;
	}

				/**
	 * Creates a new adapter for an object of class '{@link com.modelsolv.reprezen.restapi.InlineDataExample <em>Inline Data Example</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.modelsolv.reprezen.restapi.InlineDataExample
	 * @generated
	 */
	public Adapter createInlineDataExampleAdapter() {
		return null;
	}

				/**
	 * Creates a new adapter for an object of class '{@link com.modelsolv.reprezen.restapi.Constraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.modelsolv.reprezen.restapi.Constraint
	 * @generated
	 */
	public Adapter createConstraintAdapter() {
		return null;
	}

				/**
	 * Creates a new adapter for an object of class '{@link com.modelsolv.reprezen.restapi.Enumeration <em>Enumeration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.modelsolv.reprezen.restapi.Enumeration
	 * @generated
	 */
	public Adapter createEnumerationAdapter() {
		return null;
	}

				/**
	 * Creates a new adapter for an object of class '{@link com.modelsolv.reprezen.restapi.SimpleType <em>Simple Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.modelsolv.reprezen.restapi.SimpleType
	 * @generated
	 */
	public Adapter createSimpleTypeAdapter() {
		return null;
	}

				/**
	 * Creates a new adapter for an object of class '{@link com.modelsolv.reprezen.restapi.EnumConstant <em>Enum Constant</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.modelsolv.reprezen.restapi.EnumConstant
	 * @generated
	 */
	public Adapter createEnumConstantAdapter() {
		return null;
	}

				/**
	 * Creates a new adapter for an object of class '{@link com.modelsolv.reprezen.restapi.UserDefinedType <em>User Defined Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.modelsolv.reprezen.restapi.UserDefinedType
	 * @generated
	 */
	public Adapter createUserDefinedTypeAdapter() {
		return null;
	}

				/**
	 * Creates a new adapter for an object of class '{@link com.modelsolv.reprezen.restapi.PrimitiveType <em>Primitive Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.modelsolv.reprezen.restapi.PrimitiveType
	 * @generated
	 */
	public Adapter createPrimitiveTypeAdapter() {
		return null;
	}

				/**
	 * Creates a new adapter for an object of class '{@link com.modelsolv.reprezen.restapi.DataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.modelsolv.reprezen.restapi.DataType
	 * @generated
	 */
	public Adapter createDataTypeAdapter() {
		return null;
	}

				/**
	 * Creates a new adapter for an object of class '{@link com.modelsolv.reprezen.restapi.SingleValueType <em>Single Value Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.modelsolv.reprezen.restapi.SingleValueType
	 * @generated
	 */
	public Adapter createSingleValueTypeAdapter() {
		return null;
	}

				/**
	 * Creates a new adapter for an object of class '{@link com.modelsolv.reprezen.restapi.ConstrainableType <em>Constrainable Type</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.modelsolv.reprezen.restapi.ConstrainableType
	 * @generated
	 */
    public Adapter createConstrainableTypeAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link com.modelsolv.reprezen.restapi.Inheritable <em>Inheritable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.modelsolv.reprezen.restapi.Inheritable
	 * @generated
	 */
	public Adapter createInheritableAdapter() {
		return null;
	}

				/**
	 * Creates a new adapter for an object of class '{@link com.modelsolv.reprezen.restapi.MediaTypesLibrary <em>Media Types Library</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.modelsolv.reprezen.restapi.MediaTypesLibrary
	 * @generated
	 */
	public Adapter createMediaTypesLibraryAdapter() {
		return null;
	}

				/**
	 * Creates a new adapter for an object of class '{@link com.modelsolv.reprezen.restapi.LinkRelationsLibrary <em>Link Relations Library</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.modelsolv.reprezen.restapi.LinkRelationsLibrary
	 * @generated
	 */
	public Adapter createLinkRelationsLibraryAdapter() {
		return null;
	}

				/**
	 * Creates a new adapter for an object of class '{@link com.modelsolv.reprezen.restapi.PrimitiveTypesLibrary <em>Primitive Types Library</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.modelsolv.reprezen.restapi.PrimitiveTypesLibrary
	 * @generated
	 */
	public Adapter createPrimitiveTypesLibraryAdapter() {
		return null;
	}

				/**
	 * Creates a new adapter for an object of class '{@link com.modelsolv.reprezen.restapi.Element <em>Element</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.modelsolv.reprezen.restapi.Element
	 * @generated
	 */
    public Adapter createElementAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link com.modelsolv.reprezen.restapi.ReferenceElement <em>Reference Element</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.modelsolv.reprezen.restapi.ReferenceElement
	 * @generated
	 */
    public Adapter createReferenceElementAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link com.modelsolv.reprezen.restapi.LengthConstraint <em>Length Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.modelsolv.reprezen.restapi.LengthConstraint
	 * @generated
	 */
	public Adapter createLengthConstraintAdapter() {
		return null;
	}

				/**
	 * Creates a new adapter for an object of class '{@link com.modelsolv.reprezen.restapi.RegExConstraint <em>Reg Ex Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.modelsolv.reprezen.restapi.RegExConstraint
	 * @generated
	 */
	public Adapter createRegExConstraintAdapter() {
		return null;
	}

				/**
	 * Creates a new adapter for an object of class '{@link com.modelsolv.reprezen.restapi.ValueRangeConstraint <em>Value Range Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.modelsolv.reprezen.restapi.ValueRangeConstraint
	 * @generated
	 */
	public Adapter createValueRangeConstraintAdapter() {
		return null;
	}

				/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
     * This default implementation returns null.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
    public Adapter createEObjectAdapter() {
		return null;
	}

} //RestapiAdapterFactory
