/**
 * purpose: prints a number which is prime as well as pallindrome.
 * @author:Bijaya Laxmi Senapati
 * @since:24/05/2018
 * @version:1.0
 */
package com.bridgelabz.algorithmprograms;

import com.bridgelabz.utility.Utility;

public class PallindromePrimeNumber {

	public static void main(String[] args) 
	{
		for(int i=0;i<=1000;i++)
		{
			if(Utility.isPrime(i) && Utility.isPallindrome(i))
			{
					System.out.println(i+"  ");
				
			}
		}

	}

}
