package org.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class XmlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//		String userName= request.getParameter("userName");
//		out.println("XML servlet called in html!");
//		out.println("Hello from the GET method!" + userName + "!");
//		System.out.println("XMLservlet: called.");	
//	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("userName");
		String fullName = request.getParameter("fullName");
		String profession = request.getParameter("profession");
		//String location = request.getParameter("location");
		String[] location = request.getParameterValues("location");
		out.println("Hello from the POST method " + userName + "!<br> " + "We know your full name is " + fullName + "." );
		out.println("<br>You are a " + profession + ".");
		out.println("<br>You live in " + location.length + " places.");
		for (int i=0; i<location.length; i++){
		out.println("<br>" + location[i]);
		}
		System.out.println("XMLservlet: called.");
		
	}
}
