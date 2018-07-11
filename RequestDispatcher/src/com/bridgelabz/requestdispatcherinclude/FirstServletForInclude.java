package com.bridgelabz.requestdispatcherinclude;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServletForInclude extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("In FirServlet");
		String productName=req.getParameter("pname");
		String productQuantity=req.getParameter("pquantity");
		req.setAttribute("pnm", productName);
		req.setAttribute("pqt", productQuantity);
		RequestDispatcher rd=req.getRequestDispatcher("sServlet");//then add url of SecServlet
		rd.include(req, resp);
		req.getAttribute("total");
		PrintWriter out=resp.getWriter();
		out.println("<html><body  bgcolor='yellow'>"+"Product purchased is: "+productName+"<br>"+"Total amount is: "+productQuantity+"</body></html>");
		out.close();
		//out.flush();

	}
}
