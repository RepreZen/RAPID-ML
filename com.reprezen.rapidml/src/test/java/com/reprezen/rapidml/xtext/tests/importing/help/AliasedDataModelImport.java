/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.xtext.tests.importing.help;

public class AliasedDataModelImport extends DataModelImport {
    private final String alias;

    public AliasedDataModelImport(String fqn, String modelFileFromModelsDslPath, String label, String alias) {
        super(fqn, modelFileFromModelsDslPath, label);
        this.alias = alias;
    }

    @Override
    public String importString() {
        return super.importString() + " as " + alias; //$NON-NLS-1$
    }

    public String alias(String type) {
        return alias + "." + type; //$NON-NLS-1$
    }

    @Override
    public String toString() {
        return "AliasedDataModelImport [fqn=" + getFqn() + ", alias=" + alias + "]"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
    }
}
