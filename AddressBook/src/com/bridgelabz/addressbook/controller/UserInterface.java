package com.bridgelabz.addressbook.controller;

import com.bridgelabz.addressbook.factory.SerializerFactory;
import com.bridgelabz.addressbook.model.Person;
import com.bridgelabz.addressbook.repository.Serializer;
import com.bridgelabz.addressbook.utility.Utility;


public class UserInterface {

	static Serializer serializer = null;

	public static void main(String[] args) {
		SerializerFactory serializerFactory = new SerializerFactory();
		System.out.println("Select the storage option:");
		System.out.println("JDBC or JSON");
		String storageOption = Utility.retNextLine();
		serializer = serializerFactory.getSerializer(storageOption);
		showOptionsForApp();
	}

	public static void showOptionsForApp() {
		System.out.println("Choose one of the options given");
		System.out.println("1.CREATE NEW ADDRESSBOOK");
		System.out.println("2.OPEN ADDRESS BOOK");
		System.out.println("3.VIEW ALL ADDRESS BOOK");
		System.out.println("4.DELETE ADDRESS BOOK");
		System.out.println("5.EXIT");
		int choice = Utility.retInt();
		doOperationsForApp(choice);
	}

	public static void doOperationsForApp(int choice) {
		switch (choice) {
		case 1:
			System.out.println("enter name of the address book which you want to create");
			String nameOfNewAddressBook = Utility.retNext();
			serializer.createNewAddressBook(nameOfNewAddressBook);
			UserInterface.showOptionsForApp();
			break;
		case 2:
			serializer.viewAllAddressBook();
			System.out.println("enter name of the address book which you want to open");
			String nameOfAddressBookToOpen = Utility.retNext();
			serializer.openAddressBook(nameOfAddressBookToOpen);
			UserInterface.showOptionsForAddressBook();
			break;
		case 3:
			serializer.viewAllAddressBook();
			UserInterface.showOptionsForApp();
			break;
		case 4:
			serializer.viewAllAddressBook();
			System.out.println("enter name of the address book which you want to delete");
			String nameOfAddressBookForDeletion = Utility.retNext();
			serializer.deleteAddressBook(nameOfAddressBookForDeletion);
			System.out.println("address book deleted successfully");
			UserInterface.showOptionsForApp();
			break;
		case 5:
			exit();
			break;
		default:
			System.out.println("Wrong option selected");
		}
	}

	private static void exit() {
		System.out.println("Do you really want to exit?");
		System.out.println("0.yes\t1.No");
		int option = Utility.retInt();
		if (option == 0) {
			System.out.println("THANK YOU!!!!");
			System.exit(1);
		} else {
			showOptionsForApp();
		}
	}
	
	public static void showOptionsForAddressBook() {
		System.out.println("What do you want?");
		System.out.println("1. Add a person");
		System.out.println("2. edit a persons details");
		System.out.println("3. delete a persons details");
		System.out.println("4. print entries");
		System.out.println("5. close the current \"ADDRESS BOOK\"");
		System.out.println("select one option");
		int option = Utility.retInt();
		doSelectedOption(option);
	}
	
	private static void doSelectedOption(int option) {
		Person person = null;
		switch (option) {
		case 1:
			person = takePersonDetails();
			serializer.personOperations(option, person, null);
			System.out.println("person details added successfully");
			showOptionsForAddressBook();
			break;
		case 2:
			serializer.printEntries();
			System.out.println("enter name of the person whose details you want to edit");
			String fname = Utility.retNext();
			serializer.personOperations(option, null, fname);
			serializer.printEntries();
			showOptionsForAddressBook();

			//editPersonNewDetails();
			break;
		case 3:
			serializer.printEntries();
			System.out.println("enter first name of the person whose details you want to delete");
			String name = Utility.retNext();
			serializer.personOperations(option, null, name);
			System.out.println("person deleted successfully");
			showOptionsForAddressBook();
			// removePerson(removeIndex);
			break;
		case 4:
			serializer.printEntries();
			showOptionsForAddressBook();
			break;
		case 5:
			serializer.closeCurrentAddressBook();
		default:

		}

	}
	
	private static Person takePersonDetails() {
		System.out.println("for adding person details to the address book");
		System.out.println("Enter the \"First Name\"");
		String firstName = Utility.retNext();
		System.out.println("Enter the \"Last Name\"");
		String lastName = Utility.retNext();
		System.out.println("Enter the \"Address\"");
		String address = Utility.retNext();
		System.out.println("Enter the \"City\"");
		String city = Utility.retNext();
		System.out.println("Enter the \"State\"");
		String state = Utility.retNext();
		System.out.println("Enter the \"Zip Code\"");
		String zip = Utility.retNext();
		System.out.println("Enter the \"Phone Number\"");
		String phoneNumber = Utility.retNext();
		Person person = new Person(firstName, lastName, address, city, state, zip, phoneNumber);
		return person;
	}

}
