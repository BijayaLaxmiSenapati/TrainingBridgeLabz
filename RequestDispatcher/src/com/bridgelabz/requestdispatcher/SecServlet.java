package com.bridgelabz.requestdispatcher;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*String name = (String) req.getAttribute("pnm");
		int quantity = Integer.parseInt((String) req.getAttribute("pqt"));*/
		String name=req.getParameter("pname");
		int quantity=Integer.parseInt(req.getParameter("pquantity"));
		
		Double price = 400.0;
		Double totalPrice = price * quantity;
		PrintWriter out=resp.getWriter();
		out.println("<html><body  bgcolor='yellow'>"+"Product purchased is: "+name+"<br>"+"Total amount is: "+totalPrice+"</body></html>");
		out.close();
		System.out.println("before close");
		//out.flush();
		
		System.out.println("after close");
		Connection con=null;
		PreparedStatement pst=null;
		String insertQuery="insert into Store.items values(?,?,?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root & password=root");
			
			pst=con.prepareStatement(insertQuery);
			pst.setString(1, name);
			System.out.println("............");
			pst.setInt(2, quantity);
			System.out.println("..........................");
			pst.setDouble(3, totalPrice);
			System.out.println(".................................................");

			pst.executeUpdate();
			} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		
	}
}
