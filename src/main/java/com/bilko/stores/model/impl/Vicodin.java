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
public class Vicodin extends AbstractProduct {

    /**
     * Tag value based on class name.
     */
    public static final String TAG = Vicodin.class.getSimpleName();

    /**
     * Constructor for {@code Vicodin}.
     */
    public Vicodin() {
        super(TAG, Painkillers.class.getSimpleName(), "340.58", Status.AVAILABLE);
    }
}
