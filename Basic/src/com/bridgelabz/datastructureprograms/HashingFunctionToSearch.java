/**
 * ..
 */
package com.bridgelabz.datastructureprograms;

import com.bridgelabz.utility.Utility;

public class HashingFunctionToSearch 
{

	public static void main(String[] args)
	{
		Utility utility=new Utility();
		String readedFile=utility.readAllFromFile("/home/adminstrato/BijayaWorkSpace/numbersWithComma");
		//System.out.println(readedFile);
		String[] numArray=readedFile.split(",");
		Integer[] array=new Integer[numArray.length];
		for(int i=0;i<numArray.length;i++)
		{
			array[i]=Integer.parseInt(numArray[i]);
		}
		MyLinkedList<Integer>[] listArray=new MyLinkedList[11];
		int index=0;
		for(int i=0;i<listArray.length;i++)
		{
			listArray[i]=new MyLinkedList<>();
		}
		for(int i=0;i<array.length;i++)
		{
			//System.out.println(array[i]); 
			index=array[i]%11;
			//System.out.println(index);
			listArray[index].add(array[i]);
			
		}
		for(int i=0;i<listArray.length;i++)
		{
			for(int j=0;j<listArray[i].size();j++)
			{
				System.out.print(listArray[i].get(j)+" ");
			}
			System.out.println();
		}
		System.out.println("enter which number you want to search");
		Integer searchNumber=Utility.retInt();
		index=searchNumber%11;
		if(listArray[index].search(searchNumber)==false)
		{
			listArray[index].add(searchNumber);
		}
		else
			listArray[index].remove(searchNumber);
		System.out.println("Linked list array elements after search operation:");
		String temporary="";
		for(int i=0;i<listArray.length;i++)
		{
			for(int j=0;j<listArray[i].size();j++)
			{
				temporary+=listArray[i].get(j)+",";
				System.out.print(listArray[i].get(j)+" ");
			}
			System.out.println();
		}
		utility.writeAllToFile("/home/adminstrato/BijayaWorkSpace/answerOfHashing", temporary);
		String readedFile2=utility.readAllFromFile("/home/adminstrato/BijayaWorkSpace/answerOfHashing");
		System.out.println(readedFile2);
	}

}
