package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.UserBean;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		RequestDispatcher rd = request.getRequestDispatcher("/login.html");
		//RequestDispatcher rd = request.getRequestDispatcher("User");
		/*
		RequestDispatcher rd = request.getRequestDispatcher("/User.php");
		
		*/
		response.setContentType("text/html");
		//out.println("Before");
		rd.include(request, response);
		//out.println("After");
		
		
		
		//response.sendRedirect("/coucou/User.php");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		String username = request.getParameter("username");
		String pwd = request.getParameter("password");

		if("admin".equals(username) && "admin".equals(pwd) ){
			HttpSession session = request.getSession();
			UserBean userBean = new UserBean(1, "admin", "admin");
			session.setAttribute("user", userBean );
			
			response.sendRedirect("/coucou/profile.php");
			//7FFDC96B3003896BE1F518597B7FBCB7
		}else{
			//response.sendError(HttpServletResponse.SC_FORBIDDEN, "tu nes pas autorise");
			out.println("User or password are invalide!");
			doGet(request, response);
		}
	}

}
