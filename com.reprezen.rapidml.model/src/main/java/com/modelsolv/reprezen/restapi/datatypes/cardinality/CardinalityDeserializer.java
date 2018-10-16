/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.modelsolv.reprezen.restapi.datatypes.cardinality;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Utilities to deserialize {@link Cardinality}s
 * 
 * @author Tatiana Fesenko <tatiana.fesenko@modelsolv.com>
 * 
 */
public class CardinalityDeserializer {

    private final List<CardinalityWithShortcut> shortcuts;
    private final Pattern cardinalityPattern = Pattern.compile("\\[(\\d+)\\.\\.(\\d+|\\*)\\]");

    /**
     * Instantiates a new cardinality deserializer.
     * 
     * @param cardinalitiesWithShortcuts
     *            supported shortcuts
     */
    public CardinalityDeserializer(CardinalityWithShortcut[] cardinalitiesWithShortcuts) {
        this.shortcuts = Arrays.asList(cardinalitiesWithShortcuts);
    }

    /**
     * Parses the string and creates the corresponding cardinality. Shortcuts are respected.
     * 
     * @param cardinalityString
     *            the cardinality string
     * @return the cardinality
     */
    public Cardinality getCardinality(String cardinalityString) {
        // uses a shortcut
        for (CardinalityWithShortcut next : shortcuts) {
            if (next.getLabel().equals(cardinalityString)) {
                return next;
            }
        }
        // uses an expanded notation
        Matcher matcher = cardinalityPattern.matcher(cardinalityString);
        if (!matcher.find()) {
            throw new RuntimeException("Unsupported cardinality: " + cardinalityString);
        }
        String lowerBound = matcher.group(1);
        String upperBound = matcher.group(2);
        return new Cardinality(lowerBound, upperBound);

    }

    /**
     * Gets the cardinality.
     * 
     * @param lower
     *            the lower bound
     * @param upper
     *            the upper bound
     * @return the cardinality
     */
    public Cardinality getCardinality(int lower, int upper) {
        for (CardinalityWithShortcut next : shortcuts) {
            if (next.equalValues(lower, upper)) {
                return next;
            }
        }
        return new Cardinality(lower, upper);
    }

}
