/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.datatypes.cardinality;

import com.reprezen.rapidml.Feature;
import com.reprezen.rapidml.ReferenceElement;

/**
 * Deserializer for {@link Cardinality} used in data type properties.
 * 
 * @author Tatiana Fesenko <tatiana.fesenko@modelsolv.com>
 * 
 */
public class FeatureCardinalities extends CardinalityDeserializer {

    public static final CardinalityWithShortcut OPTIONAL_DEFAULT = new CardinalityWithShortcut(0, 1, "");
    public static final CardinalityWithShortcut REQUIRED_EXCLAMATION_MARK = new CardinalityWithShortcut(1, 1, "!");
    public static final CardinalityWithShortcut OPTIONAL_LIST_ASTERISK = new CardinalityWithShortcut(0, -1, "*");
    // public static final CardinalityWithShortcut OPTIONAL_LIST = new CardinalityWithShortcut(0, -1, "[]");
    public static final CardinalityWithShortcut OPTIONAL = new CardinalityWithShortcut(0, 1, "?");
    public static final CardinalityWithShortcut REQUIRED_LIST = new CardinalityWithShortcut(1, -1, "+");
    public static final CardinalityWithShortcut[] ALL_CARDINALITIES = { OPTIONAL_DEFAULT, OPTIONAL_LIST_ASTERISK,
            OPTIONAL, REQUIRED_LIST, REQUIRED_EXCLAMATION_MARK };

    private FeatureCardinalities() {
        super(ALL_CARDINALITIES);
    }

    public static FeatureCardinalities getFeatureCardinalities() {
        return new FeatureCardinalities();
    }

    /**
     * Gets the cardinality of the data type property.
     *
     * @param property
     *            the data type property
     * @return the cardinality of the data type property
     */
    public Cardinality getCardinality(Feature property) {
        Cardinality cardinality = getCardinality(property.getMinOccurs(), property.getMaxOccurs());
        return cardinality;
    }
    
    public Cardinality getCardinality(ReferenceElement property) {
        Cardinality cardinality = getCardinality(property.getMinOccurs(), property.getMaxOccurs());
        return cardinality;
    }

}
