package com.revature.main;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import static org.quartz.JobBuilder.*;

import com.revature.dao.InviteesDao;
import com.revature.util.SimpleJob;
import com.revature.util.TextMessage;
import com.revature.beans.*;
import com.revature.dao.*;
import org.quartz.JobDetail;

public class Driver {

	public static void main(String[] args) {
		/*
		JobDetail job = JobBuilder.newJob(SimpleJob.class)
				.withIdentity("dummyOn.Job", "group1")
				.build();
		Trigger trigger = TriggerBuilder
				.newTrigger()
				.withIdentity("dummyOn.Job", "group1")
				.withSchedule(
						SimpleScheduleBuilder.simpleSchedule()
						.withIntervalInSeconds(5).repeatForever()).build();
		
		Scheduler scheduler;
		try {
			scheduler = new StdSchedulerFactory().getScheduler();
			scheduler.start();
			scheduler.scheduleJob(job, trigger);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		*/
		/*JobDetail job = JobBuilder.newJob(SimpleJob.class) 
				.withIdentity("dummyJobName", "group1").build();
		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("dummyJobName").withSchedule(CronScheduleBuilder.cronSchedule("0 0/1 * 1/1 * ? *")).build();
    	Scheduler scheduler;
		try {
			scheduler = new StdSchedulerFactory().getScheduler();
			scheduler.start();
	    	scheduler.scheduleJob(job, trigger);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	*/
		
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 50);
        calendar.set(Calendar.HOUR, 3);
        calendar.set(Calendar.AM_PM, Calendar.PM);
        calendar.set(Calendar.MONTH, Calendar.NOVEMBER);
        calendar.set(Calendar.DAY_OF_MONTH, 10);
        calendar.set(Calendar.YEAR, 2017);
		/*
        try {
			SchedulerFactory sf = new StdSchedulerFactory();
			Scheduler scheduler = sf.getScheduler();
 
			JobDetail job = JobBuilder.newJob(SimpleJob.class)
					.withIdentity("dummyJobName", "group1").build();
 
 
			// run 10 seconds only 4 times infinite loop
			
			SimpleTrigger simpletrigger = (SimpleTrigger) TriggerBuilder
					.newTrigger()
					.withIdentity("FourTimesTrigger", "group1")
					.startAt(calendar.getTime()).build();
					// startNow()
					//.withSchedule(SimpleScheduleBuilder.simpleSchedule()
					//.withIntervalInSeconds(10)
					//.withRepeatCount(4)).build();
							
 
			scheduler.start();
			scheduler.scheduleJob(job, simpletrigger);
 
			scheduler.shutdown();
 

        } catch (Exception e) {
        	e.printStackTrace();
        }
        
        */
		//TextMessage.sendTextNotification("+", "blahuihui");
        
		TextMessage.sendTextNotificationWithImage("+19177421581", "cupcake", "http://food.fnr.sndimg.com/content/dam/images/food/fullset/2014/1/14/0/FN_Cupcakes-App-Go-To-Vanilla-Cupcake_s4x3.jpg.rend.hgtvcom.616.462.suffix/1390332048162.jpeg");
		//ApplicationContext ac = new ClassPathXmlApplicationContext("beansORM.xml");
		//EventsDao ed = (EventsDao) ac.getBean("eventsDao");
		//InviteesDao id = (InviteesDao) ac.getBean("inviteesDao");
		//UsersDao ud = (UsersDao) ac.getBean("usersDao");
		//WeatherDao wd = (WeatherDao) ac.getBean("weatherDao");
		
		/*Users u = (Users) ac.getBean("users");
		u.setUsername("janedoe22");
		u.setPassword("doe22");
		u.setUser_type("USER");
		u.setEmail("janedoe22@gmail.com");
		u.setPhone_number("(555)555-5555");
		ud.addUser(u);*/
		
		/*Users u = (Users) ac.getBean("users");
		u.setUsername("admin");
		u.setPassword("password");
		u.setUser_type("ADMIN");
		u.setEmail("admin123@gmail.com");
		u.setPhone_number("(555)555-1234");
		ud.addUser(u);*/
		
		/*Events e = (Events) ac.getBean("events");
		e.setU_id(1);
		e.setDate("11/8/17");
		e.setLocation("CUNY");
		e.setTime("9:00AM");
		ed.addEvent(e);*/
		
		/*Weather w = (Weather) ac.getBean("weather");
		w.setU_id(1);
		w.setMaxTemp(75);
		w.setMinTemp(60);
		w.setRain(40);
		w.setSnow(40);
		wd.addWeather(w);*/
		
		/*Invitees i = (Invitees) ac.getBean("invitees");
		i.setE_id(1);
		i.setFirstname("Mary");
		i.setLastname("Poppins");
		i.setPhone_number("(555)555-3333");
		id.addInvitee(i);*/
		
//		List<Invitees> il = id.namedQueryGetInviteesByEventId(1);
//		Iterator<Invitees> itr = il.iterator();
//		while(itr.hasNext()) {
//			System.out.println(itr.next().toString());
//		}
	}
}
