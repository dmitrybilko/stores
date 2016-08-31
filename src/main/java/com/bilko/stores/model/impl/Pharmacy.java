package com.bilko.stores.model.impl;

import java.util.Arrays;

import org.bson.types.ObjectId;

import com.bilko.stores.model.AbstractStore;
import com.bilko.stores.model.Store;

/**
 * {@link Store} implementation.
 *
 * @author Dmitry Bilko
 * @see Store
 * @since 1.0
 */
public class Pharmacy extends AbstractStore {

    /**
     * Tag value based on class name.
     */
    public static final String TAG = Pharmacy.class.getSimpleName();

    /**
     * Instance of considered class.
     */
    private static Pharmacy instance;

    /**
     * Private constructor for {@code Pharmacy}.
     */
    private Pharmacy() {
        super(ObjectId.get().toString(), TAG, Arrays.asList(new Antipyretics(), new Painkillers()));
    }

    /**
     * Method is used to return instance of considered class.
     * @return instance of considered class
     */
    public static synchronized Pharmacy get() {
        if (instance == null) {
            instance = new Pharmacy();
        }
        return instance;
    }
}
