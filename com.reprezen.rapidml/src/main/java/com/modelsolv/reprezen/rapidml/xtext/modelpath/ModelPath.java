/*******************************************************************************
 * Copyright © 2013, 2018 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.modelsolv.reprezen.rapidml.xtext.modelpath;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;

public class ModelPath {
    List<ModelPathItem> items = Lists.newArrayList();
    private String name;

    public ModelPath(List<ModelPathItem> items) {
        this.items = items;
    }

    public ModelPath(String modelPathString) {
        this(Arrays.stream(modelPathString.split(";|[\\r\\n]+"))
                .map((String itemString) -> new ModelPathItem(itemString)).collect(Collectors.toList()));
    }

    public List<ModelPathItem> getItems() {
        return items;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.join("; ",
                items.stream().map((ModelPathItem item) -> item.toString()).collect(Collectors.toList()));
    }

}