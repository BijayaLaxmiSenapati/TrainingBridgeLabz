/**
 * purpose: calculates and display the time taken by all the searching and sorting algorithms.
 * @author: Bijaya Laxmi Senapati
 * @since:24/05/2018
 * @version:1.0
 */
package com.bridgelabz.algorithmprograms;

import java.util.Arrays;
import java.util.List;

import com.bridgelabz.utility.Utility;

public class UtilityForSearchingAndSorting
{

	public static void main(String[] args)
	{
		//for binary search of integer
		System.out.println("enter how many elements you want to store in the array(for binary search if integer)");
		int size=Utility.retInt();
		int[] array=new int[size];
		System.out.println("enter elements of the array(for binary search if integer)");
		for(int i=0;i<array.length;i++)
		{
			array[i]=Utility.retInt();
		}
		
		System.out.println("enter the searching element(for binary search if integer)");
		int search=Utility.retInt();
		
		array=UtilityForSearchingAndSorting.intBubbleSort(array);
		
		System.out.println("At "+UtilityForSearchingAndSorting.intBinarySearch(array,search)+" index "+search+" is present");
		
		
		
		//	for binary search of strings
		System.out.println("enter how many elements you want to store in the array(for binary search of strings)");
		int size1=Utility.retInt();
		String[] array1=new String[size1];
		System.out.println("enter elements of the array(for binary search of strings)");
		for(int i=0;i<array1.length;i++)  //for size=5, it is only taking 4 inputs????
		{
			array1[i]=Utility.retNextLine();
		}
		System.out.println("enter the searching element(for binary search of strings)");
		String search1=Utility.retNextLine();
		Arrays.sort(array1);
		System.out.println("after sorting the array is");
		for(String s:array1)
		{
			System.out.print(s+" ");
		}
		System.out.println("At "+UtilityForSearchingAndSorting.stringBinarySearch(array1,search1)+" index "+search1+" is present");
		
		
		
		//for bubble sort of integer
		System.out.println("enter how many elements you want to store in the array (for bubble sort)");
		int size3=Utility.retInt();
		int[] array3=new int[size3];
		System.out.println("enter elements of the array(for bubble sort)");
		for(int i=0;i<size3;i++)
		{
			array3[i]=Utility.retInt();
		}
		
		array3=UtilityForSearchingAndSorting.intBubbleSort(array3);
		for(int i=0;i<size3;i++)
		{
			System.out.print(array3[i]+" ");
		}
		
		
		//for bubble sort of string
		System.out.println("enter a string which you want to sort(for bubble sort)");
		String string6=Utility.retNextLine();
		String[] array6=string6.split(" ");
		array6=UtilityForSearchingAndSorting.stringBubbleSort(array6);
		String temporary6="";
		for(int i=0;i<array6.length;i++)
		{
			temporary6=temporary6+array6[i]+" ";
		}
		string6=temporary6;
		System.out.println("the sorted string(bubble sort) is "+string6);
		
		
		//for insertion sort of integer
		System.out.println("enter size of the array(for insertion sort of integer)");
		int size4=Utility.retInt();
		int array4[]=new int[size4];
		System.out.println("enter elements of the array(for insertion sort of integer)");
		for(int i=0;i<array4.length;i++)
		{
			array4[i]=Utility.retInt();
		}
		array4=UtilityForSearchingAndSorting.intInsertionSort(array4);
		System.out.println("the sorted array(insertion sort) is ");
		for(int i=0;i<array4.length;i++)
		{
			System.out.print(array4[i]+" ");
		}
		
		
		//for insertion sort of string
		System.out.println("enter a string which you want to sort(for insertion sort)");
		String string5=Utility.retNextLine();
		String[] array5=string5.split(" ");
		array5=UtilityForSearchingAndSorting.stringInsertionSort(array5);
		String temporary5="";
		for(int i=0;i<array5.length;i++)
		{
			temporary5=temporary5+array5[i]+" ";
		}
		string5=temporary5;
		System.out.println("the sorted string(insertion sort) is "+string5);
		
	}
	
	
	/*
	 * @param array1
	 * @param search1
	 * @return
	 */
	private static int stringBinarySearch(String[] array1, String search1) 
	{
		long startTime=0;
		long stopTime=0;
		long elapsedTime=0;

		int low=0;
		int high=array1.length-1;
		int mid=0;
		startTime=System.nanoTime();
		while(low<=high)
		{
			mid=low+(high-low)/2;
			if(array1[mid].equals(search1))
			{
				stopTime=System.nanoTime();
				elapsedTime=stopTime-startTime;
				System.out.println("start time="+startTime);
				System.out.println("stop time="+stopTime);
				System.out.println("elapsed time="+elapsedTime);
				return mid;
			}
			else if(search1.compareTo(array1[mid])>0)
			{
				low=mid+1;
			}
			else if(search1.compareTo(array1[mid])<0)
			{
				high=mid-1;
			}
		}
		stopTime=System.nanoTime();
		elapsedTime=stopTime-startTime;
		System.out.println("start time="+startTime);
		System.out.println("stop time="+stopTime);
		System.out.println("elapsed time="+elapsedTime);
		return -1;
	}
	
	
	/**
	 * @param array
	 * @param search
	 * @return
	 */
	public static int intBinarySearch(int[] array,int search)
	{
		long startTime=0;
		long stopTime=0;
		long elapsedTime=0;
		int low=0;
		int high=array.length-1;
		int mid=0;
		startTime=System.nanoTime();
		while(low<=high)
		{
			mid=(int)(low+(high-low)/2);
			if(array[mid]==search)
			{
				stopTime=System.nanoTime();
				elapsedTime=stopTime-startTime;
				System.out.println("start time="+startTime);
				System.out.println("stop time="+stopTime);
				System.out.println("elapsed time="+elapsedTime);
				return mid;
			}
			else if(search<array[mid])
			{
				high=mid-1;
			}
			else if(search>array[mid])
			{
				low=mid+1;
			}	
		}
		stopTime=System.nanoTime();
		elapsedTime=stopTime-startTime;
		System.out.println("start time="+startTime);
		System.out.println("stop time="+stopTime);
		System.out.println("elapsed time="+elapsedTime);
		return -1;
	}
	
	

	/**
	 * @param array
	 * @return
	 */
	public static int[] intBubbleSort(int[] array2)
	{
		long startTime=0;
		long stopTime=0;
		long elapsedTime=0;
		startTime=System.nanoTime();
		for(int i=0;i<array2.length-1;i++)
		{
			for(int j=0;j<array2.length-1-i;j++)
			{
				if(array2[j]>array2[j+1])
				{
					int temprary=array2[j];
					array2[j]=array2[j+1];
					array2[j+1]=temprary;
				}
			}
		}
		stopTime=System.nanoTime();
		elapsedTime=stopTime-startTime;
		System.out.println("start time="+startTime);
		System.out.println("stop time="+stopTime);
		System.out.println("elapsed time="+elapsedTime);
		return array2;
	}
	
	
	/**********************************************************************************
	 * @param string
	 * @return
	 */
	public static String[] stringBubbleSort(String[] array) 
	{
		long startTime=0;
		long stopTime=0;
		long elapsedTime=0;
		String temprary="";
		startTime=System.nanoTime();
		for(int i=0;i<array.length-1;i++)
		{
			for(int j=0;j<array.length-1-i;j++)
			{
				if(array[j].compareTo(array[j+1])>0)
				{
					temprary=array[j];
					array[j]=array[j+1];
					array[j+1]=temprary;
				}
			}
		}
		stopTime=System.nanoTime();
		elapsedTime=stopTime-startTime;
		System.out.println("start time="+startTime);
		System.out.println("stop time="+stopTime);
		System.out.println("elapsed time="+elapsedTime);
		return array;
	}
	
	
	/**
	 * @param array
	 * @return
	 */
	public static int[] intInsertionSort(int[] array)
	{

		long startTime=0;
		long stopTime=0;
		long elapsedTime=0;
		startTime=System.nanoTime();
		for(int i=1;i<array.length;i++)
		{
			int key=array[i];
			int j=i-1;
			while(j>=0 && array[j]>key)
			{
				array[j+1]=array[j];
				j=j-1;
			}
			array[j+1]=key;
		}
		stopTime=System.nanoTime();
		elapsedTime=stopTime-startTime;
		System.out.println("start time="+startTime);
		System.out.println("stop time="+stopTime);
		System.out.println("elapsed time="+elapsedTime);
		return array;
	}
	
	
	/**
	 * @param string
	 * @return
	 */
	
	public static String[] stringInsertionSort(String[] array)
	{
		long startTime=0;
		long stopTime=0;
		long elapsedTime=0;
		startTime=System.nanoTime();
	      for (int i = 1; i < array.length; i++) 
	      {
	    	  String key = array[i];
	    	  int j = i - 1;
	    	  while (j >= 0 && key.compareToIgnoreCase(array[j]) < 0)
	    	  {
	    		  array[j + 1] = array[j];
	    		  j--;
	    	  }
	    	  array[j + 1] = key;

	      }
	      stopTime=System.nanoTime();
		  elapsedTime=stopTime-startTime;
		  System.out.println("start time="+startTime);
		  System.out.println("stop time="+stopTime);
		  System.out.println("elapsed time="+elapsedTime);
	      return array;
	}
	
	
	public static <T extends Comparable<T>> T[] bubbleSort(T[] array) 
	{
		T temporary;
		for(int i=0;i<array.length-1;i++)
		{
			for(int j=0;j<array.length-1-i;j++)
			{
				if(array[j].compareTo(array[j+1])>0)
				{
					temporary=array[j];
					array[j]=array[j+1];
					array[j+1]=temporary;
				}
			}
		}
		return array;
	}

}
