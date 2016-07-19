package com.bilko.stores;

import java.util.Arrays;

class Pharmacy extends AbstractStore {

    private static Pharmacy instance;

    private Pharmacy() {
        super(Arrays.asList(new Antipyretics(), new Painkillers()));
    }

    static synchronized Pharmacy getInstance() {
        if (instance == null) {
            instance = new Pharmacy();
        }
        return instance;
    }
}
