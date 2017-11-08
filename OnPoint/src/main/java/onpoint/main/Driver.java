package onpoint.main;

import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import onpoint.beans.*;
import onpoint.dao.*;

public class Driver {

	public static void main(String[] args) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		//EventsDao ed = (EventsDao) ac.getBean("eventsDao");
		InviteesDao id = (InviteesDao) ac.getBean("inviteesDao");
		//UsersDao ud = (UsersDao) ac.getBean("usersDao");
		//WeatherDao wd = (WeatherDao) ac.getBean("weatherDao");
		
		/*Users u = (Users) ac.getBean("users");
		u.setUsername("janedoe22");
		u.setPassword("doe22");
		u.setUser_type("USER");
		u.setEmail("janedoe22@gmail.com");
		u.setPhone_number("(555)555-5555");
		ud.addUser(u);*/
		
		/*Users u = (Users) ac.getBean("users");
		u.setUsername("admin");
		u.setPassword("password");
		u.setUser_type("ADMIN");
		u.setEmail("admin123@gmail.com");
		u.setPhone_number("(555)555-1234");
		ud.addUser(u);*/
		
		/*Events e = (Events) ac.getBean("events");
		e.setU_id(1);
		e.setDate("11/8/17");
		e.setLocation("CUNY");
		e.setTime("9:00AM");
		ed.addEvent(e);*/
		
		/*Weather w = (Weather) ac.getBean("weather");
		w.setU_id(1);
		w.setMaxTemp(75);
		w.setMinTemp(60);
		w.setRain(40);
		w.setSnow(40);
		wd.addWeather(w);*/
		
		/*Invitees i = (Invitees) ac.getBean("invitees");
		i.setE_id(1);
		i.setFirstname("Mary");
		i.setLastname("Poppins");
		i.setPhone_number("(555)555-3333");
		id.addInvitee(i);*/
		
		List<Invitees> il = id.namedQueryGetInviteesByEventId(1);
		Iterator<Invitees> itr = il.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next().toString());
		}
	}
}
