/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.modelsolv.reprezen.restapi.datatypes.cardinality;

/**
 * {@link Cardinality} with an assigned shortcut.
 * @author Tatiana Fesenko <tatiana.fesenko@modelsolv.com>
 *
 */
public class CardinalityWithShortcut extends Cardinality {

    private String shortcut;

    CardinalityWithShortcut(int lower, int upper, String shortcut) {
        super(lower, upper);
        this.shortcut = shortcut;
    }

    @Override
    public String getLabel() {
        return shortcut;
    }

}
