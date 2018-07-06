/**
 * 
 */
package com.bridgelabz.objectorientedprograms;

import java.util.Random;

import com.bridgelabz.datastructureprograms.MyLinkedList;
import com.bridgelabz.utility.Utility;

public class SortedDeckOfCards {

	public static void main(String[] args) 
	{
		String[] suit={"Clubs","Diamonds","Hearts","Spades"}; 
		String[] rank={"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
		MyLinkedList<String> cards=new MyLinkedList<>();
		String[][] players=new String[4][9]; 
		for(int i=0;i<suit.length;i++) 
		{ 
			for(int j=0;j<rank.length;j++)
			{ 
				cards.add(suit[i]+" "+rank[j]);
			} 
		} 
		cards.display(); 
		System.out.println();
	    System.out.println(); 
	    players=distribute(players,cards);
	    players=sortByRank(players);
	    Utility.print2DArrayElement(players);
	}
	private static String[][] distribute(String[][] players, MyLinkedList<String> cards) 
	{ 
		Random rand=new Random();
		int numOfCardsPresent=52; 
		for(int i=0;i<9;i++) 
		{ 
			players[0][i]=cards.pop(rand.nextInt(numOfCardsPresent--));
			players[1][i]=cards.pop(rand.nextInt(numOfCardsPresent--));
			players[2][i]=cards.pop(rand.nextInt(numOfCardsPresent--));
			players[3][i]=cards.pop(rand.nextInt(numOfCardsPresent--)); 
		} 
		return players;
	  
	}
	private static String[][] sortByRank(String[][] players)
	{
		String[] sortedCards= {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
		String[][] sortedArray=new String[4][9];
		//for(int j=0;j<players[i])
		return players;
		
	}
}
