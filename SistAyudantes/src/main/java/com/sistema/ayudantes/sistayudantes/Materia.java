package com.sistema.ayudantes.sistayudantes;

import com.fasterxml.jackson.annotation.JsonProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Label;

import java.util.ArrayList;

public class Materia {
    private Label nombre;
    public final String id;
    public final int ayudantesAsignados;
    public final int ayudantesNecesarios;
    private Label Estado;

    public Materia(String id, String nombre, int ayudantesAsignados, int ayudantesNecesarios){
        this.nombre = new Label(nombre);
        this.id = id;
        this.ayudantesAsignados= ayudantesAsignados;
        this.ayudantesNecesarios= ayudantesNecesarios;
        this.Estado=new Label("sin estado");
    }

    public String getNombre() {
        return nombre.getText();
    }

    public void setNombre(String nombre) {
        this.nombre.setText(nombre);
    }

    public void estadoMateria(){
        if(ayudantesAsignados < ayudantesNecesarios) {
            setEstado("Incompleto");
        }
        if (ayudantesAsignados == ayudantesNecesarios && (ayudantesAsignados!=0)){
            setEstado("Completo");
        }
        if (ayudantesAsignados == 0)
            setEstado("Sin candidatos");
    }



    public void setEstado(String estado){
        this.Estado.setText(estado);
    }

    public String getEstado(){
        return Estado.getText();
    }


}
