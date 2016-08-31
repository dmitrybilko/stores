package com.bilko.stores.model;

import java.util.List;

/**
 * Class {@code Store} specifies appropriate entity which contains list of {@link Category} each of them contains list
 * of {@link Product}.
 *
 * @author Dmitry Bilko
 * @see Category
 * @see Product
 * @since 1.0
 */
public interface Store {

    /**
     * Returns id of considered {@code Store} instance.
     * @return id as string
     */
    String getId();

    /**
     * Returns title of considered {@code Store} instance.
     * @return title as string
     */
    String getTitle();

    /**
     * Returns list of {@link Category} which considered {@code Store} instance contains.
     * @return list of {@link Category}
     */
    List<Category> getCategories();

    /**
     * Sets given list of {@link Category} which considered {@code Store} instance should contain.
     * @param categories list of {@link Category} to be set
     */
    void setCategories(List<Category> categories);
}
