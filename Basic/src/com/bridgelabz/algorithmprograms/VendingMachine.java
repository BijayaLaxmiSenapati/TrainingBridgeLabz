/**
 * purpose: Program to calculate the minimum number
of Notes as well as the Notes to be returned by the Vending Machine as a
Change.
 * @author:Bijaya Laxmi Senapati
 * @since:24/05/2018
 * @version:1.0
 */
package com.bridgelabz.algorithmprograms;

import com.bridgelabz.utility.Utility;

public class VendingMachine {

	public static void main(String[] args)
	{
		System.out.println("enter how much amount the user want");
		int requiredAmount=Utility.retInt();
		Utility.giveMinimumChange(requiredAmount);
	}

}
