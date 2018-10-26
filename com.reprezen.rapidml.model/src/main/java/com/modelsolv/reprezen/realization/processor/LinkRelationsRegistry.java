/*******************************************************************************
 * Copyright © 2013, 2018 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.modelsolv.reprezen.realization.processor;

import java.util.Map;

import com.google.common.collect.Maps;
import com.modelsolv.reprezen.rapidml.LinkRelation;
import com.modelsolv.reprezen.rapidml.RapidmlFactory;

public class LinkRelationsRegistry {
    private final Map<String, LinkRelation> linkRelationRegistry = Maps.newHashMap();

    public LinkRelation getLinkRelation(String linkRelationName) {
        if (linkRelationRegistry.containsKey(linkRelationName)) {
            return linkRelationRegistry.get(linkRelationName);
        }

        LinkRelation linkRelation = RapidmlFactory.eINSTANCE.createLinkRelation();
        linkRelation.setName(linkRelationName);
        linkRelationRegistry.put(linkRelationName, linkRelation);

        return linkRelation;
    }
}
