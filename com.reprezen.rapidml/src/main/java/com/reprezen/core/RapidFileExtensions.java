/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.core;

/**
 * This class enumerates all file extensions that RepreZen deals with.
 * 
 * @author jimleroyer
 * @since 2013/05/01
 */
public enum RapidFileExtensions {

    ZEN("zen"), RAPID("rapid");

    private String extension;

    private RapidFileExtensions(String extension) {
        this.extension = extension;
    }

    public String getExtension() {
        return extension;
    }

    /**
     * Compares the given extension to the enumeration, in a case-insensitive way.
     * 
     * @param candidateExtension
     *            Extension to check
     */
    public boolean extensionEquals(String candidateExtension) {
        return this.extension.equalsIgnoreCase(candidateExtension);
    }

    /**
     * Checks whether the given extension is part of this enumeration, in a case insensitive way.
     * 
     * @param candidateExtension
     *            Extension to check
     * @return True if included else false
     */
    public static boolean includes(String candidateExtension) {
        for (RapidFileExtensions extension : RapidFileExtensions.values()) {
            if (extension.getExtension().equalsIgnoreCase(candidateExtension)) {
                return true;
            }
        }
        return false;
    }

}
