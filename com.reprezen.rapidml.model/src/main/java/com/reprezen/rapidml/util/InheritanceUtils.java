/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.util;

import java.util.Collection;
import java.util.Set;

import com.google.common.collect.Sets;
import com.reprezen.rapidml.Feature;
import com.reprezen.rapidml.Inheritable;
import com.reprezen.rapidml.Structure;

public class InheritanceUtils {

    public static Collection<Feature> getInheritedFeatures(Structure structure) {
        Set<Feature> result = Sets.newLinkedHashSet();
        for (Inheritable supertype : structure.getAllSupertypes()) {
            if (supertype instanceof Structure) {
                result.addAll(((Structure) supertype).getOwnedFeatures());
            }
        }
        return result;
    }

    public static boolean sameOrOverrides(Feature feature1, Feature feature2) {
        // TODO add a stricter condition
        // But it's OK for now as
        // 1. this method is called only when feature1 and feature2 belong to the same data type hierarchy.
        // 2. Names are unique within a structure
        return feature1 == feature2 || feature1.getName().equals(feature2.getName());
    }

}
