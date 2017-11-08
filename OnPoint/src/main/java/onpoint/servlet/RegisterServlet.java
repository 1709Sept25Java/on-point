package onpoint.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		resp.setContentType("text/html");
		req.getRequestDispatcher("register.html").include(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		resp.setContentType("text/html");
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String phone_number = req.getParameter("phone_number");
		
<<<<<<< HEAD
		resp.sendRedirect(req.getContextPath() 
				+ "/homepage.html");
	}
}
=======
		System.out.println(username);
		
		resp.sendRedirect(req.getContextPath() 
				+ "/homepage.html");
	}
}
>>>>>>> 5caa136350f05e0b6e2c395a86a1f766e42499fb