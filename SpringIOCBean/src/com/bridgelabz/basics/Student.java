package com.bridgelabz.basics;

public class Student {
	int sid;
	String sname;
	public Student() {
		System.out.println("Student()");
	}
	public Student(int sid) {
		super();
		System.out.println("Student(int sid)");
		this.sid = sid;
	}
	public Student(String sname) {
		super();
		System.out.println("Student(String sname)");
		this.sname = sname;
	}
	public Student(int sid, String sname) {
		super();
		System.out.println(" Student(int sid, String sname)");
		this.sid = sid;
		this.sname = sname;
	}
	public int getSid() {
		System.out.println("getSid()");
		return sid;
	}
	public void setSid(int sid) {
		System.out.println("setSid(int sid)");
		this.sid = sid;
	}
	public String getSname() {
		System.out.println("getSname()");
		return sname;
	}
	public void setSname(String sname) {
		System.out.println("setSname(String sname)");
		this.sname = sname;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + "]";
	}
	
	
	
}
