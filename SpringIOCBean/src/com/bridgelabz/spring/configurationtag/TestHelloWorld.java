package com.bridgelabz.spring.configurationtag;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestHelloWorld {

	public static void main(String[] args) {
		ApplicationContext applicationContext=new AnnotationConfigApplicationContext(HelloWorldConfig.class);	
		HelloWorl helloWorld=applicationContext.getBean(HelloWorl.class);
		helloWorld.setMessege("SIMRAN");
		System.out.println(helloWorld.toString());
		
	}

}
