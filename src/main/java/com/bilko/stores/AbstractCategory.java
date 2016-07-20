package com.bilko.stores;

import java.util.List;

abstract class AbstractCategory implements Category {

    AbstractCategory(final List<Product> products) {
        this.products = products;
    }

    private List<Product> products;

    @Override
    public List<Product> getProducts() {
        return products;
    }
}
