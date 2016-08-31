package com.bilko.stores.model.impl;

import com.bilko.stores.model.AbstractProduct;
import com.bilko.stores.model.Product;

/**
 * {@link Product} implementation.
 *
 * @author Dmitry Bilko
 * @see Product
 * @since 1.0
 */
public class Ketamine extends AbstractProduct {

    /**
     * Tag value based on class name.
     */
    public static final String TAG = Ketamine.class.getSimpleName();

    /**
     * Constructor for {@code Ketamine}.
     */
    public Ketamine() {
        super(TAG, Painkillers.class.getSimpleName(), "372.9", Status.AVAILABLE);
    }
}
