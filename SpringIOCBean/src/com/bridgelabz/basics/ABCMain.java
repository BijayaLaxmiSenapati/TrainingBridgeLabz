package com.bridgelabz.basics;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class ABCMain {
public static void main(String[] args) {
	Resource resource=new ClassPathResource("ABCXml.xml");
	BeanFactory factory=new XmlBeanFactory(resource);
	B b=factory.getBean("b1", B.class);
	System.out.println(b);
}
}
