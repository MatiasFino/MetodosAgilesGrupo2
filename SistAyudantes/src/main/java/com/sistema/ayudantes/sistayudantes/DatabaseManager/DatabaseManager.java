package com.sistema.ayudantes.sistayudantes.DatabaseManager;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

public class DatabaseManager {
    private static DatabaseManager databaseManager;
    private MongoDatabase database;

    private DatabaseManager() {
        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
        String _databaseName = "taller_agiles";
        this.database = mongoClient.getDatabase(_databaseName);
    }

    public static DatabaseManager getInstance() {
        if (databaseManager == null) {
            databaseManager = new DatabaseManager();
        }
        return databaseManager;
    }

    public MongoDatabase getDatabase () {
        return this.database;
    }
}
