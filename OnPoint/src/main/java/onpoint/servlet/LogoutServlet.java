package onpoint.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class LogoutServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		req.getRequestDispatcher("login").include(req, resp);
		HttpSession session = req.getSession(false);
		if (session != null){
			session.removeAttribute("username");
			session.removeAttribute("password");
			session.invalidate();
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("login");
	}
	
}
