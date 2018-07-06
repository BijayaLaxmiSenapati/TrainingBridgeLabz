/**
 * ..
 */
package com.bridgelabz.functionalprograms;

import com.bridgelabz.utility.Utility;

/**
 * @author bridgelabz
 *
 */
public class HarmonicNumber 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		System.out.println("enter a number");
		int n = Utility.retInt();
		Utility.printNthHarmonic(n);
		System.out.println("the " + n + "th" + " harmonic number is " + Utility.printNthHarmonic(n));
	}

}
