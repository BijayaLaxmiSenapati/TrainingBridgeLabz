package com.bridgelabz.requestdispatcherbasic;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		//PrintWriter out= res.getWriter();
		//out.println("In FirstServlet");
		//System.out.println("In FirstServlet");
		/*RequestDispatcher rd=req.getRequestDispatcher("SecondServlet");
		rd.forward(req, res);*/
		res.sendRedirect("SecondServlet");
	}
}
