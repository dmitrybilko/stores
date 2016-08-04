package com.bilko.stores.factory.impl;

import com.bilko.stores.factory.StoreFactory;
import com.bilko.stores.model.Store;
import com.bilko.stores.model.impl.Grocery;

public class GroceryFactory implements StoreFactory {

    @Override
    public Store getStore() {
        return Grocery.get();
    }
}
