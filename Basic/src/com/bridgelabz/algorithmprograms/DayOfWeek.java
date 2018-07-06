/**
 * purpose: gives day of the week for the given date.
 * @author:Bijaya Laxmi Senapati
 * @since:24/05/2018
 * @version:1.0
 */
package com.bridgelabz.algorithmprograms;

import com.bridgelabz.utility.Utility;

public class DayOfWeek {

	public static void main(String[] args)
	{
		int date=Integer.parseInt(args[0]);
		int month=Integer.parseInt(args[1]);
		int year=Integer.parseInt(args[2]);
		String[] week= {"Sunday","Monday","Tuesday","Wednesday","Thurseday","Friday","Saturday"};
		if(Utility.isValidDate(date,month,year))
		{
			int result=Utility.dayOfWeek(date, month, year);
			System.out.println("the given date is "+week[result]);
		}
		else
			System.out.println("entered date is invalid");
	}

}
