/**
 * purpose: converts a given decimal number to its binary.
 * @author:Bijaya Laxmi Senapati
 * @since:24/05/2018
 * @version:1.0
 */
package com.bridgelabz.algorithmprograms;

import com.bridgelabz.utility.Utility;

public class DecimalToBinary
{

	public static void main(String[] args)
	{
		System.out.println("enter a decimal number which should be <=259");
		int decimal=Utility.retInt();
		String binary=Utility.decimalToBinary(decimal);
		System.out.println("binary of "+decimal+" is= "+binary);

	}

}
