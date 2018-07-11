package com.bridgelabz.loginandregistration.controllers;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.bridgelabz.loginandregistration.listeners.MyHttpSessionListener;
import com.bridgelabz.loginandregistration.models.TraineeBean;
import com.bridgelabz.loginandregistration.repositories.DataAccessObject;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		DataAccessObject dao = new DataAccessObject();

		ServletContext context = req.getServletContext();
		MyHttpSessionListener.totalUserVisited++;
		context.setAttribute("totalUserVisited", MyHttpSessionListener.totalUserVisited);

		TraineeBean traineebean = new TraineeBean();
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		traineebean.setEmail(username);
		traineebean.setPassword(password);
		TraineeBean traineebean2 = dao.getTraineeBeanByUserName(username);
		if (traineebean2 != null) {
			if (!traineebean2.getPassword().equals(password)) {
				resp.sendRedirect("unsuccessfulLoginServlet");
			} else {
				int serialNumber = traineebean2.getSerialNum();
				String fullName = traineebean2.getFullName();
				Long mobileNumber = traineebean2.getMobile();
				session.setAttribute("message", "you are successfully logged in");
				session.setAttribute("serialNum", serialNumber);
				session.setAttribute("fullName", fullName);
				//System.out.println(mobileNumber);
				session.setAttribute("mobile", mobileNumber);
				session.setAttribute("username", username);

				resp.sendRedirect("SuccessfulLoginServlet");
			}
		} else if (traineebean2 == null) {
			resp.sendRedirect("unsuccessfulLoginServlet");
		}

	}
}
