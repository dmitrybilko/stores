package com.bilko.stores.factory.impl;

import java.util.logging.Logger;

import com.bilko.stores.factory.Factory;
import com.bilko.stores.model.Store;
import com.bilko.stores.model.impl.Grocery;
import com.bilko.stores.model.impl.Pharmacy;

public class StoreFactory implements Factory<Store> {

    private static final Logger LOG = Logger.getLogger(StoreFactory.class.getSimpleName());

    @Override
    public Store get(final String type) {
        if (type.equals(Grocery.TAG)) {
            return Grocery.get();
        } else if (type.equals(Pharmacy.TAG)) {
            return Pharmacy.get();
        } else {
            LOG.warning("INCOMPATIBLE STORE TYPE: " + type);
            return null;
        }
    }
}
