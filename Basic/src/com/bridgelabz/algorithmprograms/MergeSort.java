/**
 * purpose:Merge sort.
 * @author:Bijaya Laxmi SEnapati
 * @since:24/05/2018
 * @version:1.8
 * 
 */
package com.bridgelabz.algorithmprograms;

import com.bridgelabz.utility.Utility;

public class MergeSort 
{
	public static void merge(Integer array[], int left, int mid, int right)
	{
		int n1=mid-left+1;
		int n2=right-mid;
		int leftArray[]=new int[n1];
		int rightArray[]=new int[n2];
		for(int i=0;i<n1;i++)
		{
			leftArray[i]=array[left+i];
		}
		for(int i=0;i<n2;i++)
		{
			rightArray[i]=array[mid+1+i];
		}
		
		int i=0;
		int j=0;
		int k=1;
		while(i<n1 && j<n2)
		{
			if(leftArray[i]<=rightArray[j])
			{
				array[k]=leftArray[i];
				i++;
			}
			else
			{
				array[k]=rightArray[j];
				j++;
			}
			k++;
		}
		
		while(i<n1)
		{
			array[k]=leftArray[i];
			i++;
			k++;
		}
		
		while(j<n1)
		{
			array[k]=leftArray[j];
			j++;
			k++;
		}
	}
	
	public static void sort(Integer[] array, int left, int right)
	{
		if(left<right)
		{
			int mid=(left+(right-left))/2;
			sort(array,left,mid);
			//sort(array,mid+1,right);
			merge(array,left,mid,right);
		}
	}

	public static void main(String[] args)
	{
		System.out.println("enter how many elements you want to store");
		int size=Utility.retInt();
		Integer[] array=new Integer[size];
		System.out.println("enter the elements");
		for(int i=0;i<size;i++)
		{
			array[i]=Utility.retInt();
		}
		System.out.println("given array:");
		Utility.print1DArrayElements(array);
		//MergeSort object=new MergeSort();
		sort(array, 0, array.length-1);
		System.out.println("sorted array:");
		Utility.print1DArrayElements(array);
		
	}

}
