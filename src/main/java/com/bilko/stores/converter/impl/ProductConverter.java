package com.bilko.stores.converter.impl;

import org.bson.Document;

import com.bilko.stores.converter.AbstractConverter;
import com.bilko.stores.model.Product;

public class ProductConverter extends AbstractConverter<Product> {

    @Override
    public Document toDocument(final Product product) {
        return new Document("product", new Document()
            .append("title", product.getTitle())
            .append("price", product.getPrice())
            .append("status", product.getStatus()));
    }

    @Override
    public Product toModel(final Document document) {
        return null;
    }
}
