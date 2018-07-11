//doGet doPost and service method of http servlet practiced but could not do the same by annotation
package com.sample;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Add
 */
// @WebServlet("/Add")
public class Add extends HttpServlet {
	// private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	/*
	 * public void doGet(HttpServletRequest request, HttpServletResponse response)
	 * throws ServletException, IOException { // TODO Auto-generated method stub
	 * System.out.println(); System.out.println("In doGet()"); int a =
	 * Integer.parseInt(request.getParameter("t1")); int b =
	 * Integer.parseInt(request.getParameter("t2")); int c = a+b; PrintWriter out =
	 * response.getWriter();
	 * 
	 * out.println(c); }
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("In doPost()");
		int a = Integer.parseInt(request.getParameter("t1"));
		int b = Integer.parseInt(request.getParameter("t2"));
		int c = a + b;
		PrintWriter out = response.getWriter();

		out.println(c);
	}

	public void processRequest(HttpServletRequest request, HttpServletResponse response) {

	}
}
