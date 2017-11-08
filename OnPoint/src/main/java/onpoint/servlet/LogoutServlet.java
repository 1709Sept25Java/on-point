package onpoint.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class LogoutServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
<<<<<<< HEAD
		resp.setContentType("text/html");
		req.getRequestDispatcher("login").include(req, resp);
=======
>>>>>>> 5caa136350f05e0b6e2c395a86a1f766e42499fb
		HttpSession session = req.getSession(false);
		if (session != null){
			session.removeAttribute("username");
			session.removeAttribute("password");
			session.invalidate();
		}
		
<<<<<<< HEAD
=======
		resp.sendRedirect("login");
		
>>>>>>> 5caa136350f05e0b6e2c395a86a1f766e42499fb
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
<<<<<<< HEAD
		resp.sendRedirect("login");
	}
	
}
=======
	}
	
}
>>>>>>> 5caa136350f05e0b6e2c395a86a1f766e42499fb
