package com.bilko.stores.model;

import java.util.List;

public abstract class AbstractStore implements Store {

    private String id;
    private String title;
    private List<Category> categories;

    public AbstractStore(final String id, final String title, final List<Category> categories) {
        this.id = id;
        this.title = title;
        this.categories = categories;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public List<Category> getCategories() {
        return categories;
    }

    @Override
    public void setCategories(final List<Category> categories) {
        this.categories = categories;
    }
}
