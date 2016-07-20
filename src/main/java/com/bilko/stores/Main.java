package com.bilko.stores;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final Logger LOG = Logger.getLogger(Main.class.getSimpleName());

    public static void main(final String[] args) {
        final ScheduledExecutorService executor = Executors.newScheduledThreadPool(Constants.STORES_NUMBER);
        try {
            executor.execute(() -> open(new GroceryFactory().getStore()));
            executor.schedule(() -> open(new PharmacyFactory().getStore()), Constants.START_DELAY, TimeUnit.SECONDS);
        } finally {
            shutdown(executor, Constants.SHUTDOWN_TIMEOUT);
        }
    }

    private static void open(final Store store) {
        changeStatus(store.getCategories());
    }

    private static void changeStatus(final List<Category> categories) {
        for (final Product product : categories.get(0).getProducts()) {
            product.setStatus(Product.Status.ABSENT);
        }
        for (final Category category : categories.subList(1, categories.size())) {
            for (final Product product : category.getProducts().subList(0, category.getProducts().size() / 2)) {
                product.setStatus(Product.Status.EXPECTED);
            }
        }
    }

    private static List<Runnable> shutdown(final ExecutorService executor, final int timeout) {
        if (executor == null) {
            LOG.log(Level.INFO, "EXECUTOR IS NULL.");
            return null;
        }
        executor.shutdown();
        if (timeout > 0) {
            try {
                executor.awaitTermination(timeout, TimeUnit.SECONDS);
            } catch (final InterruptedException e) {
                LOG.log(Level.WARNING, "WAITING FOR EXECUTOR SERVICE TASKS COMPLETION INTERRUPTED.", e);
            }
        }
        return (executor.isTerminated() ? null : executor.shutdownNow());
    }
}
