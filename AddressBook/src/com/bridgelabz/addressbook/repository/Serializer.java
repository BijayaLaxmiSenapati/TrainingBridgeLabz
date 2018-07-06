package com.bridgelabz.addressbook.repository;

import com.bridgelabz.addressbook.model.Person;

public interface Serializer 
{
	void createNewAddressBook(String nameOfNewAddressBook);

	void viewAllAddressBook();

	void openAddressBook(String nameOfAddressBook);

	void deleteAddressBook(String nameOfAddressBook);

	void printEntries();
	
	void personOperations(int option, Person person, String name);

	void closeCurrentAddressBook();

}
