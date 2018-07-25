package com.bridgelabz.loginandregistration.repositories;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import javax.sql.DataSource;
import com.bridgelabz.loginandregistration.models.TraineeBean;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DataAccessObject {
	static final String FILEPATH = "/home/adminstrato/BijayaWorkSpace/LoginAndRegistration/src/com/bridgelabz/loginandregistration/files/DBDetails.properties";

	/**
	 * To establish a connection using connection pool concept
	 */
	public Connection connectionPoolFactory() {
		DataSource datasource = null;
		Connection con = null;
		datasource = getMySQLDataSource();
		try {
			con = datasource.getConnection();
			return con;
		} catch (Exception e) {
			System.out.println("Connection issue occured");
		}
		return con;
	}

	/**
	 * To fetch user name,password ,url of specific database
	 * 
	 * @return mysql datasource object
	 */
	public DataSource getMySQLDataSource() {
		Properties props = new Properties();
		FileInputStream file = null;
		// only for mysql database
		MysqlDataSource mysqlDS = null;
		try {
			FileInputStream fileRead = new FileInputStream(FILEPATH);
			props.load(fileRead);
			mysqlDS = new MysqlDataSource();
			mysqlDS.setURL(props.getProperty("URL"));
			mysqlDS.setUser(props.getProperty("USER"));
			mysqlDS.setPassword(props.getProperty("PASSWORD"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		return mysqlDS;
	}

	public TraineeBean getTraineeBeanByUserName(String username) {
		TraineeBean bean = null;
		String selectQuery = "select * from Trainee where Email=?";

		try (Connection con = connectionPoolFactory(); PreparedStatement pst = con.prepareStatement(selectQuery);) {
			pst.setString(1, username);
			try (ResultSet res = pst.executeQuery();) {
				if (res.next()) {
					bean = new TraineeBean();
					int serialNumber = res.getInt(1);
					String fullName = res.getString(2);
					Long mobileNumber = res.getLong(3);
					bean.setEmail(username);
					bean.setPassword(res.getString(5));
					bean.setSerialNum(serialNumber);
					bean.setFullName(fullName);
					bean.setMobile(mobileNumber);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bean;
	}

	public void addTraineeBeanIntoDatabase(TraineeBean traineeBean) {

		String fullName = traineeBean.getFullName();
		Long mobile = traineeBean.getMobile();
		String email = traineeBean.getEmail();
		String password = traineeBean.getPassword();
		String insert = "insert into Trainee(FullName ,Mobile,Email,Password) values(?,?,?,?)";
		try (Connection con = connectionPoolFactory(); PreparedStatement pst = con.prepareStatement(insert);) {
			pst.setString(1, fullName);
			pst.setLong(2, mobile);
			pst.setString(3, email);
			pst.setString(4, password);
			pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean checkWhetherEmailPresentOrNot(TraineeBean traineeBean) {
		boolean result = false;
		ResultSet res = null;
		String selectQuery = "select * from Trainee where Email=?";
		try (Connection con = connectionPoolFactory(); PreparedStatement pst = con.prepareStatement(selectQuery);) {
			String username = traineeBean.getEmail();
			pst.setString(1, username);
			res = pst.executeQuery();
			if (res.next()) {
				result = true;
			} else {
				result = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
