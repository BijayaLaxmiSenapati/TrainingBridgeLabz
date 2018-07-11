package com.bridgelabz.basics;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorldClient {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("HelloWorldXml.xml");
		HelloWorld helloworld=context.getBean("hw1",HelloWorld.class);
		//System.out.println(helloworld.getMessege());
		helloworld.setMessege("BHAD ME JAOO!!!");
		System.out.println(helloworld.getMessege());
		//System.out.println(helloworld.getMessage());
		
		HelloWorld helloworld1=context.getBean("hw1",HelloWorld.class);
		System.out.println(helloworld1.getMessege());
		//System.out.println(helloworld.hashCode());

	}

}
