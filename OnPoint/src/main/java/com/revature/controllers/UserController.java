package com.revature.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.revature.beans.Events;
import com.revature.beans.Users;
import com.revature.dao.UsersDao;

@Controller
public class UserController {

	@RequestMapping(value="/users", method = RequestMethod.GET)
	public List<Users> showUser(HttpServletRequest req, HttpServletResponse resp){
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("beansORM.xml");
		UsersDao ud = (UsersDao) ac.getBean("usersDao");
		List<Users> users = ud.getAllUsers();
		return users;
		
		/*ModelAndView mav = new ModelAndView("user");
		mav.addObject("user", new Users());
		return mav;*/
	}
	
	@RequestMapping(value="/user", method = RequestMethod.GET)
	public ModelAndView showUsers(HttpServletRequest req, HttpServletResponse resp){
		ModelAndView mav = new ModelAndView("user");
		mav.addObject("user", new Users());
		return mav;
	}
}
