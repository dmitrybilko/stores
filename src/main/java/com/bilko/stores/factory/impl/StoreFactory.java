package com.bilko.stores.factory.impl;

import java.util.logging.Logger;

import com.bilko.stores.factory.ModelFactory;
import com.bilko.stores.model.Store;
import com.bilko.stores.model.impl.Grocery;
import com.bilko.stores.model.impl.Pharmacy;

/**
 * {@code ModelFactory} implementation is used to return {@link Store} instance.
 *
 * @author Dmitry Bilko
 * @see Store
 * @since 1.0
 */
public class StoreFactory implements ModelFactory<Store> {

    /**
     * Default logger for {@code StoreFactory} class.
     */
    private static final Logger LOG = Logger.getLogger(StoreFactory.class.getSimpleName());

    @Override
    public final Store get(final String type) {
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
