/**
 * purpose: Prints prime factors of a number.
 * @author: BijayaLaxmi
 * @version: 1.0
 * @since:17/05/2018
 */
package com.bridgelabz.functionalprograms;

import java.util.Scanner;

import com.bridgelabz.utility.Utility;

public class Gambling 
{

	public static void main(String[] args)
	{
		Scanner scr=new Scanner(System.in);
		System.out.println("enter how much money the player have");
		int stake=scr.nextInt();
		System.out.println("enter the goal value,which the player needs to make for the final winnig");
		int goal=scr.nextInt();
		System.out.println("enter the number of chances the player have");
		int chance=scr.nextInt();
		Utility.calWinLossInGambling(stake,goal,chance);
	}

}
