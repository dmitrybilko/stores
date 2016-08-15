package com.bilko.stores.dao;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Arrays;

import com.mongodb.client.MongoCollection;

import org.bson.Document;

import com.bilko.stores.converter.impl.StoreConverter;
import com.bilko.stores.db.MongoHandler;
import com.bilko.stores.model.Product;
import com.bilko.stores.model.Store;

import static com.mongodb.client.model.Filters.eq;

import static com.bilko.stores.util.Constants.CURRENCY_SCALE;
import static com.bilko.stores.util.Constants.MONGO_DB_ID_FIELD;
import static com.bilko.stores.util.Constants.PRODUCTS;

public class StoreDao {

    private Store store;
    private MongoCollection<Document> collection;
    private StoreConverter converter;

    public StoreDao(final Store store) {
        this.store = store;
        this.converter = new StoreConverter();
        this.collection = MongoHandler.getCollection();
    }

    public void create() {
        collection.insertOne(converter.toDocument(store));
    }

    private void addProduct(final Product product) {
        store
            .getCategories()
            .stream()
            .filter(category -> category.getTitle().equals(product.getType()))
            .forEach(category -> category.getProducts().add(product));
        collection.replaceOne(eq(MONGO_DB_ID_FIELD, store.getId()), converter.toDocument(store));
    }

    public void addProducts() {
        Arrays
            .asList(PRODUCTS)
            .stream()
            .forEach(this::addProduct);
    }

    public void changeProductsStatuses() {
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

    public void changeProductsPrices() {
        store
            .getCategories()
            .stream()
            .forEach(category -> category
                .getProducts()
                .stream()
                .filter(product -> product
                    .getStatus()
                    .equals(Product.Status.AVAILABLE.toString()))
                .forEach(product -> {
                    final NumberFormat priceFormat = NumberFormat.getNumberInstance();
                    priceFormat.setMaximumFractionDigits(CURRENCY_SCALE);
                    product.setPrice(priceFormat.format(new BigDecimal(product.getPrice())
                        .setScale(CURRENCY_SCALE, RoundingMode.HALF_EVEN)
                        .multiply(new BigDecimal(Float.toString(1.2f)))));
                })
            );
        collection.replaceOne(eq(MONGO_DB_ID_FIELD, store.getId()), converter.toDocument(store));
    }
}
