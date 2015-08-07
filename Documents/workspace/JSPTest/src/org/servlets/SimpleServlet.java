package org.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SimpleServlet
 */
@WebServlet(description = "Simple servlet", urlPatterns = { "/SimpleServlet" }, initParams={@WebInitParam(name="defaultUser",value="John Doe")})
public class SimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Servlet is only created once so scalability is easy to maintain.
		response.setContentType("text/html");
		System.out.println("SimpleServlet: called.");
		
		//response.getWriter().print("Simple Servlet: Hello - on the web page.");
		PrintWriter writer = response.getWriter();
		String userName = request.getParameter("userName");
		
		HttpSession session = request.getSession();
		//session: when using the same browser the servlet will be available
		ServletContext context = request.getServletContext();
		//session: available across all browser and all users.
		
		if (userName != "" && userName != null) {
			session.setAttribute("savedUserName", userName);
			context.setAttribute("savedUserName", userName);
		}

		writer.println("Request parameter has username as " + userName);
		writer.println("<br>Session parameter has username as " + (String) session.getAttribute("savedUserName"));
		writer.println("<br>Context parameter has username as " + (String) context.getAttribute("savedUserName"));
		writer.println("<br>Init parameter has default username as " + getServletConfig().getInitParameter("defaultUser"));
		
	}

}
