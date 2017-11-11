package com.revature.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Login;
import com.revature.beans.Users;
import com.revature.dao.UsersDao;

@Controller
@Scope("session")
public class LoginController {
	
	public static Users user = new Users();
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public ModelAndView showLogin(HttpServletRequest req, HttpServletResponse resp){
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("login", new Login());
		return mav;
	}	

	@RequestMapping(value = "/home")
	public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
	@ModelAttribute("login") Login login) {
	  ModelAndView mav = null;
	  String username = login.getUsername();
	  String password = login.getPassword();
	  ApplicationContext ac = new ClassPathXmlApplicationContext("beansORM.xml");
	  
	  UsersDao ud = (UsersDao) ac.getBean("usersDao");
	  user = ud.namedQueryGetUserByUsername(username);
	  String type = user.getUser_type();
	  
	  if(ud.namedQueryisValidUsername(username)) {
		  if(ud.namedQueryisValidPassword(username, password)) {
			  if(type.equals("USER")) {
				  mav = new ModelAndView("home");
			  }else {
				  mav = new ModelAndView("admin");
			  }
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
	
	
	@RequestMapping(value="/user")
	public void saveUser(HttpSession session) {
		session.setAttribute("id", user.getId());
		session.setAttribute("role", user.getUser_type());
		session.setAttribute("latitude", "");
		session.setAttribute("longitude", "");
	}
}