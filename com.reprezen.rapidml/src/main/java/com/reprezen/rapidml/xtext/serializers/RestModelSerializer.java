/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.xtext.serializers;

import com.reprezen.rapidml.ZenModel;

/**
 * Serializer for the ModelSolv RESTApi metamodel.
 * 
 * @author jimleroyer
 * @since 2013/04/25
 */
public interface RestModelSerializer {

	/**
	 * Serializes an {@link com.modelsolv.reprezen.restapi.ZenModel} at the given
	 * path.
	 * 
	 * @param path
	 *            Location of the RESTApi metamodel.
	 * @param model
	 *            {@link com.modelsolv.reprezen.restapi.ZenModel} to serialize.
	 */
	public void serialize(String path, ZenModel model);

}
