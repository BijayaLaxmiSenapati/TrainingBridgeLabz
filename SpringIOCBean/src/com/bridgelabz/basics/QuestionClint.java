package com.bridgelabz.basics;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class QuestionClint {

	public static void main(String[] args) {
		Resource resource=new ClassPathResource("QuestionXml.xml");
		BeanFactory factory=new XmlBeanFactory(resource);
		Question q=factory.getBean("que",Question.class);
		System.out.println(q);
	}

}
