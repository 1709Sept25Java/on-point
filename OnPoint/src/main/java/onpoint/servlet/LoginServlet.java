package onpoint.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		resp.setContentType("text/html");
		req.getRequestDispatcher("index.html").include(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		resp.setContentType("text/html");
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		session.setAttribute("username", username);
		session.setAttribute("password", password);
		
		resp.sendRedirect(req.getContextPath() 
				+ "/homepage.html");
	}
<<<<<<< HEAD
}
=======
}
>>>>>>> 5caa136350f05e0b6e2c395a86a1f766e42499fb