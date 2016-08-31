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
public class Ibuprofen extends AbstractProduct {

    /**
     * Tag value based on class name.
     */
    public static final String TAG = Ibuprofen.class.getSimpleName();

    /**
     * Constructor for {@code Ibuprofen}.
     */
    public Ibuprofen() {
        super(TAG, Antipyretics.class.getSimpleName(), "232.94", Status.AVAILABLE);
    }
}
