package com.sistema.ayudantes.sistayudantes;

import java.util.ArrayList;

public class Materia {
    private int id;
    private ArrayList<Postulante> ayudantes;
    private ArrayList<Postulante> postulantes;
    private int cantAyudantes;
    private int cantGraduados;
    private int solicitudesEnviadas;

    public Materia(int id, int cantAyudantes, int cantGraduados) {
        this.id = id;
        this.cantAyudantes = cantAyudantes;
        this.cantGraduados = cantGraduados;

        this.solicitudesEnviadas=0;
        this.ayudantes=new ArrayList<Postulante>();
        this.postulantes=new ArrayList<Postulante>();
    }

    
}