package com.sistema.ayudantes.sistayudantes;

public class Postulante {
	private int id; //dni
	private char tipo; //graduado/alummno
	private String apellido_nombre;
	private String email;
	private int cant_horas;
	private int cant_materias; 
	private int cant_materias_pendientes;
	
	public Postulante(int id, char tipo, String ap, String email, int cant_horas, int cant_materias) {
		this.id=id;
		this.tipo=tipo;
		this.apellido_nombre=ap;
		this.email=email;
		this.cant_horas=cant_horas;
		this.cant_materias= cant_materias;
		this.cant_materias_pendientes = 0;
	}
	
	@Override
	public boolean equals (Object o) {
		Postulante p= (Postulante) o;
		if (p.getId()== this.id)
				return true;
		return false;
		
	}

	public int getId() {
		return id;
	}

	public char getTipo() {
		return tipo;
	}

	public String getApellido_nombre() {
		return apellido_nombre;
	}

	public void addMateriaPendiente(){
		this.cant_materias_pendientes++;
	}

	public void restarMateriaPendiente(){
		this.cant_materias_pendientes--;
	}

	public int getMateriasPendientes(){
		return this.cant_materias_pendientes;
	}

	public String getEmail() {
		return email;
	}

	public int getCant_horas() {
		return cant_horas;
	}

	public int getCant_materias() {
		return cant_materias;
	}

	public void addMateria(){
		this.cant_materias++ ;
	}

	public boolean isGraduado(){
		return this.tipo == "G".charAt(0);
	}
	
	public boolean disponibleAyudantia(){
		if (this.tipo == "G".charAt(0)) {
			return this.cant_materias < Constants.MAX_AYUDANTIAS_GRADUADO;
		}
		else {
			return this.cant_materias < Constants.MAX_AYUDANTIAS_ALUMNO;
		}
	}
	



}
