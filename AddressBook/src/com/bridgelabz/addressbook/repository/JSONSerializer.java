package com.bridgelabz.addressbook.repository;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgelabz.addressbook.controller.UserInterface;
import com.bridgelabz.addressbook.model.Person;
import com.bridgelabz.addressbook.utility.Utility;

public class JSONSerializer implements Serializer {

	public static ArrayList<String> addressBookList = new ArrayList<String>();

	// public static ArrayList<Person> personList=new ArrayList<Person>();

	public static String addressBookStorage = "/home/adminstrato/BijayaWorkSpace/AddressBook/src/com/bridgelabz/addressbook/files/ADDRESSBOOKLIST.json";

	public static String filesLocation = "/home/adminstrato/BijayaWorkSpace/AddressBook/src/com/bridgelabz/addressbook/files/";
	String currentAddressBook = null;
	AddressBook addressBook = null;
	static {
		addressBookList = Utility.convertJsonToList(addressBookStorage);
	}

	@Override
	public void createNewAddressBook(String nameOfNewAddressBook) {
		// System.out.println("enter the name of the address book which you want to
		// create");
		String name = filesLocation + nameOfNewAddressBook + ".json";
		File fl = new File(name);
		try {
			if (fl.createNewFile()) {
				System.out.println("New Address Book is Created");
				addressBookList.add(name);
				Utility.convertJavaToJson(addressBookList, addressBookStorage);
			} else {
				System.err.println("address book already exists. Enter a new name");
			}
		} catch (IOException e) {

			e.printStackTrace();
		}
		// closeCurrentAddressBook();
	}

	@Override
	public void openAddressBook(String nameOfAddressBook) {
		int index = searchIndexByName(nameOfAddressBook);
		currentAddressBook = addressBookList.get(index);
		String fullName = filesLocation + nameOfAddressBook + ".json";
		// personList=Utility.convertJsonToListUsingJackson(fullName,personList);
		addressBook = new AddressBook(fullName);
		// showOptions();
	}

	@Override
	public void deleteAddressBook(String nameOfAddressBook) {
		// String fileNameToDlt=addressBookList.get(indexOfFileList);
		int index = searchIndexByName(nameOfAddressBook);
		String fileNameToDlt = addressBookList.get(index);
		if (index > -1) {
			addressBookList.remove(index);
		} else {
			System.out.println("Given address book is not present");
			return;
		}
		Utility.convertJavaToJson(addressBookList, addressBookStorage);
		File file = new File(fileNameToDlt);
		if (file.delete()) {
			System.out.println("File Deleted Successfully");
		} else {
			System.out.println("Failed To delete the file");
		}
		// closeCurrentAddressBook();
	}

	private int searchIndexByName(String nameOfAddressBook) {
		String fullName = filesLocation + nameOfAddressBook + ".json";
		int i = 0;
		for (i = 0; i < addressBookList.size(); i++) {
			if (addressBookList.get(i).equals(fullName)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public void viewAllAddressBook() {
		addressBookList = Utility.convertJsonToList(addressBookStorage);
		for (int i = 0; i < addressBookList.size(); i++) {
			System.out.print("index=" + i + "\t");
			System.out.println(addressBookList.get(i));
		}
		if (addressBookList.size() == 0) {
			System.out.println("No address Book is present");
		}
	}

	public void printEntries() {
		JSONParser parser = new JSONParser();
		Object object = null;
		try {
			object = parser.parse(new FileReader(currentAddressBook));
		} catch (ParseException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		JSONArray jsonArray = (JSONArray) object;
		for (int i = 0; i < jsonArray.size(); i++) {
			JSONObject object1 = (JSONObject) jsonArray.get(i);
			System.out.print("index=" + i);
			System.out.println(object1);
		}
	}

	@Override
	public void personOperations(int option, Person person, String name) {
		if (option == 1)// insert new person
		{
			addressBook.personList.add(person);// adding to person list
		} else if (option == 2)// edit existing person info
		{
			int index = 0;
			System.out.println("enter what do you want to edit");
			System.out.println("1.to edit address");
			System.out.println("2.to edit city");
			System.out.println("3.to edit state");
			System.out.println("4.to edit zip");
			System.out.println("5.to edit phone number");
			int option1 = Utility.retInt();
			switch (option1) {
			case 1:
				System.out.println("Enter the new address");
				String newAddress = Utility.retNext();
				index = searchIndexOfPersonByName(name);
				addressBook.getPersonList().get(index).setAddress(newAddress);

			case 2:
				System.out.println("Enter the new city");
				String newCity = Utility.retNext();
				index = searchIndexOfPersonByName(name);
				addressBook.getPersonList().get(index).setCity(newCity);

			case 3:
				System.out.println("Enter the new state");
				String newState = Utility.retNext();
				index = searchIndexOfPersonByName(name);
				addressBook.getPersonList().get(index).setState(newState);

			case 4:
				System.out.println("Enter the new zip code");
				String newZip = Utility.retNext();
				index = searchIndexOfPersonByName(name);
				addressBook.getPersonList().get(index).setZip(newZip);

			case 5:
				System.out.println("Enter the new phone number");
				String newPhoneNumber = Utility.retNext();
				index = searchIndexOfPersonByName(name);
				addressBook.getPersonList().get(index).setPhoneNumber(newPhoneNumber);

			}
		} else if (option == 3)// delete a person
		{
			int index = searchIndexOfPersonByName(name);
			addressBook.personList.remove(index);
		}
	}

	private int searchIndexOfPersonByName(String firstNameOfPerson) {
		int i = 0;
		for (i = 0; i < addressBook.getPersonList().size(); i++) {
			if (addressBook.getPersonList().get(i).getFirstName().equals(firstNameOfPerson)) {
				return i;
			}
		}
		return -1;
	}

	public void closeCurrentAddressBook() {
		System.out.println("do you really want to exit??");
		System.out.println("0.Yes\t1.No");
		int option1 = Utility.retInt();
		if (option1 == 0) {
			System.out.println("Do you want to save the changes?");
			System.out.println("0.Yes\t1.No");
			option1 = Utility.retInt();
			if (option1 == 0) {
				save();
			}

			System.exit(1);
		} else {
			UserInterface.showOptionsForAddressBook();
		}
	}

	private void save() {
		Utility.convertJavaToJson(addressBook.getPersonList(), currentAddressBook);
		System.out.println("THANK YOU!!!!");
	}

}
