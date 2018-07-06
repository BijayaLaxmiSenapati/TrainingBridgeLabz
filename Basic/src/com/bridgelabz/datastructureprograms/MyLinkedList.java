/**
 * ..
 */
package com.bridgelabz.datastructureprograms;

public class MyLinkedList<T>
{
	private Node<T> first;
	private Node<T> last;
	private int count=0;
	/**
	 * default constructor to create object of MyLinkedList class
	 */
	public MyLinkedList()
	{
		
	}
	/**
	 * @param element element which will be added to the linked list
	 */
	public void add(T element)
	{
		if(first==null)
		{
			first=new Node<T>(element);
			last=first;
			count++;
			return;
		}
		last.next=new Node<T>(element);
		last=last.next;
		count++;
		return;
	}
	
	
	/**
	 * @return integer ,the size of the linked list
	 */
	public int size()
	{
		return count;
	}
	
	/**
	 * @return returns true if the linked list is empty and false if not.
	 */
	public boolean isEmpty()
	{
		return(count==0);
		
	}
	
	
	
	/**
	 * @param index the index where the given element will be inserted
	 * @param element the element to be inserted
	 */
	public void insert(int index, T element)
	{
		if(index>=size())
		{
			throw new IndexOutOfBoundsException();
		}
		if(index==0)
		{
			first=new Node<T>(element,first);
			count++;
			return;
		}
		Node<T> temp=first;
		for(int i=1;i<index;i++)
		{
			temp=temp.next;
		}
		temp.next=new Node<T>(element,temp.next);
		count++;
	}
	
	
	/**
	 * display the elements of the linked list
	 */
	public void display()
	{
		Node<T> temp=first;
		//System.out.print("[");
		for(int i=0;i<size();i++)
		{
			System.out.print(temp.element+" ");
			temp=temp.next;
		}
		//System.out.print("]");
	}
	
	/**
	 * @param index the index from which the index element will be returned
	 * @return returns the element at the given index
	 */
	public T get(int index)
	{
		if(index>=size())
		{
			throw new IndexOutOfBoundsException();
		}
		Node<T> temp=first;
		for(int i=0;i<index;i++)
		{
			temp=temp.next;
		}
		return temp.element;
	}
	
	
	/**
	 * @param searchElement the element to be searched from the linked list
	 * @return returns true if the linked list is empty and false if not
	 */
	public boolean search(T searchElement)
	{
		Node<T> temp=first;
		for(int i=0;i<size();i++)
		{
			if(temp.element.equals(searchElement))
			{
				return true;
			}
			temp=temp.next;
		}
		return false;
	}
	
	
	/**
	 * @param element the element whose position/index in the linked list is required
	 * @return returns the index of the given element
	 */
	public int index(T element)
	{
		Node<T> temp=first;
		for(int i=0;i<size();i++)
		{
			if(temp.element.equals(element))
			{
				return i;
			}
			temp=temp.next;
		}
		return -1;
	}
	
	/**
	 * @param element the element which will be removed from the linked list
	 */
	public void remove(T element)
	{
		Node<T> temp=first;
		Node<T> previous=null;
		if(first.element==element)
		{
			first=first.next;
			count--;
			return;
		}
		while(temp.next!=null)
		{
			if(temp.element==element)
			{
				previous.next=temp.next;
				count--;
				return;
			}
			previous=temp;
			temp=temp.next;
		}
		if(temp.next==null)
		{
			previous.next=null;
			count--;
		}
	}
	
	/**
	 * @param index the position/index in the linked list which node will be deleted
	 */
	public void remove(int index)
	{
		
		if(index>=size())
		{
			throw new IndexOutOfBoundsException();
		}
		if(index==0)
		{
			first=first.next;
			count--;
			return;
		}
		Node<T> temp = first;
		for(int i=0;i<index-1;i++)
		{
			temp=temp.next;
		}
		temp.next=temp.next.next;
		count--;
	}
	
	
	/**
	 * @return removes and returns last element of the linked list
	 */
	public T pop()
	{
		Node<T> temp=first;
		Node<T> previous=null;
		while(temp.next!=null)
		{
			previous=temp;
			temp=temp.next;
		}
		T lastElement=temp.element;
		previous.next=null;
		count--;
		return lastElement;
		
	}
	
	
	/**
	 * @param index the index whose element will be deleted and and will be returned
	 * @return returns the element which is deleted from the specified index
	 */
	public T pop(int index)
	{
		if(index>=size())
		{
			throw new IndexOutOfBoundsException();
		}
		if(index==0)
		{
			T firstElement=first.element;
			first=first.next;
			count--;
			return firstElement;
		}
		Node<T> temp = first;
		for(int i=0;i<index-1;i++)
		{
			temp=temp.next;
		}
		T elementAtIndex=temp.next.element;
		temp.next=temp.next.next;
		count--;
		return elementAtIndex;
	}
	
	
}
