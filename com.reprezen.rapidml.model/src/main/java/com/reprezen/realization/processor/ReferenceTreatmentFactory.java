/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.realization.processor;

import static com.reprezen.rapidml.util.TagUtils.WITH_DEFAULT_OBJECT_REALIZATION;

import com.reprezen.realization.processor.DefaultReferenceRealizationRegistry.ReferenceTreatmentDescriptor;
import com.reprezen.rapidml.ObjectRealization;
import com.reprezen.rapidml.ReferenceEmbed;
import com.reprezen.rapidml.ReferenceLink;
import com.reprezen.rapidml.ReferenceRealization;
import com.reprezen.rapidml.ReferenceRealizationEnum;
import com.reprezen.rapidml.ReferenceTreatment;
import com.reprezen.rapidml.ResourceAPI;
import com.reprezen.rapidml.RapidmlFactory;
import com.reprezen.rapidml.ReferenceElement;
import com.reprezen.rapidml.util.TagUtils;

public class ReferenceTreatmentFactory {
    
    private static final RapidmlFactory rapidmlFactory = RapidmlFactory.eINSTANCE;
    
    public static ReferenceTreatment createReferenceTreatment(ReferenceRealization referenceRealization, ReferenceElement reference) {
        final ReferenceTreatment result;
        if (referenceRealization.getRealizationType() == ReferenceRealizationEnum.LINK) {
            result = createReferenceLink(referenceRealization);
        } else {
            result = createReferenceEmbed(referenceRealization);
        }
        result.setReferenceElement(reference);
        boolean isDefaultRealization = referenceRealization.eContainer() instanceof ResourceAPI;
        if (isDefaultRealization) {
            markWithDefaultRealization(result);
        }
        return result;
    }
    
    public static ReferenceLink createReferenceLink(ReferenceRealization referenceRealization) {
        ReferenceLink referenceLink = rapidmlFactory.createReferenceLink();
        referenceLink.setReferenceRealization(referenceRealization);
        return referenceLink;
    }

    public static ReferenceEmbed createReferenceEmbed(ReferenceRealization referenceRealization) {
        ReferenceEmbed referenceEmbed = rapidmlFactory.createReferenceEmbed();
        referenceEmbed.setReferenceRealization(referenceRealization);
        return referenceEmbed;
    }
    
    public static ReferenceRealization createReferenceEmbed(ResourceAPI context, ReferenceTreatmentDescriptor reference) {
        ReferenceRealization referenceEmbed = rapidmlFactory.createReferenceRealization();
        referenceEmbed.setRealizationType(ReferenceRealizationEnum.EMBED);
        referenceEmbed.setDataType(reference.getTargetDataType());
        
        ObjectRealization propertyList = rapidmlFactory.createObjectRealization();
        referenceEmbed.setInlineObjectRealization(propertyList);
        
        return referenceEmbed;
    }

    public static ReferenceTreatment maybeSetReferenceRealization(ReferenceTreatment treatment) {
        if (treatment.getReferenceRealization() == null) {
            ReferenceRealization referenceRealization = rapidmlFactory.createReferenceRealization();
            referenceRealization.setRealizationType(treatment instanceof ReferenceLink ? ReferenceRealizationEnum.LINK
                    : ReferenceRealizationEnum.EMBED);
            treatment.setOwnedReferenceRealization(referenceRealization);
        }
        return treatment;
    }
    
    public static void markWithDefaultRealization(ReferenceTreatment referenceTreatment) {
        TagUtils.addTag(referenceTreatment, WITH_DEFAULT_OBJECT_REALIZATION).setValue("true");
    }
    
    public static boolean isDefailtRealization(ReferenceTreatment referenceTreatment) {
        return TagUtils.getTagWithName(referenceTreatment, TagUtils.WITH_DEFAULT_OBJECT_REALIZATION).isPresent();
    }
}
