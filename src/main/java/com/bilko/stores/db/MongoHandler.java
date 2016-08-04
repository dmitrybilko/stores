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

    public static MongoCollection<Document> getCollection() {
        return connect().getCollection(Constants.MONGO_DB_COLLECTION);
    }

    public static void drop() {
        getCollection().drop();
    }

    public static void reveal() {
        getCollection()
            .find()
            .forEach((Block<Document>) System.out::println);
    }
}
