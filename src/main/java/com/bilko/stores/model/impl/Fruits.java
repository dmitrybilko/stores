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
public class Fruits extends AbstractCategory {

    /**
     * Tag value based on class name.
     */
    public static final String TAG = Fruits.class.getSimpleName();

    /**
     * Constructor for {@code Fruits}.
     */
    public Fruits() {
        super(TAG);
    }
}
