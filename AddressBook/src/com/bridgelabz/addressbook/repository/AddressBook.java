package com.bridgelabz.addressbook.repository;

import java.util.ArrayList;

import com.bridgelabz.addressbook.model.Person;
import com.bridgelabz.addressbook.utility.Utility;

public class AddressBook 
{
	ArrayList<Person> personList=new ArrayList<Person>();
	public AddressBook()
	{
		
	}
	AddressBook(String filePath)
	{
		personList=Utility.convertJsonToListUsingJackson(filePath, personList);
	}
	public ArrayList<Person> getPersonList() 
	{
		return personList;
	}
	
	
	public void setPersonList(ArrayList<Person> personList) 
	{
		this.personList = personList;
	}
	
	
	/*public void add(Person person)
	{
		personList.add(person);
	}
	
	
	public void delete(String personName)
	{
		for(int i=0;i<personList.size();i++)
		{
			if(personList.get(i).getFirstName().equals(personName))
			{
				personList.remove(i);
			}
		}
	}*/
}
