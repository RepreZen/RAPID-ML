/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.modelsolv.reprezen.rapidml.xtext.parser;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenSource;
import org.eclipse.xtext.parser.antlr.ITokenAcceptor;
import org.eclipse.xtext.parser.antlr.ITokenDefProvider;
import org.eclipse.xtext.parser.antlr.TokenAcceptor;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.inject.Inject;

/**
 * @author Konstantin Zaitsev
 * @date Dec 4, 2014
 */
public abstract class AbstractIndentTokenSource implements TokenSource {
    public static final String LEXER_RULE_PREFIX = "RULE_"; //$NON-NLS-1$
    protected static final boolean TRACE = false;

    protected TokenSource delegate;

    protected TokenAcceptor nextTokens;
    protected Token prevToken;

    private BiMap<Integer, String> tokenDefs;

    private int level;

    protected int lastPosition = 0;

    public AbstractIndentTokenSource() {
        this.nextTokens = new TokenAcceptor();
        this.tokenDefs = HashBiMap.create();
    }

    public void setDelegate(TokenSource delegate) {
        this.delegate = delegate;
    }

    public TokenSource getDelegate() {
        return delegate;
    }

    @Override
    public Token nextToken() {
        if (nextTokens.hasNext()) {
            Token result = nextTokens.next();
            if (TRACE) {
                trace(result);
            }
            return result;
        }
        if (prevToken == null) {
            prevToken = delegate.nextToken();
        }

        Token nextToken = null;
        if (prevToken != Token.EOF_TOKEN) {
            nextToken = delegate.nextToken();
            nextToken = skipDuplicateNLTokens(nextToken);
            glueNLAndCommentTokens(nextToken);
            lastPosition = ((CommonToken) prevToken).getStartIndex();
            splitToken(prevToken, nextToken, nextTokens);
            prevToken = nextToken;
        } else {
            splitToken(prevToken, prevToken, nextTokens);
        }
        nextToken = nextTokens.next();
        if (TRACE) {
            trace(nextToken);
        }

        return nextToken;
    }

    protected void glueNLAndCommentTokens(Token nextToken) {
        if (isNLToken(prevToken) && isCommentToken(nextToken)) {
            prevToken.setType(getWSTokenType());
        }
    }

    protected Token skipDuplicateNLTokens(Token nextToken) {
        // skip duplicate NL tokens
        while (nextToken != Token.EOF_TOKEN && isNLToken(nextToken) && isNLToken(prevToken)
                // undo changes from the commit 93725b66fab92aa25922161929983aa6fd131d8f
                // to enable code-assist for included properties ZEN-1413
                && shouldSkipNewLines(nextToken)) {
            CommonToken skipToken = new CommonToken(prevToken);
            skipToken.setType(getWSTokenType());

            nextTokens.accept(skipToken);
            prevToken = nextToken;
            nextToken = delegate.nextToken();
        }
        return nextToken;
    }

    protected boolean shouldSkipNewLines(Token nextToken) {
        return countTabs(prevToken.getText()) <= countTabs(nextToken.getText())
                || (countTabs(prevToken.getText()) - level) > 1;
    }

    @Override
    public String getSourceName() {
        return "[IndentTokenSource] " + delegate.getSourceName(); //$NON-NLS-1$
    }

    protected String getRuleName(Token token) {
        String result = tokenDefs.get(token.getType());
        result = getLexerRuleName(result);
        return result;
    }

    protected int getTokenType(String ruleNameWithRulePrefix) {
        int result = tokenDefs.inverse().get(ruleNameWithRulePrefix);
        return result;
    }

    public String getLexerRuleName(String antlrTokenDef) {
        if (antlrTokenDef.startsWith(LEXER_RULE_PREFIX)) {
            return antlrTokenDef.substring(LEXER_RULE_PREFIX.length());
        }
        return antlrTokenDef;
    }

    @Inject
    public void initializeTokenDefsFrom(ITokenDefProvider provider) {
        tokenDefs.clear();
        tokenDefs.putAll(provider.getTokenDefMap());
    }

    protected void splitToken(Token splitMe, Token nextToken, ITokenAcceptor acceptor) {
        if (isNLToken(splitMe) && !isCommentToken(nextToken)) {
            doSplitToken(splitMe, acceptor);
        } else {
            acceptor.accept(splitMe);
        }
    }

    protected void doSplitToken(Token token, ITokenAcceptor result) {
        int nextLevel = (token.getType() == Token.EOF) ? 0 : countTabs(token.getText());
        int startIndex = ((CommonToken) token).getStartIndex();
        int stopIndex = ((CommonToken) token).getStopIndex();

        if (startIndex <= 0) {
            startIndex = lastPosition;
        }

        if (startIndex > stopIndex) {
            stopIndex = startIndex;
        }
        if (handleEOF() || token != Token.EOF_TOKEN) {
            while (this.level > nextLevel) {
                this.level--;
                if (token == Token.EOF_TOKEN) {
                    startIndex = lastPosition;
                }
                CommonToken token1 = new CommonToken(getEndTokenType(), ""); //$NON-NLS-1$
                token1.setStartIndex(startIndex);
                token1.setStopIndex(startIndex);
                token1.setLine(token.getLine());
                result.accept(token1);
            }
        }
        while (this.level < nextLevel) {
            this.level++;
            CommonToken token1 = new CommonToken(getBeginTokenType(), ""); //$NON-NLS-1$
            // we need set +1 to make length equals to 0
            token1.setStartIndex(startIndex + 1);
            token1.setStopIndex(startIndex);
            token1.setLine(token.getLine());
            result.accept(token1);
        }
        result.accept(token);
    }

    private int countTabs(String text) {
        int firstTab = text.indexOf("\t"); //$NON-NLS-1$
        return (firstTab == -1) ? 0 : text.length() - firstTab;
    }

    protected void trace(Token token) {
        if (token == Token.EOF_TOKEN) {
            System.out.println(" -- EOF"); //$NON-NLS-1$
        } else if (token instanceof CommonToken) {
            System.out.println(token + " : " + getTokenNames()[token.getType()] + " : " + token.getChannel()); //$NON-NLS-1$ //$NON-NLS-2$
        } else {
            System.out.println(token);
        }

    }

    /**
     * @param token
     * @return <code>true</code> if token comment token
     */
    protected abstract boolean isCommentToken(Token token);

    /**
     * @param token
     * @return <code>true</code> if token NewLine token
     */
    protected abstract boolean isNLToken(Token token);

    /**
     * @return token type for RULE_BEGIN
     */
    protected abstract int getBeginTokenType();

    /**
     * @return token type for RULE_END
     */
    protected abstract int getEndTokenType();

    /**
     * @return token type for RULE_WS
     */
    protected abstract int getWSTokenType();

    /**
     * @return token names provided by lexer
     */
    protected abstract String[] getTokenNames();

    /**
     * @return <code>true</code> if need generate additional END tokens for EOF
     */
    protected abstract boolean handleEOF();
}
