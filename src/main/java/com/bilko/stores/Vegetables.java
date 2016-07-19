package com.bilko.stores;

class Vegetables extends AbstractCategory {

    @Override
    public String getType() {
        return Grocery.class.getSimpleName();
    }
}
