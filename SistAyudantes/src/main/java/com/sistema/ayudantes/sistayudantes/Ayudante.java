package com.sistema.ayudantes.sistayudantes;

import javafx.beans.property.SimpleStringProperty;

public class Ayudante {
    private SimpleStringProperty nombre;

    public Ayudante (String nombre){
        this.nombre = new SimpleStringProperty(nombre);
    }

    public String getNombre() {
        return nombre.get();
    }

    public SimpleStringProperty nombreProperty() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }
}
