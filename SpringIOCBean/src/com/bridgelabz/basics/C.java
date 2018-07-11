package com.bridgelabz.basics;

public class C {
	int num1;
	int num2;
	//String name;
	public C() {
		System.out.println("C()");
	}
	public C(int num1) {
		System.out.println("C(int num1)");
		this.num1=num1;
	}
	public C(int num1,int num2) {
		System.out.println("C"+num1 +"" +num2);
		this.num1=num1;
		this.num2=num2;

	}
	/*public C(int num2, String name)
	{
		System.out.println("C(int num2, String name)");
	}
	public C(int num1,int num2,String name) {
		System.out.println("C(int num1,int num2,String name)");
	}*/
	@Override
	public String toString() {
		return "C [num1=" + num1 + ", num2=" + num2 + "]";
	}
}
