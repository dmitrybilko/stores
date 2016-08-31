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
public class Apple extends AbstractProduct {

    /**
     * Tag value based on class name.
     */
    public static final String TAG = Apple.class.getSimpleName();

    /**
     * Constructor for {@code Apple}.
     */
    public Apple() {
        super(TAG, Fruits.class.getSimpleName(), "17", Status.AVAILABLE);
    }
}
