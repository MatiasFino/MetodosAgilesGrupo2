package com.sistema.ayudantes.sistayudantes.DatabaseManager.AlmacenamientoToken;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.sistema.ayudantes.sistayudantes.DatabaseManager.DatabaseManager;
import org.bson.Document;

public class AlmacenamientoTokenCollection {
    private MongoCollection<Document> _collection;
    private static AlmacenamientoTokenCollection almacenamientoTokenCollection;

    private AlmacenamientoTokenCollection() {
        this._collection = DatabaseManager.getInstance().getDatabase().getCollection("almacenamiento_token");
    }

    public static AlmacenamientoTokenCollection getInstance() {
        if (almacenamientoTokenCollection == null) {
            almacenamientoTokenCollection = new AlmacenamientoTokenCollection();
        }
        return almacenamientoTokenCollection;
    }

    public boolean insert (AlmacenamientoTokenDTO almacenamientoTokenDTO) {
        BasicDBObject searchQuery = new
                BasicDBObject("id_ayudante", almacenamientoTokenDTO.getIdAyudante())
                .append("id_materia", almacenamientoTokenDTO.getIdMateria());
        if (!this._collection.find(searchQuery).cursor().hasNext()) {
            this._collection.insertOne(almacenamientoTokenDTO.getDatabaseFormat());
            return true;
        } else {
            System.err.println("Ya existe una token para el ayudante "+ almacenamientoTokenDTO.getIdAyudante() + " y la materia " + almacenamientoTokenDTO.getIdMateria());
            return false;
        }
    }

    public boolean delete (String id_ayudante, String id_materia) {
        BasicDBObject deleteQuery = new
                BasicDBObject("id_ayudante", id_ayudante)
                .append("id_materia", id_materia);
        if (this._collection.find(deleteQuery).cursor().hasNext()) {
            this._collection.deleteMany(deleteQuery);
            return true;
        } else {
            System.err.println("No existe un token para el ayudante "+ id_ayudante + " y la materia " + id_materia);
            return false;
        }
    }

    public FindIterable<Document> getTokens (BasicDBObject searchQuery) {
        return this._collection.find(searchQuery);
    }

    public FindIterable<Document> getTokens () {
        return this._collection.find();
    }

}
