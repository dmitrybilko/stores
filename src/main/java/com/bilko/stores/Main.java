package com.bilko.stores;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.bilko.stores.dao.StoreDao;
import com.bilko.stores.factory.impl.StoreFactory;
import com.bilko.stores.model.Store;
import com.bilko.stores.model.impl.Grocery;
import com.bilko.stores.model.impl.Pharmacy;
import com.bilko.stores.util.Constants;

/**
 * Main class.
 *
 * @author Dmitry Bilko
 * @since 1.0
 */
public final class Main {

    /**
     * Default logger for {@code Main} class.
     */
    private static final Logger LOG = Logger.getLogger(Main.class.getSimpleName());

    /**
     * Private constructor for {@code Main}.
     */
    private Main() { }

    /**
     * Main method.
     * @param args array of input arguments
     */
    public static void main(final String[] args) {
        final StoreFactory factory = new StoreFactory();
        final ScheduledExecutorService executor = Executors.newScheduledThreadPool(Constants.STORES_NUMBER);
        try {
            executor.execute(() -> open(factory.get(Grocery.TAG)));
            executor.schedule(() -> open(factory.get(Pharmacy.TAG)), Constants.START_DELAY, TimeUnit.SECONDS);
        } finally {
            shutdown(executor, Constants.SHUTDOWN_TIMEOUT);
            close();
        }
    }

    /**
     * Performs all required operations with given {@link Store} instance.
     * @param store instance
     */
    private static void open(final Store store) {
        final StoreDao storeDao = new StoreDao(store);
        storeDao.create();
        storeDao.addProducts();
        storeDao.changeProductsStatuses();
        storeDao.changeProductsPrices();
    }

    /**
     * Shutdowns all executing threads with specified timeout.
     * @param executor is used to manage threads
     * @param timeout after which all executing threads to be terminated
     * @return list of tasks that never commenced execution
     */
    private static List<Runnable> shutdown(final ExecutorService executor, final int timeout) {
        executor.shutdown();
        if (timeout > 0) {
            try {
                executor.awaitTermination(timeout, TimeUnit.SECONDS);
            } catch (final InterruptedException e) {
                LOG.log(Level.WARNING, "WAITING FOR EXECUTOR SERVICE TASKS COMPLETION INTERRUPTED", e);
            }
        }
        return (executor.isTerminated() ? null : executor.shutdownNow());
    }

    /**
     * Logs message that all threads are shut down.
     */
    private static void close() {
        LOG.info("ALL THREADS ARE SHUT DOWN");
    }
}
