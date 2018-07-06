/**
 * ..
 */
package com.bridgelabz.datastructureprograms;

import com.bridgelabz.utility.Utility;

public class BankingCashCounter 
{
	static MyQueue<Integer> myqueue=new MyQueue<>();
	public static void main(String[] args) 
	{
		System.out.println("enter the initial amount that the bank has");
		int initialAmount=Utility.retInt();
		System.out.println("enter how many people are in the queue");
		int numberOfPerson=Utility.retInt();
		int depositAmount;
		int withdrawAmount;
		for(int i=0;i<numberOfPerson;i++)
		{
			myqueue.enqueue(i);
		}
		while(myqueue.size()!=0)//for(int i=0;i<numberOfPerson;i++)
		{
			System.out.println("select an option:");
			System.out.println("enter 0 to deposit");
			System.out.println("enter 1 to withdraw");
			int option=Utility.retInt();
			switch(option)
			{
			case 0:
				System.out.println("enter how much amount you want to deposit");
				depositAmount=Utility.retInt();
				initialAmount=initialAmount+depositAmount;
				System.out.println("Updated balance of bank is:"+initialAmount);
				myqueue.dequeue();
				break;
			case 1:
				System.out.println("enter how much amount you want to withdraw");
				withdrawAmount=Utility.retInt();
				if(withdrawAmount>initialAmount)
				{
					System.out.println("Sorry Insufficient balance ");
					System.out.println("Would you like to withdraw an amount less than "+initialAmount);
					System.out.println("If yes then enter 1, if not enter 0");
					if(Utility.retInt()==1)
					{
						continue;
					}
					myqueue.dequeue();
				}
				else
				{
					initialAmount=initialAmount-withdrawAmount;
					System.out.println("Updated balance of bank is:"+initialAmount);
					myqueue.dequeue();
				}
				break;
			default:
				System.out.println("Wrong option choosen");
			}
		}
	}

}
