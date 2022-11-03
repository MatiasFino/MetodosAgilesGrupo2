package com.sistema.ayudantes.sistayudantes.DatabaseManager.Persona;

import com.sistema.ayudantes.sistayudantes.DatabaseManager.LocalDocument;
import org.bson.Document;

public class PersonaDTO implements LocalDocument {
    private String _nombreCampoIdPersona = "id";
    private String _nombreCampoNombre = "nombre";
    private String _nombreCampoApellido = "apellido";
    private String _nombreCampoEmail = "email";
    private String _nombreCampoTipo = "tipo";
    private String _nombreCampoCantidadMateriasAsignadas = "cantidad_materias_asignadas";
    private String _idPersona;
    private String _nombre;
    private String _apellido;
    private String _email;
    private String _tipo;
    private int _cantidadMateriasAsignadas;

    public PersonaDTO(String idPersona, String nombre, String apellido, String email, String tipo, int cantidadMateriasAsignadas) {
        this._idPersona = idPersona;
        this._nombre = nombre;
        this._apellido = apellido;
        this._email = email;
        this._tipo = tipo;
        this._cantidadMateriasAsignadas = cantidadMateriasAsignadas;
    }

    public String getIdPersona() {
        return this._idPersona;
    }

    @Override
    public Document getDatabaseFormat() {
        return new Document(this._nombreCampoIdPersona, this._idPersona)
                .append(this._nombreCampoNombre, this._nombre)
                .append(this._nombreCampoApellido, this._apellido)
                .append(this._nombreCampoEmail, _email)
                .append(this._nombreCampoTipo, this._tipo)
                .append(this._nombreCampoCantidadMateriasAsignadas, this._cantidadMateriasAsignadas);
    }
}
