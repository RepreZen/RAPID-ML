/*******************************************************************************
 * Copyright © 2013, 2018 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.modelsolv.reprezen.realization.model;

import java.util.Collection;
import java.util.Optional;

public interface Switchable<T extends ConditionedItem> {
    public Collection<T> getCandidates();

    default Optional<T> getNoCandidatesResult() {
        return Optional.empty();
    }

    default Optional<T> getNoMatchingCandidateResult() {
        return Optional.empty();
    }
}
