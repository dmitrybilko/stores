package com.bilko.stores;

class Pharmacy extends Store {

    private static Pharmacy instance;

    private Pharmacy() {}

    static synchronized Pharmacy getInstance() {
        if (instance == null) {
            instance = new Pharmacy();
        }
        return instance;
    }
}
