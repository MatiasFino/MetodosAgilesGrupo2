package com.sistema.ayudantes.sistayudantes.API.DataInterfaces;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IAyudante {

    public final String id;
    public final String nombre;
    public final String apellido;
    public final String email;
    public final String tipo;
    public final String cantidadMateriasAsignadas;

    public IAyudante(
            @JsonProperty("_id") Object _id,
            @JsonProperty("id") String id,
            @JsonProperty("nombre") String nombre,
            @JsonProperty("apellido") String apellido,
            @JsonProperty("email") String email,
            @JsonProperty("tipo") String tipo,
            @JsonProperty("cantidad_materias_asignadas") String cantidadMateriasAsignadas
    ) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.tipo = tipo;
        this.cantidadMateriasAsignadas = cantidadMateriasAsignadas;
    }
}
