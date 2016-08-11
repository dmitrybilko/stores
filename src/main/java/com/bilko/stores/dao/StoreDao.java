package com.bilko.stores.dao;

import java.util.Arrays;

import com.mongodb.client.MongoCollection;

import org.bson.Document;

import com.bilko.stores.converter.impl.StoreConverter;
import com.bilko.stores.db.MongoHandler;
import com.bilko.stores.model.Product;
import com.bilko.stores.model.Store;

import static com.mongodb.client.model.Filters.eq;

import static com.bilko.stores.util.Constants.MONGO_DB_ID_FIELD;
import static com.bilko.stores.util.Constants.PRODUCTS;

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

    private void addProduct(final Store store, final Product product) {
        store
            .getCategories()
            .stream()
            .filter(category -> category.getTitle().equals(product.getType()))
            .forEach(category -> category.getProducts().add(product));
        collection.replaceOne(eq(MONGO_DB_ID_FIELD, store.getId()), converter.toDocument(store));
    }

    public void addProducts(final Store store) {
        Arrays
            .asList(PRODUCTS)
            .stream()
            .forEach(product -> addProduct(store, product));
    }

    public void changeProductsStatuses(final Store store) {
        store
            .getCategories()
            .get(0)
            .getProducts()
            .stream()
            .forEach(product -> product.setStatus(Product.Status.ABSENT));
        store
            .getCategories()
            .subList(1, store.getCategories().size())
            .stream()
            .forEach(category -> category
                .getProducts()
                .subList(0, category.getProducts().size() / 2)
                .stream()
                .forEach(product -> product.setStatus(Product.Status.EXPECTED)));
        collection.replaceOne(eq(MONGO_DB_ID_FIELD, store.getId()), converter.toDocument(store));
    }

    public void changeProductsPrices(final Store store) {
        store
            .getCategories()
            .stream()
            .forEach(category -> category
                .getProducts()
                .stream()
                .filter(product -> product.getStatus().equals(Product.Status.AVAILABLE.toString()))
                .forEach(product -> product.setPrice(String.valueOf(Float.valueOf(product.getPrice()) * 1.2f)))
            );
        collection.replaceOne(eq(MONGO_DB_ID_FIELD, store.getId()), converter.toDocument(store));
    }
}
