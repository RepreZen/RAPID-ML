/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.modelsolv.reprezen.rapidml.xtext.scoping;

import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.scoping.impl.ImportNormalizer;
import org.eclipse.xtext.util.Strings;

/**
 * Custom realization of Import normalizer with <b>alias<b> support.
 * 
 * @author Konstantin Zaitsev
 * @date Nov 14, 2014
 */
public class RepreZenImportNormalizer extends ImportNormalizer {

    /** Alias for namespace. */
    private QualifiedName alias;

    public RepreZenImportNormalizer(String alias, QualifiedName importedNamespace) {
        super(importedNamespace, true, false);
        this.alias = Strings.isEmpty(alias) ? QualifiedName.EMPTY : QualifiedName.create(alias);
    }

    @Override
    public QualifiedName deresolve(QualifiedName fullyQualifiedName) {
        if (fullyQualifiedName.startsWith(getImportedNamespacePrefix())) {
            int segmentCount = getImportedNamespacePrefix().getSegmentCount();
            return alias.append(fullyQualifiedName.skipFirst(segmentCount));
        }
        return null;
    }

    @Override
    public QualifiedName resolve(QualifiedName relativeName) {
        QualifiedName prefix = getImportedNamespacePrefix();

        if (relativeName.getSegmentCount() > 1 && !alias.isEmpty() && relativeName.startsWith(alias)) {
            relativeName = relativeName.skipFirst(1);
        }
        return prefix.append(relativeName);
    }
}
