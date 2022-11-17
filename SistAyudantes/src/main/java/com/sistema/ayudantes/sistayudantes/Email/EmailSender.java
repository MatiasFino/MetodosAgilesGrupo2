package com.sistema.ayudantes.sistayudantes.Email;

import com.sistema.ayudantes.sistayudantes.Materia;
import com.sistema.ayudantes.sistayudantes.Postulante;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.Date;
import java.util.UUID;

import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

public class EmailSender {

    public static int notificarAyudante(Postulante postulante, Materia materia, UUID token) {
        try {
            EmailService emailSend = EmailService.getInstance();
            String emailHTML = ConfirmationEmail.buildEmail(
                    postulante.getApellido_nombre(),
                    materia.getNombre(),
                    Integer.toString(postulante.getId()),
                    Integer.toString(materia.getId()),
                    token.toString()
            );

            //
            emailSend.sendEmail(postulante.getEmail(), emailHTML);
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();

            JobDetail job = JobBuilder.newJob(ScheduledEmail.class)
                    .withIdentity("scheduledEmail")
                    .build();
            var d = new Date();

            SimpleTrigger trigger = newTrigger().withIdentity("trigger1")
                    .startAt(new Date(System.currentTimeMillis()+ 259200000)) // 259200000 son 72 horas, el evento arranca ahi
                    .withSchedule(simpleSchedule().withRepeatCount(1)) // se repite una sola vez.
                    .build();

            scheduler.scheduleJob(job,trigger);
            return 200;
        } catch (Exception e) {
            return 500;
        }
    }
}
