/**
 * purpose:Deque class
 */
package com.bridgelabz.datastructureprograms;

public class MyDeque<T>
{
	MyLinkedList<T> mylinkedlist=new MyLinkedList<>();
	/**
	 * creates a new deque that is empty
	 */
	public MyDeque()
	{
		
	}
	/**
	 * @param element the element which will be added to the front of the deque
	 */
	public void addFront(T element)
	{
		if(mylinkedlist.size()==0)
		{
			mylinkedlist.add(element);
		}
		else
			mylinkedlist.insert(0, element);
	}
	/**
	 * @param element the element which will be added to the rear of the deque
	 */
	public void addRear(T element)
	{
		if(mylinkedlist.size()==0)
		{
			mylinkedlist.add(element);
		}
		else
		{
			int index=mylinkedlist.size()-1;
			mylinkedlist.insert(index, element);
		}
	}
	/**
	 * @return returns the element which was at the front of the deque
	 */
	public T removeFront()
	{
		T element=null;
		if(mylinkedlist.isEmpty())
		{
			System.out.println("MyDeque is already empty");
		}
		else
		{
			element=mylinkedlist.get(0);
			mylinkedlist.remove(0);
			//return element;
		}
		return element;
	}
	/**
	 * @return returns the element which was at the rear of the deque
	 */
	public T removeRear()
	{
		T element=null;
		if(mylinkedlist.isEmpty())
		{
			System.out.println("MyDeque is already empty");
		}
		else
		{
			int index=mylinkedlist.size()-1;
			element=mylinkedlist.get(index);
			mylinkedlist.remove(index);
			//return element;
		}
		return element;
	}
	/**
	 * @return returns true if the deque is empty else returns false
	 */
	public boolean isEmpty()
	{
		return mylinkedlist.isEmpty();
	}
	/**
	 * @return returns size of the deque
	 */
	public int size()
	{
		return mylinkedlist.size();
	}
	/**
	 * prints all the elements of the deque
	 */
	public void display()
	{
		mylinkedlist.display();
	}
}
