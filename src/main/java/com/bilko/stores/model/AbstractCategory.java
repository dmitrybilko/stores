package com.bilko.stores.model;

import java.util.List;

public abstract class AbstractCategory implements Category {

    private String title;
    private List<Product> products;

    public AbstractCategory(final String title, final List<Product> products) {
        this.title = title;
        this.products = products;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public List<Product> getProducts() {
        return products;
    }
}
