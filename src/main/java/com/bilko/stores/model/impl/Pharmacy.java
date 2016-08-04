package com.bilko.stores.model.impl;

import java.util.Arrays;

import org.bson.types.ObjectId;

import com.bilko.stores.model.AbstractStore;

public class Pharmacy extends AbstractStore {

    private static Pharmacy instance;

    private Pharmacy() {
        super(ObjectId.get().toString(), Pharmacy.class.getSimpleName(), Arrays.asList(new Antipyretics(), new Painkillers()));
    }

    public static synchronized Pharmacy get() {
        if (instance == null) {
            instance = new Pharmacy();
        }
        return instance;
    }
}
