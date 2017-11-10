package com.revature.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.revature.beans.Login;
import com.revature.dao.UsersDao;

@Controller
public class LoginController {
	
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
	  String username = login.getUsername();
	  String password = login.getPassword();
	  System.out.println(username);
	  System.out.println(password);
	  ApplicationContext ac = new ClassPathXmlApplicationContext("beansORM.xml");
	  UsersDao ud = (UsersDao) ac.getBean("usersDao");

	  if(ud.namedQueryisValidUsername(username)) {
		  if(ud.namedQueryisValidPassword(username, password)) {
			  mav = new ModelAndView("home");
		  }else {
			  mav = new ModelAndView("login");
			  mav.addObject("message", "**Invalid Password**");
		  }
	  }else {
		  mav = new ModelAndView("login");
		  mav.addObject("message", "**Invalid Username**");
	  }
	  return mav;
	}
}