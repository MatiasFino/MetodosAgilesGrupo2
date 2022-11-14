package com.sistema.ayudantes.sistayudantes;

public class Postulante {
	private int id; //dni
	private char tipo; //graduado/alummno
	private String apellido_nombre;
	private String email;
	private int cant_horas;
	private int cant_materias; 
	
	public Postulante(int id, char tipo, String ap, String email, int cant_horas, int cant_materias) {
		this.id=id;
		this.tipo=tipo;
		this.apellido_nombre=ap;
		this.email=email;
		this.cant_horas=cant_horas;
		this.cant_materias= cant_materias;
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

	public String getEmail() {
		return email;
	}

	public int getCant_horas() {
		return cant_horas;
	}

	public int getCant_materias() {
		return cant_materias;
	}
	
	
	



}
