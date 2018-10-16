/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.modelsolv.reprezen.restapi.xtext.ui.hover;

import static com.modelsolv.reprezen.restapi.xtext.ui.hover.Messages.CONNECT;
import static com.modelsolv.reprezen.restapi.xtext.ui.hover.Messages.DELETE;
import static com.modelsolv.reprezen.restapi.xtext.ui.hover.Messages.GET;
import static com.modelsolv.reprezen.restapi.xtext.ui.hover.Messages.HEAD;
import static com.modelsolv.reprezen.restapi.xtext.ui.hover.Messages.OPTIONS;
import static com.modelsolv.reprezen.restapi.xtext.ui.hover.Messages.PATCH;
import static com.modelsolv.reprezen.restapi.xtext.ui.hover.Messages.POST;
import static com.modelsolv.reprezen.restapi.xtext.ui.hover.Messages.PUT;
import static com.modelsolv.reprezen.restapi.xtext.ui.hover.Messages.TRACE;
import static com.modelsolv.reprezen.restapi.xtext.ui.hover.Messages.URI;
import static com.modelsolv.reprezen.restapi.xtext.ui.hover.Messages.autoRealizations;
import static com.modelsolv.reprezen.restapi.xtext.ui.hover.Messages.baseURI;
import static com.modelsolv.reprezen.restapi.xtext.ui.hover.Messages.collectionParam;
import static com.modelsolv.reprezen.restapi.xtext.ui.hover.Messages.collectionResource;
import static com.modelsolv.reprezen.restapi.xtext.ui.hover.Messages.collectionResource_bound;
import static com.modelsolv.reprezen.restapi.xtext.ui.hover.Messages.collectionResource_to;
import static com.modelsolv.reprezen.restapi.xtext.ui.hover.Messages.container;
import static com.modelsolv.reprezen.restapi.xtext.ui.hover.Messages.containing;
import static com.modelsolv.reprezen.restapi.xtext.ui.hover.Messages.dataExample;
import static com.modelsolv.reprezen.restapi.xtext.ui.hover.Messages.dataModel;
import static com.modelsolv.reprezen.restapi.xtext.ui.hover.Messages.datamodel_enum;
import static com.modelsolv.reprezen.restapi.xtext.ui.hover.Messages.derivedFrom;
import static com.modelsolv.reprezen.restapi.xtext.ui.hover.Messages.example;
import static com.modelsolv.reprezen.restapi.xtext.ui.hover.Messages.externalExample;
import static com.modelsolv.reprezen.restapi.xtext.ui.hover.Messages.import_as;
import static com.modelsolv.reprezen.restapi.xtext.ui.hover.Messages.import_from;
import static com.modelsolv.reprezen.restapi.xtext.ui.hover.Messages.import_import;
import static com.modelsolv.reprezen.restapi.xtext.ui.hover.Messages.inverse;
import static com.modelsolv.reprezen.restapi.xtext.ui.hover.Messages.linkDescriptor;
import static com.modelsolv.reprezen.restapi.xtext.ui.hover.Messages.linkDescriptor_default;
import static com.modelsolv.reprezen.restapi.xtext.ui.hover.Messages.linkRelationsLibrary;
import static com.modelsolv.reprezen.restapi.xtext.ui.hover.Messages.matrixParam;
import static com.modelsolv.reprezen.restapi.xtext.ui.hover.Messages.mediaType;
import static com.modelsolv.reprezen.restapi.xtext.ui.hover.Messages.mediaTypes;
import static com.modelsolv.reprezen.restapi.xtext.ui.hover.Messages.mediaTypesLibrary;
import static com.modelsolv.reprezen.restapi.xtext.ui.hover.Messages.message_param;
import static com.modelsolv.reprezen.restapi.xtext.ui.hover.Messages.method;
import static com.modelsolv.reprezen.restapi.xtext.ui.hover.Messages.objectResource;
import static com.modelsolv.reprezen.restapi.xtext.ui.hover.Messages.objectResource_bound;
import static com.modelsolv.reprezen.restapi.xtext.ui.hover.Messages.objectResource_to;
import static com.modelsolv.reprezen.restapi.xtext.ui.hover.Messages.operation;
import static com.modelsolv.reprezen.restapi.xtext.ui.hover.Messages.parameter_default;
import static com.modelsolv.reprezen.restapi.xtext.ui.hover.Messages.parameter_fixed;
import static com.modelsolv.reprezen.restapi.xtext.ui.hover.Messages.parameter_required;
import static com.modelsolv.reprezen.restapi.xtext.ui.hover.Messages.primitiveProperty_as;
import static com.modelsolv.reprezen.restapi.xtext.ui.hover.Messages.primitiveType;
import static com.modelsolv.reprezen.restapi.xtext.ui.hover.Messages.primitiveTypesLibrary;
import static com.modelsolv.reprezen.restapi.xtext.ui.hover.Messages.primitive_type;
import static com.modelsolv.reprezen.restapi.xtext.ui.hover.Messages.property;
import static com.modelsolv.reprezen.restapi.xtext.ui.hover.Messages.propertyRestriction_restrict;
import static com.modelsolv.reprezen.restapi.xtext.ui.hover.Messages.referenceEmbed;
import static com.modelsolv.reprezen.restapi.xtext.ui.hover.Messages.referenceLink;
import static com.modelsolv.reprezen.restapi.xtext.ui.hover.Messages.referenceLink_linkRelation;
import static com.modelsolv.reprezen.restapi.xtext.ui.hover.Messages.referenceProperty;
import static com.modelsolv.reprezen.restapi.xtext.ui.hover.Messages.reference_as;
import static com.modelsolv.reprezen.restapi.xtext.ui.hover.Messages.reference_to;
import static com.modelsolv.reprezen.restapi.xtext.ui.hover.Messages.request;
import static com.modelsolv.reprezen.restapi.xtext.ui.hover.Messages.resourceAPI;
import static com.modelsolv.reprezen.restapi.xtext.ui.hover.Messages.resource_default;
import static com.modelsolv.reprezen.restapi.xtext.ui.hover.Messages.resource_type;
import static com.modelsolv.reprezen.restapi.xtext.ui.hover.Messages.response;
import static com.modelsolv.reprezen.restapi.xtext.ui.hover.Messages.response_statusCode;
import static com.modelsolv.reprezen.restapi.xtext.ui.hover.Messages.specURL;
import static com.modelsolv.reprezen.restapi.xtext.ui.hover.Messages.structure;
import static com.modelsolv.reprezen.restapi.xtext.ui.hover.Messages.structure_and;
import static com.modelsolv.reprezen.restapi.xtext.ui.hover.Messages.supertype;
import static com.modelsolv.reprezen.restapi.xtext.ui.hover.Messages.targetProperties;
import static com.modelsolv.reprezen.restapi.xtext.ui.hover.Messages.targetResource;
import static com.modelsolv.reprezen.restapi.xtext.ui.hover.Messages.templateParam;
import static com.modelsolv.reprezen.restapi.xtext.ui.hover.Messages.title;
import static com.modelsolv.reprezen.restapi.xtext.ui.hover.Messages.version;
import static com.modelsolv.reprezen.restapi.xtext.ui.hover.Messages.withAutoRealizations;
import static com.modelsolv.reprezen.restapi.xtext.ui.hover.Messages.zenModel;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.internal.text.html.HTMLPrinter;
import org.eclipse.xtext.EnumLiteralDeclaration;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ui.editor.hover.html.DefaultEObjectHoverProvider;

import com.google.common.base.Strings;
import com.google.inject.Inject;
import com.modelsolv.reprezen.restapi.Documentable;
import com.modelsolv.reprezen.restapi.Documentation;
import com.modelsolv.reprezen.restapi.xtext.services.RapidMLGrammarAccess;

/**
 * @author Konstantin Zaitsev
 * @date Oct 7, 2014
 */
@SuppressWarnings("restriction")
public class RepreZenEObjectHoverProvider extends DefaultEObjectHoverProvider {

    @Inject
    public RapidMLGrammarAccess grammarAccess;

    @Override
    protected boolean hasHover(EObject o) {
        return super.hasHover(o) || o instanceof Keyword || o instanceof Documentable
                || o instanceof EnumLiteralDeclaration;
    }

    @Override
    protected String getDocumentation(EObject o) {
        if (o instanceof Keyword) {
            return getDocumentationForKeyword((Keyword) o);
        } else if (o instanceof EnumLiteralDeclaration) {
            return getDocumentationForKeyword(((EnumLiteralDeclaration) o).getLiteral());
        } else if (o instanceof Documentable) {
            Documentation doc = ((Documentable) o).getDocumentation();
            if (doc != null && !Strings.isNullOrEmpty(doc.getText())) {
                return HTMLPrinter.convertToHTMLContent(doc.getText()).replaceAll("\\r?\\n", "<br>"); //$NON-NLS-1$//$NON-NLS-2$
            }
        }

        return super.getDocumentation(o);
    }

    public String getDocumentationForKeyword(final Keyword keyword) {
        if (grammarAccess.getZenModelAccess().getRapidModelKeyword_4_1() == keyword) {
            return zenModel;
        }
        if (grammarAccess.getZenModelAccess().getWithKeyword_7_1() == keyword
                || grammarAccess.getZenModelAccess().getTitleKeyword_7_2() == keyword) {
            return title;
        }
        if (grammarAccess.getResourceAPIAccess().getResourceAPIKeyword_3() == keyword) {
            return resourceAPI;
        }
        if (grammarAccess.getResourceAPIAccess().getBaseURIKeyword_5_1_0() == keyword) {
            return baseURI;
        }
        if (grammarAccess.getResourceAPIAccess().getVersionKeyword_5_0_0() == keyword) {
            return version;
        }
        if (grammarAccess.getResourceAPIAccess().getWithKeyword_6_1_1() == keyword
                || grammarAccess.getResourceAPIAccess().getTitleKeyword_6_1_2() == keyword) {
            return title;
        }
        if (grammarAccess.getResourceAPIAccess().getWithKeyword_6_3_1() == keyword) {
            return withAutoRealizations;
        }
        if (grammarAccess.getResourceAPIAccess().getAutoRealizationsKeyword_6_3_2() == keyword) {
            return autoRealizations;
        }
        if (grammarAccess.getObjectResourceAccess().getObjectResourceKeyword_4() == keyword) {
            return objectResource;
        }
        if (grammarAccess.getObjectResourceAccess().getBoundKeyword_6_0_0() == keyword) {
            return objectResource_bound;
        }
        if (grammarAccess.getObjectResourceAccess().getToKeyword_6_0_1() == keyword) {
            return objectResource_to;
        }
        if (grammarAccess.getCollectionResourceAccess().getCollectionResourceKeyword_4() == keyword) {
            return collectionResource;
        }
        if (grammarAccess.getCollectionResourceAccess().getBoundKeyword_6_0_0() == keyword) {
            return collectionResource_bound;
        }
        if (grammarAccess.getCollectionResourceAccess().getToKeyword_6_0_1() == keyword) {
            return collectionResource_to;
        }
        if (grammarAccess.getMethodAccess().getMethodKeyword_3() == keyword) {
            return method;
        }
        if (grammarAccess.getHTTPMethodsAccess().getPUTPUTKeyword_0_0() == keyword) {
            return PUT;
        }
        if (grammarAccess.getHTTPMethodsAccess().getPOSTPOSTKeyword_1_0() == keyword) {
            return POST;
        }
        if (grammarAccess.getHTTPMethodsAccess().getDELETEDELETEKeyword_2_0() == keyword) {
            return DELETE;
        }
        if (grammarAccess.getHTTPMethodsAccess().getHEADHEADKeyword_3_0() == keyword) {
            return HEAD;
        }
        if (grammarAccess.getHTTPMethodsAccess().getGETGETKeyword_4_0() == keyword) {
            return GET;
        }
        if (grammarAccess.getHTTPMethodsAccess().getPATCHPATCHKeyword_5_0() == keyword) {
            return PATCH;
        }
        if (grammarAccess.getHTTPMethodsAccess().getTRACETRACEKeyword_6_0() == keyword) {
            return TRACE;
        }
        if (grammarAccess.getHTTPMethodsAccess().getCONNECTCONNECTKeyword_7_0() == keyword) {
            return CONNECT;
        }
        if (grammarAccess.getHTTPMethodsAccess().getOPTIONSOPTIONSKeyword_8_0() == keyword) {
            return OPTIONS;
        }
        if (grammarAccess.getTypedResponseAccess().getStatusCodeKeyword_7_0() == keyword
                || grammarAccess.getTypedErrorResponseAccess().getStatusCodeKeyword_4() == keyword) {
            return response_statusCode;
        }

        if (grammarAccess.getCollectionResourceAccess().getDefaultDefaultKeyword_3_0() == keyword
                || grammarAccess.getObjectResourceAccess().getDefaultDefaultKeyword_3_0() == keyword) {
            return resource_default;
        }
        if (grammarAccess.getCollectionResourceAccess().getTypeKeyword_6_1() == keyword
                || grammarAccess.getObjectResourceAccess().getTypeKeyword_6_1() == keyword) {
            return resource_type;
        }
        if (grammarAccess.getCollectionResourceAccess().getURIKeyword_7_1_1() == keyword
                || grammarAccess.getObjectResourceAccess().getURIKeyword_7_1_1() == keyword) {
            return URI;
        }
        if (grammarAccess.getCollectionResourceAccess().getMediaTypesKeyword_7_3_4_1() == keyword
                || grammarAccess.getObjectResourceAccess().getMediaTypesKeyword_7_3_3_1() == keyword
                || grammarAccess.getTypedRequestAccess().getMediaTypesKeyword_7_1_2_1() == keyword
                || grammarAccess.getTypedResponseAccess().getMediaTypesKeyword_8_1_2_1() == keyword) {
            return mediaTypes;
        }

        if (grammarAccess.getTypedRequestAccess().getRequestKeyword_3() == keyword) {
            return request;
        }
        if (grammarAccess.getTypedResponseAccess().getResponseKeyword_3() == keyword
                || grammarAccess.getTypedErrorResponseAccess().getErrorResponseKeyword_3() == keyword) {
            return response;
        }
        // interface data model
        if (grammarAccess.getDataModelAccess().getDataModelKeyword_3() == keyword) {
            return dataModel;
        }
        if (grammarAccess.getDataModelAccess().getWithKeyword_6_1() == keyword
                || grammarAccess.getDataModelAccess().getTitleKeyword_6_2() == keyword) {
            return title;
        }
        if (grammarAccess.getStructureAccess().getStructureKeyword_3() == keyword) {
            return structure;
        }
        
        if (grammarAccess.getStructureAccess().getExtendsKeyword_5_0() == keyword) {
            return supertype;
        } 
        if (grammarAccess.getStructureAccess().getAndKeyword_5_2_1() == keyword) {
            return structure_and;
        }
        if (grammarAccess.getPrimitivePropertyAccess().getRestrictionRestrictKeyword_3_0() == keyword
                || grammarAccess.getReferencePropertyAccess().getRestrictionRestrictKeyword_2_0() == keyword) {
            return propertyRestriction_restrict;
        }
        if (grammarAccess.getPrimitivePropertyAccess().getToKeyword_6_0() == keyword
                || grammarAccess.getPrimitivePropertyAccess().getAsKeyword_6_1() == keyword) {
            return primitiveProperty_as;
        }
        if (grammarAccess.getPrimitivePropertyAccess().getReadOnlyReadOnlyKeyword_7_0() == keyword) {
            return Messages.primitiveProperty_readOnly;
        }
        if (grammarAccess.getPrimitivePropertyAccess().getKeyKeyKeyword_8_0() == keyword) {
            return Messages.primitiveProperty_key;
        }     
        if (grammarAccess.getEnumerationAccess().getEnumKeyword_3() == keyword) {
            return datamodel_enum;
        }

        if (grammarAccess.getReferencePropertyAccess().getReferenceKeyword_6_0_1_0() == keyword
                || grammarAccess.getReferencePropertyAccess().getReferenceKeyword_6_1_0() == keyword) {
            return referenceProperty;
        }
        if (grammarAccess.getReferencePropertyAccess().getContainmentContainingKeyword_6_0_0_0_0() == keyword) {
            return containing;
        }

        if (grammarAccess.getReferencePropertyAccess().getContainerContainerKeyword_6_0_0_1_0() == keyword) {
            return container;
        }
        if (grammarAccess.getPropertyReferenceAccess().getPropertyKeyword_2() == keyword) {
            return property;
        }

        // parameters
        if (grammarAccess.getMessageParameterAccess().getRequiredRequiredKeyword_3_0() == keyword
                || grammarAccess.getCollectionParameterAccess().getRequiredRequiredKeyword_3_0() == keyword
                || grammarAccess.getMatrixParameterAccess().getRequiredRequiredKeyword_3_0() == keyword
                || grammarAccess.getTemplateParameterAccess().getRequiredRequiredKeyword_3_0() == keyword) {
            return parameter_required;
        }
        if (grammarAccess.getMessageParameterAccess().getParamKeyword_4() == keyword) {
            return message_param;
        }
        if (grammarAccess.getCollectionParameterAccess().getCollectionParamKeyword_4() == keyword) {
            return collectionParam;
        }
        if (grammarAccess.getMatrixParameterAccess().getMatrixParamKeyword_4() == keyword) {
            return matrixParam;
        }
        if (grammarAccess.getTemplateParameterAccess().getTemplateParamKeyword_4() == keyword) {
            return templateParam;
        }

        if (grammarAccess.getMessageParameterAccess().getDefaultKeyword_8_2_0_0() == keyword
                || grammarAccess.getCollectionParameterAccess().getDefaultKeyword_7_2_0_0() == keyword
                || grammarAccess.getMatrixParameterAccess().getDefaultKeyword_7_2_0_0() == keyword
                || grammarAccess.getTemplateParameterAccess().getDefaultKeyword_7_2_0_0() == keyword) {
            return parameter_default;
        }
        if (grammarAccess.getMessageParameterAccess().getFixedKeyword_8_2_1_0() == keyword
                || grammarAccess.getCollectionParameterAccess().getFixedKeyword_7_2_1_0() == keyword
                || grammarAccess.getMatrixParameterAccess().getFixedKeyword_7_2_1_0() == keyword
                || grammarAccess.getTemplateParameterAccess().getFixedKeyword_7_2_1_0() == keyword) {
            return parameter_fixed;
        }

        // import
        if (grammarAccess.getImportAccess().getImportKeyword_0() == keyword) {
            return import_import;
        }
        if (grammarAccess.getImportAccess().getAsKeyword_4_0() == keyword) {
            return import_as;
        }
        if (grammarAccess.getImportAccess().getFromKeyword_2() == keyword) {
            return import_from;
        }

        if (grammarAccess.getPrimitiveTypeSourceReferenceAccess().getTypeKeyword_2() == keyword) {
            return primitive_type;
        }

        if (grammarAccess.getInlineExampleAccess().getExampleKeyword_2() == keyword) {
            return example;
        }
        if (grammarAccess.getExternalExampleAccess().getExternalExampleKeyword_2() == keyword) {
            return externalExample;
        }
        if (grammarAccess.getInlineDataExampleAccess().getDataExampleKeyword_2() == keyword) {
            return dataExample;
        }

        if (grammarAccess.getReferenceEmbedAccess().getReferenceEmbedKeyword_2() == keyword) {
            return referenceEmbed;
        }

        // reference link
        if (grammarAccess.getReferenceLinkAccess().getReferenceLinkKeyword_2() == keyword) {
            return referenceLink;
        }
        if (grammarAccess.getReferenceLinkRealizationAccess().getTargetResourceKeyword_1_1() == keyword) {
            return targetResource;
        }
        if (grammarAccess.getReferenceLinkRealizationAccess().getLinkDescriptorKeyword_2_1_1() == keyword
                || grammarAccess.getNamedLinkDescriptorAccess().getLinkDescriptorKeyword_3() == keyword) {
            return linkDescriptor;
        }
        if (grammarAccess.getReferenceLinkAccess().getLinkRelationKeyword_5_2_1() == keyword
                || grammarAccess.getLinkRelationAccess().getLinkRelationKeyword_3() == keyword) {
            return referenceLink_linkRelation;
        }

        if (grammarAccess.getAnonimousLinkDescriptorAccess().getTargetPropertiesKeyword_2() == keyword) {
            return targetProperties;
        }
        if (grammarAccess.getNamedLinkDescriptorAccess().getDefaultDefaultKeyword_2_0() == keyword) {
            return linkDescriptor_default;
        }
        if (grammarAccess.getReferencePropertyAccess().getAsKeyword_5() == keyword) {
            return reference_as;
        }
        if (grammarAccess.getReferencePropertyAccess().getToKeyword_6_1_1() == keyword
                || grammarAccess.getReferencePropertyAccess().getToKeyword_6_0_1_1() == keyword) {
            return reference_to;
        }
        if (grammarAccess.getReferencePropertyAccess().getInverseKeyword_9_0() == keyword) {
            return inverse;
        }

        if (grammarAccess.getPrimitiveTypesLibraryAccess().getPrimitiveTypesLibraryKeyword_2() == keyword) {
            return primitiveTypesLibrary;
        }

        if (grammarAccess.getPrimitiveTypeAccess().getPrimitiveTypeKeyword_2() == keyword) {
            return primitiveType;
        }

        if (grammarAccess.getOperationAccess().getOperationKeyword_3() == keyword) {
            return operation;
        }

        if (grammarAccess.getMediaTypesLibraryAccess().getMediaTypesLibraryKeyword_2() == keyword) {
            return mediaTypesLibrary;
        }
        if (grammarAccess.getMediaTypeAccess().getMediaTypeKeyword_3() == keyword) {
            return mediaType;
        }
        if (grammarAccess.getMediaTypeAccess().getSpecURLKeyword_5_1_1() == keyword
                || grammarAccess.getLinkRelationAccess().getSpecURLKeyword_5_0() == keyword) {
            return specURL;
        }
        if (grammarAccess.getMediaTypeAccess().getDerivedFromKeyword_5_2_1() == keyword) {
            return derivedFrom;
        }

        if (grammarAccess.getLinkRelationsLibraryAccess().getLinkRelationsLibraryKeyword_2() == keyword) {
            return linkRelationsLibrary;
        }
        if (grammarAccess.getIncludedPropertiesAccess().getWithKeyword_2_1_0() == keyword
                || grammarAccess.getIncludedPropertiesAccess().getWithKeyword_2_0_0() == keyword) {
            return Messages.includedProperties_with;
        }
        if (grammarAccess.getIncludedPropertiesAccess().getAllKeyword_2_1_1() == keyword) {
            return Messages.includedProperties_all;
        }
        if (grammarAccess.getIncludedPropertiesAccess().getPropertiesKeyword_2_1_2() == keyword
                || grammarAccess.getIncludedPropertiesAccess().getPropertiesKeyword_2_0_2() == keyword) {
            return Messages.includedProperties_properties;
        }
        if (grammarAccess.getIncludedPropertiesAccess().getOnlyKeyword_2_0_1() == keyword) {
            return Messages.includedProperies_only;
        }
        if (grammarAccess.getIncludedPropertiesAccess().getIncludingKeyword_2_1_3_1() == keyword) {
            return Messages.includedProperies_including;
        }
        if (grammarAccess.getIncludedPropertiesAccess().getExcludingKeyword_2_1_4_1() == keyword) {
            return Messages.includedProperies_excluding;
        }

        if (grammarAccess.getTypedRequestAccess().getUseParentTypeReferenceThisKeyword_5_0() == keyword
                || grammarAccess.getTypedResponseAccess().getUseParentTypeReferenceThisKeyword_5_0() == keyword) {
            return Messages.typedMessage_this;
        }
        if (grammarAccess.getTypedRequestAccess().getWithKeyword_4() == keyword
                || grammarAccess.getTypedResponseAccess().getWithKeyword_4() == keyword) {
            return Messages.typedMessage_with;
        }
        if (grammarAccess.getTypedRequestAccess().getResourceKeyword_6_0_0() == keyword
                || grammarAccess.getTypedResponseAccess().getResourceKeyword_6_0_0() == keyword) {
            return Messages.typedMessage_resource;
        }
        if (grammarAccess.getTypedRequestAccess().getTypeKeyword_6_1_0() == keyword
                || grammarAccess.getTypedResponseAccess().getTypeKeyword_6_1_0() == keyword) {
            return Messages.typedMessage_type;
        }
        if (grammarAccess.getUserDefinedTypeAccess().getSimpleTypeKeyword_3() == keyword) {
            return Messages.simpletype_simpleType;
        }
        if (grammarAccess.getUserDefinedTypeAccess().getDefinedKeyword_5() == keyword) {
            return Messages.simpletype_defined;
        }
        if (grammarAccess.getUserDefinedTypeAccess().getAsKeyword_6() == keyword) {
            return Messages.simpletype_as;
        }
        if (grammarAccess.getRegExConstraintAccess().getMatchingKeyword_2() == keyword) {
            return Messages.regex_matching;
        }
        if (grammarAccess.getRegExConstraintAccess().getRegexKeyword_3() == keyword) {
            return Messages.regex_regex;
        }
        if (grammarAccess.getLengthConstraintAccess().getOfKeyword_2() == keyword) {
            return Messages.length_of;
        }
        if (grammarAccess.getLengthConstraintAccess().getLengthKeyword_3() == keyword) {
            return Messages.length_length;
        }
        if (grammarAccess.getLengthConstraintAccess().getFromKeyword_4_0_0_0() == keyword) {
            return Messages.length_from;
        }
        if (grammarAccess.getLengthConstraintAccess().getMinimumKeyword_4_0_0_1() == keyword) {
            return Messages.length_minimum;
        }
        if (grammarAccess.getLengthConstraintAccess().getUpKeyword_4_0_1_0() == keyword) {
            return Messages.length_up;
        }
        if (grammarAccess.getLengthConstraintAccess().getToKeyword_4_0_1_1() == keyword) {
            return Messages.length_to;
        }
        if (grammarAccess.getLengthConstraintAccess().getMaximumKeyword_4_0_1_2() == keyword) {
            return Messages.length_maximum;
        }
        if (grammarAccess.getValueRangeConstraintAccess().getWithKeyword_2() == keyword) {
            return Messages.valueRange_with;
        }
        if (grammarAccess.getValueRangeConstraintAccess().getValueRangeKeyword_3() == keyword) {
            return Messages.valueRange_valueRange;
        }
        if (grammarAccess.getValueRangeConstraintAccess().getFromKeyword_4_0() == keyword) {
            return Messages.valueRange_from;
        }
        if (grammarAccess.getValueRangeConstraintAccess().getInclusiveKeyword_4_3_0() == keyword) {
            return Messages.valueRange_minimum_inclusive;
        }
        if (grammarAccess.getValueRangeConstraintAccess().getInclusiveKeyword_5_4_0() == keyword) {
            return Messages.valueRange_maximum_inclusive;
        }
        if (grammarAccess.getValueRangeConstraintAccess().getUpKeyword_5_0() == keyword) {
            return Messages.valueRange_up;
        }
        if (grammarAccess.getValueRangeConstraintAccess().getToKeyword_5_1() == keyword) {
            return Messages.valueRange_to;
        }
        if (grammarAccess.getValueRangeConstraintAccess().getMinimumKeyword_4_1() == keyword) {
            return Messages.valueRange_minimum;
        }
        if (grammarAccess.getValueRangeConstraintAccess().getMaximumKeyword_5_2() == keyword) {
            return Messages.valueRange_maximum;
        }
        if (grammarAccess.getValueRangeConstraintAccess().getMinValueExclusiveExclusiveKeyword_4_3_1_0() == keyword) {
            return Messages.valueRange_minimum_exclusive;
        }
        if (grammarAccess.getValueRangeConstraintAccess().getMaxValueExclusiveExclusiveKeyword_5_4_1_0() == keyword) {
            return Messages.valueRange_maximum_exclusive;
        }
        // security scheme related
        if (grammarAccess.getResourceAPIAccess().getSecuredKeyword_6_2_1() == keyword
                || grammarAccess.getObjectResourceAccess().getSecuredKeyword_7_2_1() == keyword
                || grammarAccess.getCollectionResourceAccess().getSecuredKeyword_7_2_1() == keyword
                || grammarAccess.getMethodAccess().getSecuredKeyword_6_1_1() == keyword) {
            return Messages.securedBy;
        }

        if (grammarAccess.getResourceAPIAccess().getByKeyword_6_2_2() == keyword
                || grammarAccess.getObjectResourceAccess().getByKeyword_7_2_2() == keyword
                || grammarAccess.getCollectionResourceAccess().getByKeyword_7_2_2() == keyword
                || grammarAccess.getMethodAccess().getByKeyword_6_1_2() == keyword) {
            return Messages.securedBy_by;
        }

        if (grammarAccess.getAuthenticationMethodAccess().getForKeyword_3_2_1()== keyword) {
            return Messages.authenticationMethod_for;
        }
        if (grammarAccess.getSecuritySchemeAccess().getRequiresKeyword_13() == keyword) {
            return Messages.securityScheme_requires;
        }
        if (grammarAccess.getSecuritySchemeAccess().getDefinesKeyword_22_1() == keyword) {
            return Messages.securityScheme_defines;
        }
        if (grammarAccess.getAuthenticationMethodAccess().getAuthorizedKeyword_3_2_0() == keyword
                || grammarAccess.getAuthenticationMethodAccess().getScopesKeyword_3_3() == keyword) {
            return Messages.using_scopes;
        }
        if (grammarAccess.getSecuritySchemeAccess().getUsesKeyword_23_1() == keyword) {
            return Messages.SecurityScheme_uses;
        }
        if (grammarAccess.getSecuritySchemeAccess().getFlowKeyword_23_2() == keyword) {
            return Messages.SecurityScheme_flow;
        }
        if (grammarAccess.getAuthenticationFlowsAccess().getIMPLICITIMPLICITKeyword_0_0() == keyword) {
            return Messages.AuthenticationFlow_Implicit;
        }
        if (grammarAccess.getAuthenticationFlowsAccess().getPASSWORDPASSWORDKeyword_1_0() == keyword) {
            return Messages.AuthenticationFlow_Password;
        }
        if (grammarAccess.getAuthenticationFlowsAccess().getAPPLICATIONAPPLICATIONKeyword_2_0() == keyword) {
            return Messages.AuthenticationFlow_Application;
        }
        if (grammarAccess.getAuthenticationFlowsAccess().getACCESS_CODEACCESS_CODEKeyword_3_0() == keyword) {
            return Messages.AuthenticationFlow_AccessCode;
        }            
        if (grammarAccess.getSecuritySchemeLibraryAccess().getSecuritySchemesLibraryKeyword_3() == keyword) {
            return Messages.securitySchemeLibrary;
        }
        if (grammarAccess.getSecuritySchemeAccess().getSecuritySchemeKeyword_3() == keyword) {
            return Messages.securityScheme;
        }
        if (grammarAccess.getSecuritySchemeAccess().getTypeKeyword_7() == keyword) {
            return Messages.securityScheme_type;
        }
        if (grammarAccess.getSecuritySchemeAccess().getMethodInvocationKeyword_10() == keyword) {
            return Messages.securityScheme_methodInvocation;
        }
        if (grammarAccess.getSecuritySchemeAccess().getAuthorizationKeyword_14() == keyword) {
            return Messages.securityScheme_authorization;
        }
        if (grammarAccess.getSecuritySchemeAccess().getSettingsKeyword_24_1()== keyword) {
            return Messages.securityScheme_settings;
        }
        if (grammarAccess.getSecuritySchemeAccess().getScopesKeyword_22_2() == keyword) {
            return Messages.securityScheme_scopes;
        }
        if (grammarAccess.getAuthenticationTypeAccess().getBASICBasicKeyword_0_0() == keyword) {
            return Messages.securityScheme_type_Basic;
        }
        if (grammarAccess.getAuthenticationTypeAccess().getOAUTH2Oauth2Keyword_1_0() == keyword) {
            return Messages.securityScheme_type_OAuth2;
        }
        if (grammarAccess.getAuthenticationTypeAccess().getCUSTOMCustomKeyword_2_0() == keyword) {
            return Messages.securityScheme_type_Custom;
        }
        if (grammarAccess.getMessageParameterAccess().getLocatedKeyword_7_0() == keyword
                || grammarAccess.getMessageParameterAccess().getInKeyword_7_1() == keyword
                || grammarAccess.getPropertyReferenceAccess().getBoundKeyword_1_0() == keyword
                || grammarAccess.getPropertyReferenceAccess().getToKeyword_1_1() == keyword
                || grammarAccess.getPrimitiveTypeSourceReferenceAccess().getOfKeyword_1() == keyword
                || grammarAccess.getHttpMessageParameterLocationAccess().getHEADERHeaderKeyword_0_0() == keyword
                || grammarAccess.getHttpMessageParameterLocationAccess().getQUERYQueryKeyword_1_0() == keyword) {
            return "'" + keyword.getValue() + "'"; //$NON-NLS-1$ //$NON-NLS-2$
        }
        if (grammarAccess.getMethodAccess().getExtensionsKeyword_6_4_1() == keyword
                || grammarAccess.getObjectResourceAccess().getExtensionsKeyword_7_4_1() == keyword
                || grammarAccess.getCollectionResourceAccess().getExtensionsKeyword_7_4_1() == keyword
                || grammarAccess.getResourceAPIAccess().getExtensionsKeyword_6_7_1() == keyword
                || grammarAccess.getZenModelAccess().getExtensionsKeyword_8_1() == keyword
                || grammarAccess.getTypedRequestAccess().getExtensionsKeyword_7_2_1() == keyword
                || grammarAccess.getTypedResponseAccess().getExtensionsKeyword_8_2_1() == keyword
                || grammarAccess.getReferenceEmbedAccess().getExtensionsKeyword_5_2_1() == keyword
                || grammarAccess.getReferenceLinkAccess().getExtensionsKeyword_5_3_1() == keyword
                || grammarAccess.getStructureAccess().getExtensionsKeyword_6_4_1() == keyword
                || grammarAccess.getReferencePropertyAccess().getExtensionsKeyword_10_1_1() == keyword
                || grammarAccess.getPrimitivePropertyAccess().getExtensionsKeyword_11_2_1() == keyword
                || grammarAccess.getEnumerationAccess().getExtensionsKeyword_8_1() == keyword
                || grammarAccess.getUserDefinedTypeAccess().getExtensionsKeyword_8_2_1() == keyword
                || grammarAccess.getMediaTypeAccess().getExtensionsKeyword_5_3_1() == keyword
                || grammarAccess.getMessageParameterAccess().getExtensionsKeyword_8_3_1() == keyword
                || grammarAccess.getTemplateParameterAccess().getExtensionsKeyword_7_3_1() == keyword
                || grammarAccess.getCollectionParameterAccess().getExtensionsKeyword_7_3_1() == keyword
                || grammarAccess.getMatrixParameterAccess().getExtensionsKeyword_7_3_1() == keyword
                || grammarAccess.getSecuritySchemeAccess().getExtensionsKeyword_25_1() == keyword//
        ) {
            return Messages.method_tags;
        }

        return keyword.getValue();
    }
}
