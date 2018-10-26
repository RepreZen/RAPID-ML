/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.xtext.naming;

import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.util.Strings;

import com.reprezen.rapidml.ZenModel;

/**
 * @author Konstantin Zaitsev
 * @date Nov 17, 2014
 */
public class RepreZenDeclarativeQualifiedNameProvider extends DefaultDeclarativeQualifiedNameProvider {
    @SuppressWarnings("unused")
    private QualifiedName qualifiedName(ZenModel model) {
        if (!Strings.isEmpty(model.getNamespace())) {
            return QualifiedName.create(model.getNamespace().split("\\.")).append(model.getName()); //$NON-NLS-1$
        }
        return QualifiedName.create(model.getName());
    }
}
