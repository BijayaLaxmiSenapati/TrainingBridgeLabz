package com.bridgelabz.jdbcpractice.connectionpooling;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;

public class DataSourceTest {
	public static void main(String[] args) throws SQLException {
		//testDBCPDataSource("mysql");
		testDataSource("mysql");
		System.out.println("***************");
		//testDataSource("oracle");
	}

	@SuppressWarnings({ "null", "unused" })
	private static void testDataSource(String dbtype) {
		DataSource ds = null;
		if ("mysql".equals(dbtype)) {
			ds = MyDataSourceFactory.getMySQLDataSourse();
		} else if ("oracle".equals(dbtype)) {
			ds=MyDataSourceFactory.getOracleDataSource();
		} else {
			System.out.println("Invalid db type");
			return;
		}
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			rs = st.executeQuery("select * from Emp_Information.Employee");
			while (rs.next()) {
				System.out.println(rs.getInt("empid") + " " + rs.getString("empname"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void testDBCPDataSource(String dbType) {
		DataSource ds = MyDataSourceFactory.getDataSource(dbType);

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery("select empid, name from Emp_Information.Employee");
			while (rs.next()) {
				System.out.println("Employee ID=" + rs.getInt("empid") + ", Name=" + rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
