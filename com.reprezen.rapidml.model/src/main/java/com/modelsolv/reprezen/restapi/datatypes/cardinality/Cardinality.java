/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.modelsolv.reprezen.restapi.datatypes.cardinality;

/**
 * Feature cardinality.
 * 
 * @author Tatiana Fesenko <tatiana.fesenko@modelsolv.com>
 * 
 */
public class Cardinality {

    private static final int INFINITE_INT = -1;
    private static final String INFINITE_STRING = "*";
    private int lowerBound;
    private int upperBound;

    Cardinality(int lower, int upper) {
        this.lowerBound = lower;
        this.upperBound = upper;
    }

    public Cardinality(String lowerBound, String upperBound) {
        this.lowerBound = Integer.valueOf(lowerBound);
        if (INFINITE_STRING.equals(upperBound)) {
            this.upperBound = INFINITE_INT;
        } else {
            this.upperBound = Integer.valueOf(upperBound);
        }
    }

    public int getLower() {
        return lowerBound;
    }

    public int getUpper() {
        return upperBound;
    }

    /**
     * Lower and upper bounds in a form of int array.
     *
     * @return the int[]
     */
    public int[] toIntArray() {
        int[] result = { lowerBound, upperBound };
        return result;
    }

    /**
     * Gets the label in the form "[lowerBound..upperBound]" or a shortcut.
     *
     * @return the label
     */
    public String getLabel() {
        return String.format("[%s..%s]", lowerBound, getUpperLabel());
    }

    public String getUpperLabel() {
        return (upperBound == INFINITE_INT) ? INFINITE_STRING : String.valueOf(upperBound);
    }

    /**
     * Checks if the lower and upper bounds of the give cardinality are equals to those of the current element even if
     * the used shortcuts are different.
     * 
     * @param that
     * @return
     */
    public boolean equalValues(Cardinality that) {
        if (that == null) {
            return false;
        }
        return equalValues(that.lowerBound, that.upperBound);
    }

    /**
     * Checks if the given lower and upper bounds are equals to those of the current element even if the used shortcuts
     * are different.
     * 
     * @param lowerBound
     *            the lower bound
     * @param upperBound
     *            the upper
     */
    public boolean equalValues(int lowerBound, int upperBound) {
        return lowerBound == this.lowerBound && upperBound == this.upperBound;
    }

    @Override
    public String toString() {
        return getLabel();
    }

    @Override
    public boolean equals(Object that) {
        if (that == null || (that.getClass() != this.getClass())) {
            return false;
        }
        if (this == that) {
            return true;
        }
        Cardinality thatCardinality = (Cardinality) that;
        return lowerBound == thatCardinality.lowerBound && upperBound == thatCardinality.upperBound
                && getLabel().equals(thatCardinality.getLabel());
    }

}
