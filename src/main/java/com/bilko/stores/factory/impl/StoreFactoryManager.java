package com.bilko.stores.factory.impl;

import java.util.logging.Logger;

import com.bilko.stores.factory.StoreFactory;
import com.bilko.stores.model.impl.Grocery;
import com.bilko.stores.model.impl.Pharmacy;

public class StoreFactoryManager {

    private static final Logger LOG = Logger.getLogger(StoreFactoryManager.class.getSimpleName());

    private static StoreFactoryManager instance;

    private StoreFactoryManager() {}

    public static synchronized StoreFactoryManager get() {
        if (instance == null) {
            instance = new StoreFactoryManager();
        }
        return instance;
    }

    public StoreFactory getStoreFactory(final String title) {
        if (title.equals(Grocery.TAG)) {
            return new GroceryFactory();
        } else if (title.equals(Pharmacy.TAG)) {
            return new PharmacyFactory();
        } else {
            LOG.warning("INCOMPATIBLE STORE TYPE: " + title);
            return null;
        }
    }
}
