package com.revature.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.scheduling.support.SimpleTriggerContext;

public class ScheduleTextMessage {

	public static void message(String date, String description) {
		SimpleDateFormat format;
		if(date.length() > 7) {
			format = new SimpleDateFormat("yyyy-MM-dd");
		}else {
			format = new SimpleDateFormat("hh:mm a");
		}
		
		Date parsed;
		try {
			parsed = format.parse(date);
			schedule(parsed, description);
			return;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return;
	}
	public static void schedule(Date parsed, String description) {
		try {
			SchedulerFactory sf = new StdSchedulerFactory();
			Scheduler scheduler = sf.getScheduler();
 
			JobDetail job = JobBuilder.newJob(SimpleJob.class)
					.withIdentity("dummyJobName", "group1")
					.usingJobData("description",description)
					.build();
			
			
			SimpleTrigger simpletrigger = (SimpleTrigger) TriggerBuilder
					.newTrigger()
					.withIdentity("FourTimesTrigger", "group1")
					.startAt(parsed)
					.build();
			
					// startNow()
					//.withSchedule(SimpleScheduleBuilder.simpleSchedule()
					//.withIntervalInSeconds(10)
					//.withRepeatCount(4)).build();
							
 
			scheduler.start();
			try {
				scheduler.scheduleJob(job, simpletrigger);
				Thread.sleep(20000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			scheduler.shutdown();
 

        } catch (Exception e) {
        	e.printStackTrace();
        }
	}
}
