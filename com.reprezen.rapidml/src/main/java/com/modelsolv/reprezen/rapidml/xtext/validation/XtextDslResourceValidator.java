/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.modelsolv.reprezen.rapidml.xtext.validation;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.validation.ResourceValidatorImpl;

/**
 * @author Tatiana Fesenko <tatiana.fesenko@modelsolv.com> Resource Validator for RepreZen models.
 * 
 */
public class XtextDslResourceValidator extends ResourceValidatorImpl {

    @Override
    protected IAcceptor<Issue> createAcceptor(List<Issue> result) {
        return new SyntaxOrLinkingListBasedMarkerAcceptor(result);
    }

    /**
     * This marker acceptor hides linking errors if syntax errors are present in the model. <br>
     * See <a href="https://modelsolv.atlassian.net/browse/ZEN-605">ZEN-605 Numerous Syntax errors cause failure to
     * recognize defined data types, very hard to diagnose root cause</a> See <a
     * href="http://stackoverflow.com/questions/24391080/hide-linking-errors-when-syntax-errors-are-present">Hide
     * linking errors when syntax errors are present<a/>
     */
    protected static class SyntaxOrLinkingListBasedMarkerAcceptor implements IAcceptor<Issue> {
        private final List<Issue> result;
        private final List<Issue> linkingIssues = new ArrayList<>();
        boolean hasSyntaxIssues;

        protected SyntaxOrLinkingListBasedMarkerAcceptor(List<Issue> result) {
            this.result = result;
        }

        public void accept(Issue issue) {
            if (issue != null) {
                // hide linking errors if syntax errors are present
                if (issue.isSyntaxError()) {
                    result.removeAll(linkingIssues);
                    hasSyntaxIssues = true;
                    result.add(issue);
                } else { // linking error
                    if (!hasSyntaxIssues) {
                        linkingIssues.add(issue);
                        result.add(issue);
                    }
                }
            }
        }

    }

}
