package com.sistema.ayudantes.sistayudantes.API;

import com.mongodb.BasicDBObject;
import com.sistema.ayudantes.sistayudantes.Controller;
import com.sistema.ayudantes.sistayudantes.DatabaseManager.AlmacenamientoToken.AlmacenamientoTokenCollection;
import com.sistema.ayudantes.sistayudantes.DatabaseManager.AsignacionMateria.AsignacionMateriaCollection;
import com.sistema.ayudantes.sistayudantes.DatabaseManager.AsignacionMateria.AsignacionMateriaDTO;
import com.sistema.ayudantes.sistayudantes.DatabaseManager.Materia.MateriaCollection;
import com.sistema.ayudantes.sistayudantes.DatabaseManager.Persona.PersonaCollection;
import org.bson.Document;
import spark.Route;

import java.util.ArrayList;
import java.util.List;

import static spark.Spark.get;

public class APIEndpoints {
    public static void configureRoutes() {
        get("/materias", "application/json", APIEndpoints.listadoMaterias);
        get("/ayudantes-materia", "application/json", APIEndpoints.ayudantesMateria);
        // aceptar-materia y rechazar-materia no es correcto que sean GET deberian ser POST,
        // pero para mostrar un mensaje en la página lo dejo como GET.
        get("/aceptar-materia", APIEndpoints.aceptarMateria);
        get("/rechazar-materia", APIEndpoints.rechazarMateria);
    }

    private static final Route listadoMaterias = (request, response) -> {
        MateriaCollection materiaCollection = MateriaCollection.getInstance();
        List<String> datosMaterias = new ArrayList<>();
        for (Document materia :  materiaCollection.getMaterias()) {
            datosMaterias.add(materia.toJson());
        }
        return datosMaterias;
    };

    private static final Route ayudantesMateria = (request, response) -> {
        String idMateria = request.queryParams("id_materia");
        AsignacionMateriaCollection asignacionMateriaCollection = AsignacionMateriaCollection.getInstance();

        BasicDBObject query = new BasicDBObject("id_materia", idMateria)
                .append("acepta", true);
        List<String> ayudantesMateria = new ArrayList<>();
        for (Document asignacionMateria :  asignacionMateriaCollection.getAsignacionesMateria(query)) {
            BasicDBObject personaQuery = new BasicDBObject("id", asignacionMateria.get("id_ayudante"));
            PersonaCollection personaCollection = PersonaCollection.getInstance();
            for (Document persona : personaCollection.getPersona(personaQuery)) {
                ayudantesMateria.add(persona.toJson());
            }
        }
        return ayudantesMateria;
    };

    private static final Route aceptarMateria = (request, response) -> {
        String id_persona = request.queryParams("id_persona");
        String id_materia = request.queryParams("id_materia");
        String requestToken = request.queryParams("token");
        // corroborar que el token sea el mismo que el almacenado en la base de datos
        AlmacenamientoTokenCollection atc = AlmacenamientoTokenCollection.getInstance();
        BasicDBObject tokenQuery = new BasicDBObject("id_ayudante", id_persona)
                                    .append("id_materia", id_materia);
        for (Document token :  atc.getTokens(tokenQuery)) {
            if (!token.getString("token").equals(requestToken)) {
                return "El token es inválido";
            }
        }

        boolean borrado = atc.delete(id_persona, id_materia);
        if (!borrado) {
            return "No se pudo almacenar tu respuesta";
        }
        Controller controllerIns = Controller.getInstance();
        if (controllerIns.confirmarDisponibilidad(Integer.parseInt(id_persona))){
            controllerIns.agregarAyudanteMateria(Integer.parseInt(id_materia),Integer.parseInt(id_persona));
            AsignacionMateriaCollection asignacionMateriaCollection = AsignacionMateriaCollection.getInstance();
            boolean insercion = asignacionMateriaCollection.insert(new AsignacionMateriaDTO(id_persona, id_materia, true));
    
            if (insercion) {
                MateriaCollection materiaCollection = MateriaCollection.getInstance();
                Document materia = materiaCollection.getMaterias(new BasicDBObject("id", id_materia)).cursor().next();
                Integer cantidadAsignados = materia.getInteger("ayudantesAsignados");
                BasicDBObject newDocument = new BasicDBObject("ayudantesAsignados", cantidadAsignados + 1);
                materiaCollection.update(id_materia, newDocument);
                return "Has sido asignado a la materia";
            } else {
                return "Ya habiamos registrado tu respuesta";
            }
        }else{
            boolean insercion = descartarPostulante(id_persona,id_materia);
            if (insercion)
            return "Se rechazo la solicitud ya que ocupaste la maxima cantidad de ayudantias que podias";
        else
            return "Ya habiamos registrado tu respuesta";
        }

    };

    private static final Route rechazarMateria = (request, response) -> {
        String id_persona = request.queryParams("id_persona");
        String id_materia = request.queryParams("id_materia");
        String requestToken = request.queryParams("token");
        // corroborar que el token sea el mismo que el almacenado en la base de datos
        AlmacenamientoTokenCollection atc = AlmacenamientoTokenCollection.getInstance();
        BasicDBObject tokenQuery = new BasicDBObject("id_ayudante", id_persona)
                .append("id_materia", id_materia);
        for (Document token :  atc.getTokens(tokenQuery)) {
            if (!token.getString("token").equals(requestToken)) {
                return "El token es inválido";
            }
        }

        boolean borrado = atc.delete(id_persona, id_materia);
        if (!borrado) {
            return "No se pudo almacenar tu respuesta";
        }
        
        boolean insercion = descartarPostulante(id_persona,id_materia);

        if (insercion)
            return "Has rechazado la asignacion a la materia";
        else
            return "Ya habiamos registrado tu respuesta";
    };

    public static boolean descartarPostulante(String id_persona, String id_materia){
        Controller controllerIns = Controller.getInstance();
        controllerIns.rechazarSolicitud(Integer.parseInt(id_materia),Integer.parseInt(id_persona));
        AsignacionMateriaCollection asignacionMateriaCollection = AsignacionMateriaCollection.getInstance();
        return asignacionMateriaCollection.insert(new AsignacionMateriaDTO(id_persona, id_materia, false));

    };
}
