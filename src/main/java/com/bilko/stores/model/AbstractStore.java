package com.bilko.stores.model;

import java.util.List;

public abstract class AbstractStore implements Store {

    private String title;
    private List<Category> categories;

    public AbstractStore(final String title, final List<Category> categories) {
        this.title = title;
        this.categories = categories;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public List<Category> getCategories() {
        return categories;
    }
}
