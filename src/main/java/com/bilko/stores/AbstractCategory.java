package com.bilko.stores;

import java.util.List;

abstract class AbstractCategory implements Category {

    private List<Product> products;

    @Override
    public List<Product> getProducts() {
        return products;
    }
}
