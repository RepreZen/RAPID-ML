/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.xtext.ui.formatting;

import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IOperationHistoryListener;
import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.commands.operations.ObjectUndoContext;
import org.eclipse.core.commands.operations.OperationHistoryEvent;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewerExtension5;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.formatter.FormattingContext;
import org.eclipse.jface.text.formatter.FormattingContextProperties;
import org.eclipse.jface.text.formatter.IContentFormatter;
import org.eclipse.jface.text.formatter.IContentFormatterExtension;
import org.eclipse.jface.text.formatter.IFormattingContext;
import org.eclipse.jface.text.formatter.IFormattingStrategy;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.text.edits.ReplaceEdit;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.xtext.formatting.INodeModelFormatter;
import org.eclipse.xtext.formatting.INodeModelFormatter.IFormattedRegion;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.formatting.IContentFormatterFactory;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.common.base.Optional;
import com.google.inject.Inject;
import com.reprezen.rapidml.xtext.ui.internal.RepreZenSourceViewerFactory;

public class RepreZenContentFormatterFactory implements IContentFormatterFactory {

    @Inject
    private INodeModelFormatter formatter;

    public class RepreZenContentFormatter implements IContentFormatterExtension, IContentFormatter {

        protected ISourceViewer sourceViewer;
        private RestoreSelectionDocumentListener listener = new RestoreSelectionDocumentListener();

        protected class RestoreSelectionDocumentListener implements IOperationHistoryListener {

            private boolean catchEvent = false;
            private int position = INVALID_POSITION;
            private static final int INVALID_POSITION = -1;

            protected class RestoringPositionUndoContext implements IUndoContext {

                private final Integer undoPosition;
                private final Integer redoPosition;

                public RestoringPositionUndoContext(Integer position, Integer redoPosition) {
                    this.undoPosition = position;
                    this.redoPosition = redoPosition;
                }

                @Override
                public String getLabel() {
                    StringBuffer buffer = new StringBuffer();
                    if (null != undoPosition) {
                        buffer.append("undoPosition :").append(undoPosition).append(", "); //$NON-NLS-1$ //$NON-NLS-2$
                    }
                    if (null != redoPosition) {
                        buffer.append("redoPosition :").append(redoPosition); //$NON-NLS-1$
                    }
                    return buffer.toString();
                }

                @Override
                public boolean matches(IUndoContext context) {
                    Optional<IDocument> document = getDocumentIfPossible(context);
                    return document.isPresent() && document.get().equals(sourceViewer.getDocument());
                }

                public Optional<Integer> getPositionForUndo() {
                    return positionIsValid(undoPosition, sourceViewer.getDocument()) ? Optional
                            .<Integer> of(undoPosition) : Optional.<Integer> absent();
                }

                public Optional<Integer> getPositionForRedo() {
                    return positionIsValid(redoPosition, sourceViewer.getDocument()) ? Optional
                            .<Integer> of(redoPosition) : Optional.<Integer> absent();
                }

            }

            public void catchNextEvent(Integer pos) {
                catchEvent = true;
                position = pos != null && 0 <= pos ? pos.intValue() : INVALID_POSITION;
            }

            @Override
            public void historyNotification(OperationHistoryEvent event) {
                if (catchEvent && OperationHistoryEvent.OPERATION_ADDED == event.getEventType()
                        && operationApplicable(event.getOperation())) {
                    if (positionIsValid(position, sourceViewer.getDocument())) {
                        event.getOperation().addContext(
                                new RestoringPositionUndoContext(position, sourceViewer.getSelectedRange().x));
                    }
                    position = INVALID_POSITION;
                    catchEvent = false;
                }
                if (OperationHistoryEvent.UNDONE == event.getEventType()) {
                    Optional<Integer> position = getPositionIfPossible(event.getOperation(), true);
                    if (position.isPresent() && positionIsValid(position.get(), sourceViewer.getDocument())) {
                        setSourceViewerPosition(sourceViewer, position.get());
                    }
                }
                if (OperationHistoryEvent.REDONE == event.getEventType()) {
                    Optional<Integer> position = getPositionIfPossible(event.getOperation(), false);
                    if (position.isPresent() && positionIsValid(position.get(), sourceViewer.getDocument())) {
                        setSourceViewerPosition(sourceViewer, position.get());
                    }
                }
            }

            protected Optional<Integer> getPositionIfPossible(IUndoableOperation operation, boolean undo) {
                Optional<RestoringPositionUndoContext> position = Optional.<RestoringPositionUndoContext> absent();
                Optional<IDocument> document = Optional.<IDocument> absent();
                for (IUndoContext context : operation.getContexts()) {
                    if (context instanceof RestoringPositionUndoContext) {
                        position = Optional.<RestoringPositionUndoContext> of((RestoringPositionUndoContext) context);
                    }
                    if (!document.isPresent()) {
                        document = getDocumentIfPossible(context);
                    }
                }
                return document.isPresent() && position.isPresent() ? (undo ? position.get().getPositionForUndo()
                        : position.get().getPositionForRedo()) : Optional.<Integer> absent();
            }
        }

        public RepreZenContentFormatter(ISourceViewer sourceViewer) {
            this.sourceViewer = sourceViewer;
            final IOperationHistory operationHistory = OperationHistoryFactory.getOperationHistory();
            operationHistory.addOperationHistoryListener(listener);
            sourceViewer.getTextWidget().addDisposeListener(new DisposeListener() {

                @Override
                public void widgetDisposed(DisposeEvent e) {
                    operationHistory.removeOperationHistoryListener(listener);
                }
            });
        }

        protected boolean operationApplicable(IUndoableOperation operation) {
            for (IUndoContext context : operation.getContexts()) {
                Optional<IDocument> document = getDocumentIfPossible(context);
                if (document.isPresent() && document.get().equals(sourceViewer.getDocument())) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public void format(IDocument document, IFormattingContext context) {
            final Boolean wholeDocument = (Boolean) context.getProperty(FormattingContextProperties.CONTEXT_DOCUMENT);
            final Integer position = (Integer) context
                    .getProperty(RepreZenSourceViewerFactory.FORMATTING_CURSOR_POSITION);
            final IRegion region = (IRegion) context.getProperty(FormattingContextProperties.CONTEXT_REGION);
            IXtextDocument doc = (IXtextDocument) document;
            int x = wholeDocument ? 0 : (null != region ? region.getOffset() : -1);
            int length = wholeDocument ? document.getLength() : (null != region ? region.getLength() : -1);
            if (0 <= x && 0 <= length) {
                Optional<TextEdit> r = doc.readOnly(new FormattingUnitOfWork(new Region(x, length)));
                try {
                    if (r.isPresent()) {
                        if (wholeDocument) {
                            listener.catchNextEvent(position);
                        }
                        r.get().apply(document);
                    }
                } catch (BadLocationException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        @Override
        public void format(IDocument document, IRegion region) {
            IFormattingContext context = new FormattingContext();
            context.setProperty(FormattingContextProperties.CONTEXT_DOCUMENT, Boolean.FALSE);
            context.setProperty(FormattingContextProperties.CONTEXT_REGION, region);
            context.setProperty(RepreZenSourceViewerFactory.FORMATTING_CURSOR_POSITION, Math.max(0, region.getOffset()));
            format(document, context);
        }

        @Override
        public IFormattingStrategy getFormattingStrategy(String contentType) {
            return null;
        }

    }

    protected class FormattingUnitOfWork implements IUnitOfWork<Optional<TextEdit>, XtextResource> {

        private final IRegion region;

        public FormattingUnitOfWork(IRegion region) {
            super();
            this.region = region;
        }

        @Override
        public Optional<TextEdit> exec(XtextResource state) throws Exception {
            IParseResult parseResult = state.getParseResult();
            if (parseResult == null) {
                return Optional.<TextEdit> absent();
            }
            try {
                IFormattedRegion fr = formatter.format(parseResult.getRootNode(), region.getOffset(),
                        region.getLength());
                return Optional.<TextEdit> of(new ReplaceEdit(region.getOffset(), region.getLength(), fr
                        .getFormattedText()));
            } catch (Throwable e) {
                e.printStackTrace();
            }
            return Optional.<TextEdit> absent();
        }
    }

    @Override
    public IContentFormatter createConfiguredFormatter(SourceViewerConfiguration configuration,
            ISourceViewer sourceViewer) {
        return new RepreZenContentFormatter(sourceViewer);
    }

    protected void setSourceViewerPosition(ISourceViewer sourceViewer, Integer position) {
        int offset = position;
        int length = 0;
        sourceViewer.setSelectedRange(position.intValue(), length);
        if (sourceViewer instanceof ITextViewerExtension5) {
            ITextViewerExtension5 extension = (ITextViewerExtension5) sourceViewer;
            extension.exposeModelRange(new Region(offset, length));
        } else if (!sourceViewer.overlapsWithVisibleRegion(offset, length))
            sourceViewer.resetVisibleRegion();

        sourceViewer.setSelectedRange(offset, length);
        sourceViewer.revealRange(offset, length);
    }

    protected Optional<IDocument> getDocumentIfPossible(IUndoContext context) {
        if (context instanceof IDocument) {
            return Optional.<IDocument> of((IDocument) context);
        }
        if (context instanceof ObjectUndoContext) {
            if (((ObjectUndoContext) context).getObject() instanceof IDocument) {
                return Optional.<IDocument> of((IDocument) ((ObjectUndoContext) context).getObject());
            }
        }
        return Optional.<IDocument> absent();
    }

    protected boolean positionIsValid(Integer position, IDocument document) {
        return null != position && 0 <= position && document.getLength() > position;
    }
}
