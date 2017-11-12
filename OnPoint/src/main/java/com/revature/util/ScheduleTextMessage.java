package com.revature.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.scheduling.support.SimpleTriggerContext;

public class ScheduleTextMessage {

	public static void singleMessage(String date, String description) {
		SimpleDateFormat format;
		format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		format.setTimeZone(TimeZone.getTimeZone("UTC"));

		Date parsed;
		try {
			parsed = format.parse(date);
			System.out.println("parsed " + parsed.getDate());
			schedule(parsed, description);
			return;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return;
	}
	
	public static void recurringMessage(String date, String description) {
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
			Date now = new Date();
			System.out.println("Schedule time " + parsed);
			System.out.println("Now " + now.toString());
			SchedulerFactory sf = new StdSchedulerFactory();
			Scheduler scheduler = sf.getScheduler();
 
			JobDetail job = JobBuilder.newJob(SimpleJob.class)
					.withIdentity("TextJob", "group1")
					.usingJobData("description",description+" "+parsed)
					.build();
			
			System.out.println("Parsed: " + parsed);
			Calendar nowTime = Calendar.getInstance();
			nowTime.add(Calendar.SECOND, -10);
			Date startTime = nowTime.getTime();
			SimpleTrigger simpletrigger = (SimpleTrigger) TriggerBuilder
					.newTrigger()
					.withIdentity("TextTrigger", "group1")
					.startAt(startTime)
					.build();
			try {
				scheduler.start();

				scheduler.scheduleJob(job, simpletrigger);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			scheduler.shutdown();
 

        } catch (Exception e) {
        	e.printStackTrace();
        }
	}
}
