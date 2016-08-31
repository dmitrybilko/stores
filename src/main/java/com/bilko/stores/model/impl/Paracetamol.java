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
public class Paracetamol extends AbstractProduct {

    /**
     * Tag value based on class name.
     */
    public static final String TAG = Paracetamol.class.getSimpleName();

    /**
     * Constructor for {@code Paracetamol}.
     */
    public Paracetamol() {
        super(TAG, Antipyretics.class.getSimpleName(), "8.19", Status.AVAILABLE);
    }
}
