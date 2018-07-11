package com.bridgelabz.basics;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Client {

	public static void main(String[] args) {
		/*Employee eRef=new Employee();
		eRef.setEid(101);
		eRef.setEname("Bijaya Laxmi");
		eRef.setAddress("Berhampur");
		System.out.println("Employee Details"+eRef);*/
		
		
		//Spring way(using Inversion of Control)
		Resource resource=new ClassPathResource("FirstXml.xml");
		BeanFactory factory=new XmlBeanFactory(resource);
		System.out.println("111111111111111111111111111111");
		Employee e1=factory.getBean("emp",Employee.class);
		System.out.println(e1);
		System.out.println("22222222222222222222222222222222");
		Employee e4=factory.getBean("emp1",Employee.class);
		System.out.println(e4);
		
		System.out.println("*************************");
		ApplicationContext context=new ClassPathXmlApplicationContext("FirstXml.xml");
		System.out.println("afterrrrrrrrrrrrrrrrrrrrrrrrrr");
		Employee e3=context.getBean("emp", Employee.class);
		System.out.println(e3);
		
		Employee e5=context.getBean("emp1",Employee.class);
		System.out.println(e5);
	}

}
