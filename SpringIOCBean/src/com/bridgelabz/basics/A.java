package com.bridgelabz.basics;

public class A {
	B b1;
	public A() {
		System.out.println("A()");
	}
	public B getB1() {
		System.out.println("getB1()");
		return b1;
	}
	public void setB1(B b1) {
		System.out.println("setB1(B b1)");
		this.b1 = b1;
	}
	@Override
	public String toString() {
		return "A [b1=" + b1 + "]";
	}
	
	
}
