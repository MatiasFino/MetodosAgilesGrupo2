package com.sistema.ayudantes.sistayudantes.Email;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.sistema.ayudantes.sistayudantes.DatabaseManager.DatabaseManager;
import com.sistema.ayudantes.sistayudantes.Materia;
import com.sistema.ayudantes.sistayudantes.Postulante;
import org.bson.Document;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class ScheduledEmail implements Job {

    private MongoCollection<Document> _collectionAsignacion;
    private MongoCollection<Document> _collectionPersona;
    private Materia m;
    private Postulante p;

    public ScheduledEmail (Postulante postulante, Materia materia) {
        _collectionAsignacion = DatabaseManager.getInstance().getDatabase().getCollection("asignacion_materia");
        _collectionPersona= DatabaseManager.getInstance().getDatabase().getCollection("persona");
        this.p=postulante;
        this.m=materia;
    }

    //se busca primero los documentos de ese ayudante, y se devuelve el que corresponda tambien con la materia.
    public Document getDoc () {
        Iterable<Document> itD = this._collectionAsignacion.find(new BasicDBObject("id_ayudante",p.getId()));
        for (Document d : itD) {
            if (d.containsValue(m))
                return d;
        }
        return null;
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        //consultar a db si el ayudante interactuo con la invitacion, chequear si el atributo _acepta en AsignacionMateria != null.
        Document doc = this.getDoc();
        if (doc.get("acepta") == null) {
            Iterable<Document> cursor = _collectionPersona.find();
            Document destinatario = null;
            for (Document d : cursor) {
                if (d.get("id") == doc.get("id_ayudante")) {
                    destinatario = d;
                    break;
                }
            }
            String html = ExpirationEmail.buildEmail(destinatario.getString("nombre"),doc.getString("Materia"));
            EmailService emailSend = EmailService.getInstance();
            emailSend.sendEmail(destinatario.getString("email"),html);
        }
    }
}
