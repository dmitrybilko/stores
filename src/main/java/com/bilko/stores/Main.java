package com.bilko.stores;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.bilko.stores.dao.StoreDao;
import com.bilko.stores.db.MongoHandler;
import com.bilko.stores.factory.impl.StoreFactoryManager;
import com.bilko.stores.model.Store;
import com.bilko.stores.model.impl.Grocery;
import com.bilko.stores.model.impl.Pharmacy;
import com.bilko.stores.util.Constants;

public class Main {

    private static final Logger LOG = Logger.getLogger(Main.class.getSimpleName());

    public static void main(final String[] args) {
        MongoHandler.drop();
        final Store grocery = StoreFactoryManager.get().getStoreFactory(Grocery.TAG).getStore();
        final Store pharmacy = StoreFactoryManager.get().getStoreFactory(Pharmacy.TAG).getStore();
        final ScheduledExecutorService executor = Executors.newScheduledThreadPool(Constants.STORES_NUMBER);
        try {
            executor.execute(() -> open(grocery));
            executor.schedule(() -> open(pharmacy), Constants.START_DELAY, TimeUnit.SECONDS);
        } finally {
            shutdown(executor, Constants.SHUTDOWN_TIMEOUT);
            close();
        }
    }

    private static void open(final Store store) {
        create(store);
        addProducts(store);
        changeProductsStatuses(store);
        changeProductsPrices(store);
    }

    private static void create(final Store store) {
        StoreDao.get().create(store);
    }

    private static void addProducts(final Store store) {
        StoreDao.get().addProducts(store);
    }

    private static void changeProductsStatuses(final Store store) {
        StoreDao.get().changeProductsStatuses(store);
    }

    private static void changeProductsPrices(final Store store) {
        StoreDao.get().changeProductsPrices(store);
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
