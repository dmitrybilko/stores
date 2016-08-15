package com.bilko.stores.converter.impl;

import java.util.List;

import org.bson.Document;

import com.bilko.stores.converter.AbstractConverter;
import com.bilko.stores.factory.impl.StoreFactory;
import com.bilko.stores.model.Store;

import static com.bilko.stores.util.Constants.MONGO_DB_CATEGORIES_FIELD;
import static com.bilko.stores.util.Constants.MONGO_DB_ID_FIELD;
import static com.bilko.stores.util.Constants.MONGO_DB_TITLE_FIELD;

public class StoreConverter extends AbstractConverter<Store> {

    private CategoryConverter categoryConverter;
    private StoreFactory storeFactory;

    public StoreConverter() {
        categoryConverter = new CategoryConverter();
        storeFactory = new StoreFactory();
    }

    @Override
    public Document toDocument(final Store store) {
        return new Document()
            .append(MONGO_DB_ID_FIELD, store.getId())
            .append(MONGO_DB_TITLE_FIELD, store.getTitle())
            .append(MONGO_DB_CATEGORIES_FIELD, categoryConverter.toDocuments(store.getCategories()));
    }

    @SuppressWarnings("unchecked")
    @Override
    public Store toModel(final Document document) {
        final Store store = storeFactory.get(document.get(MONGO_DB_TITLE_FIELD, String.class));
        store.setCategories(categoryConverter.toModels((List<Document>) document.get(MONGO_DB_CATEGORIES_FIELD)));
        return store;
    }
}
