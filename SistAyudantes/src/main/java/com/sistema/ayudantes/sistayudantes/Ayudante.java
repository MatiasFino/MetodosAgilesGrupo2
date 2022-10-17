package com.sistema.ayudantes.sistayudantes;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Label;

public class Ayudante {
    private Label nombre;

    public Ayudante (String nombre){
        this.nombre = new Label(nombre);
    }

    public String getNombre() {
        return nombre.getText();
    }

    public void setNombre(String nombre) {
        this.nombre.getText();
    }
}
