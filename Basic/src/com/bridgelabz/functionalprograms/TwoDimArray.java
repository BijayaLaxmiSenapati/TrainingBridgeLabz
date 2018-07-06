/**
 * ..
 */
package com.bridgelabz.functionalprograms;

import com.bridgelabz.utility.Utility;

/**
 * @author adminstrato
 *
 */
public class TwoDimArray 
{

	public static void main(String[] args) 
	{
		
		System.out.println("enter your choice, which type of values you want to store in the array");
		System.out.println("Type 1 for integer");
		System.out.println("Type 2 for double");
		System.out.println("Type 3 for boolean");
		int n=Utility.retInt();
		Utility.print2DArray(n);
		
	}

}
