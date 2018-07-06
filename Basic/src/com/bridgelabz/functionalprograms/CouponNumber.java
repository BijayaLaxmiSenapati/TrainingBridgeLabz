/** 
 * purpose: prints the total random number needed to get the given coupon number.
 * @author: BijayaLaxmi
 * @version: 1.0
 * @since:17/05/2018
 */
package com.bridgelabz.functionalprograms;

import com.bridgelabz.utility.Utility;

public class CouponNumber 
{

	
	public static void main(String[] args) 
	{
		System.out.println("enter how many distinct coupon numbers you want");
		int n = Utility.retInt();
		System.out.println("to generate distinct coupon numbers "+Utility.generateCouponNum(n)+" random numbers are needed");

	}

}
