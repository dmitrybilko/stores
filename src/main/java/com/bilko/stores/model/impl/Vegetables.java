package com.bilko.stores.model.impl;

import com.bilko.stores.model.AbstractCategory;
import com.bilko.stores.model.Category;

/**
 * {@link Category} implementation.
 *
 * @author Dmitry Bilko
 * @see Category
 * @since 1.0
 */
public class Vegetables extends AbstractCategory {

    /**
     * Tag value based on class name.
     */
    public static final String TAG = Vegetables.class.getSimpleName();

    /**
     * Constructor for {@code Vegetables}.
     */
    public Vegetables() {
        super(TAG);
    }
}
