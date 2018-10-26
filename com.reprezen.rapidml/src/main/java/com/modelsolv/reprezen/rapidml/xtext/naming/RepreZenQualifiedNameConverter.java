/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.modelsolv.reprezen.rapidml.xtext.naming;

import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;

/**
 * @author Konstantin Zaitsev
 * @date Dec 15, 2014
 */
public class RepreZenQualifiedNameConverter extends IQualifiedNameConverter.DefaultImpl {

    @Override
    public QualifiedName toQualifiedName(String qualifiedNameAsString) {
        QualifiedName qualifiedName = super.toQualifiedName(qualifiedNameAsString);
        // workaround for mediaTypes with dots
        if (qualifiedName.getSegmentCount() >= 2 && qualifiedName.getSegment(0).startsWith("application/")) { //$NON-NLS-1$
            return QualifiedName.create(qualifiedNameAsString);
        }
        return qualifiedName;
    }
}
