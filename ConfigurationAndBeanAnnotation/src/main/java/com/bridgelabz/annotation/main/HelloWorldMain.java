package com.bridgelabz.annotation.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bridgelabz.annotation.config.HelloWorldConfig;
import com.bridgelabz.annotation.model.HelloWorld;

public class HelloWorldMain {

	public static void main(String[] args) 
	{
		ApplicationContext ctx = new AnnotationConfigApplicationContext(HelloWorldConfig.class);
		HelloWorld helloWorld = ctx.getBean(HelloWorld.class);
		helloWorld.setMessage("Hello Bijaya....");
		helloWorld.getMessage();
	}

}
