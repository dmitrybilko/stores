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
public class Grocery extends AbstractStore {

    /**
     * Tag value based on class name.
     */
    public static final String TAG = Grocery.class.getSimpleName();

    /**
     * Instance of considered class.
     */
    private static Grocery instance;

    /**
     * Private constructor for {@code Grocery}.
     */
    private Grocery() {
        super(ObjectId.get().toString(), TAG, Arrays.asList(new Fruits(), new Vegetables()));
    }

    /**
     * Method is used to return instance of considered class.
     * @return instance of considered class
     */
    public static synchronized Grocery get() {
        if (instance == null) {
            instance = new Grocery();
        }
        return instance;
    }
}
