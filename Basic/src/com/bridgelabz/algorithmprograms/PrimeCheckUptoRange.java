/**
 * purpose: prints all the prime numbers between the given range.
 * @author:Bijaya Laxmi Senapati
 * @since:24/05/2018
 * @version:1.0
 */
package com.bridgelabz.algorithmprograms;

import com.bridgelabz.utility.Utility;

public class PrimeCheckUptoRange {

	
	public static void main(String[] args) 
	{
		for(int i=0;i<=1000;i++)
		{
			if(Utility.isPrime(i))
			{
				System.out.println(i+"  ");
			}
		}
	}

}
