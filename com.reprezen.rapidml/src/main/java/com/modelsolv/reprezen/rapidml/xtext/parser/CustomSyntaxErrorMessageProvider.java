/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.modelsolv.reprezen.rapidml.xtext.parser;

import static com.modelsolv.reprezen.rapidml.RapidmlPackage.Literals.COLLECTION_PARAMETER;
import static com.modelsolv.reprezen.rapidml.RapidmlPackage.Literals.MATRIX_PARAMETER;
import static com.modelsolv.reprezen.rapidml.RapidmlPackage.Literals.MESSAGE_PARAMETER;
import static com.modelsolv.reprezen.rapidml.RapidmlPackage.Literals.NAMED_LINK_DESCRIPTOR;
import static com.modelsolv.reprezen.rapidml.RapidmlPackage.Literals.SERVICE_DATA_RESOURCE;
import static com.modelsolv.reprezen.rapidml.xtext.parser.antlr.internal.InternalRapidMLParser.RULE_ID;
import static org.antlr.runtime.Token.EOF;

import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.IntStream;
import org.antlr.runtime.MismatchedTokenException;
import org.antlr.runtime.MissingTokenException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.Token;
import org.antlr.runtime.UnwantedTokenException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.osgi.util.NLS;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.diagnostics.Diagnostic;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.SyntaxErrorMessage;
import org.eclipse.xtext.parser.antlr.SyntaxErrorMessageProvider;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.util.Strings;

import com.google.common.base.Optional;
import com.modelsolv.reprezen.rapidml.RapidmlPackage;
import com.modelsolv.reprezen.rapidml.xtext.nls.Messages;
import com.modelsolv.reprezen.rapidml.xtext.parser.antlr.internal.InternalRapidMLLexer;
import com.modelsolv.reprezen.rapidml.xtext.parser.antlr.internal.InternalRapidMLParser;

/**
 * RepreZen custom syntax error message provider.
 * 
 * @author Tatiana Fesenko <tatiana.fesenko@modelsolv.com>
 */
public class CustomSyntaxErrorMessageProvider extends SyntaxErrorMessageProvider {

    private final List<RepreZenNoViableAltErrorHandler> repreZenSyntaxErrorHandlers = new ArrayList<>();

    public CustomSyntaxErrorMessageProvider() {
        repreZenSyntaxErrorHandlers.add(new MissingMessageParameterName());
        repreZenSyntaxErrorHandlers.add(new MissingCollectionParameterName());
        repreZenSyntaxErrorHandlers.add(new MissingMatrixParameterName());
        repreZenSyntaxErrorHandlers.add(new MissingServiceDataResourceName());
        repreZenSyntaxErrorHandlers.add(new MissingLinkDescriptorName());
        repreZenSyntaxErrorHandlers.add(new MissingInterfaceDataTypeName());
        repreZenSyntaxErrorHandlers.add(new MissingReferencePropertyName());
        repreZenSyntaxErrorHandlers.add(new MissingPrimitivePropertyName());
    }

    @Override
    public SyntaxErrorMessage getSyntaxErrorMessage(IParserErrorContext context) {
        String contextName = context.getCurrentContext() != null ? getNameFromEObject(context.getCurrentContext())
                : Messages.CustomSyntaxErrorMessageProvider_unknownElement;
        String unexpectedText = context.getRecognitionException() != null ? context.getRecognitionException().token
                .getText() : ""; //$NON-NLS-1$

        // ZEN-2309 hack to fix this message until we rename the ZenModel eclass
        String wrongName = Strings.toFirstLower(RapidmlPackage.eINSTANCE.getZenModel().getName());
        if (contextName != null && wrongName.equals(contextName)) {
            contextName = "rapidModel";
        }

        if (context.getRecognitionException() instanceof NoViableAltException) {
            return processNoViableAltException(context, unexpectedText,
                    (NoViableAltException) context.getRecognitionException());
        } else if (context.getRecognitionException() instanceof MissingTokenException) {
            return processMissingTokenException(contextName, unexpectedText,
                    (MissingTokenException) context.getRecognitionException());
        } else if (context.getRecognitionException() instanceof UnwantedTokenException) {
            return processUnwantedTokenException(contextName, unexpectedText,
                    (UnwantedTokenException) context.getRecognitionException());
        } else if (context.getRecognitionException() instanceof EarlyExitException) {
            return processEarlyExitException(context, (EarlyExitException) context.getRecognitionException());
        } else if (context.getRecognitionException() instanceof MismatchedTokenException) {
            return processMismatchedTokenException(context,
                    (MismatchedTokenException) context.getRecognitionException());
        }

        if ((context.getDefaultMessage() != null) && (context.getDefaultMessage().startsWith("Invalid token /"))) { //$NON-NLS-1$
            return new SyntaxErrorMessage(Messages.CustomSyntaxErrorMessageProvider_msgUnclosedMultilineComment,
                    Diagnostic.SYNTAX_DIAGNOSTIC);
        }

        return super.getSyntaxErrorMessage(context);
    }

    private SyntaxErrorMessage processMismatchedTokenException(IParserErrorContext context,
            MismatchedTokenException exception) {
        if ((InternalRapidMLLexer.RULE_END == exception.expecting)
                && (InternalRapidMLLexer.RULE_JAVADOC_COMMENT == exception.token.getType())) {
            return new SyntaxErrorMessage(Messages.CustomSyntaxErrorMessageProvider_msgInvalidDocumentationIndentLevel,
                    Diagnostic.SYNTAX_DIAGNOSTIC);
        }
        return super.getSyntaxErrorMessage(context);
    }

    private SyntaxErrorMessage processEarlyExitException(IParserErrorContext context, EarlyExitException exception) {
        if (exception.input instanceof XtextTokenStream) {
            XtextTokenStream xtextTokenStream = (XtextTokenStream) exception.input;
            int prevTokenIndex = exception.index - 1;
            if (0 < prevTokenIndex) {
                Token prevToken = xtextTokenStream.get(prevTokenIndex);
                if (InternalRapidMLLexer.RULE_JAVADOC_COMMENT == prevToken.getType()) {
                    return new SyntaxErrorMessage(
                            Messages.CustomSyntaxErrorMessageProvider_msgInvalidDocumentationIndentLevel,
                            Diagnostic.SYNTAX_DIAGNOSTIC);
                }
            }
        }
        return super.getSyntaxErrorMessage(context);
    }

    /**
     * @param context
     *            parser context
     * @param unexpectedText
     *            unexpected text of token name
     * @param exception
     *            ANTL exception
     * @return formatted error message
     */
    private SyntaxErrorMessage processNoViableAltException(IParserErrorContext context, String unexpectedText,
            NoViableAltException exception) {
        Optional<SyntaxErrorMessage> message = getErrorMessageForMissingName(context, unexpectedText);
        if (message.isPresent()) {
            return message.get();
        }
        INode currNode = context.getCurrentNode();
        if (currNode != null && currNode.getPreviousSibling() != null) {
            INode prevNode = currNode.getPreviousSibling();
            // in most cases NoViableAltException indicate that previous statement not complete or doesnt contains
            // required attributes (name, id, etc)
            if (prevNode.getGrammarElement() instanceof Keyword) {
                String prevContextName = ((Keyword) prevNode.getGrammarElement()).getValue();
                if (",".equals(unexpectedText)) { //$NON-NLS-1$
                    return new SyntaxErrorMessage(NLS.bind(
                            Messages.CustomSyntaxErrorMessageProvider_msgRequiredAttributes, prevContextName),
                            Diagnostic.SYNTAX_DIAGNOSTIC);
                } else {
                    return new SyntaxErrorMessage(NLS.bind(
                            Messages.CustomSyntaxErrorMessageProvider_msgNotAllowedAttribute, unexpectedText,
                            prevContextName), Diagnostic.SYNTAX_DIAGNOSTIC);
                }
            }
        }
        if (InternalRapidMLLexer.RULE_BEGIN == exception.token.getType()
                || InternalRapidMLLexer.RULE_END == exception.token.getType()) {
            if (isNextTokenDocumentation(exception.input, exception.index)) {
                return new SyntaxErrorMessage(
                        Messages.CustomSyntaxErrorMessageProvider_msgInvalidDocumentationIndentLevel,
                        Diagnostic.SYNTAX_DIAGNOSTIC);
            } else {
                return new SyntaxErrorMessage(Messages.CustomSyntaxErrorMessageProvider_msgInvalidIndentNextLine,
                        Diagnostic.SYNTAX_DIAGNOSTIC);
            }
        }
        return super.getSyntaxErrorMessage(context);
    }

    /**
     * @param contextName
     *            name of context element
     * @param unexpectedText
     *            unexpected text of token name
     * @param exception
     *            ANTL exception
     * @return formatted error message
     */
    private SyntaxErrorMessage processMissingTokenException(String contextName, String unexpectedText,
            MissingTokenException exception) {
        String errorMessage;
        if (isDocumentationIndentError(exception)) {
            errorMessage = Messages.CustomSyntaxErrorMessageProvider_msgInvalidDocumentationIndentLevel;
        } else {
            errorMessage = exception.expecting == RepreZenInternalDslParser.RULE_ID ? NLS.bind(
                    Messages.CustomSyntaxErrorMessageProvider_msgMissingTokenId, new Object[] {
                            getTokenName(exception.expecting), contextName, getUnexpectedTextLabel(unexpectedText) })
                    : NLS.bind(Messages.CustomSyntaxErrorMessageProvider_msgMissingToken, new Object[] {
                            getTokenName(exception.expecting), contextName, getUnexpectedTextLabel(unexpectedText) });
        }
        return new SyntaxErrorMessage(errorMessage, Diagnostic.SYNTAX_DIAGNOSTIC);
    }

    private boolean isDocumentationIndentError(MissingTokenException exception) {
        if (InternalRapidMLLexer.RULE_BEGIN == exception.getMissingType()) {
            return isNextTokenDocumentation(exception.input, exception.index);
        } else if (InternalRapidMLLexer.RULE_JAVADOC_COMMENT == exception.token.getType()) {
            return true;
        }
        return false;
    }

    private boolean isNextTokenDocumentation(IntStream input, int index) {
        if (input instanceof XtextTokenStream) {
            XtextTokenStream xtextTokenStream = (XtextTokenStream) input;
            for (int nextTokenIndex = index + 1; nextTokenIndex < xtextTokenStream.size(); nextTokenIndex++) {
                Token nextToken = xtextTokenStream.get(nextTokenIndex);
                if (InternalRapidMLLexer.RULE_JAVADOC_COMMENT == nextToken.getType()) {
                    return true;
                }
                if (InternalRapidMLLexer.RULE_NL != nextToken.getType()
                        && InternalRapidMLLexer.RULE_BEGIN != nextToken.getType()) {
                    break;
                }
            }
        }
        return false;
    }

    private String getUnexpectedTextLabel(String unexpectedText) {
        if (unexpectedText.trim().isEmpty()) {
            return Messages.CustomSyntaxErrorMessageProvider_lineBeak;
        } else {
            return unexpectedText;
        }
    }

    /**
     * @param contextName
     *            name of context element
     * @param unexpectedText
     *            unexpected text of token name
     * @param exception
     *            ANTL exception
     * @return formatted error message
     */
    private SyntaxErrorMessage processUnwantedTokenException(String contextName, String unexpectedText,
            UnwantedTokenException exception) {
        String errorMessage;
        if (RepreZenInternalDslParser.RULE_JAVADOC_COMMENT == exception.token.getType()) {
            errorMessage = Messages.CustomSyntaxErrorMessageProvider_msgInvalidDocumentationIndentLevel;
        } else if (InternalRapidMLLexer.RULE_BEGIN == exception.token.getType()
                || InternalRapidMLLexer.RULE_END == exception.token.getType()) {
            if (isNextTokenDocumentation(exception.input, exception.index)) {
                return new SyntaxErrorMessage(
                        Messages.CustomSyntaxErrorMessageProvider_msgInvalidDocumentationIndentLevel,
                        Diagnostic.SYNTAX_DIAGNOSTIC);
            } else {
                return new SyntaxErrorMessage(Messages.CustomSyntaxErrorMessageProvider_msgInvalidIndentNextLine,
                        Diagnostic.SYNTAX_DIAGNOSTIC);
            }
        } else {
            errorMessage = exception.token.getType() == RepreZenInternalDslParser.RULE_ID ? NLS.bind(
                    Messages.CustomSyntaxErrorMessageProvider_msgUnexpectedTokenId, new Object[] { unexpectedText,
                            contextName, getTokenName(exception.expecting) }) : NLS.bind(
                    Messages.CustomSyntaxErrorMessageProvider_msgUnexpectedToken, new Object[] { unexpectedText,
                            contextName, getTokenName(exception.expecting) });
        }
        return new SyntaxErrorMessage(errorMessage, Diagnostic.SYNTAX_DIAGNOSTIC);
    }

    /**
     * Gets the error message if the element's name is missing.
     * 
     * @param context
     *            the parser context
     * @param unexpectedText
     *            the unexpected token
     * @return the error message for missing name
     */
    protected Optional<SyntaxErrorMessage> getErrorMessageForMissingName(IParserErrorContext context,
            String unexpectedText) {
        // empty unexpected text means that something is missing before line break
        if (unexpectedText == null || unexpectedText.trim().isEmpty()) {
            INode currNode = context.getCurrentNode();
            if (currNode.getGrammarElement() instanceof RuleCall) {
                AbstractRule calledRule = ((RuleCall) currNode.getGrammarElement()).getRule();
                EObject currContext = context.getCurrentContext();
                for (RepreZenNoViableAltErrorHandler syntaxError : repreZenSyntaxErrorHandlers) {
                    if (syntaxError.isApplicable(currContext, calledRule)) {
                        SyntaxErrorMessage message = new SyntaxErrorMessage(syntaxError.getErrorMessage(),
                                Diagnostic.SYNTAX_DIAGNOSTIC);
                        return Optional.of(message);
                    }
                }
            }
        }
        return Optional.absent();
    }

    /**
     * @param tokenType
     *            type of token
     * @return name by token type
     */
    private String getTokenName(int tokenType) {
        switch (tokenType) {
        case RULE_ID:
            return Messages.CustomSyntaxErrorMessageProvider_aValidName;
        case EOF:
            return Messages.CustomSyntaxErrorMessageProvider_endOfFile;
        default:
            return InternalRapidMLParser.tokenNames[tokenType];
        }
    }

    /**
     * This method returns possible token name using some name conventions
     * 
     * @param obj
     *            EMF object
     * @return Converted name to token name
     */
    private static String getNameFromEObject(EObject obj) {
        String name = obj.eClass().getName();
        if (name.toUpperCase().equals(name)) {
            return name;
        }
        return Strings.toFirstLower(name);
    }

    /**
     * An interface to process the RepreZenNoViableAltError Antlr parser errors.
     */
    private interface RepreZenNoViableAltErrorHandler {
        boolean isApplicable(EObject currContext, AbstractRule calledRule);

        String getErrorMessage();
    }

    /**
     * An abstract implementation of {@link RepreZenNoViableAltErrorHandler} suited for errors due to missing element
     * name.
     */
    private static abstract class MissingNameErrorHandler implements RepreZenNoViableAltErrorHandler {
        EClass supportedClass;

        /**
         * @param supportedClass
         *            the metaclass which will be recognized by this error handler
         */
        public MissingNameErrorHandler(EClass supportedClass) {
            this.supportedClass = supportedClass;
        }

        @Override
        public boolean isApplicable(EObject currContext, AbstractRule calledRule) {
            return (supportedClass.isSuperTypeOf(currContext.eClass())) && "EString".equals(calledRule.getName()); //$NON-NLS-1$
        }

        @Override
        public String getErrorMessage() {
            return NLS.bind(Messages.CustomSyntaxErrorMessageProvider_nameIsMissing, supportedClass.getName());
        }

    }

    private static class MissingMessageParameterName extends MissingNameErrorHandler {
        public MissingMessageParameterName() {
            super(MESSAGE_PARAMETER);
        }
    }

    private static class MissingCollectionParameterName extends MissingNameErrorHandler {
        public MissingCollectionParameterName() {
            super(COLLECTION_PARAMETER);
        }
    }

    private static class MissingMatrixParameterName extends MissingNameErrorHandler {
        public MissingMatrixParameterName() {
            super(MATRIX_PARAMETER);
        }
    }

    private static class MissingServiceDataResourceName extends MissingNameErrorHandler {
        public MissingServiceDataResourceName() {
            super(SERVICE_DATA_RESOURCE);
        }
    }

    private static class MissingLinkDescriptorName extends MissingNameErrorHandler {
        public MissingLinkDescriptorName() {
            super(NAMED_LINK_DESCRIPTOR);
        }
    }

    private static class MissingInterfaceDataTypeName extends MissingNameErrorHandler {
        public MissingInterfaceDataTypeName() {
            super(RapidmlPackage.Literals.STRUCTURE);
        }
    }

    private static class MissingReferencePropertyName extends MissingNameErrorHandler {
        public MissingReferencePropertyName() {
            super(RapidmlPackage.Literals.REFERENCE_PROPERTY);
        }
    }

    private static class MissingPrimitivePropertyName extends MissingNameErrorHandler {
        public MissingPrimitivePropertyName() {
            super(RapidmlPackage.Literals.PRIMITIVE_PROPERTY);
        }
    }

}