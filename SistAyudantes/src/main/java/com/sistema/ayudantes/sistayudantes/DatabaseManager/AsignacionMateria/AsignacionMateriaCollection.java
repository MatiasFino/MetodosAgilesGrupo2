package com.sistema.ayudantes.sistayudantes.DatabaseManager.AsignacionMateria;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.sistema.ayudantes.sistayudantes.DatabaseManager.DatabaseManager;
import org.bson.Document;

public class AsignacionMateriaCollection {
    private MongoCollection<Document> _collection;
    private static AsignacionMateriaCollection asignacionMateriaCollection;

    private AsignacionMateriaCollection() {
        this._collection = DatabaseManager.getInstance().getDatabase().getCollection("asignacion_materia");
    }

    public static AsignacionMateriaCollection getInstance() {
        if (asignacionMateriaCollection == null) {
            asignacionMateriaCollection = new AsignacionMateriaCollection();
        }
        return asignacionMateriaCollection;
    }

    public boolean insert (AsignacionMateriaDTO asignacionMateria) {
        BasicDBObject searchQuery = new
                BasicDBObject("id_ayudante", asignacionMateria.getIdAyudante())
                .append("id_materia", asignacionMateria.getIdMateria());
        if (!this._collection.find(searchQuery).cursor().hasNext()) {
            this._collection.insertOne(asignacionMateria.getDatabaseFormat());
            return true;
        } else {
            System.err.println("Ya existe una asignacion del ayudante "+ asignacionMateria.getIdAyudante() + " a la materia " + asignacionMateria.getIdMateria());
            return false;
        }
    }

    public FindIterable<Document> getAsignacionesMateria (BasicDBObject searchQuery) {
        return this._collection.find(searchQuery);
    }

    public FindIterable<Document> getAsignacionesMateria () {
        return this._collection.find();
    }

}
