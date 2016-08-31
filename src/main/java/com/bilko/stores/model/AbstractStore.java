package com.bilko.stores.model;

import java.util.List;

/**
 * Class {@code AbstractStore} provides abstract implementation of {@link Store}. This class can be extended by calling
 * public constructor.
 *
 * @author Dmitry Bilko
 * @see Store
 * @since 1.0
 */
public abstract class AbstractStore implements Store {

    /**
     * Current {@link Store} instance's id value.
     */
    private String id;

    /**
     * Current {@link Store} instance's title value.
     */
    private String title;

    /**
     * Current {@link Store} instance's categories value.
     */
    private List<Category> categories;

    /**
     * Constructor for {@code AbstractStore}.
     * @param sId of {@link Store} to be instantiate
     * @param sTitle of {@link Store} to be instantiate
     * @param sCategories of {@link Store} to be instantiate
     */
    public AbstractStore(final String sId, final String sTitle, final List<Category> sCategories) {
        this.id = sId;
        this.title = sTitle;
        this.categories = sCategories;
    }

    @Override
    public final String getId() {
        return id;
    }

    @Override
    public final String getTitle() {
        return title;
    }

    @Override
    public final List<Category> getCategories() {
        return categories;
    }

    @Override
    public final void setCategories(final List<Category> sCategories) {
        this.categories = sCategories;
    }
}
