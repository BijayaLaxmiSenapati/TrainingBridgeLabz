/**
 * 
 */
package com.bridgelabz.objectorientedprograms;

import java.util.Random;

import com.bridgelabz.datastructureprograms.MyLinkedList;
import com.bridgelabz.utility.Utility;

public class DeckOfCards 
{

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
				cards.add(suit[i]+rank[j]);
			} 
		} 
		cards.display(); 
		System.out.println();
	    System.out.println(); 
	    Utility.print2DArrayElement(distribute(players,cards));
	  
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
	  
	  
	  
	 /* private static MyLinkedList shuffle(MyLinkedList<String> cards) 
	  { 
		  Random rand=new Random(); 
		  int index; 
		  for(int i=0;i<30;i++) 
		  { 
			  index=rand.nextInt(51);
			  String temp=cards.pop(index); 
			  cards.insert(index, cards.pop(i));
			  cards.insert(i, temp); 
		  } 
		  return cards; 
	  }*/
	 

	/*public static void main(String[] args) {
		String[] suit = { "Clubs", "Diamons", "Hearts", "Spades" };
		String[] rank = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
		
		String[][] players = new String[4][9];
		
		MyLinkedList<String> cards = new MyLinkedList<>();
		for (int i = 0; i < suit.length; i++) {
			for (int j = 0; j < rank.length; j++) {
				cards.add(suit[i] + " " + rank[j]);
			}
		}
		
		Random random = new Random();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 9; j++) {
				players[i][j] = cards.pop(random.nextInt(cards.size()));
			}
		}
		
		Utility.print2DArrayElement(players);

	}*/

}
