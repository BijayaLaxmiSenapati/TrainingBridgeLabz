package com.bridgelabz.loginandregistration.filters;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgelabz.loginandregistration.models.TraineeBean;
import com.bridgelabz.loginandregistration.repositories.DataAccessObject;

public class ValidationFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String email = req.getParameter("email");
		TraineeBean traineeBean = new TraineeBean();
		traineeBean.setEmail(email);
		DataAccessObject dao = new DataAccessObject();
		boolean result = dao.checkWhetherEmailPresentOrNot(traineeBean);
		if (result) {
			HttpSession session = req.getSession(true);
			session.setAttribute("message", "the given email id is already registered. Give a valid email id");
			resp.sendRedirect("UnsuccessfulRegisterServlet");
		} else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
