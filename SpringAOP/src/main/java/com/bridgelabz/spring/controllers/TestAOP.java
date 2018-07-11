package com.bridgelabz.spring.controllers;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bridgelabz.spring.service.Operation;

public class TestAOP {

	public static void main(String[] args) throws Exception 
	{
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("SpringAop.xml");
		Operation op=(Operation) context.getBean("opBean");
		System.out.println("calling m...");  
	    System.out.println(op.m());  
	    System.out.println("calling k...");  
	    System.out.println(op.k());  
	    
	    System.out.println("calling validate...with correct input value");
		op.validate(21);
	    System.out.println();
	    System.out.println("calling validate...with wrong input value");
		op.validate(17);

	}

}
