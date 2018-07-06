/**
 * 
 */
package com.bridgelabz.algorithmprograms;

import com.bridgelabz.utility.Utility;

public class MergeSort1 {

	public static void main(String[] args) 
	{
		  System.out.println("Enter how many elements you want to sort");
	        int input=Utility.retInt();
	        System.out.println("Enter elements");
	        String [] array=new String[input];
	        for(int i=0;i<input;i++)
	        {
	            array[i]=Utility.retNext();
	        }
	        Utility.mergeSort(array,0,array.length-1);
	        //printing sorted array
	        for(int i=0;i<array.length;i++)
	        {
	            System.out.println(array[i]);
	        }

	}
	
	
    public static void sort(String[] array, int low, int high) 
    {
        int mid;
        if (low < high) {
            mid = (low + high) / 2;
            sort(array, low, mid);
            sort(array, mid + 1, high);
            merge(array, low, mid, high);
        }
    }
    /**This function merge the array after comparing the strings
     */
    public static void merge(String array[], int low, int mid, int high) 
    {
        int i;
        int mid1;
        int k = 0;
        int low1;
        //int lengthOfFirstSlave=mid-low+1;
        //int lengthOfSecondSlave=high-mid;
        String[] temp = new String[50];
        low1 = low;
        i = low;
        mid1 = mid + 1;
        while ((low1 <= mid) && (mid1 <= high)) 
        {
            if (array[low1].compareToIgnoreCase(array[mid1]) <= 0) 
            {
                temp[i] = array[low1];
                low1++;
            } else 
            {
                temp[i] = array[mid1];
                mid1++;
            }
            i++;
        }
        if (low1 > mid) 
        {
            for (k = mid1; k <= high; k++) 
            {
                temp[i] = array[k];
                i++;
            }
        } 
        else 
        {
            for (k = low1; k <= mid; k++) 
            {
                temp[i] = array[k];
                i++;
            }
        }
        for (k = low; k <= high; k++) 
        {
            array[k] = temp[k];
        }
    }

}
