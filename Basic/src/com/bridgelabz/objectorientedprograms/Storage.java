/**
 * 
 */
package com.bridgelabz.objectorientedprograms;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Storage
{
	private static ArrayList<Person> book;
	
	public ArrayList<Person> getBook() {
		return book;
	}

	public void setBook(ArrayList<Person> book) {
		this.book = book;
	}
	Storage()
	{
		String filePath="/home/adminstrato/BijayaWorkSpace/Basic/src/com/bridgelabz/objectorientedprograms/adsBookPersonDetails.json";
		JSONParser parser=new JSONParser();
		Object object = null;
		try 
		{
			object = parser.parse(new FileReader(filePath));
		} 
		catch (ParseException e) 
		{
		
			e.printStackTrace();
		}
		catch (FileNotFoundException e)
		{
			
			e.printStackTrace();
		} 
		catch (IOException e)
		{
			
			e.printStackTrace();
		}
		JSONObject jsonObject=(JSONObject)object;
		JSONArray jsonArray=(JSONArray)jsonObject.get("book");
		//System.out.println(jsonArray);
		for(int i=0;i<jsonArray.size();i++)
		{
			JSONObject object1=(JSONObject)jsonArray.get(i);
			Person person=new Person();
			person.setFirstName(object1.get("firstName").toString());
			person.setLastName(object1.get("lastName").toString());
			person.setAddress(object1.get("address").toString());
			person.setCity(object1.get("city").toString());
			person.setState(object1.get("state").toString());
			person.setZip(object1.get("zip").toString());
			person.setPhoneNumber(object1.get("phoneNumber").toString());
			book.add(person);
		}
	}
}
