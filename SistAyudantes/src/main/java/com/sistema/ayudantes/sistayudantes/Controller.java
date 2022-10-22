package com.sistema.ayudantes.sistayudantes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

public class Controller {
    private ArrayList<Materia> materias; 
    //private Hashtable<Materia, ArrayList<Integer>> postulantes; 
    
    public Controller(){
        this.materias=new ArrayList<Materia>();
        //this.postulantes=new Hashtable<Materia, ArrayList<Integer>>();
    }
    
    private void extraerLineasCsv(String csv, ArrayList<String[]> filasCsv){ //csv cuantificador del grupo1   csv= Documentos/archivo.csv
	        
	        String SEPARADOR = ",";
	        BufferedReader bufferLectura = null;
	        try {
	         // Abrir el .csv en buffer de lectura
	        
	         bufferLectura = new BufferedReader(new FileReader(csv));
	         
	         // Leer una linea del archivo
	         String linea = bufferLectura.readLine();
	         while (linea != null) {
	            // Sepapar la linea leída con el separador definido previamente
	            //String[] campos = new String[2];
	          
	            String[] a = linea.split(SEPARADOR);
	            filasCsv.add(a);
	            // Volver a leer otra línea del fichero
	            linea = bufferLectura.readLine();
	            }
	        } 
	        catch (IOException e) {
	         e.printStackTrace();
	        }
	        finally {
	         // Cierro el buffer de lectura
	         if (bufferLectura != null) {
	          try {
	           bufferLectura.close();
	          } 
	          catch (IOException e) {
	           e.printStackTrace();
	          }
	         }
	        }
	
	        //System.out.println("Materias: "+ this.materias.size());
	    }
    
    
   //Se recibe un csv el cual contiene para cada materia, la cantidad de ayudantes que le corresponden y la cantidad de graduados que la/el docente a cargo decidio 
   public void cargarMaterias(String csv) {
    	ArrayList <String[]> dmaterias= new ArrayList<String[]>(); //guardamos en un ArrayList los datos por materia
    	this.extraerLineasCsv(csv, dmaterias);
    	for (String[] dmateria: dmaterias) { 
    		Materia m = new Materia(Integer.parseInt(dmateria[0]),Integer.parseInt(dmateria[1]),Integer.parseInt(dmateria[2])); //ID Materia, cantidadAyudantes, cantidadGraduados (1,5,2)
            this.materias.add(m);
    	}
        System.out.println("Materias: "+ this.materias.size());

    }

   //Se recibe un csv con ordenes de merito de cada postulante, y se le agrega a cada materia (cargadas previamente) el postulante leido.
    public void cargarPostulantes(String csv){
    	ArrayList <String[]> dPostulantes= new ArrayList<String[]>(); //guaradamos en un ArrayList los datos por postulante y el id de la materia a la que se postula
    	this.extraerLineasCsv(csv, dPostulantes); //linea: ID materia, ID postulante, tipo de postulante, nombre del postulante, email, cantidad horas que trabaja, cantidad de materias asignadas
    	for (String[] dpostulante: dPostulantes) {
    		if (existeMateria(Integer.parseInt(dpostulante[0]))) {
    			Postulante p = new Postulante(Integer.parseInt(dpostulante[1]), dpostulante[2].charAt(0), dpostulante[3], dpostulante[4], Integer.parseInt(dpostulante[5]), Integer.parseInt(dpostulante[6]));
    			this.cargarPostulanteMateria(Integer.parseInt(dpostulante[0]), p);
    		}
    	}
 
    }
    
    private boolean existeMateria(int id) {
    	for (Materia m: this.materias){
    		if (m.getId()==id) 
    			return true;
    	}
    	return false;
    }
    
    private void cargarPostulanteMateria(int id, Postulante p) { // se carga el postulante a la materia 
    	for (Materia m: this.materias) {
    		if (m.getId()== id){
    			m.cargarPostulante(p);
    		}
    	}
    }

    public void asignarAyudantes(){
        
    }

    public void ayudantesMateria(){
        
    }

    public int cantAyudantesMateria(){
        return 0;
    }

    public void imprimirPostulantesxMateria() {
    	for (Materia m: this.materias) {
    		m.imprimirPostulantes();
    	}
    }
}



