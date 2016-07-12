package com.bilko.stores;

import java.util.List;

class Category {

    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(final List<Product> products) {
        this.products = products;
    }
}
