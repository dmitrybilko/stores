package com.bilko.stores.factory.impl;

import com.bilko.stores.factory.StoreFactory;
import com.bilko.stores.model.Store;
import com.bilko.stores.model.impl.Pharmacy;

public class PharmacyFactory implements StoreFactory {

    @Override
    public Store getStore() {
        return Pharmacy.get();
    }
}
