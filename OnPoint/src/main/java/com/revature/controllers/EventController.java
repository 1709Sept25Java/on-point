package com.revature.controllers;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.revature.beans.*;
import com.revature.dao.EventsDao;
import com.revature.dao.UsersDao;
import com.revature.util.ScheduleTextMessage;

@Controller
public class EventController {
	@RequestMapping(value="/event", method = RequestMethod.GET)
	public ModelAndView showRegister(HttpServletRequest req, HttpServletResponse resp){
		ModelAndView mav = new ModelAndView("event");
		mav.addObject("event", new Events());
		return mav;
	}	
	@RequestMapping(value = "/eventProcess", method = RequestMethod.POST)
	public ModelAndView eventProcess(HttpServletRequest request, HttpServletResponse response,
	@ModelAttribute("event") Events event) {
		String event_date = event.getDate();
		String event_time = event.getTime();
		String location = event.getLocation();
		String description = event.getDescription();
		
		String date = event_date + " " + event_time;
		
		
		 ApplicationContext ac = new ClassPathXmlApplicationContext("beansORM.xml");
		 EventsDao ed = (EventsDao) ac.getBean("eventsDao");
		 Events e = (Events) ac.getBean("events");
			e.setU_id(1);
			e.setDate(event_date);
			e.setLocation(location);
			e.setDescription(description);
			e.setTime(event_time);
			ed.addEvent(e);
			ScheduleTextMessage.message(date, description);

	  ModelAndView mav = null;
	  mav = new ModelAndView("event");
	  return mav;
	}
	
	
}