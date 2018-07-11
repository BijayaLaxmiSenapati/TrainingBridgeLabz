package com.bridgelabz.reflection;

import com.bridgelabz.reflection.ReflectionInterface;

public class ReflectionServiceImplentation implements ReflectionInterface{

	private int number1 = 20;
	private int number2 = 50;
	private String message =null;
	@Override
	public void add() {
		int result=number1+number2;
		System.out.println("sum of two numbers"+result);
	}
	//constructor
	public ReflectionServiceImplentation(String message) {
		
		this.message = message;
	}
//getter method
	public String getPrivate() {
		return "get private id using getter";
	}
	//constuctor with 2 arguments
	public ReflectionServiceImplentation(int number,String msg) {
	 	System.out.println("you entered  "+number+" "+msg);
}
}
