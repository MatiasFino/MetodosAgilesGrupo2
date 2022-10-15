package com.sistema.ayudantes.sistayudantes;

import java.util.ArrayList;

public class Materia {
    private String nombre;
    private ArrayList<String> ayudantes;

    private int cantidadAyudantes;

    public Materia(String nombre){
        this.nombre = nombre;
        this.ayudantes = new ArrayList<>();
        this.cantidadAyudantes=0;
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

    public int cantidadAyudantes(){
        return cantidadAyudantes;
    }

    public void setAyudantes(int cantidad){
        this.cantidadAyudantes=cantidad;
    }


    public String estadoMateria(int cantidad){
        if(cantidad < cantidadAyudantes){
            return "Incompleto";
        }
        return "Completo";
    }
}
