package com.bilko.stores.model;

import java.util.List;

public interface Store {

    String getTitle();

    List<Category> getCategories();
}
