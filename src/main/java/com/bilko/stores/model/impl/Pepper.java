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
public class Pepper extends AbstractProduct {

    /**
     * Tag value based on class name.
     */
    public static final String TAG = Pepper.class.getSimpleName();

    /**
     * Constructor for {@code Pepper}.
     */
    public Pepper() {
        super(TAG, Vegetables.class.getSimpleName(), "60", Status.AVAILABLE);
    }
}
