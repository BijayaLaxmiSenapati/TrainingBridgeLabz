package com.bridgelabz.loginandregistrationusingspringboot.models;

public class Trainee 
{
	private int serialNum;
	private String fullName;
	private long mobile;
	private String email;
	private String password;

	public int getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(int serialNum) {
		this.serialNum = serialNum;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Trainee [serialNum=" + serialNum + ", fullName=" + fullName + ", mobile=" + mobile + ", email=" + email
				+ ", password=" + password + "]";
	}


	

}
