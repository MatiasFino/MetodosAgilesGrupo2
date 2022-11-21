package com.sistema.ayudantes.sistayudantes.Scheduler.CustomJobs;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.sistema.ayudantes.sistayudantes.API.APIEndpoints;
import com.sistema.ayudantes.sistayudantes.DatabaseManager.AlmacenamientoToken.AlmacenamientoTokenCollection;
import com.sistema.ayudantes.sistayudantes.DatabaseManager.AsignacionMateria.AsignacionMateriaCollection;
import com.sistema.ayudantes.sistayudantes.Email.EmailSender;

import org.bson.Document;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class ScheduledEmail implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        try {
            String idPersona = jobExecutionContext.getJobDetail().getJobDataMap().get("idPersona").toString();
            String nombrePersona = jobExecutionContext.getJobDetail().getJobDataMap().get("nombrePersona").toString();
            String email = jobExecutionContext.getJobDetail().getJobDataMap().get("email").toString();
            String idMateria = jobExecutionContext.getJobDetail().getJobDataMap().get("idMateria").toString();
            String nombreMateria = jobExecutionContext.getJobDetail().getJobDataMap().get("nombreMateria").toString();

            AsignacionMateriaCollection coleccionAsignacion = AsignacionMateriaCollection.getInstance();
            BasicDBObject query = new BasicDBObject("id_materia", idMateria)
                                        .append("id_ayudante", idPersona);
            FindIterable<Document> asignaciones = coleccionAsignacion.getAsignacionesMateria(query);
            
            if (!asignaciones.iterator().hasNext()) {
                AlmacenamientoTokenCollection coleccionAlmacenamiento = AlmacenamientoTokenCollection.getInstance();
                coleccionAlmacenamiento.delete(idPersona, idMateria);
                APIEndpoints.descartarPostulante(idPersona, idMateria);
                EmailSender.expiracionInvitacion(nombrePersona, nombreMateria, email);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
