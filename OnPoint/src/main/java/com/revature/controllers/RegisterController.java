package com.revature.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.revature.beans.Register;

@Controller
public class RegisterController {
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public ModelAndView showRegister(HttpServletRequest req, HttpServletResponse resp){
		ModelAndView mav = new ModelAndView("register");
		mav.addObject("register", new Register());
		return mav;
	}	
	
	@RequestMapping(value = "/homepage", method = RequestMethod.POST)
	public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
	@ModelAttribute("register") Register register){
	  ModelAndView mav = null;
	  mav = new ModelAndView("home");
	  return mav;
	}
}