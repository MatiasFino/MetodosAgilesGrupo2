package com.sistema.ayudantes.sistayudantes.DatabaseManager.AsignacionMateria;

import com.sistema.ayudantes.sistayudantes.DatabaseManager.LocalDocument;
import org.bson.Document;

public class AsignacionMateriaDTO implements LocalDocument {
    private String _nombreCampoIdAyudante = "id_ayudante";
    private String _nombreCampoIdMateria = "id_materia";
    private String _nombreCampoAyudanteAcepta = "acepta";
    private String _id_ayudante;
    private String _id_materia;
    private boolean _acepta;

    public AsignacionMateriaDTO(String id_ayudante, String id_materia, boolean acepta) {
        this._id_ayudante = id_ayudante;
        this._id_materia = id_materia;
        this._acepta = acepta;
    }

    public String getIdAyudante() {
        return this._id_ayudante;
    }
    public String getIdMateria() {return this._id_materia;}

    @Override
    public Document getDatabaseFormat() {
        return new Document(this._nombreCampoIdAyudante, this._id_ayudante)
                .append(this._nombreCampoIdMateria, this._id_materia)
                .append(this._nombreCampoAyudanteAcepta, this._acepta);
    }
}
