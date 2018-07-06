/**
 * ..
 */
package com.bridgelabz.datastructureprograms;

public class MyQueue<T>
{
	MyLinkedList<T> mylinkedlist=new MyLinkedList<>();
	/**
	 * creates a new queue that is empty
	 */
	public MyQueue()
	{
		
	}
	/**
	 * @param element the element which will be added to the rear of the queue
	 */
	public void enqueue(T element)
	{
		mylinkedlist.add(element);
	}
	/**
	 * @return returns the deleted item which was in the front of the queue
	 */
	public T dequeue()
	{
		if(mylinkedlist.isEmpty())
		{
			System.out.println("Queue is already empty");
		}
		T elementToBeDeleted=mylinkedlist.get(0);
		mylinkedlist.remove(0);
		return elementToBeDeleted;
	}
	
	/**
	 * @return returns true if the queue is empty else false
	 */
	public boolean isEmpty()
	{
		return mylinkedlist.size()==0;
	}
	/**
	 * @return returns size of the queue
	 */
	public int size()
	{
		return mylinkedlist.size();
	}
	/**
	 * prints all the elements present in the queue
	 */
	public void display()
	{
		mylinkedlist.display();
	}
	/**
	 * @param searchElement the element which will be searched from the queue
	 * @return returns true if the searching element is present else returns false
	 */
	public boolean search(T searchElement)
	{
		
		return mylinkedlist.search(searchElement);
	}
}
