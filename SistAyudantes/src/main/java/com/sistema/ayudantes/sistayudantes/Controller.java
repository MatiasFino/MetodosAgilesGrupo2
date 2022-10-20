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
    private Hashtable<Materia, ArrayList<Integer>> postulantes; 
    
    public Controller(){
        this.materias=new ArrayList<Materia>();
        this.postulantes=new Hashtable<Materia, ArrayList<Integer>>();
    }
    public void cargarMaterias(String csv){ //csv cuantificador del grupo1   csv= Documentos/archivo.csv
        
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
          
            String[] a = linea.split(SEPARADOR);//Materia, cantidadAyudantes, cantidadGraduados (1,5,2)
            Materia m = new Materia(Integer.parseInt(a[0]),Integer.parseInt(a[1]),Integer.parseInt(a[2]));
            materias.add(m);
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

        System.out.println("Materias: "+ this.materias.size());
    }

    public void cargarPostulantes(){
        
    }

    public void asignarAyudantes(){
        
    }

    public void ayudantesMateria(){
        
    }

    public int cantAyudantesMateria(){
        return 0;
    }

}



