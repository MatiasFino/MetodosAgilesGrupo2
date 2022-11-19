package com.sistema.ayudantes.sistayudantes.Scheduler;

import java.util.Date;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SimpleTrigger;

import com.sistema.ayudantes.sistayudantes.Constants;
import com.sistema.ayudantes.sistayudantes.Materia;
import com.sistema.ayudantes.sistayudantes.Postulante;
import com.sistema.ayudantes.sistayudantes.Scheduler.CustomJobs.ScheduledEmail;
import com.sistema.ayudantes.sistayudantes.Utils.DateUtils;

import static org.quartz.TriggerBuilder.newTrigger;

public class JobScheduler {
  public static void expirationMail (Postulante postulante, Materia materia) {
    JobDetail job = JobBuilder.newJob(ScheduledEmail.class).build();
    job.getJobDataMap().put("idPersona", postulante.getId());
    job.getJobDataMap().put("nombrePersona", postulante.getApellido_nombre());
    job.getJobDataMap().put("email", postulante.getEmail());
    job.getJobDataMap().put("idMateria", materia.getId());
    job.getJobDataMap().put("nombreMateria", materia.getNombre());
    SimpleTrigger trigger = (SimpleTrigger) newTrigger()
      .startAt(
        DateUtils.addHoursToJavaUtilDate(new Date(), Constants.TIEMPO_EXPIRACION_INVITACION_AYUDANTIA_EN_HORAS)
      )
      .build();

    JobSchedulerWrapper.getInstance().scheduleJob(job, trigger);
  }
}
