/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.datatypes.cardinality;

import static com.reprezen.rapidml.datatypes.cardinality.FeatureCardinalities.OPTIONAL;
import static com.reprezen.rapidml.datatypes.cardinality.FeatureCardinalities.OPTIONAL_DEFAULT;
import static com.reprezen.rapidml.datatypes.cardinality.FeatureCardinalities.OPTIONAL_LIST_ASTERISK;
import static com.reprezen.rapidml.datatypes.cardinality.FeatureCardinalities.REQUIRED_EXCLAMATION_MARK;
import static com.reprezen.rapidml.datatypes.cardinality.FeatureCardinalities.REQUIRED_LIST;

import java.util.Collection;

import com.google.common.collect.ImmutableSetMultimap;
import com.google.common.collect.Multimap;
import com.reprezen.rapidml.Feature;
import com.reprezen.rapidml.PropertyRealization;

/**
 * Deserializer for cardinalities used in {@link PropertyRealization}.
 * 
 * @author Tatiana Fesenko <tatiana.fesenko@modelsolv.com>
 * 
 */
public class OverrideCardinalities extends CardinalityDeserializer {

	private static final CardinalityWithShortcut[] OVERRIDE_CARDINALITIES = { OPTIONAL_LIST_ASTERISK, OPTIONAL,
			REQUIRED_LIST, REQUIRED_EXCLAMATION_MARK };

	private final Multimap<Cardinality, Cardinality> cardinalityOverrides = ImmutableSetMultimap
			.<Cardinality, Cardinality>builder() //
			.put(OPTIONAL_DEFAULT, REQUIRED_EXCLAMATION_MARK) // override for OPTIONAL
			.put(OPTIONAL, REQUIRED_EXCLAMATION_MARK) // override for OPTIONAL
			.put(REQUIRED_LIST, REQUIRED_EXCLAMATION_MARK) // override for REQUIRE
			.put(OPTIONAL_LIST_ASTERISK, REQUIRED_LIST) // override for OPTIONAL LIST
			.put(OPTIONAL_LIST_ASTERISK, REQUIRED_EXCLAMATION_MARK) //
			.put(OPTIONAL_LIST_ASTERISK, OPTIONAL).build();

	public static OverrideCardinalities getOverrideCardinalities() {
		return new OverrideCardinalities();
	}

	private OverrideCardinalities() {
		super(OVERRIDE_CARDINALITIES);
	}

	/**
	 * Gets the cardinality of the included property.
	 * 
	 * @param includedProperty
	 *            the included property
	 * @return the cardinality of the included property
	 */
	public Cardinality getCardinality(PropertyRealization includedProperty) {
		Cardinality cardinality = getCardinality(includedProperty.getMinOccurs(), includedProperty.getMaxOccurs());
		return cardinality;
	}

	/**
	 * Gets the allowed override for the given included property.
	 * 
	 * @param includedProperty
	 *            the included property
	 * @return the allowed cardinality overrides
	 */
	public Collection<Cardinality> getAllowedOverride(PropertyRealization includedProperty) {
		Feature baseProperty = includedProperty.getBaseProperty();
		return getAllowedOverride(baseProperty);
	}

	protected Collection<Cardinality> getAllowedOverride(Feature baseProperty) {
		Cardinality baseCardinality = FeatureCardinalities.getFeatureCardinalities().getCardinality(baseProperty);
		// MultiSet returns an empty collection if the key is not used in the table
		Collection<Cardinality> result = cardinalityOverrides.get(baseCardinality);
		return result;
	}

}
