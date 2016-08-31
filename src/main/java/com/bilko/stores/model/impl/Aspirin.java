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
public class Aspirin extends AbstractProduct {

    /**
     * Tag value based on class name.
     */
    public static final String TAG = Aspirin.class.getSimpleName();

    /**
     * Constructor for {@code Aspirin}.
     */
    public Aspirin() {
        super(TAG, Antipyretics.class.getSimpleName(), "232.44", Status.AVAILABLE);
    }
}
