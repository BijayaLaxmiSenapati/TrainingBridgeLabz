package com.bridgelabz.basics;

public class StudentWithAddress {
		int sid;
		String sname;
		Address saddress;
		public StudentWithAddress() {
			System.out.println("In student with address");
		}
		public StudentWithAddress(int sid, String sname, Address saddress) {
			super();
			this.sid = sid;
			this.sname = sname;
			this.saddress = saddress;
		}
		public int getSid() {
			return sid;
		}
		public void setSid(int sid) {
			this.sid = sid;
		}
		public String getSname() {
			return sname;
		}
		public void setSname(String sname) {
			this.sname = sname;
		}
		public Address getSaddress() {
			return saddress;
		}
		public void setSaddress(Address saddress) {
			this.saddress = saddress;
		}
		@Override
		public String toString() {
			return "StudentWithAddress [sid=" + sid + ", sname=" + sname + ", saddress=" + saddress + "]";
		}

}
