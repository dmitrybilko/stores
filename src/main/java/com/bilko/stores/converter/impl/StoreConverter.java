package com.bilko.stores.converter.impl;

import org.bson.Document;

import com.bilko.stores.converter.AbstractConverter;
import com.bilko.stores.model.Store;

public class StoreConverter extends AbstractConverter<Store> {

    private CategoryConverter categoryConverter;

    public StoreConverter() {
        categoryConverter = new CategoryConverter();
    }

    @Override
    public Document toDocument(final Store store) {
        return new Document()
            .append("_id", store.getId())
            .append("title", store.getTitle())
            .append("categories", categoryConverter.toDocuments(store.getCategories()));
    }
}
