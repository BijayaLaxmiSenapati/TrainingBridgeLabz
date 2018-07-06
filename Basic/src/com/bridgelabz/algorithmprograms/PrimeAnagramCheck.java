/**
 * purpose: prints all the pair of prime numbers which are anagram.
 * @author:Bijaya Laxmi Senapati
 * @since:24/05/2018
 * @version:1.0
 */
package com.bridgelabz.algorithmprograms;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.bridgelabz.utility.Utility;

public class PrimeAnagramCheck {

	public static void main(String[] args)
	{
		List<Integer> list=new ArrayList<>();
		Set<Integer> distinctElement=new TreeSet<Integer>();
		for(int i=0;i<=1000;i++)
		{
			if(Utility.isPrime(i))
			{
				list.add(i);
			}
		}
		
		
		for(int i=0;i<list.size()-1;i++)
		{
			for(int j=i+1;j<list.size();j++)
			{
				if(Utility.numAnagramCheck(list.get(i),list.get(j)))
				{
					distinctElement.add(list.get(i));
					distinctElement.add(list.get(j));
				}
			}
		}
		System.out.println(distinctElement);

	}

}
