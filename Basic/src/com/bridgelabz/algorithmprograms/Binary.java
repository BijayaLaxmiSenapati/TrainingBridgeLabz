/**
 * purpose:It reads an integer as an input, convert to binary using 
 * decimalToBinary method and swap nibbles and then finds the new number.
 * @author:Bijaya Laxmi Senapati
 * @since:24/05/2018
 * @version:
 */
package com.bridgelabz.algorithmprograms;

import com.bridgelabz.utility.Utility;

public class Binary {

	public static void main(String[] args)
	{
		String swapedBinary;
		System.out.println("enter a decimal number");
		int decimal=Utility.retInt();
		String binary=Utility.decimalToBinary(decimal);
		System.out.println("binary="+binary);
		swapedBinary=binary.substring(4, 8)+binary.substring(0,4);
		System.out.println("swapedBinary="+swapedBinary);
		int swapedDecimal=Utility.binaryToDecimal(swapedBinary);
		System.out.println("decimal value after swapping "+decimal+" is "+swapedDecimal);
		for(int i=1;i<Math.sqrt(swapedDecimal);i++)
		{
			if(swapedDecimal%Math.pow(2, i)==0)
			{
				System.out.println("the swaped decimal number "+swapedDecimal+
						" is divesible by "+i+"th power of 2");
				return;
			}
		}
		System.out.println("the swaped decimal number "+swapedDecimal+
				" is divisible by any power of 2");
		
	}

}
