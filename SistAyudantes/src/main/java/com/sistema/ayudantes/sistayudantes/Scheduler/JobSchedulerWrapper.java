package com.sistema.ayudantes.sistayudantes.Scheduler;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;

public class JobSchedulerWrapper {
  private static JobSchedulerWrapper jobScheduler;
  private Scheduler scheduler;

  private JobSchedulerWrapper() {
    try {
      this.scheduler = StdSchedulerFactory.getDefaultScheduler();
    } catch (SchedulerException e) {
      e.printStackTrace();
    }
  }

  public void start() {
    try {
      this.scheduler.start();
    } catch (SchedulerException e) {
      e.printStackTrace();
    }
  }

  public static JobSchedulerWrapper getInstance() {
    if (jobScheduler == null) {
      jobScheduler = new JobSchedulerWrapper();
    }
    return jobScheduler;
  }

  public void scheduleJob(JobDetail job, SimpleTrigger trigger) {
    try {
      this.scheduler.scheduleJob(job,trigger);
    } catch (SchedulerException e) {
      e.printStackTrace();
    }
  }
}