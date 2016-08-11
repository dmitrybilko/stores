package com.bilko.stores.model;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractCategory implements Category {

    private String title;
    private List<Product> products = new ArrayList<>();

    public AbstractCategory(final String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public List<Product> getProducts() {
        return products;
    }

    @Override
    public void setProducts(final List<Product> products) {
        this.products = products;
    }
}
