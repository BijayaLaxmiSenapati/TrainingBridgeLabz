/**
 * ..
 */
package com.bridgelabz.algorithmprograms;

public class MaxOfThree {

	public static void main(String[] args)
	{
		Integer[] array={5,3,7,2,6,8};
		UtilityForSearchingAndSorting.bubbleSort(array);
		for(int i=0;i<array.length;i++)
		{
			System.out.print(array[i]+" ");
		}
		/*System.out.println("enter how many elements you want to store in the array (for bubble sort)");
		int size3=Utility.retInt();
		[] array3=new int[size3];
		System.out.println("enter elements of the array(for bubble sort)");
		for(int i:array3)
		{
			array3[i]=Utility.retInt();
		}
		array3=UtilityForSearchingAndSorting.bubbleSort(array3);
		for(int i:array3)
		{
			System.out.print(array3[i]+" ");
		}*/
	}

}
