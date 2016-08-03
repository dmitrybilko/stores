package com.bilko.stores.dao;

import com.bilko.stores.converter.impl.StoreConverter;
import com.bilko.stores.db.MongoHandler;
import com.bilko.stores.model.Store;
import com.bilko.stores.util.Constants;

public class StoreDAO {

    private StoreConverter converter;

    public StoreDAO() {
        converter = new StoreConverter();
    }

    public void create(final Store store) {
        MongoHandler
            .getCollection(Constants.MONGO_DB_COLLECTION)
            .insertOne(converter.toDocument(store));
    }
}
