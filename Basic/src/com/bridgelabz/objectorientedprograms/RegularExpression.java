/**
 * 
 */
package com.bridgelabz.objectorientedprograms;

import java.util.Date;
import java.text.SimpleDateFormat;

import com.bridgelabz.utility.Utility;

public class RegularExpression {

	public static void main(String[] args) 
	{
		System.out.println("enter your full name:");
		String fullName=Utility.retNextLine();
		System.out.println("enter your phone number:");
		String phoneNumber=Utility.retNextLine();
		String[] splitArray=fullName.split(" ");
		String firstName=splitArray[0];
		String date=dateOfToday();
		System.out.println(firstName);
		String template="Hello <<name>>, We have your full name as <<full name>> in our system. your contact number is 91­xxxxxxxxxx. "
						+ "Please,let us know in case of any clarification Thank you BridgeLabz 01/01/2016.";
		String regexName="<<name>>";
		String regexFullName="<<full name>>";
		String regexPhoneNum="xxxxxxxxxx";
		String regexDate="01/01/2016";
		template=Utility.replaceOperation(template,regexName,firstName);
		template=Utility.replaceOperation(template,regexFullName,fullName);
		template=Utility.replaceOperation(template,regexPhoneNum,phoneNumber);
		template=Utility.replaceOperation(template,regexDate,date);
		System.out.println(template);
	}
	public static String dateOfToday()
	{
		 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
		 Date date = new Date();  
		 return formatter.format(date);  
	}

}
