/**
 * 
 * purpose: Calculates percentage of head and tail after flipping a coin n number of times.
 * @author: BijayaLaxmi
 * @version: 1.0
 * @since:17/05/2018
 */
package com.bridgelabz.functionalprograms;

import com.bridgelabz.utility.Utility;

public class FlipCoin 
{

	
	public static void main(String[] args) 
	{
		System.out.println("enter how many times the coin should be flipped");
		int numberOfTimes = Utility.retInt();
		Utility.percentOfHeadTail(numberOfTimes);
	}

}
