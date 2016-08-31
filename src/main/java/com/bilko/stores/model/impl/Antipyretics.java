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
public class Antipyretics extends AbstractCategory {

    /**
     * Tag value based on class name.
     */
    public static final String TAG = Antipyretics.class.getSimpleName();

    /**
     * Constructor for {@code Antipyretics}.
     */
    public Antipyretics() {
        super(TAG);
    }
}
