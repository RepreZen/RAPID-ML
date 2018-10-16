/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.modelsolv.reprezen.restapi.xtext.ui.syntaxcoloring;

import static com.google.common.collect.ImmutableSet.copyOf;
import static com.google.common.collect.Iterables.filter;
import static org.eclipse.xtext.EcoreUtil2.eAllContentsAsList;
import static org.eclipse.xtext.EcoreUtil2.typeSelect;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.ComposedSwitch;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.modelsolv.reprezen.restapi.Method;
import com.modelsolv.reprezen.restapi.ObjectRealization;
import com.modelsolv.reprezen.restapi.PropertyRealization;
import com.modelsolv.reprezen.restapi.PropertyReference;
import com.modelsolv.reprezen.restapi.ReferenceEmbed;
import com.modelsolv.reprezen.restapi.ReferenceLink;
import com.modelsolv.reprezen.restapi.ResourceAPI;
import com.modelsolv.reprezen.restapi.ResourceDefinition;
import com.modelsolv.reprezen.restapi.RestapiPackage;
import com.modelsolv.reprezen.restapi.ZenModel;
import com.modelsolv.reprezen.restapi.DataModel;
import com.modelsolv.reprezen.restapi.DataType;
import com.modelsolv.reprezen.restapi.PrimitiveProperty;
import com.modelsolv.reprezen.restapi.ReferenceProperty;
import com.modelsolv.reprezen.restapi.util.RestapiSwitch;
import com.modelsolv.reprezen.restapi.xtext.services.RapidMLGrammarAccess;

/**
 * Calculates highlight regions according to semantic rules.
 *
 * @author Konstantin Zaitsev
 * @date Feb 26, 2015
 */
public class RepreZenSemanticHighlightingCalculator implements ISemanticHighlightingCalculator {

    private Set<Keyword> optionalKeywords;

    @Inject
    public RepreZenSemanticHighlightingCalculator(RapidMLGrammarAccess grammarAccess) {
        this.optionalKeywords = getAllOptionalKeywords(grammarAccess);
    }

    @Override
    public void provideHighlightingFor(XtextResource resource, IHighlightedPositionAcceptor acceptor) {
        if (resource == null) {
            return;
        }

        ComposedSwitch<Void> switcher = new ComposedSwitch<>();
        switcher.addSwitch(new HighlightingSwitch(acceptor));
        switcher.addSwitch(new HighlightingDatatypesSwitch(acceptor));

        Iterator<EObject> iter = EcoreUtil.getAllContents(resource, true);
        while (iter.hasNext()) {
            EObject current = iter.next();
            switcher.doSwitch(current);
        }

        // highlight optional keywords
        if (resource.getParseResult() != null) {
            for (INode node : resource.getParseResult().getRootNode().getAsTreeIterable()) {
                if (optionalKeywords.contains(node.getGrammarElement())) {
                    acceptor.addPosition(node.getOffset(), node.getLength(),
                            RepreZenHighlightingConfiguration.OPTIONAL_KEYWORD_ID);
                }
            }
        }
    }

    private class HighlightingSwitch extends RestapiSwitch<Void> {

        private final IHighlightedPositionAcceptor acceptor;

        public HighlightingSwitch(IHighlightedPositionAcceptor acceptor) {
            this.acceptor = acceptor;
        }

        @Override
        public Void caseZenModel(ZenModel object) {
            return highlightNameNode(acceptor, object, RestapiPackage.eINSTANCE.getZenModel_Name());
        }

        @Override
        public Void caseResourceAPI(ResourceAPI object) {
            return highlightNameNode(acceptor, object, RestapiPackage.eINSTANCE.getResourceAPI_Name());
        }

        @Override
        public Void caseResourceDefinition(ResourceDefinition object) {
            return highlightNameNode(acceptor, object, RestapiPackage.eINSTANCE.getResourceDefinition_Name());
        }

        @Override
        public Void caseMethod(Method object) {
            return highlightNameNode(acceptor, object, RestapiPackage.eINSTANCE.getMethod_Id());
        }

        @Override
        public Void casePropertyRealization(PropertyRealization object) {
            highlightNode(acceptor,
                    getFirstFeatureNode(object, RestapiPackage.eINSTANCE.getPropertyRealization_BaseProperty()),
                    RepreZenHighlightingConfiguration.DEFAULT_ID);
            return null;
        }

        @Override
        public Void caseObjectRealization(ObjectRealization object) {
            highlightNodes(acceptor,
                    getAllFeatureNodes(object, RestapiPackage.eINSTANCE.getObjectRealization_ExcludedProperties()),
                    RepreZenHighlightingConfiguration.DEFAULT_ID);
            return null;
        }

        @Override
        public Void casePropertyReference(PropertyReference object) {
            highlightNode(acceptor,
                    getFirstFeatureNode(object, RestapiPackage.eINSTANCE.getPropertyReference_ConceptualFeature()),
                    RepreZenHighlightingConfiguration.DEFAULT_ID);
            return null;
        }

        @Override
        public Void caseReferenceLink(ReferenceLink object) {
            highlightNode(acceptor,
                    getFirstFeatureNode(object, RestapiPackage.eINSTANCE.getReferenceTreatment_ReferenceElement()),
                    RepreZenHighlightingConfiguration.DEFAULT_ID);
            return null;
        }

        @Override
        public Void caseReferenceEmbed(ReferenceEmbed object) {
            highlightNode(acceptor,
                    getFirstFeatureNode(object, RestapiPackage.eINSTANCE.getReferenceTreatment_ReferenceElement()),
                    RepreZenHighlightingConfiguration.DEFAULT_ID);
            return null;
        }
    }

    private class HighlightingDatatypesSwitch extends RestapiSwitch<Void> {

        private final IHighlightedPositionAcceptor acceptor;

        public HighlightingDatatypesSwitch(IHighlightedPositionAcceptor acceptor) {
            this.acceptor = acceptor;
        }

        @Override
        public Void caseDataModel(DataModel object) {
            return highlightNameNode(acceptor, object, RestapiPackage.eINSTANCE.getDataModel_Name());
        }

        @Override
        public Void caseDataType(DataType object) {
            return highlightNameNode(acceptor, object, RestapiPackage.eINSTANCE.getDataType_Name());
        }

        @Override
        public Void caseReferenceProperty(ReferenceProperty object) {
            highlightNode(acceptor, getFirstFeatureNode(object, RestapiPackage.Literals.FEATURE__NAME),
                    RepreZenHighlightingConfiguration.DEFAULT_ID);
            highlightNode(acceptor, getFirstFeatureNode(object, RestapiPackage.Literals.REFERENCE_PROPERTY__INVERSE),
                    RepreZenHighlightingConfiguration.DEFAULT_ID);
            return null;
        }

        @Override
        public Void casePrimitiveProperty(PrimitiveProperty object) {
            highlightNode(acceptor, getFirstFeatureNode(object, RestapiPackage.Literals.FEATURE__NAME),
                    RepreZenHighlightingConfiguration.DEFAULT_ID);
            return null;
        }
    }

    private Void highlightNameNode(IHighlightedPositionAcceptor acceptor, EObject semantic,
            EStructuralFeature feature) {
        INode node = getFirstFeatureNode(semantic, feature);
        highlightNode(acceptor, node, RepreZenHighlightingConfiguration.NAME_ID);
        return null;
    }

    private void highlightNode(IHighlightedPositionAcceptor acceptor, INode node, String highlightConfigurationId) {
        if (node == null) {
            return;
        }
        if (node instanceof ILeafNode) {
            acceptor.addPosition(node.getOffset(), node.getLength(), highlightConfigurationId);
        } else {
            for (ILeafNode leaf : node.getLeafNodes()) {
                if (!leaf.isHidden()) {
                    acceptor.addPosition(leaf.getOffset(), leaf.getLength(), highlightConfigurationId);
                }
            }
        }
    }

    private void highlightNodes(IHighlightedPositionAcceptor acceptor, Collection<INode> nodes,
            String highlightConfigurationId) {
        nodes.stream().forEach(node -> highlightNode(acceptor, node, highlightConfigurationId));
    }

    private INode getFirstFeatureNode(EObject semantic, EStructuralFeature feature) {
        if (feature == null) {
            return NodeModelUtils.findActualNodeFor(semantic);
        }
        List<INode> nodes = NodeModelUtils.findNodesForFeature(semantic, feature);
        if (!nodes.isEmpty()) {
            return Iterables.getFirst(nodes, null);
        }
        return null;
    }

    private List<INode> getAllFeatureNodes(EObject semantic, EStructuralFeature feature) {
        if (feature == null) {
            ICompositeNode node = NodeModelUtils.findActualNodeFor(semantic);
            if (node != null) {
                return Lists.newArrayList(node);
            } else {
                return Lists.newArrayList();
            }
        }
        return NodeModelUtils.findNodesForFeature(semantic, feature);
    }

    /**
     * Gets the all optional keyword where cardinality is set to '?'.
     *
     * @param grammarAccess
     *            the grammar access
     * @return the all optional keyword
     */
    private Set<Keyword> getAllOptionalKeywords(RapidMLGrammarAccess grammarAccess) {
        Grammar g = grammarAccess.getGrammar();
        List<Keyword> kws = new ArrayList<>();

        for (ParserRule parserRule : GrammarUtil.allParserRules(g)) {
            kws.addAll(typeSelect(eAllContentsAsList(parserRule), Keyword.class));
        }
        for (EnumRule enumRule : GrammarUtil.allEnumRules(g)) {
            kws.addAll(typeSelect(eAllContentsAsList(enumRule), Keyword.class));
        }

        // add implicit keywords that should be highlighted as optional
        // This is because 'bound' keyword is optional for group: ('bound' 'to'?)?
        // but our algorithm track only this kind of keyword 'keyword'?
        final Set<Keyword> implicitKeywords = new HashSet<>();
        implicitKeywords.add(grammarAccess.getPropertyReferenceAccess().getBoundKeyword_1_0());
        implicitKeywords.add(grammarAccess.getObjectResourceAccess().getBoundKeyword_6_0_0());
        implicitKeywords.add(grammarAccess.getCollectionResourceAccess().getBoundKeyword_6_0_0());
        // Authentication
        implicitKeywords.add(grammarAccess.getAuthenticationMethodAccess().getAuthorizedKeyword_3_2_0());
        implicitKeywords.add(grammarAccess.getSecuritySchemeAccess().getRequiresKeyword_13());
        implicitKeywords.add(grammarAccess.getSecuritySchemeAccess().getDefinesKeyword_22_1());

        implicitKeywords.add(grammarAccess.getZenModelAccess().getTitleKeyword_7_2());
        implicitKeywords.add(grammarAccess.getResourceAPIAccess().getTitleKeyword_6_1_2());
        implicitKeywords.add(grammarAccess.getDataModelAccess().getTitleKeyword_6_2());

        return copyOf(filter(kws, new Predicate<Keyword>() {
            @Override
            public boolean apply(Keyword keyword) {
                return implicitKeywords.contains(keyword) || "?".equals(keyword.getCardinality()); //$NON-NLS-1$
            }
        }));
    }
}
