package com.bridgelabz.spring.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bridgelabz.spring.service.AutoWiredByType;
import com.bridgelabz.spring.service.AutowiredByConstructor;
import com.bridgelabz.spring.service.EmployeeService;

public class SpringMain
{
	public static void main(String[] args)
	{
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
		/*EmployeeService employeeService=context.getBean("employeeServiceByName",EmployeeService.class);
		System.out.println(employeeService.getEmployee().getName());*/
		EmployeeService serviceByName = context.getBean("employeeServiceByName", EmployeeService.class);
		
		System.out.println("Autowiring byName. Employee Name="+serviceByName.getEmployee().getName());
		
		EmployeeService serviceByType = context.getBean("employeeServiceByType", EmployeeService.class);
		
		System.out.println("Autowiring byType. Employee Name="+serviceByType.getEmployee().getName());
		
		EmployeeService serviceByConstructor = context.getBean("employeeServiceByConstructor", EmployeeService.class);
		
		System.out.println("Autowiring by Constructor. Employee Name="+serviceByConstructor.getEmployee().getName());
		
		AutoWiredByType autowiredByType=context.getBean("autoWiredByType",AutoWiredByType.class);

		System.out.println("@Autowired byType. Employee Name="+autowiredByType.getEmployee().getName());

		AutowiredByConstructor autowiredByConstructor=context.getBean("autowiredByConstructor",AutowiredByConstructor.class);
		
		System.out.println("@Autowired byType. Employee Name="+autowiredByConstructor.getEmployee().getName());
	}
}
