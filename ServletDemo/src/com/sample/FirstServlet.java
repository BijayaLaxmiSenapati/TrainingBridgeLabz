//life cycle of servlet and service method generic servlet practiced
package com.sample;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FirstServlet extends GenericServlet
{
	public FirstServlet() {
		System.out.println("Servlet object created");
	}
	 @Override
	public void init(ServletConfig config) throws ServletException {
		 System.out.println("Servlet object initialized");
	}
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String name=req.getParameter("nm");
		String place=req.getParameter("pl");
		PrintWriter out=res.getWriter();
		//out.println("welcome to "+place+" "+name);
		out.println("<html><body bgcolor='cyan'>"+"welcome "+name+" to "+place+"</body></html>");
		out.println("hey "+name);
		System.out.println("Service is executed");
	}
	@Override
	public void destroy() {
		System.out.println("Costly resources closed");
	}
}
