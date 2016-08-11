package com.bilko.stores.model.impl;

import java.util.Arrays;

import org.bson.types.ObjectId;

import com.bilko.stores.model.AbstractStore;

public class Grocery extends AbstractStore {

    public static final String TAG = Grocery.class.getSimpleName();

    private static Grocery instance;

    private Grocery() {
        super(ObjectId.get().toString(), TAG, Arrays.asList(new Fruits(), new Vegetables()));
    }

    public static synchronized Grocery get() {
        if (instance == null) {
            instance = new Grocery();
        }
        return instance;
    }
}
