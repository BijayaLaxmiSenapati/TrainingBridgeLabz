package com.bridgelabz.basics;

public class Employee {
	
	//Attributes
	int eid;
	String ename;
	String eaddress;
	
	
	//Methods
	public Employee()
	{
		System.out.println("Constructor");
	}

	public Employee(int eid, String ename, String eaddress) {
		super();
		System.out.println("parameter constructor");
		this.eid = eid;
		this.ename = ename;
		this.eaddress = eaddress;
	}

	public int getEid() {
		System.out.println("getEid");
		return eid;
	}

	public void setEid(int eid) {
		System.out.println("setEid");

		this.eid = eid;
	}

	public String getEname() {
		System.out.println("getEname");

		return ename;
	}

	public void setEname(String ename) {
		System.out.println("setEname");

		this.ename = ename;
	}

	public String getEaddress() {
		System.out.println("getEaddress");

		return eaddress;
	}

	public void setEaddress(String eaddress) {
		System.out.println("setEaddress");

		this.eaddress = eaddress;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", address=" + eaddress + "]";
	}
	
}
