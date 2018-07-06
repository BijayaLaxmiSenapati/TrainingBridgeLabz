/**
 * purpose:search a word from the file using binary search.
 * @author:Bijaya Laxmi Senapati
 * @since:22/05/2018
 * @version:1.0
 */
package com.bridgelabz.algorithmprograms;

import com.bridgelabz.utility.Utility;

public class InsertionSort 
{

	
	public static void main(String[] args)
	{
		System.out.println("enter how many strings you want to store");
		int size=Integer.parseInt(Utility.retNextLine());
		String[] array=new String[size];
		System.out.println("enter one by one string");
		for(int i=0;i<size;i++)
		{
			array[i]=Utility.retNextLine();
		}
		array=Utility.stringInsertionSort(array);
		System.out.println("the order of array elements after sorting is");
		for(int i=0;i<size;i++)
		{
			System.out.println(array[i]+" ");
		}
	}

}
