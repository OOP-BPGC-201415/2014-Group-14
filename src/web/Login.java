package web;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import backend.DatabaseManager;

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
			String session = new BigInteger(130, new SecureRandom())
					.toString(32);
			Connection dbConn = DatabaseManager.getConnection();
			String hash = HashGenerator.getHash(request.getParameter("user"),
					request.getParameter("password"));
			PreparedStatement s = dbConn
					.prepareStatement("SELECT * FROM Login WHERE hash=?;");
			s.setString(1, hash);
			s.execute();
			ResultSet rs = s.getResultSet();
			if (!rs.first()) {
				response.sendRedirect("failed.jsp");
				return;
			}
			int desig = rs.getInt("User_Designation"), id = rs
					.getInt("User_Id");
			s = dbConn
					.prepareStatement("INSERT INTO Sessions (hash, designation, id) values(?, ?, ?)");
			s.setString(1, session);
			s.setInt(2, desig);
			s.setInt(3, id);
			s.execute();
			response.addCookie(new Cookie("session", session));
			String next = request.getParameter("redirect");
			next = next == null ? "/test.jsp" : next;
			if (!next.startsWith("/"))
				next = "/" + next;
			response.sendRedirect("test.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
