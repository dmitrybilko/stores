package com.bilko.stores;

import java.util.Arrays;

class Grocery extends AbstractStore {

    private static Grocery instance;

    private Grocery() {
        super(Arrays.asList(new Fruits(), new Vegetables()));
    }

    static synchronized Grocery getInstance() {
        if (instance == null) {
            instance = new Grocery();
        }
        return instance;
    }
}
