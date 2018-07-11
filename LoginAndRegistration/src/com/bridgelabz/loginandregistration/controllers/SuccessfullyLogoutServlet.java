package com.bridgelabz.loginandregistration.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SuccessfullyLogoutServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if (req.getParameter("Logout") != null) {
			session.invalidate();
			RequestDispatcher dispatcher = req.getRequestDispatcher("HomePage.jsp");
			dispatcher.forward(req, resp);
		}
	}
}
