/**
 * purpose: allows a user and the system to play a cross game/Tic-Tac-Toe game.
 * @author:Bijaya Laxmi
 * @version:1.0
 * @since:18/05.2018
 */
package com.bridgelabz.functionalprograms;

import java.util.Random;

import com.bridgelabz.utility.Utility;

public class TicTacToe
{

	public static void main(String[] args) 
	{
		Random random=new Random();
		Character[][] box=new Character[3][3];
		int l1=0;
		int l2=0;
		int count=1;
		
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				box[i][j]=' ';
			}
		}

		//system will give the first input, so it is outside the while loop
		l1=random.nextInt(3);
		l2=random.nextInt(3);
		box[l1][l2]='X';
		while(checkForWin(box)==false && count<=8)
		{
			//it prints the contents of the box before asking input from the user
			
			Utility.print2DArrayElement(box);//prints element with space
			System.out.println("________________________");
			System.out.println("enter the row number, which should be in between 0 to 2");
			l1=Utility.retInt();
			System.out.println("enter the col number, which should be in between 0 to 2");
			l2=Utility.retInt();
			if(box[l1][l2]!='X' && box[l1][l2]!='o' || (checkForWin(box)==false && count<=8))
			{
				box[l1][l2]='o';
				//prints the 2D array or board
				
				Utility.print2DArrayElement(box);
				System.out.println("________________________");
				count++;
			}
			else
			{
				continue;
			}
			
			//for system
			l1=random.nextInt(3);
			l2=random.nextInt(3);
			if(box[l1][l2]!='X' && box[l1][l2]!='o' || (checkForWin(box)==false && count<=8))
			{
				box[l1][l2]='X';
				//prints the 2D array or board
				
				Utility.print2DArrayElement(box);
				System.out.println("________________________");
				count++;
			}
			else
			{
				while(true)
				{
					l1=random.nextInt(3);
					l2=random.nextInt(3);
					if(box[l1][l2]!='X' && box[l1][l2]!='o' || (checkForWin(box)==false && count<=8))
					{
						box[l1][l2]='X';
						//prints the 2D array or board
						
						Utility.print2DArrayElement(box);
						System.out.println("________________________");
						count++;
						break;
					}
					else
					{
						continue;
					}
				}
			}
		}
		if(checkForWin(box))
		{
			System.out.println("either system or you won");
		}
		else if(count!=8)
		{
			System.out.println("lost");
		}
		
	}

	/**Function to check whether any row element or column element or giagonal elements of the board/2D array same or not.
	 * @param box/2D array the array to check whether a line element of that array is same or not
	 * @return true if a line of the given array has same elements else false
	 */
	private static boolean checkForWin(Character box[][]) 
	{
		return (checkRowWin(box) || checkColWin(box) || checkDiagonalWin(box));
	}

	/**
	 * @param box/2D array to check whether the elements of any diagonal is same or not
	 * @return true if elements of any diagonal is equal else false
	 */
	private static boolean checkDiagonalWin(Character box[][]) 
	{
		return (checkEqual(box[0][0], box[1][1], box[2][2]) || checkEqual(box[2][0], box[1][1], box[0][1]));
		
	}

	/**
	 * @param box/2D array to check whether the elements of any column is equal or not
	 * @return true if elements of any column is equal else false
	 */
	private static boolean checkColWin(Character box[][]) 
	{
		char c1;
		char c2;
		char c3;
		for(int i=0;i<3;i++)
		{
			c1=box[0][i];
			c2=box[1][i];
			c3=box[2][i];
			if(checkEqual(c1,c2,c3))
			{
				return true;
			}
		}
		return false;
	}

	/**
	 * @param box/2D array to check whether the elements of any row is equal or not
	 * @return true if elements of any row is equal else false
	 */
	private static boolean checkRowWin(Character box[][]) 
	{
		char c1;
		char c2;
		char c3;
		for(int i=0;i<3;i++)
		{
			c1=box[i][0];
			c2=box[i][1];
			c3=box[i][2];
			if(checkEqual(c1,c2,c3))
			{
				return true;
			}
		}
		return false;
	}

	/**
	 * @param c1 a charecter which is the first element of a row/column/diagonal of the 2D array
	 * @param c2 a charecter which is the second element of a row/column/diagonal of the 2D array
	 * @param c3 a charecter which is the third element of a row/column/diagonal of the 2D array
	 * @return
	 */
	private static boolean checkEqual(char c1, char c2, char c3) 
	{
		
		return ((c1!=' ')&&(c1==c2)&&(c2==c3));
	}
}
