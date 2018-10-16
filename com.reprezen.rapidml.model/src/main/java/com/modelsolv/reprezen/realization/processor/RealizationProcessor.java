/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.modelsolv.reprezen.realization.processor;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

import com.modelsolv.reprezen.realization.model.RealizationRule;
import com.modelsolv.reprezen.restapi.CollectionRealizationEnum;
import com.modelsolv.reprezen.restapi.CollectionReferenceElement;
import com.modelsolv.reprezen.restapi.CollectionResource;
import com.modelsolv.reprezen.restapi.Extension;
import com.modelsolv.reprezen.restapi.Method;
import com.modelsolv.reprezen.restapi.ObjectRealization;
import com.modelsolv.reprezen.restapi.ObjectResource;
import com.modelsolv.reprezen.restapi.RealizationContainer;
import com.modelsolv.reprezen.restapi.ReferenceLink;
import com.modelsolv.reprezen.restapi.ReferenceTreatment;
import com.modelsolv.reprezen.restapi.ResourceAPI;
import com.modelsolv.reprezen.restapi.ResourceDefinition;
import com.modelsolv.reprezen.restapi.RestapiFactory;
import com.modelsolv.reprezen.restapi.ServiceDataResource;
import com.modelsolv.reprezen.restapi.TypedMessage;
import com.modelsolv.reprezen.restapi.ReferenceProperty;
import com.modelsolv.reprezen.restapi.Structure;
import com.modelsolv.reprezen.restapi.datatypes.util.ReferenceTreatmentOperations;
import com.modelsolv.reprezen.restapi.util.ResourceFinder;
import com.modelsolv.reprezen.restapi.util.RestapiModelUtils;
import com.modelsolv.reprezen.restapi.util.TagUtils;
import com.reprezen.jsonoverlay.Overlay;

public class RealizationProcessor {
    private final ReferenceTreatmentNormalizer referenceTreatmentNormalizer;
    private final ResourceFinder resourceFinder;
    private final RestapiFactory restapiFactory = RestapiFactory.eINSTANCE;

    private final IRealizationProcessor autoRealizationProcessor;
    private final ResourceAPI resourceAPI;

    public RealizationProcessor(ResourceAPI resourceAPI) {
        this.resourceAPI = resourceAPI;
        boolean withAutoRealizations = !resourceAPI.getAutoRealizations().isEmpty();
        if (withAutoRealizations) {
            autoRealizationProcessor = new AutoRealizationProcessor();
        } else {
            autoRealizationProcessor = new DefaultRealizationProcessor(resourceAPI);
        }
        resourceFinder = new ResourceFinder(resourceAPI);
        referenceTreatmentNormalizer = new ReferenceTreatmentNormalizer(resourceAPI);
    }

    public void generateAutoRealizations() {
        for (ResourceDefinition resource : resourceAPI.getOwnedResourceDefinitions()) {
            processResource(resource);
            for (Method method : resource.getMethods()) {
                processMessage(method.getRequest());
                for (TypedMessage message : method.getResponses()) {
                    processMessage(message);
                }
            }
        }
    }

    public IRealizationProcessor getRealizationProcessor() {
        return autoRealizationProcessor;
    }

    protected void processMessage(TypedMessage message) {
        if (message.getActualType() == null) {
            // no realization processing required for a dataless message
            return;
        }
        maybeSetWithDefaultRealization(message);
        if (message.getResourceType() instanceof ServiceDataResource // instanceof also checks for non-null
                && ((ServiceDataResource) message.getResourceType()).isWithDefaultRealization()) {
            message.setWithDefaultRealization(true);
            message.setEffectiveRealization(
                    ((ServiceDataResource) message.getResourceType()).getEffectiveRealization());
        }
        if (message.getResourceType() != null) {
            // should re-use realization of the resource
            return;
        }
        if (message.isWithDefaultRealization()) {
            RealizationRule rule = autoRealizationProcessor.processMessage(message);
            if (rule != null) {
                storeAutoRealization(message).accept(rule);
            }
        }
        if (message.getActualType() != null) {
            referenceTreatmentNormalizer.normalizeUserDefinedReferenceTreatments(message, message.getActualType());
        }
        processNestedReferenceTreatments(message, message);
    }

    protected void processResource(ResourceDefinition resource) {
        if (resource instanceof ObjectResource) {
            processObjectResource((ObjectResource) resource);
        } else if (resource instanceof CollectionResource) {
            processCollectionResource((CollectionResource) resource);
        }
    }

    protected void processObjectResource(ObjectResource objectResource) {
        maybeSetWithDefaultRealization(objectResource);
        if (!objectResource.isDefault()) {
            referenceTreatmentNormalizer.normalizeUserDefinedReferenceTreatments(objectResource,
                    objectResource.getDataType());
        }

        if (objectResource.isWithDefaultRealization()) {
            RealizationRule rule = autoRealizationProcessor.processObjectResource(objectResource);
            if (rule != null) {
                storeAutoRealization(objectResource).accept(rule);
            }
        }

        processNestedReferenceTreatments(objectResource, objectResource);
    }

    protected void processCollectionResource(CollectionResource collectionResource) {
        maybeSetWithDefaultRealization(collectionResource);

        RealizationRule rule = null;
        if (collectionResource.isWithDefaultRealization()) {
            rule = autoRealizationProcessor.processCollectionResource(collectionResource);
            if (rule != null) {
                storeAutoRealization(collectionResource).accept(rule);
            }
        }

        // This sets collectionResource.getResourceRealizationKind()
        boolean hasRealizationRule = rule != null;
        generateImplicitCollectionLinks(collectionResource, hasRealizationRule);
        boolean isReferenceLinkList = collectionResource
                .getResourceRealizationKind() == CollectionRealizationEnum.REFERENCE_LINK_LIST;
        if (!isReferenceLinkList) {
            processNestedReferenceTreatments(collectionResource, collectionResource);
            if (!collectionResource.isDefault()) {
                referenceTreatmentNormalizer.normalizeUserDefinedReferenceTreatments(collectionResource,
                        collectionResource.getDataType());
            }
        }
    }

    protected void processNestedReferenceTreatments(RealizationContainer realizationContainer,
            RealizationContainer contextResourceOrMessage) {
        // check for cycles with the enabled registry
        String markerName = "gen-auto-realization";
        if (TagUtils.hasTagWithName(realizationContainer, markerName)) {
            // already processed
            return;
        }

        TagUtils.addTag(realizationContainer, markerName);
        if (realizationContainer.getActualType() != null) {
            Structure type = realizationContainer.getActualType();
            Stream<ReferenceProperty> implicitReferenceTreatments = type.getReferenceProperties().stream() //
                    .filter(isIncluded(realizationContainer.getProperties()).and(isNotDefined(realizationContainer)));
            implicitReferenceTreatments //
                    .forEach(reference -> {
                        try {
                            processReferenceProperty(reference, contextResourceOrMessage)//
                                    .ifPresent(referenceTreatment -> {
                                        realizationContainer.getReferenceTreatments().add(referenceTreatment);
                                    });
                        } catch (Exception e) {
                            // TODO
                            // RestApiPlugin.logWarning("Cannot find AutoRealization for " + reference.getName(), e);
                        }

                    });
        }

        realizationContainer.getReferenceTreatments().stream()//
                // .filter(ReferenceEmbed.class::isInstance)//
                .map(ReferenceTreatmentFactory::maybeSetReferenceRealization) //
                // process nested reference embeds of all default and user-defined reference treatments
                .forEach(e -> processNestedReferenceTreatments(e.getReferenceRealization(), contextResourceOrMessage));
    }

    protected Optional<ReferenceTreatment> processReferenceProperty(ReferenceProperty reference,
            RealizationContainer contextResourceOrMessage) {
        ReferenceTreatment referenceTreatment;
        if (contextResourceOrMessage instanceof ServiceDataResource) {
            referenceTreatment = autoRealizationProcessor.processReferenceProperty(reference,
                    (ServiceDataResource) contextResourceOrMessage);
        } else {
            referenceTreatment = autoRealizationProcessor.processReferenceProperty(reference,
                    (TypedMessage) contextResourceOrMessage);
        }
        return Optional.ofNullable(referenceTreatment);
    }

    private void generateImplicitCollectionLinks(CollectionResource serviceDataResource, boolean hasRealizationRule) {
        ServiceDataResource targetResource = resourceFinder.findResource(serviceDataResource.getDataType(), true);
        boolean useReferenceLinkList = targetResource != null && serviceDataResource.isWithDefaultRealization()
                && !hasRealizationRule;
        serviceDataResource
                .setResourceRealizationKind(useReferenceLinkList ? CollectionRealizationEnum.REFERENCE_LINK_LIST
                        : CollectionRealizationEnum.EMBEDDED_OBJECT_LIST);
        if (useReferenceLinkList) {
            ReferenceLink hyperlink = restapiFactory.createReferenceLink();
            ReferenceTreatmentFactory.maybeSetReferenceRealization(hyperlink);
            hyperlink.getReferenceRealization().setTargetResource(targetResource);
            serviceDataResource.getReferenceTreatments().add(hyperlink);
            if (targetResource.getDefaultLinkDescriptor() != null) {
                hyperlink.getReferenceRealization().setProperties(targetResource.getDefaultLinkDescriptor());
            } else {
                ObjectRealization linkDescriptor = restapiFactory.createObjectRealization();
                // set container
                hyperlink.getReferenceRealization().setInlineObjectRealization(linkDescriptor);
                // Set by ReferenceTreatmentInlineLinkDescriptorProcessor for user-defined link descriptors
                hyperlink.getReferenceRealization().setProperties(linkDescriptor);
            }
            CollectionReferenceElement collectionReferenceElement = restapiFactory.createCollectionReferenceElement();
            collectionReferenceElement.setCardinality(new int[] { 0, -1 });
            collectionReferenceElement.setDataType(serviceDataResource.getDataType());

            hyperlink.setReferenceElement(collectionReferenceElement);
            serviceDataResource.getReferenceElements().add(collectionReferenceElement);
        }
    }

    private void maybeSetWithDefaultRealization(RealizationContainer realizationContainer) {
        if (realizationContainer.getReferenceTreatments().isEmpty()
                && realizationContainer.getInlineObjectRealization() == null) {
            // Used by JSON Schema generator
            realizationContainer.setWithDefaultRealization(true);
        }
    }

    private Consumer<RealizationRule> storeAutoRealization(RealizationContainer container) {
        return (rule) -> {
            String templateName = Overlay.of(rule).getPathInParent();
            if (templateName != null) {
                Extension tag = TagUtils.addTag(container, TagUtils.REALIZATION_TEMPLATE_NAME);
                tag.setValue(templateName);
            }
        };
    }

    private static Predicate<ReferenceProperty> isIncluded(ObjectRealization includedProperties) {
        return property -> RestapiModelUtils.isFeatureIncluded(includedProperties, property);
    }

    private static Predicate<ReferenceProperty> isNotDefined(RealizationContainer realization) {
        return property -> realization.getReferenceTreatments().stream() //
                .noneMatch(ReferenceTreatmentOperations.treatsReferenceProperty(property));
    }

    public interface IRealizationProcessor {
        RealizationRule processMessage(TypedMessage message);

        RealizationRule processObjectResource(ObjectResource objectResource);

        RealizationRule processCollectionResource(CollectionResource collectionResource);

        ReferenceTreatment processReferenceProperty(ReferenceProperty reference, TypedMessage contextMessage);

        ReferenceTreatment processReferenceProperty(ReferenceProperty reference, ServiceDataResource contextResource);
    }

}
