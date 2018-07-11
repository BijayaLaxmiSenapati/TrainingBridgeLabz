package com.bridgelabz.spring.service;

public class Operation 
{
	public void msg() {
		System.out.println("In method msg()");	
	}
	public int m() {
		System.out.println("In method m()");
		return 2;
	}
	public int k() {
		System.out.println("In method k()");
		return 3;
	}
	public void validate(int age) throws Exception {
		if(age<18) {
			throw new ArithmeticException("Not Valid age");
		}
		else {
			System.out.println("Thanks for vote");
		}
			
	}
}
