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
public class Banana extends AbstractProduct {

    /**
     * Tag value based on class name.
     */
    public static final String TAG = Banana.class.getSimpleName();

    /**
     * Constructor for {@code Banana}.
     */
    public Banana() {
        super(TAG, Fruits.class.getSimpleName(), "26.50", Status.AVAILABLE);
    }
}
