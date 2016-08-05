package com.bilko.stores.dao;

import java.util.List;

import com.mongodb.client.MongoCollection;

import org.bson.Document;

import com.bilko.stores.converter.impl.StoreConverter;
import com.bilko.stores.db.MongoHandler;
import com.bilko.stores.model.Product;
import com.bilko.stores.model.Store;

public class StoreDao {

    private static StoreDao instance;
    private MongoCollection<Document> collection;
    private StoreConverter converter;

    private StoreDao() {
        converter = new StoreConverter();
        collection = MongoHandler.getCollection();
    }

    public static synchronized StoreDao get() {
        if (instance == null) {
            instance = new StoreDao();
        }
        return instance;
    }

    public void create(final Store store) {
        collection.insertOne(converter.toDocument(store));
    }

    public void addProduct(final Store store, final Product product) {
        store
            .getCategories()
            .stream()
            .filter(category -> category.getTitle().equals(product.getType()))
            .forEach(category -> category.getProducts().add(product));
        collection.replaceOne(new Document("_id", store.getId()), converter.toDocument(store));
    }

    public void addProducts(final Store store, final List<Product> products) {
        products
            .stream()
            .forEach(product -> addProduct(store, product));
    }
}
