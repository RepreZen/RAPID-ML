/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.modelsolv.reprezen.restapi.xtext.ui.editor;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DocumentCommand;
import org.eclipse.jface.text.IDocument;
import org.eclipse.xtext.ui.editor.autoedit.DefaultAutoEditStrategyProvider;
import org.eclipse.xtext.ui.editor.autoedit.SingleLineTerminalsStrategy;

/**
 * Edit strategy provider for ReprZen DSL
 * 
 * @author Tatiana Fesenko <tatiana.fesenko@modelsolv.com>
 * 
 */
public class AutoEditStrategyWOMultilineCommentProvider extends DefaultAutoEditStrategyProvider {
    @Override
    protected void configureMultilineComments(IEditStrategyAcceptor acceptor) {
        // ZEN-446 Xtext editor sometime s pastes '**/' on newline when it's not expected
        // MultiLineTerminalsEditStrategy#handleNoStopTerminal creates a command based on
        // DefaultAutoEditStrategyProvider which configures CommandInfo. A CommandInfo is used in a DocumentCommand.
        // acceptor.accept(singleLineTerminals.newInstance("/*", " */"), IDocument.DEFAULT_CONTENT_TYPE);
        acceptor.accept(new SingleLineTerminalsStrategy("/*", " */", SingleLineTerminalsStrategy.DEFAULT) { //$NON-NLS-1$ //$NON-NLS-2$
                    // Ovveride original method to add space according to
                    // "ZEN-1411: Editor should auto-insert a space after beginning a slash-star comment"
                    @Override
                    protected void handleInsertLeftTerminal(IDocument document, DocumentCommand command)
                            throws BadLocationException {
                        if (command.text.length() > 0 && appliedText(document, command).endsWith(getLeftTerminal())
                                && isInsertClosingTerminal(document, command.offset + command.length)) {
                            String documentContent = getDocumentContent(document, command);
                            int opening = count(getLeftTerminal(), documentContent);
                            int closing = count(getRightTerminal(), documentContent);
                            int occurences = opening + closing;
                            if (occurences % 2 == 0
                                    && (command.text.length() - command.length + documentContent.length() >= getLeftTerminal()
                                            .length())) {
                                // add additional space
                                command.caretOffset = command.offset + command.text.length() + 1;
                                command.text = command.text + "* " + getRightTerminal(); //$NON-NLS-1$
                                command.shiftsCaret = false;
                            }
                        }
                    }
                }, IDocument.DEFAULT_CONTENT_TYPE);
        // acceptor.accept(multiLineTerminals.newInstance("/*", " * ", " */"), IDocument.DEFAULT_CONTENT_TYPE);
        // acceptor.accept(multiLineTerminals.newInstance("/*", " * ", " */"),
        // TerminalsTokenTypeToPartitionMapper.COMMENT_PARTITION);
    }
    
    @Override
    protected void configureParenthesis(IEditStrategyAcceptor acceptor) {
        // Disable super.configureParenthesis, see 
        // ZEN-3654 RAPID-ML Editor: pressing enter appends stray close-paren character
        // super.configureParenthesis(acceptor);
    }

    @Override
    protected void configureCompoundBracesBlocks(IEditStrategyAcceptor acceptor) {
        // Disable super.configureCompoundBracesBlocks, see 
        // ZEN-3654 RAPID-ML Editor: pressing enter appends stray close-paren character
        // super.configureCompoundBracesBlocks(acceptor);
    }
}