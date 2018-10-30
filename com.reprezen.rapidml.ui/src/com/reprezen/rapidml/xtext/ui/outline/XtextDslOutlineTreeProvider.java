/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.xtext.ui.outline;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider;

import com.reprezen.rapidml.DataExample;
import com.reprezen.rapidml.Example;
import com.reprezen.rapidml.ReferenceRealization;
import com.reprezen.rapidml.ResourceDefinition;
import com.reprezen.rapidml.URI;

/**
 * customization of the default outline structure.
 * Labels are defined in {link {@link XtextDslLabelProvider}.
 * @author Tatiana Fesenko <tatiana.fesenko@modelsolv.com>
 * 
 */
public class XtextDslOutlineTreeProvider extends DefaultOutlineTreeProvider {

    @Override
    protected void _createChildren(IOutlineNode parentNode, EObject modelElement) {
        for (EObject childElement : modelElement.eContents()) {
            if (!filter(modelElement, childElement)) {
                createNode(parentNode, childElement);
            }
            if (isReferenceRealization(childElement)) {
                _createChildren(parentNode, childElement);
            }
        }
    }

    protected boolean filter(EObject parentElement, EObject childElement) {
        return isResourceUri(parentElement, childElement) || isExample(childElement)
                || isReferenceRealization(childElement);
    }

    private boolean isResourceUri(EObject parentElement, EObject childElement) {
        return (parentElement instanceof ResourceDefinition) && (childElement instanceof URI);
    }
    
    private boolean isExample(EObject childElement) {
        // do not show examples
        return childElement instanceof Example || childElement instanceof DataExample;
    }
    
    private boolean isReferenceRealization(EObject childElement) {
        return childElement instanceof ReferenceRealization;
    }

}
