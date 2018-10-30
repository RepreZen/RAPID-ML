/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.xtext.ui.editor.templates;

import static org.eclipse.xtext.Constants.LANGUAGE_NAME;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.text.templates.ContextTypeRegistry;
import org.eclipse.jface.text.templates.Template;
import org.eclipse.jface.text.templates.TemplateContextType;
import org.eclipse.jface.text.templates.persistence.TemplateStore;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.IFollowElementAcceptor;
import org.eclipse.xtext.ui.editor.templates.ContextTypeIdHelper;
import org.eclipse.xtext.ui.editor.templates.DefaultTemplateProposalProvider;
import org.eclipse.xtext.util.XtextSwitch;

import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.reprezen.rapidml.xtext.ui.internal.RepreZenDslActivator;

/**
 * @author Konstantin Zaitsev
 * @date Mar 30, 2015
 */
public class RepreZenTemplateProposalProvider extends DefaultTemplateProposalProvider {

    private ContextTypeRegistry registry;
    private String languageName;
    private ContextTypeIdHelper helper;
    private Image image;


    @Inject
    public RepreZenTemplateProposalProvider(TemplateStore templateStore, ContextTypeRegistry registry,
            ContextTypeIdHelper helper, @Named(LANGUAGE_NAME) String languageName) {
        super(templateStore, registry, helper);
        this.registry = registry;
        this.helper = helper;
        this.languageName = languageName;
    }
    
    @Override
    public Image getImage(Template template) {
        // ZEN-2286 - Use consistent code assist icons between RAPID-ML & SwagEdit, update end user docs
        if (image == null) {
            ImageDescriptor imageDescriptor = RepreZenDslActivator
                    .getImageDescriptor("icons/contentassist_template.png"); //$NON-NLS-1$
            image = imageDescriptor.createImage();
        }
        return image;
    }

    @Override
    protected TemplateContextType[] getContextTypes(ContentAssistContext context) {
        final Set<TemplateContextType> result = Sets.newLinkedHashSet();
        IFollowElementAcceptor acceptor = new RepreZenFollowElementAcceptor(result);
        List<AbstractElement> grammarElements = context.getFirstSetGrammarElements();
        for (AbstractElement element : grammarElements) {
            acceptor.accept(element);
        }
        // Added EObject based template context from content assist context
        if (context.getPreviousModel() != null) {
            TemplateContextType contextType = registry.getContextType(languageName + "." //$NON-NLS-1$
                    + context.getPreviousModel().eClass().getName());
            if (contextType != null) {
                result.add(contextType);
            }
        }
        return result.toArray(new TemplateContextType[result.size()]);
    }

    public class RepreZenFollowElementAcceptor extends XtextSwitch<Boolean> implements IFollowElementAcceptor {

        private final Collection<TemplateContextType> result;

        public RepreZenFollowElementAcceptor(Collection<TemplateContextType> result) {
            this.result = result;
        }

        @Override
        public Boolean defaultCase(EObject object) {
            return Boolean.TRUE;
        }

        @Override
        public Boolean caseKeyword(Keyword object) {
            addContextType(object);
            return Boolean.TRUE;
        }

        @Override
        public Boolean caseRuleCall(RuleCall object) {
            doSwitch(object.getRule());
            return Boolean.TRUE;
        }

        @Override
        public Boolean caseParserRule(ParserRule object) {
            // ignore this rule because it incorrect include parent node from content assist context
            // addContextType(object);
            return Boolean.TRUE;
        }

        @Override
        public Boolean caseAssignment(Assignment object) {
            accept(object.getTerminal());
            return Boolean.TRUE;
        }

        @Override
        public void accept(AbstractElement element) {
            doSwitch(element);
        }

        protected void addContextType(Keyword keyword) {
            addContextType(helper.getId(keyword));
        }

        protected void addContextType(String id) {
            TemplateContextType contextType = registry.getContextType(id);
            if (contextType != null)
                result.add(contextType);
        }
    }

}
