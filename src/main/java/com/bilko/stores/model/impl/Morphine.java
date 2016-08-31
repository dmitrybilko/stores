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
public class Morphine extends AbstractProduct {

    /**
     * Tag value based on class name.
     */
    public static final String TAG = Morphine.class.getSimpleName();

    /**
     * Constructor for {@code Morphine}.
     */
    public Morphine() {
        super(TAG, Painkillers.class.getSimpleName(), "358.23", Status.AVAILABLE);
    }
}
