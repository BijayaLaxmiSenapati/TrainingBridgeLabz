/**
 * 
 */
package com.bridgelabz.objectorientedprograms;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgelabz.utility.Utility;

public class AddressBookManager1 
{
	String fileLocation="/home/adminstrato/BijayaWorkSpace/Basic/src/com/bridgelabz/objectorientedprograms/";
	ArrayList<String> listOfAddressBook=null;
	AddressBook1 addressBook1;
	String select;
	/**
	 * @param fileStorage
	 */
	public AddressBookManager1(String fileStorage) 
	{
		if(listOfAddressBook == null) {
			
				listOfAddressBook = Utility.convertJsonToList(fileStorage);
				System.out.println();
			
		}
		else {
			System.out.println("No Address Book is present");
			listOfAddressBook = new ArrayList<>();
			System.out.println("lists are:"+listOfAddressBook);
		}
	}
	
	/**
	 * 
	 */
	void showOptions()
	{
		System.out.println("What do you want?");
		System.out.println("1. Add a person");
		System.out.println("2. edit a persons details");
		System.out.println("3. delete a persons details");
		System.out.println("4. Sort entries by name");
		System.out.println("5. sort entries by zip");
		System.out.println("6. print entries");
		//System.out.println("7. create a new address book");
		System.out.println("7. Quit program");
		System.out.println("8. close the current \"ADDRESS BOOK\"");
		System.out.println("select one option");
		int option=Utility.retInt();
		doSelectedOption(option);
	}

	
	/**
	 * @param option
	 */
	void doSelectedOption(int option)
	{
		//AddressBook obj=new AddressBook();
		switch(option)
		{
		case 1:
			printEntries();
			addPerson();
			break;
		case 2:
			printEntries();
			System.out.println("enter index of the person whose details you want to edit");
			int index=Utility.retInt();
			editPerson(index);
			break;
		case 3:
			printEntries();
			System.out.println("enter index of the person whose details you want to delete");
			int removeIndex=Utility.retInt();
			removePerson(removeIndex);
			break;
		case 4:
			sortByLastName();
			break;
		case 5:
			sortByZipCode();
			break;
		case 6:
			printEntries();
			break;
		/*case 7:
			createNewAddressBook();
			break;*/
		case 7:
			quitProgram();
			break;
		case 8:
			closeCurrentAddressBook();
		default:
			
		}
		
	}
	
	/**
	 * 
	 */
	void closeCurrentAddressBook() 
	{
		AddressBookManager1 addressBookManager2ndObj=new AddressBookManager1("/home/adminstrato/BijayaWorkSpace/Basic/src/com"
																			+ "/bridgelabz/objectorientedprograms/LISTOFADDRESSBOOK");
		UserInterface.showInitialOptions(addressBookManager2ndObj);
	}

	
	
	/**
	 * 
	 */
	public void addPerson()
	{
		String firstName="";
		String lastName="";
		String address="";
		String city="";
		String state="";
		String zip="";
		String phoneNumber="";
		System.out.println("for adding person details to the address book");
		System.out.println("Enter the \"First Name\"");
		firstName=Utility.retNext();
		System.out.println("Enter the \"Last Name\"");
		lastName=Utility.retNext();
		System.out.println("Enter the \"Address\"");
		address=Utility.retNext();
		System.out.println("Enter the \"City\"");
		city=Utility.retNext();
		System.out.println("Enter the \"State\"");
		state=Utility.retNext();
		System.out.println("Enter the \"Zip Code\"");
		zip=Utility.retNext();
		System.out.println("Enter the \"Phone Number\"");
		phoneNumber=Utility.retNext();
		Person person=new Person(firstName, lastName, address, city, state, zip, phoneNumber);
		addressBook1.getPersons().add(person);
		Utility.convertJavaToJson(addressBook1.getPersons(), select);
		showOptions();
	}

	

	/**
	 * 
	 */
	public void printEntries()
	{
		JSONParser parser=new JSONParser();
		Object object = null;
		try 
		{
			object = parser.parse(new FileReader(select));
		}
		catch (ParseException e) 
		{
			
			e.printStackTrace();
		}
		catch (IOException e) {
			
			e.printStackTrace();
		}
		JSONArray jsonArray=(JSONArray)object;
		for(int i=0;i<jsonArray.size();i++)
		{
			JSONObject object1=(JSONObject)jsonArray.get(i);
			System.out.print("index="+i);
			System.out.println(object1);
		}
	}
	
	
	
	/**
	 * 
	 */
	public void quitProgram()
	{
		System.out.println("DO YOU REALLY WANT TO QUIT THE PROGRAM ?");
		System.out.println("if yes then enter 0");
		int exitSurance=Utility.retInt();
		if(exitSurance==0)
		{
			System.out.println("Address Book Application closed");
			System.exit(0);
		}
		showOptions();
	}

	
	/**
	 * @param index
	 */
	public void editPerson(int index)
	{
		System.out.println("Enter what you want to change");
		System.out.println("To change address, enter 1");
		System.out.println("To change city, enter 2");
		System.out.println("To change state, enter 3");
		System.out.println("To change zip code, enter 4");
		System.out.println("To change phone number, enter 5");
		int option=Utility.retInt();
		switch(option)
		{
		case 1:
			System.out.println("Enter the new address");
			String newAddress=Utility.retNext();
			addressBook1.getPersons().get(index).setAddress(newAddress);
			Utility.convertJavaToJson(addressBook1.getPersons(), select);
			printEntries();
			showOptions();
			break;
		case 2:
			System.out.println("Enter the new city name");
			String newCity=Utility.retNext();
			addressBook1.getPersons().get(index).setCity(newCity);
			Utility.convertJavaToJson(addressBook1.getPersons(), select);
			printEntries();
			showOptions();
			break;
		case 3:
			System.out.println("Enter the new state name");
			String newState=Utility.retNext();
			addressBook1.getPersons().get(index).setState(newState);
			Utility.convertJavaToJson(addressBook1.getPersons(), select);
			printEntries();
			showOptions();
			break;
		case 4:
			System.out.println("Enter the new zip code");
			String newZipCode=Utility.retNext();
			addressBook1.getPersons().get(index).setZip(newZipCode);
			Utility.convertJavaToJson(addressBook1.getPersons(), select);
			printEntries();
			showOptions();
			break;
		case 5:
			System.out.println("Enter the new Phone number");
			String newPhoneNum=Utility.retNext();
			addressBook1.getPersons().get(index).setPhoneNumber(newPhoneNum);
			Utility.convertJavaToJson(addressBook1.getPersons(), select);
			printEntries();
			showOptions();
			break;
		default:
			System.out.println("wrong option selected");
			showOptions();
		}
	}

	
	
	/**
	 * @param removeIndex
	 */
	public void removePerson(int removeIndex)
	{
		addressBook1.getPersons().remove(addressBook1.getPersons().get(removeIndex));
		Utility.convertJavaToJson(addressBook1.getPersons(), select);
		printEntries();
		showOptions();
	}

	/**
	 * 
	 */
	public void sortByLastName()
	{
		
		for(int i=0;i<addressBook1.getPersons().size()-1;i++)
		{
			for(int j=i+1;j<addressBook1.getPersons().size();j++)
			{
				if(addressBook1.getPersons().get(i).getLastName().compareTo(addressBook1.getPersons().get(j).getLastName())>0)
				{
					Person temporary=addressBook1.getPersons().get(i);
					addressBook1.getPersons().set(i,addressBook1.getPersons().get(j));
					addressBook1.getPersons().set(j, temporary);
				}
				else if(addressBook1.getPersons().get(i).getLastName().compareTo(addressBook1.getPersons().get(j).getLastName())==0)
				{
					sortByFirstName(addressBook1.getPersons().get(i), i, addressBook1.getPersons().get(j), j);
				}
			}
		}
		Utility.convertJavaToJson(addressBook1.getPersons(), select);
		printEntries();
		showOptions();
	}
	
	
	/**
	 * @param person1
	 * @param i
	 * @param person2
	 * @param j
	 */
	public void sortByFirstName(Person person1 , int i , Person person2, int j)
	{
		if(person1.getFirstName().compareTo(person2.getFirstName())>0)
		{
			Person temp=addressBook1.getPersons().get(i);
			addressBook1.getPersons().set(i, addressBook1.getPersons().get(j));
			addressBook1.getPersons().set(j, temp);
		}
	}


	/**
	 * 
	 */
	public void sortByZipCode()
	{
		for(int i=0;i<addressBook1.getPersons().size()-1;i++)
		{
			for(int j=i+1;j<addressBook1.getPersons().size();j++)
			{
				if(addressBook1.getPersons().get(i).getZip().compareTo(addressBook1.getPersons().get(j).getZip())>0)
				{
					Person temporary=addressBook1.getPersons().get(i);
					addressBook1.getPersons().set(i,addressBook1.getPersons().get(j));
					addressBook1.getPersons().set(j, temporary);
				}
				else if(addressBook1.getPersons().get(i).getZip().compareTo(addressBook1.getPersons().get(j).getZip())==0)
				{
					sortByFirstName(addressBook1.getPersons().get(i), i, addressBook1.getPersons().get(j), j);
				}
			}
		}
		Utility.convertJavaToJson(addressBook1.getPersons(), select);
		printEntries();
		showOptions();
	}

	/**
	 * 
	 */
	public void createNewAddressBook() 
	{
		System.out.println("enter the name of the address book which you want to create");
		String name=fileLocation+Utility.retNext()+".json";
		File fl=new File(name);
		try 
		{
			if(fl.createNewFile())
			{
				System.out.println("New Address Book is Created");
				listOfAddressBook.add(name);
				Utility.convertJavaToJson(listOfAddressBook, UserInterface.fileStorage);
			}
			else
			{
				System.err.println("address book already exists. Enter a new name");
			}
		} 
		catch (IOException e) 
		{

			e.printStackTrace();
		}
		closeCurrentAddressBook();
	}

	/**
	 * 
	 */
	public void viewAllAddressBook() 
	{
		
		listOfAddressBook=Utility.convertJsonToList(UserInterface.fileStorage);
		for(int i=0;i<listOfAddressBook.size();i++)
		{
			System.out.print("index="+i+"\t");
			System.out.println(listOfAddressBook.get(i));
		}
		
	}

	/**
	 * @param indexOfFileList
	 */
	public void openAddressBook(int indexOfFileList) 
	{
		select=listOfAddressBook.get(indexOfFileList);
		//Utility.convertJsonToList(select,)
		addressBook1=new AddressBook1(select);
		showOptions();
	}

	public void deleteAddressBook(int indexOfFileList) 
	{
		String fileNameToDlt=listOfAddressBook.get(indexOfFileList);
		listOfAddressBook.remove(indexOfFileList);
		Utility.convertJavaToJson(listOfAddressBook,UserInterface.fileStorage);
		File file=new File(fileNameToDlt);
		if(file.delete())
		{
			System.out.println("File Deleted Successfully");
		}
		else
		{
			System.out.println("Failed To delete the file");
		}
		closeCurrentAddressBook();
	}

}
