package com.bridgelabz.requestdispatcher;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("In FirServlet");
		String productName=req.getParameter("pname");
		String productQuantity=req.getParameter("pquantity");
		/*req.setAttribute("pnm", productName);
		req.setAttribute("pqt", productQuantity);*/
		RequestDispatcher rd=req.getRequestDispatcher("sServlet");//then add url of SecServlet
		rd.forward(req, resp);

	}
}
