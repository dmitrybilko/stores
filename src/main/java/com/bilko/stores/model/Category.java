package com.bilko.stores.model;

import java.util.List;

/**
 * Class {@code Category} specifies appropriate entity which contains list of {@link Product}.
 *
 * @author Dmitry Bilko
 * @see Store
 * @see Product
 * @since 1.0
 */
public interface Category {

    /**
     * Returns title of considered {@code Category} instance.
     * @return title as string
     */
    String getTitle();

    /**
     * Returns list of {@link Product} which considered {@code Category} instance contains.
     * @return list of {@link Product}
     */
    List<Product> getProducts();

    /**
     * Sets given list of {@link Product} which considered {@code Category} instance should contain.
     * @param products list of {@link Product} to be set
     */
    void setProducts(List<Product> products);
}
