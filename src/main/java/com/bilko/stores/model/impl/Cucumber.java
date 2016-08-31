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
public class Cucumber extends AbstractProduct {

    /**
     * Tag value based on class name.
     */
    public static final String TAG = Cucumber.class.getSimpleName();

    /**
     * Constructor for {@code Cucumber}.
     */
    public Cucumber() {
        super(TAG, Vegetables.class.getSimpleName(), "17", Status.AVAILABLE);
    }
}
