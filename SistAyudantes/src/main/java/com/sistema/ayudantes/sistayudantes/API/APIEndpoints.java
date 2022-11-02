package com.sistema.ayudantes.sistayudantes.API;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import com.sistema.ayudantes.sistayudantes.DatabaseManager.AsignacionMateria.AsignacionMateriaCollection;
import com.sistema.ayudantes.sistayudantes.DatabaseManager.AsignacionMateria.AsignacionMateriaDTO;
import com.sistema.ayudantes.sistayudantes.DatabaseManager.Materia.MateriaCollection;
import org.bson.Document;
import org.bson.json.JsonWriter;
import spark.Route;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import static spark.Spark.get;
import static spark.Spark.post;

public class APIEndpoints {
    public static void configureRoutes() {
        get("/materias", "application/json", APIEndpoints.listadoMaterias);
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

    private static final Route aceptarMateria = (request, response) -> {
        String id_persona = request.queryParams("id_persona");
        String id_materia = request.queryParams("id_materia");
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

    };

    private static final Route rechazarMateria = (request, response) -> {
        String id_persona = request.queryParams("id_persona");
        String id_materia = request.queryParams("id_materia");
        AsignacionMateriaCollection asignacionMateriaCollection = AsignacionMateriaCollection.getInstance();
        boolean insercion = asignacionMateriaCollection.insert(new AsignacionMateriaDTO(id_persona, id_materia, false));

        if (insercion)
            return "Has rechazado la asignacion a la materia";
        else
            return "Ya habiamos registrado tu respuesta";
    };
}
