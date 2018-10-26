/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.xtext.ui.contentassist;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.ui.editor.contentassist.ConfigurableCompletionProposal;
import org.eclipse.xtext.ui.editor.contentassist.ReplacementTextApplier;

import com.reprezen.rapidml.RapidmlPackage;
import com.reprezen.rapidml.ReferenceProperty;

/**
 * Sets the current {@link ReferenceProperty} to the other end of {@link ReferenceProperty#getInverse()}.
 * 
 * @author Tatiana Fesenko <tatiana.fesenko@modelsolv.com>
 * 
 */
public class InverseReplacementTextApplier extends ReplacementTextApplier {

    private static final String INVERSE = "inverse";
    private static final String CONTAINER = "container";
    private static final String CONTAINMENT = "containing";
    private final ReferenceProperty referenceProperty;
    private final IScope scope;
    private final IQualifiedNameConverter qualifiedNameConverter;
    private final IValueConverter<String> qualifiedNameValueConverter;

    public InverseReplacementTextApplier(ReferenceProperty referenceProperty, IScope scope,
            IQualifiedNameConverter qualifiedNameConverter, IValueConverter<String> qualifiedNameValueConverter) {
        this.referenceProperty = referenceProperty;
        this.scope = scope;
        this.qualifiedNameConverter = qualifiedNameConverter;
        this.qualifiedNameValueConverter = qualifiedNameValueConverter;

    }

    @Override
    public void apply(IDocument document, ConfigurableCompletionProposal proposal) throws BadLocationException {
        String replacementString = getActualReplacementString(proposal);
        proposal.setCursorPosition(replacementString.length());
        int replacementOffset = proposal.getReplacementOffset();

        IEObjectDescription oppositeDescription = scope.getSingleElement(qualifiedNameConverter
                .toQualifiedName(qualifiedNameValueConverter.toValue(replacementString, null)));
        EObject opposite = oppositeDescription.getEObjectOrProxy();
        ReferenceProperty oppositeReference = (ReferenceProperty) opposite;

        List<INode> nodes = NodeModelUtils.findNodesForFeature(opposite,
                RapidmlPackage.Literals.REFERENCE_PROPERTY__TYPE);
        if (!nodes.isEmpty()) {
            INode node = nodes.get(nodes.size() - 1);
            int offset = node.getEndOffset();

            // ZEN-3617: offset should be moved if the node is followed by a multiple cardinality,
            // otherwise the replacement would be done between the node and the cardinality.
            INode nextNode = node.getNextSibling();
            if (nextNode != null && nextNode.getText().contains("*")) {
                offset = nextNode.getEndOffset();
            }

            String oppositeReplacement = " " + INVERSE + " "
                    + qualifiedNameValueConverter.toString(referenceProperty.getName());
            String containerReplacement = "";
            if (referenceProperty.isContainer() && !oppositeReference.isContainment()) {
                containerReplacement = " " + CONTAINMENT + " ";
            }
            if (referenceProperty.isContainment() && !oppositeReference.isContainer()) {
                containerReplacement = " " + CONTAINER + " ";
            }
            if (replacementOffset > offset) {
                // the 'opposite' reference is defined BEFORE the edited reference
                document.replace(replacementOffset, proposal.getReplacementLength(), replacementString);
                document.replace(offset, 0, containerReplacement);
                document.replace(offset + containerReplacement.length(), 0, oppositeReplacement);
            } else {
                // the 'opposite' reference is defined AFTER the edited reference
                document.replace(offset, 0, containerReplacement);
                document.replace(offset + containerReplacement.length(), 0, oppositeReplacement);
                document.replace(replacementOffset, proposal.getReplacementLength(), replacementString);
            }
            return;
        }
        document.replace(replacementOffset, proposal.getReplacementLength(), replacementString);
    }

    @Override
    public String getActualReplacementString(ConfigurableCompletionProposal proposal) {
        return proposal.getReplacementString();
    }

}
