package com.controller;

import java.io.IOException;
import java.net.URLPermission;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/teacher")
//@WebServlet(urlPatterns = {"/teacher", "/teacher.asp"})
//@WebServlet(urlPatterns = {"/teacher", "/teacher.asp"}, name = "TeacherServletName")

public class Teacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Teacher() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 RequestDispatcher rd = request.getRequestDispatcher("/index.html");
		RequestDispatcher rd = request.getRequestDispatcher("/student.html");
		//RequestDispatcher rd = request.getRequestDispatcher("Student");
		
		response.setContentType("text/html");
		response.getWriter().println("teacher");
		
		rd.forward(request, response);
		//rd.include(request, response);
		 
		 */
		
		//response.sendRedirect("/coucou/student.html");
		//response.sendError( HttpServletResponse.SC_NOT_FOUND, "NOT FOUND");

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
