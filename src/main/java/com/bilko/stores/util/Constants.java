package com.bilko.stores.util;

import com.bilko.stores.model.Product;
import com.bilko.stores.model.impl.Apple;
import com.bilko.stores.model.impl.Aspirin;
import com.bilko.stores.model.impl.Banana;
import com.bilko.stores.model.impl.Cucumber;
import com.bilko.stores.model.impl.Ibuprofen;
import com.bilko.stores.model.impl.Ketamine;
import com.bilko.stores.model.impl.Morphine;
import com.bilko.stores.model.impl.Paracetamol;
import com.bilko.stores.model.impl.Pear;
import com.bilko.stores.model.impl.Pepper;
import com.bilko.stores.model.impl.Tomato;
import com.bilko.stores.model.impl.Vicodin;

/**
 * Util class to store constants.
 *
 * @author Dmitry Bilko
 * @since 1.0
 */
public final class Constants {

    /**
     * Amount of usable stores.
     */
    public static final int STORES_NUMBER = 2;

    /**
     * Value of start delay for second thread.
     */
    public static final int START_DELAY = 10;

    /**
     * Value of shutdown timeout for all threads.
     */
    public static final int SHUTDOWN_TIMEOUT = 60;

    /**
     * Value of currency scale.
     */
    public static final int CURRENCY_SCALE = 2;

    /**
     * Value of price multiplier.
     */
    public static final float PRICE_MULTIPLIER = 1.2f;

    /**
     * Name of database.
     */
    public static final String MONGO_DB_NAME = "bilko";

    /**
     * Name of database collection.
     */
    public static final String MONGO_DB_COLLECTION = "stores";

    /**
     * Name of id field.
     */
    public static final String MONGO_DB_ID_FIELD = "_id";

    /**
     * Name of title field.
     */
    public static final String MONGO_DB_TITLE_FIELD = "title";

    /**
     * Name of categories field.
     */
    public static final String MONGO_DB_CATEGORIES_FIELD = "categories";

    /**
     * Name of category field.
     */
    public static final String MONGO_DB_CATEGORY_FIELD = "category";

    /**
     * Name of products field.
     */
    public static final String MONGO_DB_PRODUCTS_FIELD = "products";

    /**
     * Name of product field.
     */
    public static final String MONGO_DB_PRODUCT_FIELD = "product";

    /**
     * Name of price field.
     */
    public static final String MONGO_DB_PRICE_FIELD = "price";

    /**
     * Name of status field.
     */
    public static final String MONGO_DB_STATUS_FIELD = "status";

    /**
     * Preset array of usable {@link Product}s.
     */
    public static final Product[] PRODUCTS = {
        new Apple(),
        new Aspirin(),
        new Banana(),
        new Cucumber(),
        new Ibuprofen(),
        new Ketamine(),
        new Morphine(),
        new Paracetamol(),
        new Pear(),
        new Pepper(),
        new Tomato(),
        new Vicodin()
    };

    /**
     * Private constructor for {@code Constants}.
     */
    private Constants() { }
}
