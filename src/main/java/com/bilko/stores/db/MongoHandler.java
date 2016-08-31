package com.bilko.stores.db;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;

import com.bilko.stores.util.Constants;

/**
 * Util class for {@link MongoDatabase} preparation.
 *
 * @author Dmitry Bilko
 * @see MongoClient
 * @see MongoDatabase
 * @since 1.0
 */
public final class MongoHandler {

    /**
     * {@link MongoDatabase} instance to be used to perform database operations.
     */
    private static MongoDatabase database;

    /**
     * Private constructor for {@code MongoHandler}.
     */
    private MongoHandler() { }

    /**
     * Sets up {@link MongoDatabase} connection.
     * @return instance of {@link MongoDatabase} with specified name
     */
    private static MongoDatabase connect() {
        if (database == null) {
            database = new MongoClient().getDatabase(Constants.MONGO_DB_NAME);
        }
        return database;
    }

    /**
     * Returns i{@link MongoCollection} instance.
     * @return instance of {@link MongoCollection} with specified name
     */
    public static MongoCollection<Document> getCollection() {
        return connect().getCollection(Constants.MONGO_DB_COLLECTION);
    }
}
