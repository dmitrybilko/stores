package com.bilko.stores.model;

import java.util.List;

public interface Category {

    String getTitle();

    List<Product> getProducts();
}
