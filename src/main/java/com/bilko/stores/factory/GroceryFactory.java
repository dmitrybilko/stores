package com.bilko.stores.factory;

import com.bilko.stores.model.Store;
import com.bilko.stores.model.impl.Grocery;

public class GroceryFactory implements StoreFactory {

    @Override
    public Store getStore() {
        return Grocery.getInstance();
    }
}
