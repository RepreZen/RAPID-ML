/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.realization.processor;

import static com.reprezen.rapidml.realization.processor.ReferenceTreatmentFactory.isDefailtRealization;
import static com.reprezen.rapidml.realization.processor.ReferenceTreatmentFactory.markWithDefaultRealization;
import static com.reprezen.rapidml.realization.processor.ReferenceTreatmentFactory.maybeSetReferenceRealization;
import static com.reprezen.rapidml.datatypes.util.ReferenceTreatmentOperations.hasDeclaredType;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.google.common.collect.Lists;
import com.reprezen.rapidml.CollectionReferenceElement;
import com.reprezen.rapidml.NamedLinkDescriptor;
import com.reprezen.rapidml.RealizationContainer;
import com.reprezen.rapidml.ReferenceEmbed;
import com.reprezen.rapidml.ReferenceLink;
import com.reprezen.rapidml.ReferenceTreatment;
import com.reprezen.rapidml.ResourceAPI;
import com.reprezen.rapidml.ServiceDataResource;
import com.reprezen.rapidml.ReferenceElement;
import com.reprezen.rapidml.Structure;
import com.reprezen.rapidml.util.TagUtils;

public class ReferenceTreatmentNormalizer {

    private final ResourceAPI contextAPI;

    public ReferenceTreatmentNormalizer(ResourceAPI contextAPI) {
        this.contextAPI = contextAPI;
    }

    public void normalizeUserDefinedReferenceTreatments(final RealizationContainer realization, Structure type) {
        removeInvalidTreatments(realization.getReferenceTreatments());

        realization.getReferenceTreatments().stream().//
                filter(ReferenceLink.class::isInstance)//
                .forEach(link -> normalizeUserDefinedReferenceLink((ReferenceLink) link));

        realization.getReferenceTreatments().stream().//
                filter(ReferenceEmbed.class::isInstance)//
                .forEach(embed -> {
                    if (usesDefaultObjectRealization((ReferenceEmbed) embed)) {
                        markWithDefaultRealization(embed);
                    } else {
                        // TODO
                    }
                    normalizeUserDefinedReferenceEmbed((ReferenceEmbed) embed
                            );
                });

        new ArrayList<>(realization.getReferenceTreatments()).stream().//
                filter(ReferenceLink.class::isInstance)//
                .forEach(link -> maybeConvertReferenceLinkToEmbed(realization, type, (ReferenceLink) link));
    }

    /**
     * Check if the provided referenceLink has a target resource:
     * <ul>
     * <li>If it does, add it to the container;</li>
     * <li>If it does not, convert it to a reference embed and add the new reference embed to the container</li>
     * </ul>
     * 
     */
    private void maybeConvertReferenceLinkToEmbed(final RealizationContainer container, Structure datatype,
            ReferenceLink referenceLink) {

            if (!container.getReferenceTreatments().contains(referenceLink)) {
                container.getReferenceTreatments().add(referenceLink);
            }
    }

    private void maybeConvertReferenceLinkToEmbed(ReferenceEmbed container, ReferenceTreatment nestedTreatment) {
        ReferenceElement property = nestedTreatment.getReferenceElement();
        if (property != null) {
            if (nestedTreatment instanceof ReferenceLink) {
                normalizeUserDefinedReferenceLink((ReferenceLink) nestedTreatment);
            } else { // ReferenceEmbed
                normalizeUserDefinedReferenceEmbed((ReferenceEmbed) nestedTreatment);
            }
        }
    }

    private void normalizeUserDefinedReferenceLink(final ReferenceLink referenceLink) {
        maybeSetReferenceRealization(referenceLink);

        if (TagUtils.getTagWithName(referenceLink.getReferenceRealization().getLinkDescriptor(), TagUtils.GENERATED)
                .isPresent() && referenceLink.getTargetResource() instanceof ServiceDataResource) {
            EcoreUtil.remove(referenceLink.getReferenceRealization().getLinkDescriptor());
            // This is a fix for JSON Schema generator which otherwise inlines the referenceLink
            markWithDefaultRealization(referenceLink);
            NamedLinkDescriptor linkDescriptor = ((ServiceDataResource) referenceLink.getTargetResource()).getDefaultLinkDescriptor();
            referenceLink.getReferenceRealization().setProperties(linkDescriptor);
        }
        // usesDefaultObjectRealization uses getAllIncludedProperties defined in
        // referenceTreatmentInlineLinkDescriptorProcessor
        if (usesDefaultObjectRealization(referenceLink)) {
            markWithDefaultRealization(referenceLink);
        }
    }

    private void normalizeReferenceEmbedFromLink(final ReferenceEmbed embed) {
        maybeSetReferenceRealization(embed);
        markWithDefaultRealization(embed);
    }

    private void normalizeUserDefinedReferenceEmbed(final ReferenceEmbed embed) {
        maybeSetReferenceRealization(embed);
        removeInvalidTreatments(embed.getReferenceRealization().getReferenceTreatments());
        ReferenceElement property = embed.getReferenceElement();

        if (property != null) {
            if (!isDefailtRealization(embed)) {
                // Need to iterate on a copy of NestedReferenceTreatments because it can be modified during
                // normalization,
                // e.g. ReferenceLink will be deleted when it's converted to ReferenceEmbed
                for (ReferenceTreatment treatment : new ArrayList<>(
                        embed.getReferenceRealization().getReferenceTreatments())) {
                    // resolve nested reference treatments
                    maybeConvertReferenceLinkToEmbed(embed, treatment);
                }
            }
        }
    }

    /**
     * Remove ReferenceTreatments without a declared type from the list
     */
    private void removeInvalidTreatments(EList<ReferenceTreatment> treatments) {
        ArrayList<ReferenceTreatment> invalidTreatments = Lists.newArrayList(treatments.stream() //
                .filter(el -> false == el.getReferenceElement() instanceof CollectionReferenceElement) // don't process collection resource links
                .filter(hasDeclaredType().negate()) //
                .collect(toList()));
        if (!invalidTreatments.isEmpty()) {
            treatments.removeAll(invalidTreatments);
        }
    }

    private boolean usesDefaultObjectRealization(ReferenceLink link) {
        if (link.getReferenceRealization() == null) {
            return true;
        }
        boolean noInlineLinkDescriptor = (link.getReferenceRealization().getInlineObjectRealization() == null)
                || (link.getReferenceRealization().getInlineObjectRealization().getAllIncludedProperties().isEmpty());
        boolean noLinkDescriptor = (link.getLinkDescriptor() == null)
                || (link.getLinkDescriptor().getAllIncludedProperties().isEmpty());
        return noInlineLinkDescriptor && noLinkDescriptor;
    }

    private boolean usesDefaultObjectRealization(ReferenceEmbed embed) {
        return embed.getReferenceRealization() == null;
    }

}
