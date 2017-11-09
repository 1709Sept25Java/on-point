package com.revature.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.revature.beans.Login;

@Controller
public class LoginController {
	@Autowired
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public ModelAndView showLogin(HttpServletRequest req, HttpServletResponse resp){
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("login", new Login());
		return mav;
	}	

	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
	@ModelAttribute("login") Login login) {
	  ModelAndView mav = null;
	  mav = new ModelAndView("home");
	  return mav;
	}
}