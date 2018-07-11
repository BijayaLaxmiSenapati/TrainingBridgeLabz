package com.bridgelabz.jdbcpractice.connectionpooling;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

import com.mysql.cj.jdbc.MysqlDataSource;

import oracle.jdbc.pool.OracleDataSource;

public class MyDataSourceFactory 
{
	public static DataSource getMySQLDataSourse()
	{
	Properties properties=new Properties();
	FileInputStream fileInputStream=null;
	MysqlDataSource mysqlDs=null;
	try 
	{
		fileInputStream=new FileInputStream("/home/adminstrato/BijayaWorkSpace/Practice/src/com/bridgelabz/jdbcpractice/connectionpooling/DatabaseDetails.properties");
		properties.load(fileInputStream);
		mysqlDs=new MysqlDataSource();
		mysqlDs.setURL(properties.getProperty("MYSQL_DB_URL"));
		mysqlDs.setUser(properties.getProperty("MYSQL_DB_USERNAME"));
		mysqlDs.setPassword(properties.getProperty("MYSQL_BD_PASSWORD"));

	} 
	catch (IOException e) 
	{
		e.printStackTrace();
	}
	return mysqlDs;
	}
	
	public static DataSource getOracleDataSource(){
		Properties props = new Properties();
		FileInputStream fis = null;
		OracleDataSource oracleDS = null;
		try {
			fis = new FileInputStream("/home/adminstrato/BijayaWorkSpace/Practice/src/com/bridgelabz/jdbcpractice/connectionpooling/DatabaseDetails.properties");
			props.load(fis);
			oracleDS = new OracleDataSource();
			oracleDS.setURL(props.getProperty("ORACLE_DB_URL"));
			oracleDS.setUser(props.getProperty("ORACLE_DB_USERNAME"));
			oracleDS.setPassword(props.getProperty("ORACLE_DB_PASSWORD"));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return oracleDS;
	}
	
	
	public static DataSource getDataSource(String dbType){
		Properties props = new Properties();
		FileInputStream fis = null;
		BasicDataSource ds = new BasicDataSource();
		
		try {
			fis = new FileInputStream("/home/adminstrato/BijayaWorkSpace/Practice/src/com/bridgelabz/jdbcpractice/connectionpooling/DatabaseDetails.properties");
			props.load(fis);
		}catch(IOException e){
			e.printStackTrace();
			return null;
		}
		if("mysql".equals(dbType)){
			ds.setDriverClassName(props.getProperty("MYSQL_DB_DRIVER_CLASS"));
            ds.setUrl(props.getProperty("MYSQL_DB_URL"));
            ds.setUsername(props.getProperty("MYSQL_DB_USERNAME"));
            ds.setPassword(props.getProperty("MYSQL_DB_PASSWORD"));
		}else if("oracle".equals(dbType)){
			ds.setDriverClassName(props.getProperty("ORACLE_DB_DRIVER_CLASS"));
            ds.setUrl(props.getProperty("ORACLE_DB_URL"));
            ds.setUsername(props.getProperty("ORACLE_DB_USERNAME"));
            ds.setPassword(props.getProperty("ORACLE_DB_PASSWORD"));
		}else{
			return null;
		}
		
		return ds;
	}
		
}
