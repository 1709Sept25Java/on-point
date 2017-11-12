package com.revature.jobs;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

import com.revature.util.Event;
import com.revature.util.Schedule;
import com.revature.util.ScheduleTextMessage;

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
	@Scheduled(fixedRate=5000)
	public void hello() {
		System.out.println("hello");
		
	}
	*/

}
