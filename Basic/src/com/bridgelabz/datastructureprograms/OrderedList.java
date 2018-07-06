/**
 * purpose:Read the Text from a file, split it into words and arrange it as Linked List.
 *Take a user input to search a Word in the List. If the Word is not found then add it
 *to the list, and if it found then remove the word from the List. In the end save the
 *list into a file
 *@author: Bijaya Laxmi Senapati
 *@since: 25/05/2018
 *@version:1.0
 */
package com.bridgelabz.datastructureprograms;

import com.bridgelabz.utility.Utility;

public class OrderedList 
{
	static MyLinkedList<Integer> mylinkedlist=new MyLinkedList<Integer>();
	public static void main(String[] args)
	{
		Utility utility=new Utility();
		String fileName="/home/adminstrato/BijayaWorkSpace/numbersWithComma";
		String readedFile=utility.readAllFromFile(fileName);
		String[] numArray=readedFile.split(",");
		Integer[] array=new Integer[numArray.length];
		for(int i=0;i<numArray.length;i++)
		{
			array[i]=Integer.parseInt(numArray[i]);
		}
		mylinkedlist.add(array[0]);
		for(int i=1;i<array.length;i++)
		{
			Utility.checkAndAddForOrderedList(array[i],mylinkedlist);
		}
		System.out.println("linked list elements are:");
		mylinkedlist.display();
		System.out.println();
		System.out.println("enter which number you want to search");
		Integer searchNumber=Utility.retInt();
		if(mylinkedlist.search(searchNumber))
		{
			int deleteIndexElement=mylinkedlist.index(searchNumber);
			mylinkedlist.pop(deleteIndexElement);
		}
		else
		{
			Utility.checkAndAddForOrderedList(searchNumber,mylinkedlist);
		}
		System.out.println("linked list elements are:");
		mylinkedlist.display();
	}
	
	

}
