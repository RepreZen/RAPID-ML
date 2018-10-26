/*******************************************************************************
 * Copyright © 2013, 2018 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.realization.model.impl;

import com.fasterxml.jackson.databind.node.MissingNode;

public class FactoryDefaultRealizationRule extends RealizationRuleImpl {

    private FactoryDefaultRealizationRule() {
        super(MissingNode.getInstance(), null, null);
    }

    public static FactoryDefaultRealizationRule instance = new FactoryDefaultRealizationRule();
}