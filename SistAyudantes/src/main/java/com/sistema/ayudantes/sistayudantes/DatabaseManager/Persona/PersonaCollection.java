package com.sistema.ayudantes.sistayudantes.DatabaseManager.Persona;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.sistema.ayudantes.sistayudantes.DatabaseManager.DatabaseManager;
import org.bson.Document;

public class PersonaCollection {
    private MongoCollection<Document> _collection;
    private static PersonaCollection personaCollection;

    private PersonaCollection() {
        this._collection = DatabaseManager.getInstance().getDatabase().getCollection("persona");
    }

    public static PersonaCollection getInstance() {
        if (personaCollection == null) {
            personaCollection = new PersonaCollection();
        }
        return personaCollection;
    }

    public boolean insert (PersonaDTO persona) {
        BasicDBObject searchQuery = new
                BasicDBObject("id", persona.getIdPersona());
        if (!this._collection.find(searchQuery).cursor().hasNext()) {
            this._collection.insertOne(persona.getDatabaseFormat());
            return true;
        } else {
            System.err.println("Ya existe una persona con id "+ persona.getIdPersona());
            return false;
        }
    }

    public FindIterable<Document> getPersona (BasicDBObject searchQuery) {
        return this._collection.find(searchQuery);
    }

    public FindIterable<Document> getPersona () {
        return this._collection.find();
    }

}
