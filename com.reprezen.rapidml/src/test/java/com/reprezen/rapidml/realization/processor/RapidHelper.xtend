/*******************************************************************************
 * Copyright © 2013, 2018 Modelsolv, Inc.
 * All Rights Reserved.
 * 
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.realization.processor

import com.reprezen.rapidml.DataModel
import com.reprezen.rapidml.HTTPMethods
import com.reprezen.rapidml.Method
import com.reprezen.rapidml.ResourceAPI
import com.reprezen.rapidml.ResourceDefinition
import com.reprezen.rapidml.Structure
import com.reprezen.rapidml.TypedMessage
import com.reprezen.rapidml.TypedRequest
import com.reprezen.rapidml.TypedResponse
import com.reprezen.rapidml.ZenModel

class RapidHelper {
	def api(ZenModel model, String name) {
		model.resourceAPIs.filter[it.name == name].head
	}

	def resource(ResourceAPI api, String name) {
		api.ownedResourceDefinitions.filter[it.name == name].head
	}

	def realizationModel(ResourceAPI api, String name) {
		api.autoRealizations.filter[it.realizationModel.name == name].head?.realizationModel
	}

	def method(ResourceDefinition resource, HTTPMethods op) {
		resource.methods.filter[it.httpMethod == op].head
	}

	def method(ResourceDefinition resource, String op) {
		resource.method(HTTPMethods.valueOf(op))
	}

	def get_Method(ResourceDefinition resource) {
		resource.method(HTTPMethods.GET)
	}

	def getMethod(TypedMessage message) {
		switch (message) {
			TypedResponse: message.containingMethod
			TypedRequest: message.containingMethod
		}
	}

	def getResource(Method method) {
		method.eContainer as ResourceDefinition
	}

	def response(Method method, int status) {
		method.responses.filter[it.statusCode == status].head
	}

	def normalResponse(Method method) {
		method.response(200)
	}

	def field(Structure struct, String name) {
		struct.ownedFeatures.filter[it.name == name].head
	}

	def dataModel(ZenModel model, String name) {
		model.dataModels.filter[it.name == name].head
	}

	def type(DataModel dataModel, String name) {
		dataModel.ownedDataTypes.filter[it.name == name].head
	}

	def structure(DataModel dataModel, String name) {
		dataModel.ownedDataTypes.filter[it instanceof Structure && it.name == name].head
	}

	def tbApi(ZenModel model) {
		model.api("TaxBlasterAPI")
	}

	def tbTaxFilingObject(ZenModel model) {
		model.tbApi.resource("TaxFilingObject")
	}

	def tbTaxFilingCollection(ZenModel model) {
		model.tbApi.resource("TaxFilingCollection")
	}

	def tbDataModel(ZenModel model) {
		model.dataModel("TaxBlasterDataModel")
	}

	def tbTaxFiling(ZenModel model) {
		model.tbDataModel.structure("TaxFiling")
	}

	def tbPerson(ZenModel model) {
		model.tbDataModel.structure("Person")
	}

	def tbPersonObject(ZenModel model) {
		model.tbApi.resource("PersonObject")
	}

	def tbPersonCollection(ZenModel model) {
		model.tbApi.resource("PersonCollection")
	}

	def tbAccountantObject(ZenModel model) {
		model.tbApi.resource("AccountantObject")
	}

	def tbAccountantCollection(ZenModel model) {
		model.tbApi.resource("AccountantCollection")
	}
	
	def tbAddressObject(ZenModel model) {
		model.tbApi.resource("AddressObject")
	}

	def tbFinancialStatementObject(ZenModel model) {
		model.tbApi.resource("FinancialStatementObject")
	}

	def tbBalanceSheetObject(ZenModel model) {
		model.tbApi.resource("BalanceSheetObject")
	}

	def tbBalanceSheetCollection(ZenModel model) {
		model.tbApi.resource("BalanceSheetCollection")
	}

	def tbIncomeStatementObject(ZenModel model) {
		model.tbApi.resource("IncomeStatementObject")
	}

	def tbIndexObject(ZenModel model) {
		model.tbApi.resource("IndexObject")
	}

	def tbCommentCollection(ZenModel model) {
		model.tbApi.resource("CommentCollection")
	}
}
