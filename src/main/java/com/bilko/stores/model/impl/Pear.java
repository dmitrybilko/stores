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
public class Pear extends AbstractProduct {

    /**
     * Tag value based on class name.
     */
    public static final String TAG = Pear.class.getSimpleName();

    /**
     * Constructor for {@code Pear}.
     */
    public Pear() {
        super(TAG, Fruits.class.getSimpleName(), "64.49", Status.AVAILABLE);
    }
}
