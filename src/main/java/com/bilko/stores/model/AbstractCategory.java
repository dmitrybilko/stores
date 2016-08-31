package com.bilko.stores.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Class {@code AbstractCategory} provides abstract implementation of {@link Category}. This class can be extended by
 * calling public constructor.
 *
 * @author Dmitry Bilko
 * @see Category
 * @since 1.0
 */
public abstract class AbstractCategory implements Category {

    /**
     * Current {@link Category} instance's title value.
     */
    private String title;

    /**
     * Current {@link Category} instance's products value.
     */
    private List<Product> products = new ArrayList<>();

    /**
     * Constructor for {@code AbstractCategory}.
     * @param cTitle of {@link Category} to be instantiate
     */
    public AbstractCategory(final String cTitle) {
        this.title = cTitle;
    }

    @Override
    public final String getTitle() {
        return title;
    }

    @Override
    public final List<Product> getProducts() {
        return products;
    }

    @Override
    public final void setProducts(final List<Product> cProducts) {
        this.products = cProducts;
    }
}
