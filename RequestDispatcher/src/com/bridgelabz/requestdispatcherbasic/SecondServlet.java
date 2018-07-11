package com.bridgelabz.requestdispatcherbasic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		//System.out.println("In SecondServlet");
		PrintWriter out= res.getWriter();
		out.println("In SecondServlet");
	}
}
