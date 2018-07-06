/**
 * purpose:search a word from the file using binary search.
 * @author:Bijaya Laxmi Senapati
 * @since:22/05/2018
 * @version:1.0
 * 
 */
package com.bridgelabz.algorithmprograms;

import com.bridgelabz.utility.Utility;

public class BubbleSort
{

	public static void main(String[] args)
	{
		System.out.println("enter how many numbers you want to store");
		int size=Utility.retInt();
		Integer[] array=new Integer[size];
		System.out.println("enter one by one integer");
		for(int i=0;i<size;i++)
		{
			array[i]=Utility.retInt();
		}
		array=Utility.intBubbleSort(array);
		System.out.println("the order of array elements after sorting is");
		for(int i=0;i<size;i++)
		{
			System.out.println(array[i]+" ");
		}

	}

}
