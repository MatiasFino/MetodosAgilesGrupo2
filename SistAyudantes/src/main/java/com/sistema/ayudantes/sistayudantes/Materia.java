package com.sistema.ayudantes.sistayudantes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.sistema.ayudantes.sistayudantes.Email.EmailService;

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

    public boolean materiaCompleta(){
        return this.ayudantes.size()==this.cantAyudantes;
    }

    //recorre los postulantes y envia invitacion a los graduados hasta completar la cantidad de graduados necesaria o se quede sin postulabtes la materia
    public void solicitarAyudantesGraduados(EmailService mailService){
        Iterator <Postulante> p = this.postulantes.iterator();
        Postulante aux;
        while (p.hasNext() || cantGraduados <= this.solicitudesEnviadas+this.ayudantes.size()){
            aux = p.next();
            if (aux.isGraduado() && aux.disponibleAyudantia()){
                this.postulantes.remove(aux);
                this.solicitudesEnviadas++;
                enviarMail(aux.getApellido_nombre());
            }
        } 
    }

    //recorre todos los postulantes de la materia y le envia invitacion en caso de que el mismo pueda
    //devuelve false en caso de que falten enviar solicitudes pero no disponga de ayudantes
    public boolean solicitarAyudantes(EmailService mailService) {
        for(Postulante p : this.postulantes){
            if (this.cantAyudantes == this.solicitudesEnviadas+this.ayudantes.size()){
                return true;
            }
            if (p.disponibleAyudantia()){
                this.postulantes.remove(p);
                this.solicitudesEnviadas++;
                enviarMail(p.getApellido_nombre());
            }else{
                this.postulantes.remove(p);
            }
        }
        return this.cantAyudantes == this.solicitudesEnviadas+this.ayudantes.size();
    }

    public void enviarMail(String nombrePos){
        System.out.println("se envio mail a "+nombrePos+" por para de la materia"+this.id);
    }

    public void removePostulante (Postulante p){
        this.postulantes.remove(p);
    }

    public void addAyudante (Postulante p){
        this.ayudantes.add(p);
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