package com.bridgelabz.basics;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class StudentClient {
	public static void main(String[] args) {
		Resource resource=new ClassPathResource("StudentXml.xml");
		BeanFactory factory=new XmlBeanFactory(resource);
		Student s=(Student) factory.getBean("stu");
		System.out.println(s);
		Student s1=(Student) factory.getBean("stu1");
		System.out.println(s);
		Student s2=(Student) factory.getBean("stu2");
		System.out.println(s);
	}
}
