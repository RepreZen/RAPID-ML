/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.xtext.serializers;

import javax.inject.Inject;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parsetree.reconstr.impl.ValueSerializer;

import com.google.common.base.Strings;
import com.reprezen.rapidml.xtext.services.RepreZenTerminalsGrammarAccess;

public class RepreZenValueSerializer extends ValueSerializer {

    @Inject
    private RepreZenTerminalsGrammarAccess grammarAccess;

    private int indentLevel = 0;

    @Override
    public String serializeUnassignedValue(EObject context, RuleCall ruleCall, INode node) {
        if (ruleCall.getRule().equals(grammarAccess.getBEGINRule())) {
            indentLevel++;
            return "\t";
        }
        if (ruleCall.getRule().equals(grammarAccess.getENDRule())) {
            indentLevel--;
            return "";
        }
        if (ruleCall.getRule().equals(grammarAccess.getNLRule())) {
            return "\n" + Strings.repeat("\t", indentLevel);
        }
        return super.serializeUnassignedValue(context, ruleCall, node);
    }

}
