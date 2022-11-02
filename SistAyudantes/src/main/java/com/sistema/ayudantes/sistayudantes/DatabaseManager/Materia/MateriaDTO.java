package com.sistema.ayudantes.sistayudantes.DatabaseManager.Materia;

import com.sistema.ayudantes.sistayudantes.DatabaseManager.LocalDocument;
import org.bson.Document;

public class MateriaDTO implements LocalDocument {
    private String _nombreCampoId = "id";
    private String _nombreCampoNombre = "nombre";
    private String _nombreCampoAyudantesAsignados = "ayudantesAsignados";
    private String _nombreCampoAyudantesNecesarios = "ayudantesNecesarios";
    private String _id;
    private String _nombre;
    private int _ayudantesAsignados;
    private int _ayudantesNecesarios;

    public MateriaDTO(String id, String nombre, int ayudantesAsignados, int ayudantesNecesarios) {
        this._id = id;
        this._nombre = nombre;
        this._ayudantesAsignados = ayudantesAsignados;
        this._ayudantesNecesarios = ayudantesNecesarios;
    }

    public String getId() {
        return this._id;
    }

    @Override
    public Document getDatabaseFormat() {
        return new Document(this._nombreCampoId, this._id)
                .append(this._nombreCampoNombre, this._nombre)
                .append(this._nombreCampoAyudantesAsignados, this._ayudantesAsignados)
                .append(this._nombreCampoAyudantesNecesarios, this._ayudantesNecesarios);
    }
}
