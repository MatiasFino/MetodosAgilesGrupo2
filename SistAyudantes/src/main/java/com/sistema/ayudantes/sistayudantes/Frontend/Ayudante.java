package com.sistema.ayudantes.sistayudantes.Frontend;

import javafx.scene.control.Label;

public class Ayudante {
    private Label nombre;
    private Label tipo;
    private Label email;
    private Label Apellido;

    public Ayudante (String nombre,String tipo,String email,String Apellido){
        this.Apellido=new Label(Apellido);
        this.email=new Label(email);
        this.tipo=new Label(tipo);
        this.nombre = new Label(nombre);
    }

    public String getNombre() {
        return nombre.getText();
    }

    public void setNombre(String nombre) {
        this.nombre.getText();
    }


    public String getEmail() {
        return email.getText();
    }

    public String getTipo() {
        return tipo.getText();
    }

    public String getApellido(){
        return Apellido.getText();
    }
}
