/**
 * purpose:Stack class
 * @author: Bijaya Laxmi Senapati
 * @since:26/05/2018
 * @version:1.0
 */
package com.bridgelabz.datastructureprograms;

public class MyStack<T>
{
	MyLinkedList<T> mylinkedlist=new MyLinkedList<>();
	
	/**
	 * creates a new empty stack
	 */
	public MyStack()
	{
			
	}
	/**
	 * @param element a new item which will be added to the top of the stack
	 */
	public void push(T element)
	{
		mylinkedlist.add(element);
	}
	/**
	 * @return returns the top item from the stack which is deleted
	 */
	public T pop()
	{
		/*if(mylinkedlist.isEmpty())
		{
			System.out.println("MyStack is already empty");
		}*/
		int index=mylinkedlist.size()-1;
		T elementToBeDeleted=mylinkedlist.get(index);
		mylinkedlist.remove(index);
		return elementToBeDeleted;
	}
	/**
	 * @return returns the top item from the stack without deleting it.
	 */
	public T peek()
	{
		return mylinkedlist.get(mylinkedlist.size()-1);
	}
	/**
	 * @return returns true if the stack is empty else false
	 */
	public boolean isEmpty()
	{ 	
		return mylinkedlist.size()==0;
	}
	/**
	 * @return returns size of the stack
	 */
	public int size()
	{
		return mylinkedlist.size();
	}
	/**
	 * prints elements present in the stack
	 */
	public void display()
	{
		for(int i=mylinkedlist.size()-1;i>=0;i--)
		{
			System.out.println(mylinkedlist.get(i));
		}
	}
}
