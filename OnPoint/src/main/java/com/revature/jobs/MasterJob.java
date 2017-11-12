package com.revature.jobs;

import java.util.Date;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

import com.revature.beans.Events;
import com.revature.dao.EventsDao;
import com.revature.util.Event;
import com.revature.util.Schedule;
import com.revature.util.ScheduleTextMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;


public class MasterJob {
	
	@Scheduled(fixedRate=3000)
	public void scheduleEvents(){
		if (!Schedule.getSchedule().isEmpty()) {
			Date now = new Date();
			
			Event e = Schedule.getSchedule().currentEvent(now);
			
			if (e != null) {
				if (e.getType() == "single") {
					System.out.println(e.toString());
					ScheduleTextMessage.singleMessage(e.getDate(), e.getDescription());
				}
				else {
					ScheduleTextMessage.recurringMessage(e.getDate(), e.getDescription());
				}
			}
			
			//if (e.getType()=="single") {
//				System.out.println(e.toString());
//				ScheduleTextMessage.singleMessage(e.getDate(), e.getDescription());
//			}
//			else {
//				ScheduleTextMessage.recurringMessage(e.getDate(), e.getDescription());
//			}
		}
	}
	/* 
	 * Populate with recurrent events
	 * Query database for all events no matter the ID
	 * but only get RECURRENT events
	 */
    @Scheduled(cron = "0 0 0 * * *") // everyday at midnight
    public void retrieveRecurrentEvents() {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("beansORM.xml");
		  EventsDao ed = (EventsDao) ac.getBean("eventsDao");
		 // List<Events> el = ed;
		 //Add to arraylist 
    }
	
	/*
	@Scheduled(fixedRate=5000)
	public void hello() {
		System.out.println("hello");
		
	}
	*/

}
