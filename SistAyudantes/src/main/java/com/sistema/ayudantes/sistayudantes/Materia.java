package com.sistema.ayudantes.sistayudantes;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Label;

import java.util.ArrayList;

public class Materia {
    private Label nombre;
    private ArrayList<Ayudante> ayudantes;
    private int ayudantesNecesarios;
    private Label Estado;


    private int cantidadAyudantes;

    public Materia(String nombre){
        this.nombre = new Label(nombre);
        this.ayudantes = new ArrayList<>();
        this.cantidadAyudantes=0;
        this.Estado=new Label("sin estado");
    }

    public String getNombre() {
        return nombre.getText();
    }

    public void setNombre(String nombre) {
        this.nombre.setText(nombre);
    }

    public ArrayList<Ayudante> getAyudantes() {
        ArrayList<Ayudante> copia = new ArrayList<>();
        for(int i=0;i<ayudantes.size();i++){
            copia.add(ayudantes.get(i));
        }
        return copia;
    }

    public int cantAyudantesActuales(){
        return getAyudantes().size();
    }

    public void addAyudante(Ayudante ayudante) {
        if(!ayudantes.contains(ayudante)) {
            ayudantes.add(ayudante);
        }
    }
    public int getAyudantesNecesarios() {
        return ayudantesNecesarios;
    }
    public void setAyudantesNecesarios(int ayudantesNecesarios) {
        this.ayudantesNecesarios = ayudantesNecesarios;
    }


    public void estadoMateria(){
        if(cantAyudantesActuales() < ayudantesNecesarios) {
            setEstado("Incompleto");
        }
        if (cantAyudantesActuales() == ayudantesNecesarios && (cantAyudantesActuales()!=0)){
            setEstado("Completo");
        }
        if (cantAyudantesActuales() == 0)
            setEstado("Sin candidatos");
    }



    public void setEstado(String estado){
        this.Estado.setText(estado);
    }

    public String getEstado(){
        return Estado.getText();
    }


}
