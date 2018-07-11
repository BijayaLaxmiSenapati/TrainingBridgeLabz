package com.bridgelabz.loginandregistration.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgelabz.loginandregistration.models.TraineeBean;
import com.bridgelabz.loginandregistration.repositories.DataAccessObject;

public class SignUpServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DataAccessObject dao = new DataAccessObject();
		HttpSession session = req.getSession(true);
		session.setMaxInactiveInterval(60);
		TraineeBean bean = new TraineeBean();
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String fullName = fname + " " + lname;
		bean.setFullName(fullName);
		Long mobile = Long.parseLong(req.getParameter("mobile"));
		bean.setMobile(mobile);
		String email = req.getParameter("email");
		bean.setEmail(email);
		String password = req.getParameter("password");
		bean.setPassword(password);

		dao.addTraineeBeanIntoDatabase(bean);

		session.setAttribute("message", "hey " + fullName + ", you are successfully registered");
		resp.sendRedirect("successfullyRegisteredServlet");

	}
}
