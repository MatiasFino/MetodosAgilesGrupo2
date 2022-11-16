package com.sistema.ayudantes.sistayudantes.DatabaseManager.AlmacenamientoToken;

import com.sistema.ayudantes.sistayudantes.DatabaseManager.LocalDocument;
import org.bson.Document;

public class AlmacenamientoTokenDTO implements LocalDocument {
    private String _nombreCampoIdAyudante = "id_ayudante";
    private String _nombreCampoIdMateria = "id_materia";
    private String _nombreCampoToken = "token";
    private String _id_ayudante;
    private String _id_materia;
    private String _token;

    public AlmacenamientoTokenDTO(String id_ayudante, String id_materia, String token) {
        this._id_ayudante = id_ayudante;
        this._id_materia = id_materia;
        this._token = token;
    }

    public String getIdAyudante() {
        return this._id_ayudante;
    }
    public String getIdMateria() {return this._id_materia;}

    @Override
    public Document getDatabaseFormat() {
        return new Document(this._nombreCampoIdAyudante, this._id_ayudante)
                .append(this._nombreCampoIdMateria, this._id_materia)
                .append(this._nombreCampoToken, this._token);
    }
}
