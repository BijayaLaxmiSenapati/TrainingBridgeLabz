
/**
 *  Purpose: Checks a given number is Leap year or not
 *  @author  BijayaLaxmi
 *  @version 1.0
 *  @since   17-05-2018
 *
 */

package com.bridgelabz.functionalprograms;

import com.bridgelabz.utility.Utility;

public class LeapYear 
{

	
	public static void main(String[] args) 
	{
		System.out.println("enter a year");
		int n = Utility.retInt();
		System.out.println(Utility.checkLeapYear(n));

	}

}
