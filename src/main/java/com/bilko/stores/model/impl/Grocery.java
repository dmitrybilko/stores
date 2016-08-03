package com.bilko.stores.model.impl;

import java.util.Arrays;

import com.bilko.stores.model.AbstractStore;

public class Grocery extends AbstractStore {

    private static Grocery instance;

    private Grocery() {
        super(Grocery.class.getSimpleName(), Arrays.asList(new Fruits(), new Vegetables()));
    }

    public static synchronized Grocery getInstance() {
        if (instance == null) {
            instance = new Grocery();
        }
        return instance;
    }
}
