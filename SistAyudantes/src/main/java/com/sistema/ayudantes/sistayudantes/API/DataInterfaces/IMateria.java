package com.sistema.ayudantes.sistayudantes.API.DataInterfaces;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IMateria {

    public final String id;
    public final String nombre;
    public final int ayudantesAsignados;
    public final int ayudantesNecesarios;

    public IMateria(
            @JsonProperty("_id") Object _id,
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
}
