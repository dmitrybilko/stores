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

public class Constants {

    public static final int STORES_NUMBER = 2;
    public static final int START_DELAY = 5;
    public static final int SHUTDOWN_TIMEOUT = 60;

    public static final String MONGO_DB_NAME = "bilko";
    public static final String MONGO_DB_COLLECTION = "stores";
    public static final String MONGO_DB_ID_FIELD = "_id";
    public static final String MONGO_DB_TITLE_FIELD = "title";
    public static final String MONGO_DB_CATEGORIES_FIELD = "categories";
    public static final String MONGO_DB_CATEGORY_FIELD = "category";
    public static final String MONGO_DB_PRODUCTS_FIELD = "products";
    public static final String MONGO_DB_PRODUCT_FIELD = "product";
    public static final String MONGO_DB_PRICE_FIELD = "price";
    public static final String MONGO_DB_STATUS_FIELD = "status";

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
}
