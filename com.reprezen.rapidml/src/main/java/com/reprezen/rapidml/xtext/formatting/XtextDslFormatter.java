/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
/*
 * generated by Xtext
 */
package com.reprezen.rapidml.xtext.formatting;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.formatting.IElementMatcherProvider.IElementMatcher;
import org.eclipse.xtext.formatting.impl.AbstractDeclarativeFormatter;
import org.eclipse.xtext.formatting.impl.AbstractFormattingConfig.ElementPattern;
import org.eclipse.xtext.formatting.impl.FormattingConfig;
import org.eclipse.xtext.formatting.impl.FormattingConfigBasedStream;
import org.eclipse.xtext.parsetree.reconstr.IHiddenTokenHelper;
import org.eclipse.xtext.parsetree.reconstr.ITokenStream;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;

import com.google.common.base.Strings;
import com.reprezen.rapidml.xtext.services.XtextDslGrammarAccess;

/**
 * This class contains custom formatting description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#formatting
 * on how and when to use it
 * 
 * Also see {@link org.eclipse.xtext.xtext.XtextFormattingTokenSerializer} as an
 * example
 */
public class XtextDslFormatter extends AbstractDeclarativeFormatter {

	@Override
	protected void configureFormatting(FormattingConfig c) {
		com.reprezen.rapidml.xtext.services.XtextDslGrammarAccess f = (com.reprezen.rapidml.xtext.services.XtextDslGrammarAccess) getGrammarAccess();

		// Used to assign correct value to FormattingConfigBasedStream
		// #indentationLevel
		for (Pair<RuleCall, RuleCall> pair : findRulePairs(f.getGrammar(), f.getBEGINRule(), f.getENDRule())) {
			c.setIndentation(pair.getFirst(), pair.getSecond());
		}

		// disable line wrapping for all grammar rules
		// No line wraps introduced by formatter – line wraps change structure
		// of YAML-like models
		for (AbstractRule r : GrammarUtil.allRules(f.getGrammar())) {
			c.setNoLinewrap().around(r);
			for (Keyword keyword : GrammarUtil.containedKeywords(r)) {
				c.setNoLinewrap().around(keyword);
			}
		}

		// No spaces around “invisible” rules – synthetic (BEGIN and END) and NL
		// (newline)
		c.setNoSpace().around(f.getNLRule());
		c.setNoSpace().around(f.getENDRule());
		c.setNoSpace().around(f.getBEGINRule());

		c.setNoSpace().around(f.getML_COMMENT_NLRule());
		c.setNoSpace().around(f.getML_COMMENTRule());
		c.setNoSpace().around(f.getSL_COMMENTRule());

		for (Keyword comma : f.findKeywords(",")) { //$NON-NLS-1$
			c.setNoSpace().before(comma);
		}
		c.setNoSpace().before(f.getCardinalityRule());
		c.setNoSpace().before(f.getCardinalityOverrideRule());

		// comma in included properties
		c.setNoSpace().around(f.getIncludedPropertiesAccess().getCommaKeyword_2_0_6_0_0());
		c.setNoSpace().around(f.getIncludedPropertiesAccess().getCommaKeyword_2_1_3_5_0_0());
		c.setNoSpace().around(f.getIncludedPropertiesAccess().getCommaKeyword_2_1_4_5_0_0());
		c.setNoSpace().around(f.getAnonimousLinkDescriptorAccess()
				.getExclusivePropertyListPropertyRealizationParserRuleCall_3_3_1_0());

		c.setNoSpace().around(f.getMediaTypeQualifierWOAsteriskAccess().getSolidusKeyword_1_0());

		c.setNoSpace().after(f.getURISegmentWithParameterAccess().getLeftCurlyBracketKeyword_1());
		c.setNoSpace().after(f.getURISegmentWithParameterAccess().getRightCurlyBracketKeyword_3());
		c.setNoSpace().after(f.getURISegmentWithParameterAccess().getNameURISegmentRuleParserRuleCall_2_0());
		c.setNoSpace().after(f.getURIAccess().getGroup_3());
		c.setNoSpace().after(f.getURIAccess().getSegmentsURISegmentParserRuleCall_2_0_0());
		c.setNoSpace().after(f.getURIAccess().getSolidusKeyword_1());
		c.setNoSpace().after(f.getURIAccess().getSolidusKeyword_3_0());

		c.setLinewrap().before(f.getJAVADOC_COMMENTRule());
	}

	@Override
	public ITokenStream createFormatterStream(EObject context, String indent, ITokenStream out,
			boolean preserveWhitespaces) {
		// call super method to initial private field contextResourceURI
		super.createFormatterStream(context, indent, out, preserveWhitespaces);
		return createFormatterStream(indent, out, preserveWhitespaces);
	}

	@Override
	public ITokenStream createFormatterStream(String indent, ITokenStream out, boolean preserveWhitespaces) {
		return new FixedCommentFormatterStream(out, indent, getConfig(), createMatcher(), getHiddenTokenHelper(),
				preserveWhitespaces, (XtextDslGrammarAccess) getGrammarAccess());
	}

	/**
	 * @return pair of rule calls this is extended version of
	 *         {@link org.eclipse.xtext.service.AbstractElementFinder#findKeywordPairs(String, String)}
	 * @see org.eclipse.xtext.service.AbstractElementFinder#findKeywordPairs(String,
	 *      String)
	 */
	private List<Pair<RuleCall, RuleCall>> findRulePairs(Grammar grammar, AbstractRule leftRule,
			AbstractRule rightRule) {
		ArrayList<Pair<RuleCall, RuleCall>> pairs = new ArrayList<>();
		for (AbstractRule ar : GrammarUtil.allRules(grammar)) {
			if (ar instanceof ParserRule && !GrammarUtil.isDatatypeRule((ParserRule) ar)) {
				Stack<RuleCall> openings = new Stack<>();
				TreeIterator<EObject> i = ar.eAllContents();
				while (i.hasNext()) {
					EObject o = i.next();
					if (o instanceof RuleCall) {
						RuleCall rc = (RuleCall) o;
						if (rc.getRule() == leftRule) {
							openings.push(rc);
						} else if (rc.getRule() == rightRule) {
							if (openings.size() > 0) {
								pairs.add(Tuples.create(openings.pop(), rc));
							}
						}
					}
				}
			}
		}
		return pairs;
	}

	// Workaround for ZEN-455 Incorrect auto-format with documentation comments
	// Related bug from Xtext bugzilla -
	// https://bugs.eclipse.org/bugs/show_bug.cgi?id=405184 Bad indentation for
	// first
	// indented comment
	private static class FixedCommentFormatterStream extends FormattingConfigBasedStream {
		private XtextDslGrammarAccess grammarAccess;

		protected FixedCommentFormatterStream(ITokenStream out, String indentation, FormattingConfig cfg,
				IElementMatcher<ElementPattern> matcher, IHiddenTokenHelper hiddenTokenHelper, boolean preserveSpaces,
				XtextDslGrammarAccess grammarAccess) {
			super(out, indentation, cfg, matcher, hiddenTokenHelper, preserveSpaces);
			this.grammarAccess = grammarAccess;
		}

		@Override
		public void writeSemantic(EObject grammarElement, String value) throws IOException {
			if (getRule(grammarElement) == grammarAccess.getJAVADOC_COMMENTRule()) {
				// format value
				value = formatJavaDoc(value, indentationLevel);
			}
			if (grammarElement == grammarAccess.getIncludedPropertiesAccess().getCommaKeyword_2_0_6_0_0()
					|| grammarElement == grammarAccess.getIncludedPropertiesAccess().getCommaKeyword_2_1_3_5_0_0()
					|| grammarElement == grammarAccess.getIncludedPropertiesAccess().getCommaKeyword_2_1_4_5_0_0()
					|| grammarElement == grammarAccess.getAnonimousLinkDescriptorAccess().getCommaKeyword_3_3_0_0_0()) {
				value = getLineSeparator()
						+ Strings.repeat(cfg.getIndentationSpace(), indentationLevel > 0 ? indentationLevel : 0);
			}
			super.writeSemantic(grammarElement, value);
		}

		protected static AbstractRule getRule(EObject grammarElement) {
			if (grammarElement instanceof TerminalRule) {
				return (AbstractRule) grammarElement;
			}
			if (grammarElement instanceof RuleCall) {
				return ((RuleCall) grammarElement).getRule();
			}
			return null;
		}

		/**
		 * Formats JavaDoc comment using "CharsPerLine" formatting settings and preserve
		 * empty line for line break.
		 * <p>
		 * Indent constructs as
		 * 
		 * <pre>
		 * (indent string * level) + four spaces
		 * </pre>
		 * 
		 * 
		 * @param str
		 *            original string
		 * @param level
		 *            indentation level
		 * @return formatted string
		 */
		private String formatJavaDoc(String str, int level) {
			String indent = Strings.repeat(cfg.getIndentationSpace(), level > 0 ? level : 0) + "    "; //$NON-NLS-1$
			String nl = getLineSeparator();

			StringBuilder result = new StringBuilder();

			int currentLineLength = 0;
			String[] lines = str.split("\r?\n"); //$NON-NLS-1$

			// iterate lines and preserve empty line as line break
			for (int i = 0; i < lines.length; i++) {
				String line = lines[i].trim();

				if (line.isEmpty()) {
					result.append(nl).append(indent).append(nl).append(indent);
					currentLineLength = 0;
				} else {
					String[] words = line.split("\\s"); //$NON-NLS-1$
					// split line into word and reformat using "CharsPerLine"
					// restriction
					for (int j = 0; j < words.length; j++) {
						String word = words[j];
						if (currentLineLength + word.length() > cfg.getCharsPerLine()) {
							result.append(nl).append(indent);
							currentLineLength = 0;
						}
						currentLineLength += word.length() + 1;
						result.append(word);

						// dont append space to last word in last line
						if (i < lines.length - 1 || j < words.length - 1) {
							result.append(" "); //$NON-NLS-1$
						}
					}
				}
			}
			return result.toString();
		}
	};
}
