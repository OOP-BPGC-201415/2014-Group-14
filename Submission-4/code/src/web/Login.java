package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import actors.Person;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Person p = AuthHelper.validate(request.getParameter("user"),
					request.getParameter("pass"));
			Session session = SessionHelper.newSession(p.getId(),
					p.getDesignation());
			Cookie c = new Cookie("session", session.hash);
			c.setMaxAge(60 * 60);
			response.addCookie(c);
			String next = request.getParameter("redirect");
			next = next == null ? "index.jsp" : next;
			response.sendRedirect(next);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("failed.jsp");
		}
	}
}
