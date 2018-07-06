/**
 * ..
 */
package com.bridgelabz.datastructureprograms;

public class Node<T>
{
	T element;
	Node<T> next;
	Node(T element)
	{
		this.element=element;
	}
	Node(T element,Node<T> next)
	{
		this.element=element;
		this.next=next;
	}
}
