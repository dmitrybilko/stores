package com.bilko.stores.dao;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Arrays;

import com.mongodb.client.MongoCollection;

import org.bson.Document;

import com.bilko.stores.converter.DocumentConverter;
import com.bilko.stores.converter.impl.StoreDocumentConverter;
import com.bilko.stores.db.MongoHandler;
import com.bilko.stores.model.Product;
import com.bilko.stores.model.Store;

import static com.mongodb.client.model.Filters.eq;

import static com.bilko.stores.util.Constants.CURRENCY_SCALE;
import static com.bilko.stores.util.Constants.MONGO_DB_ID_FIELD;
import static com.bilko.stores.util.Constants.PRICE_MULTIPLIER;
import static com.bilko.stores.util.Constants.PRODUCTS;

/**
 * Class {@code StoreDao} provides access to database through pack of specified operations with {@link Store} model.
 *
 * @author Dmitry Bilko
 * @see Store
 * @since 1.0
 */
public class StoreDao {

    /**
     * {@link Store} instance is provided to make record to database.
     */
    private Store store;

    /**
     * {@link MongoCollection} to be used to perform database operations.
     */
    private MongoCollection<Document> collection;

    /**
     * {@link DocumentConverter} implementation to convert {@link Store}.
     */
    private StoreDocumentConverter converter;

    /**
     * Constructor for {@code StoreDao}. {@link Store} instance must be passed in to instantiate.
     * @param model instance of {@link Store}
     */
    public StoreDao(final Store model) {
        this.store = model;
        this.converter = new StoreDocumentConverter();
        this.collection = MongoHandler.getCollection();
    }

    /**
     * Creates record in database which represents {@link Store} model as {@link Document}.
     */
    public final void create() {
        collection.insertOne(converter.toDocument(store));
    }

    /**
     * Replaces current database record represented {@link Store} model with new one supplemented by given
     * {@link Product}.
     * @param product given to be added to database record
     */
    private void addProduct(final Product product) {
        store
            .getCategories()
            .stream()
            .filter(category -> category.getTitle().equals(product.getType()))
            .forEach(category -> category.getProducts().add(product));
        collection.replaceOne(eq(MONGO_DB_ID_FIELD, store.getId()), converter.toDocument(store));
    }

    /**
     * Adds preset list of {@link Product} to current {@link Store} instance.
     */
    public final void addProducts() {
        Arrays
            .asList(PRODUCTS)
            .stream()
            .forEach(this::addProduct);
    }

    /**
     * Replaces current database record represented {@link Store} model with new one with changed statuses of
     * {@link Product}s.
     */
    public final void changeProductsStatuses() {
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

    /**
     * Replaces current database record represented {@link Store} model with new one with changed prices of
     * {@link Product.Status#AVAILABLE} {@link Product}s.
     */
    public final void changeProductsPrices() {
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
                        .multiply(new BigDecimal(Float.toString(PRICE_MULTIPLIER)))));
                })
            );
        collection.replaceOne(eq(MONGO_DB_ID_FIELD, store.getId()), converter.toDocument(store));
    }
}
