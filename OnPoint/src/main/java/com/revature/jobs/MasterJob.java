package com.revature.jobs;

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
		while (!Schedule.getSchedule().isEmpty()) {
			Event e = Schedule.getSchedule().pop();
			if (e.getType()=="single") {
				System.out.println(e.toString());
				ScheduleTextMessage.singleMessage(e.getDate(), e.getDescription());
			}
			else {
				ScheduleTextMessage.recurringMessage(e.getDate(), e.getDescription());
			}
		}
	}
	
	
	
	/*
	@Scheduled(fixedRate=5000)
	public void hello() {
		System.out.println("hello");
		
	}
	*/

}
