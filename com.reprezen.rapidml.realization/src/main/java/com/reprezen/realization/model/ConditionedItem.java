/*******************************************************************************
 * Copyright © 2013, 2018 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.realization.model;

import java.util.Collection;

public interface ConditionedItem {

    Collection<? extends Conditions> getConditions();

    default boolean noConditionsResult() {
        return false;
    }
}
