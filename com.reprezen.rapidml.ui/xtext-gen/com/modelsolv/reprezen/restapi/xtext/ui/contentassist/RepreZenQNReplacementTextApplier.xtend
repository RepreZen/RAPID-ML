package com.modelsolv.reprezen.restapi.xtext.ui.contentassist

import com.google.common.collect.Iterables
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.conversion.IValueConverterService
import org.eclipse.xtext.conversion.ValueConverterException
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.scoping.IScope
import org.eclipse.xtext.ui.editor.contentassist.ConfigurableCompletionProposal
import org.eclipse.xtext.ui.editor.contentassist.ReplacementTextApplier

class RepreZenQNReplacementTextApplier extends ReplacementTextApplier {
	final IScope scope
	final Resource context
	final IQualifiedNameConverter qualifiedNameConverter
	final String ruleName
	final IValueConverterService valueConverter

	new(Resource context, 
		IScope scope, 
		IQualifiedNameConverter qualifiedNameConverter, 
		String ruleName,
		IValueConverterService valueConverter
	) {
		this.context = context
		this.scope = scope
		this.qualifiedNameConverter = qualifiedNameConverter
		this.ruleName = ruleName
		this.valueConverter = valueConverter
	}

	override String getActualReplacementString(ConfigurableCompletionProposal proposal) {
		var String replacementString = proposal.getReplacementString()
		if (scope !== null) {
			val QualifiedName proposalQName = qualifiedNameConverter.toQualifiedName(replacementString)
			val IEObjectDescription proposalDescription = scope.getSingleElement(proposalQName)
			val QualifiedName simpleQName = qualifiedNameConverter.toQualifiedName(proposalQName.getLastSegment())
			if (isNameClash(simpleQName, proposalDescription)) {
				if (simpleQName.equals(proposalQName)) {
					replacementString = qualifiedNameConverter.toString(proposalDescription.getQualifiedName())
				} else {
					replacementString = qualifiedNameConverter.toString(proposalQName)
				}
			} else {
				replacementString = qualifiedNameConverter.toString(simpleQName)
			}
		}
		if (null !== ruleName) {
			try {
				replacementString = valueConverter.toString(replacementString, ruleName)
			} catch (ValueConverterException e) {
				return null
			}

		}
		return replacementString
	}

	def private boolean isNameClash(QualifiedName proposalQName, IEObjectDescription proposalDescription) {
		return Iterables.any(scope.getAllElements(), [ IEObjectDescription input |
			var QualifiedName elementQName = input.getName()
			var int skipCount = elementQName.getSegmentCount() - proposalQName.getSegmentCount()
			if (skipCount >= 0) {
				if (elementQName.skipFirst(skipCount).equals(proposalQName) &&
					!input.getEObjectURI().equals(proposalDescription.getEObjectURI())) {
					return true
				}
			}
			return false
		])
	} // use alias-qualified name
}