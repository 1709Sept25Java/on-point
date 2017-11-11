package com.revature.controllers;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.revature.beans.*;

@Controller
public class EventController {
	@RequestMapping(value="/event", method = RequestMethod.GET)
	public ModelAndView showRegister(HttpServletRequest req, HttpServletResponse resp){
		ModelAndView mav = new ModelAndView("event");
		mav.addObject("event", new Event());
		return mav;
	}	
	@RequestMapping(value = "/eventProcess", method = RequestMethod.POST)
	public ModelAndView eventProcess(HttpServletRequest request, HttpServletResponse response,
	@ModelAttribute("event") Event event) {
	  ModelAndView mav = null;
	  mav = new ModelAndView("event");
	  return mav;
	}
	
	
}
