/**
 * ..
 */
package com.bridgelabz.datastructureprograms;
import com.bridgelabz.utility.Utility;

public class UnOrderedList 
{

	public static void main(String[] args)
	{
		Utility utility=new Utility();
		String fileName="/home/adminstrato/BijayaWorkSpace/fileContentWithSpace";
		String readedFile=utility.readAllFromFile(fileName);
		String[] wordArray=readedFile.split(" ");
		MyLinkedList<String> mylinkedlist=new MyLinkedList<String>();
		for(int i=0;i<wordArray.length;i++)
		{
			mylinkedlist.add(wordArray[i]);
		}
		System.out.println("File elements are:");
		mylinkedlist.display();
		System.out.println();
		System.out.println("enter the element which you want to search");
		String searchElement=Utility.retNext();
		if(!mylinkedlist.search(searchElement))
		{
			mylinkedlist.add(searchElement);
		}
		else
		{
			int deleteIndexElement=mylinkedlist.index(searchElement);
			mylinkedlist.pop(deleteIndexElement);
		}
		mylinkedlist.display();
	}

}
