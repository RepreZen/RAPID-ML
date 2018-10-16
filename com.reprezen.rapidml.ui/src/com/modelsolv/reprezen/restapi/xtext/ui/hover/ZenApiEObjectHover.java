/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.modelsolv.reprezen.restapi.xtext.ui.hover;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Region;
import org.eclipse.xtext.EnumLiteralDeclaration;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.hover.DispatchingEObjectTextHover;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;

import com.modelsolv.reprezen.restapi.TemplateParameter;
import com.modelsolv.reprezen.restapi.TypedRequest;
import com.modelsolv.reprezen.restapi.TypedResponse;

public class ZenApiEObjectHover extends DispatchingEObjectTextHover {

    @Override
    protected Pair<EObject, IRegion> getXtextElementAt(XtextResource resource, int offset) {
        Pair<EObject, IRegion> temp = super.getXtextElementAt(resource, offset);
        if (temp == null || isWithoutModelRepresentative(temp.getFirst())) {
            ILeafNode node = NodeModelUtils.findLeafNodeAtOffset(resource.getParseResult().getRootNode(), offset);
            if (node != null &&  (node.getGrammarElement() instanceof Keyword
                    || node.getGrammarElement() instanceof EnumLiteralDeclaration)) {
                IRegion region = new Region(node.getOffset(), node.getLength());
                temp = Tuples.create(node.getGrammarElement(), region);
            }
        }
        return temp;
    }

    protected boolean isWithoutModelRepresentative(EObject obj) {
        return obj == null || obj instanceof TemplateParameter || obj instanceof TypedRequest
                || obj instanceof TypedResponse;
    }
}
