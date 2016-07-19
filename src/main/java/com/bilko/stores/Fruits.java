package com.bilko.stores;

class Fruits extends AbstractCategory {

    @Override
    public String getType() {
        return Grocery.class.getSimpleName();
    }
}
