/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.modelsolv.reprezen.core.util;

/**
 * Enumeration of RepreZen's system properties.
 * 
 * @author jimleroyer
 * @since 2013/05/24
 */
public enum RepreZenSystemProperties {

    OverrideGenerationDirectory("com.modelsolv.reprezen.gen.output-dir"),
    UsePresentationMode("-zenPresentation");

    // RepreZen's property name.
    private String name;

    private RepreZenSystemProperties(String propertyName) {
        this.name = propertyName;
    }

    /**
     * Gets the name of the property.
     * 
     * @return Property name.
     */
    public String getName() {
        return name;
    }

}
