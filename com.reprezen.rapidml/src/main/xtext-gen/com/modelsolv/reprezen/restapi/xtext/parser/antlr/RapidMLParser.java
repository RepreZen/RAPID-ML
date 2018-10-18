/*
 * generated by Xtext 2.9.2
 */
package com.modelsolv.reprezen.restapi.xtext.parser.antlr;

import com.google.inject.Inject;
import com.modelsolv.reprezen.restapi.xtext.parser.antlr.internal.InternalRapidMLParser;
import com.modelsolv.reprezen.restapi.xtext.services.RapidMLGrammarAccess;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;

public class RapidMLParser extends AbstractAntlrParser {

	@Inject
	private RapidMLGrammarAccess grammarAccess;

	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	

	@Override
	protected InternalRapidMLParser createParser(XtextTokenStream stream) {
		return new InternalRapidMLParser(stream, getGrammarAccess());
	}

	@Override 
	protected String getDefaultRuleName() {
		return "ZenModel";
	}

	public RapidMLGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(RapidMLGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
