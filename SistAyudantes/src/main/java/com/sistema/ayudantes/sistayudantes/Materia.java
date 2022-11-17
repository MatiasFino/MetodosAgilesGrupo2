package com.sistema.ayudantes.sistayudantes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import com.sistema.ayudantes.sistayudantes.DatabaseManager.AlmacenamientoToken.AlmacenamientoTokenCollection;
import com.sistema.ayudantes.sistayudantes.DatabaseManager.AlmacenamientoToken.AlmacenamientoTokenDTO;
import com.sistema.ayudantes.sistayudantes.Email.EmailSender;
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
    public void solicitarAyudantesGraduados(){
        ArrayList<Postulante> postuAux = (ArrayList<Postulante>) this.postulantes.clone();
        Iterator <Postulante> p = postuAux.iterator();
        Postulante aux;
        while ((p.hasNext()) && (this.cantGraduados > this.solicitudesEnviadas+this.ayudantes.size())){
            aux = p.next();
            if (aux.isGraduado() && aux.disponibleAyudantia()){
                this.postulantes.remove(aux);
                this.solicitudesEnviadas++;
                enviarMail(aux);
            }
        } 
    }

    //recorre todos los postulantes de la materia y le envia invitacion en caso de que el mismo pueda
    //devuelve false en caso de que falten enviar solicitudes pero no disponga de ayudantes
    public boolean solicitarAyudantes() {
        ArrayList<Postulante> aux = (ArrayList<Postulante>) this.postulantes.clone();
        for(Postulante p : aux){
            if (this.cantAyudantes == this.solicitudesEnviadas+this.ayudantes.size()){
                return true;
            }
            if (p.disponibleAyudantia()){
                this.postulantes.remove(p);
                this.solicitudesEnviadas++;
                enviarMail(p);
            }else{
                this.postulantes.remove(p);
            }
        }
        return this.cantAyudantes == this.solicitudesEnviadas+this.ayudantes.size();
    }

    public void enviarMail(Postulante postulante){
        AlmacenamientoTokenCollection atc = AlmacenamientoTokenCollection.getInstance();
		UUID token = UUID.randomUUID();
		atc.insert(new AlmacenamientoTokenDTO(Integer.toString(postulante.getId()), Integer.toString(this.getId()), token.toString()));
		EmailSender.notificarAyudante(postulante, this, token);
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
    	return this.cantAyudantes;
    }
    
    public void restarSolicitudEnviada(){
        this.solicitudesEnviadas--;
    }

    public void sumarSolicitudEnviada(){
        this.solicitudesEnviadas++;
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