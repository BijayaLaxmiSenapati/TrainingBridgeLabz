package com.bridgelabz.spring.configurationtag;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test 
{
	public static void main(String[] args) {
		ApplicationContext application = new AnnotationConfigApplicationContext(A.class);
		B b = application.getBean(B.class);
		b.setName("Bijayalaxmi");
		System.out.println(b.toString());
	}

}
