package com.bilko.stores;

class GroceryFactory implements StoreFactory {

    @Override
    public Store getStore() {
        return Grocery.getInstance();
    }
}
