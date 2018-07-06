/**
 * purpose: prints the calender of the given month and year
 * @author:Bijaya Laxmi Senapati
 * @since:27/05/2018
 * @version:1.0
 */
package com.bridgelabz.datastructureprograms;
import com.bridgelabz.utility.Utility;

public class Calender 
{

	public static void main(String[] args) 
	{
		int date=1;
		int month=Integer.parseInt(args[0]);
		int year=Integer.parseInt(args[1]);
		String[] daysArray= {"S   ","M   ","T   ","W   ","TH  ","F   ","S   "};
		String[] months= {" ","Jan","Feb","Mar","Apr","May","Jun","July","Aug","Sept","Oct","Nov","Dec"};
		Integer[] daysInMonths= {0,31,28,31,30,31,30,31,31,30,31,30,31};
		if(Utility.checkLeapYear(year).equals("Leap Year"))
		{
			daysInMonths[2]=29;
		}
		String[][] calender=new String[6][7];
		for(int i=0;i<calender.length;i++)
		{
			for(int j=0;j<calender[i].length;j++)
			{
				calender[i][j]=" ";
			}
		}
		if(Utility.isValidDate(date, month, year)==true)
		{
			int day=Utility.dayOfWeek(date, month, year);
			int tillDate=daysInMonths[month];
			System.out.println("   "+months[month]+" "+year);
			for(int i=0;i<daysArray.length;i++)
			{
				System.out.print(daysArray[i]);
			}
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
						calender[i][j]="   ";
						//System.out.print("   ");
						j++;
					}
				}
				for(j=day;j<calender[i].length;j++)
				{	
					
					if(count<=tillDate)
					{
						if(count<=9)
						{
							calender[i][j]=count+"  ";
							count++;
							//System.out.print(count+"  ");
							//count++;
						}
						else
						{
							calender[i][j]=count+" ";
							count++;
							//System.out.print(count+" ");
							//count++;
						}
					}
					
				}
				day=0;
				//System.out.println();
			}
			Utility.print2DArrayElement(calender);
		}
		else
		{
			System.out.println("Invalid month or year given");
			return;
		}
	}

}
