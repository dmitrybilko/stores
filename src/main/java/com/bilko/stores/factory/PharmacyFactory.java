package com.bilko.stores.factory;

import com.bilko.stores.model.Store;
import com.bilko.stores.model.impl.Pharmacy;

public class PharmacyFactory implements StoreFactory {

    @Override
    public Store getStore() {
        return Pharmacy.getInstance();
    }
}
