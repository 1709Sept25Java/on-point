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
/*
	@Scheduled(fixedRate=5000)
	public void scheduleEvent(){
		Schedule schedEvents = new Schedule();
		while (!schedEvents.isEmpty()) {
			Event e = schedEvents.pop();
			if (e.getType()=="single") {
				ScheduleTextMessage.message(e.getDate(), e.getDescription());

			}
			else {
				//recurrent job
			}
			
		}
	}
	*/
	@Scheduled(fixedRate=1000)
	public void hello() {
		System.out.println("hello");
	}

}
