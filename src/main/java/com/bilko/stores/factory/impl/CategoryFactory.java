package com.bilko.stores.factory.impl;

import java.util.logging.Logger;

import com.bilko.stores.factory.ModelFactory;
import com.bilko.stores.model.Category;
import com.bilko.stores.model.impl.Antipyretics;
import com.bilko.stores.model.impl.Fruits;
import com.bilko.stores.model.impl.Painkillers;
import com.bilko.stores.model.impl.Vegetables;

/**
 * {@code ModelFactory} implementation is used to return {@link Category} instance.
 *
 * @author Dmitry Bilko
 * @see Category
 * @since 1.0
 */
public class CategoryFactory implements ModelFactory<Category> {

    /**
     * Default logger for {@code CategoryFactory} class.
     */
    private static final Logger LOG = Logger.getLogger(CategoryFactory.class.getSimpleName());

    @Override
    public final Category get(final String title) {
        if (title.equals(Antipyretics.TAG)) {
            return new Antipyretics();
        } else if (title.equals(Fruits.TAG)) {
            return new Fruits();
        } else if (title.equals(Painkillers.TAG)) {
            return new Painkillers();
        } else if (title.equals(Vegetables.TAG)) {
            return new Vegetables();
        } else {
            LOG.warning("INCOMPATIBLE CATEGORY TYPE: " + title);
            return null;
        }
    }
}
