package com.bilko.stores.db;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;

import com.bilko.stores.util.Constants;

public class MongoHandler {

    private static MongoDatabase database;

    private static MongoDatabase connect() {
        if (database == null) {
            database = new MongoClient().getDatabase(Constants.MONGO_DB_NAME);
        }
        return database;
    }

    public static MongoCollection<Document> getCollection(final String name) {
        return connect().getCollection(name);
    }

    public static void drop(final String collection) {
        getCollection(collection).drop();
    }

    public static void reveal(final String collection) {
        getCollection(collection)
            .find()
            .forEach((Block<Document>) System.out::println);
    }
}
