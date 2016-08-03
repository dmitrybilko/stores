package com.bilko.stores.model.impl;

import java.util.Arrays;

import com.bilko.stores.model.AbstractStore;

public class Pharmacy extends AbstractStore {

    private static Pharmacy instance;

    private Pharmacy() {
        super(Pharmacy.class.getSimpleName(), Arrays.asList(new Antipyretics(), new Painkillers()));
    }

    public static synchronized Pharmacy getInstance() {
        if (instance == null) {
            instance = new Pharmacy();
        }
        return instance;
    }
}
