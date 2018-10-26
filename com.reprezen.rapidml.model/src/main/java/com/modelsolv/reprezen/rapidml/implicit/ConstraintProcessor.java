/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.modelsolv.reprezen.rapidml.implicit;

import static com.google.common.base.Predicates.instanceOf;
import static com.google.common.base.Predicates.not;
import static com.google.common.collect.Iterables.all;

import org.eclipse.emf.ecore.util.EcoreUtil;

import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.modelsolv.reprezen.rapidml.ConstrainableType;
import com.modelsolv.reprezen.rapidml.Constraint;
import com.modelsolv.reprezen.rapidml.util.TagUtils;

public class ConstraintProcessor {

    public static void addParentConstraints(final ConstrainableType constrainableType) {
        if (TagUtils.getTagWithName(constrainableType, TagUtils.CONSTRAINTS_PROCESSED).isPresent()) {
            return;
        }
        TagUtils.addTag(constrainableType, TagUtils.CONSTRAINTS_PROCESSED);
        ConstrainableType constrainableParent = constrainableType.getConstrainableParent();
        if (constrainableParent != null) {
            ImmutableList<Constraint> filteredConstraints = ImmutableList
                    .copyOf(Iterables.filter(constrainableParent.getAllConstraints(), new Predicate<Constraint>() {
                        @Override
                        public boolean apply(Constraint constraint) {
                            return all(constrainableType.getConstraints(), not(instanceOf(constraint.getClass())));
                        }
                    }));
            for (Constraint constraint: filteredConstraints) {
                Constraint inheritedConstraint = EcoreUtil.copy(constraint);
                TagUtils.addTag(inheritedConstraint, TagUtils.CONSTRAINT_INHERITED);
                constrainableType.getConstraints().add(inheritedConstraint);
            }
        }
    }

}
