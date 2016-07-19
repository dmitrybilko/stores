package com.bilko.stores;

import java.util.List;

abstract class AbstractStore implements Store {

    private List<Category> categories;

    AbstractStore(final List<Category> categories) {
        this.categories = categories;
    }

    @Override
    public List<Category> getCategories() {
        return categories;
    }
}
