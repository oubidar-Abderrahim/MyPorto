package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ThreadPoolExecutor;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.listener.AppAsyncListener;

@WebServlet(urlPatterns = "/async", asyncSupported = true, loadOnStartup = 1)
public class ServletAsync extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletAsync() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		/*
		 * RequestDispatcher rd = request.getRequestDispatcher("/index.html");
		 * out.println("isAsyncStarted : false"); rd.include(request, response);
		 * out.println("<br/>asynchronous task finished.");
		 */
		/*
		 * AsyncContext asyncContext = request.startAsync();
		 * asyncContext.setTimeout(0); ServletRequest servReq =
		 * asyncContext.getRequest();
		 * 
		 * boolean b = servReq.isAsyncStarted(); out.println("isAsyncStarted : "
		 * + b); asyncContext.dispatch("/index.html");
		 * out.println("<br/>asynchronous task finished.");
		 */

		/*
		 * AsyncContext asyncContext = request.startAsync();
		 * asyncContext.setTimeout(0); ServletRequest servReq =
		 * asyncContext.getRequest(); boolean b = servReq.isAsyncStarted();
		 * out.println("isAsyncStarted : " + b); asyncContext.complete();
		 * out.println("asynchronous task finished.");
		 */

		long startTime = System.currentTimeMillis();
		System.out.println("AsyncServlet Start::Name="
				+ Thread.currentThread().getName() + "::ID="
				+ Thread.currentThread().getId());

		request.setAttribute("org.apache.catalina.ASYNC_SUPPORTED", true);

		String time = request.getParameter("time");
		int secs = Integer.valueOf(time); // max 10 seconds
		if (secs > 10000)
			secs = 10000;

		AsyncContext asyncCtx = request.startAsync();
		asyncCtx.addListener(new AppAsyncListener());
		asyncCtx.setTimeout(9000);

		ThreadPoolExecutor executor = (ThreadPoolExecutor) request
				.getServletContext().getAttribute("executor");

		executor.execute(new AsyncRequestProcessor(asyncCtx, secs));
		long endTime = System.currentTimeMillis();
		System.out.println("AsyncServlet End::Name="
				+ Thread.currentThread().getName() + "::ID="
				+ Thread.currentThread().getId() + "::Time Taken="
				+ (endTime - startTime) + " ms.");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");

		response.getWriter().println("Welcome : <hr />");
		response.getWriter().println("email: " + email);
		response.getWriter().println("<br />");
		response.getWriter().println("password: " + pwd);
	}

}
