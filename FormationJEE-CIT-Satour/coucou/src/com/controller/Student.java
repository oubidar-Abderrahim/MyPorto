package com.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Student
 */
public class Student extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Student() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	    Enumeration<String> headers = request.getHeaderNames();
	    while(headers.hasMoreElements()){
	    	String header =  headers.nextElement();
	    	String value = request.getHeader(header); 
	    	response.getWriter().println(header+ " : " + value + "<br />");
	    }
		response.getWriter().println( 
				"<form method=\"post\">"
				+ "<input type=\"text\" name=\"email\" />"
				+ "<br />"
				+ "<input type=\"password\" name=\"pwd\" />"
				+ "<input type=\"submit\"/>"
				+ "</form>"
				);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		
		response.getWriter().println("Welcome : <hr />");
		response.getWriter().println("email: "+ email);
		response.getWriter().println("<br />");
		response.getWriter().println("password: "+ pwd);
	}

}
