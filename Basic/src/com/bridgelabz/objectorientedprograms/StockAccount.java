/**
 * 
 */
package com.bridgelabz.objectorientedprograms;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class StockAccount {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException 
	{
		String filePath="/home/adminstrato/BijayaWorkSpace/Basic/src/com/bridgelabz/objectorientedprograms/companyStock.json";
		
		/*JSONParser parser=new JSONParser();
		Object object=parser.parse(new FileReader(filePath));
		JSONObject jsonObject=(JSONObject)object;
		System.out.println(jsonObject.get("nokia"));
		System.out.println(jsonObject.get("samsung"));*/
		System.out.println("To login enter the details");
		customerDetails();
		
	}

	private static void customerDetails() 
	{
		System.out.println("Enter your name:");
		//"/home/adminstrato/BijayaWorkSpace/Basic/src/com/bridgelabz/"
		
	}

}
