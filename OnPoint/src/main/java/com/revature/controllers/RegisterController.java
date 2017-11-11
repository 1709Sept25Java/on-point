package com.revature.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

import com.revature.beans.Register;
import com.revature.beans.Users;
import com.revature.dao.UsersDao;

@Controller
public class RegisterController {
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public ModelAndView showRegister(HttpServletRequest req, HttpServletResponse resp){
		ModelAndView mav = new ModelAndView("register");
		mav.addObject("register", new Register());
		return mav;
	}	
	
	@RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
	public String registerProcess(HttpServletRequest request, HttpServletResponse response,
	@ModelAttribute("register") Register register){
		String username = register.getUsername();
		String password = register.getPassword();
		String email = register.getEmail();
		String phone = register.getNumber();
		 ApplicationContext ac = new ClassPathXmlApplicationContext("beansORM.xml");
		  
		  UsersDao ud = (UsersDao) ac.getBean("usersDao");
		  Users u = (Users) ac.getBean("users");
			u.setUsername(username);
			u.setPassword(password);
			u.setUser_type("USER");
			u.setEmail(email);
			u.setPhone_number(phone);
			ud.addUser(u);
			return "redirect:/";

			
		
	}
}