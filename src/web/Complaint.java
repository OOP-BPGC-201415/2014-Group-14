package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Complaint
 */
@WebServlet("/Complaint")
public class Complaint extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Complaint() {
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
		String from = request.getParameter("from");
		String text = request.getParameter("text");
		response.setContentType("text/html");
		if (backend.Complaint.addComplaint(from, text)) {
			response.getOutputStream().write("Added! <a href='javascript:void(0)' onclick='history.back();'>Back</a>".getBytes());
		} else
			response.getOutputStream().write("Failed! <a href='javascript:void(0)' onclick='history.back();'>Back</a>".getBytes());
	}

}
