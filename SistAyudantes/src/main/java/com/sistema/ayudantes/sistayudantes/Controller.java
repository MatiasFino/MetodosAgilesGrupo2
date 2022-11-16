package com.sistema.ayudantes.sistayudantes;

import com.sistema.ayudantes.sistayudantes.DatabaseManager.Materia.MateriaCollection;
import com.sistema.ayudantes.sistayudantes.DatabaseManager.Materia.MateriaDTO;
import com.sistema.ayudantes.sistayudantes.Email.EmailService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Controller {
    private ArrayList<Materia> materias; 
    private Hashtable<Integer, Postulante> postulantes; //idPostulante, Postulante
	private ArrayList<Postulante> postulantesDisponibles;
	private EmailService mailService;
	private static Controller controllerInstance;
    
    private Controller(EmailService mailService){
		this.mailService = mailService;
		this.materias=new ArrayList<Materia>();
        this.postulantes=new Hashtable<Integer, Postulante>();
		this.postulantesDisponibles = new ArrayList<Postulante>();
	}

	public static Controller getInstance(EmailService mailService){
		if (controllerInstance == null){
			if (mailService == null){
				System.out.println("No se puede iniciar un Controller con mailservice en null");
			}else{
				controllerInstance = new Controller(mailService);
			}
		}
		return controllerInstance;
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
    }
    
    
   //Se recibe un csv el cual contiene para cada materia, la cantidad de ayudantes que le corresponden y la cantidad de graduados que la/el docente a cargo decidio 
   public void cargarMaterias(String csv) {
    	ArrayList <String[]> dmaterias= new ArrayList<String[]>(); //guardamos en un ArrayList los datos por materia
    	this.extraerLineasCsv(csv, dmaterias);
    	for (String[] dmateria: dmaterias) { 
    		Materia m = new Materia(Integer.parseInt(dmateria[0]),dmateria[1],Integer.parseInt(dmateria[2]),Integer.parseInt(dmateria[3])); //ID Materia, nombre materia, cantidadAyudantes, cantidadGraduados (1,materia1,5,2)
            this.materias.add(m);
			MateriaCollection mc = MateriaCollection.getInstance();
			mc.insert(new MateriaDTO(Integer.toString(m.getId()), m.getNombre(), 0, m.getCantAyudantes()));
    	}
        System.out.println("Cantidad de materias cargadas: "+ this.materias.size());

    }

   //Se recibe un csv con ordenes de merito de cada postulante, y se le agrega a cada materia (cargadas previamente) el postulante leido.
    public void cargarPostulantes(String csv){
    	ArrayList <String[]> dPostulantes= new ArrayList<String[]>(); //guardamos en un ArrayList los datos por postulante y el id de la materia a la que se postula
    	this.extraerLineasCsv(csv, dPostulantes); //linea: ID materia, ID postulante, tipo de postulante, nombre del postulante, email, cantidad horas que trabaja, cantidad de materias asignadas
    	for (String[] dpostulante: dPostulantes) {
    		if (existeMateria(Integer.parseInt(dpostulante[0]))) {
    			if (!this.postulantes.containsKey(Integer.parseInt(dpostulante[1]))) {
    				Postulante p = new Postulante(Integer.parseInt(dpostulante[1]), dpostulante[2].charAt(0), dpostulante[3], dpostulante[4], Integer.parseInt(dpostulante[5]), Integer.parseInt(dpostulante[6]));
					p.addMateriaPendiente();
    				this.postulantes.put(Integer.parseInt(dpostulante[1]), p);
    				this.cargarPostulanteMateria(Integer.parseInt(dpostulante[0]), p);
    			}
    			else {
					Postulante p = this.postulantes.get(Integer.parseInt(dpostulante[1]));
					p.addMateriaPendiente();
    				this.cargarPostulanteMateria(Integer.parseInt(dpostulante[0]), p);
				}
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

	/*Agrega un postulante a la lista de ayudantes, ademas en caso de que esa materia se complete se fija si los postulantes sobrantes 
	de dicha materia pueden ser agregados a la lista de ayudantes disponibles*/
	public void agregarAyudanteMateria(int idMateria, int idAyudante){
		Postulante p = this.postulantes.get(idAyudante);
		p.restarMateriaPendiente();
		for(Materia mat : this.materias){
			if (mat.getId()==idMateria){
				mat.addAyudante(p);
				if(mat.materiaCompleta()){
					for (Postulante pos : mat.getPostulantes()){
						pos.restarMateriaPendiente();
						if (pos.getMateriasPendientes() == 0){
							this.postulantesDisponibles.add(p);
						}
					}
				}
			}
			else{
				return;
			}
		}
	}

	//recorre todas las materias y en cada una solicita enviar las invitaciones a postulantes graduados y alumnos
    public void asignarAyudantes(){
		for(Materia mat : this.materias) {
			mat.solicitarAyudantesGraduados(this.mailService);
			mat.solicitarAyudantes(this.mailService);
		}
    }

	//dada una materia se envian las solicitudes para intentar completar la ayudantia de la misma
	public void asignarAyudanteMateria(int idMateria){
		for(Materia mat : this.materias){
			if (mat.getId()==idMateria){
				mat.solicitarAyudantes(this.mailService);
				return;
			}
		}
	}

	//retorna un ayudante disponible, un ayudante disponible es aquel que no como postulante en ninguna materia que no este completa
	public Postulante postulanteDisponible(){
		for (Postulante p : this.postulantesDisponibles){
			if (p.disponibleAyudantia()){
				return p;
			}
		}
		return null;
	}

	//Obtener ayudantes de una materia por ID. Utilizado una vez que se realizaron las asignaciones
    public List<Postulante> ayudantesMateria(int id) {
		for(Materia m : this.materias) {
			if(m.getId() == id) {
				return m.getAyudantes();
			}
		}
      return new ArrayList<>();
    }

    public void imprimirPostulantesxMateria() {
    	for (Materia m: this.materias) {
    		m.imprimirPostulantes();
    	}
    }
    
    public void imprimirTotalPostulates() {
    	System.out.println("Cantidad de postulantes totales : " + this.postulantes.size());
    	System.out.println("Id de postulantes cargados : ");
    	for (Postulante p: this.postulantes.values()) {
    		System.out.println(p.getId());
    	}
    }
    
    //devuelve un mapa con los pares <idMateria, cantAyudantes>
    public Map<Integer, Integer> cantAyudantesMateria(){
    	Map<Integer, Integer> mapa= new HashMap<>();
    	for (Materia m: this.materias) {
    		mapa.put(m.getId(), m.getCantAyudantes());
    	}
		return mapa;
    }
    
}



