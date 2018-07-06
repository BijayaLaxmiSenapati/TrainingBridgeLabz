/**
 * purpose: prints calender of the given month and year using queue
 * author: Bijaya Laxmi Senapati
 * @since:27/05/2018
 * @version:1.0
 */
package com.bridgelabz.datastructureprograms;

import com.bridgelabz.utility.Utility;

public class CalenderUsingQueue
{

	public static void main(String[] args) 
	{
		int date=1;
		int month=Integer.parseInt(args[0]);
		int year=Integer.parseInt(args[1]);
		String[] daysArray= {"S ","M ","T ","W ","TH","F ","SAT  "};
		MyQueue<String> queueDays=new MyQueue<>();
		for(int i=0;i<daysArray.length;i++)
		{
			queueDays.enqueue(daysArray[i]);
		}
		String[] months= {" ","January","February","March","April","May","June","July","August","September","October","November","December"};
		Integer[] daysInMonths= {0,31,28,31,30,31,30,31,31,30,31,30,31};
		if(Utility.checkLeapYear(year).equals("Leap Year"))
		{
			daysInMonths[2]=29;
		}
		MyQueue<String> [][] calender=new MyQueue[6][7];
		for(int i=0;i<calender.length;i++)
		{
			for(int j=0;j<calender[i].length;j++)
			{
				calender[i][j]=new MyQueue();
			}
		}
		for(int i=0;i<calender.length;i++)
		{
			for(int j=0;j<calender[i].length;j++)
			{
				calender[i][j].enqueue(" ");
			}
		}
		if(Utility.isValidDate(date, month, year)==true)
		{
			int day=Utility.dayOfWeek(date, month, year);
			int tillDate=daysInMonths[month];
			/*for(int i=0;i<daysArray.length;i++)
			{
				System.out.print(daysArray[i]);
			}*/
			System.out.println("    "+months[month]+" "+year);
			queueDays.display();
			System.out.println();
			System.out.println();
			int count=1;
			int j=0;
			for(int i=0;i<calender.length;i++)
			{
				if(i==0 )
				{
					for(int k=0;k<day;k++)
					{
						calender[i][j].dequeue();
						calender[i][j].enqueue("   ");
						j++;
					}
				}
				for(j=day;j<calender[i].length;j++)
				{	
					
					if(count<=tillDate)
					{
						if(count<=9)
						{
							calender[i][j].dequeue();
							calender[i][j].enqueue(count+"  ");
							count++;
						}
						else
						{
							calender[i][j].dequeue();
							calender[i][j].enqueue(count+" ");
							count++;
						}
					}
					
				}
				day=0;
			}
			for(int i=0;i<calender.length;i++)
			{
				for( j=0;j<calender[i].length;j++)
				{
					System.out.print(calender[i][j].dequeue());
				}
				System.out.println();
			}
		}
		else
		{
			System.out.println("Invalid month or year given");
			return;
		}
	}

}
