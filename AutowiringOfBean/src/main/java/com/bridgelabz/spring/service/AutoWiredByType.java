package com.bridgelabz.spring.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.bridgelabz.spring.model.Employee;

public class AutoWiredByType 
{
	@Autowired
	private Employee employee;
	@Autowired
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
}
