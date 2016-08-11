package com.bilko.stores.converter.impl;

import java.util.List;

import org.bson.Document;

import com.bilko.stores.converter.AbstractConverter;
import com.bilko.stores.factory.impl.CategoryFactory;
import com.bilko.stores.model.Category;

import static com.bilko.stores.util.Constants.MONGO_DB_CATEGORY_FIELD;
import static com.bilko.stores.util.Constants.MONGO_DB_PRODUCTS_FIELD;
import static com.bilko.stores.util.Constants.MONGO_DB_TITLE_FIELD;

public class CategoryConverter extends AbstractConverter<Category> {

    private ProductConverter productConverter;
    private CategoryFactory categoryFactory;

    public CategoryConverter() {
        productConverter = new ProductConverter();
        categoryFactory = new CategoryFactory();
    }

    @Override
    public Document toDocument(final Category category) {
        return new Document(MONGO_DB_CATEGORY_FIELD, new Document()
            .append(MONGO_DB_TITLE_FIELD, category.getTitle())
            .append(MONGO_DB_PRODUCTS_FIELD, productConverter.toDocuments(category.getProducts())));
    }

    @SuppressWarnings("unchecked")
    @Override
    public Category toModel(final Document document) {
        final Document categoryDocument = document.get(MONGO_DB_CATEGORY_FIELD, Document.class);
        final Category category = categoryFactory.get(categoryDocument.get(MONGO_DB_TITLE_FIELD, String.class));
        category.setProducts(productConverter.toModels((List<Document>) categoryDocument.get(MONGO_DB_PRODUCTS_FIELD)));
        return category;
    }
}
