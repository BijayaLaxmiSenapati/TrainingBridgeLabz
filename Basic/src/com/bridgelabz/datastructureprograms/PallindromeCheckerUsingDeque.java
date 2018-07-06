/**
 * purpose: Checks a string is pallindrome or not using deque.
 * @author:Bijaya Laxmi Senapati
 * @since:27/05/2018
 * @version:1.0
 */
package com.bridgelabz.datastructureprograms;

import com.bridgelabz.utility.Utility;

public class PallindromeCheckerUsingDeque 
{
	
	public static void main(String[] args)
	{
		
		System.out.println("enter a string which you want to check for pallindrome");
		String string=Utility.retNext();
		if(Utility.checkPallindrome(string))
			System.out.println("The given string is pallindrome");
		else
			System.out.println("The given string is not pallindrome");
	}

}
