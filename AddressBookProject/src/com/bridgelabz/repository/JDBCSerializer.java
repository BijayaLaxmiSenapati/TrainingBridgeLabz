package com.bridgelabz.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bridgelabz.Controller.UserInterface;
import com.bridgelabz.model.Person;
import com.bridgelabz.utility.Utility;

public class JDBCSerializer implements Serializer {
	public JDBCSerializer() {
		connection();
	}

	Connection con = null;
	Statement stmt = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	String currentAddressBook = null;
	AddressBook addressBook = new AddressBook();

	public void connection() {
		try {
			Class.forName(Utility.getProperty("MYSQL_DB_DRIVER"));
			con = DriverManager.getConnection(Utility.getProperty("MYSQL_DB_URL"),
					Utility.getProperty("MYSQL_DB_USERNAME"), Utility.getProperty("MYSQL_DB_PASSWORD"));
			stmt = con.createStatement();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Connection not established");
			e.printStackTrace();
		}

	}

	public void closeResources() {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void createNewAddressBook(String nameOfNewAddressBook) {
		String createQuery = "create table " + nameOfNewAddressBook
				+ "(firstName varchar(10), lastName varchar(10), address varchar(10),city varchar(10),state varchar(10),zip bigint,phoneNumber bigint primary key)";
		try {
			stmt.executeUpdate(createQuery);
			System.out.println("New Address Book is Created");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void openAddressBook(String nameOfAddressBook) {
		currentAddressBook = nameOfAddressBook;
		System.out.println(currentAddressBook);
		//addressBook.setPersonList(personList);
		String fetch = "select * from " + currentAddressBook;
		try {
			rs = stmt.executeQuery(fetch);
			while (rs.next()) {
				String fname = rs.getString(1);
				String lname = rs.getString(2);
				String address = rs.getString(3);
				String city = rs.getString(4);
				String state = rs.getString(5);
				String zip = rs.getString(6);
				String phoneNumber = rs.getString(7);
				Person person2 = new Person(fname, lname, address, city, state, zip, phoneNumber);
				addressBook.add(person2);
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void deleteAddressBook(String nameOfAddressBook) {
		String dropQuery = "drop table " + nameOfAddressBook;
		try {
			stmt.execute(dropQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void viewAllAddressBook() {
		String showTablesQuery = "show tables";
		try {
			rs = stmt.executeQuery(showTablesQuery);
			while (rs.next()) {
				String table = rs.getString(1);
				System.out.println(table);
			}
		} catch (SQLException e) {
			System.out.println("No address Book is present");
			e.printStackTrace();
		}

	}

	@Override
	public void printEntries() {
		for(int i=0;i<addressBook.getPersonList().size();i++)
		{
			System.out.println(addressBook.getPersonList().get(i).toString());
		}
		/*String showPersons = "select * from " + currentAddressBook;
		try {
			rs = stmt.executeQuery(showPersons);
			while (rs.next()) {
				System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  " 
			+ rs.getString(3)+ "  " + rs.getString(4)+ "  " + rs.getString(5)+ "  " + rs.getString(6)+ "  " + rs.getString(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
	}

	@Override
	public void personOperations(int option, Person person, String name) {
		/*String fetch = "select * from " + currentAddressBook;
		try {
			rs = stmt.executeQuery(fetch);
			while (rs.next()) {
				String fname = rs.getString(1);
				String lname = rs.getString(2);
				String address = rs.getString(3);
				String city = rs.getString(4);
				String state = rs.getString(5);
				String zip = rs.getString(6);
				String phoneNumber = rs.getString(7);
				Person person2 = new Person(fname, lname, address, city, state, zip, phoneNumber);
				addressBook.add(person2);
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}*/
		
		if (option == 1)
		{
			String fname = person.getFirstName();
			String lname = person.getLastName();
			String address = person.getAddress();
			String city = person.getCity();
			String state = person.getState();
			String zip = person.getZip();
			String phoneNumber = person.getPhoneNumber();
			addressBook.add(person);
			String insertQ = "insert into " + currentAddressBook + " values('" + fname + "','" + lname + "','" + address
					+ "','" + city + "','" + state + "','" + zip + "','" + phoneNumber + "')";
			addToBatch(insertQ);
			
		} 
		else if (option == 2) 
		{
			String updateQuery=null;
			int index=0;
			System.out.println("enter what do you want to edit");
			System.out.println("1.to edit address");
			System.out.println("2.to edit city");
			System.out.println("3.to edit state");
			System.out.println("4.to edit zip");
			System.out.println("5.to edit phone number");
			int option1 = Utility.retInt();
			switch (option1)
			{
			case 1:
				System.out.println("Enter the new address");
				String newAddress = Utility.retNext();
				index=searchIndexOfPersonByName(name);
				System.out.println(index);
				addressBook.getPersonList().get(index).setAddress(newAddress);
				updateQuery="update "+currentAddressBook+" set address = '"+newAddress+"' where firstName = '"+name+"'";
				addToBatch(updateQuery);
				break;
				
			case 2:
				System.out.println("Enter the new city");
				String newCity = Utility.retNext();
				index=searchIndexOfPersonByName(name);
				addressBook.getPersonList().get(index).setCity(newCity);
				updateQuery="update "+currentAddressBook+" set city = '"+newCity+"' where firstName = '"+name+"'";
				addToBatch(updateQuery);
				break;

			case 3:
				System.out.println("Enter the new state");
				String newState = Utility.retNext();
				index=searchIndexOfPersonByName(name);
				addressBook.getPersonList().get(index).setState(newState);
				updateQuery="update "+currentAddressBook+" set state = '"+newState+"' where firstName = '"+name+"'";
				addToBatch(updateQuery);
				break;

			case 4:
				System.out.println("Enter the new zip code");
				String newZip = Utility.retNext();
				index=searchIndexOfPersonByName(name);
				System.out.println(index);
				addressBook.getPersonList().get(index).setZip(newZip);
				
				updateQuery="update "+currentAddressBook+" set zip = '"+newZip+"' where firstName = '"+name+"'";
				addToBatch(updateQuery);
				break;

			case 5:
				System.out.println("Enter the new phone number");
				String newPhoneNumber = Utility.retNext();
				index=searchIndexOfPersonByName(name);
				addressBook.getPersonList().get(index).setPhoneNumber(newPhoneNumber);
				updateQuery="update "+ currentAddressBook +" set phoneNumber = '"+newPhoneNumber+"' where firstName = '"+name+"'";
				addToBatch(updateQuery);
				break;
			}
		}
		else if(option==3)
		{
			// String personName=name;
			addressBook.delete(name);
			String deleteQuery = "delete from " + currentAddressBook + " where firstName=" + name;
			addToBatch(deleteQuery);
		}
	}
	
	private void addToBatch(String query) 
	{
		try
		{
			
			stmt.addBatch(query);
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	

	private int searchIndexOfPersonByName(String firstNameOfPerson) 
	{
		int i=0;
		for(i=0;i<addressBook.getPersonList().size();i++)
		{
			if(addressBook.getPersonList().get(i).getFirstName().equals(firstNameOfPerson))
			{
				return i;
			}
		}
		return -1;
	}
	
	/*@Override
	public Person getPersonsObjectByName(String fname)
	{
		for(int i=0;i<addressBook.getPersonList().size();i++)
		{
			if(addressBook.getPersonList().get(i).getFirstName().equals(fname))
			{
				return addressBook.getPersonList().get(i);
			}
		}
		return null;
	}*/
	
	
	public void closeCurrentAddressBook()
	{
		System.out.println("do you really want to exit??");
		System.out.println("0.Yes\t1.No");
		int option1=Utility.retInt();
		if(option1==0)
		{
			System.out.println("Do you want to save the changes?");
			System.out.println("0.Yes\t1.No");
			option1=Utility.retInt();
			if(option1==0)
			{
				save();
			}
			
			System.exit(1);
		}
		else
		{
			UserInterface.showOptionsForAddressBook();
		}
	}

	private void save() 
	{
		try {
			stmt.executeBatch();
			System.out.println("THANK YOU!!!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
