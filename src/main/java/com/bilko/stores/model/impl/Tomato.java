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
public class Tomato extends AbstractProduct {

    /**
     * Tag value based on class name.
     */
    public static final String TAG = Tomato.class.getSimpleName();

    /**
     * Constructor for {@code Tomato}.
     */
    public Tomato() {
        super(TAG, Vegetables.class.getSimpleName(), "30.95", Status.AVAILABLE);
    }
}
