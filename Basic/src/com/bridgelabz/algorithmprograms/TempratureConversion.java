/**
 * purpose:this program converts celcius to fahrenheit and vice versa.
 * @author:Bijaya Laxmi Senapati
 * @since:24/05/2018
 * @version:1.0
 */
package com.bridgelabz.algorithmprograms;

import com.bridgelabz.utility.Utility;

public class TempratureConversion
{

	public static void main(String[] args)
	{
	     System.out.println("Temparature in  1.Celsius \t 2.Fahrenheit");
	     System.out.println("Enter 1 for if you want temparature in Celsius: ");
	     System.out.println("Enter 2 for if you want temparature in Fahrenheit: ");
	     int input = Utility.retInt();
	     double temparature = 0;
	     switch (input)
	     {
	     case 1:
	            System.out.println("Enter the temparature in Fahrenheit");
	            double temparatureInF = Utility.retDouble();
	            temparature = (temparatureInF - 32) * 5 / 9;
	            System.out.println("Fahrenheit to Celsius: " + temparature + "C");
	            break;
	     case 2:
	            System.out.println("Enter the temparature Celsius");
	            double temparatureInC = Utility.retDouble();
	            temparature = (temparatureInC * 9 / 5) + 32;
	            System.out.println("Celsius to Fahrenheit: " + temparature + "F");
	            break;
	     default:
	    	    System.out.println("invalid input");
	     }
	}

}
