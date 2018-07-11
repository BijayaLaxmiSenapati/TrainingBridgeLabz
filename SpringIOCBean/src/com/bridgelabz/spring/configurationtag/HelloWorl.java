package com.bridgelabz.spring.configurationtag;

public class HelloWorl {
public String messege;

public String getMessege() {
	return messege;
}

public void setMessege(String messege) {
	this.messege = messege;
}

@Override
public String toString() {
	return "HelloWorl [messege=" + messege + "]";
}

}
