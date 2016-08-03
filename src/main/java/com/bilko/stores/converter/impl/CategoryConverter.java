package com.bilko.stores.converter.impl;

import org.bson.Document;

import com.bilko.stores.converter.AbstractConverter;
import com.bilko.stores.model.Category;

public class CategoryConverter extends AbstractConverter<Category> {

    private ProductConverter productConverter;

    public CategoryConverter() {
        productConverter = new ProductConverter();
    }

    @Override
    public Document toDocument(final Category category) {
        return new Document()
            .append("title", category.getTitle())
            .append("products", productConverter.toDocuments(category.getProducts()));
    }
}
