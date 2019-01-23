/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.xtext.conversion;

import java.util.Set;
import java.util.regex.Pattern;

import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.common.services.Ecore2XtextTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.AbstractNullSafeConverter;
import org.eclipse.xtext.conversion.impl.QualifiedNameValueConverter;
import org.eclipse.xtext.nodemodel.INode;

import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * Terminal converters for Xtext DSL
 * 
 * @author Tatiana Fesenko <tatiana.fesenko@modelsolv.com>
 * 
 */
public class RestTerminalConverters extends DefaultTerminalConverters {
	private static final Pattern ID_PATTERN_WITH_UNDERSCORE = Pattern.compile("[\\p{Alpha}_]\\w*");
	/*
	 * Certain keywords, like 'title', are commonly used as property names in data
	 * models. Normally, such keywords would need to be prefixed with a ^caret to be
	 * declared or referenced as property names. We can allow selected keywords to
	 * be used as property names without the caret prefix by making these changes:
	 * add the keyword as an alternate to the Keyword rule in XtextDsl.xtext add the
	 * keyword to RestTerminalConverters.keywordsAsIdentifiers
	 */
	private static final Set<String> keywordsAsIdentifiers = Sets.newHashSet("title");

	/**
	 * Copy pasted from {@link Ecore2XtextTerminalConverters} with additional
	 * allowing of the "_" as a first character.
	 * 
	 * @return
	 */
	@ValueConverter(rule = "EString")
	public IValueConverter<String> EString() {
		return new AbstractNullSafeConverter<String>() {
			@Override
			protected String internalToValue(String string, INode node) {
				if ((string.startsWith("'") && string.endsWith("'"))
						|| (string.startsWith("\"") && string.endsWith("\""))) {
					return STRING().toValue(string, node);
				}
				return ID().toValue(string, node);
			}

			@Override
			protected String internalToString(String value) {
				if (ID_PATTERN_WITH_UNDERSCORE.matcher(value).matches()) {
					return ID().toString(value);
				} else {
					return STRING().toString(value);
				}
			}
		};
	}

	@ValueConverter(rule = "FeatureName")
	public IValueConverter<String> FeatureName() {
		return new AbstractNullSafeConverter<String>() {
			@Override
			protected String internalToValue(String string, INode node) throws ValueConverterException {
				if ((string.startsWith("'") && string.endsWith("'"))
						|| (string.startsWith("\"") && string.endsWith("\""))) {
					return STRING().toValue(string, node);
				} else if (keywordsAsIdentifiers.contains(string)) {
					return string;
				}
				return ID().toValue(string, node);
			}

			@Override
			protected String internalToString(String value) {
				if (keywordsAsIdentifiers.contains(value)) {
					return value;
				} else if (ID_PATTERN_WITH_UNDERSCORE.matcher(value).matches()) {
					return ID().toString(value);
				} else {
					return STRING().toString(value);
				}
			}
		};
	}

	@Inject
	private JAVADOC_COMMENTValueConverter javadocCommentValueConverter;

	@Inject
	private RICH_TEXTValueConverter richTextValueConverter;

	@Inject
	private RawStringValueConverter rawStringValueConverter;

	@Inject
	private QualifiedNameValueConverter qualifiedNameValueConverter;

	@ValueConverter(rule = "JAVADOC_COMMENT")
	public IValueConverter<String> JAVADOC_COMMENT() {
		return javadocCommentValueConverter;
	}

	@ValueConverter(rule = "RICH_TEXT")
	public IValueConverter<String> RICH_TEXT() {
		return richTextValueConverter;
	}

	@ValueConverter(rule = "RAW_STRING")
	public IValueConverter<String> RawString() {
		return rawStringValueConverter;
	}

	@ValueConverter(rule = "QualifiedName")
	public IValueConverter<String> QualifiedName() {
		return qualifiedNameValueConverter;
	}

	@ValueConverter(rule = "StringLiteral")
	public IValueConverter<String> StringLiteral() {
		return new AbstractNullSafeConverter<String>() {
			@Override
			protected String internalToValue(String string, INode node) {
				if ((string.startsWith("'") && string.endsWith("'"))
						|| (string.startsWith("\"") && string.endsWith("\""))) {
					return STRING().toValue(string, node);
				}
				return RawString().toValue(string, node);
			}

			@Override
			protected String internalToString(String value) {
				if (value.contains("\\") || value.contains("\"") | value.contains("'")) {
					return RawString().toString(value);
				} else {
					return STRING().toString(value);
				}
			}
		};
	}

}