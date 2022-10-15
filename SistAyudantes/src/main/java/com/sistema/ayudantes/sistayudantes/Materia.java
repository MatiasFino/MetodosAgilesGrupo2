package com.sistema.ayudantes.sistayudantes;

import java.util.ArrayList;

public class Materia {
    private String nombre;
    private ArrayList<String> ayudantes;

    public Materia(String nombre){
        this.nombre = nombre;
        this.ayudantes = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<String> getAyudantes() {
        ArrayList<String> copia = new ArrayList<>();
        for(int i=0;i<ayudantes.size();i++){
            copia.add(ayudantes.get(i));
        }
        return copia;
    }

    public void addAyudante(String ayudante) {
        if(!ayudantes.contains(ayudante)) {
            ayudantes.add(ayudante);
        }
    }
}
