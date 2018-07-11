package com.bridgelabz.spring.service;

import com.bridgelabz.spring.model.Employee;

public class EmployeeService 
{
	private Employee employee;
	public EmployeeService(Employee emp) {
		System.out.println("Autowiring by constructor used");
		this.employee = emp;
	}
	public EmployeeService() {
		System.out.println("Default Constructor used");
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}
