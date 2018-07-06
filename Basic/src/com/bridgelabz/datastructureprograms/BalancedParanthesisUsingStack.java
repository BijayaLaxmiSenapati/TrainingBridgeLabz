/**
 * ..
 */
package com.bridgelabz.datastructureprograms;

import com.bridgelabz.utility.Utility;

public class BalancedParanthesisUsingStack
{
	public static void main(String[] args)
	{
		System.out.println("enter a arithmatic expression ");
		String expression=Utility.retNextLine();
		Utility utility=new Utility();
		if(utility.checkForValidExpression(expression)==true)
		{
			System.out.println("the given expression is valid");
		}
		else
		{
			System.out.println("the given expression is not valid");
		}
		
	}
}
