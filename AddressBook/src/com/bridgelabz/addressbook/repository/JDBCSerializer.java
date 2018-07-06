package com.bridgelabz.addressbook.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.bridgelabz.addressbook.controller.UserInterface;
import com.bridgelabz.addressbook.model.Person;
import com.bridgelabz.addressbook.model.Status;
import com.bridgelabz.addressbook.utility.Utility;

public class JDBCSerializer implements Serializer
{
	public JDBCSerializer() {
		connection();
	}

	Connection con = null;
	Statement stmt = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	String currentAddressBook = null;
	AddressBook addressBook = new AddressBook();
	ArrayList<Person> removedPersonList=new ArrayList<Person>();

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
		//giving bigint datatype to zip and phone number which may affect my program execution later 
		String createQuery = "create table " + nameOfNewAddressBook
				+ "(firstName varchar(20), lastName varchar(20), address varchar(20),city varchar(20),state varchar(20),zip bigint,phoneNumber bigint primary key)";
		try {
			stmt.executeUpdate(createQuery);
			System.out.println("New Address Book is Created");
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
	public void openAddressBook(String nameOfAddressBook) {
		currentAddressBook = nameOfAddressBook;
		int count=0;
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
				addressBook.personList.add(count++,person2);//have doubt
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

	public void printEntries() {
		for(int i=0;i<addressBook.getPersonList().size();i++)
		{
			System.out.println(addressBook.getPersonList().get(i));
		}
	}

	
	
	@Override
	public void personOperations(int option, Person person, String name) {
		
		
		if (option == 1)
		{
			Status status=person.getStatus();
			System.out.println(status);//to know the default status
			addressBook.getPersonList().add(person);
		} 
		else if (option == 2) //update.............................
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
				addressBook.getPersonList().get(index).setStatus(Status.update);
				break;
				
			case 2:
				System.out.println("Enter the new city");
				String newCity = Utility.retNext();
				index=searchIndexOfPersonByName(name);
				addressBook.getPersonList().get(index).setCity(newCity);
				addressBook.getPersonList().get(index).setStatus(Status.update);
				break;

			case 3:
				System.out.println("Enter the new state");
				String newState = Utility.retNext();
				index=searchIndexOfPersonByName(name);
				addressBook.getPersonList().get(index).setState(newState);
				addressBook.getPersonList().get(index).setStatus(Status.update);
				break;

			case 4:
				System.out.println("Enter the new zip code");
				String newZip = Utility.retNext();
				index=searchIndexOfPersonByName(name);
				System.out.println(index);
				addressBook.getPersonList().get(index).setZip(newZip);
				addressBook.getPersonList().get(index).setStatus(Status.update);
				break;

			case 5:
				System.out.println("Enter the new phone number");
				String newPhoneNumber = Utility.retNext();
				index=searchIndexOfPersonByName(name);
				addressBook.getPersonList().get(index).setPhoneNumber(newPhoneNumber);
				addressBook.getPersonList().get(index).setStatus(Status.update);
				break;
			}
		}
		
		else if(option==3)//delete...................................
		{
			int index=searchIndexOfPersonByName(name);
			removedPersonList.add(addressBook.getPersonList().get(index));
			addressBook.getPersonList().remove(index);
		}
	}
	public int searchIndexOfPersonByName(String firstNameOfPerson) 
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
		for(int i=0;i<addressBook.getPersonList().size();i++)
		{
			Person prsn=addressBook.getPersonList().get(i);
			String fname = prsn.getFirstName();
			String lname = prsn.getLastName();
			String address = prsn.getAddress();
			String city = prsn.getCity();
			String state = prsn.getState();
			String zip = prsn.getZip();
			String phoneNumber = prsn.getPhoneNumber();
			if(!(addressBook.getPersonList().get(i).equals(Status.defaultStatus)))
			{
				if(addressBook.getPersonList().get(i).equals(Status.insert))
				{
					//insert the newly added persons to database
					String insertQ = "insert into " + currentAddressBook + " values('" + fname + "','" + lname + "','" + address
							+ "','" + city + "','" + state + "','" + zip + "','" + phoneNumber + "')";
				}
				
				//.....................doubt...........................
				else if(addressBook.getPersonList().get(i).equals(Status.update))
				{
					//first delete the updated person from database
					//then insert the same person details from the list to database
					String deleteQuery = "delete from " + currentAddressBook + " where firstName=" + fname +" and lastName=" + lname +" and phoneNumber= " + phoneNumber;
					String insertQ = "insert into " + currentAddressBook + " values('" + fname + "','" + lname + "','" + address
							+ "','" + city + "','" + state + "','" + zip + "','" + phoneNumber + "')";
				}
			}
		}
		
		//.....................doubt...........................
		for(int i=0;i<removedPersonList.size();i++)
		{
			Person prsn=addressBook.getPersonList().get(i);
			String fname = prsn.getFirstName();
			String lname = prsn.getLastName();
			String phoneNumber = prsn.getPhoneNumber();
			//delete the removed persons from database
			String deleteQuery = "delete from " + currentAddressBook + " where firstName=" + fname +" and lastName=" + lname +" and phoneNumber= " + phoneNumber;
		}
	}
}
