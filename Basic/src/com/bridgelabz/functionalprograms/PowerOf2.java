
/**
 *  Purpose: Prints a table of the power of 2.it prints upto the nth power
 *
 *  @author  BijayaLaxmi
 *  @version 1.0
 *  @since   17-05-2018
 *
 */

package com.bridgelabz.functionalprograms;

import com.bridgelabz.utility.Utility;

public class PowerOf2 
{

	/**
	 * @param args takes the number upto which power of 2,the program should print
	 */
	public static void main(String[] args)
	{
		int number=Integer.parseInt(args[0]);
		Utility.printPowOf2(number);
	}

}
