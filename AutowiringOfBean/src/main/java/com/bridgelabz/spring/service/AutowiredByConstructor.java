package com.bridgelabz.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.bridgelabz.spring.model.Employee;

public class AutowiredByConstructor
{
	private Employee employee;
	
	
	@Autowired(required=false)
	public AutowiredByConstructor(@Qualifier("employee") Employee employee) {
		super();
		this.employee = employee;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
}
