/*******************************************************************************
 * Copyright © 2013, 2018 Modelsolv, Inc.
 * All Rights Reserved.
 * 
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.realization.processor

import com.reprezen.rapidml.ObjectRealization
import com.reprezen.rapidml.RapidmlFactory
import org.eclipse.emf.common.util.EList
import com.reprezen.rapidml.ReferenceTreatment
import java.util.ArrayList
import com.reprezen.rapidml.ReferenceRealization
import com.reprezen.rapidml.ReferenceRealizationEnum
import com.reprezen.rapidml.ReferenceProperty
import org.eclipse.emf.common.util.ECollections
import com.reprezen.rapidml.ReferenceLink
import com.reprezen.rapidml.util.TagUtils

class RealizationContainerBuilder {
	val private rapidmlFactory = RapidmlFactory.eINSTANCE;
	val private linkRelationRegistry = new LinkRelationsRegistry

	def ObjectRealization buildObjectRealization(EffectiveRealization realization) {
		val objectRealization = rapidmlFactory.createObjectRealization()
		objectRealization.allIncludedProperties.addAll(realization.getProperties.values)
		return objectRealization
	}

	def EList<ReferenceTreatment> buildReferenceTreatmentsList(EffectiveRealization realization) {
		val referenceTreatments = new ArrayList<ReferenceTreatment>();
		realization.type.referenceProperties.filter[realization.referenceRealizations.containsKey(it.name)].map [ ReferenceProperty refProperty |
			{
				val refRealization = realization.referenceRealizations.get(refProperty.name)
				val referenceRealization = refRealization.asReferenceRealization()
				val referenceTreatment = buildReferenceTreatment(referenceRealization)
				referenceTreatment.referenceElement = refProperty
				return referenceTreatment
			}
		].forEach[referenceTreatments.add(it)]
		return ECollections.unmodifiableEList(referenceTreatments);
	}
	
	def ReferenceTreatment buildReferenceTreatment(ReferenceRealization referenceRealization) {
		val referenceTreatment = if (referenceRealization.realizationType == ReferenceRealizationEnum.LINK) {
				rapidmlFactory.createReferenceLink()
			} else {
				rapidmlFactory.createReferenceEmbed()
			}
		referenceTreatment.referenceRealization = referenceRealization
		if (referenceTreatment instanceof ReferenceLink &&
			TagUtils.getTagWithName(referenceRealization, TagUtils.LINK_RELATION).isPresent) {
			val String linkRel = TagUtils.getTagWithName(referenceRealization, TagUtils.LINK_RELATION).get.getValue()
			(referenceTreatment as ReferenceLink).linkRelation = linkRelationRegistry.getLinkRelation(linkRel)
		}

		ReferenceTreatmentFactory::markWithDefaultRealization(referenceTreatment)

		return referenceTreatment
	}

	def ReferenceRealization buildReferenceRealization(EffectiveRealization realization) {
		val referenceRealization = rapidmlFactory.createReferenceRealization
		referenceRealization.realizationType = ReferenceRealizationEnum.EMBED
		referenceRealization.effectiveRealization = realization
		referenceRealization.dataType = realization.type
		if (!realization.links.isEmpty) { // process as ReferenceLink
			referenceRealization.realizationType = ReferenceRealizationEnum.LINK
			// This is the limitation of a ReferenceRealization, it can only contain one link
			val linkInfo = realization.links.entrySet.get(0)
			referenceRealization.targetResource = linkInfo.value
			val tag = TagUtils.addTag(referenceRealization, TagUtils.LINK_RELATION)
			tag.value = linkInfo.key
		}
		return referenceRealization
	}
}
