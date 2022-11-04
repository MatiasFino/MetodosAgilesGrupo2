package com.sistema.ayudantes.sistayudantes.DatabaseManager.Materia;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sistema.ayudantes.sistayudantes.DatabaseManager.LocalDocument;
import org.bson.Document;

public class MateriaDTO implements LocalDocument {
    private String _nombreCampoId = "id";
    private String _nombreCampoNombre = "nombre";
    private String _nombreCampoAyudantesAsignados = "ayudantesAsignados";
    private String _nombreCampoAyudantesNecesarios = "ayudantesNecesarios";
    private String id;
    private String nombre;
    private int ayudantesAsignados;
    private int ayudantesNecesarios;

    public MateriaDTO(String id, String nombre, int ayudantesAsignados, int ayudantesNecesarios) {
        this.id = id;
        this.nombre = nombre;
        this.ayudantesAsignados = ayudantesAsignados;
        this.ayudantesNecesarios = ayudantesNecesarios;
    }

    public MateriaDTO(
            @JsonProperty("id") String id,
            @JsonProperty("nombre") String nombre,
            @JsonProperty("ayudantesAsignados") String ayudantesAsignados,
            @JsonProperty("ayudantesNecesarios") String ayudantesNecesarios
    ) {
        this.id = id;
        this.nombre = nombre;
        this.ayudantesAsignados = Integer.parseInt(ayudantesAsignados);
        this.ayudantesNecesarios = Integer.parseInt(ayudantesNecesarios);
    }

    public String getId() {
        return this.id;
    }

    @Override
    public Document getDatabaseFormat() {
        return new Document(this._nombreCampoId, this.id)
                .append(this._nombreCampoNombre, this.nombre)
                .append(this._nombreCampoAyudantesAsignados, this.ayudantesAsignados)
                .append(this._nombreCampoAyudantesNecesarios, this.ayudantesNecesarios);
    }
}
