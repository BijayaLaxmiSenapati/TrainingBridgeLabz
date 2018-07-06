/**
 * ..
 */
package com.bridgelabz.datastructureprograms;

import com.bridgelabz.utility.Utility;

class WeekDays
{
	String[] days= {"S ","M ","T ","W ","TH","F ","S   "};
	Integer[] dates= {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
}
class CalenderQueue
{
	public static void main(String[] args)
	{
		String[] months= {" ","January","February","March","April","May","June","July","August","September","October","November","December"};
		MyQueue<String> queueDays=new MyQueue<>();
		MyQueue<Integer> queueDates=new MyQueue<>();
		MyQueue<String> calender=new MyQueue<>();
		WeekDays weekdays=new WeekDays();
		for(int i=0;i<weekdays.days.length;i++)
		{
			queueDays.enqueue(weekdays.days[i]);
		}
		for(int i=0;i<weekdays.dates.length;i++)
		{
			queueDates.enqueue(weekdays.dates[i]);
		}
		int date=1;
		int month=Integer.parseInt(args[0]);
		int year=Integer.parseInt(args[1]);
		Integer[] daysInMonths= {0,31,28,31,30,31,30,31,31,30,31,30,31};
		int tillDate=0;
		if(Utility.checkLeapYear(year).equals("Leap Year"))
		{
			daysInMonths[2]=29;
		}
		if(Utility.isValidDate(date, month, year)==true)
		{
			int day=Utility.dayOfWeek(date, month, year);
			tillDate=tillDate+daysInMonths[month];
			int count=1;
			int j=0;
			System.out.println("    "+months[month]+" "+year);
			queueDays.display();
			System.out.println();
			System.out.println();
			for(int i=0;i<6;i++)
			{
				if(i==0 )
				{
					for(int k=0;k<day;k++)
					{
						calender.enqueue("   ");
						j++;
					}
				}
				for(j=day;j<7;j++)
				{	
					
					if(count<=tillDate)
					{
						if(count<=9)
						{
							calender.enqueue(count+"  ");
							count++;
						}
						else
						{
							calender.enqueue(count+" ");
							count++;
						}
					}
					
				}
				day=0;
			}
		}
		else
		{
			System.out.println("Invalid month or year given");
			return;
		}
		int count=0;
		while(calender.size()!=0)
		{
			for(int i=0;i<7;i++)
			{
				if(count<=tillDate) {
					System.out.print(calender.dequeue());
				}
				else if(count>tillDate) {
					return;
				}
				count++;
			}
			System.out.println();
		}
	}
}