package com.bridgelabz.basics;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class StudentWithAddressClient {
public static void main(String[] args) {
	Resource resource=new ClassPathResource("StudentWithAddressXml.xml");
	BeanFactory factory=new XmlBeanFactory(resource);
	StudentWithAddress sa=factory.getBean("stuWadd",StudentWithAddress.class);
	System.out.println(sa);
}
}
