package com.bridgelabz.basics;

public class B {
C c1;
C c2;
/*public B() {
	System.out.println("B()");
}
public B(C c1) {
	System.out.println("B(C c1)");
	this.c1=c1;
}*/
public B(C c1, C c2) {
	System.out.println("B" +c1);
	System.out.println("B" +c2);

	this.c1=c1;
	this.c2=c2;
}
/*public C getC2() {
	System.out.println("getC2()");
	return c2;
}
public void setC2(C c2) {
	System.out.println("setC2(C c2)");
	this.c2 = c2;
}
public C getC1() {
	System.out.println("getC1()");
	return c1;
}
public void setC1(C c1) {
	System.out.println("setC1(C c1)");
	this.c1 = c1;
}*/
@Override
public String toString() {
	return "B [c1=" + c1 + ", c2=" + c2 + "]";
}

}
