package com.bilko.stores;

class Grocery extends Store {

    private static Grocery instance;

    private Grocery() {}

    static synchronized Grocery getInstance() {
        if (instance == null) {
            instance = new Grocery();
        }
        return instance;
    }
}
