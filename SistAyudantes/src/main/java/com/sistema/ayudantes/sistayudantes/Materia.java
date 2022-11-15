package com.sistema.ayudantes.sistayudantes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Materia {
    private int id;
    private String nombre;
    private ArrayList<Postulante> ayudantes;
    private ArrayList<Postulante> postulantes;
    private int cantAyudantes;
    private int cantGraduados;
    private int solicitudesEnviadas;

    public Materia(int id, String nombre, int cantAyudantes, int cantGraduados) {
        this.id = id;
        this.nombre=nombre;
        this.cantAyudantes = cantAyudantes;
        this.cantGraduados = cantGraduados;

        this.solicitudesEnviadas=0;
        this.ayudantes=new ArrayList<Postulante>();
        this.postulantes=new ArrayList<Postulante>();
    }

    public void cargarPostulante(Postulante ayudante_nuevo) {
    	if (!postulantes.contains(ayudante_nuevo)) {
    		postulantes.add(ayudante_nuevo);
    	}
    }
    
    public int getId() {
    	return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantAyudantes() {
    	return this.cantAyudantes + this.cantGraduados;
    }
    
    public void imprimirPostulantes() {
    	System.out.println("Postulantes a la MATERIA: " + this.getId());
    	for (Postulante p: this.postulantes) {
    		System.out.println(p.getId());
    	}
    }
    public List<Postulante> getAyudantes() {
        return Collections.unmodifiableList(this.ayudantes);
    }

    public List<Postulante> getPostulantes() {
        return Collections.unmodifiableList(this.postulantes);
    }
    
}