/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.realization.processor;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.reprezen.rapidml.ObjectRealization;
import com.reprezen.rapidml.RapidmlFactory;
import com.reprezen.rapidml.ReferenceRealization;
import com.reprezen.rapidml.ReferenceRealizationEnum;
import com.reprezen.rapidml.ResourceAPI;
import com.reprezen.rapidml.ServiceDataResource;
import com.reprezen.rapidml.realization.model.ConditionalLink;
import com.reprezen.rapidml.realization.model.LinkSpec;
import com.reprezen.rapidml.realization.model.LinkStrategy;
import com.reprezen.rapidml.realization.model.LinkSwitch;
import com.reprezen.rapidml.realization.model.ObjectRealizationSpec;
import com.reprezen.rapidml.realization.processor.DefaultReferenceRealizationRegistry.ReferenceTreatmentDescriptor;
import com.reprezen.rapidml.util.ResourceFinder;

public class LinksProcessor {

	private final ResourceFinder resourceFinder;
	private final ResourceAPI resourceAPI;
	private final RapidmlFactory rapidmlFactory = RapidmlFactory.eINSTANCE;

	/**
	 * @param context
	 *            - context ResourceAPI, can be null
	 */
	public LinksProcessor(ResourceAPI resourceAPI) {
		resourceFinder = new ResourceFinder(resourceAPI);
		this.resourceAPI = resourceAPI;
	}

	public ResourceAPI getResourceAPI() {
		return resourceAPI;
	}

	public ReferenceRealization createDefaultReferenceRealization(ResourceAPI contextAPI,
			ReferenceTreatmentDescriptor reference) {
		boolean useReferenceLink = getDefaultResource(reference) != null;
		ReferenceRealization referenceRealization;
		if (useReferenceLink) {
			referenceRealization = createDefaultReferenceLink(contextAPI, reference);
		} else {
			referenceRealization = createDefaultReferenceEmbed(contextAPI, reference);
		}
		referenceRealization.setWithDefaultRealization(true);
		// referenceRealization.isMultiValued not used anywhere, its meaning should be
		// clarified
		// referenceRealization.setMultiValued(reference.isMultiValued());
		return referenceRealization;
	}

	public static Optional<LinkSpec> getLinkSpec(RealizationContext context,
			Optional<ObjectRealizationSpec> objectRealizationSpec) {
		if (!objectRealizationSpec.isPresent()) {
			return Optional.empty();
		}
		Collection<LinkSpec> linkSpecs = getLinkSpecs(context, objectRealizationSpec.get().getLinks());
		return Optional.ofNullable(Iterables.getFirst(linkSpecs, null));
	}

	public static Collection<LinkSpec> getLinkSpecs(RealizationContext context, Collection<LinkStrategy> links) {
		if (links.isEmpty()) {
			return Collections.emptyList();
		}
		// TODO Each LinkStrategy (except LinkSwtich) has its own appliesTo, so even
		// with multiple link strategies you
		// could end up with only one link
		List<LinkSpec> linkSpecs = Lists.newArrayList();
		for (LinkStrategy link : links) {
			linkSpecs.addAll(getLinkSpecs(context, link, new HashSet<>()));
		}
		if (linkSpecs.size() > 1) {
			// RestApiPlugin.logWarning("Multiple links are not supported yet, only the
			// first link will be processed");
		}
		return linkSpecs;
	}

	public static Collection<LinkSpec> getLinkSpecs(RealizationContext context, LinkStrategy link,
			Collection<LinkStrategy> processedLinks) {
		// guard against infinite recursion
		if (processedLinks.contains(link)) {
			// RestApiPlugin.logWarning(
			// String.format("Detected a cycle in the links hierarchy: the element %s was
			// already processed",
			// Overlay.of(link).getPathFromRoot()));
			return Collections.emptyList();
		}
		processedLinks.add(link);
		if (link instanceof LinkSpec) {
			LinkSpec linkSpec = (LinkSpec) link;
			return Collections.singleton(linkSpec);
		}
		if (link instanceof ConditionalLink) {
			ConditionalLink conditionalLink = (ConditionalLink) link;
			boolean matches = ContextMatcher.matchesAny(context, conditionalLink.getConditions(), true);
			return matches ? getLinkSpecs(context, conditionalLink.getLink(), processedLinks) : Collections.emptyList();
		}
		if (link instanceof LinkSwitch) {
			LinkSwitch linkSwitch = (LinkSwitch) link;
			Optional<ConditionalLink> matched = ContextMatcher.evalSwitch(context, linkSwitch);
			if (!matched.isPresent()) {
				return Collections.emptyList();
			}
			return getLinkSpecs(context, matched.get(), processedLinks);
		}
		// RestApiPlugin.logWarning(String.format("Unsupported Link type for '%s':
		// '%s'",
		// Overlay.of(link).getPathFromRoot(), link.getClass().getSimpleName()));
		return Collections.emptyList();
	}

	private ReferenceRealization createDefaultReferenceEmbed(ResourceAPI context,
			ReferenceTreatmentDescriptor reference) {
		ReferenceRealization referenceEmbed = ReferenceTreatmentFactory.createReferenceEmbed(context, reference);
		return referenceEmbed;
	}

	private ReferenceRealization createDefaultReferenceLink(ResourceAPI context,
			ReferenceTreatmentDescriptor reference) {
		ReferenceRealization referenceLink = rapidmlFactory.createReferenceRealization();
		referenceLink.setRealizationType(ReferenceRealizationEnum.LINK);

		referenceLink.setDataType(reference.getTargetDataType());

		ObjectRealization objectRealization = getLinkDescriptor(reference);
		if (objectRealization == null) {
			objectRealization = rapidmlFactory.createObjectRealization();
			referenceLink.setInlineObjectRealization(objectRealization);
		}

		referenceLink.setTargetResource(getDefaultResource(reference));
		// TODO move linkRelation from ReferenceTreatment to ReferenceRealization and
		// set it here
		referenceLink.setProperties(objectRealization);

		return referenceLink;
	}

	private ServiceDataResource getDefaultResource(ReferenceTreatmentDescriptor reference) {
		boolean objectNotCollection = reference.isObjectNotCollection();
		ServiceDataResource newTargetResource;
		if (!reference.isObjectNotCollection()) {
			// ZEN-3978 if a multi-valued reference does not have a corresponding collection
			// resource,
			// try to represent it as an array of hyperlinks to the corresponding object
			// resource
			newTargetResource = resourceFinder.tryFindCollectionThenObjectResource(reference.getTargetDataType());
		} else {
			newTargetResource = resourceFinder.findResource(reference.getTargetDataType(), objectNotCollection);
		}
		return newTargetResource;
	}

	private ObjectRealization getLinkDescriptor(ReferenceTreatmentDescriptor reference) {
		ServiceDataResource defaultResource = getDefaultResource(reference);
		if (defaultResource != null) {
			return defaultResource.getDefaultLinkDescriptor();
		}
		return null;
	}

}
