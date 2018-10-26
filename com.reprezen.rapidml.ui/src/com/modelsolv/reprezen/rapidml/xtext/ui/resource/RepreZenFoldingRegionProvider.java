/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.modelsolv.reprezen.rapidml.xtext.ui.resource;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.folding.DefaultFoldingRegionProvider;
import org.eclipse.xtext.ui.editor.folding.IFoldingRegionAcceptor;
import org.eclipse.xtext.util.ITextRegion;

/**
 * @author Konstantin Zaitsev
 * @date Dec 23, 2014
 */
public class RepreZenFoldingRegionProvider extends DefaultFoldingRegionProvider {

    @Override
    protected void computeObjectFolding(XtextResource xtextResource,
            IFoldingRegionAcceptor<ITextRegion> foldingRegionAcceptor) {
        // add additional folding to root ZenModel element
        IParseResult parseResult = xtextResource.getParseResult();
        if (parseResult != null) {
            EObject rootASTElement = parseResult.getRootASTElement();
            if (rootASTElement != null) {
                computeObjectFolding(rootASTElement, foldingRegionAcceptor);
            }
        }
        super.computeObjectFolding(xtextResource, foldingRegionAcceptor);
    }
}
