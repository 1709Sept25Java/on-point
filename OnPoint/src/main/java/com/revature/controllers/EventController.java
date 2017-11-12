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
import com.revature.util.Event;
import com.revature.util.Schedule;
import com.revature.util.ScheduleTextMessage;

@Controller
public class EventController {
	@RequestMapping(value="/event", method = RequestMethod.GET)
	public ModelAndView showEvent(HttpServletRequest req, HttpServletResponse resp){
		ModelAndView mav = new ModelAndView("event");
		mav.addObject("event", new Events());
		return mav;
	}	
	@RequestMapping(value = "/eventProcess", method = RequestMethod.POST)
	public ModelAndView eventProcess(HttpServletRequest request, HttpServletResponse response,
	@ModelAttribute("event") Events event) {
		HttpSession session = request.getSession();
		String phoneNumber = (String) session.getAttribute("phone");
		String phone = "+1" + phoneNumber;
		String user_id = (String) request.getSession(false).getAttribute("id");
		String event_date = event.getDate();
		String event_time = event.getTime();
		String location = event.getLocation();
		String description = event.getDescription();
		
		String date = event_date +" "+ event_time;
		
		System.out.println(user_id + " " + phone);
		 ApplicationContext ac = new ClassPathXmlApplicationContext("beansORM.xml");
		 EventsDao ed = (EventsDao) ac.getBean("eventsDao");
		 Events e = (Events) ac.getBean("events");
			e.setU_id(1);
			e.setDate(event_date);
			e.setLocation(location);
			e.setDescription(description);
			e.setTime(event_time);
			ed.addEvent(e);
		Event singleEvent = new Event(date, description, "single", phone);
		
		Schedule.getSchedule().add(singleEvent);
		
//		ScheduleTextMessage.singleMessage(date, description);
		System.out.println(date);
		
	  ModelAndView mav = null;
	  mav = new ModelAndView("home");
	  return mav;
	}
	
	@RequestMapping(value="/recurring", method = RequestMethod.GET)
	public ModelAndView showRecurring(HttpServletRequest req, HttpServletResponse resp){
		ModelAndView mav = new ModelAndView("recurring");
		mav.addObject("recurring", new Recurring());
		return mav;
	}	
	
	@RequestMapping(value = "/recurringProcess", method = RequestMethod.POST)
	public ModelAndView recurringProcess(HttpServletRequest request, HttpServletResponse response,
	@ModelAttribute("recurring") Recurring recurring) {
		String event_time = recurring.getTime();
		String description = recurring.getDescription();
		HttpSession session = request.getSession();
		String phoneNumber = (String) session.getAttribute("phone");
		String phone = "+1" + phoneNumber;
		String user_id = (String) session.getAttribute("id");
		

		 ApplicationContext ac = new ClassPathXmlApplicationContext("beansORM.xml");
		 EventsDao ed = (EventsDao) ac.getBean("eventsDao");
		Events e = (Events) ac.getBean("events");
			e.setU_id(1);
			e.setDescription(description);
			e.setTime(event_time);
			ed.addEvent(e);
		Event recurringEvent = new Event(event_time, description, "recurring", phone);	
		Schedule.getSchedule().add(recurringEvent);
		
		//ScheduleTextMessage.message(event_time, description);

	  ModelAndView mav = null;
	  mav = new ModelAndView("home");
	  return mav;
	}
	
	@RequestMapping(value="/delete", method = RequestMethod.GET)
	public ModelAndView showDelete(HttpServletRequest req, HttpServletResponse resp){
		ModelAndView mav = new ModelAndView("delete");
		mav.addObject("delete", new Delete());
		return mav;
	}	
	
	@RequestMapping(value = "/deleteProcess", method = RequestMethod.POST)
	public ModelAndView recurringDelete(HttpServletRequest request, HttpServletResponse response,
	@ModelAttribute("delete") Delete delete) {
		int id = delete.getId();
		
		 ApplicationContext ac = new ClassPathXmlApplicationContext("beansORM.xml");
		 EventsDao ed = (EventsDao) ac.getBean("eventsDao");
		 Events e = (Events) ac.getBean("events");
		 e.setId(id);
		 ed.deleteEvent(e);

	  ModelAndView mav = null;
	  mav = new ModelAndView("home");
	  return mav;
	}
	
}