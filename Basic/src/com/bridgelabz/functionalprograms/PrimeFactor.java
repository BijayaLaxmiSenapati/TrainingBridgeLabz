/**
 * purpose: Prints prime factors of a number.
 * @author: BijayaLaxmi
 * @version: 1.0
 * @since:17/05/2018
 */
package com.bridgelabz.functionalprograms;

import com.bridgelabz.utility.Utility;


public class PrimeFactor 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		System.out.println("enter a number whose prime factors you want to print");
		int n = Utility.retInt();
		System.out.println(Utility.printPrimeFactors(n));
	}

}
