/** 
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 */
package
/*
 * generated by Xtext
 */
com.reprezen.rapidml.xtext

import org.eclipse.xtext.conversion.IValueConverterService
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.parser.IParser
import org.eclipse.xtext.parser.antlr.ISyntaxErrorMessageProvider
import org.eclipse.xtext.parsetree.reconstr.ITokenSerializer.IValueSerializer
import org.eclipse.xtext.resource.ILocationInFileProvider
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.scoping.IGlobalScopeProvider
import org.eclipse.xtext.scoping.IScopeProvider
import com.google.inject.Binder
import com.google.inject.name.Names
import com.reprezen.rapidml.xtext.conversion.RestTerminalConverters
import com.reprezen.rapidml.xtext.formatting.RepreZenNodeModelStreamer
import com.reprezen.rapidml.xtext.loaders.RepreZenXtextResourceSet
import com.reprezen.rapidml.xtext.naming.RepreZenQualifiedNameConverter
import com.reprezen.rapidml.xtext.parser.CustomSyntaxErrorMessageProvider
import com.reprezen.rapidml.xtext.parser.RepreZenDslParser
import com.reprezen.rapidml.xtext.resource.RepreZenLocationInFileProvider
import com.reprezen.rapidml.xtext.scoping.ImportedNamespaceScopeProvider
import com.reprezen.rapidml.xtext.scoping.RepreZenImportUriGlobalScopeProvider
import com.reprezen.rapidml.xtext.serializers.RepreZenValueSerializer
import com.reprezen.rapidml.xtext.validation.XtextDslResourceValidator

/** 
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
class XtextDslRuntimeModule extends com.reprezen.rapidml.xtext.AbstractXtextDslRuntimeModule {
	override Class<? extends IValueConverterService> bindIValueConverterService() {
		return RestTerminalConverters
	}

	override void configureIScopeProviderDelegate(com.google.inject.Binder binder) {
		binder.bind(org.eclipse.xtext.scoping.IScopeProvider).annotatedWith(
			Names.named(org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider.NAMED_DELEGATE)).to(
			ImportedNamespaceScopeProvider)
	}

	def Class<? extends ISyntaxErrorMessageProvider> bindISyntaxErrorMessageProvider() {
		return CustomSyntaxErrorMessageProvider
	}

	def Class<? extends IValueSerializer> bindIValueSerializer() {
		return RepreZenValueSerializer
	}

	def Class<? extends org.eclipse.xtext.validation.IResourceValidator> bindIResourceValidator() {
		return XtextDslResourceValidator
	}

	def Class<? extends org.eclipse.xtext.formatting.INodeModelStreamer> bindINodeModelStreamer() {
		return RepreZenNodeModelStreamer
	}

	override Class<? extends IParser> bindIParser() {
		return RepreZenDslParser
	}

	override Class<? extends IQualifiedNameProvider> bindIQualifiedNameProvider() {
		return com.reprezen.rapidml.xtext.naming.RepreZenDeclarativeQualifiedNameProvider
	}

	override Class<? extends IScopeProvider> bindIScopeProvider() {
		return super.bindIScopeProvider()
	}

	override Class<? extends IGlobalScopeProvider> bindIGlobalScopeProvider() {
		return RepreZenImportUriGlobalScopeProvider
	}

	override Class<? extends XtextResourceSet> bindXtextResourceSet() {
		return RepreZenXtextResourceSet
	}

	def void configureQualifiedNameConverter(Binder binder) {
		binder.bind(IQualifiedNameConverter).to(RepreZenQualifiedNameConverter)
	}

	override Class<? extends ILocationInFileProvider> bindILocationInFileProvider() {
		return RepreZenLocationInFileProvider
	}
}