package com.sistema.ayudantes.sistayudantes.DatabaseManager.Materia;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.sistema.ayudantes.sistayudantes.DatabaseManager.DatabaseManager;
import org.bson.Document;

public class MateriaCollection {
    private MongoCollection<Document> _collection;
    private static MateriaCollection materiaCollection;

    private MateriaCollection () {
        this._collection = DatabaseManager.getInstance().getDatabase().getCollection("materia");
    }

    public static MateriaCollection getInstance() {
        if (materiaCollection == null) {
            materiaCollection = new MateriaCollection();
        }
        return materiaCollection;
    }

    public boolean insert (MateriaDTO materia) {
        BasicDBObject searchQuery = new BasicDBObject("id", materia.getId());
        if (!this._collection.find(searchQuery).cursor().hasNext()) {
            this._collection.insertOne(materia.getDatabaseFormat());
            return true;
        } else {
            System.err.println("Ya existe una materia cuyo id es: " + materia.getId());
            return false;
        }
    }

    public void update (String id_materia, BasicDBObject newDocument) {
        BasicDBObject searchQuery = new BasicDBObject("id", id_materia);

        BasicDBObject updateObject = new BasicDBObject();
        updateObject.put("$set", newDocument);

        this._collection.updateOne(searchQuery, updateObject);
    }

    public FindIterable<Document> getMaterias (BasicDBObject searchQuery) {
        return this._collection.find(searchQuery);
    }

    public FindIterable<Document> getMaterias () {
        return this._collection.find();
    }

}
