package com.bilko.stores;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.bilko.stores.dao.StoreDao;
import com.bilko.stores.db.MongoHandler;
import com.bilko.stores.factory.impl.GroceryFactory;
import com.bilko.stores.factory.impl.PharmacyFactory;
import com.bilko.stores.model.Category;
import com.bilko.stores.model.Product;
import com.bilko.stores.model.Store;
import com.bilko.stores.model.impl.*;
import com.bilko.stores.util.Constants;

public class Main {

    private static final Logger LOG = Logger.getLogger(Main.class.getSimpleName());

    private static final Product[] products = {new Apple(), new Aspirin(), new Banana(), new Cucumber(), new Ibuprofen(),
        new Ketamine(), new Morphine(), new Paracetamol(), new Pear(), new Pepper(), new Tomato(), new Vicodin()};

    public static void main(final String[] args) {
        MongoHandler.drop();
        final ScheduledExecutorService executor = Executors.newScheduledThreadPool(Constants.STORES_NUMBER);
        try {
            executor.execute(() -> open(new GroceryFactory().getStore()));
            executor.schedule(() -> open(new PharmacyFactory().getStore()), Constants.START_DELAY, TimeUnit.SECONDS);
        } finally {
            shutdown(executor, Constants.SHUTDOWN_TIMEOUT);
            close();
        }
    }

    private static void open(final Store store) {
        StoreDao.get().addProducts(store, Arrays.asList(products));
    }

    private static void changeStatus(final List<Category> categories) {
        categories.get(0).getProducts()
            .stream()
            .forEach(product -> product.setStatus(Product.Status.ABSENT));

        categories.subList(1, categories.size())
            .stream()
            .forEach(category -> category
                .getProducts()
                .subList(0, category.getProducts().size() / 2)
                .stream()
                .forEach(product -> product.setStatus(Product.Status.EXPECTED)));
    }

    private static void changePrice(final List<Category> categories) {
        categories
            .stream()
            .forEach(category -> category
                .getProducts()
                .stream()
                .filter(product -> product.getStatus().equals(Product.Status.AVAILABLE.toString()))
                .forEach(product -> product.setPrice(product.getPrice() * 1.2f))
            );
    }

    private static List<Runnable> shutdown(final ExecutorService executor, final int timeout) {
        executor.shutdown();
        if (timeout > 0) {
            try {
                executor.awaitTermination(timeout, TimeUnit.SECONDS);
            } catch (final InterruptedException e) {
                LOG.log(Level.WARNING, "WAITING FOR EXECUTOR SERVICE TASKS COMPLETION INTERRUPTED", e);
            }
        }
        MongoHandler.reveal();
        return (executor.isTerminated() ? null : executor.shutdownNow());
    }

    private static void close() {
        LOG.info("ALL THREADS ARE SHUT DOWN");
    }
}
