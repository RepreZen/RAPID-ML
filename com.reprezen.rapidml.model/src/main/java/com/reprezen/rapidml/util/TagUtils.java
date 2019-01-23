/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.util;

import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.reprezen.rapidml.Extensible;
import com.reprezen.rapidml.Extension;
import com.reprezen.rapidml.RapidmlFactory;

public class TagUtils {

	public static String PROPERTY_INHERITED = "gen-inherited";
	public static String DATATYPE_PROCESSED = "gen-processed";
	public static String CONSTRAINTS_PROCESSED = "gen-constraints-processed";
	public static String CONSTRAINT_INHERITED = "gen-inherited";
	public static String WITH_DEFAULT_OBJECT_REALIZATION = "gen-with_default_realization";
	public static String GENERATED = "gen-generated";
	public static String REALIZATION_TEMPLATE_NAME = "template-name";
	public static String NORMALIZED = "gen-normalized";
	public static String LINK_RELATION = "gen-linkRelation";

	public static Optional<Extension> getTagWithName(Extensible taggable, final String name) {
		// ZEN-3121 replace tryFind with Guava-10-friendly find()
		Extension tag = Iterables.find(taggable.getExtensions(), new Predicate<Extension>() {

			@Override
			public boolean apply(Extension input) {
				return name.equals(input.getName());
			}
		}, null);
		return Optional.fromNullable(tag);
	}

	public static boolean hasTagWithName(Extensible taggable, final String name) {
		return getTagWithName(taggable, name).isPresent();
	}

	public static Extension addTag(Extensible taggable, String tagName) {
		Extension tag = RapidmlFactory.eINSTANCE.createExtension();
		tag.setName(tagName);
		taggable.getExtensions().add(tag);
		return tag;
	}

}
