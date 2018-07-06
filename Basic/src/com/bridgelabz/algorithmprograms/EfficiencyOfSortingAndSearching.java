/**
 * ...
 */
package com.bridgelabz.algorithmprograms;

import java.util.HashSet;
import java.util.Set;

import com.bridgelabz.utility.Utility;

public class EfficiencyOfSortingAndSearching
{
	
	 static long START;
	 static long STOP;
	 static double ELAPSE_TIME;
	 public static void main(String[] args) 
	 {
		 	Set<Double> elapsedTimes=new HashSet<Double>();
	        System.out.println("Enter size of array:");
	        int size=Utility.retInt();
	        System.out.println("What type of elements you want to insert : \n 1. Integer \t 2.String");
	        System.out.println("Press 1 for Integer \nPress 2 for String");
	        int input = Utility.retInt();
	        switch (input) 
	        {
	        case 1:
	            System.out.println("Enter Integer Elements: ");
	            Integer[] array = new Integer[size];
	            for (int i = 0; i < size; i++) 
	            {
	                array[i] = Utility.retInt();
	            }
	            System.out.println("*****Bubble sort****");
	            START =System.nanoTime();
	            Utility.bubbleSort(array);
	            System.out.println("sorted array is ");
	            Utility.print1DArrayElements(array);
	            STOP =System.nanoTime();
	            ELAPSE_TIME=(STOP-START)/Math.pow(10, 9);
	            elapsedTimes.add(ELAPSE_TIME);
	            System.out.println("Elapse time for bubble sort = "+ELAPSE_TIME+" s \n");
	            System.out.println("*****Insertion sort****");
	            START =System.nanoTime();
	            Utility.insertionSort(array);
	            System.out.println("sorted array is ");
	            Utility.print1DArrayElements(array);
	            STOP =System.nanoTime();
	            ELAPSE_TIME=(STOP-START)/Math.pow(10, 9);
	            elapsedTimes.add(ELAPSE_TIME);
	            System.out.println("Elapse time for Insertion sort = "+ELAPSE_TIME+" s\n");
	            System.out.println("*****Binary search****");
	            System.out.println("Enter Search element");
	            int searchWord=Utility.retInt();
	            START =System.nanoTime();
	            System.out.println("searching element present at "+Utility.intBinarySearch(array, searchWord)+" index");
	            STOP =System.nanoTime();
	            ELAPSE_TIME=(STOP-START)/Math.pow(10, 9);
	            elapsedTimes.add(ELAPSE_TIME);
	            System.out.println("Elapse time for Binary search  = "+ELAPSE_TIME+" s\n");
	            System.out.println("elapsed times are ");
	            System.out.println(elapsedTimes);
	            break;
	        case 2:
	            System.out.println("Enter Strings: ");
	            String[] array1 = new String[size];
	            for (int i = 0; i < size; i++) {
	                array1[i] = Utility.retNext();
	            }
	            System.out.println("*****Bubble sort****");
	            START =System.nanoTime();
	            Utility.bubbleSort(array1);
	            System.out.println("sorted array is ");
	            Utility.print1DArrayElements(array1);
	            STOP =System.nanoTime();
	            ELAPSE_TIME=(STOP-START)/Math.pow(10, 9);
	            elapsedTimes.add(ELAPSE_TIME);
	            System.out.println("Elapse time for bubble sort = "+ELAPSE_TIME+" s \n");
	            System.out.println("*****Insertion sort****");
	            START =System.nanoTime();
	            Utility.insertionSort(array1);
	            System.out.println("sorted array is ");
	            Utility.print1DArrayElements(array1);
	            STOP =System.nanoTime();
	            ELAPSE_TIME=(STOP-START)/Math.pow(10, 9);
	            elapsedTimes.add(ELAPSE_TIME);
	            System.out.println("Elapse time for Insertion sort = "+ELAPSE_TIME+" s\n");
	            System.out.println("*****Binary search****");
	            System.out.println("Enter Search word");
	            String searchWord1=Utility.retNext();
	            START =System.nanoTime();
	            System.out.println(Utility.stringBinarySearch(array1, searchWord1));
	            STOP =System.nanoTime();
	            ELAPSE_TIME=(STOP-START)/Math.pow(10, 9);
	            elapsedTimes.add(ELAPSE_TIME);
	            System.out.println("Elapse time for Binary search  = "+ELAPSE_TIME+" s\n");
	            System.out.println("elapsed time in descending order is ");
	            System.out.println(elapsedTimes);
	            break;
	        default:
	            System.out.println("invalid option selected!!!");
	        }
	    }
	
}
