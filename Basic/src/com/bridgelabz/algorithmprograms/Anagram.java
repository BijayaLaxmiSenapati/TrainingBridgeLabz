/**
 * purpose: checks whether two strings are anagram or not.
 * @author:Bijaya Laxmi
 * @version:1.0
 * @since:21/05/2018
 */
package com.bridgelabz.algorithmprograms;

import com.bridgelabz.utility.Utility;

public class Anagram 
{

	public static void main(String[] args) 
	{
		System.out.println("enter the first string");
		String string1=Utility.retNextLine();
		System.out.println("enter the second string");
		String string2=Utility.retNextLine();
		string1=Utility.removeSapce(string1);
		//System.out.println(string1);
		string2=Utility.removeSapce(string2);
		//System.out.println(string2);
		if(string1.length()==string2.length())
		{
			string1=string1.toLowerCase();
			//System.out.println(string1);
			string2=string2.toLowerCase();
			//System.out.println(string2);
			string1=Utility.stringBubbleSortByLetter(string1);
			//System.out.println(string1);
			string2=Utility.stringBubbleSortByLetter(string2);
			//System.out.println(string2);
			for(int i=0;i<string1.length();i++)
			{
				if(string1.charAt(i)!=string2.charAt(i))
				{
					System.out.println("not anagram");
				}
			}
			System.out.println("anagram");
		}
		else
		{
			System.out.println("not anagram");
		}
	}

}
