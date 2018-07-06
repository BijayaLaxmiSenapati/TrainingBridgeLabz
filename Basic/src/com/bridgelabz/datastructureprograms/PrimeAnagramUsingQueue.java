/**
 * adds the prime anagram numbers in the range 0-1000 and print the numbers in the queue
 * @author: Bijaya Laxmi Senapati
 * @since:28/05/2018
 * @version:1.0
 */
package com.bridgelabz.datastructureprograms;

import com.bridgelabz.utility.Utility;

public class PrimeAnagramUsingQueue 
{

	public static void main(String[] args) 
	{
		MyLinkedList<Integer> mylinkedlist=new MyLinkedList<Integer>();
		MyQueue<Integer> myqueue=new MyQueue<Integer>();
		for(int i=0;i<=1000;i++)
		{
			if(Utility.isPrime(i))
			{
				mylinkedlist.add(i);
			}
		}
	
		for(int i=0;i<mylinkedlist.size()-1;i++)
		{
			for(int j=i+1;j<mylinkedlist.size();j++)
			{
				if(Utility.numAnagramCheck(mylinkedlist.get(i),mylinkedlist.get(j)))
				{
					if(myqueue.search(mylinkedlist.get(i))==false)
					{
						myqueue.enqueue(mylinkedlist.get(i));
					}
					if(myqueue.search(mylinkedlist.get(j))==false)
					{
						myqueue.enqueue(mylinkedlist.get(j));
					}
				}
			}
		}
		myqueue.display();
		
	}

}
